//移动资源的事件
ronyao.gis.ctlDrag.onComplete = function(feature, pixel) {
	// 高亮位置改变
	ronyao.gis.layerLight.destroyFeatures();
	ronyao.gis.layerLight.addFeatures(feature.clone());

	// 用于更新的数据
	var gis_data = {
		id : feature.fid,
		data : ronyao.gis.getGeoData(feature)
	};
	controller.gisEditor.updateFeature(gis_data);
}

//保存被选中的资源feature
var selectedFeature;

// 选择设备的事件
ronyao.gis.onSelected = function(event) {
	selectedFeature = event.feature;
	// 高亮被选择的资源
	ronyao.gis.layerLight.destroyFeatures();
	ronyao.gis.highLight(event.feature.attributes.resid);

	// 准备数据
	var resid = event.feature.attributes.resid;
	var type = event.feature.attributes.type;

	// 监控界面下实时视频播放的回调
	if (controller.gisVideo) {
		controller.gisVideo.onResourceSelect(resid, type);
	}

	// 监控界面下，设备控制的回调
	if (controller.control) {
		var rst = controller.control.needPop(resid, type);
		if (rst.popup) {
			var feature = event.feature;
			var popup = new OpenLayers.Popup.FramedCloud("chicken", feature.geometry.getBounds().getCenterLonLat(), new OpenLayers.Size(100, 100),
					"<div id='gisPopupDiv' style='width:" + rst.width + "px;height:" + rst.height + "px;'></div>", null, false);
			feature.popup = popup;
			ronyao.gis.map.addPopup(popup, true);
			// 调用控制器事件
			controller.control.onPopupShow(popup.div.querySelector("#gisPopupDiv").id, resid, type);
		}
	}

}

// 没有选择，清除选择
ronyao.gis.onUnSelected = function(event) {
	var feature = event.feature;
	
	if (feature.popup) {
		// 调用控制器事件
		if (controller.control) {
			controller.control.onPopupClose(feature.popup.div);
		}
		// Gis删除popup
		ronyao.gis.map.removePopup(feature.popup.div.querySelector("#chicken_contentDiv"));
		feature.popup.destroy();
		delete feature.popup;
	}
};

// 当添加一个GIS的时候
ronyao.gis.featureAdded = function(event) {
	// 更新该元素的其他值

	// 保存数据库
	var gis_data = {
		id : null,
		resid : controller.gisEditor.resid,
		layer : ronyao.gis.map.baseLayer.layerId,
		type : ronyao.gis.getGeoType(event.feature),
		style : controller.gisEditor.type,
		data : ronyao.gis.getGeoData(event.feature)
	};

	// event.feature.attributes.id = '';
	event.feature.attributes.layer = ronyao.gis.map.baseLayer.layerId;
	event.feature.attributes.resid = controller.gisEditor.resid;
	event.feature.attributes.style = controller.gisEditor.type;
	event.feature.attributes.type = gis_data.type;

	controller.gisEditor.saveFeature(gis_data);
}

ronyao.gis.changLayer = function(events){
	//关闭弹出框
	var popDiv = Ext.getElementById('gisPopupDiv');
	if(popDiv) {
		selectedFeature.popup.destroy();
	}
	
	ronyao.gis.layerLight.destroyFeatures();
	var layerId = ronyao.gis.map.baseLayer.layerId;
	ronyao.gis.layerRes.protocol.params.layer = layerId
	ronyao.gis.layerRes.refresh();
	if(controller.gisEditor && ronyao.gis.useResId == -1){
		controller.gisEditor.loadGisResByLayerId(layerId);
	}
	
	ronyao.gis.map.zoomToMaxExtent();
}
// 注册事件

// 资源被选择时的事件
ronyao.gis.layerRes.events.register('featureselected', ronyao.gis.layerRes, ronyao.gis.onSelected);
ronyao.gis.layerRes.events.register('featureunselected', ronyao.gis.layerRes, ronyao.gis.onUnSelected);

// 资源被添加的事件
ronyao.gis.layerRes.events.register('sketchcomplete', ronyao.gis.layerRes, ronyao.gis.featureAdded);

//当地图的基本图层发生改变时触发
ronyao.gis.map.events.register('changebaselayer', ronyao.gis.map, ronyao.gis.changLayer); 

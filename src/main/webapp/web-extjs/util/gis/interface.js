// 高亮资源所对应的GIS元素
ronyao.gis.highLight = function(resid) {

	
	ronyao.gis.layerLight.destroyFeatures();

	var resFeatures = ronyao.gis.layerRes.getFeaturesByAttribute('resid', resid);

	for ( var i = 0; i < resFeatures.length; i++) {
		ronyao.gis.layerLight.addFeatures(resFeatures[i].clone());
	}
}

ronyao.gis.highLightById = function(id) {
	ronyao.gis.layerLight.destroyFeatures();
	var resFeature = ronyao.gis.layerRes.getFeatureByFid(id);
	ronyao.gis.layerLight.addFeatures(resFeature.clone());
	// 放大图层
	ronyao.gis.map.zoomToExtent(resFeature.geometry.bounds, false);
}

ronyao.gis.useResId=-1;
ronyao.gis.currentResId = null;

ronyao.gis.highLightByIdAndLayer = function(id,layerId) {
	ronyao.gis.layerLight.destroyFeatures();
	ronyao.gis.currentResId = id;
	ronyao.gis.layerRes.protocol.params.layer = layerId;
	ronyao.gis.layerRes.refresh();
	ronyao.gis.layerRes.protocol.read();
	ronyao.gis.map.zoomToMaxExtent();
}


// 在一个HTML的节点中初始化GIS
ronyao.gis.initGis = function(dom) {
	if (!controller.control) {
		ronyao.gis.layerRes.refresh();
	}
	ronyao.gis.map.render(dom);
	ronyao.gis.map.zoomToMaxExtent();
}

//重新绘图，不重新读取数据
ronyao.gis.layoutGis = function() {
	ronyao.gis.map.render(ronyao.gis.map.div);
}

ronyao.gis.currentLayers=[];

//动态获取后台数据并生成Layers
ronyao.gis.initGisLayers = function(layersInfo){
	if(ronyao.gis.currentLayers.length > 0) {
		ronyao.gis.currentLayers = [];
		ronyao.gis.currentLayers.length = 0;
	}
	Ext.Array.each(layersInfo,function(layer){
       var basiclayer = new OpenLayers.Layer.Image( layer['name'],
		'res/map/' + layer['fname'],
        new OpenLayers.Bounds(-250, -125, 250, 125),
		new OpenLayers.Size(640,290),
		{	
			displayInLayerSwitcher:true,
			layerId:layer['id'],
			numZoomLevels : 3,
			maxResolution : .5,
			opacity : 0.7
		});
		ronyao.gis.map.addLayer(basiclayer);
		Ext.Array.push(ronyao.gis.currentLayers,basiclayer);
	});
	ronyao.gis.map.addLayer(ronyao.gis.layerRes);
}

ronyao.gis.highLightCallBack = function(){
	if(ronyao.gis.currentResId==null){
		return;
	}
	var resId = ronyao.gis.currentResId;
	var layerId =ronyao.gis.layerRes.protocol.params.layer;
	var layer = ronyao.gis.map.getLayersBy('layerId',layerId);
	ronyao.gis.map.setBaseLayer(layer[0]);
	var features = ronyao.gis.layerRes.protocol.options.format.data.features;
	ronyao.gis.layerRes.destroyFeatures();
	var featureArray = [];
	Ext.Array.each(features,function(feature){
		var tempFeature = ronyao.gis.layerRes.protocol.options.format.parseFeature(feature);
		featureArray.push(tempFeature);
	});
	
	ronyao.gis.layerRes.addFeatures(featureArray);
	
	if(ronyao.gis.useResId==0){
		var resFeature = ronyao.gis.layerRes.getFeatureByFid(resId);
		ronyao.gis.layerLight.addFeatures(resFeature.clone());
	}
	
	if(ronyao.gis.useResId==1){
		var resFeatures = ronyao.gis.layerRes.getFeaturesByAttribute('resid', resId);
		for ( var i = 0; i < resFeatures.length; i++) {
			ronyao.gis.layerLight.addFeatures(resFeatures[i].clone());
		}
	}
	
	ronyao.gis.useResId = -1;
}

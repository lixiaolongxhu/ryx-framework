//GIS 地图操作

// 资源显示样式---缺省
ronyao.gis.ruleDefault = new OpenLayers.Rule({
	symbolizer : {
		'Point' : {
			label:'${label}',
			fontSize:11,
			labelYOffset:20,
			labelSelect: true,
			fontStyle: "Cursive",
			pointRadius : 8,
			graphicOpacity : 1,
			externalGraphic : 'res/mark/${style}.png'
		},
		'Line' : {
			label:'${label}',
			fontSize:11,
			labelYOffset:20,
			labelSelect: true,
			fontStyle: "Cursive",
			strokeWidth : 3,
			strokeColor : "yellow"
		},
		'Polygon' : {
			label:'${label}',
			fontSize:11,
			labelYOffset:20,
			labelSelect: true,
			fontStyle: "Cursive",
			fillColor : "yellow",
			strokeWidth : 1,
			strokeColor : "blue"
		}
	}
})

ronyao.gis.styleDefault = new OpenLayers.Style(null, {
	rules : [ ronyao.gis.ruleDefault ]
})

// 资源图层
ronyao.gis.layerRes = new OpenLayers.Layer.Vector("设备图层", {
	strategies : [ new OpenLayers.Strategy.Fixed() ],
	protocol : new OpenLayers.Protocol.HTTP({
		scope:this,
		url : "controller/getGeoJson",
		params:{
			layer: 1
		},
		format : new OpenLayers.Format.GeoJSON({keepData:true}),
		callback:function(){
			ronyao.gis.highLightCallBack();
		}
	}),
	displayInLayerSwitcher:false,
	// 定义坐标显示图标样式
	styleMap : new OpenLayers.StyleMap({
		'default' : ronyao.gis.styleDefault
	})
});

// 资源显示样式---高亮，选择方式
ronyao.gis.ruleSelect = new OpenLayers.Rule({
	symbolizer : {
		'Point' : {
			pointRadius : 12,
			graphicOpacity : 1,
			externalGraphic : 'res/mark/light.gif'
		},
		'Line' : {
			strokeWidth : 6,
			strokeColor : "red"
		},
		'Polygon' : {
			fillColor : "yellow",
			strokeWidth : 6,
			strokeColor : "red"
		}
	}
})

ronyao.gis.styleSelect = new OpenLayers.Style(null, {
	rules : [ ronyao.gis.ruleSelect ]
})

// 高亮图层
ronyao.gis.layerLight = new OpenLayers.Layer.Vector("高亮图层", {
	transparent : "true",
	displayInLayerSwitcher:false,
	styleMap : new OpenLayers.StyleMap({
		'default' : ronyao.gis.styleSelect
	})
});

ronyao.gis.layerSwitcher = new OpenLayers.Control.LayerSwitcher();

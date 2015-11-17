// 拖动的控件
ronyao.gis.ctlDrag = new OpenLayers.Control.DragFeature(ronyao.gis.layerRes);

// 设备选择的控件
ronyao.gis.ctlSelect = new OpenLayers.Control.SelectFeature(ronyao.gis.layerRes, {
	multiple : false,
	toggle : true,
	multipleKey : 'shiftKey',
// hover : true,
// autoActivate : true
});

ronyao.gis.ctlEdit = new OpenLayers.Control.EditingToolbar(ronyao.gis.layerRes);

//添加图层
ronyao.gis.map.addLayer(ronyao.gis.layerLight);

//添加控件
ronyao.gis.map.addControl(ronyao.gis.ctlSelect);
ronyao.gis.map.addControl(ronyao.gis.ctlDrag);
ronyao.gis.map.addControl(ronyao.gis.ctlEdit);
ronyao.gis.map.addControl(ronyao.gis.layerSwitcher);

//控件使能
ronyao.gis.ctlSelect.activate();
ronyao.gis.ctlEdit.deactivate();
//ronyao.gis.ctlDrag.activate();
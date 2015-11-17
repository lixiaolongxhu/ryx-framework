/*
 * 这是GIS入口的第一个文件。GIS必须按照以下顺序进行载入
 *1:config.js
 *2:utils.js
 *3:layers.js
 *4:controls.js
 *5:events.js
 *6:init.js
 *7:interface.js
 */

Ext.namespace('ronyao.gis');

// Map 对象
ronyao.gis.map = new OpenLayers.Map();
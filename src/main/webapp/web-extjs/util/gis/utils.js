/*
 * GIS 所需要的工具函数
 */

/**
 * 取得Geo点的类型 \\n1：点\\n2：多点\\n3：线\\n4：多线\\n5：面\\n6：多面
 */
ronyao.gis.getGeoType = function(feature) {
	if (!feature)
		return;
	if (!feature.geometry.components) {// 点
		return 1;
	} else if (feature.geometry.components.length > 1) {// 线
		return 3;
	} else if (feature.geometry.components.length === 1) {// 面
		return 5;
	}
}
/**
 * 取得Geo点的数据
 */
ronyao.gis.getGeoData = function(feature) {
	if (!feature)
		return;
	var type = ronyao.gis.getGeoType(feature), data = [], geometry = feature.geometry;
	switch (type) {
	case 1:
		data = [ geometry.x, geometry.y ];
		break;
	case 2:
		break;
	case 3:
		var arrData = '';
		for ( var i = 0; i < geometry.components.length; i++) {
			arrData = '[' + geometry.components[i].x + ','
					+ geometry.components[i].y + ']';
			data.push(arrData);
		}
		break;
	case 4:
		break;
	case 5:
		var arrData = '';
		for ( var i = 0; i < geometry.components[0].components.length; i++) {
			arrData = '[' + geometry.components[0].components[i].x + ','
					+ geometry.components[0].components[i].y + ']';
			data.push(arrData);
		}
		data = '[' + data.toString() + ']';
		break;
	case 6:
		break;
	}
	return '[' + data.toString() + ']';
}
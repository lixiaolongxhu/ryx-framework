/*
Navicat MySQL Data Transfer

Source Server         : 127.0.0.1
Source Server Version : 50710
Source Host           : 127.0.0.1:3306
Source Database       : ryx

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-01-19 15:41:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for eqp_cha
-- ----------------------------
DROP TABLE IF EXISTS `eqp_cha`;
CREATE TABLE `eqp_cha` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `eid` int(10) NOT NULL,
  `type` int(10) DEFAULT NULL,
  `node` int(10) DEFAULT NULL,
  `uid` varchar(50) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `ext1` int(10) DEFAULT NULL,
  `ext2` int(10) DEFAULT NULL,
  `resid` int(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK__equipment` (`eid`),
  KEY `FK_eqp_cha_resource` (`resid`),
  CONSTRAINT `FK__equipment` FOREIGN KEY (`eid`) REFERENCES `equipment` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION,
  CONSTRAINT `FK_eqp_cha_resource` FOREIGN KEY (`resid`) REFERENCES `resource` (`id`) ON DELETE SET NULL
) ENGINE=InnoDB AUTO_INCREMENT=164 DEFAULT CHARSET=utf8 COMMENT='所有视频，控制器，定位点的通道';

-- ----------------------------
-- Records of eqp_cha
-- ----------------------------
INSERT INTO `eqp_cha` VALUES ('39', '0', '9', null, '31313732343047160C004100', '1号定位点', null, null, '39');
INSERT INTO `eqp_cha` VALUES ('40', '0', '9', null, '313137323430471624004000', '2号定位点', null, null, '40');
INSERT INTO `eqp_cha` VALUES ('41', '0', '9', null, '313137323430471607804100', '3号定位点', null, null, '41');
INSERT INTO `eqp_cha` VALUES ('42', '0', '9', null, '313137323430471600804100', '4号定位点', null, null, '42');
INSERT INTO `eqp_cha` VALUES ('45', '0', '9', null, '313137323430471628004000', '5号定位点', null, null, '158');
INSERT INTO `eqp_cha` VALUES ('83', '0', '9', null, '31313732343047161E004200', '定位点测试1', null, null, '159');
INSERT INTO `eqp_cha` VALUES ('89', '10', '7', '262401', '', '241-灯光', null, null, '155');
INSERT INTO `eqp_cha` VALUES ('90', '10', '4', '262402', '', '241-风机', null, null, null);
INSERT INTO `eqp_cha` VALUES ('107', '15', '8', '327938', '', '231-风速', null, null, '112');
INSERT INTO `eqp_cha` VALUES ('108', '15', '12', '328194', '', '231-SF6', null, null, '113');
INSERT INTO `eqp_cha` VALUES ('109', '15', '5', '393473', '', '231-空调', null, null, '114');
INSERT INTO `eqp_cha` VALUES ('110', '15', '6', '459008', '', '231-温湿度', null, null, '115');
INSERT INTO `eqp_cha` VALUES ('111', '15', '13', '590081', '', '231-氧气', null, null, '116');
INSERT INTO `eqp_cha` VALUES ('123', '10', '10', '196865', '', '241-水位', null, null, '123');
INSERT INTO `eqp_cha` VALUES ('124', '10', '3', '196866', '', '241-烟感', null, null, '125');
INSERT INTO `eqp_cha` VALUES ('125', '10', '2', '196867', '', '241-红外周界', null, null, '124');
INSERT INTO `eqp_cha` VALUES ('126', '15', '3', '196865', '', '231-烟感', null, null, '126');
INSERT INTO `eqp_cha` VALUES ('127', '15', '7', '262401', '', '231-灯光', null, null, '127');
INSERT INTO `eqp_cha` VALUES ('132', '23', '5', '3', '', 'v1空调', null, null, '128');
INSERT INTO `eqp_cha` VALUES ('133', '23', '4', '5', '', 'v1风机', null, null, '129');
INSERT INTO `eqp_cha` VALUES ('134', '23', '6', '99', '', 'v1温湿度', null, null, '132');
INSERT INTO `eqp_cha` VALUES ('151', '26', '7', '262401', '', '232-灯光', null, null, '153');
INSERT INTO `eqp_cha` VALUES ('152', '26', '4', '262402', '', '232-风机', null, null, '154');
INSERT INTO `eqp_cha` VALUES ('153', '26', '12', '328194', '', '232-SF6', null, null, '151');
INSERT INTO `eqp_cha` VALUES ('154', '26', '6', '459008', '', '232-温湿度', null, null, '150');
INSERT INTO `eqp_cha` VALUES ('155', '26', '13', '590081', '', '232-O2', null, null, '152');
INSERT INTO `eqp_cha` VALUES ('157', '26', '5', '393473', '', '232-空调', null, null, '163');
INSERT INTO `eqp_cha` VALUES ('158', '27', '1', '1', '', '视频1', '0', '1', '164');
INSERT INTO `eqp_cha` VALUES ('159', '27', '1', '2', '', '视频2', '0', '1', '166');
INSERT INTO `eqp_cha` VALUES ('160', '27', '1', '3', '', '视频3', '0', '1', '165');
INSERT INTO `eqp_cha` VALUES ('161', '27', '1', '4', '', '视频4', '1', '1', '166');
INSERT INTO `eqp_cha` VALUES ('162', '10', '8', '327938', '', '241-风速', null, null, '167');
INSERT INTO `eqp_cha` VALUES ('163', '29', '11', '3213213', '', '22132131', null, null, null);

-- ----------------------------
-- Table structure for equipment
-- ----------------------------
DROP TABLE IF EXISTS `equipment`;
CREATE TABLE `equipment` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `no` int(10) DEFAULT '0',
  `type` int(10) NOT NULL,
  `ip` char(50) DEFAULT NULL,
  `port` int(10) DEFAULT NULL,
  `user` varchar(50) DEFAULT NULL,
  `pass` varchar(50) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `version` int(11) NOT NULL DEFAULT '1' COMMENT '1：温湿度，2：输入，3：输出，10：主控',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8 COMMENT='视频，控制器，定位点的主表';

-- ----------------------------
-- Records of equipment
-- ----------------------------
INSERT INTO `equipment` VALUES ('10', '20', '1001', '192.168.1.241', '80', '', '', '241主控模块', '10');
INSERT INTO `equipment` VALUES ('15', '1', '1001', '192.168.1.230', '80', '', '', '231主控模块', '10');
INSERT INTO `equipment` VALUES ('23', '6', '1001', '192.168.1.239', '8080', '', '', 'v1环境温湿度模块', '1');
INSERT INTO `equipment` VALUES ('26', '2', '1001', '192.168.1.232', '80', '', '', '232主控模块', '10');
INSERT INTO `equipment` VALUES ('27', '22', '8', '192.168.1.28', '8000', 'admin', '12345', '测试', '1');
INSERT INTO `equipment` VALUES ('29', '2', '1002', '192.168.1.104', '249', null, null, '定位点的主表', '1');

-- ----------------------------
-- Table structure for gis_layer
-- ----------------------------
DROP TABLE IF EXISTS `gis_layer`;
CREATE TABLE `gis_layer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) NOT NULL,
  `fname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gis_layer
-- ----------------------------
INSERT INTO `gis_layer` VALUES ('1', '底图', 'layer1.jpg');
INSERT INTO `gis_layer` VALUES ('2', '泰兴', 'layer2.jpg');

-- ----------------------------
-- Table structure for gis_res
-- ----------------------------
DROP TABLE IF EXISTS `gis_res`;
CREATE TABLE `gis_res` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resid` int(11) NOT NULL,
  `layer` int(11) NOT NULL DEFAULT '1',
  `type` int(11) NOT NULL DEFAULT '1' COMMENT '1：点\n2：多点\n3：线\n4：多线\n5：面\n6：多面',
  `style` int(11) NOT NULL DEFAULT '1' COMMENT '地图元素的风格',
  `data` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_gis_res_resource` (`resid`),
  KEY `fk_gis_res_gis_layer` (`layer`),
  CONSTRAINT `fk_gis_res_gis_layer1` FOREIGN KEY (`layer`) REFERENCES `gis_layer` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_gis_res_resource` FOREIGN KEY (`resid`) REFERENCES `resource` (`id`) ON DELETE CASCADE ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of gis_res
-- ----------------------------
INSERT INTO `gis_res` VALUES ('3', '124', '1', '3', '2', '[[-207.5,52.25],[107,10.25],[99.5,-15.75],[236.5,-39.75],[236,21.75]]');
INSERT INTO `gis_res` VALUES ('4', '125', '1', '1', '3', '[-5,5.75]');
INSERT INTO `gis_res` VALUES ('6', '155', '1', '1', '7', '[-167.5,34.25]');
INSERT INTO `gis_res` VALUES ('7', '39', '1', '1', '9', '[-102,23.25]');
INSERT INTO `gis_res` VALUES ('8', '123', '1', '1', '10', '[141,-58.25]');
INSERT INTO `gis_res` VALUES ('9', '150', '2', '1', '6', '[-143.5,45.75]');
INSERT INTO `gis_res` VALUES ('12', '128', '1', '1', '5', '[101.5,38]');
INSERT INTO `gis_res` VALUES ('13', '132', '1', '1', '6', '[214.5,-21.5]');
INSERT INTO `gis_res` VALUES ('14', '154', '2', '1', '4', '[-2,-4.25]');
INSERT INTO `gis_res` VALUES ('16', '153', '2', '1', '7', '[83.5,-14.8125]');
INSERT INTO `gis_res` VALUES ('18', '151', '2', '1', '12', '[150.5,-15.3125]');
INSERT INTO `gis_res` VALUES ('19', '152', '2', '1', '13', '[-107,-97.3125]');
INSERT INTO `gis_res` VALUES ('20', '163', '2', '1', '5', '[31,-62.5]');
INSERT INTO `gis_res` VALUES ('21', '127', '1', '1', '7', '[125,7.25]');
INSERT INTO `gis_res` VALUES ('23', '129', '1', '1', '4', '[17,-21]');
INSERT INTO `gis_res` VALUES ('25', '129', '1', '1', '4', '[-143.5,56]');
INSERT INTO `gis_res` VALUES ('27', '114', '1', '1', '5', '[-116.5,-15.25]');
INSERT INTO `gis_res` VALUES ('30', '164', '1', '1', '1', '[-162.5,-13.75]');
INSERT INTO `gis_res` VALUES ('31', '115', '1', '1', '6', '[-9.5,-72.75]');
INSERT INTO `gis_res` VALUES ('32', '113', '1', '1', '12', '[-108,-53.75]');
INSERT INTO `gis_res` VALUES ('33', '116', '1', '1', '13', '[-56.5,-71.25]');
INSERT INTO `gis_res` VALUES ('34', '41', '1', '1', '9', '[60,4.125]');
INSERT INTO `gis_res` VALUES ('35', '125', '1', '1', '3', '[53.5,80.5]');
INSERT INTO `gis_res` VALUES ('37', '167', '1', '1', '8', '[-33,-43.25]');

-- ----------------------------
-- Table structure for json_test
-- ----------------------------
DROP TABLE IF EXISTS `json_test`;
CREATE TABLE `json_test` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jsonStr` json DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of json_test
-- ----------------------------
INSERT INTO `json_test` VALUES ('19', '{\"id\": \"\", \"token\": \"\", \"status\": \"\", \"nickname\": \"\", \"password\": \"\", \"realName\": \"李小龙\", \"loginName\": \"登陆名\", \"createTime\": \"2016-01-19 14:31:28\", \"updateTime\": \"\", \"portraitPath\": \"\"}');
INSERT INTO `json_test` VALUES ('20', '{\"id\": \"\", \"token\": \"\", \"status\": \"\", \"nickname\": \"\", \"password\": \"\", \"realName\": \"李小龙\", \"loginName\": \"loginname\", \"createTime\": \"2016-01-19 14:31:51\", \"updateTime\": \"\", \"portraitPath\": \"\"}');
INSERT INTO `json_test` VALUES ('21', '{\"id\": \"\", \"token\": \"\", \"status\": \"\", \"nickname\": \"\", \"password\": \"\", \"realName\": \"李小龙\", \"loginName\": \"登陆名\", \"createTime\": \"2016-01-19 14:32:12\", \"updateTime\": \"\", \"portraitPath\": \"\"}');
INSERT INTO `json_test` VALUES ('22', '{\"id\": \"\", \"token\": \"\", \"status\": \"\", \"nickname\": \"\", \"password\": \"\", \"realName\": \"李小龙\", \"loginName\": \"登陆名\", \"createTime\": \"2016-01-19 14:45:47\", \"updateTime\": \"\", \"portraitPath\": \"\"}');

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识的主键',
  `parentId` int(11) DEFAULT '0' COMMENT '上级编号',
  `name` varchar(50) NOT NULL DEFAULT '' COMMENT '权限资源名称',
  `url` varchar(50) DEFAULT '' COMMENT '访问权限的资源文件路径',
  `type` tinyint(4) DEFAULT '1' COMMENT '权限类型  1 接口 ，2 菜单',
  `describe` varchar(50) DEFAULT '' COMMENT '描述',
  `weight` tinyint(8) DEFAULT '0' COMMENT '同级权限的排序或者显示顺序，值越大，就越靠前显示',
  `status` tinyint(4) DEFAULT '0' COMMENT '1,正常状态，2，取消关注,3默认(首选)状态,4锁定状态(用户锁定)',
  `createTime` varchar(0) DEFAULT NULL COMMENT '创建时间',
  `updateTime` varchar(0) DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `permission_name_index` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '2', '权限资源管理', '', '2', '菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('2', '0', '用户管理', '', '2', '菜单', '0', '1', null, null);
INSERT INTO `permission` VALUES ('3', '2', '角色管理', '', '2', '', '0', '1', null, null);
INSERT INTO `permission` VALUES ('4', '3', '添加角色', '', '2', '', '0', '1', null, null);

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键，在文档中对应\nRESID\n',
  `pid` int(11) NOT NULL COMMENT '父节点',
  `class` int(11) NOT NULL DEFAULT '1' COMMENT '用于用户浏览权限分类\\n',
  `type` int(11) NOT NULL COMMENT '资源类型,见文档2.4',
  `name` varchar(45) NOT NULL COMMENT '名称',
  `state` int(11) NOT NULL DEFAULT '1' COMMENT '资源状态(可用还是不可用)\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\n0不可用，1可用',
  `ord` int(11) NOT NULL DEFAULT '1' COMMENT '排序的编号',
  PRIMARY KEY (`id`),
  KEY `fk_resource_res_class` (`class`),
  KEY `fk_resource_res_type` (`type`),
  CONSTRAINT `fk_resource_res_class` FOREIGN KEY (`class`) REFERENCES `res_class` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_resource_res_type` FOREIGN KEY (`type`) REFERENCES `res_type` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=168 DEFAULT CHARSET=utf8 COMMENT='资源列表';

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES ('39', '1', '1', '9', '1号定位点', '39', '1');
INSERT INTO `resource` VALUES ('40', '1', '1', '9', '2号定位点', '40', '1');
INSERT INTO `resource` VALUES ('41', '1', '1', '9', '3号定位点', '41', '1');
INSERT INTO `resource` VALUES ('42', '1', '1', '9', '4号定位点', '42', '1');
INSERT INTO `resource` VALUES ('112', '1', '1', '8', '231-风速', '107', '1');
INSERT INTO `resource` VALUES ('113', '1', '1', '12', '231-SF6', '108', '1');
INSERT INTO `resource` VALUES ('114', '1', '1', '5', '231-空调', '109', '1');
INSERT INTO `resource` VALUES ('115', '1', '1', '6', '231-温湿度', '110', '1');
INSERT INTO `resource` VALUES ('116', '1', '1', '13', '231-氧气', '111', '1');
INSERT INTO `resource` VALUES ('123', '1', '1', '10', '241-水位', '123', '1');
INSERT INTO `resource` VALUES ('124', '1', '1', '2', '241-红外周界', '125', '1');
INSERT INTO `resource` VALUES ('125', '1', '1', '3', '241-烟感', '124', '1');
INSERT INTO `resource` VALUES ('126', '1', '1', '3', '231-烟感', '126', '1');
INSERT INTO `resource` VALUES ('127', '1', '1', '7', '231-灯光', '127', '1');
INSERT INTO `resource` VALUES ('128', '1', '1', '5', 'v1空调', '132', '1');
INSERT INTO `resource` VALUES ('129', '1', '1', '4', 'v1风机', '133', '1');
INSERT INTO `resource` VALUES ('132', '1', '1', '6', 'v1温湿度', '134', '1');
INSERT INTO `resource` VALUES ('150', '1', '1', '6', '232-温湿度', '154', '1');
INSERT INTO `resource` VALUES ('151', '1', '1', '12', '232-SF6', '153', '1');
INSERT INTO `resource` VALUES ('152', '1', '1', '13', '232-O2', '155', '1');
INSERT INTO `resource` VALUES ('153', '1', '1', '7', '232-灯光', '151', '1');
INSERT INTO `resource` VALUES ('154', '1', '1', '4', '232-风机', '152', '1');
INSERT INTO `resource` VALUES ('155', '1', '1', '7', '241-灯光', '89', '1');
INSERT INTO `resource` VALUES ('158', '1', '1', '9', '5号定位点', '45', '1');
INSERT INTO `resource` VALUES ('159', '1', '1', '9', '定位点测试1', '83', '1');
INSERT INTO `resource` VALUES ('163', '1', '1', '5', '232-空调', '157', '1');
INSERT INTO `resource` VALUES ('164', '1', '1', '1', '视频1', '158', '1');
INSERT INTO `resource` VALUES ('165', '1', '1', '1', '视频3', '160', '1');
INSERT INTO `resource` VALUES ('166', '1', '1', '1', '视频2', '159', '1');
INSERT INTO `resource` VALUES ('167', '1', '1', '8', '241-风速', '162', '1');

-- ----------------------------
-- Table structure for res_type
-- ----------------------------
DROP TABLE IF EXISTS `res_type`;
CREATE TABLE `res_type` (
  `id` int(11) NOT NULL COMMENT '资源分类ID',
  `name` varchar(45) NOT NULL COMMENT '资源分类名',
  `state` varchar(10) NOT NULL COMMENT '1:告警规则资源,2:联动动作资源,3:既是告警规则资源也是联动动作资源,4:两者都不是',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of res_type
-- ----------------------------
INSERT INTO `res_type` VALUES ('0', '文件夹', '4');
INSERT INTO `res_type` VALUES ('1', '摄像机', '3');
INSERT INTO `res_type` VALUES ('2', '红外周界', '1');
INSERT INTO `res_type` VALUES ('3', '消防', '1');
INSERT INTO `res_type` VALUES ('4', '风机', '2');
INSERT INTO `res_type` VALUES ('5', '空调', '2');
INSERT INTO `res_type` VALUES ('6', '温湿度传感', '1');
INSERT INTO `res_type` VALUES ('7', '灯光', '2');
INSERT INTO `res_type` VALUES ('8', '风速', '1');
INSERT INTO `res_type` VALUES ('9', '人员定位', '2');
INSERT INTO `res_type` VALUES ('10', '水浸', '1');
INSERT INTO `res_type` VALUES ('11', '通用开关量', '2');
INSERT INTO `res_type` VALUES ('12', 'SF6传感器', '1');
INSERT INTO `res_type` VALUES ('13', 'O2传感器', '1');
INSERT INTO `res_type` VALUES ('101', '室外刀闸', '2');

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识的主键',
  `parentId` int(11) NOT NULL DEFAULT '0' COMMENT '父角色编码',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '角色名称 唯一约束，不允许为空',
  `status` tinyint(4) DEFAULT '1' COMMENT '记录状态 1 可用 2 不可用',
  `createTime` varchar(20) DEFAULT '' COMMENT '记录创建时间',
  `updateTime` varchar(20) DEFAULT '' COMMENT '记录修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name_index` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------

-- ----------------------------
-- Table structure for role_permission_link
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_link`;
CREATE TABLE `role_permission_link` (
  `roleId` int(11) NOT NULL COMMENT '角色唯一标识，外键（与permissionUuid组成联合主键）',
  `permissionId` int(11) NOT NULL COMMENT '权限唯一约束，外键',
  `status` tinyint(4) DEFAULT '1' COMMENT '1 可用 2 不可用',
  `createTime` varchar(20) DEFAULT '',
  `updateTime` varchar(20) DEFAULT '',
  PRIMARY KEY (`roleId`,`permissionId`),
  KEY `role_permissioin_link_permissionUuid` (`permissionId`),
  KEY `role_permission_link_roleid` (`roleId`),
  CONSTRAINT `perId_fk` FOREIGN KEY (`permissionId`) REFERENCES `permission` (`id`),
  CONSTRAINT `roleId_per_fk` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission_link
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '唯一标识的主键；不允许为空',
  `loginName` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号(登陆名)唯一约束，不允许为空，用户登陆名',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '不允许为空；使用MD5加密后保存',
  `token` varchar(40) DEFAULT '' COMMENT '用户的令牌码token',
  `realName` varchar(20) DEFAULT '' COMMENT '真实姓名',
  `nickname` varchar(20) DEFAULT '' COMMENT '昵称',
  `portraitPath` varchar(50) DEFAULT '' COMMENT '头像图片的相对路径',
  `status` tinyint(8) NOT NULL DEFAULT '1' COMMENT '1,正常状态，2，取消关注(冻结状态),',
  `createTime` varchar(20) NOT NULL DEFAULT '' COMMENT '记录创建时间',
  `updateTime` varchar(20) DEFAULT '' COMMENT '记录修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_loginName_index` (`loginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------

-- ----------------------------
-- Table structure for user_role_link
-- ----------------------------
DROP TABLE IF EXISTS `user_role_link`;
CREATE TABLE `user_role_link` (
  `userId` int(11) NOT NULL COMMENT '用户唯一标识，外键 ',
  `roleId` int(11) NOT NULL COMMENT '角色唯一标识，外键',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态 1 可用  2 不可用 ',
  `createTime` varchar(20) DEFAULT '' COMMENT '记录创建时间',
  `updateTime` varchar(20) DEFAULT '' COMMENT '修改时间',
  PRIMARY KEY (`userId`,`roleId`),
  KEY `user_role_link_roleUuid` (`roleId`),
  KEY `user_role_link_userId` (`userId`),
  CONSTRAINT `roleId_fk` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`),
  CONSTRAINT `user_role_uid_fk` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role_link
-- ----------------------------
DROP TRIGGER IF EXISTS `eqp_cha_before_update`;
DELIMITER ;;
CREATE TRIGGER `eqp_cha_before_update` BEFORE UPDATE ON `eqp_cha` FOR EACH ROW /*
需要对资源的名称和类型进行修改
首先判断RESID是否为空
*/
BEGIN

IF OLD.resid THEN
	UPDATE resource SET type=NEW.type, name=NEW.name WHERE id=OLD.resid;
END IF;

END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `eqp_cha_before_delete`;
DELIMITER ;;
CREATE TRIGGER `eqp_cha_before_delete` BEFORE DELETE ON `eqp_cha` FOR EACH ROW /*
需要删除通道对应的资源
*/
BEGIN

DELETE FROM resource WHERE ID=OLD.resid;

END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `equipment_before_delete`;
DELIMITER ;;
CREATE TRIGGER `equipment_before_delete` BEFORE DELETE ON `equipment` FOR EACH ROW /*
在进行级联删除的时候，子表的触发器不工作
1:需要遍历所有的通道，然后删除通道所对应的资源
*/
BEGIN
DECLARE done INT DEFAULT 0;
DECLARE rid INT;
DECLARE rs CURSOR FOR SELECT resid FROM eqp_cha WHERE eid=OLD.id;
DECLARE CONTINUE HANDLER FOR NOT FOUND SET done = 1;

OPEN rs;
read_loop:LOOP
	FETCH rs INTO rid;
	IF done THEN
		LEAVE read_loop;
	END IF;
	/*
	删除相关的resource记录
	*/
	DELETE FROM resource WHERE id=rid;
END LOOP;
CLOSE rs;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `resource_after_insert`;
DELIMITER ;;
CREATE TRIGGER `resource_after_insert` AFTER INSERT ON `resource` FOR EACH ROW BEGIN
/*
该触发器用于添加资源的时候自动更新相应的编码器、控制器通道，以及定位点的resid
注意：使用了state来传递源表的ID
*/

update eqp_cha set resid=NEW.id where id=NEW.state;


END
;;
DELIMITER ;

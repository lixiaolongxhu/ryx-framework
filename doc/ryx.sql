/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : ryx

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2015-10-15 15:56:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `uuid` varchar(40) NOT NULL COMMENT '唯一标识的主键',
  `no` varchar(50) DEFAULT '' COMMENT '唯一约束，不允许为空，定义格式001001001的格式',
  `name` varchar(50) DEFAULT '' COMMENT '不允许为空，唯一性约束',
  `url` varchar(50) DEFAULT '' COMMENT '访问权限的资源文件路径',
  `weight` tinyint(8) DEFAULT '0' COMMENT '同级权限的排序或者显示顺序，值越大，就越靠前显示',
  `parentNo` varchar(50) DEFAULT '0' COMMENT '上级编号',
  `status` tinyint(8) DEFAULT '0' COMMENT '1,正常状态，2，取消关注,3默认(首选)状态,4锁定状态(用户锁定)',
  `type` tinyint(8) DEFAULT '0' COMMENT '权限类型  1 接口 ，2 菜单',
  `describe` varchar(50) DEFAULT '' COMMENT '描述',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间',
  `updateTime` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `permission_no_index` (`no`) USING BTREE,
  UNIQUE KEY `permission_name_index` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('0f2261fe-ef58-4244-9799-51783817f578', '012001', '版本查询', '/jsp/updateMobileApp/index.jsp', '0', '012', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('1ce24454-a5d9-4c74-9d1e-920ad6b9499a', '009002', '资讯标签', '/jsp/informationLable/informationLableQuery.jsp', '0', '009', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('2fd75c44-cbb5-4165-863f-1319b34e2e18', '001001', '用户查询', '/jsp/user/userQuery.jsp', '0', '001', '1', '2', '菜单', null, null);
INSERT INTO `permission` VALUES ('42102ea2-5c07-4306-8cdb-880906190d94', '002001', '小区查询', '/jsp/village/villageQuery.jsp', '0', '002', '1', '2', '菜单', null, null);
INSERT INTO `permission` VALUES ('463cd82a-3648-4d44-a170-080bb855a6e2', '001', '用户管理', '', '0', '0', '1', '2', '菜单', null, null);
INSERT INTO `permission` VALUES ('561192d2-ed42-44ad-8ff6-20469d0b9d01', '002', '小区管理', '', '0', '0', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('668c2cb1-9d5f-40fe-a532-9d4c0d77443c', '005001', '商品类型查询', '/jsp/business/merTypeQuery.jsp', '0', '005', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('69a27cc5-60d5-43aa-9986-a94f9e5cb49f', '004', '商家管理', '', '0', '0', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('7dbfb8bd-c0c7-4b9b-ad20-b6cb6e202e41', '012', '版本管理', '', '0', '0', '1', '0', '', null, null);
INSERT INTO `permission` VALUES ('87b5c736-e0d3-492a-a3ee-10a56b0a5e8b', '006', '区域管理', '', '0', '0', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('a7bf7d05-ef30-41cb-a7b0-c47d07669d82', '009003', '资讯信息', '/jsp/information/informationQuery.jsp', '0', '009', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('abc1d238-9600-4def-959c-b4f095940e7d', '011001', '订单查询', '/jsp/orders/ordersQuery.jsp', '0', '011', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('addc9712-80c1-46b9-a996-c5b86ab4b920', '009', '资讯管理', '', '0', '0', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('b1623351-d22d-4c94-a4b7-d803532c0870', '010001', '小屋查询', '/jsp/hut/hutQuery.jsp', '0', '010', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('bda74218-f3a3-46f1-ae4d-4b370c083701', '007', '公告管理', '', '0', '0', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('c9be58e7-5d80-4a78-a4dd-064f3197fe21', '008001', '投诉保修查询', '/jsp/invitation/invitationCallQuery.jsp', '0', '008', '2', '2', '', null, null);
INSERT INTO `permission` VALUES ('cab4afa3-4065-4f74-8af3-02489ec62e87', '003', '物业管理', '', '0', '0', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('dec024a6-addb-444e-858a-d13b750a48c6', '005', '商品管理', '', '0', '0', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('e736cb70-ef6d-4c8d-8f80-1f9cc843c8be', '010', '小屋管理', '', '0', '0', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('e7b163fc-db15-46ad-901b-ddc9b477a824', '005002', '商品查询', '/jsp/business/merchandiseQuery.jsp', '0', '005', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('eb406d16-5b00-4e94-ab88-10e7d1e861ff', '011', '订单管理', '', '0', '0', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('edc7b4c2-9e22-425d-b403-26da661c8bfb', '007001', '公告查询', '/jsp/notice/noticeQuery.jsp', '0', '007', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('f1f8d428-8bbc-4ccc-a03f-dda75fff3c64', '009001', '资讯分类', '/jsp/informationType/InformationTypeQuery.jsp', '0', '009', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('f3407ccc-be6e-4845-aa2a-93572d791703', '008', '投诉保修管理', '', '0', '0', '2', '0', '', null, null);
INSERT INTO `permission` VALUES ('f52bb195-3b94-49e8-9a5d-848ab03db3e4', '006001', '区域查询', '/jsp/region/regionQuery.jsp', '0', '006', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('f9dfd453-fdb0-479c-acf2-d6e02a927be8', '004001', '商家查询', '/jsp/business/businessQuery.jsp', '0', '004', '1', '2', '', null, null);
INSERT INTO `permission` VALUES ('fad0889e-efaf-4fb9-a813-5653407d7ba7', '003001', '物业公司查询', '/jsp/tenementCompany/companyQuery.jsp', '0', '003', '1', '2', '', null, null);

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `uuid` varchar(40) NOT NULL COMMENT '唯一标识的主键',
  `no` varchar(50) DEFAULT '' COMMENT '唯一约束，不允许为空，定义格式001001001的格式',
  `name` varchar(20) DEFAULT '' COMMENT '唯一约束，不允许为空',
  `parentNo` varchar(20) DEFAULT '' COMMENT '父角色编码',
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '002', 'USER_ADMIN', '0', null, null);
INSERT INTO `role` VALUES ('68f23f57-a496-4894-8d50-814ec4296806', '003', 'USER_TENEMENT', '0', null, null);
INSERT INTO `role` VALUES ('72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '005', 'USER_BUSINESS', '0', null, null);
INSERT INTO `role` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', '001', 'USER_SUPERVER_ADMIN', '0', '2015-06-09 16:12:38', null);
INSERT INTO `role` VALUES ('c80feb63-907a-46d8-957e-a085d304b14f', '004', 'USER_COMMON', '0', null, null);

-- ----------------------------
-- Table structure for role_permission_link
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_link`;
CREATE TABLE `role_permission_link` (
  `roleUuid` varchar(50) NOT NULL COMMENT '角色唯一标识，外键（与permissionUuid组成联合主键）',
  `permissionUuid` varchar(50) NOT NULL COMMENT '权限唯一约束，外键',
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`roleUuid`,`permissionUuid`),
  KEY `role_permissioin_link_permissionUuid` (`permissionUuid`),
  CONSTRAINT `role_permissioin_link_permissionUuid` FOREIGN KEY (`permissionUuid`) REFERENCES `permission` (`uuid`),
  CONSTRAINT `role_permisson_link_roleUuid` FOREIGN KEY (`roleUuid`) REFERENCES `role` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission_link
-- ----------------------------

-- ----------------------------
-- Table structure for sms_validate_code
-- ----------------------------
DROP TABLE IF EXISTS `sms_validate_code`;
CREATE TABLE `sms_validate_code` (
  `uuid` varchar(40) NOT NULL,
  `content` text,
  `mobilePhoneNum` varchar(20) DEFAULT NULL,
  `code` varchar(20) DEFAULT NULL,
  `info` text,
  `smsNoticeType` tinyint(4) DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sms_validate_code
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uuid` varchar(40) NOT NULL COMMENT '唯一标识的主键；不允许为空',
  `nickname` varchar(20) DEFAULT '' COMMENT '昵称',
  `portraitPath` varchar(50) DEFAULT '' COMMENT '头像图片的相对路径',
  `password` varchar(50) NOT NULL DEFAULT '' COMMENT '不允许为空；使用MD5加密后保存',
  `realName` varchar(20) DEFAULT NULL,
  `type` tinyint(1) unsigned zerofill NOT NULL DEFAULT '0' COMMENT '1表示管理员（包括运营人员），2表示普通住户，3表示物业人员，4表示商家，',
  `loginName` varchar(20) NOT NULL DEFAULT '' COMMENT '手机号(登陆名)唯一约束，不允许为空，用户登陆名',
  `payPassword` varchar(50) DEFAULT NULL COMMENT '支付密码',
  `mobilePhone` varchar(20) DEFAULT NULL,
  `token` varchar(40) DEFAULT NULL,
  `status` tinyint(8) NOT NULL DEFAULT '0' COMMENT '1,正常状态，2，取消关注,3默认(首选)状态,4锁定状态(用户锁定)',
  `createTime` datetime NOT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  UNIQUE KEY `user_loginName_index` (`loginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3e6df067-b03b-422d-851d-8225feabab16', '', '', 'password', null, '0', 'lxl2836', null, null, null, '0', '2015-10-15 14:00:25', null);
INSERT INTO `user` VALUES ('7536844e-9af7-4002-bad9-eb8ca0878d4f', '', '', 'password', null, '0', 'lxl4157', null, null, null, '0', '2015-10-15 14:00:10', null);

-- ----------------------------
-- Table structure for user_role_link
-- ----------------------------
DROP TABLE IF EXISTS `user_role_link`;
CREATE TABLE `user_role_link` (
  `userUuid` varchar(50) NOT NULL COMMENT '用户唯一标识，外键  (与roleUuid组成联合主键)',
  `roleUuid` varchar(50) NOT NULL COMMENT '角色唯一标识，外键',
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  PRIMARY KEY (`userUuid`,`roleUuid`),
  KEY `user_role_link_roleUuid` (`roleUuid`),
  CONSTRAINT `user_role_link_roleUuid` FOREIGN KEY (`roleUuid`) REFERENCES `role` (`uuid`),
  CONSTRAINT `user_role_link_userUuid` FOREIGN KEY (`userUuid`) REFERENCES `user` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role_link
-- ----------------------------

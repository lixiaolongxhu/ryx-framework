/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : ryx

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2015-11-05 11:59:43
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL COMMENT '唯一标识的主键',
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------

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
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '唯一标识的主键；不允许为空',
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
  `userId` bigint(20) NOT NULL COMMENT '用户唯一标识，外键 ',
  `roleId` int(11) NOT NULL COMMENT '角色唯一标识，外键',
  `status` tinyint(4) DEFAULT '1' COMMENT '状态 1 可用  2 不可用 ',
  `createTime` varchar(20) DEFAULT '' COMMENT '记录创建时间',
  `updateTime` varchar(20) DEFAULT '' COMMENT '修改时间',
  PRIMARY KEY (`userId`,`roleId`),
  KEY `user_role_link_roleUuid` (`roleId`),
  KEY `user_role_link_userId` (`userId`),
  CONSTRAINT `roleId_fk` FOREIGN KEY (`roleId`) REFERENCES `role` (`id`),
  CONSTRAINT `userId_fk` FOREIGN KEY (`userId`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role_link
-- ----------------------------

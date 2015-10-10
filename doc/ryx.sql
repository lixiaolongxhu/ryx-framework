/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50703
Source Host           : localhost:3306
Source Database       : ryx

Target Server Type    : MYSQL
Target Server Version : 50703
File Encoding         : 65001

Date: 2015-10-10 09:20:03
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
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '0f2261fe-ef58-4244-9799-51783817f578', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '1ce24454-a5d9-4c74-9d1e-920ad6b9499a', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2fd75c44-cbb5-4165-863f-1319b34e2e18', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '42102ea2-5c07-4306-8cdb-880906190d94', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '463cd82a-3648-4d44-a170-080bb855a6e2', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '561192d2-ed42-44ad-8ff6-20469d0b9d01', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '668c2cb1-9d5f-40fe-a532-9d4c0d77443c', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '69a27cc5-60d5-43aa-9986-a94f9e5cb49f', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '7dbfb8bd-c0c7-4b9b-ad20-b6cb6e202e41', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '87b5c736-e0d3-492a-a3ee-10a56b0a5e8b', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', 'a7bf7d05-ef30-41cb-a7b0-c47d07669d82', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', 'abc1d238-9600-4def-959c-b4f095940e7d', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', 'addc9712-80c1-46b9-a996-c5b86ab4b920', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', 'b1623351-d22d-4c94-a4b7-d803532c0870', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', 'bda74218-f3a3-46f1-ae4d-4b370c083701', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', 'c9be58e7-5d80-4a78-a4dd-064f3197fe21', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', 'cab4afa3-4065-4f74-8af3-02489ec62e87', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', 'dec024a6-addb-444e-858a-d13b750a48c6', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', 'e736cb70-ef6d-4c8d-8f80-1f9cc843c8be', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', 'e7b163fc-db15-46ad-901b-ddc9b477a824', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', 'eb406d16-5b00-4e94-ab88-10e7d1e861ff', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', 'edc7b4c2-9e22-425d-b403-26da661c8bfb', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', 'f1f8d428-8bbc-4ccc-a03f-dda75fff3c64', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', 'f3407ccc-be6e-4845-aa2a-93572d791703', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', 'f52bb195-3b94-49e8-9a5d-848ab03db3e4', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', 'f9dfd453-fdb0-479c-acf2-d6e02a927be8', null, null);
INSERT INTO `role_permission_link` VALUES ('1dafa9ca-bd88-4061-8740-7a62d8fbbb60', 'fad0889e-efaf-4fb9-a813-5653407d7ba7', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', '0f2261fe-ef58-4244-9799-51783817f578', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', '1ce24454-a5d9-4c74-9d1e-920ad6b9499a', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', '2fd75c44-cbb5-4165-863f-1319b34e2e18', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', '42102ea2-5c07-4306-8cdb-880906190d94', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', '463cd82a-3648-4d44-a170-080bb855a6e2', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', '561192d2-ed42-44ad-8ff6-20469d0b9d01', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', '668c2cb1-9d5f-40fe-a532-9d4c0d77443c', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', '69a27cc5-60d5-43aa-9986-a94f9e5cb49f', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', '7dbfb8bd-c0c7-4b9b-ad20-b6cb6e202e41', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', '87b5c736-e0d3-492a-a3ee-10a56b0a5e8b', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', 'a7bf7d05-ef30-41cb-a7b0-c47d07669d82', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', 'abc1d238-9600-4def-959c-b4f095940e7d', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', 'addc9712-80c1-46b9-a996-c5b86ab4b920', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', 'b1623351-d22d-4c94-a4b7-d803532c0870', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', 'bda74218-f3a3-46f1-ae4d-4b370c083701', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', 'c9be58e7-5d80-4a78-a4dd-064f3197fe21', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', 'cab4afa3-4065-4f74-8af3-02489ec62e87', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', 'dec024a6-addb-444e-858a-d13b750a48c6', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', 'e736cb70-ef6d-4c8d-8f80-1f9cc843c8be', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', 'e7b163fc-db15-46ad-901b-ddc9b477a824', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', 'eb406d16-5b00-4e94-ab88-10e7d1e861ff', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', 'edc7b4c2-9e22-425d-b403-26da661c8bfb', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', 'f1f8d428-8bbc-4ccc-a03f-dda75fff3c64', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', 'f3407ccc-be6e-4845-aa2a-93572d791703', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', 'f52bb195-3b94-49e8-9a5d-848ab03db3e4', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', 'f9dfd453-fdb0-479c-acf2-d6e02a927be8', null, null);
INSERT INTO `role_permission_link` VALUES ('8d688dac-7db5-4506-85e2-d39d085ed1d2', 'fad0889e-efaf-4fb9-a813-5653407d7ba7', null, null);

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
INSERT INTO `sms_validate_code` VALUES ('015790bc-db9a-4339-ae43-fb701d25aa50', '欢迎使用日有喜智慧社区,您的验证码是:3289;懒人生活,立刻开启。', '13881957318', '3289', 'result=0&description=发送短信成功&taskid=229106929165&faillist=&task_id=229106929165', null, '1', '2015-06-19 15:32:04', null);
INSERT INTO `sms_validate_code` VALUES ('04abf837-ab10-4395-b399-792216030df3', '欢迎使用日有喜智慧社区,您的验证码是:3297;懒人生活,立刻开启。', '18380478210', '3297', 'result=0&description=发送短信成功&taskid=229114555407&faillist=&task_id=229114555407', null, '1', '2015-07-20 16:51:36', null);
INSERT INTO `sms_validate_code` VALUES ('0c1d7ab0-d476-445f-827f-27162c3848e4', '欢迎使用日有喜智慧社区,您的验证码是:9560;懒人生活,立刻开启。', '13123456789', '9560', 'result=13&description=您的[普通短信业务]剩余数量发送不足，暂不能发送该类信息', null, '1', '2015-07-14 16:20:51', null);
INSERT INTO `sms_validate_code` VALUES ('0faa452b-561d-4702-bbed-904913bc4f38', '欢迎使用日有喜智慧社区,您的验证码是:6421;懒人生活,立刻开启。', '13881957318', '6421', 'result=0&description=发送短信成功&taskid=229115493984&faillist=&task_id=229115493984', null, '1', '2015-07-20 17:22:46', null);
INSERT INTO `sms_validate_code` VALUES ('14d4936a-9373-4547-ba8e-6e2a84557e4f', '欢迎使用日有喜智慧社区,您的验证码是:4109;懒人生活,立刻开启。', '13123456789', '4109', 'result=0&description=发送短信成功&taskid=229106553630&faillist=&task_id=229106553630', null, '1', '2015-06-26 01:53:49', null);
INSERT INTO `sms_validate_code` VALUES ('15c766f1-c7f9-4677-9217-41de8666f648', '欢迎使用日有喜智慧社区,您的验证码是:6175;懒人生活,立刻开启。', '18111618866', '6175', 'result=32&description=同一号码发送次数太多', null, '1', '2015-06-26 01:52:10', null);
INSERT INTO `sms_validate_code` VALUES ('1bef6b2d-7cf5-444c-9515-0e067e842b5f', '欢迎使用日有喜智慧社区,您的验证码是:5267;懒人生活,立刻开启。', '18380478218', '5267', 'result=0&description=发送短信成功&taskid=229107397748&faillist=&task_id=229107397748', null, '1', '2015-06-24 19:18:23', null);
INSERT INTO `sms_validate_code` VALUES ('1fa1414d-4f60-40ce-8952-52b2e2f1892b', '欢迎使用日有喜智慧社区,您的验证码是:6748;懒人生活,立刻开启。', '18202823071', '6748', 'result=28&description=发送内容与模板不符', null, '1', '2015-07-21 11:07:22', null);
INSERT INTO `sms_validate_code` VALUES ('2fe0d132-461a-4ac5-93e9-ce3fe78601e5', '欢迎使用日有喜智慧社区,您的验证码是:2810;懒人生活,立刻开启。', '18111618866', '2810', 'result=0&description=发送短信成功&taskid=229107576489&faillist=&task_id=229107576489', null, '1', '2015-06-25 16:16:35', null);
INSERT INTO `sms_validate_code` VALUES ('32c7b7fb-4522-48d2-a7c9-1af4b61972bf', '欢迎使用日有喜智慧社区,您的验证码是:9042;懒人生活,立刻开启。', '18380478218', '9042', 'result=13&description=您的[普通短信业务]剩余数量发送不足，暂不能发送该类信息', null, '1', '2015-07-20 15:51:30', null);
INSERT INTO `sms_validate_code` VALUES ('381430fa-3c62-4329-b1ca-577b9469b874', '欢迎使用日有喜智慧社区,您的验证码是:6213;懒人生活,立刻开启。', '18380478218', '6213', 'result=32&description=同一号码发送次数太多', null, '1', '2015-07-20 16:52:31', null);
INSERT INTO `sms_validate_code` VALUES ('3b1606a1-89c0-469a-9feb-0cfe836381a3', '欢迎使用日有喜智慧社区,您的验证码是:4079;懒人生活,立刻开启。', '13668128127', '4079', 'result=0&description=发送短信成功&taskid=229114637313&faillist=&task_id=229114637313', null, '1', '2015-07-21 09:35:37', null);
INSERT INTO `sms_validate_code` VALUES ('44bedba3-b56c-4391-a8c6-7f7d1f8d75ca', '欢迎来到轻松宅智慧社区,您的验证码是:348129;开门八件事,柴米油盐酱醋茶,喜!', '18380478218', '348129', 'result=0&description=发送短信成功&taskid=229115644550&faillist=&task_id=229115644550', '2', '1', '2015-07-22 13:58:13', null);
INSERT INTO `sms_validate_code` VALUES ('4c50353c-c943-443c-ac12-0c17dbabedb3', '欢迎使用日有喜智慧社区,您的验证码是:7913;懒人生活,立刻开启。', '18680519173', '7913', 'result=0&description=发送短信成功&taskid=229115525862&faillist=&task_id=229115525862', null, '1', '2015-07-21 08:37:24', null);
INSERT INTO `sms_validate_code` VALUES ('530c3d08-f7e6-4f8f-9bf9-b9b7ce7e45ee', '欢迎使用日有喜智慧社区,您的验证码是:0971;懒人生活,立刻开启。', '18380478218', '0971', 'result=13&description=您的[普通短信业务]剩余数量发送不足，暂不能发送该类信息', null, '1', '2015-07-20 14:33:27', null);
INSERT INTO `sms_validate_code` VALUES ('60a8cdd6-47fd-4af4-bcb8-4186e23fd0a5', '欢迎使用日有喜智慧社区,您的验证码是:6421;懒人生活,立刻开启。', '13881957318', '6421', 'result=0&description=发送短信成功&taskid=229115493412&faillist=&task_id=229115493412', null, '1', '2015-07-20 17:16:56', null);
INSERT INTO `sms_validate_code` VALUES ('65502cf5-c88d-4801-8efb-ad8c1169a10e', '欢迎使用日有喜智慧社区,您的验证码是:6472;懒人生活,立刻开启。', '18111618866', '6472', 'result=0&description=发送短信成功&taskid=229109866984&faillist=&task_id=229109866984', null, '1', '2015-06-26 22:47:47', null);
INSERT INTO `sms_validate_code` VALUES ('6a1a6d07-5c0e-419f-85f7-57a7688c3b19', '欢迎使用日有喜智慧社区,您的验证码是:6538;懒人生活,立刻开启。', '13881957318', '6538', 'result=0&description=发送短信成功&taskid=229115490791&faillist=&task_id=229115490791', null, '1', '2015-07-20 16:54:47', null);
INSERT INTO `sms_validate_code` VALUES ('6b887038-d936-4498-82d9-c7728e4d0cf5', '欢迎使用日有喜智慧社区,您的验证码是:4518;懒人生活,立刻开启。', '13881957318', '4518', 'result=0&description=发送短信成功&taskid=229106525412&faillist=&task_id=229106525412', null, '1', '2015-06-26 00:05:57', null);
INSERT INTO `sms_validate_code` VALUES ('6e6265dc-642d-462a-903a-a8ca3fb823de', '欢迎使用日有喜智慧社区,您的验证码是:3542;懒人生活,立刻开启。', '18980704515', '3542', 'result=0&description=发送短信成功&taskid=229115530958&faillist=&task_id=229115530958', null, '1', '2015-07-21 09:24:48', null);
INSERT INTO `sms_validate_code` VALUES ('711ce90d-41fb-4d00-aad8-a9d44856da35', '欢迎使用日有喜智慧社区,您的验证码是:6175;懒人生活,立刻开启。', '18111618866', '6175', 'result=32&description=同一号码发送次数太多', null, '1', '2015-06-26 01:48:40', null);
INSERT INTO `sms_validate_code` VALUES ('783a854d-77d7-4009-9f25-d2204d945147', '欢迎使用日有喜智慧社区,您的验证码是:6018;懒人生活,立刻开启。', '18380478218', '6018', 'result=13&description=您的[普通短信业务]剩余数量发送不足，暂不能发送该类信息', null, '1', '2015-07-20 10:30:53', null);
INSERT INTO `sms_validate_code` VALUES ('86137a07-27dd-4b7e-89db-47a4adb1b002', '欢迎使用日有喜智慧社区,您的验证码是:8125;懒人生活,立刻开启。', '18111618866', '8125', 'result=0&description=发送短信成功&taskid=229107584970&faillist=&task_id=229107584970', null, '1', '2015-06-26 01:21:00', null);
INSERT INTO `sms_validate_code` VALUES ('946e1803-1522-46d6-8d78-ad062707d279', '欢迎使用日有喜智慧社区,您的验证码是:3042;懒人生活,立刻开启。', '13908180189', '3042', 'result=0&description=发送短信成功&taskid=229115510391&faillist=&task_id=229115510391', null, '1', '2015-07-20 20:24:54', null);
INSERT INTO `sms_validate_code` VALUES ('982c2e45-8283-4931-8df7-9b15b863ae9b', '欢迎使用日有喜智慧社区,您的验证码是:0793;懒人生活,立刻开启。', '18161266869', '0793', 'result=13&description=您的[普通短信业务]剩余数量发送不足，暂不能发送该类信息', null, '1', '2015-07-14 15:50:32', null);
INSERT INTO `sms_validate_code` VALUES ('a4753325-025d-4013-881d-2ddfc2354388', '欢迎使用日有喜智慧社区,您的验证码是:3195;懒人生活,立刻开启。', '13881957318', '3195', 'result=0&description=发送短信成功&taskid=229105982295&faillist=&task_id=229105982295', null, '1', '2015-06-23 18:08:33', null);
INSERT INTO `sms_validate_code` VALUES ('ad7515ad-38b9-4e85-84d0-877ca012d517', '欢迎使用日有喜智慧社区,您的验证码是:0971;懒人生活,立刻开启。', '18380478218', '0971', 'result=13&description=您的[普通短信业务]剩余数量发送不足，暂不能发送该类信息', null, '1', '2015-07-20 14:36:36', null);
INSERT INTO `sms_validate_code` VALUES ('b475bd92-0d89-47e7-a63e-df507d618b0d', '欢迎使用日有喜智慧社区,您的验证码是:6738;懒人生活,立刻开启。', '18161266869', '6738', 'result=13&description=您的[普通短信业务]剩余数量发送不足，暂不能发送该类信息', null, '1', '2015-07-14 16:11:46', null);
INSERT INTO `sms_validate_code` VALUES ('b6858803-999b-43f9-a87f-54a0e57e9b62', '欢迎来到轻松宅智慧社区,您的验证码是:628749;开门八件事,柴米油盐酱醋茶,喜!', '18380478218', '628749', 'result=0&description=发送短信成功&taskid=229114854450&faillist=&task_id=229114854450', '2', '1', '2015-07-22 11:18:47', null);
INSERT INTO `sms_validate_code` VALUES ('bbf3c84a-2dfc-4de1-98e0-e1eb86ecf313', '欢迎使用日有喜智慧社区,您的验证码是:8125;懒人生活,立刻开启。', '18111618866', '8125', 'result=0&description=发送短信成功&taskid=229106548782&faillist=&task_id=229106548782', null, '1', '2015-06-26 01:31:11', null);
INSERT INTO `sms_validate_code` VALUES ('cf422ad3-9bd4-46ab-bcd1-532e89104c2b', '欢迎使用轻松宅智慧社区,您的验证码是:768143;懒人生活,立刻开启。', '17012451235', '768143', '发送短信失败   发送短信的号码必须是手机号', '1', '1', '2015-07-24 17:33:58', null);
INSERT INTO `sms_validate_code` VALUES ('d2d1a3f7-1e10-4486-a167-eb60f375c085', '欢迎使用轻松宅智慧社区,您的验证码是:5074;懒人生活,立刻开启。', '15982119314', '5074', 'result=0&description=发送短信成功&taskid=229114814531&faillist=&task_id=229114814531', null, '1', '2015-07-22 09:37:22', null);
INSERT INTO `sms_validate_code` VALUES ('d3e2fef2-f346-4b42-bcf0-45c5de3a6b1d', '欢迎使用日有喜智慧社区,您的验证码是:8125;懒人生活,立刻开启。', '18111618866', '8125', 'result=0&description=发送短信成功&taskid=229107585774&faillist=&task_id=229107585774', null, '1', '2015-06-26 01:27:34', null);
INSERT INTO `sms_validate_code` VALUES ('d816063a-b876-4226-bd35-8b22a6cf5dcd', '欢迎使用日有喜智慧社区,您的验证码是:9216;懒人生活,立刻开启。', '13881957318', '9216', 'result=13&description=您的[普通短信业务]剩余数量发送不足，暂不能发送该类信息', null, '1', '2015-07-17 18:30:29', null);
INSERT INTO `sms_validate_code` VALUES ('da9148b8-a37a-4e31-a397-df9864d77dcc', '欢迎使用日有喜智慧社区,您的验证码是:6748;懒人生活,立刻开启。', '18202823071', '6748', 'result=28&description=发送内容与模板不符', null, '1', '2015-07-21 11:05:35', null);
INSERT INTO `sms_validate_code` VALUES ('ddeb3abe-c3b2-41c8-bf26-66ef247de8e2', '欢迎使用日有喜智慧社区,您的验证码是:9560;懒人生活,立刻开启。', '13123456789', '9560', 'result=13&description=您的[普通短信业务]剩余数量发送不足，暂不能发送该类信息', null, '1', '2015-07-14 16:13:40', null);
INSERT INTO `sms_validate_code` VALUES ('e106d986-be52-4dc9-9d21-50106000c6de', '欢迎使用日有喜智慧社区,您的验证码是:2810;懒人生活,立刻开启。', '18111618866', '2810', 'result=0&description=发送短信成功&taskid=229107576283&faillist=&task_id=229107576283', null, '1', '2015-06-25 16:14:52', null);
INSERT INTO `sms_validate_code` VALUES ('e5946ce0-2c3c-401c-93fa-171db4aa5b0c', '欢迎使用轻松宅智慧社区,您的验证码是:923480;懒人生活,立刻开启。', '15008205524', '923480', 'result=0&description=发送短信成功&taskid=229115664306&faillist=&task_id=229115664306', '1', '1', '2015-07-22 17:40:23', null);
INSERT INTO `sms_validate_code` VALUES ('e626bb72-c10a-4f74-a144-9485d31b475e', '欢迎来到轻松宅智慧社区,您的验证码是:628749;开门八件事,柴米油盐酱醋茶,喜!', '18380478218', '628749', 'result=0&description=发送短信成功&taskid=229114855669&faillist=&task_id=229114855669', '2', '1', '2015-07-22 11:22:26', null);
INSERT INTO `sms_validate_code` VALUES ('e92020e8-cff4-4af2-97ce-94867a7c05d3', '欢迎使用日有喜智慧社区,您的验证码是:2810;懒人生活,立刻开启。', '18111618866', '2810', 'result=0&description=发送短信成功&taskid=229106527869&faillist=&task_id=229106527869', null, '1', '2015-06-25 16:15:46', null);
INSERT INTO `sms_validate_code` VALUES ('e93f4dec-2774-4f9c-976e-15a0629797c7', '欢迎使用轻松宅智慧社区,您的验证码是:7812;懒人生活,立刻开启。', '13699716420', '7812', 'result=0&description=发送短信成功&taskid=229115590010&faillist=&task_id=229115590010', null, '1', '2015-07-21 21:01:33', null);
INSERT INTO `sms_validate_code` VALUES ('e9c9ea28-add3-4bd5-a1dc-f231f98798c2', '欢迎使用日有喜智慧社区,您的验证码是:0971;懒人生活,立刻开启。', '18380478218', '0971', 'result=13&description=您的[普通短信业务]剩余数量发送不足，暂不能发送该类信息', null, '1', '2015-07-20 14:37:45', null);
INSERT INTO `sms_validate_code` VALUES ('eb4f5c06-a4ab-49a8-9067-869db59e2279', '欢迎使用日有喜智慧社区,您的验证码是:6018;懒人生活,立刻开启。', '18380478218', '6018', 'result=13&description=您的[普通短信业务]剩余数量发送不足，暂不能发送该类信息', null, '1', '2015-07-20 10:34:12', null);
INSERT INTO `sms_validate_code` VALUES ('ec2bf8d4-9d50-4df5-9caf-13d13ecc1d8a', '欢迎来到轻松宅智慧社区,您的验证码是:628749;开门八件事,柴米油盐酱醋茶,喜!', '18380478218', '628749', 'result=0&description=发送短信成功&taskid=229115633786&faillist=&task_id=229115633786', '2', '1', '2015-07-22 11:32:37', null);
INSERT INTO `sms_validate_code` VALUES ('ec976be0-5db1-48eb-86b7-e5f215b721e6', '欢迎来到轻松宅智慧社区,您的验证码是:628749;开门八件事,柴米油盐酱醋茶,喜!', '18380478218', '628749', 'result=0&description=发送短信成功&taskid=229114860298&faillist=&task_id=229114860298', '2', '1', '2015-07-22 11:37:45', null);
INSERT INTO `sms_validate_code` VALUES ('f137ee1d-7daa-4a90-818e-b127a3ac7078', '欢迎使用日有喜智慧社区,您的验证码是:6421;懒人生活,立刻开启。', '13881957318', '6421', 'result=0&description=发送短信成功&taskid=229114565674&faillist=&task_id=229114565674', null, '1', '2015-07-20 17:31:02', null);
INSERT INTO `sms_validate_code` VALUES ('f87156e9-c98e-412f-9042-93cca17fdefe', '欢迎使用日有喜智慧社区,您的验证码是:0924;懒人生活,立刻开启。', '13908180189', '0924', 'result=0&description=发送短信成功&taskid=229114590619&faillist=&task_id=229114590619', null, '1', '2015-07-20 19:36:16', null);
INSERT INTO `sms_validate_code` VALUES ('fb82a03a-2464-4986-bd43-9cec61297e80', '欢迎使用轻松宅智慧社区,您的验证码是:756841;懒人生活,立刻开启。', '13881957318', '756841', 'result=0&description=发送短信成功&taskid=229116353197&faillist=&task_id=229116353197', '1', '1', '2015-07-24 16:37:17', null);

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
INSERT INTO `user` VALUES ('007e031f-5d0b-47c5-b071-3aebaecb1f1a', '乐箩小仙', '2015072217443175530865.jpg', 'E1279148EEF1AA062FAB1A7FB2941465', null, '2', '15008205524', null, null, 'e25c05c1-06d8-4571-8312-be09d4273983', '1', '2015-07-22 17:42:00', null);
INSERT INTO `user` VALUES ('01026999-f8ca-49df-83f9-fc7a2b6c214f', '11212', '', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '11', null, null, null, '2', '2015-07-10 16:12:13', '2015-07-24 11:39:02');
INSERT INTO `user` VALUES ('054eca46-6c68-4d0f-a2c0-95a585fab9b0', '123', '', '202cb962ac59075b964b07152d234b70', null, '1', '224455', null, null, null, '1', '2015-07-09 11:20:12', '2015-07-17 17:43:46');
INSERT INTO `user` VALUES ('0841957d-1e7e-49ad-9b43-07d9d5364d90', 'yi', '', 'e10adc3949ba59abbe56e057f20f883e', null, '1', 'yi', null, null, null, '2', '2015-07-21 11:13:56', '2015-07-21 11:14:26');
INSERT INTO `user` VALUES ('0b1ce2e3-8e87-42f9-b5dd-f222157b9849', '修改昵称', '', 'e807f1fcf82d132f9bb018ca6738a19f', null, '1', '123', null, null, null, '1', '2015-06-10 14:16:17', '2015-07-17 17:43:50');
INSERT INTO `user` VALUES ('157f1ba6-77eb-421f-a20f-94b8b7dd5371', '', '', 'E10ADC3949BA59ABBE56E057F20F883E', null, '2', '18680519173', null, null, '292f5782-5a46-41c4-9979-afec4780fc95', '1', '2015-07-21 08:37:52', null);
INSERT INTO `user` VALUES ('168e8973-ee6e-4fc3-9153-a3138b07ebac', '昵称11', '', '123', null, '6', '22223', null, null, null, '2', '2015-07-14 16:51:53', '2015-07-20 16:11:21');
INSERT INTO `user` VALUES ('18832940-e4c8-466b-8546-3be91b036647', '呵呵1', '', '202cb962ac59075b964b07152d234b70', null, '1', '13123456789', null, null, null, '1', '2015-06-26 01:54:49', '2015-07-17 17:43:59');
INSERT INTO `user` VALUES ('1badd7e1-4ccb-48bd-bd06-2976ce4683ef', '123321w', '', '13', null, '1', '1', null, null, null, '2', '2015-07-03 17:01:47', '2015-07-24 11:16:32');
INSERT INTO `user` VALUES ('1dd6ede6-71d0-4e2c-90f4-2e814bdf824c', '小米2', '', '81dc9bdb52d04dc20036dbd8313ed055', null, '4', '1234', null, null, null, '1', '2015-07-15 11:49:37', '2015-07-17 17:44:07');
INSERT INTO `user` VALUES ('1e0b5afa-fa4c-4f84-be23-7ca3ec4ce8f9', '说的', '', '123', null, '3', '123123', null, null, null, '1', '2015-06-23 10:51:57', '2015-07-17 17:44:10');
INSERT INTO `user` VALUES ('2485362d-355e-43f4-a2c4-2f4da8ebd3ae', '挪威', '2015072411273638853216.jpg', 'E10ADC3949BA59ABBE56E057F20F883E', null, '1', '18111618866', '96E79218965EB72C92A549DD5A330112', null, '4fab4b11-7da6-42b2-ac7a-3bd76886f74a', '1', '2015-06-26 22:48:09', '2015-07-17 17:44:14');
INSERT INTO `user` VALUES ('2a2807b9-fd8b-4deb-a713-5e578712eaf6', '11', '', 'b0baee9d279d34fa1dfd71aadb908c3f', null, '4', '1111', null, '13512312334', null, '1', '2015-07-20 16:23:31', '2015-07-20 17:16:15');
INSERT INTO `user` VALUES ('2cb78647-771b-4f2d-8b26-ba74033bbcdb', '小黑', '', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '黑1', null, null, null, '1', '2015-07-15 14:04:52', '2015-07-28 09:57:14');
INSERT INTO `user` VALUES ('2f404e5c-ae34-4615-8598-c555b27d501e', '10', '', '202cb962ac59075b964b07152d234b70', null, '1', 'sss', null, null, null, '1', '2015-06-10 14:06:57', '2015-07-17 17:44:20');
INSERT INTO `user` VALUES ('314072ac-130a-4d9f-b6f3-abbb5d3c8c2e', 'aaa', '', '0687b8866cf13d6eeed51336cfc0365c', null, '1', 'dddddddd', null, null, null, '1', '2015-07-13 11:30:44', '2015-07-17 17:44:23');
INSERT INTO `user` VALUES ('31bf15b6-7c13-4824-a65a-1ee197ae9254', 'yiyi11', '', 'e10adc3949ba59abbe56e057f20f883e', null, '1', 'yiyi', null, null, null, '1', '2015-07-13 10:51:38', '2015-07-17 17:44:28');
INSERT INTO `user` VALUES ('330d4ed0-a6b2-4f65-a7b6-0afc1d247c46', '44', '', 'f7177163c833dff4b38fc8d2872f1ec6', null, '1', '44', null, null, null, '1', '2015-07-09 16:26:57', '2015-07-17 17:44:31');
INSERT INTO `user` VALUES ('339bbc4c-cda7-452c-8485-eaceb6df45e4', '121', '', 'e10adc3949ba59abbe56e057f20f883e', null, '1', '1231', null, null, null, '1', '2015-07-24 11:38:35', null);
INSERT INTO `user` VALUES ('35f5556b-2751-47ed-973a-1f43e1520fa3', '的说法', '', '123', null, '3', 'df22', null, null, null, '1', '2015-07-09 10:31:11', '2015-07-17 17:44:35');
INSERT INTO `user` VALUES ('37da0158-ff77-467f-8bcf-f1ca1b928e7a', 'sff11', '', '202cb962ac59075b964b07152d234b70', null, '1', '156765', null, null, null, '1', '2015-07-12 16:09:20', '2015-07-17 17:44:39');
INSERT INTO `user` VALUES ('3a96232c-0019-4385-a574-f2248edf7bed', '停机图', '2015072410174468803241.jpg', '96E79218965EB72C92A549DD5A330112', null, '2', '13811111111', '96E79218965EB72C92A549DD5A330112', null, '57a7ad78-1132-4f93-93a1-f8c88bdba890', '1', '2015-07-20 17:31:21', null);
INSERT INTO `user` VALUES ('3ec4c76f-af7d-44d0-845f-82a1cc9b17b6', '222', '', '3d2172418ce305c7d16d4b05597c6a59', null, '4', '222222', null, '18202562532', null, '1', '2015-07-23 14:36:06', null);
INSERT INTO `user` VALUES ('3f3ae625-f950-4318-8842-6c6eb1612186', '', '2015072416390237918347.jpg', 'E10ADC3949BA59ABBE56E057F20F883E', null, '2', '13881957318', '25F9E794323B453885F5181F1B624D0B', null, '9dff5578-519c-458c-aca4-22908b53f3e3', '1', '2015-07-24 16:37:57', null);
INSERT INTO `user` VALUES ('3f4d6e41-8d08-452d-ae65-cd491cf68c1e', '1w', '', '827ccb0eea8a706c4c34a16891f84e7b', null, '1', '1w', null, null, null, '1', '2015-07-13 10:03:12', '2015-07-17 17:44:43');
INSERT INTO `user` VALUES ('3fea6922-51dd-4b2b-8618-cfd84c9ff41d', '12', '', '202cb962ac59075b964b07152d234b70', null, '4', '2222', null, null, null, '1', '2015-07-20 16:56:05', null);
INSERT INTO `user` VALUES ('421c9f74-ebe7-4d76-9591-ea41612975e7', '123', '', '', null, '6', '测试22', null, null, null, '2', '2015-07-14 17:16:23', '2015-07-20 16:11:24');
INSERT INTO `user` VALUES ('4734fd46-bae8-4e8d-9862-976270cbe8b0', '4132432', '', 'bc903fb5330305c6d8160119d4055781', null, '1', '41434', null, null, null, '1', '2015-07-24 11:40:12', null);
INSERT INTO `user` VALUES ('485d6293-aa4f-4d35-82b3-06272c84d7b8', '42314', '', '77472e4d3e1b601a50cfb29be6539a3f', null, '1', '324124', null, null, null, '1', '2015-07-24 11:33:34', null);
INSERT INTO `user` VALUES ('4d3ad4b5-895c-48fd-b4d3-366847442777', '1231', '', '202cb962ac59075b964b07152d234b70', '呵呵', '6', '1234567', null, '13523421233', null, '1', '2015-07-17 11:31:25', '2015-07-20 16:11:47');
INSERT INTO `user` VALUES ('4fe0ac8c-67da-400c-ad71-fb1a3e691cc7', '零', '2015072415322140810742.jpg', '58D2784228A291704D8620D77EFFAEBB', null, '2', '13699716420', null, null, '321847fc-51f4-408c-8bf7-c2306f238077', '1', '2015-07-21 21:02:05', null);
INSERT INTO `user` VALUES ('5415b7db-6b90-49f0-9101-2a225870d859', '', '', '202cb962ac59075b964b07152d234b70', null, '1', 'sss1s', null, null, null, '1', '2015-06-10 14:07:55', '2015-07-17 17:44:53');
INSERT INTO `user` VALUES ('5af4a877-817e-47f4-b40c-1856e7b866bf', '123', '', '202cb962ac59075b964b07152d234b70', '222', '6', '地方', null, '13523456781', null, '1', '2015-07-14 17:17:13', '2015-07-17 17:44:56');
INSERT INTO `user` VALUES ('5c0632e9-5e54-4312-af7a-f4d35b2f026c', 'wwss', '', '202cb962ac59075b964b07152d234b70', null, '4', 'eew', null, null, null, '1', '2015-07-14 19:05:03', '2015-07-17 17:45:36');
INSERT INTO `user` VALUES ('60bda546-aa83-4736-bc59-8c24ae0ec5e3', '', '', '123', null, '3', 'dgh', null, null, null, '1', '2015-06-25 15:26:41', null);
INSERT INTO `user` VALUES ('621436be-6caa-46cd-872b-1b0829db84df', '', '', 'e10adc3949ba59abbe56e057f20f883e', null, '4', 'business_test', null, '13254125415', null, '1', '2015-07-28 16:49:45', null);
INSERT INTO `user` VALUES ('6308786c-f708-44a0-a60f-0194c33004b0', '', '', '698d51a19d8a121ce581499d7b701668', null, '3', '111', null, null, null, '1', '2015-06-10 14:16:53', '2015-07-17 17:45:40');
INSERT INTO `user` VALUES ('64d8783d-d5ff-4d43-b561-0015af6db523', 'sad', '', '123', null, '1', 'kjh', null, null, null, '1', '2015-06-25 13:45:20', null);
INSERT INTO `user` VALUES ('64f1bd0c-1122-42d0-b5bf-4686eafc7d4b', 'aaaaaaaaaaa22', '', 'c162de19c4c3731ca3428769d0cd593d', null, '1', 'aaaaaa', null, null, null, '1', '2015-07-13 11:23:55', '2015-07-17 17:45:26');
INSERT INTO `user` VALUES ('65fcaaba-b537-49a9-8572-caf8f1a973b6', '是实得分', '', '202cb962ac59075b964b07152d234b70', null, '4', '2232', null, null, null, '2', '2015-07-20 17:04:38', '2015-07-23 14:35:46');
INSERT INTO `user` VALUES ('6aebf24d-bb54-443b-8c83-3fc576268a84', 'dsf22', '', '202cb962ac59075b964b07152d234b70', null, '1', 'dsff', null, null, null, '1', '2015-07-14 17:31:36', '2015-07-17 17:45:02');
INSERT INTO `user` VALUES ('6b61f457-e965-47cc-84d5-4a0aa69fbe72', '123', '', '202cb962ac59075b964b07152d234b70', null, '4', '123az', null, null, null, '1', '2015-07-20 10:17:28', null);
INSERT INTO `user` VALUES ('7cafd044-82ff-4c60-a389-962d843f8fe3', '123', '', '202cb962ac59075b964b07152d234b70', '123', '6', '123444', null, '13512312312', null, '1', '2015-07-17 12:02:58', null);
INSERT INTO `user` VALUES ('7cedbafa-f24a-4ba0-bcc8-12da2a66c337', 'wcc', '', 'e10adc3949ba59abbe56e057f20f883e', null, '1', 'wcc', null, null, null, '1', '2015-07-24 09:14:59', null);
INSERT INTO `user` VALUES ('7d2ec9a5-9253-4fef-a49f-6ad0fc309958', '111111111122', '', '9dcbf642c78137f656ba7c24381ac25b', null, '1', '111111111111', null, null, null, '1', '2015-07-13 11:16:25', '2015-07-17 17:45:06');
INSERT INTO `user` VALUES ('8010df99-3b2a-423f-a91c-d56a7d6c30f5', 'dw1', '', '123', null, '1', 'asdfgh', null, null, null, '1', '2015-06-28 10:29:03', '2015-07-17 17:45:10');
INSERT INTO `user` VALUES ('92a98558-2037-4a3e-a5b9-2a79ed04f522', '李小龙', '2015072416385028037186.jpg', 'E10ADC3949BA59ABBE56E057F20F883E', null, '2', '13668128127', 'E10ADC3949BA59ABBE56E057F20F883E', null, 'c2f5096e-3b31-4941-8aa2-299765bcb22a', '1', '2015-07-21 09:36:03', null);
INSERT INTO `user` VALUES ('9333a7f9-b6eb-4819-b744-88ce07136d02', '3214321', '', 'b28b0fd8c9744e7759dc80b3a4bbbc7d', null, '1', '432143', null, null, null, '1', '2015-07-24 11:10:38', null);
INSERT INTO `user` VALUES ('939f1309-4fa5-467c-a06d-13713b597bf7', 'hehe', '', 'e10adc3949ba59abbe56e057f20f883e', null, '4', '123456', null, '18202928765', null, '1', '2015-07-24 09:35:01', null);
INSERT INTO `user` VALUES ('95f266a8-74c8-47b6-853e-1cbb83626ac7', '11', '', 'e3ceb5881a0a1fdaad01296d7554868d', null, '4', '222', null, null, null, '1', '2015-07-15 11:32:05', '2015-07-17 17:45:16');
INSERT INTO `user` VALUES ('9906bb93-990b-4692-a02a-f6b2dcc28a05', '订单', '', '202cb962ac59075b964b07152d234b70', null, '1', 'sss1', null, null, null, '1', '2015-06-10 14:07:05', '2015-07-17 17:45:13');
INSERT INTO `user` VALUES ('9a66ed6e-3d02-44fb-b3be-136c5706c7f6', '的说法', '', '123', null, '1', 'asdasd', null, null, null, '1', '2015-07-07 15:38:48', '2015-07-17 17:45:19');
INSERT INTO `user` VALUES ('9ad6ee95-1eba-4184-90d7-d63527be5227', '111', '', 'c8837b23ff8aaa8a2dde915473ce0991', null, '1', '123321', null, null, null, '1', '2015-07-15 11:10:24', '2015-07-17 17:45:23');
INSERT INTO `user` VALUES ('9cd65155-e843-4e30-a1dc-551d3ad0afa0', '呵呵', '2015072315104360752798.jpg', 'E10ADC3949BA59ABBE56E057F20F883E', null, '2', '13611111111', 'E10ADC3949BA59ABBE56E057F20F883E', null, '92dc88c0-db1e-4e70-9e30-57953c7e3e0a', '1', '2015-07-20 17:23:07', null);
INSERT INTO `user` VALUES ('9dd852d9-4543-4027-94f7-be92cf3a81c7', '4213432', '', 'a5e282468e1011e1118679fc677a6db6', null, '1', '4132432', null, null, null, '1', '2015-07-24 11:33:54', null);
INSERT INTO `user` VALUES ('9de77245-d1ea-418a-a0e7-5c2ca96bba9c', 'aaa', '', 'aaa', null, '1', 'aaa', null, null, null, '1', '2015-07-02 11:33:15', '2015-07-17 17:45:30');
INSERT INTO `user` VALUES ('a1708022-28d7-492f-8aff-8e12733f2440', 'asd', '', '123', null, '3', '111111', null, null, null, '1', '2015-06-19 16:24:50', '2015-07-17 17:45:33');
INSERT INTO `user` VALUES ('a43e7eee-99a6-4228-9ab0-edc03d073495', '的说法', '', '202cb962ac59075b964b07152d234b70', null, '1', '223355', null, null, null, '1', '2015-07-09 14:16:12', '2015-07-17 17:46:24');
INSERT INTO `user` VALUES ('aa46558f-41c9-4d5f-a5a9-15e411124bc6', 'b', '', 'e10adc3949ba59abbe56e057f20f883e', null, '4', 'b', null, null, null, '2', '2015-07-13 15:52:00', '2015-07-24 11:38:24');
INSERT INTO `user` VALUES ('abaf58dd-90f0-4fb1-8e55-e6dc6c879b9f', '123', '', '202cb962ac59075b964b07152d234b70', null, '6', '11224421', null, null, null, '2', '2015-07-14 17:12:42', '2015-07-20 16:11:26');
INSERT INTO `user` VALUES ('abc55120-dcfd-4274-a1aa-d32a1de47beb', '', '', 'AFD6BB6CF82315D526A59B848ADA2E5C', null, '2', '13908180189', null, null, 'e61b66ca-abb7-42b0-8708-f41e6c20f87f', '1', '2015-07-20 20:25:41', null);
INSERT INTO `user` VALUES ('ac4bd342-e3e0-4b10-b650-1ba99f8f8618', '', '', '507AD300AF7EA70D38C79BBBD4AE992B', null, '2', '18980704515', null, null, '96a7c318-4f7c-484f-86b1-c42d27753162', '1', '2015-07-21 09:25:41', null);
INSERT INTO `user` VALUES ('acedb501-ca60-43cf-8108-53c468f923e2', '12122', '', 'a', null, '1', 'a', null, null, null, '1', '2015-07-02 15:14:30', '2015-07-17 17:45:46');
INSERT INTO `user` VALUES ('b7f59965-7ffa-4595-bbc6-37899a57a975', '432143214', '', '27a5791860175ac5c37641356311dfe2', null, '1', '3124', null, null, null, '1', '2015-07-24 11:14:50', null);
INSERT INTO `user` VALUES ('b92c37df-d921-44e9-8121-327c145caff6', '', '', '21232f297a57a5a743894a0e4a801fc3', null, '5', 'admin', null, null, null, '1', '2015-06-09 16:11:31', '2015-07-17 17:46:05');
INSERT INTO `user` VALUES ('be387c4d-7f4f-429c-891a-ec738e314524', '', '', 'E24EA2779AEB960534E8CD0284E88B24', null, '2', '15982119314', null, null, '37423fcb-cb60-4be3-b668-235b63647ecc', '1', '2015-07-22 09:37:51', null);
INSERT INTO `user` VALUES ('beeb3552-8e6e-4c41-8c99-3d114bc90635', '小小', '', '12', null, '1', 'xx', null, null, null, '1', '2015-07-09 14:27:26', '2015-07-17 17:46:21');
INSERT INTO `user` VALUES ('bff1c274-0230-4a25-b497-1e1767c47134', '阿东', '', '202cb962ac59075b964b07152d234b70', null, '4', 'sggw', null, null, null, '1', '2015-07-14 19:59:16', '2015-07-17 17:45:49');
INSERT INTO `user` VALUES ('c1a2d1af-8823-49c8-b979-42d009da41b3', '123', '', '123', null, '6', '24351', null, null, null, '2', '2015-07-14 16:31:09', '2015-07-20 16:11:29');
INSERT INTO `user` VALUES ('c74601c0-1e59-46c4-8510-8f3d5765d8eb', '', '', '202cb962ac59075b964b07152d234b70', null, '1', 'ss', null, null, null, '1', '2015-06-10 14:06:22', '2015-07-17 17:45:59');
INSERT INTO `user` VALUES ('c806ae29-9133-4a96-abcc-e7441ec297d2', 'zl', '', 'e10adc3949ba59abbe56e057f20f883e', null, '1', 'zl', null, null, null, '1', '2015-07-24 09:26:44', null);
INSERT INTO `user` VALUES ('c9b7ddb7-347c-4ee0-a099-43a2016d455b', '111', '', '96e79218965eb72c92a549dd5a330112', null, '1', '1111111', null, null, null, '2', '2015-07-20 15:04:13', '2015-07-20 15:04:33');
INSERT INTO `user` VALUES ('d078d180-8f94-4b7c-a809-cf94a6cbd28a', '', '', 'E10ADC3949BA59ABBE56E057F20F883E', null, '2', '13622222222', null, null, '8fe3fffd-0cf8-4cd9-b5c5-cd7776eeb2f4', '1', '2015-06-19 15:32:29', null);
INSERT INTO `user` VALUES ('d2f7bb33-15cb-4844-8ec2-36eb37963542', '', '', 'e10adc3949ba59abbe56e057f20f883e', null, '1', 'test_user_admin872', null, null, null, '1', '2015-07-28 16:49:45', null);
INSERT INTO `user` VALUES ('d580419b-7f60-4427-baec-c2673b1c0f63', '2ss', '', '25425', null, '1', '242354', null, null, null, '1', '2015-07-02 15:15:06', '2015-07-17 17:46:11');
INSERT INTO `user` VALUES ('d64b08ae-42f2-4c80-bfd1-a5a1a1209839', '阿斯达', '', '123', null, '1', '1212', null, null, null, '1', '2015-06-23 11:05:05', '2015-07-17 17:45:56');
INSERT INTO `user` VALUES ('d847988c-8580-48ba-9426-4cc3da69202d', 'a222', '', '12345678', null, '1', 'aa', null, null, null, '1', '2015-07-03 17:50:59', '2015-07-17 17:46:02');
INSERT INTO `user` VALUES ('da91b7ea-9fd5-4fb0-a411-1c85b3a99b13', '431243', '', '5174b3b426509ae508352856762e2c3a', null, '1', '41243242', null, null, null, '1', '2015-07-24 11:50:06', null);
INSERT INTO `user` VALUES ('db7979a8-5039-4c58-9b7a-05ca5f841fd4', '123', '', '4297f44b13955235245b2497399d7a93', null, '4', '1231223', null, null, null, '1', '2015-07-15 15:13:52', null);
INSERT INTO `user` VALUES ('e36a3a78-79a0-438d-9c8b-c0571df4e3ab', '', '', 'e10adc3949ba59abbe56e057f20f883e', null, '3', 'tenement_test', null, '13625125478', null, '1', '2015-07-28 16:49:45', null);
INSERT INTO `user` VALUES ('e539f72d-73d4-404f-97ba-56ced3c37f85', '', '', 'e10adc3949ba59abbe56e057f20f883e', null, '2', '13668111111', 'e10adc3949ba59abbe56e057f20f883e', null, 'c1d684db-c7f7-482e-b726-28d0c1fa2284', '1', '2015-07-28 16:49:45', null);
INSERT INTO `user` VALUES ('e77f2853-d589-4b07-a582-5624efb2a6b0', 'zl', '', 'fcea920f7412b5da7be0cf42b8c93759', null, '3', 'zli', null, '18202829876', null, '1', '2015-07-24 09:33:53', null);
INSERT INTO `user` VALUES ('f1e04df3-b8d0-46dc-83b5-08d01dd4b8f5', '123', '', '202cb962ac59075b964b07152d234b70', null, '4', '12345', null, null, null, '1', '2015-07-17 10:53:53', '2015-07-17 17:46:08');
INSERT INTO `user` VALUES ('f5d8b2ef-0e7e-4627-873c-1f1fa231911d', '', '', '202cb962ac59075b964b07152d234b70', null, '1', 'sa1', null, null, null, '1', '2015-06-10 14:05:24', '2015-07-17 17:46:27');
INSERT INTO `user` VALUES ('f7048d00-b877-4b16-8375-781acf238873', '小霸王', '2015072317402804247180.jpg', '21218CCA77804D2BA1922C33E0151105', null, '2', '18380478218', 'E10ADC3949BA59ABBE56E057F20F883E', null, '404b47c4-da2c-4cf1-9b8a-579489965809', '1', '2015-06-24 19:19:52', '2015-07-22 13:58:39');
INSERT INTO `user` VALUES ('f8bf1fca-99b9-4ada-81e1-a0083b1f1436', 'fasdf', '', '1d0adae6dcd8cf9422441fb7e27693ed', null, '1', 'fdasf', null, null, null, '1', '2015-07-24 11:11:47', null);
INSERT INTO `user` VALUES ('fba7d3d5-c333-47c8-8497-2a3017e4c81f', '123', '', '202cb962ac59075b964b07152d234b70', '1', '6', '22', null, '13523123134', null, '1', '2015-07-17 11:55:52', '2015-07-20 16:11:54');
INSERT INTO `user` VALUES ('ffc57eff-94c8-4a38-bca4-fc1c36f3f901', '明明2', '', '1bbd886460827015e5d605ed44252251', null, '6', '黎明', null, null, null, '1', '2015-07-15 11:04:23', '2015-07-15 11:05:02');

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
INSERT INTO `user_role_link` VALUES ('01026999-f8ca-49df-83f9-fc7a2b6c214f', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-10 16:12:13', null);
INSERT INTO `user_role_link` VALUES ('054eca46-6c68-4d0f-a2c0-95a585fab9b0', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-09 11:20:12', null);
INSERT INTO `user_role_link` VALUES ('0841957d-1e7e-49ad-9b43-07d9d5364d90', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-21 11:13:56', null);
INSERT INTO `user_role_link` VALUES ('1badd7e1-4ccb-48bd-bd06-2976ce4683ef', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-03 17:01:47', null);
INSERT INTO `user_role_link` VALUES ('1dd6ede6-71d0-4e2c-90f4-2e814bdf824c', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-15 11:49:37', null);
INSERT INTO `user_role_link` VALUES ('1e0b5afa-fa4c-4f84-be23-7ca3ec4ce8f9', '68f23f57-a496-4894-8d50-814ec4296806', '2015-06-23 10:51:57', null);
INSERT INTO `user_role_link` VALUES ('2a2807b9-fd8b-4deb-a713-5e578712eaf6', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-20 16:23:31', null);
INSERT INTO `user_role_link` VALUES ('314072ac-130a-4d9f-b6f3-abbb5d3c8c2e', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-13 11:30:44', null);
INSERT INTO `user_role_link` VALUES ('31bf15b6-7c13-4824-a65a-1ee197ae9254', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-13 10:51:38', null);
INSERT INTO `user_role_link` VALUES ('330d4ed0-a6b2-4f65-a7b6-0afc1d247c46', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-09 16:26:57', null);
INSERT INTO `user_role_link` VALUES ('339bbc4c-cda7-452c-8485-eaceb6df45e4', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-24 11:38:35', null);
INSERT INTO `user_role_link` VALUES ('35f5556b-2751-47ed-973a-1f43e1520fa3', '68f23f57-a496-4894-8d50-814ec4296806', '2015-07-09 10:31:12', null);
INSERT INTO `user_role_link` VALUES ('37da0158-ff77-467f-8bcf-f1ca1b928e7a', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-12 16:09:20', null);
INSERT INTO `user_role_link` VALUES ('3ec4c76f-af7d-44d0-845f-82a1cc9b17b6', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-23 14:36:06', null);
INSERT INTO `user_role_link` VALUES ('3f4d6e41-8d08-452d-ae65-cd491cf68c1e', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-13 10:03:12', null);
INSERT INTO `user_role_link` VALUES ('3fea6922-51dd-4b2b-8618-cfd84c9ff41d', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-20 16:56:05', null);
INSERT INTO `user_role_link` VALUES ('4734fd46-bae8-4e8d-9862-976270cbe8b0', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-24 11:40:12', null);
INSERT INTO `user_role_link` VALUES ('485d6293-aa4f-4d35-82b3-06272c84d7b8', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-24 11:33:34', null);
INSERT INTO `user_role_link` VALUES ('5c0632e9-5e54-4312-af7a-f4d35b2f026c', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-14 19:05:04', null);
INSERT INTO `user_role_link` VALUES ('60bda546-aa83-4736-bc59-8c24ae0ec5e3', '68f23f57-a496-4894-8d50-814ec4296806', '2015-06-25 15:26:41', null);
INSERT INTO `user_role_link` VALUES ('621436be-6caa-46cd-872b-1b0829db84df', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-28 16:49:45', null);
INSERT INTO `user_role_link` VALUES ('64d8783d-d5ff-4d43-b561-0015af6db523', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-06-25 13:45:20', null);
INSERT INTO `user_role_link` VALUES ('64f1bd0c-1122-42d0-b5bf-4686eafc7d4b', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-13 11:23:56', null);
INSERT INTO `user_role_link` VALUES ('65fcaaba-b537-49a9-8572-caf8f1a973b6', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-20 17:05:00', null);
INSERT INTO `user_role_link` VALUES ('6aebf24d-bb54-443b-8c83-3fc576268a84', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-14 17:31:36', null);
INSERT INTO `user_role_link` VALUES ('6b61f457-e965-47cc-84d5-4a0aa69fbe72', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-20 10:17:28', null);
INSERT INTO `user_role_link` VALUES ('7cedbafa-f24a-4ba0-bcc8-12da2a66c337', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-24 09:14:59', null);
INSERT INTO `user_role_link` VALUES ('7d2ec9a5-9253-4fef-a49f-6ad0fc309958', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-13 11:16:25', null);
INSERT INTO `user_role_link` VALUES ('8010df99-3b2a-423f-a91c-d56a7d6c30f5', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-06-28 10:29:03', null);
INSERT INTO `user_role_link` VALUES ('9333a7f9-b6eb-4819-b744-88ce07136d02', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-24 11:10:38', null);
INSERT INTO `user_role_link` VALUES ('939f1309-4fa5-467c-a06d-13713b597bf7', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-24 09:35:01', null);
INSERT INTO `user_role_link` VALUES ('95f266a8-74c8-47b6-853e-1cbb83626ac7', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-15 11:32:05', null);
INSERT INTO `user_role_link` VALUES ('9a66ed6e-3d02-44fb-b3be-136c5706c7f6', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-07 15:38:48', null);
INSERT INTO `user_role_link` VALUES ('9ad6ee95-1eba-4184-90d7-d63527be5227', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-15 11:10:24', null);
INSERT INTO `user_role_link` VALUES ('9dd852d9-4543-4027-94f7-be92cf3a81c7', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-24 11:33:54', null);
INSERT INTO `user_role_link` VALUES ('9de77245-d1ea-418a-a0e7-5c2ca96bba9c', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-02 11:33:15', null);
INSERT INTO `user_role_link` VALUES ('a1708022-28d7-492f-8aff-8e12733f2440', '68f23f57-a496-4894-8d50-814ec4296806', '2015-06-19 16:24:54', null);
INSERT INTO `user_role_link` VALUES ('a43e7eee-99a6-4228-9ab0-edc03d073495', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-09 14:16:12', null);
INSERT INTO `user_role_link` VALUES ('aa46558f-41c9-4d5f-a5a9-15e411124bc6', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-13 15:52:00', null);
INSERT INTO `user_role_link` VALUES ('acedb501-ca60-43cf-8108-53c468f923e2', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-02 15:14:30', null);
INSERT INTO `user_role_link` VALUES ('b7f59965-7ffa-4595-bbc6-37899a57a975', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-24 11:14:50', null);
INSERT INTO `user_role_link` VALUES ('b92c37df-d921-44e9-8121-327c145caff6', '8d688dac-7db5-4506-85e2-d39d085ed1d2', null, null);
INSERT INTO `user_role_link` VALUES ('beeb3552-8e6e-4c41-8c99-3d114bc90635', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-09 14:27:27', null);
INSERT INTO `user_role_link` VALUES ('bff1c274-0230-4a25-b497-1e1767c47134', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-14 19:59:16', null);
INSERT INTO `user_role_link` VALUES ('c806ae29-9133-4a96-abcc-e7441ec297d2', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-24 09:26:44', null);
INSERT INTO `user_role_link` VALUES ('c9b7ddb7-347c-4ee0-a099-43a2016d455b', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-20 15:04:13', null);
INSERT INTO `user_role_link` VALUES ('d2f7bb33-15cb-4844-8ec2-36eb37963542', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-28 16:49:45', null);
INSERT INTO `user_role_link` VALUES ('d580419b-7f60-4427-baec-c2673b1c0f63', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-02 15:15:06', null);
INSERT INTO `user_role_link` VALUES ('d64b08ae-42f2-4c80-bfd1-a5a1a1209839', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-06-23 11:05:05', null);
INSERT INTO `user_role_link` VALUES ('d847988c-8580-48ba-9426-4cc3da69202d', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-03 17:50:59', null);
INSERT INTO `user_role_link` VALUES ('da91b7ea-9fd5-4fb0-a411-1c85b3a99b13', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-24 11:50:06', null);
INSERT INTO `user_role_link` VALUES ('db7979a8-5039-4c58-9b7a-05ca5f841fd4', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-15 15:13:52', null);
INSERT INTO `user_role_link` VALUES ('e36a3a78-79a0-438d-9c8b-c0571df4e3ab', '68f23f57-a496-4894-8d50-814ec4296806', '2015-07-28 16:49:45', null);
INSERT INTO `user_role_link` VALUES ('e77f2853-d589-4b07-a582-5624efb2a6b0', '68f23f57-a496-4894-8d50-814ec4296806', '2015-07-24 09:33:53', null);
INSERT INTO `user_role_link` VALUES ('f1e04df3-b8d0-46dc-83b5-08d01dd4b8f5', '72cb2e61-6ee2-46b4-99f8-b3efdf453c5c', '2015-07-17 10:53:53', null);
INSERT INTO `user_role_link` VALUES ('f8bf1fca-99b9-4ada-81e1-a0083b1f1436', '1dafa9ca-bd88-4061-8740-7a62d8fbbb60', '2015-07-24 11:11:47', null);

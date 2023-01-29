-- nj_nhc_global_online.sys_org definition

CREATE TABLE `sys_org` (
  `id` bigint(20) NOT NULL COMMENT '主键',
  `pid` bigint(20) NOT NULL COMMENT '父id',
  `pids` text NOT NULL COMMENT '父ids',
  `layers` int(11) DEFAULT NULL COMMENT '组织层级，0-省、1-市、2-区（县）、3-街道（乡镇）、4-行政村、5-基层组织',
  `code` varchar(50) NOT NULL COMMENT '组织编码',
  `name` varchar(100) NOT NULL COMMENT '组织名称',
  `org_type` varchar(50) DEFAULT NULL COMMENT '组织类型（001-农民专业合作社、002-家庭农场、003-涉农企业、004-政府机构）',
  `enterprise_code` varchar(100) DEFAULT NULL COMMENT '统一社会信用代码',
  `industry_attribute` varchar(50) DEFAULT NULL COMMENT '行业属性（001-种植业、002-畜牧业、003-渔业、004-农机服务）',
  `account_system` varchar(50) DEFAULT NULL COMMENT '会计制度',
  `link_man` varchar(50) DEFAULT NULL COMMENT '负责人',
  `mobile_phone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `treasurer` varchar(50) DEFAULT NULL COMMENT '财务主管',
  `account_people` varchar(50) DEFAULT NULL COMMENT '会计',
  `cashier` varchar(50) DEFAULT NULL COMMENT '出纳',
  `bank_name` varchar(50) DEFAULT NULL COMMENT '开户银行',
  `account_name` varchar(50) DEFAULT NULL COMMENT '户名',
  `bank_account` varchar(50) DEFAULT NULL COMMENT '银行账号',
  `province` varchar(50) DEFAULT NULL COMMENT '省',
  `city` varchar(50) DEFAULT NULL COMMENT '市',
  `county` varchar(50) DEFAULT NULL COMMENT '区县',
  `street` varchar(50) DEFAULT NULL COMMENT '街道',
  `address` text COMMENT '详细地址',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '组织状态（字典 0正常 1停用 2删除）',
  `enable_module` varchar(200) DEFAULT NULL COMMENT '启用模块',
  `service_start_time` datetime DEFAULT NULL COMMENT '服务期限开始时间',
  `service_end_time` datetime DEFAULT NULL COMMENT '服务期限结束时间',
  `verify` tinyint(4) DEFAULT NULL COMMENT '审核状态（0-待审核、1-通过、2-不通过）',
  `verify_time` datetime DEFAULT NULL COMMENT '审核时间',
  `description` text COMMENT '描述',
  `user_count` int(11) DEFAULT NULL COMMENT '用户数限定数',
  `invitation_code` varchar(50) DEFAULT NULL COMMENT '组织邀请码',
  `org_nature` tinyint(4) DEFAULT NULL COMMENT '组织性质（0-临时组织 1-正式组织  2-已经延期过得组织）',
  `is_register` tinyint(4) DEFAULT NULL COMMENT '是否是用户自行注册的组织（0-否， 1-是）',
  `last_stage` tinyint(4) DEFAULT NULL COMMENT '组织末级字段',
  `sort` tinyint(100) DEFAULT NULL COMMENT '排序',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT NULL COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT NULL COMMENT '更新人',
  `location` varchar(100) DEFAULT NULL COMMENT '所在地区',
  `postal_code` varchar(32) DEFAULT NULL COMMENT '邮编',
  `register_date` datetime DEFAULT NULL COMMENT '注册登记时间',
  `register_amount` decimal(16,2) DEFAULT NULL COMMENT '注册资金（万元）',
  `license` text COMMENT '营业执照',
  `accounting` varchar(100) DEFAULT NULL COMMENT '会计',
  `is_establish_council` int(3) DEFAULT NULL COMMENT '是否成立理事会',
  `board_member` text COMMENT '理事会成员',
  `is_establish_board` int(3) DEFAULT NULL COMMENT '是否成立监事会',
  `supervisors_member` text COMMENT '监事会成员',
  `president` bigint(20) DEFAULT NULL COMMENT '理事长',
  `main_type` int(3) DEFAULT NULL COMMENT '主体类型',
  `demonstration_level` int(3) DEFAULT NULL COMMENT '示范级别',
  `business_range` varchar(100) DEFAULT NULL COMMENT '经营范围',
  `contribution` decimal(16,2) DEFAULT NULL COMMENT '出资总额',
  `establish_date` datetime DEFAULT NULL COMMENT '成立日期',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='系统组织机构表';

INSERT INTO nj_nhc_global_online.sys_org (id,pid,pids,layers,code,name,org_type,enterprise_code,industry_attribute,account_system,link_man,mobile_phone,treasurer,account_people,cashier,bank_name,account_name,bank_account,province,city,county,street,address,status,enable_module,service_start_time,service_end_time,verify,verify_time,description,user_count,invitation_code,org_nature,is_register,last_stage,sort,create_time,create_user,update_time,update_user,location,postal_code,register_date,register_amount,license,accounting,is_establish_council,board_member,is_establish_board,supervisors_member,president,main_type,demonstration_level,business_range,contribution,establish_date) VALUES
	 (1600066928314953730,0,'[0],',0,'1100000000000000','北京',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'11',NULL,NULL,NULL,NULL,0,'007,008,010',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'2022-12-06 17:57:38',1265476890672672808,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 (1600066928373673985,1600066928314953730,'[0],[1600066928314953730],',1,'1101000000000000','北京市',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'11',NULL,NULL,NULL,NULL,0,'007,008,010',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'2022-12-06 17:57:38',1265476890672672808,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 (1600066928449171457,1600066928373673985,'[0],[1600066928314953730],[1600066928373673985],',2,'1101010000000000','东城区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'11',NULL,NULL,NULL,NULL,0,'007,008,010',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'2022-12-06 17:57:38',1265476890672672808,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 (1600066928465948673,1600066928373673985,'[0],[1600066928314953730],[1600066928373673985],',2,'1101020000000000','西城区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'11',NULL,NULL,NULL,NULL,0,'007,008,010',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'2022-12-06 17:57:38',1265476890672672808,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 (1600066928478531586,1600066928373673985,'[0],[1600066928314953730],[1600066928373673985],',2,'1101050000000000','朝阳区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'11',NULL,NULL,NULL,NULL,0,'007,008,010',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'2022-12-06 17:57:38',1265476890672672808,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 (1600066928482725889,1600066928373673985,'[0],[1600066928314953730],[1600066928373673985],',2,'1101060000000000','丰台区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'11',NULL,NULL,NULL,NULL,0,'007,008,010',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'2022-12-06 17:57:38',1265476890672672808,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 (1600066928512086017,1600066928373673985,'[0],[1600066928314953730],[1600066928373673985],',2,'1101070000000000','石景山区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'11',NULL,NULL,NULL,NULL,0,'007,008,010',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'2022-12-06 17:57:38',1265476890672672808,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 (1600066928533057538,1600066928373673985,'[0],[1600066928314953730],[1600066928373673985],',2,'1101080000000000','海淀区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'11',NULL,NULL,NULL,NULL,0,'007,008,010',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'2022-12-06 17:57:38',1265476890672672808,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 (1600066928537251841,1600066928373673985,'[0],[1600066928314953730],[1600066928373673985],',2,'1101090000000000','门头沟区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'11',NULL,NULL,NULL,NULL,0,'007,008,010',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'2022-12-06 17:57:38',1265476890672672808,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),
	 (1600066928541446146,1600066928373673985,'[0],[1600066928314953730],[1600066928373673985],',2,'1101110000000000','房山区',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'11',NULL,NULL,NULL,NULL,0,'007,008,010',NULL,NULL,1,NULL,NULL,NULL,NULL,NULL,0,NULL,NULL,'2022-12-06 17:57:38',1265476890672672808,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);
CREATE TABLE test.`user` (
	id bigint(20) NOT NULL COMMENT '主键',
	name varchar(100) NULL,
	age int(3) NULL,
	sex int(3) NULL,
	CONSTRAINT user_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8;
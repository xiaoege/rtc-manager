/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : rtc

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 09/09/2020 16:35:56
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for india_charge
-- ----------------------------
DROP TABLE IF EXISTS `india_charge`;
CREATE TABLE `india_charge` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) DEFAULT NULL,
  `srn` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '序列号',
  `charge_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '诉讼ID',
  `charge_holder_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '原告名称',
  `date_of_creation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '创建日期 ',
  `date_of_modification` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '改动日期',
  `date_of_satisfaction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '清偿日期',
  `amount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '金额',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地址',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=58485 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for india_cin
-- ----------------------------
DROP TABLE IF EXISTS `india_cin`;
CREATE TABLE `india_cin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `cin` varchar(255) DEFAULT NULL COMMENT 'CIN编号',
  `company_name` varchar(255) DEFAULT NULL COMMENT '企业名称',
  `roc_code` varchar(255) DEFAULT NULL COMMENT 'RoC 编号',
  `registration_number` varchar(255) DEFAULT NULL COMMENT '注册编码',
  `company_category` varchar(255) DEFAULT NULL COMMENT '企业分类',
  `company_sub_category` varchar(255) DEFAULT NULL COMMENT '企业子类',
  `class_of_company` varchar(255) DEFAULT NULL COMMENT '企业类型',
  `authorised_capital` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '法定资本',
  `paid_up_capital` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发行资本',
  `number_of_members` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '成员数',
  `date_of_incorporation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册日期',
  `email_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电子邮件ID ',
  `whether_listed_or_not` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否上市',
  `active_compliant` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'Active 合规',
  `suspended_at_stock_exchange` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '是否停牌',
  `date_of_last_agm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '上次股东大会日期',
  `date_of_balance_sheet` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资产负债表日期',
  `company_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业状态',
  `registered_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册地址',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_enterprise_id` (`enterprise_id`),
  KEY `idx_company_name` (`company_name`)
) ENGINE=InnoDB AUTO_INCREMENT=79561 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for india_llpin
-- ----------------------------
DROP TABLE IF EXISTS `india_llpin`;
CREATE TABLE `india_llpin` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `llpin` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'LLPIN 编号',
  `llp_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业名称',
  `number_of_partners` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '合伙人数',
  `number_of_designated_partners` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '指定合伙人数',
  `roc_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'RoC编号',
  `date_of_incorporation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册日期',
  `registrated_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册地址',
  `email_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电子邮件ID',
  `previous_firm` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '之前公司细节，如果有之',
  `total_obligation_of_contribution` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `main_division_of_business` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '主要在印度开展业务的业务类别',
  `description_of_main_division` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '主要业务类别描述',
  `statement_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '递交上一个财年财务报告的日期',
  `annual_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '递交上一个财年年度报表的日期',
  `llp_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公司状态',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_llp_name` (`llp_name`),
  KEY `idx_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3507 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for india_signatory
-- ----------------------------
DROP TABLE IF EXISTS `india_signatory`;
CREATE TABLE `india_signatory` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `din_pan` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `begin_date` varchar(255) DEFAULT NULL,
  `end_date` varchar(255) DEFAULT NULL,
  `surrendered_din` varchar(255) DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_ enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=169092 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc
-- ----------------------------
DROP TABLE IF EXISTS `qcc`;
CREATE TABLE `qcc` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `rtc_enterprise_uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '对应rtc_enterprise表的uuid',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url` varchar(10200) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `country_region` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '地区',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  `synopsis` varchar(255) DEFAULT NULL COMMENT '简介',
  `nation` varchar(255) DEFAULT NULL COMMENT '国家',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_qcc_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7818 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_administrative_license
-- ----------------------------
DROP TABLE IF EXISTS `qcc_administrative_license`;
CREATE TABLE `qcc_administrative_license` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `decision_document_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '决定文书号',
  `license_authority` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '许可机关',
  `license_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '决定日期',
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '内容',
  `valid_from` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '有效期自',
  `valid_until` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '有效期至',
  `decision_document_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '许可文件名称',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qal_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5469 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_administrative_license_china
-- ----------------------------
DROP TABLE IF EXISTS `qcc_administrative_license_china`;
CREATE TABLE `qcc_administrative_license_china` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL COMMENT '决定文书号',
  `authority` varchar(255) DEFAULT NULL COMMENT '许可机关',
  `decided_date` varchar(255) DEFAULT NULL COMMENT '决定日期',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_qtc_enterprise_id` (`enterprise_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=12319 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_administrative_sanction
-- ----------------------------
DROP TABLE IF EXISTS `qcc_administrative_sanction`;
CREATE TABLE `qcc_administrative_sanction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `determine_document_number` varchar(255) DEFAULT NULL COMMENT '决定文书号',
  `violations_type` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '违法行为类型',
  `content` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '行政处罚内容',
  `publication_date` varchar(255) DEFAULT NULL COMMENT '公示日期',
  `decision_making_organ` varchar(255) DEFAULT NULL COMMENT '决定机关',
  `decision_date` varchar(255) DEFAULT NULL COMMENT '决定日期',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  `punishment_unit` varchar(255) DEFAULT NULL COMMENT '处罚单位',
  `source` varchar(255) DEFAULT NULL COMMENT '数据来源',
  `punishment_date` varchar(255) DEFAULT NULL COMMENT '处罚日期',
  PRIMARY KEY (`id`),
  KEY `idx_qas_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2110 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_annual_report
-- ----------------------------
DROP TABLE IF EXISTS `qcc_annual_report`;
CREATE TABLE `qcc_annual_report` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `year` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '年报年份',
  `unified_social_credit_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '统一社会信用代码',
  `registration_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册号',
  `business_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业经营状态',
  `business_telephone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业联系电话',
  `e_mail` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '电子邮箱',
  `post_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '邮政编码',
  `staff_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '员工人数（可以选择不公示）',
  `equity_transfer` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '有限责任公司本年度是否发生股东股权转让',
  `purchase_equity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业是否有投资信息或购买其他公司股权',
  `postal_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业通讯地址',
  `total_assets` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '资产总额',
  `total_equity` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所有者权益合计',
  `total_operating_income` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '营业总收入',
  `total_profit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '利润总额',
  `net_profit` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '净利润',
  `main_business_income` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '营业总收入中主营业务收入',
  `total_tax` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '纳税总额',
  `total_liabilities` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '负债总额',
  `endowment_insurance` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '城镇职工基本养老保险',
  `medical_insurance` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职工基本医疗保险',
  `maternity_insurance` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '生育保险',
  `unemployment_insurance` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '失业保险',
  `employment_injury_insurance` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工伤保险',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_qar_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34405 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_annual_report_shareholder
-- ----------------------------
DROP TABLE IF EXISTS `qcc_annual_report_shareholder`;
CREATE TABLE `qcc_annual_report_shareholder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `annual_report_uuid` varchar(255) DEFAULT NULL COMMENT '对应qcc_annual_report里的uuid',
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '股东',
  `subscribed_capital` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '认缴出资额(万元)',
  `subscribed_capital_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '认缴出资日期',
  `subscribed_capital_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '认缴出资方式',
  `paid_capital` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '实缴出资额(万元)',
  `paid_capital_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '实缴出资日期',
  `paid_capital_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '实缴出资方式',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qars_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=68764 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_app
-- ----------------------------
DROP TABLE IF EXISTS `qcc_app`;
CREATE TABLE `qcc_app` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称',
  `sort` varchar(255) DEFAULT NULL COMMENT '分类',
  `current_version` varchar(255) DEFAULT NULL COMMENT '当前版本',
  `brief_introduction` varchar(255) DEFAULT NULL COMMENT '简介',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_qapp_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=209 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_applet
-- ----------------------------
DROP TABLE IF EXISTS `qcc_applet`;
CREATE TABLE `qcc_applet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '名称',
  `sort` varchar(255) DEFAULT NULL COMMENT '分类',
  `associated_official_account` varchar(255) DEFAULT NULL COMMENT '关联公众号',
  `predict_reading_volume` varchar(255) DEFAULT NULL COMMENT '公众号预估阅读量',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qapplet_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1084 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_bidding
-- ----------------------------
DROP TABLE IF EXISTS `qcc_bidding`;
CREATE TABLE `qcc_bidding` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '项目名称',
  `release_date` varchar(255) DEFAULT NULL COMMENT '发布日期',
  `province` varchar(255) DEFAULT NULL COMMENT '省份地区',
  `progress` varchar(255) DEFAULT NULL COMMENT '招标进度',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  `announcement_type` varchar(255) DEFAULT NULL COMMENT '公告类型',
  PRIMARY KEY (`id`),
  KEY `idx_qb_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36017 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_business_information
-- ----------------------------
DROP TABLE IF EXISTS `qcc_business_information`;
CREATE TABLE `qcc_business_information` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `business_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '经营状态',
  `establishment_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '成立日期',
  `registered_capital` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册资本',
  `paid_in_capital` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '实缴资本',
  `check_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '核准日期',
  `unified_social_credit_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '统一社会信用代码',
  `organization_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '组织机构代码',
  `business_registration_no` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '工商注册号',
  `taxpayer_registration_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '纳税人识别号',
  `import_export_enterprise_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '进出口企业代码',
  `industry` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属行业',
  `business_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业类型',
  `business_term` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '营业期限',
  `registration_authority` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '登记机关',
  `staff_size` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '人员规模',
  `staff_insured` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '参保人数',
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '所属地区',
  `old_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '曾用名',
  `english_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '英文名',
  `business_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业地址',
  `business_scope` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '经营范围',
  `legal_representative` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '法定代表人',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qbi_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7818 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_change_record
-- ----------------------------
DROP TABLE IF EXISTS `qcc_change_record`;
CREATE TABLE `qcc_change_record` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `change_date` varchar(255) DEFAULT NULL COMMENT '变更日期',
  `change_content` varchar(255) DEFAULT NULL COMMENT '变更项目',
  `before_change` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '变更前',
  `after_change` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '变更后',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_qfc_enterprise_id` (`enterprise_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=51740 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_client
-- ----------------------------
DROP TABLE IF EXISTS `qcc_client`;
CREATE TABLE `qcc_client` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '客户',
  `sale_proportion` varchar(255) DEFAULT NULL COMMENT '销售占比',
  `sale_amount` varchar(255) DEFAULT NULL COMMENT '销售金额(万元)',
  `report_date` varchar(255) DEFAULT NULL COMMENT '报告期',
  `source` varchar(255) DEFAULT NULL COMMENT '数据来源',
  `relationship` varchar(255) DEFAULT NULL COMMENT '关联关系',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qc_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_court_notice
-- ----------------------------
DROP TABLE IF EXISTS `qcc_court_notice`;
CREATE TABLE `qcc_court_notice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `case_code` varchar(255) DEFAULT NULL COMMENT '案号',
  `court_date` varchar(255) DEFAULT NULL COMMENT '开庭时间',
  `reason` varchar(255) DEFAULT NULL COMMENT '案由',
  `litigant` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '当事人',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_qapplet_enterprise_id` (`enterprise_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=26433 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_environmental_punishment
-- ----------------------------
DROP TABLE IF EXISTS `qcc_environmental_punishment`;
CREATE TABLE `qcc_environmental_punishment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL COMMENT '决定书文号',
  `type` varchar(255) DEFAULT NULL COMMENT '违法类型',
  `penalty_unite` varchar(255) DEFAULT NULL COMMENT '处罚单位',
  `penalty_date` varchar(255) DEFAULT NULL COMMENT '处罚日期',
  `implementation` varchar(255) DEFAULT NULL COMMENT '执行情况',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_qk_enterprise_id` (`enterprise_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=130 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_equity_change
-- ----------------------------
DROP TABLE IF EXISTS `qcc_equity_change`;
CREATE TABLE `qcc_equity_change` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `shareholder` varchar(255) DEFAULT NULL COMMENT '股东（发起人）',
  `before` varchar(255) DEFAULT NULL COMMENT '变更前股权比例',
  `after` varchar(255) DEFAULT NULL COMMENT '变更后股权比例',
  `change_date` varchar(255) DEFAULT NULL COMMENT '股权变更日期',
  `release_date` varchar(255) DEFAULT NULL COMMENT '公示日期',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_qfc_enterprise_id` (`enterprise_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1255 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_equity_out_pledge
-- ----------------------------
DROP TABLE IF EXISTS `qcc_equity_out_pledge`;
CREATE TABLE `qcc_equity_out_pledge` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL COMMENT '登记编号',
  `pledgor` varchar(255) DEFAULT NULL COMMENT '出质人',
  `pledgee` varchar(255) DEFAULT NULL COMMENT '质权人',
  `enterprise` varchar(255) DEFAULT NULL COMMENT '出质股权标的企业',
  `amount` varchar(255) DEFAULT NULL COMMENT '出质股权数额(万元)',
  `registration_date` varchar(255) DEFAULT NULL COMMENT '登记日期',
  `pledge_status` varchar(255) DEFAULT NULL COMMENT '状态',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_qas_enterprise_id` (`enterprise_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1489 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_equity_pledge
-- ----------------------------
DROP TABLE IF EXISTS `qcc_equity_pledge`;
CREATE TABLE `qcc_equity_pledge` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '股东名称',
  `shares` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '质押股份总数（股）',
  `value` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '质押股份市值（元）',
  `pledge_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '状态',
  `announcement_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公告日期',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_qweibo_enterprise_id` (`enterprise_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=700 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_filing_information
-- ----------------------------
DROP TABLE IF EXISTS `qcc_filing_information`;
CREATE TABLE `qcc_filing_information` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL COMMENT '案号',
  `prosecutor` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '公诉人/原告/上诉人/申请人',
  `defendant` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '被告人/被告/被上诉人/被申请人',
  `court_name` varchar(255) DEFAULT NULL COMMENT '法院名称',
  `filing_date` varchar(255) DEFAULT NULL COMMENT '立案日期',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qapplet_enterprise_id` (`enterprise_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=5013 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_financing_consultation
-- ----------------------------
DROP TABLE IF EXISTS `qcc_financing_consultation`;
CREATE TABLE `qcc_financing_consultation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL COMMENT '日期',
  `name` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `financing_round` varchar(255) DEFAULT NULL COMMENT '融资轮次',
  `amount` varchar(255) DEFAULT NULL COMMENT '金额',
  `investor` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '投资方',
  `source` varchar(255) DEFAULT NULL COMMENT '新闻来源',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qfc_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=272 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_general_taxpayer
-- ----------------------------
DROP TABLE IF EXISTS `qcc_general_taxpayer`;
CREATE TABLE `qcc_general_taxpayer` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '纳税人名称',
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '纳税人识别号',
  `qualification_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '纳税人资格类型',
  `competent_tax_authority` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '主管税务机关',
  `valid_from` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '有效期起（暂时为varchar）',
  `valid_end` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '有效期止（暂时为varchar）',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qgt_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4533 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_import_export_credit
-- ----------------------------
DROP TABLE IF EXISTS `qcc_import_export_credit`;
CREATE TABLE `qcc_import_export_credit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `registered_customs` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册海关',
  `business_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '经营类别',
  `registration_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '注册日期',
  `content` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '内容',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qiec_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3638 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_judgment_document
-- ----------------------------
DROP TABLE IF EXISTS `qcc_judgment_document`;
CREATE TABLE `qcc_judgment_document` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '裁判文书标题',
  `reason` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '案由',
  `release_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发布日期',
  `case_code` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '案号',
  `case_status` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '案件身份',
  `court_name` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '法院名称',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  `litigant` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '当事人',
  `amount` varchar(255) DEFAULT NULL COMMENT '案件金额（元）',
  `result` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '裁判结果',
  `judgment_date` varchar(255) DEFAULT NULL COMMENT '裁判日期',
  PRIMARY KEY (`id`),
  KEY `idx_qjd_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47947 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_judicial_auction
-- ----------------------------
DROP TABLE IF EXISTS `qcc_judicial_auction`;
CREATE TABLE `qcc_judicial_auction` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `start_price` varchar(255) DEFAULT NULL COMMENT '起拍价（元）',
  `auction_time` varchar(255) DEFAULT NULL COMMENT '拍卖时间',
  `court` varchar(255) DEFAULT NULL COMMENT '委托法院',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_qweibo_enterprise_id` (`enterprise_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1351 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_keyman
-- ----------------------------
DROP TABLE IF EXISTS `qcc_keyman`;
CREATE TABLE `qcc_keyman` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `duty` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '职务',
  `shareholding_ratio` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '持股比例',
  `ultimate_beneficial_shares` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '最终受益股份',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qk_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17161 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_land_purchase_information
-- ----------------------------
DROP TABLE IF EXISTS `qcc_land_purchase_information`;
CREATE TABLE `qcc_land_purchase_information` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL COMMENT '项目位置',
  `purpose` varchar(255) DEFAULT NULL COMMENT '土地用途',
  `area` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '面积（公顷）',
  `administrative_region` varchar(255) DEFAULT NULL COMMENT '行政区',
  `land_supply_mode` varchar(255) DEFAULT NULL COMMENT '供地方式',
  `contract_signing_date` varchar(255) DEFAULT NULL COMMENT '合同签订日期',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qlp_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=881 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_match_summary
-- ----------------------------
DROP TABLE IF EXISTS `qcc_match_summary`;
CREATE TABLE `qcc_match_summary` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '信息录入时间/自动',
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '信息录入时间/自动',
  `status` int DEFAULT '1' COMMENT '是否在用：1是0否',
  PRIMARY KEY (`id`),
  KEY `idx_qms_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7818 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_out_investment
-- ----------------------------
DROP TABLE IF EXISTS `qcc_out_investment`;
CREATE TABLE `qcc_out_investment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '被投资企业名称',
  `legal_representative` varchar(255) DEFAULT NULL COMMENT '法定代表人',
  `registered_capital` varchar(255) DEFAULT NULL COMMENT '注册资本',
  `ratio` varchar(255) DEFAULT NULL COMMENT '投资比例',
  `amount` varchar(255) DEFAULT NULL COMMENT '投资数额',
  `release_date` varchar(255) DEFAULT NULL COMMENT '成立日期',
  `investment_status` varchar(255) DEFAULT NULL COMMENT '状态',
  `round` varchar(255) DEFAULT NULL COMMENT '融资轮次',
  `financing_date` varchar(255) DEFAULT NULL COMMENT '融资日期',
  `products_institutions` varchar(255) DEFAULT NULL COMMENT '关联产品/机构',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_qfc_enterprise_id` (`enterprise_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6453 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_qualification
-- ----------------------------
DROP TABLE IF EXISTS `qcc_qualification`;
CREATE TABLE `qcc_qualification` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '资质类型',
  `code` varchar(255) DEFAULT NULL COMMENT '资质证书号',
  `name` varchar(255) DEFAULT NULL COMMENT '资质名称',
  `release_date` varchar(255) DEFAULT NULL COMMENT '发证日期',
  `validity` varchar(255) DEFAULT NULL COMMENT '证书有效期',
  `authority` varchar(255) DEFAULT NULL COMMENT '发证机关',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_enterprise_id` (`enterprise_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=178 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_qualification_certificate
-- ----------------------------
DROP TABLE IF EXISTS `qcc_qualification_certificate`;
CREATE TABLE `qcc_qualification_certificate` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `certificate_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证书类型',
  `certificate_name` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '证书名称',
  `certificate_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '证书编号',
  `issue_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发证日期',
  `closing_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '截止日期',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qqc_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=19092 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_remove_exception
-- ----------------------------
DROP TABLE IF EXISTS `qcc_remove_exception`;
CREATE TABLE `qcc_remove_exception` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `save_reason` varchar(255) DEFAULT NULL COMMENT '列入经营异常名录原因',
  `desicion_authority` varchar(255) DEFAULT NULL COMMENT '作出决定机关',
  `remove_date` varchar(255) DEFAULT NULL COMMENT '移出日期',
  `remove_reason` varchar(255) DEFAULT NULL COMMENT '移出经营异常名录原因',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  `save_date` varchar(255) DEFAULT NULL COMMENT '列入日期',
  PRIMARY KEY (`id`),
  KEY `idx_qre_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_save_exception
-- ----------------------------
DROP TABLE IF EXISTS `qcc_save_exception`;
CREATE TABLE `qcc_save_exception` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `save_date` varchar(255) DEFAULT NULL COMMENT '列入日期',
  `desicion_authority` varchar(255) DEFAULT NULL COMMENT '作出决定机关',
  `save_reason` varchar(255) DEFAULT NULL COMMENT '列入经营异常名录原因',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qse_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_shareholder
-- ----------------------------
DROP TABLE IF EXISTS `qcc_shareholder`;
CREATE TABLE `qcc_shareholder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '股东',
  `ratio` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '持股比例',
  `subscribed_capital` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '认缴资本（万元）',
  `subscribed_capital_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '认缴出资日期',
  `paid_capital` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '实缴出资额(万元)',
  `paid_capital_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '实缴出资日期',
  `subscribed_capital_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '认缴出资方式',
  `paid_capital_way` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '实缴出资方式',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qs_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16062 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_shareholder_investment
-- ----------------------------
DROP TABLE IF EXISTS `qcc_shareholder_investment`;
CREATE TABLE `qcc_shareholder_investment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `shareholder` varchar(255) DEFAULT NULL COMMENT '股东（发起人）',
  `ratio` varchar(255) DEFAULT NULL COMMENT '持股比例',
  `subscribed_capital` varchar(255) DEFAULT NULL COMMENT '认缴出资额(万元)',
  `subscribed_date` varchar(255) DEFAULT NULL COMMENT '认缴出资日期',
  `publication` varchar(255) DEFAULT NULL COMMENT '认缴公示日期',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_qfc_enterprise_id` (`enterprise_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=6300 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_shareholder_three
-- ----------------------------
DROP TABLE IF EXISTS `qcc_shareholder_three`;
CREATE TABLE `qcc_shareholder_three` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '股东名称',
  `ratio` varchar(255) DEFAULT NULL COMMENT '持股比例',
  `numbers` varchar(255) DEFAULT NULL COMMENT '持股数(股)',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=818 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_software_copyright
-- ----------------------------
DROP TABLE IF EXISTS `qcc_software_copyright`;
CREATE TABLE `qcc_software_copyright` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '软件名称',
  `version` varchar(255) DEFAULT NULL COMMENT '版本号',
  `release_date` varchar(255) DEFAULT NULL COMMENT '发布日期',
  `abbreviation` varchar(255) DEFAULT NULL COMMENT '软件简称',
  `registration_number` varchar(255) DEFAULT NULL COMMENT '登记号',
  `registration_approval_date` varchar(255) DEFAULT NULL COMMENT '登记批准日期',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qsc_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4637 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_spot_check
-- ----------------------------
DROP TABLE IF EXISTS `qcc_spot_check`;
CREATE TABLE `qcc_spot_check` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `organization` varchar(255) DEFAULT NULL COMMENT '检查实施机关',
  `type` varchar(255) DEFAULT NULL COMMENT '类型',
  `inspection_date` varchar(255) DEFAULT NULL COMMENT '日期',
  `result` longtext CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '结果',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_qapp_enterprise_id` (`enterprise_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1825 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_supplier
-- ----------------------------
DROP TABLE IF EXISTS `qcc_supplier`;
CREATE TABLE `qcc_supplier` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '供应商',
  `proportion_of_procurement` varchar(255) DEFAULT NULL COMMENT '采购占比',
  `purchase_amount` varchar(255) DEFAULT NULL COMMENT '采购金额(万元)',
  `report_period` varchar(255) DEFAULT NULL COMMENT '报告期',
  `source` varchar(255) DEFAULT NULL COMMENT '数据来源',
  `relationship` varchar(255) DEFAULT NULL COMMENT '关联关系',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qs_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=942 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_tax_arrears_notice
-- ----------------------------
DROP TABLE IF EXISTS `qcc_tax_arrears_notice`;
CREATE TABLE `qcc_tax_arrears_notice` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL COMMENT '欠税税种',
  `balance` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '欠税余额（元）',
  `current_arrears` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '当前新发生的欠税金额（元）',
  `release_company` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发布单位',
  `release_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '发布日期',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qweibo_enterprise_id` (`enterprise_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_tax_credit
-- ----------------------------
DROP TABLE IF EXISTS `qcc_tax_credit`;
CREATE TABLE `qcc_tax_credit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `year` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '评价年度',
  `taxpayer_identification_number` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '纳税人识别号',
  `tax_credit_rank` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '纳税信用等级',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  `evaluation_cop` varchar(255) DEFAULT NULL COMMENT '评价单位',
  PRIMARY KEY (`id`),
  KEY `idx_qtc_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6102 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_tax_violation
-- ----------------------------
DROP TABLE IF EXISTS `qcc_tax_violation`;
CREATE TABLE `qcc_tax_violation` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `release_date` varchar(255) DEFAULT NULL COMMENT '发布日期',
  `tax_authorities` varchar(255) DEFAULT NULL COMMENT '所属税务机关',
  `case_nature` varchar(255) DEFAULT NULL COMMENT '案件性质',
  `illegal_fact` varchar(255) DEFAULT NULL COMMENT '主要违法事实',
  `basis_punishment` varchar(255) DEFAULT NULL COMMENT '法律依据及处理处罚情况',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_qweibo_enterprise_id` (`enterprise_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_website_information
-- ----------------------------
DROP TABLE IF EXISTS `qcc_website_information`;
CREATE TABLE `qcc_website_information` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `website_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '网站名称',
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '网址',
  `domain_name` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '域名',
  `license_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '网站备案/许可证号',
  `audit_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '审核日期',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qwi_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3027 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_wechat
-- ----------------------------
DROP TABLE IF EXISTS `qcc_wechat`;
CREATE TABLE `qcc_wechat` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '公众号名称',
  `account` varchar(255) DEFAULT NULL COMMENT '微信号',
  `brief_introduction` varchar(255) DEFAULT NULL COMMENT '简介',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qwechat_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=488 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for qcc_weibo
-- ----------------------------
DROP TABLE IF EXISTS `qcc_weibo`;
CREATE TABLE `qcc_weibo` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nickname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '微博昵称',
  `industry_category` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '行业类别',
  `brief_introduction` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '简介',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_qweibo_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1064 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rtc_enterprise
-- ----------------------------
DROP TABLE IF EXISTS `rtc_enterprise`;
CREATE TABLE `rtc_enterprise` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业名称',
  `main_products` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '主要产品',
  `country_region` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '国家/地区',
  `total_revenue` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '总收益',
  `top3_markets` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `trans_6m_times` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `trans_6m_amount` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公司网址',
  `qcc_match` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `qcc_search_string` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '信息录入时间/自动',
  `gmt_update` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '信息修改时间/自动',
  `status` int DEFAULT '1' COMMENT '是否在用：1是0否',
  PRIMARY KEY (`id`),
  KEY `idx_re_uuid` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=4578 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rtc_news
-- ----------------------------
DROP TABLE IF EXISTS `rtc_news`;
CREATE TABLE `rtc_news` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `author` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `source` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '新闻来源',
  `country` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '国家',
  `description` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '描述',
  `preview` varchar(255) DEFAULT NULL COMMENT '预览图',
  `sequence` int DEFAULT NULL COMMENT '展示序列',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rtc_news_check
-- ----------------------------
DROP TABLE IF EXISTS `rtc_news_check`;
CREATE TABLE `rtc_news_check` (
  `id` int NOT NULL AUTO_INCREMENT,
  `url` varchar(255) DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rtc_news_config
-- ----------------------------
DROP TABLE IF EXISTS `rtc_news_config`;
CREATE TABLE `rtc_news_config` (
  `id` int NOT NULL AUTO_INCREMENT,
  `news_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `views` int DEFAULT NULL COMMENT '新闻查看次数',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_news_id` (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rtc_news_detail
-- ----------------------------
DROP TABLE IF EXISTS `rtc_news_detail`;
CREATE TABLE `rtc_news_detail` (
  `id` int NOT NULL AUTO_INCREMENT,
  `news_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '多页新闻对应一个uuid',
  `author` varchar(255) DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `content` longtext,
  `source` varchar(255) DEFAULT NULL COMMENT '新闻来源',
  `country` varchar(255) DEFAULT NULL COMMENT '国家',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_uuid` (`news_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rtc_user
-- ----------------------------
DROP TABLE IF EXISTS `rtc_user`;
CREATE TABLE `rtc_user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT 'token生成规则',
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `country_code` varchar(255) DEFAULT NULL COMMENT '手机号国家代码',
  `email` varchar(255) DEFAULT NULL,
  `salt` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '盐',
  `role_id` int DEFAULT '1' COMMENT '角色',
  `synopsis` varchar(255) DEFAULT NULL COMMENT '简介',
  `country` varchar(255) DEFAULT NULL COMMENT '国家',
  `enterprise` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '公司',
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  `portrait` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`),
  KEY `idx_rtc_user_email` (`email`),
  KEY `idx_rtc_user_nickname` (`nickname`),
  KEY `idx_rtc_phone` (`phone`),
  KEY `idx_phone_nickname` (`phone`,`nickname`),
  KEY `idx_uuid` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rtc_user_authority
-- ----------------------------
DROP TABLE IF EXISTS `rtc_user_authority`;
CREATE TABLE `rtc_user_authority` (
  `id` int NOT NULL AUTO_INCREMENT,
  `authority_name` varchar(255) DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rtc_user_comment
-- ----------------------------
DROP TABLE IF EXISTS `rtc_user_comment`;
CREATE TABLE `rtc_user_comment` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `comment` varchar(1000) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `examination` int DEFAULT '1' COMMENT '审核：0未审核，1审核通过，2审核未通过',
  `enterprise_id` varchar(255) DEFAULT NULL,
  `nation` varchar(255) DEFAULT NULL,
  `e_type` varchar(255) DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_user_id` (`user_id`),
  KEY `idx_enterprise_id` (`enterprise_id`),
  KEY `idx_gmt_create` (`gmt_create`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rtc_user_favourite
-- ----------------------------
DROP TABLE IF EXISTS `rtc_user_favourite`;
CREATE TABLE `rtc_user_favourite` (
  `id` int NOT NULL AUTO_INCREMENT,
  `user_id` varchar(255) DEFAULT NULL,
  `enterprise_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `nation` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '国家',
  `e_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业类型',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_ enterprise_id` (`enterprise_id`),
  KEY `idx_user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=69 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for rtc_user_role
-- ----------------------------
DROP TABLE IF EXISTS `rtc_user_role`;
CREATE TABLE `rtc_user_role` (
  `id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `authority_id` int DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(666) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `address` varchar(1800) DEFAULT NULL,
  `remark` text,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `enterprise_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for vietnam_business_activities
-- ----------------------------
DROP TABLE IF EXISTS `vietnam_business_activities`;
CREATE TABLE `vietnam_business_activities` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '业务代码',
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '业务说明',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_enterprise_id` (`enterprise_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1326607 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for vietnam_enterprise
-- ----------------------------
DROP TABLE IF EXISTS `vietnam_enterprise`;
CREATE TABLE `vietnam_enterprise` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) DEFAULT NULL,
  `enterprise_name` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '企业名称',
  `enterprise_name_in_foreign_language` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业对外名称',
  `enterprise_short_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业简称',
  `enterpirse_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业状态',
  `enterprise_code` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '企业代码',
  `legal_type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '法定类型',
  `founding_date` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '成立日期',
  `representative_first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '代表',
  `head_office_address` text CHARACTER SET utf8 COLLATE utf8_general_ci COMMENT '总部地址',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modified` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`),
  KEY `idx_enterprise_id` (`enterprise_id`)
) ENGINE=InnoDB AUTO_INCREMENT=94294 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;

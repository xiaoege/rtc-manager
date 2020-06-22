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

 Date: 22/06/2020 17:12:11
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for qcc
-- ----------------------------
DROP TABLE IF EXISTS `qcc`;
CREATE TABLE `qcc` (
  `id` int NOT NULL,
  `enterprise_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `telephone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `email` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `country_region` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地区',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of qcc
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for qcc_administrative_license
-- ----------------------------
DROP TABLE IF EXISTS `qcc_administrative_license`;
CREATE TABLE `qcc_administrative_license` (
  `id` int NOT NULL,
  `enterprise_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `decision_document_no` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '决定文书号',
  `license_authority` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '许可机关',
  `license_date` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '决定日期',
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '内容',
  `valid_from` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '有效期自',
  `valid_until` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '有效期至',
  `decision_document_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '许可文件名称',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of qcc_administrative_license
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for qcc_annual_report
-- ----------------------------
DROP TABLE IF EXISTS `qcc_annual_report`;
CREATE TABLE `qcc_annual_report` (
  `id` int NOT NULL,
  `uuid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `enterprise_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `year` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '年报年份',
  `unified_social_credit_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '统一社会信用代码',
  `registration_number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '注册号',
  `business_status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业经营状态',
  `business_telephone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业联系电话',
  `e_mail` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '电子邮箱',
  `post_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '邮政编码',
  `staff_number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '员工人数（可以选择不公示）',
  `equity_transfer` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '有限责任公司本年度是否发生股东股权转让',
  `purchase_equity` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业是否有投资信息或购买其他公司股权',
  `postal_address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业通讯地址',
  `total_assets` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '资产总额',
  `total_equity` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所有者权益合计',
  `total_operating_income` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '营业总收入',
  `total_profit` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '利润总额',
  `net_profit` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '净利润',
  `main_business_income` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '营业总收入中主营业务收入',
  `total_tax` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '纳税总额',
  `total_liabilities` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '负债总额',
  `endowment_insurance` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '城镇职工基本养老保险',
  `medical_insurance` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '职工基本医疗保险',
  `maternity insurance

maternity insurance

maternity_insurance` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '生育保险',
  `unemployment_insurance` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '失业保险',
  `employment_injury_insurance` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '工伤保险',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of qcc_annual_report
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for qcc_business_information
-- ----------------------------
DROP TABLE IF EXISTS `qcc_business_information`;
CREATE TABLE `qcc_business_information` (
  `id` int NOT NULL,
  `enterprise_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `business_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '经营状态',
  `establishment_date` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '成立日期',
  `registered_capital` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '注册资本',
  `paid_in_capital` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '实缴资本',
  `check_date` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '核准日期',
  `unified_social_credit_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '统一社会信用代码',
  `organization_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '组织机构代码',
  `business_registration_no` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '工商注册号',
  `taxpayer_registration_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '纳税人识别号',
  `import_export _enterprise_code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '进出口企业代码',
  `industry` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属行业',
  `business_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业类型',
  `business_term` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '营业期限',
  `registration_authority` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '登记机关',
  `staff_size` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '人员规模',
  `staff_insured` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '参保人数',
  `area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '所属地区',
  `old_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '曾用名',
  `english_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '英文名',
  `business_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业地址',
  `business_scope` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '经营范围',
  `legal_representative` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '法定代表人',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of qcc_business_information
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for qcc_general_taxpayer
-- ----------------------------
DROP TABLE IF EXISTS `qcc_general_taxpayer`;
CREATE TABLE `qcc_general_taxpayer` (
  `id` int NOT NULL,
  `enterprise_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '纳税人名称',
  `code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '纳税人识别号',
  `qualification_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '纳税人资格类型',
  `competent_tax_authority` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '主管税务机关',
  `valid_from` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '有效期起（暂时为varchar）',
  `valid_end` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '有效期止（暂时为varchar）',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of qcc_general_taxpayer
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for qcc_import_export_credit
-- ----------------------------
DROP TABLE IF EXISTS `qcc_import_export_credit`;
CREATE TABLE `qcc_import_export_credit` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `registered_customs` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '注册海关',
  `business_category` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '经营类别',
  `registration_date` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '注册日期',
  `content` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '内容',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of qcc_import_export_credit
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for qcc_judgment_document
-- ----------------------------
DROP TABLE IF EXISTS `qcc_judgment_document`;
CREATE TABLE `qcc_judgment_document` (
  `id` int NOT NULL,
  `enterprise_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `title` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '裁判文书标题',
  `reason` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '案由',
  `release_date` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发布日期',
  `case_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '案号',
  `case_status` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '案件身份',
  `court_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '法院名称',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of qcc_judgment_document
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for qcc_keyman
-- ----------------------------
DROP TABLE IF EXISTS `qcc_keyman`;
CREATE TABLE `qcc_keyman` (
  `id` int NOT NULL,
  `enterprise_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `duty` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '职务',
  `shareholding_ratio` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '持股比例',
  `ultimate_beneficial_shares` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '最终受益股份',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of qcc_keyman
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for qcc_match_summary
-- ----------------------------
DROP TABLE IF EXISTS `qcc_match_summary`;
CREATE TABLE `qcc_match_summary` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '信息录入时间/自动',
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '信息录入时间/自动',
  `status` int DEFAULT '1' COMMENT '是否在用：1是0否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of qcc_match_summary
-- ----------------------------
BEGIN;
INSERT INTO `qcc_match_summary` VALUES (4, '11', 'a', 'b', '2020-06-18 10:47:56', '2020-06-18 10:47:56', 1);
INSERT INTO `qcc_match_summary` VALUES (5, '11', 'a', 'b', '2020-06-18 10:48:33', NULL, 1);
COMMIT;

-- ----------------------------
-- Table structure for qcc_qualification_certificate
-- ----------------------------
DROP TABLE IF EXISTS `qcc_qualification_certificate`;
CREATE TABLE `qcc_qualification_certificate` (
  `id` int NOT NULL,
  `enterprise_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `certificate_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '证书类型',
  `certificate_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '证书名称',
  `certificate_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '证书编号',
  `issue_date` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '发证日期',
  `closing_date` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '截止日期',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of qcc_qualification_certificate
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for qcc_shareholder
-- ----------------------------
DROP TABLE IF EXISTS `qcc_shareholder`;
CREATE TABLE `qcc_shareholder` (
  `id` int NOT NULL AUTO_INCREMENT,
  `enterprise_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '股东',
  `ratio` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '持股比例',
  `subscribed_capital` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '认缴资本（万元）',
  `subscribed_capital_date` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '认缴出资日期',
  `paid_capital` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '实缴出资额(万元)',
  `paid_capital_date` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '实缴出资日期',
  `subscribed_capital_way` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '认缴出资方式',
  `paid_capital_way` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '实缴出资方式',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of qcc_shareholder
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for qcc_tax_credit
-- ----------------------------
DROP TABLE IF EXISTS `qcc_tax_credit`;
CREATE TABLE `qcc_tax_credit` (
  `id` int NOT NULL,
  `enterprise_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `year` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '评价年度',
  `taxpayer_identification_number` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '纳税人识别号',
  `tax_credit_rank` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '纳税信用等级',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of qcc_tax_credit
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for qcc_website_information
-- ----------------------------
DROP TABLE IF EXISTS `qcc_website_information`;
CREATE TABLE `qcc_website_information` (
  `id` int NOT NULL,
  `enterprise_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `website_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '网站名称',
  `url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '网址',
  `domain_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '域名',
  `license_code` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '网站备案/许可证号',
  `audit_date` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '审核日期',
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `gmt_modify` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `status` int DEFAULT '1',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of qcc_website_information
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for rtc_enterprise
-- ----------------------------
DROP TABLE IF EXISTS `rtc_enterprise`;
CREATE TABLE `rtc_enterprise` (
  `id` int NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '企业名称',
  `main_products` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '主要产品',
  `country_region` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '国家/地区',
  `total_revenue` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '总收益',
  `top3_markets` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `trans_6m_times` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `trans_6m_amount` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `url` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '公司网址',
  `qcc_match` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `qcc_search_string` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `gmt_create` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '信息录入时间/自动',
  `gmt_update` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '信息修改时间/自动',
  `status` int DEFAULT '1' COMMENT '是否在用：1是0否',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of rtc_enterprise
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for test
-- ----------------------------
DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- ----------------------------
-- Records of test
-- ----------------------------
BEGIN;
INSERT INTO `test` VALUES (1, '喵帕斯');
INSERT INTO `test` VALUES (12, '喵喵喵');
INSERT INTO `test` VALUES (996, 'aaaa');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;

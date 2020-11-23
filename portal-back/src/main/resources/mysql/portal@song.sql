/*
 Navicat Premium Data Transfer

 Source Server         : linjunjie
 Source Server Type    : MySQL
 Source Server Version : 50730
 Source Host           : 150.158.116.155:3306
 Source Schema         : portal@song

 Target Server Type    : MySQL
 Target Server Version : 50730
 File Encoding         : 65001

 Date: 29/09/2020 17:27:44
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for activity_rule
-- ----------------------------
DROP TABLE IF EXISTS `activity_rule`;
CREATE TABLE `activity_rule`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `awardee_type` tinyint(4) NULL DEFAULT NULL,
  `create_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `event` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `is_delete` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `is_sms_notice` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `priority` tinyint(4) NULL DEFAULT NULL,
  `rule_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `send_award_times` tinyint(4) NULL DEFAULT NULL,
  `task_id` bigint(20) NULL DEFAULT NULL,
  `update_by` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  `rule_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `score` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of activity_rule
-- ----------------------------
INSERT INTO `activity_rule` VALUES ('1', 1, 'admin', '0001-01-01 01:01:01.000000', 'REGISTER', '0', '0', 0, 'telephone == \"13712750156\"', -1, 23, 'lgp', '2018-09-04 16:17:42.000000', '张三规则', '0');
INSERT INTO `activity_rule` VALUES ('2', 2, 'admin', '0001-01-01 01:01:01.000000', 'REGISTER', '0', '0', 0, 'userId== \"123456\"', -1, 24, NULL, '2018-09-04 09:18:04.000000', '李四规则', '0');
INSERT INTO `activity_rule` VALUES ('3', 3, 'admin', '0001-01-01 01:01:01.000000', 'REGISTER', '0', '0', 0, 'telephone == \"13712750166\"', -1, 24, NULL, '2018-09-04 16:17:24.000000', '王二麻规则', '0');
INSERT INTO `activity_rule` VALUES ('4', 4, 'admin', '2020-09-24 14:58:44.000000', 'CUSTOMER', '0', '0', 0, 'annualSalary>=10', -1, 24, NULL, '2020-09-24 14:59:30.000000', '客户规则', '60.0');
INSERT INTO `activity_rule` VALUES ('4028f78174d89cbf0174d89d6f790000', NULL, 'admin', '2020-09-29 14:47:08.833000', 'string', NULL, NULL, NULL, 'string', NULL, NULL, 'admin', '2020-09-29 14:47:08.833000', 'string', '0.0');

-- ----------------------------
-- Table structure for t_account_role
-- ----------------------------
DROP TABLE IF EXISTS `t_account_role`;
CREATE TABLE `t_account_role`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `account_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `creator` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `edit_time` datetime(6) NULL DEFAULT NULL,
  `editor` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_account_role
-- ----------------------------
INSERT INTO `t_account_role` VALUES ('d5dd470bfb2a49d2bd083965f92f6e97', 'Ejef56cJKMCEmlN3Po6cMRKxQ80dwY9q', '2020-08-05 22:22:06.000000', 'Ejef56cJKMCEmlN3Po6cMRKxQ80dwY9q', NULL, NULL, '9f647f53b1e74d4abea1e3622c5b0c48');
INSERT INTO `t_account_role` VALUES ('d5dd470bfb2a49d2bd083965f92f6e98', 'Ejef56cJKMCEmlN3Po6cMRKxQ80dwY9r', '2020-08-06 23:40:39.000000', 'Ejef56cJKMCEmlN3Po6cMRKxQ80dwY9q', NULL, NULL, '9f647f53b1e74d4abea1e3622c5b0c49');

-- ----------------------------
-- Table structure for t_customer_base_info
-- ----------------------------
DROP TABLE IF EXISTS `t_customer_base_info`;
CREATE TABLE `t_customer_base_info`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `account_nature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `annual_salary` double(32, 0) NULL DEFAULT NULL,
  `channel_source` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `company_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `customer_label` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `educational` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `family_size` int(11) NULL DEFAULT NULL,
  `former_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `health_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `id_number` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `industry_type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `length_of_residence` int(11) NULL DEFAULT NULL,
  `marital_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `position` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `profession` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `residence_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `residence_status` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `residential_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `unit_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `unit_detail_address` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `work_phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `working_years` int(11) NULL DEFAULT NULL,
  `loan_to_income_ratio` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `assets_to_liabilities_ratio` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `average_personal_income` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `bank_card_situation` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `breach_of_contract` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `credit_card_default` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `credit_score` double(32, 0) NULL DEFAULT NULL,
  `debt_coverage_ratio` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `family_monthly_income` double NULL DEFAULT NULL,
  `family_property_assessment` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `family_status` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `judicial_records` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `number_of_dependents` int(11) NULL DEFAULT NULL,
  `overdraft_situation` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `records_and_years` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `repayment_record` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `repayment_to_income_ratio` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `responsible` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `delete_status` tinyint(1) NULL DEFAULT 0,
  `complete_status` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT '待完成',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_customer_base_info
-- ----------------------------
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874b3afbe0174b3dae71e0000', 'rural', NULL, NULL, 'referral', '', 'NOresource', 'junior', NULL, '无', 'good', '421123198506070265', '', 1, '未婚', '铜次优', '13238569987', '', '', '湖北省黄冈市浠水县', NULL, '', 'male', '', '', '', 0, NULL, '', '', '', '', '', NULL, '', NULL, '', NULL, '', NULL, '', '', '', '', '赵六', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874b3afbe0174b3e469ec0001', 'rural', NULL, NULL, 'self', '', 'resource', 'junior', NULL, '无', 'good', '421123198606201520', '', NULL, '', '铁憨憨', '13359867556', '', '', '', NULL, '', 'male', '', '', '', NULL, NULL, '', '', '', '', '', NULL, '', NULL, '', NULL, '', NULL, '', '', '', '', '王五', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874b999550174ba094b320000', 'rural', NULL, NULL, 'Manager', '132', 'NOresource', 'general', NULL, '无', 'good', '421123198702056019', 'infomation', NULL, '已婚', '吕轻侯', '13237198875', 'middleLeaders', 'manufacturingPersonnel', '湖北省黄冈市', NULL, '', 'female', '', '454', '456', NULL, NULL, '46456', '', '5', '5', '5', NULL, '555', NULL, '55', NULL, '5', NULL, '5', '55', '55', '555', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874bf3d080174bf571b390000', 'NOrural', NULL, NULL, 'channel', '', 'NOresource', 'doctoral', NULL, '无', 'good', '421123196805067215', '', NULL, '', '贾任意', '13535755594', '', '', '', NULL, '', 'male', '', '', '', NULL, NULL, '', '', '', '', '', NULL, '', NULL, '', NULL, '', NULL, '', '', '', '', '赵六', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874bf3d080174bf5720f20001', 'NOrural', NULL, NULL, 'channel', '', 'NOresource', 'doctoral', NULL, '无', 'good', '421123196805067215', '', NULL, '', '贾任意', '13535755594', '', '', '', NULL, '', 'female', '', '', '', NULL, NULL, '', '', '', '', '', NULL, '', NULL, '', NULL, '', NULL, '', '', '', '', '赵六', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874ce6ba30174ce718c160000', 'rural', NULL, 123, 'Manager', '', 'resource', 'junior', NULL, '无', 'good', '421123199805062602', 'finance', NULL, '已婚', '金有钱', '13239875621', 'middleLeaders', 'soldier', '', NULL, '', 'male', '', '', '5682618', NULL, NULL, '0', '0', '1', '1', '1', 1, '0', 222222, '0', NULL, '1', NULL, '1', '1', '1', '0', '李四', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d38e3c0174d38ef4c00000', '', NULL, 0, 'Manager', '', '', 'doctoral', NULL, '无', '', '421123199702056018', '', NULL, '', '那莹莹', '13237198675', '', '', '', NULL, '', 'male', '', '', '', NULL, NULL, '', '', '', '', '', 0, '', 0, '', NULL, '', 0, '', '', '', '', '王五', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d3a4af0174d3c06e720000', 'rural', NULL, 0, 'Manager', '', 'resource', 'general', NULL, '无', 'good', '421123199702056019', '', NULL, '', '162156', '13237198675', '', '', '', NULL, '', 'female', '', '', '', NULL, NULL, '', '', '', '', '', 0, '', 0, '', NULL, '', 0, '', '', '', '', '李四', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d3a4af0174d3c2eb250001', 'rural', NULL, 0, 'Manager', '', 'resource', 'master', NULL, '无', '', '421123199702056018', '', NULL, '', '林虎从', '13237198675', '', '', '', NULL, '', 'male', '', '', '', NULL, NULL, '', '', '', '', '', 0, '', 0, '', NULL, '', 0, '', '', '', '', '王五', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d3a4af0174d3c6a1ba0002', 'rural', NULL, 0, 'Manager', '', 'resource', '', NULL, '无', '', '421123199702056018', '', NULL, '', '东凡不败', '13237198675', '', '', '', NULL, '', 'male', '', '', '', NULL, NULL, '', '', '', '', '', 0, '', 0, '', NULL, '', 0, '', '', '', '', '王五', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d3c9790174d3d89ca10000', 'rural', NULL, 123, 'Manager', '西部沙漠', 'NOresource', 'primary', NULL, '无', 'good', '421123191002064021', 'culture', NULL, '未婚', '鸠摩智', '13237198675', 'senioreaders', 'technicalPersonnel', '', NULL, '', 'male', '', '某小区', '5682618', NULL, NULL, '1', '1', '2', '2', '2', 2, '1', 123, '1', NULL, '2', 1, '2', '2', '2', '1', '张三', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d3c9790174d3e510f50001', '', NULL, NULL, 'channel', '', '', 'doctoral', NULL, '无', '', '421123199702056018', '', 1, '', '12313132', '13237198675', '', '', '', NULL, '', 'male', '', '', '', 0, NULL, '', '', '', '', '', NULL, '', NULL, '', NULL, '', NULL, '', '', '', '', '王五', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d3c9790174d3fd55ff0002', '', NULL, NULL, 'Manager', '', '', '', NULL, '无', '', '421123199702056018', '', NULL, '', '555555', '13337198675', '', '', '', NULL, '', 'male', '', '', '', NULL, NULL, '', '', '', '', '', NULL, '', NULL, '', NULL, '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d412ec0174d41452bd0000', 'NOrural', NULL, NULL, 'channel', '', 'resource', 'general', NULL, '无1', 'good', '421123199702056018', '', 1, '', '13313', '13237198675', '', '', '', NULL, '', 'male', '', '', '', 0, NULL, '', '', '', '', '', NULL, '', NULL, '', NULL, '', NULL, '', '', '', '', '张三', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d412ec0174d42817d60001', 'rural', NULL, 55, 'Manager', '4', 'resource', 'general', 4, '无', 'good', '421123199702056018', 'infomation', 1, '已婚', '5555555555', '13237198675', 'middleLeaders', 'technicalPersonnel', '', NULL, '', 'male', '', '5', '4', 2, NULL, '5', '5', '5', '5', '5', 5, '5', 55, '5', NULL, '5', 5, '5', '5', '5', '5', '张三', 0, '已完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d74ca70174d754b2ca0000', 'NOrural', NULL, NULL, 'Manager', '', 'resource', 'master', NULL, '无', 'good', '421123199702056018', '', 1, '', '天山童姥', '13237198675', '', '', '', NULL, '', 'male', '', '', '', 0, NULL, '', '', '', '', '', NULL, '', NULL, '', NULL, '', NULL, '', '', '', '', '张三', 0, '已完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d74ca70174d76aa4340001', '', NULL, NULL, 'Manager', '', '', '', NULL, '无', '', '', '', 1, '', '321321321', '', '', '', '', NULL, '', '', '', '', '', 0, NULL, '', '', '', '', '', NULL, '', NULL, '', NULL, '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d74ca70174d77493b90002', 'rural', NULL, 10, 'Manager', '抗金军', 'resource', 'master', 5, '无', 'good', '421123198002063012', 'internationalOrganization', 2, '已婚', '黄蓉', '13237198675', 'senioreaders', 'soldier', '', NULL, '', 'male', '', '襄阳城池', '5682618', 11, NULL, '1', '1', '2', '2', '2', 100, '1', 20, '1', NULL, '2', 3, '2', '2', '2', '1', '李四', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d79c7b0174d7a051e10000', 'rural', '城关', 123, 'self', '抗金军', 'resource', 'doctoral', 5, '无', 'good', '421123199702056013', 'internationalOrganization', 2, '已婚', '郭襄', '13237198675', 'middleLeaders', 'soldier', '', 'dormitory', '', 'female', '', '城关', '5682618', 2, NULL, '0', '0', '11', '111', '11', 100, '0', 123, '0', '父母武功高强', '111', 0, '111', '111', '111', '0', '张三', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7b37fcf0000', 'rural', '', NULL, 'self', '', 'resource', 'master', NULL, '无', 'good', '421123199702056018', '', 1, '', '郭靖', '13237198675', '', '', '', '', '', 'male', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '张三', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7b4dcb00001', 'rural', '', NULL, 'Manager', '', '', 'doctoral', NULL, '无', 'good', '421123199702056019', '', 1, '', '111111', '13237198675', '', '', '', '', '', 'male', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7bfdb3c0002', '', '', NULL, 'Manager', '', '', 'junior', NULL, '无', '', '421123199702056018', '', 1, '', '杨康', '13237198677', '', '', '', '', '', 'male', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '王五', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7c4fd9a0003', 'rural', '', NULL, 'channel', '', 'NOresource', 'vocational', NULL, '无', 'good', '421123197802056018', '', 1, '', '小龙女', '13237198675', '', '', '', '', '', 'male', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '赵六', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7d2c61e0004', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '姚凤凤', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7d862e40005', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7e084f50006', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '999999', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7e092c30007', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '999999', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7e113960008', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '99999', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7e151410009', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '999888', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7e34c8a000a', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '1111222244444', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7e46fc2000b', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '天津南玻万', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7e84d58000c', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '北京南玻万', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7f0d450000d', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '5555554444455', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7f2d89a000e', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '11111111', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7fcb069000f', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7fefd670010', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d7ffe87d0011', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d8010c890012', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d7ab460174d8031dd90013', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d874570174d881c7e20000', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d874570174d882f5d50001', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d874570174d88340ba0002', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d893550174d8972dec0000', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d893550174d899ca190001', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '123456789', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d893550174d89a9f780002', '', '', NULL, '', '', '', '', NULL, '无', '', '', '', 1, '', '', '', '', '', '', '', '', '', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '', 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d8e98d0174d8efbf520001', 'NOrural', '', NULL, 'channel', '', 'resource', 'doctoral', NULL, '无', 'good', '421123199702056018', '', 1, '', '花无缺', '13237198675', '', '', '湖南省娄底市双峰县', '', '', 'male', '', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '王五', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d8e98d0174d90074860004', 'NOrural', '4221', 212, 'Manager', '11', 'resource', 'master', 2, '', 'good', '421123200212031122', 'infomation', 4, '已婚', '你节目你节目', '13213132222', 'generalStaff', 'handler', '湖南省益阳市赫山区', 'Noloan', '24742412', 'male', '211', '12', '2212', 2, '12', '1212', '212', '1221', '21', '2121', 122, '212', 1212, '1212', '2222', '2120', 2121, '2121', '121', '1212', '121', '李四', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d917720174d919387e0000', 'rural', '郭德纲', 42, 'Manager', '34', 'NOresource', 'doctoral', 22, '无', 'good', '421123199702056018', 'finance', 3, '未婚', '小鱼儿', '13237198675', 'middleLeaders', 'handler', '湖南省衡阳市石鼓区', 'noLoan', '天津市天津市南开区', 'male', '天津市天津市红桥区', '123132132', '42434', 2, '423', '3432', '424', '24', '424', '24', 2424, '442', 244, '4244', '32让让对方V个 ', '224', 4, '42', '242', '424', '4242', '赵六', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('2c9085e874d91cfc0174d91e1a5f0000', 'rural', '', NULL, 'channel', '', 'resource', 'general', NULL, '无', 'good', '421122198707089986', '', 1, '', '031212', '13237198675', '', '', '湖北省黄石市下陆区', '', '', 'male', '天津市天津市河西区', '', '', 0, '', '', '', '', '', '', NULL, '', NULL, '', '', '', NULL, '', '', '', '', '张三', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781748b9e0e01748b9edefd0000', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', '删除我1', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 0, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f141ec40000', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', '删除我2', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 0, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1429420001', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f142c440002', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f142ee00003', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', '删除我5', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 0, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f14315a0004', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1433800005', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', '删除我6', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 0, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1435c50006', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', '删除我3', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 0, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1437940007', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', '删除我7', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1439560008', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', '删除我4', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 1, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f143b280009', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f143cf2000a', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f143ea2000b', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', '删除我8', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f144047000c', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', '删除我9', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f144218000d', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1443c4000e', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f144561000f', 'string', NULL, NULL, 'string', 'string', 'resource', 'string', NULL, '无', 'string', '421123199702066012', 'string', NULL, 'string', '钛奈勇', 'string', 'string', 'string', 'string', 'string', 'string', 'male', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', '张三', 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1446f70010', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', '123', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f14489d0011', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', '1313123123321', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f144a2d0012', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', '1321353', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 0, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f144bc80013', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', '213123', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 0, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d55a20014', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', '99999', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 0, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d56620015', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d57250016', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d57b10017', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d65e10018', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d68a20019', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d6a21001a', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d6acb001b', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d6b6b001c', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d6c12001d', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d6caf001e', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d6d45001f', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d6dd30020', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d6e670021', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d6efd0022', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d6f9d0023', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d70340024', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d70c60025', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d71690026', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f781749f022b01749f1d71fe0027', 'string', NULL, NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', NULL, 'string', NULL, 'string', NULL, 'string', 'string', 'string', 'string', NULL, 0, '待完成');
INSERT INTO `t_customer_base_info` VALUES ('4028f78174d880c30174d88b2fad0003', 'string', NULL, 0, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 0, 'string', 0, 'string', NULL, 'string', 0, 'string', 'string', 'string', 'string', 'string', NULL, NULL);
INSERT INTO `t_customer_base_info` VALUES ('4028f78174d880c30174d88b9ccd0004', 'string', NULL, 0, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 0, 'string', 0, 'string', NULL, 'string', 0, 'string', 'string', 'string', 'string', 'string', NULL, NULL);
INSERT INTO `t_customer_base_info` VALUES ('4028f78174d880c30174d88bc6be0005', 'string', NULL, 0, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 0, 'string', 0, 'string', NULL, 'string', 0, 'string', 'string', 'string', 'string', 'string', NULL, NULL);
INSERT INTO `t_customer_base_info` VALUES ('4028f78174d880c30174d88bf0d10006', 'string', NULL, 0, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', 'string', NULL, 'string', 'string', 'string', 'string', 'string', 'string', 0, 'string', 0, 'string', NULL, 'string', 0, 'string', 'string', 'string', 'string', 'string', NULL, NULL);

-- ----------------------------
-- Table structure for t_electronic_contract
-- ----------------------------
DROP TABLE IF EXISTS `t_electronic_contract`;
CREATE TABLE `t_electronic_contract`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `contract_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `contract_type` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `number` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_financial_product
-- ----------------------------
DROP TABLE IF EXISTS `t_financial_product`;
CREATE TABLE `t_financial_product`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `product_name` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_interface_info
-- ----------------------------
DROP TABLE IF EXISTS `t_interface_info`;
CREATE TABLE `t_interface_info`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `introduction` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `permission_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_interface_info
-- ----------------------------
INSERT INTO `t_interface_info` VALUES ('40280981740ff0e201740ff50fb50000', '给权限添加接口', '6893d8c2efce42eda7d8b0d4fe621391', '/sys/admin/addInterface4Permission');
INSERT INTO `t_interface_info` VALUES ('4028098174100c0c0174101382880000', '查看当前登录用户信息', '6893d8c2efce42eda7d8b0d4fe621391', '/sys/getAccountInfo');

-- ----------------------------
-- Table structure for t_ledger
-- ----------------------------
DROP TABLE IF EXISTS `t_ledger`;
CREATE TABLE `t_ledger`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `amount` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `content` varchar(250) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `group_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `record_time` date NULL DEFAULT NULL,
  `subject` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `update_time` datetime(6) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_people
-- ----------------------------
DROP TABLE IF EXISTS `t_people`;
CREATE TABLE `t_people`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `age` int(11) NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `sex` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_relationship
-- ----------------------------
DROP TABLE IF EXISTS `t_relationship`;
CREATE TABLE `t_relationship`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `master_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `relationship_info_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `servant_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_relationship_info
-- ----------------------------
DROP TABLE IF EXISTS `t_relationship_info`;
CREATE TABLE `t_relationship_info`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `add_time` datetime(6) NULL DEFAULT NULL,
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `remark` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_role_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_role_permission`;
CREATE TABLE `t_role_permission`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `creator` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `edit_time` datetime(6) NULL DEFAULT NULL,
  `editor` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `permission_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_role_permission
-- ----------------------------
INSERT INTO `t_role_permission` VALUES ('3380feab36f84db88168270ba87ff125', '2020-08-05 22:23:02.000000', 'Ejef56cJKMCEmlN3Po6cMRKxQ80dwY9q', NULL, NULL, '6893d8c2efce42eda7d8b0d4fe621391', '9f647f53b1e74d4abea1e3622c5b0c48');
INSERT INTO `t_role_permission` VALUES ('3380feab36f84db88168270ba87ff126', '2020-08-21 10:28:46.000000', 'Ejef56cJKMCEmlN3Po6cMRKxQ80dwY9q', NULL, NULL, '6893d8c2efce42eda7d8b0d4fe621392', '9f647f53b1e74d4abea1e3622c5b0c48');

-- ----------------------------
-- Table structure for t_sys_account
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_account`;
CREATE TABLE `t_sys_account`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `avatar` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `del_flag` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `department` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `enabled` bit(1) NULL DEFAULT NULL,
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `login_time` datetime(6) NULL DEFAULT NULL,
  `mail_address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `username` varchar(12) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_account
-- ----------------------------
INSERT INTO `t_sys_account` VALUES ('Ejef56cJKMCEmlN3Po6cMRKxQ80dwY9q', NULL, '2020-03-21 16:23:55.000000', NULL, NULL, b'1', NULL, '2020-09-29 17:06:49.844000', NULL, '147369', NULL, 'admin');
INSERT INTO `t_sys_account` VALUES ('Ejef56cJKMCEmlN3Po6cMRKxQ80dwY9r', NULL, '2020-08-06 23:39:33.000000', NULL, NULL, b'1', NULL, NULL, NULL, '900420', NULL, 'finance');

-- ----------------------------
-- Table structure for t_sys_department
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_department`;
CREATE TABLE `t_sys_department`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `creator` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `editor` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_sys_permission
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_permission`;
CREATE TABLE `t_sys_permission`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `creator` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `edit_time` datetime(6) NULL DEFAULT NULL,
  `editor` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_permission
-- ----------------------------
INSERT INTO `t_sys_permission` VALUES ('6893d8c2efce42eda7d8b0d4fe621391', '0', '2020-08-05 22:19:20.000000', 'Ejef56cJKMCEmlN3Po6cMRKxQ80dwY9q', NULL, NULL, '查看', 'ADD', NULL);
INSERT INTO `t_sys_permission` VALUES ('6893d8c2efce42eda7d8b0d4fe621392', '1', '2020-08-05 22:19:20.000000', 'Ejef56cJKMCEmlN3Po6cMRKxQ80dwY9q', NULL, NULL, '查看', 'GET', NULL);

-- ----------------------------
-- Table structure for t_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `t_sys_role`;
CREATE TABLE `t_sys_role`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `code` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `create_time` datetime(6) NULL DEFAULT NULL,
  `creator` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `edit_time` datetime(6) NULL DEFAULT NULL,
  `editor` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `intro` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '角色介绍',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  `parent_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of t_sys_role
-- ----------------------------
INSERT INTO `t_sys_role` VALUES ('40280981740962c8017409ba37bf0000', '2', '2020-08-20 10:37:10.789000', 'admin', '2020-08-20 10:37:10.789000', 'admin', '总经理', 'GM', '0');
INSERT INTO `t_sys_role` VALUES ('9f647f53b1e74d4abea1e3622c5b0c48', '0', '2020-08-05 22:17:40.000000', 'Ejef56cJKMCEmlN3Po6cMRKxQ80dwY9q', NULL, NULL, '管理员', 'ADMIN', NULL);
INSERT INTO `t_sys_role` VALUES ('9f647f53b1e74d4abea1e3622c5b0c49', '1', '2020-08-05 22:17:40.000000', 'Ejef56cJKMCEmlN3Po6cMRKxQ80dwY9q', NULL, NULL, '财务', 'FINANCE', NULL);

-- ----------------------------
-- Table structure for t_variable
-- ----------------------------
DROP TABLE IF EXISTS `t_variable`;
CREATE TABLE `t_variable`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for t_variable_group
-- ----------------------------
DROP TABLE IF EXISTS `t_variable_group`;
CREATE TABLE `t_variable_group`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;

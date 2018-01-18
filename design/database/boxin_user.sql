/*
Navicat MySQL Data Transfer

Source Server         : boxin_dev
Source Server Version : 50628
Source Host           : 192.168.2.223:3306
Source Database       : boxin_user

Target Server Type    : MYSQL
Target Server Version : 50628
File Encoding         : 65001

Date: 2017-07-10 15:56:22
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `bx_dict_area`
-- ----------------------------
DROP TABLE IF EXISTS `bx_dict_area`;
CREATE TABLE `bx_dict_area` (
  `code` int(6) NOT NULL COMMENT '地区编码_6位数字',
  `name` varchar(50) NOT NULL COMMENT '地区名称',
  `parent_code` int(6) NOT NULL DEFAULT '0' COMMENT '父级行政区划编码,0则为顶层',
  `level` int(6) NOT NULL DEFAULT '1' COMMENT '级别,1为省,2为市级,3为县级',
  PRIMARY KEY (`code`),
  KEY `index_parent_code` (`parent_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='中国行政区域划分信息表';

-- ----------------------------
-- Records of bx_dict_area
-- ----------------------------
INSERT INTO `bx_dict_area` VALUES ('110000', '北京市', '0', '1');
INSERT INTO `bx_dict_area` VALUES ('110100', '市辖区', '110000', '2');
INSERT INTO `bx_dict_area` VALUES ('110101', '东城区', '110100', '3');
INSERT INTO `bx_dict_area` VALUES ('110102', '西城区', '110100', '3');
INSERT INTO `bx_dict_area` VALUES ('110105', '朝阳区', '110100', '3');
INSERT INTO `bx_dict_area` VALUES ('110106', '丰台区', '110100', '3');
INSERT INTO `bx_dict_area` VALUES ('110107', '石景山区', '110100', '3');
INSERT INTO `bx_dict_area` VALUES ('110108', '海淀区', '110100', '3');
INSERT INTO `bx_dict_area` VALUES ('110109', '门头沟区', '110100', '3');
INSERT INTO `bx_dict_area` VALUES ('110111', '房山区', '110100', '3');
INSERT INTO `bx_dict_area` VALUES ('110112', '通州区', '110100', '3');
INSERT INTO `bx_dict_area` VALUES ('110113', '顺义区', '110100', '3');
INSERT INTO `bx_dict_area` VALUES ('110114', '昌平区', '110100', '3');
INSERT INTO `bx_dict_area` VALUES ('110115', '大兴区', '110100', '3');
INSERT INTO `bx_dict_area` VALUES ('110116', '怀柔区', '110100', '3');
INSERT INTO `bx_dict_area` VALUES ('110117', '平谷区', '110100', '3');
INSERT INTO `bx_dict_area` VALUES ('110200', '县', '110000', '2');
INSERT INTO `bx_dict_area` VALUES ('110228', '密云县', '110200', '3');
INSERT INTO `bx_dict_area` VALUES ('110229', '延庆县', '110200', '3');
INSERT INTO `bx_dict_area` VALUES ('120000', '天津市', '0', '1');
INSERT INTO `bx_dict_area` VALUES ('120100', '市辖区', '120000', '2');
INSERT INTO `bx_dict_area` VALUES ('120101', '和平区', '120100', '3');
INSERT INTO `bx_dict_area` VALUES ('120102', '河东区', '120100', '3');
INSERT INTO `bx_dict_area` VALUES ('120103', '河西区', '120100', '3');
INSERT INTO `bx_dict_area` VALUES ('120104', '南开区', '120100', '3');
INSERT INTO `bx_dict_area` VALUES ('120105', '河北区', '120100', '3');
INSERT INTO `bx_dict_area` VALUES ('120106', '红桥区', '120100', '3');
INSERT INTO `bx_dict_area` VALUES ('120110', '东丽区', '120100', '3');
INSERT INTO `bx_dict_area` VALUES ('120111', '西青区', '120100', '3');
INSERT INTO `bx_dict_area` VALUES ('120112', '津南区', '120100', '3');
INSERT INTO `bx_dict_area` VALUES ('120113', '北辰区', '120100', '3');
INSERT INTO `bx_dict_area` VALUES ('120114', '武清区', '120100', '3');
INSERT INTO `bx_dict_area` VALUES ('120115', '宝坻区', '120100', '3');
INSERT INTO `bx_dict_area` VALUES ('120116', '滨海新区', '120100', '3');
INSERT INTO `bx_dict_area` VALUES ('120200', '县', '120000', '2');
INSERT INTO `bx_dict_area` VALUES ('120221', '宁河县', '120200', '3');
INSERT INTO `bx_dict_area` VALUES ('120223', '静海县', '120200', '3');
INSERT INTO `bx_dict_area` VALUES ('120225', '蓟县', '120200', '3');
INSERT INTO `bx_dict_area` VALUES ('130000', '河北省', '0', '1');
INSERT INTO `bx_dict_area` VALUES ('130100', '石家庄市', '130000', '2');
INSERT INTO `bx_dict_area` VALUES ('130101', '市辖区', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130102', '长安区', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130104', '桥西区', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130105', '新华区', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130107', '井陉矿区', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130108', '裕华区', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130109', '藁城区', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130110', '鹿泉区', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130111', '栾城区', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130121', '井陉县', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130123', '正定县', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130125', '行唐县', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130126', '灵寿县', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130127', '高邑县', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130128', '深泽县', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130129', '赞皇县', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130130', '无极县', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130131', '平山县', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130132', '元氏县', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130133', '赵县', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130181', '辛集市', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130183', '晋州市', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130184', '新乐市', '130100', '3');
INSERT INTO `bx_dict_area` VALUES ('130200', '唐山市', '130000', '2');
INSERT INTO `bx_dict_area` VALUES ('130201', '市辖区', '130200', '3');
INSERT INTO `bx_dict_area` VALUES ('130202', '路南区', '130200', '3');
INSERT INTO `bx_dict_area` VALUES ('130203', '路北区', '130200', '3');
INSERT INTO `bx_dict_area` VALUES ('130204', '古冶区', '130200', '3');
INSERT INTO `bx_dict_area` VALUES ('130205', '开平区', '130200', '3');
INSERT INTO `bx_dict_area` VALUES ('130207', '丰南区', '130200', '3');
INSERT INTO `bx_dict_area` VALUES ('130208', '丰润区', '130200', '3');
INSERT INTO `bx_dict_area` VALUES ('130209', '曹妃甸区', '130200', '3');
INSERT INTO `bx_dict_area` VALUES ('130223', '滦县', '130200', '3');
INSERT INTO `bx_dict_area` VALUES ('130224', '滦南县', '130200', '3');
INSERT INTO `bx_dict_area` VALUES ('130225', '乐亭县', '130200', '3');
INSERT INTO `bx_dict_area` VALUES ('130227', '迁西县', '130200', '3');
INSERT INTO `bx_dict_area` VALUES ('130229', '玉田县', '130200', '3');
INSERT INTO `bx_dict_area` VALUES ('130281', '遵化市', '130200', '3');
INSERT INTO `bx_dict_area` VALUES ('130283', '迁安市', '130200', '3');
INSERT INTO `bx_dict_area` VALUES ('130300', '秦皇岛市', '130000', '2');
INSERT INTO `bx_dict_area` VALUES ('130301', '市辖区', '130300', '3');
INSERT INTO `bx_dict_area` VALUES ('130302', '海港区', '130300', '3');
INSERT INTO `bx_dict_area` VALUES ('130303', '山海关区', '130300', '3');
INSERT INTO `bx_dict_area` VALUES ('130304', '北戴河区', '130300', '3');
INSERT INTO `bx_dict_area` VALUES ('130321', '青龙满族自治县', '130300', '3');
INSERT INTO `bx_dict_area` VALUES ('130322', '昌黎县', '130300', '3');
INSERT INTO `bx_dict_area` VALUES ('130323', '抚宁县', '130300', '3');
INSERT INTO `bx_dict_area` VALUES ('130324', '卢龙县', '130300', '3');
INSERT INTO `bx_dict_area` VALUES ('130400', '邯郸市', '130000', '2');
INSERT INTO `bx_dict_area` VALUES ('130401', '市辖区', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130402', '邯山区', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130403', '丛台区', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130404', '复兴区', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130406', '峰峰矿区', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130421', '邯郸县', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130423', '临漳县', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130424', '成安县', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130425', '大名县', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130426', '涉县', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130427', '磁县', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130428', '肥乡县', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130429', '永年县', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130430', '邱县', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130431', '鸡泽县', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130432', '广平县', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130433', '馆陶县', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130434', '魏县', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130435', '曲周县', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130481', '武安市', '130400', '3');
INSERT INTO `bx_dict_area` VALUES ('130500', '邢台市', '130000', '2');
INSERT INTO `bx_dict_area` VALUES ('130501', '市辖区', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130502', '桥东区', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130503', '桥西区', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130521', '邢台县', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130522', '临城县', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130523', '内丘县', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130524', '柏乡县', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130525', '隆尧县', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130526', '任县', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130527', '南和县', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130528', '宁晋县', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130529', '巨鹿县', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130530', '新河县', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130531', '广宗县', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130532', '平乡县', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130533', '威县', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130534', '清河县', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130535', '临西县', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130581', '南宫市', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130582', '沙河市', '130500', '3');
INSERT INTO `bx_dict_area` VALUES ('130600', '保定市', '130000', '2');
INSERT INTO `bx_dict_area` VALUES ('130601', '市辖区', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130602', '新市区', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130603', '北市区', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130604', '南市区', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130621', '满城县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130622', '清苑县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130623', '涞水县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130624', '阜平县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130625', '徐水县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130626', '定兴县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130627', '唐县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130628', '高阳县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130629', '容城县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130630', '涞源县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130631', '望都县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130632', '安新县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130633', '易县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130634', '曲阳县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130635', '蠡县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130636', '顺平县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130637', '博野县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130638', '雄县', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130681', '涿州市', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130682', '定州市', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130683', '安国市', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130684', '高碑店市', '130600', '3');
INSERT INTO `bx_dict_area` VALUES ('130700', '张家口市', '130000', '2');
INSERT INTO `bx_dict_area` VALUES ('130701', '市辖区', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130702', '桥东区', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130703', '桥西区', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130705', '宣化区', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130706', '下花园区', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130721', '宣化县', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130722', '张北县', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130723', '康保县', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130724', '沽源县', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130725', '尚义县', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130726', '蔚县', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130727', '阳原县', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130728', '怀安县', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130729', '万全县', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130730', '怀来县', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130731', '涿鹿县', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130732', '赤城县', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130733', '崇礼县', '130700', '3');
INSERT INTO `bx_dict_area` VALUES ('130800', '承德市', '130000', '2');
INSERT INTO `bx_dict_area` VALUES ('130801', '市辖区', '130800', '3');
INSERT INTO `bx_dict_area` VALUES ('130802', '双桥区', '130800', '3');
INSERT INTO `bx_dict_area` VALUES ('130803', '双滦区', '130800', '3');
INSERT INTO `bx_dict_area` VALUES ('130804', '鹰手营子矿区', '130800', '3');
INSERT INTO `bx_dict_area` VALUES ('130821', '承德县', '130800', '3');
INSERT INTO `bx_dict_area` VALUES ('130822', '兴隆县', '130800', '3');
INSERT INTO `bx_dict_area` VALUES ('130823', '平泉县', '130800', '3');
INSERT INTO `bx_dict_area` VALUES ('130824', '滦平县', '130800', '3');
INSERT INTO `bx_dict_area` VALUES ('130825', '隆化县', '130800', '3');
INSERT INTO `bx_dict_area` VALUES ('130826', '丰宁满族自治县', '130800', '3');
INSERT INTO `bx_dict_area` VALUES ('130827', '宽城满族自治县', '130800', '3');
INSERT INTO `bx_dict_area` VALUES ('130828', '围场满族蒙古族自治县', '130800', '3');
INSERT INTO `bx_dict_area` VALUES ('130900', '沧州市', '130000', '2');
INSERT INTO `bx_dict_area` VALUES ('130901', '市辖区', '130900', '3');
INSERT INTO `bx_dict_area` VALUES ('130902', '新华区', '130900', '3');
INSERT INTO `bx_dict_area` VALUES ('130903', '运河区', '130900', '3');
INSERT INTO `bx_dict_area` VALUES ('130921', '沧县', '130900', '3');
INSERT INTO `bx_dict_area` VALUES ('130922', '青县', '130900', '3');
INSERT INTO `bx_dict_area` VALUES ('130923', '东光县', '130900', '3');
INSERT INTO `bx_dict_area` VALUES ('130924', '海兴县', '130900', '3');
INSERT INTO `bx_dict_area` VALUES ('130925', '盐山县', '130900', '3');
INSERT INTO `bx_dict_area` VALUES ('130926', '肃宁县', '130900', '3');
INSERT INTO `bx_dict_area` VALUES ('130927', '南皮县', '130900', '3');
INSERT INTO `bx_dict_area` VALUES ('130928', '吴桥县', '130900', '3');
INSERT INTO `bx_dict_area` VALUES ('130929', '献县', '130900', '3');
INSERT INTO `bx_dict_area` VALUES ('130930', '孟村回族自治县', '130900', '3');
INSERT INTO `bx_dict_area` VALUES ('130981', '泊头市', '130900', '3');
INSERT INTO `bx_dict_area` VALUES ('130982', '任丘市', '130900', '3');
INSERT INTO `bx_dict_area` VALUES ('130983', '黄骅市', '130900', '3');
INSERT INTO `bx_dict_area` VALUES ('130984', '河间市', '130900', '3');
INSERT INTO `bx_dict_area` VALUES ('131000', '廊坊市', '130000', '2');
INSERT INTO `bx_dict_area` VALUES ('131001', '市辖区', '131000', '3');
INSERT INTO `bx_dict_area` VALUES ('131002', '安次区', '131000', '3');
INSERT INTO `bx_dict_area` VALUES ('131003', '广阳区', '131000', '3');
INSERT INTO `bx_dict_area` VALUES ('131022', '固安县', '131000', '3');
INSERT INTO `bx_dict_area` VALUES ('131023', '永清县', '131000', '3');
INSERT INTO `bx_dict_area` VALUES ('131024', '香河县', '131000', '3');
INSERT INTO `bx_dict_area` VALUES ('131025', '大城县', '131000', '3');
INSERT INTO `bx_dict_area` VALUES ('131026', '文安县', '131000', '3');
INSERT INTO `bx_dict_area` VALUES ('131028', '大厂回族自治县', '131000', '3');
INSERT INTO `bx_dict_area` VALUES ('131081', '霸州市', '131000', '3');
INSERT INTO `bx_dict_area` VALUES ('131082', '三河市', '131000', '3');
INSERT INTO `bx_dict_area` VALUES ('131100', '衡水市', '130000', '2');
INSERT INTO `bx_dict_area` VALUES ('131101', '市辖区', '131100', '3');
INSERT INTO `bx_dict_area` VALUES ('131102', '桃城区', '131100', '3');
INSERT INTO `bx_dict_area` VALUES ('131121', '枣强县', '131100', '3');
INSERT INTO `bx_dict_area` VALUES ('131122', '武邑县', '131100', '3');
INSERT INTO `bx_dict_area` VALUES ('131123', '武强县', '131100', '3');
INSERT INTO `bx_dict_area` VALUES ('131124', '饶阳县', '131100', '3');
INSERT INTO `bx_dict_area` VALUES ('131125', '安平县', '131100', '3');
INSERT INTO `bx_dict_area` VALUES ('131126', '故城县', '131100', '3');
INSERT INTO `bx_dict_area` VALUES ('131127', '景县', '131100', '3');
INSERT INTO `bx_dict_area` VALUES ('131128', '阜城县', '131100', '3');
INSERT INTO `bx_dict_area` VALUES ('131181', '冀州市', '131100', '3');
INSERT INTO `bx_dict_area` VALUES ('131182', '深州市', '131100', '3');
INSERT INTO `bx_dict_area` VALUES ('140000', '山西省', '0', '1');
INSERT INTO `bx_dict_area` VALUES ('140100', '太原市', '140000', '2');
INSERT INTO `bx_dict_area` VALUES ('140101', '市辖区', '140100', '3');
INSERT INTO `bx_dict_area` VALUES ('140105', '小店区', '140100', '3');
INSERT INTO `bx_dict_area` VALUES ('140106', '迎泽区', '140100', '3');
INSERT INTO `bx_dict_area` VALUES ('140107', '杏花岭区', '140100', '3');
INSERT INTO `bx_dict_area` VALUES ('140108', '尖草坪区', '140100', '3');
INSERT INTO `bx_dict_area` VALUES ('140109', '万柏林区', '140100', '3');
INSERT INTO `bx_dict_area` VALUES ('140110', '晋源区', '140100', '3');
INSERT INTO `bx_dict_area` VALUES ('140121', '清徐县', '140100', '3');
INSERT INTO `bx_dict_area` VALUES ('140122', '阳曲县', '140100', '3');
INSERT INTO `bx_dict_area` VALUES ('140123', '娄烦县', '140100', '3');
INSERT INTO `bx_dict_area` VALUES ('140181', '古交市', '140100', '3');
INSERT INTO `bx_dict_area` VALUES ('140200', '大同市', '140000', '2');
INSERT INTO `bx_dict_area` VALUES ('140201', '市辖区', '140200', '3');
INSERT INTO `bx_dict_area` VALUES ('140202', '城区', '140200', '3');
INSERT INTO `bx_dict_area` VALUES ('140203', '矿区', '140200', '3');
INSERT INTO `bx_dict_area` VALUES ('140211', '南郊区', '140200', '3');
INSERT INTO `bx_dict_area` VALUES ('140212', '新荣区', '140200', '3');
INSERT INTO `bx_dict_area` VALUES ('140221', '阳高县', '140200', '3');
INSERT INTO `bx_dict_area` VALUES ('140222', '天镇县', '140200', '3');
INSERT INTO `bx_dict_area` VALUES ('140223', '广灵县', '140200', '3');
INSERT INTO `bx_dict_area` VALUES ('140224', '灵丘县', '140200', '3');
INSERT INTO `bx_dict_area` VALUES ('140225', '浑源县', '140200', '3');
INSERT INTO `bx_dict_area` VALUES ('140226', '左云县', '140200', '3');
INSERT INTO `bx_dict_area` VALUES ('140227', '大同县', '140200', '3');
INSERT INTO `bx_dict_area` VALUES ('140300', '阳泉市', '140000', '2');
INSERT INTO `bx_dict_area` VALUES ('140301', '市辖区', '140300', '3');
INSERT INTO `bx_dict_area` VALUES ('140302', '城区', '140300', '3');
INSERT INTO `bx_dict_area` VALUES ('140303', '矿区', '140300', '3');
INSERT INTO `bx_dict_area` VALUES ('140311', '郊区', '140300', '3');
INSERT INTO `bx_dict_area` VALUES ('140321', '平定县', '140300', '3');
INSERT INTO `bx_dict_area` VALUES ('140322', '盂县', '140300', '3');
INSERT INTO `bx_dict_area` VALUES ('140400', '长治市', '140000', '2');
INSERT INTO `bx_dict_area` VALUES ('140401', '市辖区', '140400', '3');
INSERT INTO `bx_dict_area` VALUES ('140402', '城区', '140400', '3');
INSERT INTO `bx_dict_area` VALUES ('140411', '郊区', '140400', '3');
INSERT INTO `bx_dict_area` VALUES ('140421', '长治县', '140400', '3');
INSERT INTO `bx_dict_area` VALUES ('140423', '襄垣县', '140400', '3');
INSERT INTO `bx_dict_area` VALUES ('140424', '屯留县', '140400', '3');
INSERT INTO `bx_dict_area` VALUES ('140425', '平顺县', '140400', '3');
INSERT INTO `bx_dict_area` VALUES ('140426', '黎城县', '140400', '3');
INSERT INTO `bx_dict_area` VALUES ('140427', '壶关县', '140400', '3');
INSERT INTO `bx_dict_area` VALUES ('140428', '长子县', '140400', '3');
INSERT INTO `bx_dict_area` VALUES ('140429', '武乡县', '140400', '3');
INSERT INTO `bx_dict_area` VALUES ('140430', '沁县', '140400', '3');
INSERT INTO `bx_dict_area` VALUES ('140431', '沁源县', '140400', '3');
INSERT INTO `bx_dict_area` VALUES ('140481', '潞城市', '140400', '3');
INSERT INTO `bx_dict_area` VALUES ('140500', '晋城市', '140000', '2');
INSERT INTO `bx_dict_area` VALUES ('140501', '市辖区', '140500', '3');
INSERT INTO `bx_dict_area` VALUES ('140502', '城区', '140500', '3');
INSERT INTO `bx_dict_area` VALUES ('140521', '沁水县', '140500', '3');
INSERT INTO `bx_dict_area` VALUES ('140522', '阳城县', '140500', '3');
INSERT INTO `bx_dict_area` VALUES ('140524', '陵川县', '140500', '3');
INSERT INTO `bx_dict_area` VALUES ('140525', '泽州县', '140500', '3');
INSERT INTO `bx_dict_area` VALUES ('140581', '高平市', '140500', '3');
INSERT INTO `bx_dict_area` VALUES ('140600', '朔州市', '140000', '2');
INSERT INTO `bx_dict_area` VALUES ('140601', '市辖区', '140600', '3');
INSERT INTO `bx_dict_area` VALUES ('140602', '朔城区', '140600', '3');
INSERT INTO `bx_dict_area` VALUES ('140603', '平鲁区', '140600', '3');
INSERT INTO `bx_dict_area` VALUES ('140621', '山阴县', '140600', '3');
INSERT INTO `bx_dict_area` VALUES ('140622', '应县', '140600', '3');
INSERT INTO `bx_dict_area` VALUES ('140623', '右玉县', '140600', '3');
INSERT INTO `bx_dict_area` VALUES ('140624', '怀仁县', '140600', '3');
INSERT INTO `bx_dict_area` VALUES ('140700', '晋中市', '140000', '2');
INSERT INTO `bx_dict_area` VALUES ('140701', '市辖区', '140700', '3');
INSERT INTO `bx_dict_area` VALUES ('140702', '榆次区', '140700', '3');
INSERT INTO `bx_dict_area` VALUES ('140721', '榆社县', '140700', '3');
INSERT INTO `bx_dict_area` VALUES ('140722', '左权县', '140700', '3');
INSERT INTO `bx_dict_area` VALUES ('140723', '和顺县', '140700', '3');
INSERT INTO `bx_dict_area` VALUES ('140724', '昔阳县', '140700', '3');
INSERT INTO `bx_dict_area` VALUES ('140725', '寿阳县', '140700', '3');
INSERT INTO `bx_dict_area` VALUES ('140726', '太谷县', '140700', '3');
INSERT INTO `bx_dict_area` VALUES ('140727', '祁县', '140700', '3');
INSERT INTO `bx_dict_area` VALUES ('140728', '平遥县', '140700', '3');
INSERT INTO `bx_dict_area` VALUES ('140729', '灵石县', '140700', '3');
INSERT INTO `bx_dict_area` VALUES ('140781', '介休市', '140700', '3');
INSERT INTO `bx_dict_area` VALUES ('140800', '运城市', '140000', '2');
INSERT INTO `bx_dict_area` VALUES ('140801', '市辖区', '140800', '3');
INSERT INTO `bx_dict_area` VALUES ('140802', '盐湖区', '140800', '3');
INSERT INTO `bx_dict_area` VALUES ('140821', '临猗县', '140800', '3');
INSERT INTO `bx_dict_area` VALUES ('140822', '万荣县', '140800', '3');
INSERT INTO `bx_dict_area` VALUES ('140823', '闻喜县', '140800', '3');
INSERT INTO `bx_dict_area` VALUES ('140824', '稷山县', '140800', '3');
INSERT INTO `bx_dict_area` VALUES ('140825', '新绛县', '140800', '3');
INSERT INTO `bx_dict_area` VALUES ('140826', '绛县', '140800', '3');
INSERT INTO `bx_dict_area` VALUES ('140827', '垣曲县', '140800', '3');
INSERT INTO `bx_dict_area` VALUES ('140828', '夏县', '140800', '3');
INSERT INTO `bx_dict_area` VALUES ('140829', '平陆县', '140800', '3');
INSERT INTO `bx_dict_area` VALUES ('140830', '芮城县', '140800', '3');
INSERT INTO `bx_dict_area` VALUES ('140881', '永济市', '140800', '3');
INSERT INTO `bx_dict_area` VALUES ('140882', '河津市', '140800', '3');
INSERT INTO `bx_dict_area` VALUES ('140900', '忻州市', '140000', '2');
INSERT INTO `bx_dict_area` VALUES ('140901', '市辖区', '140900', '3');
INSERT INTO `bx_dict_area` VALUES ('140902', '忻府区', '140900', '3');
INSERT INTO `bx_dict_area` VALUES ('140921', '定襄县', '140900', '3');
INSERT INTO `bx_dict_area` VALUES ('140922', '五台县', '140900', '3');
INSERT INTO `bx_dict_area` VALUES ('140923', '代县', '140900', '3');
INSERT INTO `bx_dict_area` VALUES ('140924', '繁峙县', '140900', '3');
INSERT INTO `bx_dict_area` VALUES ('140925', '宁武县', '140900', '3');
INSERT INTO `bx_dict_area` VALUES ('140926', '静乐县', '140900', '3');
INSERT INTO `bx_dict_area` VALUES ('140927', '神池县', '140900', '3');
INSERT INTO `bx_dict_area` VALUES ('140928', '五寨县', '140900', '3');
INSERT INTO `bx_dict_area` VALUES ('140929', '岢岚县', '140900', '3');
INSERT INTO `bx_dict_area` VALUES ('140930', '河曲县', '140900', '3');
INSERT INTO `bx_dict_area` VALUES ('140931', '保德县', '140900', '3');
INSERT INTO `bx_dict_area` VALUES ('140932', '偏关县', '140900', '3');
INSERT INTO `bx_dict_area` VALUES ('140981', '原平市', '140900', '3');
INSERT INTO `bx_dict_area` VALUES ('141000', '临汾市', '140000', '2');
INSERT INTO `bx_dict_area` VALUES ('141001', '市辖区', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141002', '尧都区', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141021', '曲沃县', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141022', '翼城县', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141023', '襄汾县', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141024', '洪洞县', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141025', '古县', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141026', '安泽县', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141027', '浮山县', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141028', '吉县', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141029', '乡宁县', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141030', '大宁县', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141031', '隰县', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141032', '永和县', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141033', '蒲县', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141034', '汾西县', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141081', '侯马市', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141082', '霍州市', '141000', '3');
INSERT INTO `bx_dict_area` VALUES ('141100', '吕梁市', '140000', '2');
INSERT INTO `bx_dict_area` VALUES ('141101', '市辖区', '141100', '3');
INSERT INTO `bx_dict_area` VALUES ('141102', '离石区', '141100', '3');
INSERT INTO `bx_dict_area` VALUES ('141121', '文水县', '141100', '3');
INSERT INTO `bx_dict_area` VALUES ('141122', '交城县', '141100', '3');
INSERT INTO `bx_dict_area` VALUES ('141123', '兴县', '141100', '3');
INSERT INTO `bx_dict_area` VALUES ('141124', '临县', '141100', '3');
INSERT INTO `bx_dict_area` VALUES ('141125', '柳林县', '141100', '3');
INSERT INTO `bx_dict_area` VALUES ('141126', '石楼县', '141100', '3');
INSERT INTO `bx_dict_area` VALUES ('141127', '岚县', '141100', '3');
INSERT INTO `bx_dict_area` VALUES ('141128', '方山县', '141100', '3');
INSERT INTO `bx_dict_area` VALUES ('141129', '中阳县', '141100', '3');
INSERT INTO `bx_dict_area` VALUES ('141130', '交口县', '141100', '3');
INSERT INTO `bx_dict_area` VALUES ('141181', '孝义市', '141100', '3');
INSERT INTO `bx_dict_area` VALUES ('141182', '汾阳市', '141100', '3');
INSERT INTO `bx_dict_area` VALUES ('150000', '内蒙古自治区', '0', '1');
INSERT INTO `bx_dict_area` VALUES ('150100', '呼和浩特市', '150000', '2');
INSERT INTO `bx_dict_area` VALUES ('150101', '市辖区', '150100', '3');
INSERT INTO `bx_dict_area` VALUES ('150102', '新城区', '150100', '3');
INSERT INTO `bx_dict_area` VALUES ('150103', '回民区', '150100', '3');
INSERT INTO `bx_dict_area` VALUES ('150104', '玉泉区', '150100', '3');
INSERT INTO `bx_dict_area` VALUES ('150105', '赛罕区', '150100', '3');
INSERT INTO `bx_dict_area` VALUES ('150121', '土默特左旗', '150100', '3');
INSERT INTO `bx_dict_area` VALUES ('150122', '托克托县', '150100', '3');
INSERT INTO `bx_dict_area` VALUES ('150123', '和林格尔县', '150100', '3');
INSERT INTO `bx_dict_area` VALUES ('150124', '清水河县', '150100', '3');
INSERT INTO `bx_dict_area` VALUES ('150125', '武川县', '150100', '3');
INSERT INTO `bx_dict_area` VALUES ('150200', '包头市', '150000', '2');
INSERT INTO `bx_dict_area` VALUES ('150201', '市辖区', '150200', '3');
INSERT INTO `bx_dict_area` VALUES ('150202', '东河区', '150200', '3');
INSERT INTO `bx_dict_area` VALUES ('150203', '昆都仑区', '150200', '3');
INSERT INTO `bx_dict_area` VALUES ('150204', '青山区', '150200', '3');
INSERT INTO `bx_dict_area` VALUES ('150205', '石拐区', '150200', '3');
INSERT INTO `bx_dict_area` VALUES ('150206', '白云鄂博矿区', '150200', '3');
INSERT INTO `bx_dict_area` VALUES ('150207', '九原区', '150200', '3');
INSERT INTO `bx_dict_area` VALUES ('150221', '土默特右旗', '150200', '3');
INSERT INTO `bx_dict_area` VALUES ('150222', '固阳县', '150200', '3');
INSERT INTO `bx_dict_area` VALUES ('150223', '达尔罕茂明安联合旗', '150200', '3');
INSERT INTO `bx_dict_area` VALUES ('150300', '乌海市', '150000', '2');
INSERT INTO `bx_dict_area` VALUES ('150301', '市辖区', '150300', '3');
INSERT INTO `bx_dict_area` VALUES ('150302', '海勃湾区', '150300', '3');
INSERT INTO `bx_dict_area` VALUES ('150303', '海南区', '150300', '3');
INSERT INTO `bx_dict_area` VALUES ('150304', '乌达区', '150300', '3');
INSERT INTO `bx_dict_area` VALUES ('150400', '赤峰市', '150000', '2');
INSERT INTO `bx_dict_area` VALUES ('150401', '市辖区', '150400', '3');
INSERT INTO `bx_dict_area` VALUES ('150402', '红山区', '150400', '3');
INSERT INTO `bx_dict_area` VALUES ('150403', '元宝山区', '150400', '3');
INSERT INTO `bx_dict_area` VALUES ('150404', '松山区', '150400', '3');
INSERT INTO `bx_dict_area` VALUES ('150421', '阿鲁科尔沁旗', '150400', '3');
INSERT INTO `bx_dict_area` VALUES ('150422', '巴林左旗', '150400', '3');
INSERT INTO `bx_dict_area` VALUES ('150423', '巴林右旗', '150400', '3');
INSERT INTO `bx_dict_area` VALUES ('150424', '林西县', '150400', '3');
INSERT INTO `bx_dict_area` VALUES ('150425', '克什克腾旗', '150400', '3');
INSERT INTO `bx_dict_area` VALUES ('150426', '翁牛特旗', '150400', '3');
INSERT INTO `bx_dict_area` VALUES ('150428', '喀喇沁旗', '150400', '3');
INSERT INTO `bx_dict_area` VALUES ('150429', '宁城县', '150400', '3');
INSERT INTO `bx_dict_area` VALUES ('150430', '敖汉旗', '150400', '3');
INSERT INTO `bx_dict_area` VALUES ('150500', '通辽市', '150000', '2');
INSERT INTO `bx_dict_area` VALUES ('150501', '市辖区', '150500', '3');
INSERT INTO `bx_dict_area` VALUES ('150502', '科尔沁区', '150500', '3');
INSERT INTO `bx_dict_area` VALUES ('150521', '科尔沁左翼中旗', '150500', '3');
INSERT INTO `bx_dict_area` VALUES ('150522', '科尔沁左翼后旗', '150500', '3');
INSERT INTO `bx_dict_area` VALUES ('150523', '开鲁县', '150500', '3');
INSERT INTO `bx_dict_area` VALUES ('150524', '库伦旗', '150500', '3');
INSERT INTO `bx_dict_area` VALUES ('150525', '奈曼旗', '150500', '3');
INSERT INTO `bx_dict_area` VALUES ('150526', '扎鲁特旗', '150500', '3');
INSERT INTO `bx_dict_area` VALUES ('150581', '霍林郭勒市', '150500', '3');
INSERT INTO `bx_dict_area` VALUES ('150600', '鄂尔多斯市', '150000', '2');
INSERT INTO `bx_dict_area` VALUES ('150601', '市辖区', '150600', '3');
INSERT INTO `bx_dict_area` VALUES ('150602', '东胜区', '150600', '3');
INSERT INTO `bx_dict_area` VALUES ('150621', '达拉特旗', '150600', '3');
INSERT INTO `bx_dict_area` VALUES ('150622', '准格尔旗', '150600', '3');
INSERT INTO `bx_dict_area` VALUES ('150623', '鄂托克前旗', '150600', '3');
INSERT INTO `bx_dict_area` VALUES ('150624', '鄂托克旗', '150600', '3');
INSERT INTO `bx_dict_area` VALUES ('150625', '杭锦旗', '150600', '3');
INSERT INTO `bx_dict_area` VALUES ('150626', '乌审旗', '150600', '3');
INSERT INTO `bx_dict_area` VALUES ('150627', '伊金霍洛旗', '150600', '3');
INSERT INTO `bx_dict_area` VALUES ('150700', '呼伦贝尔市', '150000', '2');
INSERT INTO `bx_dict_area` VALUES ('150701', '市辖区', '150700', '3');
INSERT INTO `bx_dict_area` VALUES ('150702', '海拉尔区', '150700', '3');
INSERT INTO `bx_dict_area` VALUES ('150703', '扎赉诺尔区', '150700', '3');
INSERT INTO `bx_dict_area` VALUES ('150721', '阿荣旗', '150700', '3');
INSERT INTO `bx_dict_area` VALUES ('150722', '莫力达瓦达斡尔族自治旗', '150700', '3');
INSERT INTO `bx_dict_area` VALUES ('150723', '鄂伦春自治旗', '150700', '3');
INSERT INTO `bx_dict_area` VALUES ('150724', '鄂温克族自治旗', '150700', '3');
INSERT INTO `bx_dict_area` VALUES ('150725', '陈巴尔虎旗', '150700', '3');
INSERT INTO `bx_dict_area` VALUES ('150726', '新巴尔虎左旗', '150700', '3');
INSERT INTO `bx_dict_area` VALUES ('150727', '新巴尔虎右旗', '150700', '3');
INSERT INTO `bx_dict_area` VALUES ('150781', '满洲里市', '150700', '3');
INSERT INTO `bx_dict_area` VALUES ('150782', '牙克石市', '150700', '3');
INSERT INTO `bx_dict_area` VALUES ('150783', '扎兰屯市', '150700', '3');
INSERT INTO `bx_dict_area` VALUES ('150784', '额尔古纳市', '150700', '3');
INSERT INTO `bx_dict_area` VALUES ('150785', '根河市', '150700', '3');
INSERT INTO `bx_dict_area` VALUES ('150800', '巴彦淖尔市', '150000', '2');
INSERT INTO `bx_dict_area` VALUES ('150801', '市辖区', '150800', '3');
INSERT INTO `bx_dict_area` VALUES ('150802', '临河区', '150800', '3');
INSERT INTO `bx_dict_area` VALUES ('150821', '五原县', '150800', '3');
INSERT INTO `bx_dict_area` VALUES ('150822', '磴口县', '150800', '3');
INSERT INTO `bx_dict_area` VALUES ('150823', '乌拉特前旗', '150800', '3');
INSERT INTO `bx_dict_area` VALUES ('150824', '乌拉特中旗', '150800', '3');
INSERT INTO `bx_dict_area` VALUES ('150825', '乌拉特后旗', '150800', '3');
INSERT INTO `bx_dict_area` VALUES ('150826', '杭锦后旗', '150800', '3');
INSERT INTO `bx_dict_area` VALUES ('150900', '乌兰察布市', '150000', '2');
INSERT INTO `bx_dict_area` VALUES ('150901', '市辖区', '150900', '3');
INSERT INTO `bx_dict_area` VALUES ('150902', '集宁区', '150900', '3');
INSERT INTO `bx_dict_area` VALUES ('150921', '卓资县', '150900', '3');
INSERT INTO `bx_dict_area` VALUES ('150922', '化德县', '150900', '3');
INSERT INTO `bx_dict_area` VALUES ('150923', '商都县', '150900', '3');
INSERT INTO `bx_dict_area` VALUES ('150924', '兴和县', '150900', '3');
INSERT INTO `bx_dict_area` VALUES ('150925', '凉城县', '150900', '3');
INSERT INTO `bx_dict_area` VALUES ('150926', '察哈尔右翼前旗', '150900', '3');
INSERT INTO `bx_dict_area` VALUES ('150927', '察哈尔右翼中旗', '150900', '3');
INSERT INTO `bx_dict_area` VALUES ('150928', '察哈尔右翼后旗', '150900', '3');
INSERT INTO `bx_dict_area` VALUES ('150929', '四子王旗', '150900', '3');
INSERT INTO `bx_dict_area` VALUES ('150981', '丰镇市', '150900', '3');
INSERT INTO `bx_dict_area` VALUES ('152200', '兴安盟', '150000', '2');
INSERT INTO `bx_dict_area` VALUES ('152201', '乌兰浩特市', '152200', '3');
INSERT INTO `bx_dict_area` VALUES ('152202', '阿尔山市', '152200', '3');
INSERT INTO `bx_dict_area` VALUES ('152221', '科尔沁右翼前旗', '152200', '3');
INSERT INTO `bx_dict_area` VALUES ('152222', '科尔沁右翼中旗', '152200', '3');
INSERT INTO `bx_dict_area` VALUES ('152223', '扎赉特旗', '152200', '3');
INSERT INTO `bx_dict_area` VALUES ('152224', '突泉县', '152200', '3');
INSERT INTO `bx_dict_area` VALUES ('152500', '锡林郭勒盟', '150000', '2');
INSERT INTO `bx_dict_area` VALUES ('152501', '二连浩特市', '152500', '3');
INSERT INTO `bx_dict_area` VALUES ('152502', '锡林浩特市', '152500', '3');
INSERT INTO `bx_dict_area` VALUES ('152522', '阿巴嘎旗', '152500', '3');
INSERT INTO `bx_dict_area` VALUES ('152523', '苏尼特左旗', '152500', '3');
INSERT INTO `bx_dict_area` VALUES ('152524', '苏尼特右旗', '152500', '3');
INSERT INTO `bx_dict_area` VALUES ('152525', '东乌珠穆沁旗', '152500', '3');
INSERT INTO `bx_dict_area` VALUES ('152526', '西乌珠穆沁旗', '152500', '3');
INSERT INTO `bx_dict_area` VALUES ('152527', '太仆寺旗', '152500', '3');
INSERT INTO `bx_dict_area` VALUES ('152528', '镶黄旗', '152500', '3');
INSERT INTO `bx_dict_area` VALUES ('152529', '正镶白旗', '152500', '3');
INSERT INTO `bx_dict_area` VALUES ('152530', '正蓝旗', '152500', '3');
INSERT INTO `bx_dict_area` VALUES ('152531', '多伦县', '152500', '3');
INSERT INTO `bx_dict_area` VALUES ('152900', '阿拉善盟', '150000', '2');
INSERT INTO `bx_dict_area` VALUES ('152921', '阿拉善左旗', '152900', '3');
INSERT INTO `bx_dict_area` VALUES ('152922', '阿拉善右旗', '152900', '3');
INSERT INTO `bx_dict_area` VALUES ('152923', '额济纳旗', '152900', '3');
INSERT INTO `bx_dict_area` VALUES ('210000', '辽宁省', '0', '1');
INSERT INTO `bx_dict_area` VALUES ('210100', '沈阳市', '210000', '2');
INSERT INTO `bx_dict_area` VALUES ('210101', '市辖区', '210100', '3');
INSERT INTO `bx_dict_area` VALUES ('210102', '和平区', '210100', '3');
INSERT INTO `bx_dict_area` VALUES ('210103', '沈河区', '210100', '3');
INSERT INTO `bx_dict_area` VALUES ('210104', '大东区', '210100', '3');
INSERT INTO `bx_dict_area` VALUES ('210105', '皇姑区', '210100', '3');
INSERT INTO `bx_dict_area` VALUES ('210106', '铁西区', '210100', '3');
INSERT INTO `bx_dict_area` VALUES ('210111', '苏家屯区', '210100', '3');
INSERT INTO `bx_dict_area` VALUES ('210112', '浑南区', '210100', '3');
INSERT INTO `bx_dict_area` VALUES ('210113', '沈北新区', '210100', '3');
INSERT INTO `bx_dict_area` VALUES ('210114', '于洪区', '210100', '3');
INSERT INTO `bx_dict_area` VALUES ('210122', '辽中县', '210100', '3');
INSERT INTO `bx_dict_area` VALUES ('210123', '康平县', '210100', '3');
INSERT INTO `bx_dict_area` VALUES ('210124', '法库县', '210100', '3');
INSERT INTO `bx_dict_area` VALUES ('210181', '新民市', '210100', '3');
INSERT INTO `bx_dict_area` VALUES ('210200', '大连市', '210000', '2');
INSERT INTO `bx_dict_area` VALUES ('210201', '市辖区', '210200', '3');
INSERT INTO `bx_dict_area` VALUES ('210202', '中山区', '210200', '3');
INSERT INTO `bx_dict_area` VALUES ('210203', '西岗区', '210200', '3');
INSERT INTO `bx_dict_area` VALUES ('210204', '沙河口区', '210200', '3');
INSERT INTO `bx_dict_area` VALUES ('210211', '甘井子区', '210200', '3');
INSERT INTO `bx_dict_area` VALUES ('210212', '旅顺口区', '210200', '3');
INSERT INTO `bx_dict_area` VALUES ('210213', '金州区', '210200', '3');
INSERT INTO `bx_dict_area` VALUES ('210224', '长海县', '210200', '3');
INSERT INTO `bx_dict_area` VALUES ('210281', '瓦房店市', '210200', '3');
INSERT INTO `bx_dict_area` VALUES ('210282', '普兰店市', '210200', '3');
INSERT INTO `bx_dict_area` VALUES ('210283', '庄河市', '210200', '3');
INSERT INTO `bx_dict_area` VALUES ('210300', '鞍山市', '210000', '2');
INSERT INTO `bx_dict_area` VALUES ('210301', '市辖区', '210300', '3');
INSERT INTO `bx_dict_area` VALUES ('210302', '铁东区', '210300', '3');
INSERT INTO `bx_dict_area` VALUES ('210303', '铁西区', '210300', '3');
INSERT INTO `bx_dict_area` VALUES ('210304', '立山区', '210300', '3');
INSERT INTO `bx_dict_area` VALUES ('210311', '千山区', '210300', '3');
INSERT INTO `bx_dict_area` VALUES ('210321', '台安县', '210300', '3');
INSERT INTO `bx_dict_area` VALUES ('210323', '岫岩满族自治县', '210300', '3');
INSERT INTO `bx_dict_area` VALUES ('210381', '海城市', '210300', '3');
INSERT INTO `bx_dict_area` VALUES ('210400', '抚顺市', '210000', '2');
INSERT INTO `bx_dict_area` VALUES ('210401', '市辖区', '210400', '3');
INSERT INTO `bx_dict_area` VALUES ('210402', '新抚区', '210400', '3');
INSERT INTO `bx_dict_area` VALUES ('210403', '东洲区', '210400', '3');
INSERT INTO `bx_dict_area` VALUES ('210404', '望花区', '210400', '3');
INSERT INTO `bx_dict_area` VALUES ('210411', '顺城区', '210400', '3');
INSERT INTO `bx_dict_area` VALUES ('210421', '抚顺县', '210400', '3');
INSERT INTO `bx_dict_area` VALUES ('210422', '新宾满族自治县', '210400', '3');
INSERT INTO `bx_dict_area` VALUES ('210423', '清原满族自治县', '210400', '3');
INSERT INTO `bx_dict_area` VALUES ('210500', '本溪市', '210000', '2');
INSERT INTO `bx_dict_area` VALUES ('210501', '市辖区', '210500', '3');
INSERT INTO `bx_dict_area` VALUES ('210502', '平山区', '210500', '3');
INSERT INTO `bx_dict_area` VALUES ('210503', '溪湖区', '210500', '3');
INSERT INTO `bx_dict_area` VALUES ('210504', '明山区', '210500', '3');
INSERT INTO `bx_dict_area` VALUES ('210505', '南芬区', '210500', '3');
INSERT INTO `bx_dict_area` VALUES ('210521', '本溪满族自治县', '210500', '3');
INSERT INTO `bx_dict_area` VALUES ('210522', '桓仁满族自治县', '210500', '3');
INSERT INTO `bx_dict_area` VALUES ('210600', '丹东市', '210000', '2');
INSERT INTO `bx_dict_area` VALUES ('210601', '市辖区', '210600', '3');
INSERT INTO `bx_dict_area` VALUES ('210602', '元宝区', '210600', '3');
INSERT INTO `bx_dict_area` VALUES ('210603', '振兴区', '210600', '3');
INSERT INTO `bx_dict_area` VALUES ('210604', '振安区', '210600', '3');
INSERT INTO `bx_dict_area` VALUES ('210624', '宽甸满族自治县', '210600', '3');
INSERT INTO `bx_dict_area` VALUES ('210681', '东港市', '210600', '3');
INSERT INTO `bx_dict_area` VALUES ('210682', '凤城市', '210600', '3');
INSERT INTO `bx_dict_area` VALUES ('210700', '锦州市', '210000', '2');
INSERT INTO `bx_dict_area` VALUES ('210701', '市辖区', '210700', '3');
INSERT INTO `bx_dict_area` VALUES ('210702', '古塔区', '210700', '3');
INSERT INTO `bx_dict_area` VALUES ('210703', '凌河区', '210700', '3');
INSERT INTO `bx_dict_area` VALUES ('210711', '太和区', '210700', '3');
INSERT INTO `bx_dict_area` VALUES ('210726', '黑山县', '210700', '3');
INSERT INTO `bx_dict_area` VALUES ('210727', '义县', '210700', '3');
INSERT INTO `bx_dict_area` VALUES ('210781', '凌海市', '210700', '3');
INSERT INTO `bx_dict_area` VALUES ('210782', '北镇市', '210700', '3');
INSERT INTO `bx_dict_area` VALUES ('210800', '营口市', '210000', '2');
INSERT INTO `bx_dict_area` VALUES ('210801', '市辖区', '210800', '3');
INSERT INTO `bx_dict_area` VALUES ('210802', '站前区', '210800', '3');
INSERT INTO `bx_dict_area` VALUES ('210803', '西市区', '210800', '3');
INSERT INTO `bx_dict_area` VALUES ('210804', '鲅鱼圈区', '210800', '3');
INSERT INTO `bx_dict_area` VALUES ('210811', '老边区', '210800', '3');
INSERT INTO `bx_dict_area` VALUES ('210881', '盖州市', '210800', '3');
INSERT INTO `bx_dict_area` VALUES ('210882', '大石桥市', '210800', '3');
INSERT INTO `bx_dict_area` VALUES ('210900', '阜新市', '210000', '2');
INSERT INTO `bx_dict_area` VALUES ('210901', '市辖区', '210900', '3');
INSERT INTO `bx_dict_area` VALUES ('210902', '海州区', '210900', '3');
INSERT INTO `bx_dict_area` VALUES ('210903', '新邱区', '210900', '3');
INSERT INTO `bx_dict_area` VALUES ('210904', '太平区', '210900', '3');
INSERT INTO `bx_dict_area` VALUES ('210905', '清河门区', '210900', '3');
INSERT INTO `bx_dict_area` VALUES ('210911', '细河区', '210900', '3');
INSERT INTO `bx_dict_area` VALUES ('210921', '阜新蒙古族自治县', '210900', '3');
INSERT INTO `bx_dict_area` VALUES ('210922', '彰武县', '210900', '3');
INSERT INTO `bx_dict_area` VALUES ('211000', '辽阳市', '210000', '2');
INSERT INTO `bx_dict_area` VALUES ('211001', '市辖区', '211000', '3');
INSERT INTO `bx_dict_area` VALUES ('211002', '白塔区', '211000', '3');
INSERT INTO `bx_dict_area` VALUES ('211003', '文圣区', '211000', '3');
INSERT INTO `bx_dict_area` VALUES ('211004', '宏伟区', '211000', '3');
INSERT INTO `bx_dict_area` VALUES ('211005', '弓长岭区', '211000', '3');
INSERT INTO `bx_dict_area` VALUES ('211011', '太子河区', '211000', '3');
INSERT INTO `bx_dict_area` VALUES ('211021', '辽阳县', '211000', '3');
INSERT INTO `bx_dict_area` VALUES ('211081', '灯塔市', '211000', '3');
INSERT INTO `bx_dict_area` VALUES ('211100', '盘锦市', '210000', '2');
INSERT INTO `bx_dict_area` VALUES ('211101', '市辖区', '211100', '3');
INSERT INTO `bx_dict_area` VALUES ('211102', '双台子区', '211100', '3');
INSERT INTO `bx_dict_area` VALUES ('211103', '兴隆台区', '211100', '3');
INSERT INTO `bx_dict_area` VALUES ('211121', '大洼县', '211100', '3');
INSERT INTO `bx_dict_area` VALUES ('211122', '盘山县', '211100', '3');
INSERT INTO `bx_dict_area` VALUES ('211200', '铁岭市', '210000', '2');
INSERT INTO `bx_dict_area` VALUES ('211201', '市辖区', '211200', '3');
INSERT INTO `bx_dict_area` VALUES ('211202', '银州区', '211200', '3');
INSERT INTO `bx_dict_area` VALUES ('211204', '清河区', '211200', '3');
INSERT INTO `bx_dict_area` VALUES ('211221', '铁岭县', '211200', '3');
INSERT INTO `bx_dict_area` VALUES ('211223', '西丰县', '211200', '3');
INSERT INTO `bx_dict_area` VALUES ('211224', '昌图县', '211200', '3');
INSERT INTO `bx_dict_area` VALUES ('211281', '调兵山市', '211200', '3');
INSERT INTO `bx_dict_area` VALUES ('211282', '开原市', '211200', '3');
INSERT INTO `bx_dict_area` VALUES ('211300', '朝阳市', '210000', '2');
INSERT INTO `bx_dict_area` VALUES ('211301', '市辖区', '211300', '3');
INSERT INTO `bx_dict_area` VALUES ('211302', '双塔区', '211300', '3');
INSERT INTO `bx_dict_area` VALUES ('211303', '龙城区', '211300', '3');
INSERT INTO `bx_dict_area` VALUES ('211321', '朝阳县', '211300', '3');
INSERT INTO `bx_dict_area` VALUES ('211322', '建平县', '211300', '3');
INSERT INTO `bx_dict_area` VALUES ('211324', '喀喇沁左翼蒙古族自治县', '211300', '3');
INSERT INTO `bx_dict_area` VALUES ('211381', '北票市', '211300', '3');
INSERT INTO `bx_dict_area` VALUES ('211382', '凌源市', '211300', '3');
INSERT INTO `bx_dict_area` VALUES ('211400', '葫芦岛市', '210000', '2');
INSERT INTO `bx_dict_area` VALUES ('211401', '市辖区', '211400', '3');
INSERT INTO `bx_dict_area` VALUES ('211402', '连山区', '211400', '3');
INSERT INTO `bx_dict_area` VALUES ('211403', '龙港区', '211400', '3');
INSERT INTO `bx_dict_area` VALUES ('211404', '南票区', '211400', '3');
INSERT INTO `bx_dict_area` VALUES ('211421', '绥中县', '211400', '3');
INSERT INTO `bx_dict_area` VALUES ('211422', '建昌县', '211400', '3');
INSERT INTO `bx_dict_area` VALUES ('211481', '兴城市', '211400', '3');
INSERT INTO `bx_dict_area` VALUES ('220000', '吉林省', '0', '1');
INSERT INTO `bx_dict_area` VALUES ('220100', '长春市', '220000', '2');
INSERT INTO `bx_dict_area` VALUES ('220101', '市辖区', '220100', '3');
INSERT INTO `bx_dict_area` VALUES ('220102', '南关区', '220100', '3');
INSERT INTO `bx_dict_area` VALUES ('220103', '宽城区', '220100', '3');
INSERT INTO `bx_dict_area` VALUES ('220104', '朝阳区', '220100', '3');
INSERT INTO `bx_dict_area` VALUES ('220105', '二道区', '220100', '3');
INSERT INTO `bx_dict_area` VALUES ('220106', '绿园区', '220100', '3');
INSERT INTO `bx_dict_area` VALUES ('220112', '双阳区', '220100', '3');
INSERT INTO `bx_dict_area` VALUES ('220113', '九台区', '220100', '3');
INSERT INTO `bx_dict_area` VALUES ('220122', '农安县', '220100', '3');
INSERT INTO `bx_dict_area` VALUES ('220182', '榆树市', '220100', '3');
INSERT INTO `bx_dict_area` VALUES ('220183', '德惠市', '220100', '3');
INSERT INTO `bx_dict_area` VALUES ('220200', '吉林市', '220000', '2');
INSERT INTO `bx_dict_area` VALUES ('220201', '市辖区', '220200', '3');
INSERT INTO `bx_dict_area` VALUES ('220202', '昌邑区', '220200', '3');
INSERT INTO `bx_dict_area` VALUES ('220203', '龙潭区', '220200', '3');
INSERT INTO `bx_dict_area` VALUES ('220204', '船营区', '220200', '3');
INSERT INTO `bx_dict_area` VALUES ('220211', '丰满区', '220200', '3');
INSERT INTO `bx_dict_area` VALUES ('220221', '永吉县', '220200', '3');
INSERT INTO `bx_dict_area` VALUES ('220281', '蛟河市', '220200', '3');
INSERT INTO `bx_dict_area` VALUES ('220282', '桦甸市', '220200', '3');
INSERT INTO `bx_dict_area` VALUES ('220283', '舒兰市', '220200', '3');
INSERT INTO `bx_dict_area` VALUES ('220284', '磐石市', '220200', '3');
INSERT INTO `bx_dict_area` VALUES ('220300', '四平市', '220000', '2');
INSERT INTO `bx_dict_area` VALUES ('220301', '市辖区', '220300', '3');
INSERT INTO `bx_dict_area` VALUES ('220302', '铁西区', '220300', '3');
INSERT INTO `bx_dict_area` VALUES ('220303', '铁东区', '220300', '3');
INSERT INTO `bx_dict_area` VALUES ('220322', '梨树县', '220300', '3');
INSERT INTO `bx_dict_area` VALUES ('220323', '伊通满族自治县', '220300', '3');
INSERT INTO `bx_dict_area` VALUES ('220381', '公主岭市', '220300', '3');
INSERT INTO `bx_dict_area` VALUES ('220382', '双辽市', '220300', '3');
INSERT INTO `bx_dict_area` VALUES ('220400', '辽源市', '220000', '2');
INSERT INTO `bx_dict_area` VALUES ('220401', '市辖区', '220400', '3');
INSERT INTO `bx_dict_area` VALUES ('220402', '龙山区', '220400', '3');
INSERT INTO `bx_dict_area` VALUES ('220403', '西安区', '220400', '3');
INSERT INTO `bx_dict_area` VALUES ('220421', '东丰县', '220400', '3');
INSERT INTO `bx_dict_area` VALUES ('220422', '东辽县', '220400', '3');
INSERT INTO `bx_dict_area` VALUES ('220500', '通化市', '220000', '2');
INSERT INTO `bx_dict_area` VALUES ('220501', '市辖区', '220500', '3');
INSERT INTO `bx_dict_area` VALUES ('220502', '东昌区', '220500', '3');
INSERT INTO `bx_dict_area` VALUES ('220503', '二道江区', '220500', '3');
INSERT INTO `bx_dict_area` VALUES ('220521', '通化县', '220500', '3');
INSERT INTO `bx_dict_area` VALUES ('220523', '辉南县', '220500', '3');
INSERT INTO `bx_dict_area` VALUES ('220524', '柳河县', '220500', '3');
INSERT INTO `bx_dict_area` VALUES ('220581', '梅河口市', '220500', '3');
INSERT INTO `bx_dict_area` VALUES ('220582', '集安市', '220500', '3');
INSERT INTO `bx_dict_area` VALUES ('220600', '白山市', '220000', '2');
INSERT INTO `bx_dict_area` VALUES ('220601', '市辖区', '220600', '3');
INSERT INTO `bx_dict_area` VALUES ('220602', '浑江区', '220600', '3');
INSERT INTO `bx_dict_area` VALUES ('220605', '江源区', '220600', '3');
INSERT INTO `bx_dict_area` VALUES ('220621', '抚松县', '220600', '3');
INSERT INTO `bx_dict_area` VALUES ('220622', '靖宇县', '220600', '3');
INSERT INTO `bx_dict_area` VALUES ('220623', '长白朝鲜族自治县', '220600', '3');
INSERT INTO `bx_dict_area` VALUES ('220681', '临江市', '220600', '3');
INSERT INTO `bx_dict_area` VALUES ('220700', '松原市', '220000', '2');
INSERT INTO `bx_dict_area` VALUES ('220701', '市辖区', '220700', '3');
INSERT INTO `bx_dict_area` VALUES ('220702', '宁江区', '220700', '3');
INSERT INTO `bx_dict_area` VALUES ('220721', '前郭尔罗斯蒙古族自治县', '220700', '3');
INSERT INTO `bx_dict_area` VALUES ('220722', '长岭县', '220700', '3');
INSERT INTO `bx_dict_area` VALUES ('220723', '乾安县', '220700', '3');
INSERT INTO `bx_dict_area` VALUES ('220781', '扶余市', '220700', '3');
INSERT INTO `bx_dict_area` VALUES ('220800', '白城市', '220000', '2');
INSERT INTO `bx_dict_area` VALUES ('220801', '市辖区', '220800', '3');
INSERT INTO `bx_dict_area` VALUES ('220802', '洮北区', '220800', '3');
INSERT INTO `bx_dict_area` VALUES ('220821', '镇赉县', '220800', '3');
INSERT INTO `bx_dict_area` VALUES ('220822', '通榆县', '220800', '3');
INSERT INTO `bx_dict_area` VALUES ('220881', '洮南市', '220800', '3');
INSERT INTO `bx_dict_area` VALUES ('220882', '大安市', '220800', '3');
INSERT INTO `bx_dict_area` VALUES ('222400', '延边朝鲜族自治州', '220000', '2');
INSERT INTO `bx_dict_area` VALUES ('222401', '延吉市', '222400', '3');
INSERT INTO `bx_dict_area` VALUES ('222402', '图们市', '222400', '3');
INSERT INTO `bx_dict_area` VALUES ('222403', '敦化市', '222400', '3');
INSERT INTO `bx_dict_area` VALUES ('222404', '珲春市', '222400', '3');
INSERT INTO `bx_dict_area` VALUES ('222405', '龙井市', '222400', '3');
INSERT INTO `bx_dict_area` VALUES ('222406', '和龙市', '222400', '3');
INSERT INTO `bx_dict_area` VALUES ('222424', '汪清县', '222400', '3');
INSERT INTO `bx_dict_area` VALUES ('222426', '安图县', '222400', '3');
INSERT INTO `bx_dict_area` VALUES ('230000', '黑龙江省', '0', '1');
INSERT INTO `bx_dict_area` VALUES ('230100', '哈尔滨市', '230000', '2');
INSERT INTO `bx_dict_area` VALUES ('230101', '市辖区', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230102', '道里区', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230103', '南岗区', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230104', '道外区', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230108', '平房区', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230109', '松北区', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230110', '香坊区', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230111', '呼兰区', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230112', '阿城区', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230123', '依兰县', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230124', '方正县', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230125', '宾县', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230126', '巴彦县', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230127', '木兰县', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230128', '通河县', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230129', '延寿县', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230182', '双城市', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230183', '尚志市', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230184', '五常市', '230100', '3');
INSERT INTO `bx_dict_area` VALUES ('230200', '齐齐哈尔市', '230000', '2');
INSERT INTO `bx_dict_area` VALUES ('230201', '市辖区', '230200', '3');
INSERT INTO `bx_dict_area` VALUES ('230202', '龙沙区', '230200', '3');
INSERT INTO `bx_dict_area` VALUES ('230203', '建华区', '230200', '3');
INSERT INTO `bx_dict_area` VALUES ('230204', '铁锋区', '230200', '3');
INSERT INTO `bx_dict_area` VALUES ('230205', '昂昂溪区', '230200', '3');
INSERT INTO `bx_dict_area` VALUES ('230206', '富拉尔基区', '230200', '3');
INSERT INTO `bx_dict_area` VALUES ('230207', '碾子山区', '230200', '3');
INSERT INTO `bx_dict_area` VALUES ('230208', '梅里斯达斡尔族区', '230200', '3');
INSERT INTO `bx_dict_area` VALUES ('230221', '龙江县', '230200', '3');
INSERT INTO `bx_dict_area` VALUES ('230223', '依安县', '230200', '3');
INSERT INTO `bx_dict_area` VALUES ('230224', '泰来县', '230200', '3');
INSERT INTO `bx_dict_area` VALUES ('230225', '甘南县', '230200', '3');
INSERT INTO `bx_dict_area` VALUES ('230227', '富裕县', '230200', '3');
INSERT INTO `bx_dict_area` VALUES ('230229', '克山县', '230200', '3');
INSERT INTO `bx_dict_area` VALUES ('230230', '克东县', '230200', '3');
INSERT INTO `bx_dict_area` VALUES ('230231', '拜泉县', '230200', '3');
INSERT INTO `bx_dict_area` VALUES ('230281', '讷河市', '230200', '3');
INSERT INTO `bx_dict_area` VALUES ('230300', '鸡西市', '230000', '2');
INSERT INTO `bx_dict_area` VALUES ('230301', '市辖区', '230300', '3');
INSERT INTO `bx_dict_area` VALUES ('230302', '鸡冠区', '230300', '3');
INSERT INTO `bx_dict_area` VALUES ('230303', '恒山区', '230300', '3');
INSERT INTO `bx_dict_area` VALUES ('230304', '滴道区', '230300', '3');
INSERT INTO `bx_dict_area` VALUES ('230305', '梨树区', '230300', '3');
INSERT INTO `bx_dict_area` VALUES ('230306', '城子河区', '230300', '3');
INSERT INTO `bx_dict_area` VALUES ('230307', '麻山区', '230300', '3');
INSERT INTO `bx_dict_area` VALUES ('230321', '鸡东县', '230300', '3');
INSERT INTO `bx_dict_area` VALUES ('230381', '虎林市', '230300', '3');
INSERT INTO `bx_dict_area` VALUES ('230382', '密山市', '230300', '3');
INSERT INTO `bx_dict_area` VALUES ('230400', '鹤岗市', '230000', '2');
INSERT INTO `bx_dict_area` VALUES ('230401', '市辖区', '230400', '3');
INSERT INTO `bx_dict_area` VALUES ('230402', '向阳区', '230400', '3');
INSERT INTO `bx_dict_area` VALUES ('230403', '工农区', '230400', '3');
INSERT INTO `bx_dict_area` VALUES ('230404', '南山区', '230400', '3');
INSERT INTO `bx_dict_area` VALUES ('230405', '兴安区', '230400', '3');
INSERT INTO `bx_dict_area` VALUES ('230406', '东山区', '230400', '3');
INSERT INTO `bx_dict_area` VALUES ('230407', '兴山区', '230400', '3');
INSERT INTO `bx_dict_area` VALUES ('230421', '萝北县', '230400', '3');
INSERT INTO `bx_dict_area` VALUES ('230422', '绥滨县', '230400', '3');
INSERT INTO `bx_dict_area` VALUES ('230500', '双鸭山市', '230000', '2');
INSERT INTO `bx_dict_area` VALUES ('230501', '市辖区', '230500', '3');
INSERT INTO `bx_dict_area` VALUES ('230502', '尖山区', '230500', '3');
INSERT INTO `bx_dict_area` VALUES ('230503', '岭东区', '230500', '3');
INSERT INTO `bx_dict_area` VALUES ('230505', '四方台区', '230500', '3');
INSERT INTO `bx_dict_area` VALUES ('230506', '宝山区', '230500', '3');
INSERT INTO `bx_dict_area` VALUES ('230521', '集贤县', '230500', '3');
INSERT INTO `bx_dict_area` VALUES ('230522', '友谊县', '230500', '3');
INSERT INTO `bx_dict_area` VALUES ('230523', '宝清县', '230500', '3');
INSERT INTO `bx_dict_area` VALUES ('230524', '饶河县', '230500', '3');
INSERT INTO `bx_dict_area` VALUES ('230600', '大庆市', '230000', '2');
INSERT INTO `bx_dict_area` VALUES ('230601', '市辖区', '230600', '3');
INSERT INTO `bx_dict_area` VALUES ('230602', '萨尔图区', '230600', '3');
INSERT INTO `bx_dict_area` VALUES ('230603', '龙凤区', '230600', '3');
INSERT INTO `bx_dict_area` VALUES ('230604', '让胡路区', '230600', '3');
INSERT INTO `bx_dict_area` VALUES ('230605', '红岗区', '230600', '3');
INSERT INTO `bx_dict_area` VALUES ('230606', '大同区', '230600', '3');
INSERT INTO `bx_dict_area` VALUES ('230621', '肇州县', '230600', '3');
INSERT INTO `bx_dict_area` VALUES ('230622', '肇源县', '230600', '3');
INSERT INTO `bx_dict_area` VALUES ('230623', '林甸县', '230600', '3');
INSERT INTO `bx_dict_area` VALUES ('230624', '杜尔伯特蒙古族自治县', '230600', '3');
INSERT INTO `bx_dict_area` VALUES ('230700', '伊春市', '230000', '2');
INSERT INTO `bx_dict_area` VALUES ('230701', '市辖区', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230702', '伊春区', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230703', '南岔区', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230704', '友好区', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230705', '西林区', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230706', '翠峦区', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230707', '新青区', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230708', '美溪区', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230709', '金山屯区', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230710', '五营区', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230711', '乌马河区', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230712', '汤旺河区', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230713', '带岭区', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230714', '乌伊岭区', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230715', '红星区', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230716', '上甘岭区', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230722', '嘉荫县', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230781', '铁力市', '230700', '3');
INSERT INTO `bx_dict_area` VALUES ('230800', '佳木斯市', '230000', '2');
INSERT INTO `bx_dict_area` VALUES ('230801', '市辖区', '230800', '3');
INSERT INTO `bx_dict_area` VALUES ('230803', '向阳区', '230800', '3');
INSERT INTO `bx_dict_area` VALUES ('230804', '前进区', '230800', '3');
INSERT INTO `bx_dict_area` VALUES ('230805', '东风区', '230800', '3');
INSERT INTO `bx_dict_area` VALUES ('230811', '郊区', '230800', '3');
INSERT INTO `bx_dict_area` VALUES ('230822', '桦南县', '230800', '3');
INSERT INTO `bx_dict_area` VALUES ('230826', '桦川县', '230800', '3');
INSERT INTO `bx_dict_area` VALUES ('230828', '汤原县', '230800', '3');
INSERT INTO `bx_dict_area` VALUES ('230833', '抚远县', '230800', '3');
INSERT INTO `bx_dict_area` VALUES ('230881', '同江市', '230800', '3');
INSERT INTO `bx_dict_area` VALUES ('230882', '富锦市', '230800', '3');
INSERT INTO `bx_dict_area` VALUES ('230900', '七台河市', '230000', '2');
INSERT INTO `bx_dict_area` VALUES ('230901', '市辖区', '230900', '3');
INSERT INTO `bx_dict_area` VALUES ('230902', '新兴区', '230900', '3');
INSERT INTO `bx_dict_area` VALUES ('230903', '桃山区', '230900', '3');
INSERT INTO `bx_dict_area` VALUES ('230904', '茄子河区', '230900', '3');
INSERT INTO `bx_dict_area` VALUES ('230921', '勃利县', '230900', '3');
INSERT INTO `bx_dict_area` VALUES ('231000', '牡丹江市', '230000', '2');
INSERT INTO `bx_dict_area` VALUES ('231001', '市辖区', '231000', '3');
INSERT INTO `bx_dict_area` VALUES ('231002', '东安区', '231000', '3');
INSERT INTO `bx_dict_area` VALUES ('231003', '阳明区', '231000', '3');
INSERT INTO `bx_dict_area` VALUES ('231004', '爱民区', '231000', '3');
INSERT INTO `bx_dict_area` VALUES ('231005', '西安区', '231000', '3');
INSERT INTO `bx_dict_area` VALUES ('231024', '东宁县', '231000', '3');
INSERT INTO `bx_dict_area` VALUES ('231025', '林口县', '231000', '3');
INSERT INTO `bx_dict_area` VALUES ('231081', '绥芬河市', '231000', '3');
INSERT INTO `bx_dict_area` VALUES ('231083', '海林市', '231000', '3');
INSERT INTO `bx_dict_area` VALUES ('231084', '宁安市', '231000', '3');
INSERT INTO `bx_dict_area` VALUES ('231085', '穆棱市', '231000', '3');
INSERT INTO `bx_dict_area` VALUES ('231100', '黑河市', '230000', '2');
INSERT INTO `bx_dict_area` VALUES ('231101', '市辖区', '231100', '3');
INSERT INTO `bx_dict_area` VALUES ('231102', '爱辉区', '231100', '3');
INSERT INTO `bx_dict_area` VALUES ('231121', '嫩江县', '231100', '3');
INSERT INTO `bx_dict_area` VALUES ('231123', '逊克县', '231100', '3');
INSERT INTO `bx_dict_area` VALUES ('231124', '孙吴县', '231100', '3');
INSERT INTO `bx_dict_area` VALUES ('231181', '北安市', '231100', '3');
INSERT INTO `bx_dict_area` VALUES ('231182', '五大连池市', '231100', '3');
INSERT INTO `bx_dict_area` VALUES ('231200', '绥化市', '230000', '2');
INSERT INTO `bx_dict_area` VALUES ('231201', '市辖区', '231200', '3');
INSERT INTO `bx_dict_area` VALUES ('231202', '北林区', '231200', '3');
INSERT INTO `bx_dict_area` VALUES ('231221', '望奎县', '231200', '3');
INSERT INTO `bx_dict_area` VALUES ('231222', '兰西县', '231200', '3');
INSERT INTO `bx_dict_area` VALUES ('231223', '青冈县', '231200', '3');
INSERT INTO `bx_dict_area` VALUES ('231224', '庆安县', '231200', '3');
INSERT INTO `bx_dict_area` VALUES ('231225', '明水县', '231200', '3');
INSERT INTO `bx_dict_area` VALUES ('231226', '绥棱县', '231200', '3');
INSERT INTO `bx_dict_area` VALUES ('231281', '安达市', '231200', '3');
INSERT INTO `bx_dict_area` VALUES ('231282', '肇东市', '231200', '3');
INSERT INTO `bx_dict_area` VALUES ('231283', '海伦市', '231200', '3');
INSERT INTO `bx_dict_area` VALUES ('232700', '大兴安岭地区', '230000', '2');
INSERT INTO `bx_dict_area` VALUES ('232721', '呼玛县', '232700', '3');
INSERT INTO `bx_dict_area` VALUES ('232722', '塔河县', '232700', '3');
INSERT INTO `bx_dict_area` VALUES ('232723', '漠河县', '232700', '3');
INSERT INTO `bx_dict_area` VALUES ('310000', '上海市', '0', '1');
INSERT INTO `bx_dict_area` VALUES ('310100', '市辖区', '310000', '2');
INSERT INTO `bx_dict_area` VALUES ('310101', '黄浦区', '310100', '3');
INSERT INTO `bx_dict_area` VALUES ('310104', '徐汇区', '310100', '3');
INSERT INTO `bx_dict_area` VALUES ('310105', '长宁区', '310100', '3');
INSERT INTO `bx_dict_area` VALUES ('310106', '静安区', '310100', '3');
INSERT INTO `bx_dict_area` VALUES ('310107', '普陀区', '310100', '3');
INSERT INTO `bx_dict_area` VALUES ('310108', '闸北区', '310100', '3');
INSERT INTO `bx_dict_area` VALUES ('310109', '虹口区', '310100', '3');
INSERT INTO `bx_dict_area` VALUES ('310110', '杨浦区', '310100', '3');
INSERT INTO `bx_dict_area` VALUES ('310112', '闵行区', '310100', '3');
INSERT INTO `bx_dict_area` VALUES ('310113', '宝山区', '310100', '3');
INSERT INTO `bx_dict_area` VALUES ('310114', '嘉定区', '310100', '3');
INSERT INTO `bx_dict_area` VALUES ('310115', '浦东新区', '310100', '3');
INSERT INTO `bx_dict_area` VALUES ('310116', '金山区', '310100', '3');
INSERT INTO `bx_dict_area` VALUES ('310117', '松江区', '310100', '3');
INSERT INTO `bx_dict_area` VALUES ('310118', '青浦区', '310100', '3');
INSERT INTO `bx_dict_area` VALUES ('310120', '奉贤区', '310100', '3');
INSERT INTO `bx_dict_area` VALUES ('310200', '县', '310000', '2');
INSERT INTO `bx_dict_area` VALUES ('310230', '崇明县', '310200', '3');
INSERT INTO `bx_dict_area` VALUES ('320000', '江苏省', '0', '1');
INSERT INTO `bx_dict_area` VALUES ('320100', '南京市', '320000', '2');
INSERT INTO `bx_dict_area` VALUES ('320101', '市辖区', '320100', '3');
INSERT INTO `bx_dict_area` VALUES ('320102', '玄武区', '320100', '3');
INSERT INTO `bx_dict_area` VALUES ('320104', '秦淮区', '320100', '3');
INSERT INTO `bx_dict_area` VALUES ('320105', '建邺区', '320100', '3');
INSERT INTO `bx_dict_area` VALUES ('320106', '鼓楼区', '320100', '3');
INSERT INTO `bx_dict_area` VALUES ('320111', '浦口区', '320100', '3');
INSERT INTO `bx_dict_area` VALUES ('320113', '栖霞区', '320100', '3');
INSERT INTO `bx_dict_area` VALUES ('320114', '雨花台区', '320100', '3');
INSERT INTO `bx_dict_area` VALUES ('320115', '江宁区', '320100', '3');
INSERT INTO `bx_dict_area` VALUES ('320116', '六合区', '320100', '3');
INSERT INTO `bx_dict_area` VALUES ('320117', '溧水区', '320100', '3');
INSERT INTO `bx_dict_area` VALUES ('320118', '高淳区', '320100', '3');
INSERT INTO `bx_dict_area` VALUES ('320200', '无锡市', '320000', '2');
INSERT INTO `bx_dict_area` VALUES ('320201', '市辖区', '320200', '3');
INSERT INTO `bx_dict_area` VALUES ('320202', '崇安区', '320200', '3');
INSERT INTO `bx_dict_area` VALUES ('320203', '南长区', '320200', '3');
INSERT INTO `bx_dict_area` VALUES ('320204', '北塘区', '320200', '3');
INSERT INTO `bx_dict_area` VALUES ('320205', '锡山区', '320200', '3');
INSERT INTO `bx_dict_area` VALUES ('320206', '惠山区', '320200', '3');
INSERT INTO `bx_dict_area` VALUES ('320211', '滨湖区', '320200', '3');
INSERT INTO `bx_dict_area` VALUES ('320281', '江阴市', '320200', '3');
INSERT INTO `bx_dict_area` VALUES ('320282', '宜兴市', '320200', '3');
INSERT INTO `bx_dict_area` VALUES ('320300', '徐州市', '320000', '2');
INSERT INTO `bx_dict_area` VALUES ('320301', '市辖区', '320300', '3');
INSERT INTO `bx_dict_area` VALUES ('320302', '鼓楼区', '320300', '3');
INSERT INTO `bx_dict_area` VALUES ('320303', '云龙区', '320300', '3');
INSERT INTO `bx_dict_area` VALUES ('320305', '贾汪区', '320300', '3');
INSERT INTO `bx_dict_area` VALUES ('320311', '泉山区', '320300', '3');
INSERT INTO `bx_dict_area` VALUES ('320312', '铜山区', '320300', '3');
INSERT INTO `bx_dict_area` VALUES ('320321', '丰县', '320300', '3');
INSERT INTO `bx_dict_area` VALUES ('320322', '沛县', '320300', '3');
INSERT INTO `bx_dict_area` VALUES ('320324', '睢宁县', '320300', '3');
INSERT INTO `bx_dict_area` VALUES ('320381', '新沂市', '320300', '3');
INSERT INTO `bx_dict_area` VALUES ('320382', '邳州市', '320300', '3');
INSERT INTO `bx_dict_area` VALUES ('320400', '常州市', '320000', '2');
INSERT INTO `bx_dict_area` VALUES ('320401', '市辖区', '320400', '3');
INSERT INTO `bx_dict_area` VALUES ('320402', '天宁区', '320400', '3');
INSERT INTO `bx_dict_area` VALUES ('320404', '钟楼区', '320400', '3');
INSERT INTO `bx_dict_area` VALUES ('320405', '戚墅堰区', '320400', '3');
INSERT INTO `bx_dict_area` VALUES ('320411', '新北区', '320400', '3');
INSERT INTO `bx_dict_area` VALUES ('320412', '武进区', '320400', '3');
INSERT INTO `bx_dict_area` VALUES ('320481', '溧阳市', '320400', '3');
INSERT INTO `bx_dict_area` VALUES ('320482', '金坛市', '320400', '3');
INSERT INTO `bx_dict_area` VALUES ('320500', '苏州市', '320000', '2');
INSERT INTO `bx_dict_area` VALUES ('320501', '市辖区', '320500', '3');
INSERT INTO `bx_dict_area` VALUES ('320505', '虎丘区', '320500', '3');
INSERT INTO `bx_dict_area` VALUES ('320506', '吴中区', '320500', '3');
INSERT INTO `bx_dict_area` VALUES ('320507', '相城区', '320500', '3');
INSERT INTO `bx_dict_area` VALUES ('320508', '姑苏区', '320500', '3');
INSERT INTO `bx_dict_area` VALUES ('320509', '吴江区', '320500', '3');
INSERT INTO `bx_dict_area` VALUES ('320581', '常熟市', '320500', '3');
INSERT INTO `bx_dict_area` VALUES ('320582', '张家港市', '320500', '3');
INSERT INTO `bx_dict_area` VALUES ('320583', '昆山市', '320500', '3');
INSERT INTO `bx_dict_area` VALUES ('320585', '太仓市', '320500', '3');
INSERT INTO `bx_dict_area` VALUES ('320600', '南通市', '320000', '2');
INSERT INTO `bx_dict_area` VALUES ('320601', '市辖区', '320600', '3');
INSERT INTO `bx_dict_area` VALUES ('320602', '崇川区', '320600', '3');
INSERT INTO `bx_dict_area` VALUES ('320611', '港闸区', '320600', '3');
INSERT INTO `bx_dict_area` VALUES ('320612', '通州区', '320600', '3');
INSERT INTO `bx_dict_area` VALUES ('320621', '海安县', '320600', '3');
INSERT INTO `bx_dict_area` VALUES ('320623', '如东县', '320600', '3');
INSERT INTO `bx_dict_area` VALUES ('320681', '启东市', '320600', '3');
INSERT INTO `bx_dict_area` VALUES ('320682', '如皋市', '320600', '3');
INSERT INTO `bx_dict_area` VALUES ('320684', '海门市', '320600', '3');
INSERT INTO `bx_dict_area` VALUES ('320700', '连云港市', '320000', '2');
INSERT INTO `bx_dict_area` VALUES ('320701', '市辖区', '320700', '3');
INSERT INTO `bx_dict_area` VALUES ('320703', '连云区', '320700', '3');
INSERT INTO `bx_dict_area` VALUES ('320706', '海州区', '320700', '3');
INSERT INTO `bx_dict_area` VALUES ('320707', '赣榆区', '320700', '3');
INSERT INTO `bx_dict_area` VALUES ('320722', '东海县', '320700', '3');
INSERT INTO `bx_dict_area` VALUES ('320723', '灌云县', '320700', '3');
INSERT INTO `bx_dict_area` VALUES ('320724', '灌南县', '320700', '3');
INSERT INTO `bx_dict_area` VALUES ('320800', '淮安市', '320000', '2');
INSERT INTO `bx_dict_area` VALUES ('320801', '市辖区', '320800', '3');
INSERT INTO `bx_dict_area` VALUES ('320802', '清河区', '320800', '3');
INSERT INTO `bx_dict_area` VALUES ('320803', '淮安区', '320800', '3');
INSERT INTO `bx_dict_area` VALUES ('320804', '淮阴区', '320800', '3');
INSERT INTO `bx_dict_area` VALUES ('320811', '清浦区', '320800', '3');
INSERT INTO `bx_dict_area` VALUES ('320826', '涟水县', '320800', '3');
INSERT INTO `bx_dict_area` VALUES ('320829', '洪泽县', '320800', '3');
INSERT INTO `bx_dict_area` VALUES ('320830', '盱眙县', '320800', '3');
INSERT INTO `bx_dict_area` VALUES ('320831', '金湖县', '320800', '3');
INSERT INTO `bx_dict_area` VALUES ('320900', '盐城市', '320000', '2');
INSERT INTO `bx_dict_area` VALUES ('320901', '市辖区', '320900', '3');
INSERT INTO `bx_dict_area` VALUES ('320902', '亭湖区', '320900', '3');
INSERT INTO `bx_dict_area` VALUES ('320903', '盐都区', '320900', '3');
INSERT INTO `bx_dict_area` VALUES ('320921', '响水县', '320900', '3');
INSERT INTO `bx_dict_area` VALUES ('320922', '滨海县', '320900', '3');
INSERT INTO `bx_dict_area` VALUES ('320923', '阜宁县', '320900', '3');
INSERT INTO `bx_dict_area` VALUES ('320924', '射阳县', '320900', '3');
INSERT INTO `bx_dict_area` VALUES ('320925', '建湖县', '320900', '3');
INSERT INTO `bx_dict_area` VALUES ('320981', '东台市', '320900', '3');
INSERT INTO `bx_dict_area` VALUES ('320982', '大丰市', '320900', '3');
INSERT INTO `bx_dict_area` VALUES ('321000', '扬州市', '320000', '2');
INSERT INTO `bx_dict_area` VALUES ('321001', '市辖区', '321000', '3');
INSERT INTO `bx_dict_area` VALUES ('321002', '广陵区', '321000', '3');
INSERT INTO `bx_dict_area` VALUES ('321003', '邗江区', '321000', '3');
INSERT INTO `bx_dict_area` VALUES ('321012', '江都区', '321000', '3');
INSERT INTO `bx_dict_area` VALUES ('321023', '宝应县', '321000', '3');
INSERT INTO `bx_dict_area` VALUES ('321081', '仪征市', '321000', '3');
INSERT INTO `bx_dict_area` VALUES ('321084', '高邮市', '321000', '3');
INSERT INTO `bx_dict_area` VALUES ('321100', '镇江市', '320000', '2');
INSERT INTO `bx_dict_area` VALUES ('321101', '市辖区', '321100', '3');
INSERT INTO `bx_dict_area` VALUES ('321102', '京口区', '321100', '3');
INSERT INTO `bx_dict_area` VALUES ('321111', '润州区', '321100', '3');
INSERT INTO `bx_dict_area` VALUES ('321112', '丹徒区', '321100', '3');
INSERT INTO `bx_dict_area` VALUES ('321181', '丹阳市', '321100', '3');
INSERT INTO `bx_dict_area` VALUES ('321182', '扬中市', '321100', '3');
INSERT INTO `bx_dict_area` VALUES ('321183', '句容市', '321100', '3');
INSERT INTO `bx_dict_area` VALUES ('321200', '泰州市', '320000', '2');
INSERT INTO `bx_dict_area` VALUES ('321201', '市辖区', '321200', '3');
INSERT INTO `bx_dict_area` VALUES ('321202', '海陵区', '321200', '3');
INSERT INTO `bx_dict_area` VALUES ('321203', '高港区', '321200', '3');
INSERT INTO `bx_dict_area` VALUES ('321204', '姜堰区', '321200', '3');
INSERT INTO `bx_dict_area` VALUES ('321281', '兴化市', '321200', '3');
INSERT INTO `bx_dict_area` VALUES ('321282', '靖江市', '321200', '3');
INSERT INTO `bx_dict_area` VALUES ('321283', '泰兴市', '321200', '3');
INSERT INTO `bx_dict_area` VALUES ('321300', '宿迁市', '320000', '2');
INSERT INTO `bx_dict_area` VALUES ('321301', '市辖区', '321300', '3');

-- ----------------------------
-- Table structure for `bx_manage_permission`
-- ----------------------------
DROP TABLE IF EXISTS `bx_manage_permission`;
CREATE TABLE `bx_manage_permission` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `parent_id` bigint(11) DEFAULT NULL COMMENT '父ID(自关联)',
  `icon_cls` varchar(60) DEFAULT NULL COMMENT '图标',
  `sort` bigint(11) DEFAULT NULL COMMENT '排序',
  `code` varchar(60) NOT NULL COMMENT '权限代码',
  `name` varchar(30) NOT NULL COMMENT '权限名',
  `type` tinyint(4) NOT NULL COMMENT '权限类型（1：menu,2：option）',
  `status` tinyint(3) NOT NULL DEFAULT '1' COMMENT '是否有效（1显示，0不显示,2删除）',
  `parent_code` varchar(60) DEFAULT NULL COMMENT '父结点',
  PRIMARY KEY (`id`),
  UNIQUE KEY `permission_code_only` (`code`) USING BTREE,
  KEY `index_parent_id_sort_status` (`parent_id`,`sort`,`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bx_manage_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `bx_manage_role`
-- ----------------------------
DROP TABLE IF EXISTS `bx_manage_role`;
CREATE TABLE `bx_manage_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `code` varchar(20) DEFAULT NULL COMMENT '权限代码',
  `name` varchar(60) DEFAULT NULL COMMENT '角色名称(如超级管理员，业务员）',
  `description` varchar(128) DEFAULT NULL COMMENT '角色描述',
  `status` tinyint(3) NOT NULL DEFAULT '1' COMMENT '角色状态0：无效，1：有效',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `modify_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_code_only` (`code`) USING BTREE,
  KEY `status` (`status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bx_manage_role
-- ----------------------------

-- ----------------------------
-- Table structure for `bx_manage_role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `bx_manage_role_permission`;
CREATE TABLE `bx_manage_role_permission` (
  `role_id` bigint(11) NOT NULL COMMENT '角色ID',
  `permission_id` bigint(11) NOT NULL COMMENT '权限ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '角色状态0：无效，1：有效',
  UNIQUE KEY `index_role_permission` (`role_id`,`permission_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bx_manage_role_permission
-- ----------------------------

-- ----------------------------
-- Table structure for `bx_manage_user`
-- ----------------------------
DROP TABLE IF EXISTS `bx_manage_user`;
CREATE TABLE `bx_manage_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `name` varchar(60) NOT NULL COMMENT '用户名',
  `real_name` varchar(100) NOT NULL COMMENT '姓名',
  `password` varchar(100) NOT NULL COMMENT '密码',
  `type` tinyint(4) NOT NULL COMMENT '类型（-1:未设置，0：超级管理员系统内置，1：运营人员,2:业务人员）',
  `phone` varchar(15) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(60) DEFAULT NULL COMMENT '邮箱',
  `pic_url` varchar(50) DEFAULT NULL COMMENT '头像',
  `status` tinyint(3) NOT NULL DEFAULT '1' COMMENT '是否有效0无效，1有效，2删除',
  `sex` tinyint(4) DEFAULT NULL COMMENT '性别(0 :男  1 ： 女)',
  `birthday` char(11) DEFAULT NULL COMMENT '出生日期',
  `office_phone` varchar(30) DEFAULT NULL COMMENT '办公电话',
  `depart_code` varchar(30) DEFAULT NULL COMMENT '部门编号',
  `depart_name` varchar(20) DEFAULT NULL COMMENT '部门名称',
  `super_leader_code` bigint(11) DEFAULT NULL COMMENT '上级领导编号',
  `super_leader_name` varchar(20) DEFAULT NULL COMMENT '上级领导名称',
  `employ_code` varchar(20) DEFAULT NULL COMMENT '员工编号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `index_emu_name_unique` (`name`) USING BTREE,
  KEY `index_status` (`type`,`status`,`depart_code`) USING BTREE,
  KEY `index_employ_code` (`employ_code`) USING BTREE,
  KEY `index_super_leader_code` (`super_leader_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bx_manage_user
-- ----------------------------

-- ----------------------------
-- Table structure for `bx_manage_user_role`
-- ----------------------------
DROP TABLE IF EXISTS `bx_manage_user_role`;
CREATE TABLE `bx_manage_user_role` (
  `user_id` bigint(11) NOT NULL COMMENT '用户ID',
  `role_id` bigint(11) NOT NULL COMMENT '角色ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `status` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT '角色状态0：无效，1：有效',
  UNIQUE KEY `index_user_role` (`user_id`,`role_id`) USING BTREE,
  KEY `index_role_id` (`role_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bx_manage_user_role
-- ----------------------------

-- ----------------------------
-- Table structure for `bx_origin`
-- ----------------------------
DROP TABLE IF EXISTS `bx_origin`;
CREATE TABLE `bx_origin` (
  `id` int(10) NOT NULL COMMENT '唯一标识',
  `origin` varchar(100) NOT NULL COMMENT '来源',
  `create_time` bigint(15) DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(4) NOT NULL COMMENT '是否有效 0无效 1有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bx_origin
-- ----------------------------

-- ----------------------------
-- Table structure for `bx_user`
-- ----------------------------
DROP TABLE IF EXISTS `bx_user`;
CREATE TABLE `bx_user` (
  `id` varchar(32) NOT NULL COMMENT '用户唯一标识',
  `name` varchar(32) NOT NULL COMMENT '姓名',
  `sex` tinyint(4) DEFAULT '-1' COMMENT '性别-1:未知，0：女 1：男',
  `phone` varchar(32) NOT NULL COMMENT '电话',
  `ident_card` varchar(64) DEFAULT NULL COMMENT '身份证号',
  `province_code` varchar(16) DEFAULT NULL COMMENT '省编码',
  `city_code` varchar(16) DEFAULT NULL COMMENT '市编码',
  `area_code` varchar(16) DEFAULT NULL COMMENT '区编码',
  `o_id` int(10) NOT NULL COMMENT '来源ID',
  `cons_quota` decimal(10,0) DEFAULT NULL COMMENT '消费额度',
  `level` tinyint(4) DEFAULT '0' COMMENT '用户级别',
  `create_time` bigint(15) NOT NULL COMMENT '创建时间',
  `update_time` bigint(15) DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(4) NOT NULL DEFAULT '0' COMMENT '是否有效  1：有效 0：无效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bx_user
-- ----------------------------

-- ----------------------------
-- Table structure for `bx_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `bx_user_info`;
CREATE TABLE `bx_user_info` (
  `id` varchar(32) NOT NULL COMMENT '唯一标识',
  `u_id` varchar(32) NOT NULL COMMENT '用户ID',
  `fir_phone` varchar(16) NOT NULL COMMENT '第一手机',
  `sec_phone` varchar(16) DEFAULT NULL COMMENT '第二手机',
  `wechat` varchar(16) DEFAULT NULL COMMENT '微信号',
  `qq` varchar(16) DEFAULT NULL COMMENT 'QQ号',
  `address` varbinary(100) DEFAULT NULL COMMENT '详细地址',
  `create_time` bigint(15) DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(4) NOT NULL COMMENT '是否有效 0:无效1:有效',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bx_user_info
-- ----------------------------

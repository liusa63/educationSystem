/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50041
Source Host           : localhost:3306
Source Database       : educationsystem

Target Server Type    : MYSQL
Target Server Version : 50041
File Encoding         : 65001

Date: 2017-11-02 19:17:21
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `co_name` varchar(30) default NULL,
  `co_score` double default NULL,
  `co_status` varchar(30) default NULL,
  `ma_id` int(10) default NULL,
  `co_week` varchar(30) default NULL,
  `co_starttime` date default NULL,
  `co_endtime` date default NULL,
  `co_id` int(11) NOT NULL auto_increment,
  PRIMARY KEY  (`co_id`),
  KEY `ma_id` (`ma_id`),
  CONSTRAINT `course_ibfk_1` FOREIGN KEY (`ma_id`) REFERENCES `major` (`ma_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('高数（一）', '5', '1', '1', '16', '2014-09-04', '2015-01-10', '1');
INSERT INTO `course` VALUES ('英语（一）', '4.5', '1', '1', '16', '2014-09-04', '2015-01-10', '2');
INSERT INTO `course` VALUES ('大学物理（一）', '3', '1', '1', '12', '2017-09-04', '2015-01-10', '3');
INSERT INTO `course` VALUES ('c语言', '3', '1', '1', '12', '2014-09-04', '2015-01-10', '4');
INSERT INTO `course` VALUES ('高数（二）', '5', '1', '1', '15', '2015-02-25', '2015-07-08', '5');
INSERT INTO `course` VALUES ('英语（二）', '4.5', '1', '1', '15', '2015-02-25', '2015-07-08', '6');
INSERT INTO `course` VALUES ('计算方法', '2', '1', '1', '10', '2015-09-07', '2016-01-05', '7');
INSERT INTO `course` VALUES ('离散数学', '3', '1', '1', '10', '2015-09-07', '2016-01-05', '8');
INSERT INTO `course` VALUES ('oracle', '3', '1', '1', '8', '2017-09-07', '2018-01-20', '9');
INSERT INTO `course` VALUES ('Linux', '3', '1', '1', '8', '2017-09-07', '2018-01-20', '10');
INSERT INTO `course` VALUES ('VB.net', '2', '1', '1', '8', '2017-09-07', '2018-01-20', '11');
INSERT INTO `course` VALUES ('单片机', '2', '1', '1', '12', '2017-09-07', '2018-01-20', '12');
INSERT INTO `course` VALUES ('汇编语言', '3', '1', '1', '16', '2017-09-07', '2018-01-20', '13');
INSERT INTO `course` VALUES ('数据结构', '3', '1', '3', '16', '2017-09-07', '2018-01-20', '14');
INSERT INTO `course` VALUES ('操作系统', '3', '1', '3', '16', '2017-09-07', '2018-01-20', '15');
INSERT INTO `course` VALUES ('计算机网络', '3', '1', '3', '16', '2017-09-07', '2018-01-20', '16');
INSERT INTO `course` VALUES ('计算机组成原理', '2', '1', '3', '16', '2017-09-07', '2018-01-20', '17');
INSERT INTO `course` VALUES ('就业指导', '2', '1', '3', '16', '2017-09-07', '2018-01-20', '18');
INSERT INTO `course` VALUES ('趣味化学', '2', '2', '3', '8', '2017-09-07', '2018-01-20', '19');
INSERT INTO `course` VALUES ('演讲与口才', '2', '2', '3', '8', '2017-09-07', '2018-01-20', '20');
INSERT INTO `course` VALUES ('c语言选修', '2', '2', '3', '8', '2017-09-07', '2018-01-20', '21');
INSERT INTO `course` VALUES ('SqlServer', '3', '1', '1', '10', '2018-01-25', '2018-06-25', '22');
INSERT INTO `course` VALUES ('c#', '2', '1', '1', '8', '2018-01-25', '2018-06-25', '23');
INSERT INTO `course` VALUES ('高数', '4', '1', '8', '18', '2017-10-19', '2017-10-11', '24');

-- ----------------------------
-- Table structure for `co_te_ev`
-- ----------------------------
DROP TABLE IF EXISTS `co_te_ev`;
CREATE TABLE `co_te_ev` (
  `id` int(11) NOT NULL auto_increment,
  `co_id` int(11) default NULL,
  `st_num` varchar(10) default NULL,
  `te_id` int(11) default NULL,
  `answer1` int(10) default NULL,
  `answer2` int(10) default NULL,
  `answer3` int(10) default NULL,
  `answer4` int(10) default NULL,
  `answer5` int(10) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK_CO_TE_EV_REFERENCE_COURSE` (`co_id`),
  KEY `FK_CO_TE_EV_REFERENCE_TEACHER` (`te_id`),
  KEY `st_id` (`st_num`),
  CONSTRAINT `FK_CO_TE_EV_REFERENCE_COURSE` FOREIGN KEY (`co_id`) REFERENCES `course` (`co_id`),
  CONSTRAINT `FK_CO_TE_EV_REFERENCE_TEACHER` FOREIGN KEY (`te_id`) REFERENCES `teacher` (`te_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of co_te_ev
-- ----------------------------
INSERT INTO `co_te_ev` VALUES ('1', '1', '1407130002', '2', '10', '3', '10', '0', '10');
INSERT INTO `co_te_ev` VALUES ('2', '14', null, '8', '10', '3', '10', '5', '8');
INSERT INTO `co_te_ev` VALUES ('3', '15', null, '8', '10', '8', '10', '8', '5');
INSERT INTO `co_te_ev` VALUES ('4', '16', null, '8', '10', '8', '10', '8', '10');
INSERT INTO `co_te_ev` VALUES ('5', '17', null, '8', '8', '10', '5', '10', '8');
INSERT INTO `co_te_ev` VALUES ('6', '18', null, '8', '8', '10', '5', '10', '8');
INSERT INTO `co_te_ev` VALUES ('7', '14', null, '8', '8', '8', '5', '10', '5');
INSERT INTO `co_te_ev` VALUES ('8', '15', null, '8', '8', '10', '5', '8', '5');
INSERT INTO `co_te_ev` VALUES ('9', '5', '1407130002', '1', '10', '8', '8', '6', '10');
INSERT INTO `co_te_ev` VALUES ('10', '8', '1407130002', '4', '10', '10', '8', '8', '8');
INSERT INTO `co_te_ev` VALUES ('11', '6', '1407130002', '6', '10', '8', '8', '10', '10');
INSERT INTO `co_te_ev` VALUES ('12', '1', '1407130004', '2', '10', '10', '8', '8', '10');
INSERT INTO `co_te_ev` VALUES ('13', '2', '1407130002', '3', '10', '10', '8', '10', '8');

-- ----------------------------
-- Table structure for `en_course`
-- ----------------------------
DROP TABLE IF EXISTS `en_course`;
CREATE TABLE `en_course` (
  `en_id` int(11) NOT NULL auto_increment,
  `ro_id` int(11) default NULL,
  `co_id` int(11) default NULL,
  `cl_id` int(11) default NULL,
  `te_id` int(11) default NULL,
  `en_day` varchar(20) default NULL,
  `en_start` varchar(20) default NULL,
  `en_end` varchar(20) default NULL,
  PRIMARY KEY  (`en_id`),
  KEY `FK_ST_COURS_REFERENCE_ROOM` (`ro_id`),
  KEY `FK_ST_COURS_REFERENCE_COURSE` (`co_id`),
  KEY `FK_ST_COURS_REFERENCE_SCLASS` (`cl_id`),
  KEY `te_id` (`te_id`),
  CONSTRAINT `en_course_ibfk_1` FOREIGN KEY (`te_id`) REFERENCES `teacher` (`te_id`),
  CONSTRAINT `FK_ST_COURS_REFERENCE_COURSE` FOREIGN KEY (`co_id`) REFERENCES `course` (`co_id`),
  CONSTRAINT `FK_ST_COURS_REFERENCE_ROOM` FOREIGN KEY (`ro_id`) REFERENCES `room` (`ro_id`),
  CONSTRAINT `FK_ST_COURS_REFERENCE_SCLASS` FOREIGN KEY (`cl_id`) REFERENCES `sclass` (`cl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of en_course
-- ----------------------------
INSERT INTO `en_course` VALUES ('1', '1', '9', '1', '1', '星期一', '8:00', '10:00');
INSERT INTO `en_course` VALUES ('2', '2', '9', '1', '1', '星期二', '15:00', '17:00');
INSERT INTO `en_course` VALUES ('3', '4', '10', '1', '1', '星期五', '10:00', '12:00');
INSERT INTO `en_course` VALUES ('4', '3', '2', '1', '3', '星期二', '10:00', '12:00');
INSERT INTO `en_course` VALUES ('5', '1', '11', '1', '1', '星期三', '8:00', '10:00');
INSERT INTO `en_course` VALUES ('6', '2', '12', '1', '2', '星期四', '8:00', '10:00');
INSERT INTO `en_course` VALUES ('7', '5', '12', '1', '2', '星期三', '10:00', '12:00');
INSERT INTO `en_course` VALUES ('8', '2', '9', '1', '3', '星期五', '17:00', '19:00');
INSERT INTO `en_course` VALUES ('9', '3', '13', '1', '3', '星期一', '10:00', '12:00');
INSERT INTO `en_course` VALUES ('10', '5', '9', '1', '1', '星期一', '17:00', '19:00');
INSERT INTO `en_course` VALUES ('11', '2', '5', '1', '1', '星期二', '8:00', '10:00');
INSERT INTO `en_course` VALUES ('12', '1', '12', '1', '3', '星期四', '17:00', '19:00');
INSERT INTO `en_course` VALUES ('13', '2', '1', '1', '2', '星期三', '8:00', '10:00');
INSERT INTO `en_course` VALUES ('14', '7', '3', '1', '5', null, null, null);
INSERT INTO `en_course` VALUES ('15', '7', '4', '1', '7', null, null, null);
INSERT INTO `en_course` VALUES ('16', '7', '6', '1', '6', null, null, null);
INSERT INTO `en_course` VALUES ('17', '6', '7', '1', '5', null, null, null);
INSERT INTO `en_course` VALUES ('18', '4', '8', '1', '4', null, null, null);
INSERT INTO `en_course` VALUES ('19', '7', '14', '1', '8', '星期一', '8:00', '10:00');
INSERT INTO `en_course` VALUES ('20', '5', '15', '1', '8', '星期三', '8:00', '10:00');
INSERT INTO `en_course` VALUES ('21', '11', '16', '2', '8', '星期四', '10:00', '12:00');
INSERT INTO `en_course` VALUES ('22', '6', '17', '2', '8', '星期五', '17:00', '19:00');
INSERT INTO `en_course` VALUES ('23', '12', '18', '2', '8', '星期二', '17:00', '19:00');

-- ----------------------------
-- Table structure for `excourse`
-- ----------------------------
DROP TABLE IF EXISTS `excourse`;
CREATE TABLE `excourse` (
  `ex_id` int(11) NOT NULL auto_increment,
  `te_id` int(11) default NULL,
  `ex_name` varchar(30) default NULL,
  `ex_count` int(11) default NULL,
  `ex_week` varchar(30) default NULL,
  `ex_day` varchar(30) default NULL,
  `ex_start` varchar(20) default NULL,
  `ex_end` varchar(20) default NULL,
  `ro_id` int(11) default NULL,
  `ex_score` int(11) default NULL,
  PRIMARY KEY  (`ex_id`),
  KEY `FK_EXCOURSE_REFERENCE_ROOM` (`ro_id`),
  KEY `te_id` (`te_id`),
  CONSTRAINT `excourse_ibfk_1` FOREIGN KEY (`te_id`) REFERENCES `teacher` (`te_id`),
  CONSTRAINT `FK_EXCOURSE_REFERENCE_ROOM` FOREIGN KEY (`ro_id`) REFERENCES `room` (`ro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of excourse
-- ----------------------------
INSERT INTO `excourse` VALUES ('1', '1', '晋商文化', '94', '7', '星期一', '19:00:00', '21:00:00', '1', '2');
INSERT INTO `excourse` VALUES ('2', '3', '孔子、孟子、老子', '69', '7', '星期二', '19:00:00', '21:00:00', '1', '2');
INSERT INTO `excourse` VALUES ('3', '3', '游泳', '92', '7', '星期一', '19:00:00', '21:00:00', '2', '2');
INSERT INTO `excourse` VALUES ('4', '1', '局域网', '94', '7', '星期三', '19:00:00', '21:00:00', '2', '2');
INSERT INTO `excourse` VALUES ('5', '5', '茶道', '94', '7', '星期三', '19:00:00', '21:00:00', '3', '2');
INSERT INTO `excourse` VALUES ('6', '3', '大学生创新创业', '0', '7', '星期五', '19:00:00', '21:00:00', '3', '2');
INSERT INTO `excourse` VALUES ('7', '1', '教育基础', '98', '7', '星期四', '19:00:00', '21:00:00', '2', '2');
INSERT INTO `excourse` VALUES ('8', '8', '趣味化学', '100', '8', '星期四', '19:00:00', '21:00:00', '1', '2');
INSERT INTO `excourse` VALUES ('9', '8', '演讲与口才', '100', '8', '星期五', '19:00:00', '21:00:00', '2', '2');
INSERT INTO `excourse` VALUES ('10', '8', 'c语言选修', '99', '8', '星期三', '19:00:00', '21:00:00', '3', '2');
INSERT INTO `excourse` VALUES ('11', '12', '趣味化学', '34', '12', '星期二', '7:00', '9:00', '8', '4');
INSERT INTO `excourse` VALUES ('12', '12', '趣味化学', '23', '16', '星期二', '7:00', '9:00', '7', '4');
INSERT INTO `excourse` VALUES ('13', '12', '趣味化学', '1', '12', '星期二', '7:00', '9:00', '7', '1');

-- ----------------------------
-- Table structure for `ex_st`
-- ----------------------------
DROP TABLE IF EXISTS `ex_st`;
CREATE TABLE `ex_st` (
  `ex_id` int(10) default NULL,
  `st_id` int(10) default NULL,
  KEY `ex_id` (`ex_id`),
  KEY `st_id` (`st_id`),
  CONSTRAINT `ex_st_ibfk_1` FOREIGN KEY (`ex_id`) REFERENCES `excourse` (`ex_id`),
  CONSTRAINT `ex_st_ibfk_2` FOREIGN KEY (`st_id`) REFERENCES `student` (`st_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ex_st
-- ----------------------------
INSERT INTO `ex_st` VALUES ('3', '1');
INSERT INTO `ex_st` VALUES ('8', '1');
INSERT INTO `ex_st` VALUES ('8', '2');
INSERT INTO `ex_st` VALUES ('8', '3');
INSERT INTO `ex_st` VALUES ('9', '4');
INSERT INTO `ex_st` VALUES ('9', '3');
INSERT INTO `ex_st` VALUES ('9', '6');
INSERT INTO `ex_st` VALUES ('10', '8');
INSERT INTO `ex_st` VALUES ('10', '7');
INSERT INTO `ex_st` VALUES ('4', '1');
INSERT INTO `ex_st` VALUES ('10', '1');
INSERT INTO `ex_st` VALUES ('3', '2');
INSERT INTO `ex_st` VALUES ('5', '1');
INSERT INTO `ex_st` VALUES ('2', '1');

-- ----------------------------
-- Table structure for `grade`
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade` (
  `gr_id` int(10) NOT NULL auto_increment,
  `st_num` varchar(20) default NULL,
  `co_name` varchar(20) default NULL,
  `score` double(10,0) default NULL,
  PRIMARY KEY  (`gr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', '1407130002', '高数（一）', '73');
INSERT INTO `grade` VALUES ('2', '1407130002', '英语（一）', '64');
INSERT INTO `grade` VALUES ('3', '1407130002', '高数（二）', '57');
INSERT INTO `grade` VALUES ('4', '1407130002', '英语（二）', '70');
INSERT INTO `grade` VALUES ('5', '1407130002', '计算方法', '75');
INSERT INTO `grade` VALUES ('7', '1407130010', 'oracle', '12');
INSERT INTO `grade` VALUES ('8', '1407130006', 'oracle', '43');
INSERT INTO `grade` VALUES ('9', '1407130002', 'oracle', '32');
INSERT INTO `grade` VALUES ('10', '1407130014', 'oracle', '21');
INSERT INTO `grade` VALUES ('11', '1407130012', 'oracle', '21');
INSERT INTO `grade` VALUES ('12', '1407130008', 'oracle', '21');
INSERT INTO `grade` VALUES ('13', '1407130004', 'oracle', '12');
INSERT INTO `grade` VALUES ('15', '1407130004', '趣味化学', '85');
INSERT INTO `grade` VALUES ('16', '1407130002', '趣味化学', '80');
INSERT INTO `grade` VALUES ('17', '1407130006', '趣味化学', '78');
INSERT INTO `grade` VALUES ('18', '1407130006', '数据结构', '95');
INSERT INTO `grade` VALUES ('19', '1407130004', '数据结构', '87');
INSERT INTO `grade` VALUES ('20', '1407130002', '数据结构', '89');
INSERT INTO `grade` VALUES ('21', '1407130004', '操作系统', '90');
INSERT INTO `grade` VALUES ('22', '1407130002', '操作系统', '45');
INSERT INTO `grade` VALUES ('23', '1407130006', '操作系统', '67');
INSERT INTO `grade` VALUES ('24', '1407130008', '计算机网络', '89');
INSERT INTO `grade` VALUES ('25', '1407130010', '计算机网络', '78');
INSERT INTO `grade` VALUES ('26', '1407130012', '计算机网络', '67');

-- ----------------------------
-- Table structure for `major`
-- ----------------------------
DROP TABLE IF EXISTS `major`;
CREATE TABLE `major` (
  `ma_id` int(11) NOT NULL auto_increment,
  `ma_name` varchar(30) default NULL,
  PRIMARY KEY  (`ma_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major
-- ----------------------------
INSERT INTO `major` VALUES ('1', '会计');
INSERT INTO `major` VALUES ('2', '大数据专业');
INSERT INTO `major` VALUES ('3', '物联网专业');
INSERT INTO `major` VALUES ('4', '美术专业');
INSERT INTO `major` VALUES ('5', '体育专业');
INSERT INTO `major` VALUES ('6', '土木工程');
INSERT INTO `major` VALUES ('7', '物流专业');
INSERT INTO `major` VALUES ('8', '电气自动化');
INSERT INTO `major` VALUES ('9', '电子商务');
INSERT INTO `major` VALUES ('10', '机械制造与自动化');
INSERT INTO `major` VALUES ('11', '软件工程');
INSERT INTO `major` VALUES ('12', '计算机1');

-- ----------------------------
-- Table structure for `question`
-- ----------------------------
DROP TABLE IF EXISTS `question`;
CREATE TABLE `question` (
  `q_id` int(11) NOT NULL auto_increment,
  `q_content` varchar(10) default NULL,
  `q_a` varchar(10) default NULL,
  `q_b` varchar(10) default NULL,
  `q_c` varchar(10) default NULL,
  `q_d` varchar(10) default NULL,
  PRIMARY KEY  (`q_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of question
-- ----------------------------
INSERT INTO `question` VALUES ('1', '教学态度认真', null, null, null, null);
INSERT INTO `question` VALUES ('2', '总结到位', '10', '8', '5', '3');
INSERT INTO `question` VALUES ('3', '衣着整洁得体', '10', '8', '5', '3');
INSERT INTO `question` VALUES ('5', '辅导学生是否耐心', '10', '8', '5', '3');
INSERT INTO `question` VALUES ('6', '普通话是否标准', '10', '8', '5', '3');

-- ----------------------------
-- Table structure for `room`
-- ----------------------------
DROP TABLE IF EXISTS `room`;
CREATE TABLE `room` (
  `ro_id` int(11) NOT NULL auto_increment,
  `ro_name` varchar(30) default NULL,
  PRIMARY KEY  (`ro_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of room
-- ----------------------------
INSERT INTO `room` VALUES ('1', '阶教 101');
INSERT INTO `room` VALUES ('2', '阶教 102');
INSERT INTO `room` VALUES ('3', '阶教 103');
INSERT INTO `room` VALUES ('4', '阶教 104');
INSERT INTO `room` VALUES ('5', '阶教 105');
INSERT INTO `room` VALUES ('6', '阶教 106');
INSERT INTO `room` VALUES ('7', '阶教 201');
INSERT INTO `room` VALUES ('8', '阶教 202');
INSERT INTO `room` VALUES ('9', '主教  601');
INSERT INTO `room` VALUES ('10', '主教  602');
INSERT INTO `room` VALUES ('11', '主教  502');
INSERT INTO `room` VALUES ('12', '主教  604');
INSERT INTO `room` VALUES ('13', '主教101');
INSERT INTO `room` VALUES ('14', '主教102');
INSERT INTO `room` VALUES ('15', '阶教304');
INSERT INTO `room` VALUES ('16', '阶教205');

-- ----------------------------
-- Table structure for `sclass`
-- ----------------------------
DROP TABLE IF EXISTS `sclass`;
CREATE TABLE `sclass` (
  `cl_id` int(11) NOT NULL auto_increment,
  `ma_id` int(11) default NULL,
  `te_id` int(11) default NULL,
  `cl_name` varchar(30) default NULL,
  `cl_count` int(11) default NULL,
  PRIMARY KEY  (`cl_id`),
  KEY `FK_SCLASS_REFERENCE_TEACHER` (`te_id`),
  KEY `FK_SCLASS_REFERENCE_MAJOR` (`ma_id`),
  CONSTRAINT `FK_SCLASS_REFERENCE_MAJOR` FOREIGN KEY (`ma_id`) REFERENCES `major` (`ma_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_SCLASS_REFERENCE_TEACHER` FOREIGN KEY (`te_id`) REFERENCES `teacher` (`te_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sclass
-- ----------------------------
INSERT INTO `sclass` VALUES ('1', '1', '10', '计算机一班', '10');
INSERT INTO `sclass` VALUES ('2', '1', '10', '计算机二班', '10');
INSERT INTO `sclass` VALUES ('3', '1', '10', '计算机三班', '10');
INSERT INTO `sclass` VALUES ('4', '2', '2', '大数据一班', '9');
INSERT INTO `sclass` VALUES ('5', '2', '2', '大数据二班', '8');
INSERT INTO `sclass` VALUES ('6', '3', '2', '物联网一班', '10');
INSERT INTO `sclass` VALUES ('7', '4', '2', '美术一班', '20');
INSERT INTO `sclass` VALUES ('8', '1', '2', '一班', '12');
INSERT INTO `sclass` VALUES ('9', '1', '2', '一班', '10');

-- ----------------------------
-- Table structure for `sroll`
-- ----------------------------
DROP TABLE IF EXISTS `sroll`;
CREATE TABLE `sroll` (
  `sr_id` int(11) NOT NULL auto_increment,
  `sr_num` varchar(30) default NULL,
  `sr_name` varchar(30) default NULL,
  `sr_sex` varchar(30) default NULL,
  `sr_address` varchar(100) default NULL,
  `sr_img` varchar(300) default NULL,
  `sr_time` date default NULL,
  `sr_birthday` date default NULL,
  `sr_idCard` varchar(100) default NULL,
  `sr_isRoll` varchar(10) default NULL,
  PRIMARY KEY  (`sr_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sroll
-- ----------------------------
INSERT INTO `sroll` VALUES ('1', '1407130002', '一毛', '1', '山西晋城', 'c7.jpg', '2014-09-08', '1994-12-23', '1405987012321', '1');
INSERT INTO `sroll` VALUES ('2', '1407130004', '二毛', '2', '山西长治', 'c10.jpg', '2014-09-08', '1997-08-08', '143536728621', '2');
INSERT INTO `sroll` VALUES ('3', '1407130006', '三毛', '1', '北京海淀', 'gril.jpg', '2014-09-08', '2015-10-08', '1232123', '1');
INSERT INTO `sroll` VALUES ('4', '1407130008', '四毛', '2', '北京房山', 'c16.jpg', '2014-09-08', '2015-10-08', '143536728621', '1');
INSERT INTO `sroll` VALUES ('5', '1407130010', '五毛', '1', '山西忻州', 'c14.jpg', '2014-09-08', '2015-10-08', '143536728621', '1');
INSERT INTO `sroll` VALUES ('6', '1407130012', '六毛', '2', '山西阳泉', 'c16.jpg', '2014-09-08', '2015-10-08', '143536728621', '1');
INSERT INTO `sroll` VALUES ('7', '1407130014', '七毛', '1', '北京昌平', 'c14.jpg', '2014-09-08', '2015-10-08', '143536728621', '1');
INSERT INTO `sroll` VALUES ('8', '5', '高', '1', '山西晋城', 'c6.jpg', '2017-10-04', '2017-10-02', '1405987012321', '1');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `st_id` int(11) NOT NULL auto_increment,
  `cl_id` int(11) default NULL,
  `st_num` varchar(30) default NULL,
  `st_name` varchar(30) default NULL,
  `st_behave` varchar(30) default NULL,
  PRIMARY KEY  (`st_id`),
  KEY `FK_STUDENT_REFERENCE_SCLASS` (`cl_id`),
  CONSTRAINT `FK_STUDENT_REFERENCE_SCLASS` FOREIGN KEY (`cl_id`) REFERENCES `sclass` (`cl_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '1', '1407130002', '一毛', '1');
INSERT INTO `student` VALUES ('2', '1', '1407130004', '二毛', '2');
INSERT INTO `student` VALUES ('3', '1', '1407130006', '三毛', '2');
INSERT INTO `student` VALUES ('4', '2', '1407130008', '四毛', '1');
INSERT INTO `student` VALUES ('5', '2', '1407130010', '五毛', '2');
INSERT INTO `student` VALUES ('6', '2', '1407130012', '六毛', '2');
INSERT INTO `student` VALUES ('7', '3', '1407130014', '七毛', '2');
INSERT INTO `student` VALUES ('8', '3', '1407130016', '八毛', '1');
INSERT INTO `student` VALUES ('9', '7', '5', '高', '');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `te_id` int(11) NOT NULL auto_increment,
  `te_num` varchar(30) default NULL,
  `te_name` varchar(30) default NULL,
  `te_salary` double default NULL,
  `te_phone` varchar(30) default NULL,
  `te_behave` int(11) default NULL,
  `ma_id` int(10) default NULL,
  PRIMARY KEY  (`te_id`),
  KEY `ma_id` (`ma_id`),
  CONSTRAINT `teacher_ibfk_1` FOREIGN KEY (`ma_id`) REFERENCES `major` (`ma_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('1', '1407130001', '乔二', '6000', '1843590863', '1', '1');
INSERT INTO `teacher` VALUES ('2', '1407130003', '乔二', '5000', '1843590863', '2', '1');
INSERT INTO `teacher` VALUES ('3', '1407130005', '乔三', '5000', '1843590863', '1', '1');
INSERT INTO `teacher` VALUES ('4', '1407130007', '乔四', '5000', '1843590863', '2', '1');
INSERT INTO `teacher` VALUES ('5', '1407130009', '乔五', '6000', '1843590863', '1', '1');
INSERT INTO `teacher` VALUES ('6', '1407130011', '乔六', '6000', '1843590863', '2', '1');
INSERT INTO `teacher` VALUES ('7', '1407130013', '乔七', '6000', '1843590863', '1', '1');
INSERT INTO `teacher` VALUES ('8', '1407130015', '大猫', '7000', '13533451087', '1', '3');
INSERT INTO `teacher` VALUES ('9', '1407130016', '二郎', '6000', '18303457841', '1', '3');
INSERT INTO `teacher` VALUES ('10', '1407130017', '小二', '6500', '13635390509', '2', '3');
INSERT INTO `teacher` VALUES ('11', '1407130019', '老大', '1234', '1843590863', '2', '1');
INSERT INTO `teacher` VALUES ('12', '1407130020', '李四', '1234', '18909870098', '1', '8');
INSERT INTO `teacher` VALUES ('13', '1', '1', '121', '12', '2', '9');
INSERT INTO `teacher` VALUES ('14', '1', '2', '2', '2', '1', '8');
INSERT INTO `teacher` VALUES ('15', '3', '3', '3', '3', '1', '8');
INSERT INTO `teacher` VALUES ('16', '4', '4', '4', '4', '1', '9');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `u_id` int(11) NOT NULL auto_increment,
  `u_number` varchar(30) default NULL,
  `u_role` int(11) default NULL,
  `u_pwd` varchar(30) default NULL,
  `u_status` int(11) default NULL,
  PRIMARY KEY  (`u_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '1', '123', '1');
INSERT INTO `user` VALUES ('2', '1407130001', '2', '1', '1');
INSERT INTO `user` VALUES ('3', '1407130002', '3', '1', '1');
INSERT INTO `user` VALUES ('4', '1407130003', '2', '1', '1');
INSERT INTO `user` VALUES ('5', '1407130004', '3', '1', '1');
INSERT INTO `user` VALUES ('6', '1407130005', '2', '1', '1');
INSERT INTO `user` VALUES ('7', '1407130006', '3', '1', '1');
INSERT INTO `user` VALUES ('8', '1407130007', '2', '1', '1');
INSERT INTO `user` VALUES ('9', '1407130008', '3', '1', '1');
INSERT INTO `user` VALUES ('10', '1407130009', '2', '1', '1');
INSERT INTO `user` VALUES ('11', '1407130010', '3', '1', '1');
INSERT INTO `user` VALUES ('12', '1407130011', '2', '1', '1');
INSERT INTO `user` VALUES ('13', '1407130012', '3', '1', '1');
INSERT INTO `user` VALUES ('14', '1407130013', '2', '1', '1');
INSERT INTO `user` VALUES ('15', '1407130014', '3', '1', '1');
INSERT INTO `user` VALUES ('16', '1407130015', '2', '1', '1');
INSERT INTO `user` VALUES ('17', '1407130016', '2', '1', '1');
INSERT INTO `user` VALUES ('18', '1407130017', '2', '1', '1');
INSERT INTO `user` VALUES ('19', '1407130018', '3', '1', '1');
INSERT INTO `user` VALUES ('20', '1407130019', '2', '123', '1');
INSERT INTO `user` VALUES ('21', '1407130020', '2', '123', '0');
INSERT INTO `user` VALUES ('22', '1', '2', '123', '0');
INSERT INTO `user` VALUES ('23', '1', '2', '123', '0');
INSERT INTO `user` VALUES ('24', '3', '2', '123', '0');
INSERT INTO `user` VALUES ('25', '4', '2', '123', '0');
INSERT INTO `user` VALUES ('26', '5', '3', '123', '1');

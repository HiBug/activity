CREATE DATABASE `activity` /*!40100 DEFAULT CHARACTER SET utf8 */;

CREATE TABLE `course` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `schoolId` int(11) DEFAULT NULL COMMENT '驾校id',
  `masterId` int(11) DEFAULT NULL COMMENT '教练id',
  `startDate` date DEFAULT NULL COMMENT '开始日期',
  `endDate` date DEFAULT NULL COMMENT '结束日期',
  `courseRank` int(11) DEFAULT '0',
  `weather` varchar(45) DEFAULT NULL COMMENT '天气',
  `memo` mediumtext COMMENT '备注',
  `crtTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_crtTime` (`crtTime`),
  KEY `idx_masterId` (`masterId`),
  KEY `idx_start_end` (`startDate`,`endDate`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程';

CREATE TABLE `courseinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `courseId` int(11) NOT NULL COMMENT '课程id',
  `studentId` int(11) DEFAULT NULL COMMENT '学员id',
  `rank` int(11) DEFAULT NULL COMMENT '序号',
  `date` date DEFAULT NULL COMMENT '课程日期',
  `week` varchar(45) DEFAULT NULL COMMENT '周几',
  `status` int(11) DEFAULT '0' COMMENT '状态 \n0：初始化\n1：正常\n2：休息\n',
  `crtTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unq_course_rank` (`courseId`,`rank`,`date`),
  KEY `idx_course` (`courseId`),
  KEY `idx_student` (`studentId`),
  KEY `idx_crtTime` (`crtTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='课程信息';

CREATE TABLE `master` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `schoolId` int(11) NOT NULL COMMENT '驾校id',
  `nickName` varchar(45) DEFAULT NULL COMMENT '微信昵称',
  `openId` varchar(45) NOT NULL COMMENT '微信openId',
  `realName` varchar(45) NOT NULL COMMENT '真实姓名',
  `mobile` varchar(45) NOT NULL COMMENT '手机号',
  `courseCount` int(11) DEFAULT '0' COMMENT '课程数',
  `iconUrl` varchar(45) DEFAULT NULL COMMENT '头像地址',
  `studentCountOneDay` int(11) DEFAULT '4' COMMENT '每天带的学员数',
  `periodOneCourse` int(11) DEFAULT '7' COMMENT '一次课的周期，单位：天',
  `crtTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `mobile_UNIQUE` (`mobile`),
  KEY `idx_openId` (`openId`),
  KEY `idx_crtTime` (`crtTime`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='教练';

CREATE TABLE `school` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL COMMENT '名称',
  `mobile` varchar(45) DEFAULT NULL COMMENT '联系手机',
  `teacherCount` int(11) DEFAULT '0',
  `studentCount` int(11) DEFAULT '0',
  `crtTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='驾校';

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `schoolId` int(11) NOT NULL COMMENT '驾校id',
  `masterId` int(11) NOT NULL COMMENT '教练id',
  `openId` varchar(45) NOT NULL COMMENT '微信id',
  `courseCount` int(11) DEFAULT '0',
  `nickName` varchar(45) DEFAULT NULL COMMENT '微信昵称',
  `realName` varchar(45) DEFAULT NULL COMMENT '真实姓名',
  `mobile` varchar(45) DEFAULT NULL COMMENT '手机号',
  `crtTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_openId` (`openId`),
  KEY `idx_masterId` (`masterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='学员';


CREATE TABLE `studentgraduated` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `schoolId` int(11) NOT NULL COMMENT '驾校id',
  `masterId` int(11) NOT NULL COMMENT '教练id',
  `openId` varchar(45) NOT NULL COMMENT '微信id',
  `courseCount` int(11) DEFAULT '0',
  `nickName` varchar(45) DEFAULT NULL COMMENT '微信昵称',
  `realName` varchar(45) DEFAULT NULL COMMENT '真实姓名',
  `useTime` int(11) DEFAULT NULL COMMENT '用时，单位：天',
  `mobile` varchar(45) DEFAULT NULL COMMENT '手机号',
  `crtTime` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `idx_openId` (`openId`),
  KEY `idx_masterId` (`masterId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='毕业学员';

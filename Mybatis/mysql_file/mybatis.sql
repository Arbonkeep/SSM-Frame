
-- 创建mybatis库
CREATE DATABASE mybatis;


-- exit表

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(32) NOT NULL COMMENT '用户名称',
  `birthday` DATETIME DEFAULT NULL COMMENT '生日',
  `sex` CHAR(1) DEFAULT NULL COMMENT '性别',
  `address` VARCHAR(256) DEFAULT NULL COMMENT '地址',
  PRIMARY KEY  (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;


-- 插入数据
INSERT  INTO `user`(`id`,`username`,`birthday`,`sex`,`address`) VALUES
 (41,'老王','2018-02-27 17:47:08','男','北京'),
 (42,'小二王','2018-03-02 15:09:37','女','北京金燕龙'),
 (43,'小二王','2018-03-04 11:34:34','女','北京金燕龙'),
 (45,'传智播客','2018-03-04 12:04:06','男','北京金燕龙'),
 (46,'老王','2018-03-07 17:37:26','男','北京'),
 (48,'小马宝莉','2018-03-08 11:44:00','女','北京修正');


SELECT * FROM USER;




DROP TABLE IF EXISTS `account`;

CREATE TABLE `account` (
  `ID` INT(11) NOT NULL COMMENT '编号',
  `UID` INT(11) DEFAULT NULL COMMENT '用户编号',
  `MONEY` DOUBLE DEFAULT NULL COMMENT '金额',
  PRIMARY KEY  (`ID`),
  KEY `FK_Reference_8` (`UID`),
  CONSTRAINT `FK_Reference_8` FOREIGN KEY (`UID`) REFERENCES `user` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;



INSERT  INTO `account`(`ID`,`UID`,`MONEY`) VALUES (1,41,1000),(2,45,1000),(3,41,2000);


DESC account;
select * from account;


select * from role;


DROP TABLE IF EXISTS `role`;

CREATE TABLE `role` (
  `ID` INT(11) NOT NULL COMMENT '编号',
  `ROLE_NAME` VARCHAR(30) DEFAULT NULL COMMENT '角色名称',
  `ROLE_DESC` VARCHAR(60) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY  (`ID`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;



INSERT  INTO `role`(`ID`,`ROLE_NAME`,`ROLE_DESC`) VALUES 
(1,'院长','管理整个学院'),
(2,'总裁','管理整个公司'),
(3,'校长','管理整个学校');





DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role` (
  `UID` INT(11) NOT NULL COMMENT '用户编号',
  `RID` INT(11) NOT NULL COMMENT '角色编号',
  PRIMARY KEY  (`UID`,`RID`),
  KEY `FK_Reference_10` (`RID`),
  CONSTRAINT `FK_Reference_10` FOREIGN KEY (`RID`) REFERENCES `role` (`ID`),
  CONSTRAINT `FK_Reference_9` FOREIGN KEY (`UID`) REFERENCES `user` (`id`)
) ENGINE=INNODB DEFAULT CHARSET=utf8;

INSERT  INTO `user_role`(`UID`,`RID`) VALUES (41,1),(45,1),(41,2);



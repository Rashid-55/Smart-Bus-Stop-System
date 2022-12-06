/*
SQLyog - Free MySQL GUI v5.19
Host - 5.0.15-nt : Database - android_bustracking_system
*********************************************************************
Server version : 5.0.15-nt
*/

SET NAMES utf8;

SET SQL_MODE='';

create database if not exists `android_bustracking_system`;

USE `android_bustracking_system`;

SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO';

/*Table structure for table `m_admin` */

DROP TABLE IF EXISTS `m_admin`;

CREATE TABLE `m_admin` (
  `id` int(10) NOT NULL auto_increment,
  `username` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `name` varchar(100) NOT NULL,
  `sex` varchar(50) NOT NULL,
  `cell` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `address` varchar(200) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_admin` */

insert into `m_admin` (`id`,`username`,`password`,`name`,`sex`,`cell`,`phone`,`email`,`address`) values (1,'admin','admin','Munna Kumar','Male','8899776655','8877665544','amm@gmail.com','Jayanagar');

/*Table structure for table `m_route` */

DROP TABLE IF EXISTS `m_route`;

CREATE TABLE `m_route` (
  `route_bus_no` varchar(150) NOT NULL,
  `route_name` varchar(150) NOT NULL,
  `route_from` varchar(150) NOT NULL,
  `route_to` varchar(50) default NULL,
  `route_bus_pwd` varchar(50) default NULL,
  `route_bus_latitude` varchar(50) default NULL,
  `route_bus_longitude` varchar(50) default NULL,
  PRIMARY KEY  (`route_bus_no`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_route` */

insert into `m_route` (`route_bus_no`,`route_name`,`route_from`,`route_to`,`route_bus_pwd`,`route_bus_latitude`,`route_bus_longitude`) values ('201','JayaNagar To Koramangala','JayaNagar','Koramankala','357','12.934506','77.589054');
insert into `m_route` (`route_bus_no`,`route_name`,`route_from`,`route_to`,`route_bus_pwd`,`route_bus_latitude`,`route_bus_longitude`) values ('3E','JayaNagar To BTM Layout','JayaNagar','BTM Layout','4567','0','0');
insert into `m_route` (`route_bus_no`,`route_name`,`route_from`,`route_to`,`route_bus_pwd`,`route_bus_latitude`,`route_bus_longitude`) values ('60E','JayaNagara To BTM Layout','JayaNagar','BTM Layout','1234','0','0');

/*Table structure for table `m_student` */

DROP TABLE IF EXISTS `m_student`;

CREATE TABLE `m_student` (
  `stu_code` int(10) NOT NULL auto_increment,
  `stu_roll_no` varchar(50) NOT NULL,
  `stu_class_sec` varchar(50) NOT NULL,
  `stu_name` varchar(50) NOT NULL,
  `stu_sex` varchar(50) NOT NULL,
  `stu_dob` varchar(100) NOT NULL,
  `stu_cell_no` varchar(20) NOT NULL,
  `stu_father_name` varchar(20) NOT NULL,
  `stu_mother_name` varchar(50) NOT NULL,
  `stu_address` varchar(200) NOT NULL,
  `route_bus_no` varchar(40) default NULL,
  `land_id` int(10) default NULL,
  PRIMARY KEY  (`stu_code`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `m_student` */

insert into `m_student` (`stu_code`,`stu_roll_no`,`stu_class_sec`,`stu_name`,`stu_sex`,`stu_dob`,`stu_cell_no`,`stu_father_name`,`stu_mother_name`,`stu_address`,`route_bus_no`,`land_id`) values (1,'14XI001','B','ammu','Female','02/15/2000','9066172779','Chithu','Manish','BTM,Bangalore-57.','3E',3);
insert into `m_student` (`stu_code`,`stu_roll_no`,`stu_class_sec`,`stu_name`,`stu_sex`,`stu_dob`,`stu_cell_no`,`stu_father_name`,`stu_mother_name`,`stu_address`,`route_bus_no`,`land_id`) values (2,'14XI002','A Sec','user','Male','02/17/1999','8892180776','Chenthu','Chinna','Bangalore','60E',1);
insert into `m_student` (`stu_code`,`stu_roll_no`,`stu_class_sec`,`stu_name`,`stu_sex`,`stu_dob`,`stu_cell_no`,`stu_father_name`,`stu_mother_name`,`stu_address`,`route_bus_no`,`land_id`) values (3,'09mca23','A','xxx','Female','04/14/2014','8899776655','xxxx','zzzz','Bangalore','201',4);

/*Table structure for table `t_route` */

DROP TABLE IF EXISTS `t_route`;

CREATE TABLE `t_route` (
  `land_id` int(10) NOT NULL auto_increment,
  `route_bus_no` varchar(10) default NULL,
  `pickup_no` int(10) default NULL,
  `land_mark` varchar(150) default NULL,
  `latitude` varchar(250) default NULL,
  `longitude` varchar(250) default NULL,
  `text_msg` varchar(100) default NULL,
  PRIMARY KEY  (`land_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `t_route` */

insert into `t_route` (`land_id`,`route_bus_no`,`pickup_no`,`land_mark`,`latitude`,`longitude`,`text_msg`) values (1,'60E',1,'JayaNagar East End','12.934506','77.589054','Near of Land Mark');
insert into `t_route` (`land_id`,`route_bus_no`,`pickup_no`,`land_mark`,`latitude`,`longitude`,`text_msg`) values (3,'60E',2,'Axa Building','12.931031','77.627678','Near of Land Mark');
insert into `t_route` (`land_id`,`route_bus_no`,`pickup_no`,`land_mark`,`latitude`,`longitude`,`text_msg`) values (4,'201',1,'5','12.919512','77.610598','Near of Land Mark');
insert into `t_route` (`land_id`,`route_bus_no`,`pickup_no`,`land_mark`,`latitude`,`longitude`,`text_msg`) values (5,'201',2,'8','12.928176','77.587531','Near to Your LandMark');
insert into `t_route` (`land_id`,`route_bus_no`,`pickup_no`,`land_mark`,`latitude`,`longitude`,`text_msg`) values (6,'201',3,'11','12.914241','77.61034','Near to Your LandMark');
insert into `t_route` (`land_id`,`route_bus_no`,`pickup_no`,`land_mark`,`latitude`,`longitude`,`text_msg`) values (7,'201',4,'18',NULL,NULL,NULL);
insert into `t_route` (`land_id`,`route_bus_no`,`pickup_no`,`land_mark`,`latitude`,`longitude`,`text_msg`) values (8,'201',5,'15',NULL,NULL,NULL);
insert into `t_route` (`land_id`,`route_bus_no`,`pickup_no`,`land_mark`,`latitude`,`longitude`,`text_msg`) values (9,'201',6,'21',NULL,NULL,NULL);

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;

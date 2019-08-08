## 创建数据库
CREATE DATABASE javaguideslave;





## 初始化表
DROP TABLE IF EXISTS `activity_pv`;
CREATE TABLE `activity_pv` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `activity_id` varchar(32) NOT NULL default '' COMMENT '活动id',
  `position_type` tinyint(10) NOT NULL default 0 COMMENT '广告位置 1.活动页 2.首页',
  `ip` varchar (15) NOT NULL DEFAULT '' COMMENT 'ip地址',
  `device_type` varchar(32) NOT NULL default '' COMMENT '设备类型',
  `device_no` varchar (32) NOT NULL default '' COMMENT '设备号',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


## 创建账号
create user 'root'@'%' identified with mysql_native_password by 'Nivelle123';

## 给当前账号授权
GRANT ALL PRIVILEGES ON javaguides.* TO 'root'@'localhost' IDENTIFIED BY 'Nivelle123' WITH GRANT OPTION;

## 查看数据库
show databases;

## 使用某个数据库
use databases;

## 查看所有表
show tables;

## 创建唯一索引
create unique index uniq_device_no on activity_pv(`device_no`);

## 创建联合索引
CREATE INDEX device ON activity_pv (`device_type`,`device_no`);

## 查看索引
show index from activity_pv;

+-------------+------------+----------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+---------+------------+
| Table       | Non_unique | Key_name       | Seq_in_index | Column_name | Collation | Cardinality | Sub_part | Packed | Null | Index_type | Comment | Index_comment | Visible | Expression |
+-------------+------------+----------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+---------+------------+
| activity_pv |          0 | PRIMARY        |            1 | id          | A         |           3 |     NULL |   NULL |      | BTREE      |         |               | YES     | NULL       |
| activity_pv |          0 | uniq_device_no |            1 | device_no   | A         |           3 |     NULL |   NULL |      | BTREE      |         |               | YES     | NULL       |
| activity_pv |          1 | device         |            1 | device_type | A         |           2 |     NULL |   NULL |      | BTREE      |         |               | YES     | NULL       |
| activity_pv |          1 | device         |            2 | device_no   | A         |           3 |     NULL |   NULL |      | BTREE      |         |               | YES     | NULL       |
+-------------+------------+----------------+--------------+-------------+-----------+-------------+----------+--------+------+------------+---------+---------------+---------+------------+





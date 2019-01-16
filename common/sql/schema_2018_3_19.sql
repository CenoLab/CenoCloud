# sso 系统
CREATE database if not exists sso_iot;
use sso_iot;
create table if not exists developers(
  id int(32) not null PRIMARY KEY key auto_increment,
  d_name varchar(32) not null,
  d_company varchar(64),
  d_email VARCHAR(64),
  d_phone VARCHAR (64),
  d_pwd VARCHAR (64) not null,
  d_token VARCHAR (64) not null,

  #客户端token 2018_3_19
--   d_android_token VARCHAR (64) not null,
--   d_iphone_token VARCHAR (64) not null,
  #申请客户端登陆授权token 2018_3_19
--   d_auth_token VARCHAR (64) not null,
  #客户端是否在线 2018_3_19
--   d_is_android_online TINYINT DEFAULT 0,
--   d_is_iphone_online TINYINT DEFAULT 0,

  d_is_active TINYINT DEFAULT 0,
  d_avatar INT(32) DEFAULT 0,
  d_createtime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  index(d_name),
  index(d_email),
  index(d_phone),
  index(d_email,d_pwd),
  index(d_email,d_token)
)Engine = InnoDB;
--  2018_3_19
alter table developers add d_android_token VARCHAR (64) not null;
alter table developers add d_iphone_token VARCHAR (64) not null;
alter table developers add d_auth_token VARCHAR (64) not null;
alter table developers add d_is_android_online TINYINT DEFAULT 0;
alter table developers add d_is_iphone_online TINYINT DEFAULT 0;

-- new table
-- +---------------------+-------------+------+-----+-------------------+----------------+
-- | Field               | Type        | Null | Key | Default           | Extra          |
-- +---------------------+-------------+------+-----+-------------------+----------------+
-- | id                  | int(32)     | NO   | PRI | NULL              | auto_increment |
-- | d_name              | varchar(32) | NO   | MUL | NULL              |                |
-- | d_company           | varchar(64) | YES  |     | NULL              |                |
-- | d_email             | varchar(64) | YES  | MUL | NULL              |                |
-- | d_phone             | varchar(64) | YES  | MUL | NULL              |                |
-- | d_pwd               | varchar(64) | NO   |     | NULL              |                |
-- | d_token             | varchar(64) | NO   |     | NULL              |                |
-- | d_is_active         | tinyint(4)  | YES  |     | 0                 |                |
-- | d_avatar            | int(32)     | YES  |     | 0                 |                |
-- | d_createtime        | timestamp   | NO   |     | CURRENT_TIMESTAMP |                |
-- | d_android_token     | varchar(64) | NO   |     | NULL              |                |
-- | d_iphone_token      | varchar(64) | NO   |     | NULL              |                |
-- | d_auth_token        | varchar(64) | NO   |     | NULL              |                |
-- | d_is_android_online | tinyint(4)  | YES  |     | 0                 |                |
-- | d_is_iphone_online  | tinyint(4)  | YES  |     | 0                 |                |
-- +---------------------+-------------+------+-----+-------------------+----------------+


#验证码信息
create table if not exists developer_verify(
  id int(32) not null PRIMARY KEY auto_increment,
  d_id int(32) not null,
  d_email VARCHAR(64),
  d_phone VARCHAR (64),
  d_email_code VARCHAR(6),
  d_phone_code VARCHAR(6),
  d_email_code_sendtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  d_phone_code_sendtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  d_verify_createtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)Engine = InnoDB;

# 开发者附加信息
create table if not exists developer_adds(
  id int(32) not null PRIMARY KEY key auto_increment,
  d_id int(32) not null,
  d_profession varchar(64) not null COMMENT '行业',
  d_bussiness VARCHAR(64) not null COMMENT '主营业务',
  d_website VARCHAR (64) not null,
  d_country VARCHAR (64) not null,
  d_address VARCHAR (64) not null,
  d_street VARCHAR (64) not null,
  d_tel VARCHAR (64) not null,
  d_fax VARCHAR (64) not null,
  d_adds_createtime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)Engine =InnoDB;

# 开发者实名认证..
create table if not exists developer_real(
  id int(32) not null PRIMARY KEY key auto_increment,
  d_id int(32) not null,
  d_realname VARCHAR(64) NOT NULL,
  d_id_real VARCHAR(64) NOT NULL,
  d_id_pic_front int(32) NOT NULL,
  d_id_pic_back int(32) NOT NULL,
  d_id_is_pass TINYINT DEFAULT 0 NOT NULL,
  d_id_authenticate_id int(32) NOT NULL,
  d_authenticate_createtime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)Engine=InnoDB;


#应用系统
CREATE database if not exists app_iot;
use app_iot;
create table if not exists apps(
    id int(32) not null PRIMARY KEY AUTO_INCREMENT,
    d_id int(32) not null,
    a_name VARCHAR(64) NOT NULL ,
    a_type VARCHAR(64) NOT NULL ,
    a_tech VARCHAR(32) not NULL ,
    a_trans TINYINT DEFAULT 1 COMMENT '0定长，1变长',
    a_company VARCHAR(64) NOT NULL ,
    a_product_key VARCHAR(64) NOT NULL ,
    a_product_secret VARCHAR(64) not null,
    a_max_connect int(32) NOT NULL ,
    a_createtime TIMESTAMP not NULL DEFAULT current_timestamp,
    a_desc TEXT,

    index(a_name),
    index(a_product_key)

)Engine=InnoDB;

# 数据点
CREATE TABLE  if NOT EXISTS datapoint(
  id int(32) PRIMARY KEY  NOT NULL  AUTO_INCREMENT,
  a_id int(32) NOT NULL ,
  p_name VARCHAR(64) NOT NULL ,
  p_type VARCHAR(32) NOT NULL ,
  p_count int(32) NOT NULL,
  p_access TINYINT NOT NULL DEFAULT 0,
  p_create_time DATETIME DEFAULT  CURRENT_TIMESTAMP
)Engine = InnoDB;

#此表动态创建，一个开发者一张，用来储存设备连接状态
create table if not exists developer_1_client(
  id int(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  a_id int(32) NOT NULL,
  client_id varchar(64) not null,
  is_online tinyint default 0,
  last_online datetime default CURRENT_TIMESTAMP,
  last_offline datetime default CURRENT_TIMESTAMP,
  create_time datetime default CURRENT_TIMESTAMP,
  conn_count int(32) NOT NULL default 0
)Engine= InnoDB;

# 消费余与余额系统
create database balance_iot;
use balance_iot;
drop table balance;
create  table balance(
    id int(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
    d_id int(32) NOT NULL,
    total_conn_count int(32) DEFAULT 100,
    rest_conn_count int(32) DEFAULT 100,
    total_money int(64) DEFAULT 0,
    rest_money int(64) DEFAULT 0,
    create_time DATETIME DEFAULT  CURRENT_TIMESTAMP
)Engine = InnoDB;





# 数据系统
#消息数据动态生成
CREATE  TABLE if NOT EXISTS ${name} (
  id int(64) PRIMARY KEY auto_increment,
  a_id int(32) NOT NULL ,
  m_from VARCHAR (64) NOT NULL ,
  m_to VARCHAR (64) NOT NULL ,
  m_qos VARCHAR (64) NOT NULL ,
  m_message text NOT NULL ,
  m_create_time DATETIME DEFAULT CURRENT_TIMESTAMP
)Engine=InnoDB;

# 静态资源系统
create database if not exists static_iot;
use static_iot;
#图片资源
CREATE table if not exists img(
  id int(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  i_hash_code VARCHAR(64) NOT NULL,
  i_file_name varchar(64) not null,
  i_file_path VARCHAR(64) not null,
  i_file_size bigint,
  i_file_type VARCHAR(32),
  i_uploader_id BIGINT not null,
  i_upload_time DATETIME DEFAULT CURRENT_TIMESTAMP,
  index(i_hash_code)
)Engine=InnoDB;


# 告警系统
create database if not exists alarm_iot;
use alarm_iot;

#表达式
drop table express;
CREATE  TABLE  if NOT EXISTS express(
id int(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
opeator VARCHAR(64) not null comment '表达式',
create_time DATETIME DEFAULT current_timestamp
)Engine = InnoDB;

#告警规则
drop table conditions;
CREATE  TABLE  if NOT EXISTS conditions(
id int(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
d_id int(32) NOT NULL,
d_index int(32) comment '数据点数组位置',
express_id int(32) not null comment '表达式',
right_value_type tinyint DEFAULT 0 comment '0：CONSTANT,1: variable',
right_value VARCHAR(64) comment '表达式右值',
create_time DATETIME DEFAULT current_timestamp
)Engine = InnoDB;

#告警日志
drop table alarm_log_${appID};
CREATE  TABLE  if NOT EXISTS alarm_log_${appID}(
  id int(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  d_id int(32) not null,
  m_id int(32) NOT NULL,
  c_id int(32) NOT NULL,
  create_time DATETIME DEFAULT current_timestamp
)Engine = InnoDB;

# 日志系统
create database if not exists log_iot;
use log_iot;

CREATE TABLE  if NOT EXISTS app_${id}_client_log(
  id int(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  l_type int(32) NOT NULL ,
  l_level int(32) NOT NULL ,
  l_log TEXT charset utf8 collate utf8_general_ci,
  l_create_time DATETIME DEFAULT current_timestamp
)Engine = InnoDB;

CREATE  TABLE  if NOT EXISTS sys_log(
 id int(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
 l_s_type int(32) NOT  NULL ,
 l_s_content VARCHAR(256) charset utf8 COLLATE utf8_general_ci,
 l_s_create_time DATETIME DEFAULT current_timestamp
)Engine = InnoDB;



#监控系统与子账号系统
create database if not exists monitor_iot;
use monitor_iot;

create table if not exists account(
  id int(32) not NULL  PRIMARY KEY AUTO_INCREMENT,
  f_id int(32) NOT NULL,
  a_level int(32) NOT NULL,
  a_name varchar(64),
  a_email VARCHAR(64),
  a_phone int(15),
  a_company VARCHAR(64),
  a_label VARCHAR(64),
  a_address VARCHAR(64),
  a_logo VARCHAR(64)
)Engine = InnoDB;

#监控关系
create table if not exists monitor_${appID}_relation(
    id int(32) not NULL  PRIMARY KEY AUTO_INCREMENT,
    a_id int(32) not null comment '子账号ID',
    c_id varchar(64) not null comment '设备clientID',

    m_create_time DATETIME DEFAULT current_timestamp
)Engine = InnoDB;



#小程序与智能硬件开发平台
create database if not exists dev_iot;
use dev_iot;

#数据点-小程序组件-智能模组管脚映射
create table if not exists mapper(
  id int(32) not NULL  PRIMARY KEY AUTO_INCREMENT,
  a_id int(32) NOT NULL COMMENT '应用程序ID',
  d_id int(32) NOT NULL COMMENT '数据点ID',
  f_id int(32) NOT NULL COMMENT '智能模组管脚ID',
  b_type VARCHAR(32) NOT NULL COMMENT  '智能模组型号',
  m_create_time DATETIME DEFAULT current_timestamp
);


# 整体系统基础配置
create database config_iot;
use config_iot;
create table if not EXISTS  config(
  id int(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  k varchar(64) not null,
  v VARCHAR(128) NOT NULL
)Engine = InnoDB;
insert into config (k,v) VALUES ("copyright","Copyright ©2017 All Rights Reserved. CenoCloud 版权所有");
insert into config (k,v) VALUES ("address","天津大学");
insert into config (k,v) VALUES ("beian","京ICP备********号");





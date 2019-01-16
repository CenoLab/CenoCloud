# sso 系统
CREATE database if not exists sso_iot;
use sso_iot;
create table if not exists developers(
  id int(32) not null PRIMARY KEY key auto_increment,
  d_name varchar(32) not null charset utf8 collate utf8_general_ci,
  d_company varchar(64) charset utf8 collate utf8_general_ci,
  d_email VARCHAR(64) charset utf8 collate utf8_general_ci,
  d_phone VARCHAR (64) charset utf8 collate utf8_general_ci,
  d_pwd VARCHAR (64)  not null charset utf8 collate utf8_general_ci,
  d_token VARCHAR (64) not null charset utf8 collate utf8_general_ci,

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
  d_email VARCHAR(64) charset utf8 collate utf8_general_ci,
  d_phone VARCHAR (64) charset utf8 collate utf8_general_ci,
  d_email_code VARCHAR(6) charset utf8 collate utf8_general_ci,
  d_phone_code VARCHAR(6) charset utf8 collate utf8_general_ci,
  d_email_code_sendtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  d_phone_code_sendtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  d_verify_createtime TIMESTAMP DEFAULT CURRENT_TIMESTAMP
)Engine = InnoDB;

# 开发者附加信息
create table if not exists developer_adds(
  id int(32) not null PRIMARY KEY key auto_increment,
  d_id int(32) not null,
  d_profession varchar(64) not null charset utf8 collate utf8_general_ci COMMENT '行业',
  d_bussiness VARCHAR(64) not null charset utf8 collate utf8_general_ci COMMENT '主营业务',
  d_website VARCHAR (64) not null charset utf8 collate utf8_general_ci,
  d_country VARCHAR (64) not null charset utf8 collate utf8_general_ci,
  d_address VARCHAR (64) not null charset utf8 collate utf8_general_ci,
  d_street VARCHAR (64) not null charset utf8 collate utf8_general_ci,
  d_tel VARCHAR (64) not null charset utf8 collate utf8_general_ci,
  d_fax VARCHAR (64) not null charset utf8 collate utf8_general_ci,
  d_adds_createtime TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)Engine =InnoDB;

# 开发者实名认证..
create table if not exists developer_real(
  id int(32) not null PRIMARY KEY key auto_increment,
  d_id int(32) not null,
  d_realname VARCHAR(64) NOT NULL charset utf8 collate utf8_general_ci,
  d_id_real VARCHAR(64) NOT NULL charset utf8 collate utf8_general_ci,
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
    a_name VARCHAR(64) NOT NULL charset utf8 collate utf8_general_ci,
    a_type VARCHAR(64) NOT NULL charset utf8 collate utf8_general_ci,
    a_tech VARCHAR(32) not NULL charset utf8 collate utf8_general_ci,
    a_trans TINYINT DEFAULT 1 COMMENT '0定长，1变长',
    a_company VARCHAR(64) NOT NULL charset utf8 collate utf8_general_ci,
    a_product_key VARCHAR(64) NOT NULL charset utf8 collate utf8_general_ci,
    a_product_secret VARCHAR(64) not null charset utf8 collate utf8_general_ci,
    a_max_connect int(32) NOT NULL ,
    a_createtime TIMESTAMP not NULL DEFAULT current_timestamp,
    a_desc TEXT charset utf8 collate utf8_general_ci,

    index(a_name),
    index(a_product_key)

)Engine=InnoDB;

# 数据点
CREATE TABLE  if NOT EXISTS datapoint(
  id int(32) PRIMARY KEY  NOT NULL  AUTO_INCREMENT,
  a_id int(32) NOT NULL ,
  p_name VARCHAR(64) NOT NULL charset utf8 collate utf8_general_ci,
  p_type VARCHAR(32) NOT NULL charset utf8 collate utf8_general_ci,
  p_count int(32) NOT NULL,
  p_access TINYINT NOT NULL DEFAULT 0,
  p_create_time DATETIME DEFAULT  CURRENT_TIMESTAMP
)Engine = InnoDB;

#此表动态创建,一个开发者一张,用来储存设备连接状态
create table if not exists developer_1_client(
  id int(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  a_id int(32) NOT NULL,
  client_id varchar(64) not null charset utf8 collate utf8_general_ci,
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
  m_from VARCHAR (64) NOT NULL charset utf8 collate utf8_general_ci,
  m_to VARCHAR (64) NOT NULL charset utf8 collate utf8_general_ci,
  m_qos VARCHAR (64) NOT NULL charset utf8 collate utf8_general_ci,
  m_message text NOT NULL charset utf8 collate utf8_general_ci,
  m_create_time DATETIME DEFAULT CURRENT_TIMESTAMP
)Engine=InnoDB;

# 静态资源系统
create database if not exists static_iot;
use static_iot;
#图片资源
CREATE table if not exists img(
  id int(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  i_hash_code VARCHAR(64) NOT NULL charset utf8 collate utf8_general_ci,
  i_file_name varchar(64) not null charset utf8 collate utf8_general_ci,
  i_file_path VARCHAR(64) not null charset utf8 collate utf8_general_ci,
  i_file_size bigint,
  i_file_type VARCHAR(32) charset utf8 collate utf8_general_ci,
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
opeator VARCHAR(64) not null charset utf8 collate utf8_general_ci comment '表达式',
create_time DATETIME DEFAULT current_timestamp
)Engine = InnoDB;

#告警规则
drop table conditions;
CREATE  TABLE  if NOT EXISTS conditions(
id int(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
name VARCHAR(64) charset utf8 collate utf8_general_ci,
d_id int(32) NOT NULL,
d_index int(32) comment '数据点数组位置',
express_id int(32) not null comment '表达式',
right_value_type tinyint DEFAULT 0 comment '0：CONSTANT,1: variable',
right_value VARCHAR(64) charset utf8 collate utf8_general_ci comment '表达式右值',
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
  a_name varchar(64) charset utf8 COLLATE utf8_general_ci,
  a_email VARCHAR(64) charset utf8 COLLATE utf8_general_ci,
  a_phone int(15),
  a_company VARCHAR(64) charset utf8 COLLATE utf8_general_ci,
  a_label VARCHAR(64) charset utf8 COLLATE utf8_general_ci,
  a_address VARCHAR(64) charset utf8 COLLATE utf8_general_ci,
  a_logo VARCHAR(64) charset utf8 COLLATE utf8_general_ci
)Engine = InnoDB;

#监控关系
create table if not exists monitor_${appID}_relation(
    id int(32) not NULL  PRIMARY KEY AUTO_INCREMENT,
    a_id int(32) not null comment '子账号ID',
    c_id varchar(64) not null charset utf8 COLLATE utf8_general_ci comment '设备clientID',

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
  b_type VARCHAR(32) NOT NULL charset utf8 COLLATE utf8_general_ci COMMENT  '智能模组型号',
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





#权限系统
create database admin_iot;
use admin_iot;
# 用户角色表
create table if not EXISTS  role(
  id int(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT, #角色ID
  name VARCHAR (32) NOT NULL ,# 角色名称
  create_time DATETIME DEFAULT current_timestamp
)Engine = InnoDB;

# 用户权限表
create table if not EXISTS  access(
  id int(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT, #权限ID
  r_id int(32) not null, #角色ID
  name VARCHAR (32) NOT NULL charset utf8 COLLATE utf8_general_ci,# 权限名称
  action VARCHAR(128) not null charset utf8 COLLATE utf8_general_ci, # 权限可访问动作:方法
  create_time DATETIME DEFAULT current_timestamp
)Engine = InnoDB;

# 工单系统
create database wo_iot;
use wo_iot;

# 工单表
create table if not EXISTS  wo(
  id int(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT, #工单ID
  u_id int(32) not null,
  product_type tinyint DEFAULT 0, # 产品类型
  product_id int(32) not null, # 产品ID
  problem_type tinyint DEFAULT 0, #问题类型
  title VARCHAR (128) NOT NULL charset utf8 COLLATE utf8_general_ci,# 标题
  level int(32) not null DEFAULT 0,#紧急程度
  level_content VARCHAR(64) charset utf8 COLLATE utf8_general_ci,#紧急描述
  content VARCHAR (256) charset utf8 COLLATE utf8_general_ci,# 问题描述
  attach VARCHAR (128) charset utf8 COLLATE utf8_general_ci,# 附件
  contact VARCHAR (64) not null charset utf8 COLLATE utf8_general_ci,# 联系方式
  status tinyint not NULL DEFAULT 0,# 工单状态
  create_time DATETIME DEFAULT current_timestamp
)Engine = InnoDB;

# 工单解决清单表
create table if not EXISTS  wo_solution(
  id int(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT, #解决ID
  wo_id int(32) not null ,# 工单ID
  u_id int(32) NOT null,# 处理人
  content int(32) not null,# 工单回复
  attach VARCHAR (128) charset utf8 COLLATE utf8_general_ci,# 附件
  create_time DATETIME DEFAULT current_timestamp
)Engine = InnoDB;

# 添加论坛相关
create database iot_forum;
use iot_forum;

# 文章
create table if not exists article(
  id int(32) PRIMARY KEY auto_increment,

  author_id int(32) NOT NULL,
  title VARCHAR(64) NOT NULL charset utf8 COLLATE utf8_general_ci,
  content TEXT NOT NULL charset utf8 COLLATE utf8_general_ci DEFAULT "我从没有见过一个不孤独的人，会发出耀眼的光芒！付出不一定马上会有回报，除非是钟点工，对于事业，傻逼一样的坚持，总会得到牛逼一样的结果！",

  read_count int(32) NOT NULL DEFAULT 1,
  tags_id VARCHAR(64) charset utf8 COLLATE utf8_general_ci,
  can_comment tinyint DEFAULT 1,
  abstract VARCHAR(256) charset utf8 COLLATE utf8_general_ci,
  type tinyint DEFAULT 0,
  start_count int(32) NOT NULL DEFAULT 1,
  from_where VARCHAR(32) charset utf8 COLLATE utf8_general_ci,
  from_url VARCHAR(128) charset utf8 COLLATE utf8_general_ci,

  del tinyint NOT NULL DEFAULT 0,
  modify_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  create_time TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP
)Engine=InnoDB;

# 作者
create table if not exists author(
  id              int(32) PRIMARY KEY auto_increment,
  nickname        VARCHAR(32) NOT NULL charset utf8 COLLATE utf8_general_ci DEFAULT "卖代码的小火柴",
  article_count   int(32) NOT NULL DEFAULT 0,
  question_count  int(32) NOT NULL DEFAULT 0,
  answer_count    int(32) NOT NULL DEFAULT 0,
  follow_count    int(32) NOT NULL DEFAULT 1,
  start_count     int(32) NOT NULL DEFAULT 0,
  experience      int(32) NOT NULL DEFAULT 8,
  score           int(32) NOT NULL DEFAULT 0,
  del             tinyint NOT NULL DEFAULT 0,
  modify_time     TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  create_time     TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP
)Engine=InnoDB;

# 每日打卡签到
create table if not exists sign(
  id int(32) PRIMARY KEY auto_increment,

  author_id int(32) NOT NULL,

  del tinyint NOT NULL DEFAULT 0,
  modify_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  create_time TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP
)Engine=InnoDB;

# 问题
create table if not exists question(
  id int(32) PRIMARY KEY auto_increment,

  author_id int(32) NOT NULL,

  title VARCHAR(128) NOT NULL charset utf8 COLLATE utf8_general_ci,
  content TEXT NOT NULL charset utf8 COLLATE utf8_general_ci DEFAULT "",
  tags_id VARCHAR(64) charset utf8 COLLATE utf8_general_ci,
  type tinyint DEFAULT 0,

  accept TINYINT NOT NULL  DEFAULT 0,
  answer_count int(32) NOT NULL DEFAULT 0,

  del tinyint NOT NULL DEFAULT 0,
  modify_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  create_time TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP
)Engine=InnoDB;
# 答案
create table if not exists answer(
  id int(32) PRIMARY KEY auto_increment,

  author_id int(32) NOT NULL,
  question_id int(32) NOT NULL,
  is_accept TINYINT NOT NULL DEFAULT 0,

  content VARCHAR(512) NOT NULL charset utf8 COLLATE utf8_general_ci,

  del tinyint NOT NULL DEFAULT 0,
  modify_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  create_time TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP
)Engine=InnoDB;

# 评论
create table if not exists comment(
  id int(32) PRIMARY KEY auto_increment,

  author_id int(32) NOT NULL,
  for_type TINYINT DEFAULT 0,
  content VARCHAR(512) NOT NULL charset utf8 COLLATE utf8_general_ci,

  del tinyint NOT NULL DEFAULT 0,
  modify_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  create_time TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP
)Engine=InnoDB;

# 活动
create table if not exists activity(

  id int(32) PRIMARY KEY auto_increment,

  title VARCHAR(128) NOT NULL charset utf8 COLLATE utf8_general_ci,
  content VARCHAR(512) NOT NULL charset utf8 COLLATE utf8_general_ci,
  time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  address VARCHAR(128) NOT NULL charset utf8 COLLATE utf8_general_ci,
  persons VARCHAR(128) NOT NULL charset utf8 COLLATE utf8_general_ci,

  del tinyint NOT NULL DEFAULT 0,
  modify_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  create_time TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP

)Engine=InnoDB;

# 公告通知
create table if not exists attention(
  id int(32) PRIMARY KEY auto_increment,

  title VARCHAR(128) NOT NULL charset utf8 COLLATE utf8_general_ci,
  content TEXT NOT NULL charset utf8 COLLATE utf8_general_ci,

  del tinyint NOT NULL DEFAULT 0,
  modify_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  create_time TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP
)Engine=InnoDB;

# 标签
create table if not exists tag(
  id int(32) PRIMARY KEY auto_increment,

  author_id int(32) NOT NULL DEFAULT 0,
  name VARCHAR(32) NOT NULL charset utf8 COLLATE utf8_general_ci,
  article_count int(32) NOT NULL DEFAULT 0,
  question_count int(32) NOT NULL DEFAULT 0,

  del tinyint NOT NULL DEFAULT 0,
  modify_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  create_time TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP
)Engine=InnoDB;

# 点赞
create table if not exists star(
  id int(32) PRIMARY KEY auto_increment,

  author_id int(32) NOT NULL DEFAULT 0,
  star_for TINYINT NOT NULL DEFAULT 0,
  for_id int(32) NOT NULL DEFAULT 0,

  del tinyint NOT NULL DEFAULT 0,
  modify_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  create_time TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP
)Engine=InnoDB;

# 收藏
create table if not exists favorite(
  id int(32) PRIMARY KEY auto_increment,

  author_id int(32) NOT NULL DEFAULT 0,
  favorite_for TINYINT NOT NULL DEFAULT 0,
  for_id int(32) NOT NULL DEFAULT 0,

  del tinyint NOT NULL DEFAULT 0,
  modify_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  create_time TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP
)Engine=InnoDB;

# 关注
create table if not exists follow(
  id int(32) PRIMARY KEY auto_increment,

  author_id int(32) NOT NULL DEFAULT 0,
  follow_id int(32) NOT NULL DEFAULT 0,

  del tinyint NOT NULL DEFAULT 0,
  modify_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  create_time TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP
)Engine=InnoDB;

# 快速入口
create table if not exists entry(
  id int(32) PRIMARY KEY auto_increment,

  name VARCHAR(32) NOT NULL charset utf8 COLLATE utf8_general_ci,
  name_url VARCHAR(32) NOT NULL charset utf8 COLLATE utf8_general_ci,

  del tinyint NOT NULL DEFAULT 0,
  modify_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ,
  create_time TIMESTAMP NOT NULL DEFAULT  CURRENT_TIMESTAMP
)Engine=InnoDB;

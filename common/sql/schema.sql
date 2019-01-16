# sso 系统
CREATE DATABASE IF NOT EXISTS sso_iot;
USE sso_iot;
CREATE TABLE IF NOT EXISTS developers (
  id           INT(32)     NOT NULL PRIMARY KEY KEY AUTO_INCREMENT,
  d_name       VARCHAR(32) NOT NULL,
  d_company    VARCHAR(64),
  d_email      VARCHAR(64),
  d_phone      VARCHAR(64),
  d_pwd        VARCHAR(64) NOT NULL,
  d_token      VARCHAR(64) NOT NULL,
  d_is_active  TINYINT                              DEFAULT 0,
  d_avatar     INT(32)                              DEFAULT 0,
  d_createtime TIMESTAMP   NOT NULL                 DEFAULT CURRENT_TIMESTAMP,

  INDEX (d_name),
  INDEX (d_email),
  INDEX (d_phone),
  INDEX (d_email, d_pwd),
  INDEX (d_email, d_token)

)
  ENGINE = InnoDB;

#验证码信息
CREATE TABLE IF NOT EXISTS developer_verify (
  id                    INT(32) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  d_id                  INT(32) NOT NULL,
  d_email               VARCHAR(64),
  d_phone               VARCHAR(64),
  d_email_code          VARCHAR(6),
  d_phone_code          VARCHAR(6),
  d_email_code_sendtime TIMESTAMP                    DEFAULT CURRENT_TIMESTAMP,
  d_phone_code_sendtime TIMESTAMP                    DEFAULT CURRENT_TIMESTAMP,
  d_verify_createtime   TIMESTAMP                    DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

# 开发者附加信息
CREATE TABLE IF NOT EXISTS developer_adds (
  id                INT(32)     NOT NULL PRIMARY KEY KEY AUTO_INCREMENT,
  d_id              INT(32)     NOT NULL,
  d_profession      VARCHAR(64) NOT NULL
  COMMENT '行业',
  d_bussiness       VARCHAR(64) NOT NULL
  COMMENT '主营业务',
  d_website         VARCHAR(64) NOT NULL,
  d_country         VARCHAR(64) NOT NULL,
  d_address         VARCHAR(64) NOT NULL,
  d_street          VARCHAR(64) NOT NULL,
  d_tel             VARCHAR(64) NOT NULL,
  d_fax             VARCHAR(64) NOT NULL,
  d_adds_createtime TIMESTAMP   NOT NULL                 DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

# 开发者实名认证..
CREATE TABLE IF NOT EXISTS developer_real (
  id                        INT(32)           NOT NULL PRIMARY KEY KEY AUTO_INCREMENT,
  d_id                      INT(32)           NOT NULL,
  d_realname                VARCHAR(64)       NOT NULL,
  d_id_real                 VARCHAR(64)       NOT NULL,
  d_id_pic_front            INT(32)           NOT NULL,
  d_id_pic_back             INT(32)           NOT NULL,
  d_id_is_pass              TINYINT DEFAULT 0 NOT NULL,
  d_id_authenticate_id      INT(32)           NOT NULL,
  d_authenticate_createtime TIMESTAMP         NOT NULL                 DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

#应用系统
CREATE DATABASE IF NOT EXISTS app_iot;
USE app_iot;
CREATE TABLE IF NOT EXISTS apps (
  id               INT(32)     NOT NULL PRIMARY KEY AUTO_INCREMENT,
  d_id             INT(32)     NOT NULL,
  a_name           VARCHAR(64) NOT NULL,
  a_type           VARCHAR(64) NOT NULL,
  a_tech           VARCHAR(32) NOT NULL,
  a_trans          TINYINT                          DEFAULT 1
  COMMENT '0定长，1变长',
  a_company        VARCHAR(64) NOT NULL,
  a_product_key    VARCHAR(64) NOT NULL,
  a_product_secret VARCHAR(64) NOT NULL,
  a_max_connect    INT(32)     NOT NULL,
  a_createtime     TIMESTAMP   NOT NULL             DEFAULT current_timestamp,
  a_desc           TEXT,

  INDEX (a_name),
  INDEX (a_product_key)

)
  ENGINE = InnoDB;

# 数据点
CREATE TABLE IF NOT EXISTS datapoint (
  id            INT(32) PRIMARY KEY  NOT NULL  AUTO_INCREMENT,
  a_id          INT(32)              NOT NULL,
  p_name        VARCHAR(64)          NOT NULL,
  p_type        VARCHAR(32)          NOT NULL,
  p_count       INT(32)              NOT NULL,
  p_access      TINYINT              NOT NULL  DEFAULT 0,
  p_create_time DATETIME                       DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

#此表动态创建，一个开发者一张，用来储存设备连接状态
CREATE TABLE IF NOT EXISTS developer_1_client (
  id           INT(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  a_id         INT(32)             NOT NULL,
  client_id    VARCHAR(64)         NOT NULL,
  is_online    TINYINT                      DEFAULT 0,
  last_online  DATETIME                     DEFAULT CURRENT_TIMESTAMP,
  last_offline DATETIME                     DEFAULT CURRENT_TIMESTAMP,
  create_time  DATETIME                     DEFAULT CURRENT_TIMESTAMP,
  conn_count   INT(32)             NOT NULL DEFAULT 0
)
  ENGINE = InnoDB;

# 消费余与余额系统
CREATE DATABASE balance_iot;
USE balance_iot;
DROP TABLE balance;
CREATE TABLE balance (
  id               INT(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  d_id             INT(32) NOT NULL,
  total_conn_count INT(32)                       DEFAULT 100,
  rest_conn_count  INT(32)                       DEFAULT 100,
  total_money      INT(64)                       DEFAULT 0,
  rest_money       INT(64)                       DEFAULT 0,
  create_time      DATETIME                      DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

# 数据系统
#消息数据动态生成
CREATE TABLE IF NOT EXISTS ${name} (
  id            INT(64) PRIMARY KEY AUTO_INCREMENT,
  a_id          INT(32)     NOT NULL,
  m_from        VARCHAR(64) NOT NULL,
  m_to          VARCHAR(64) NOT NULL,
  m_qos         VARCHAR(64) NOT NULL,
  m_message     TEXT        NOT NULL,
  m_create_time DATETIME            DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

# 静态资源系统
CREATE DATABASE IF NOT EXISTS static_iot;
USE static_iot;
#图片资源
CREATE TABLE IF NOT EXISTS img (
  id            INT(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  i_hash_code   VARCHAR(64)         NOT NULL,
  i_file_name   VARCHAR(64)         NOT NULL,
  i_file_path   VARCHAR(64)         NOT NULL,
  i_file_size   BIGINT,
  i_file_type   VARCHAR(32),
  i_uploader_id BIGINT              NOT NULL,
  i_upload_time DATETIME                     DEFAULT CURRENT_TIMESTAMP,
  INDEX (i_hash_code)
)
  ENGINE = InnoDB;

# 告警系统
CREATE DATABASE IF NOT EXISTS alarm_iot;
USE alarm_iot;

#表达式
DROP TABLE express;
CREATE TABLE IF NOT EXISTS express (
  id          INT(32)     NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  opeator     VARCHAR(64) NOT NULL
  COMMENT '表达式',
  create_time DATETIME                          DEFAULT current_timestamp
)
  ENGINE = InnoDB;

#告警规则
DROP TABLE conditions;
CREATE TABLE IF NOT EXISTS conditions (
  id               INT(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  d_id             INT(32) NOT NULL,
  d_index          INT(32) COMMENT '数据点数组位置',
  express_id       INT(32) NOT NULL
  COMMENT '表达式',
  right_value_type TINYINT                       DEFAULT 0
  COMMENT '0：CONSTANT,1: variable',
  right_value      VARCHAR(64) COMMENT '表达式右值',
  create_time      DATETIME                      DEFAULT current_timestamp
)
  ENGINE = InnoDB;

#告警日志
DROP TABLE log;
CREATE TABLE IF NOT EXISTS log (
  id          INT(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  d_id        INT(32) NOT NULL
  COMMENT '数据点',
  d_index     INT(32) COMMENT '数据点数组位置',
  c_id        INT(32) NOT NULL
  COMMENT '告警满足规则',
  create_time DATETIME                      DEFAULT current_timestamp
)
  ENGINE = InnoDB;

# 日志系统
CREATE DATABASE IF NOT EXISTS log_iot;
USE log_iot;

CREATE TABLE IF NOT EXISTS app_${id}_client_log (
  id INT (32
) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  l_type INT (32
) NOT NULL,
  l_level INT (32
) NOT NULL,
  l_log TEXT CHARSET utf8 COLLATE utf8_general_ci,
  l_create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS sys_log (
  id              INT(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  l_s_type        INT(32) NOT NULL,
  l_s_content     VARCHAR(256)
                  CHARSET utf8
                  COLLATE utf8_general_ci,
  l_s_create_time DATETIME                      DEFAULT current_timestamp
)
  ENGINE = InnoDB;

#监控系统与子账号系统
CREATE DATABASE IF NOT EXISTS monitor_iot;
USE monitor_iot;

CREATE TABLE IF NOT EXISTS account (
  id        INT(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  f_id      INT(32) NOT NULL,
  a_level   INT(32) NOT NULL,
  a_name    VARCHAR(64),
  a_email   VARCHAR(64),
  a_phone   INT(15),
  a_company VARCHAR(64),
  a_label   VARCHAR(64),
  a_address VARCHAR(64),
  a_logo    VARCHAR(64)
)
  ENGINE = InnoDB;

#监控关系
CREATE TABLE IF NOT EXISTS monitor_${appID}_relation (
  id INT (32
) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  a_id INT (32
) NOT NULL COMMENT '子账号ID',
  c_id VARCHAR (64
) NOT NULL COMMENT '设备clientID',

  m_create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE = InnoDB;

#小程序与智能硬件开发平台
CREATE DATABASE IF NOT EXISTS dev_iot;
USE dev_iot;

#数据点-小程序组件-智能模组管脚映射
CREATE TABLE IF NOT EXISTS mapper (
  id            INT(32)     NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  a_id          INT(32)     NOT NULL
  COMMENT '应用程序ID',
  d_id          INT(32)     NOT NULL
  COMMENT '数据点ID',
  f_id          INT(32)     NOT NULL
  COMMENT '智能模组管脚ID',
  b_type        VARCHAR(32) NOT NULL
  COMMENT '智能模组型号',
  m_create_time DATETIME                          DEFAULT current_timestamp
);

# 整体系统基础配置
CREATE DATABASE config_iot;
USE config_iot;
CREATE TABLE IF NOT EXISTS config (
  id INT(32)      NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  k  VARCHAR(64)  NOT NULL,
  v  VARCHAR(128) NOT NULL
)
  ENGINE = InnoDB;
INSERT INTO config (k, v) VALUES ("copyright", "Copyright ©2017 All Rights Reserved. CenoCloud 版权所有");
INSERT INTO config (k, v) VALUES ("address", "天津大学");
INSERT INTO config (k, v) VALUES ("beian", "京ICP备********号");





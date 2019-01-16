# sso 系统
CREATE DATABASE IF NOT EXISTS sso_iot;
USE sso_iot;
CREATE TABLE IF NOT EXISTS developers (
  id           INT(32)     NOT NULL PRIMARY KEY KEY AUTO_INCREMENT,
  d_name       VARCHAR(32) NOT NULL
  COLLATE utf8_general_ci,
  d_company    VARCHAR(64)
               COLLATE utf8_general_ci,
  d_email      VARCHAR(64)
               COLLATE utf8_general_ci,
  d_phone      VARCHAR(64)
               COLLATE utf8_general_ci,
  d_pwd        VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci,
  d_token      VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci,

  #客户端token 2018_3_19
  --   d_android_token VARCHAR (64) not null,
  --   d_iphone_token VARCHAR (64) not null,
  #申请客户端登陆授权token 2018_3_19
  --   d_auth_token VARCHAR (64) not null,
  #客户端是否在线 2018_3_19
  --   d_is_android_online TINYINT DEFAULT 0,
  --   d_is_iphone_online TINYINT DEFAULT 0,

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
--  2018_3_19
ALTER TABLE developers
  ADD d_android_token VARCHAR(64) NOT NULL;
ALTER TABLE developers
  ADD d_iphone_token VARCHAR(64) NOT NULL;
ALTER TABLE developers
  ADD d_auth_token VARCHAR(64) NOT NULL;
ALTER TABLE developers
  ADD d_is_android_online TINYINT DEFAULT 0;
ALTER TABLE developers
  ADD d_is_iphone_online TINYINT DEFAULT 0;

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
CREATE TABLE IF NOT EXISTS developer_verify (
  id                    INT(32) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  d_id                  INT(32) NOT NULL,
  d_email               VARCHAR(64)
                        COLLATE utf8_general_ci,
  d_phone               VARCHAR(64)
                        COLLATE utf8_general_ci,
  d_email_code          VARCHAR(6)
                        COLLATE utf8_general_ci,
  d_phone_code          VARCHAR(6)
                        COLLATE utf8_general_ci,
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
  COLLATE utf8_general_ci
  COMMENT '行业',
  d_bussiness       VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci
  COMMENT '主营业务',
  d_website         VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci,
  d_country         VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci,
  d_address         VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci,
  d_street          VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci,
  d_tel             VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci,
  d_fax             VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci,
  d_adds_createtime TIMESTAMP   NOT NULL                 DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

# 开发者实名认证..
CREATE TABLE IF NOT EXISTS developer_real (
  id                        INT(32)           NOT NULL PRIMARY KEY KEY AUTO_INCREMENT,
  d_id                      INT(32)           NOT NULL,
  d_realname                VARCHAR(64)       NOT NULL
  COLLATE utf8_general_ci,
  d_id_real                 VARCHAR(64)       NOT NULL
  COLLATE utf8_general_ci,
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
  a_name           VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci,
  a_type           VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci,
  a_tech           VARCHAR(32) NOT NULL
  COLLATE utf8_general_ci,
  a_trans          TINYINT                          DEFAULT 1
  COMMENT '0定长，1变长',
  a_company        VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci,
  a_product_key    VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci,
  a_product_secret VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci,
  a_max_connect    INT(32)     NOT NULL,
  a_createtime     TIMESTAMP   NOT NULL             DEFAULT current_timestamp,
  a_desc           TEXT COLLATE utf8_general_ci,

  INDEX (a_name),
  INDEX (a_product_key)

)
  ENGINE = InnoDB;

# 数据点
CREATE TABLE IF NOT EXISTS datapoint (
  id            INT(32) PRIMARY KEY  NOT NULL  AUTO_INCREMENT,
  a_id          INT(32)              NOT NULL,
  p_name        VARCHAR(64)          NOT NULL
  COLLATE utf8_general_ci,
  p_type        VARCHAR(32)          NOT NULL
  COLLATE utf8_general_ci,
  p_count       INT(32)              NOT NULL,
  p_access      TINYINT              NOT NULL  DEFAULT 0,
  p_create_time DATETIME                       DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

#此表动态创建,一个开发者一张,用来储存设备连接状态
CREATE TABLE IF NOT EXISTS developer_1_client (
  id           INT(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  a_id         INT(32)             NOT NULL,
  client_id    VARCHAR(64)         NOT NULL
  COLLATE utf8_general_ci,
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
  m_from        VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci,
  m_to          VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci,
  m_qos         VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci,
  m_message     TEXT        NOT NULL
  COLLATE utf8_general_ci,
  m_create_time DATETIME            DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

# 静态资源系统
CREATE DATABASE IF NOT EXISTS static_iot;
USE static_iot;

# 子系统文件允许列表
CREATE TABLE IF NOT EXISTS file_limit(
  id            INT(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  type           VARCHAR (32) not NULL,
  system_identification  VARCHAR(64) NOT NULL COLLATE utf8_general_ci,
  del INT(32) NOT NULL DEFAULT 0,
  create_time DATETIME  DEFAULT CURRENT_TIMESTAMP,
  modify_time DATETIME  DEFAULT CURRENT_TIMESTAMP
);

#文件资源
CREATE TABLE IF NOT EXISTS file (
  id            INT(32) PRIMARY KEY NOT NULL AUTO_INCREMENT,
  f_uuid        VARCHAR(64) NOT NULL COLLATE utf8_general_ci,
  f_hash_code   VARCHAR(64) NOT NULL COLLATE utf8_general_ci,
  f_system_identification  VARCHAR(64) NOT NULL COLLATE utf8_general_ci,
  f_storage_node   VARCHAR(64) NOT NULL COLLATE utf8_general_ci,
  f_path   VARCHAR(64) NOT NULL COLLATE utf8_general_ci,
  f_name   VARCHAR(64) NOT NULL COLLATE utf8_general_ci,
  f_size   BIGINT,
  f_type   VARCHAR(32) COLLATE utf8_general_ci,
  f_uploader_id BIGINT  NOT NULL,
  f_upload_time DATETIME  DEFAULT CURRENT_TIMESTAMP,
  useCount      INT(32) NOT NULL DEFAULT 1,
  del INT(32) NOT NULL DEFAULT 0,
  create_time DATETIME  DEFAULT CURRENT_TIMESTAMP,
  modify_time DATETIME  DEFAULT CURRENT_TIMESTAMP,
  INDEX (f_hash_code)
)ENGINE = InnoDB;

# 告警系统
CREATE DATABASE IF NOT EXISTS alarm_iot;
USE alarm_iot;

#表达式
DROP TABLE express;
CREATE TABLE IF NOT EXISTS express (
  id          INT(32)     NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  opeator     VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci
  COMMENT '表达式',
  create_time DATETIME                          DEFAULT current_timestamp
)
  ENGINE = InnoDB;

#告警规则
DROP TABLE conditions;
CREATE TABLE IF NOT EXISTS conditions (
  id               INT(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  name             VARCHAR(64)
                   COLLATE utf8_general_ci,
  d_id             INT(32) NOT NULL,
  d_index          INT(32) COMMENT '数据点数组位置',
  express_id       INT(32) NOT NULL
  COMMENT '表达式',
  right_value_type TINYINT                       DEFAULT 0
  COMMENT '0：CONSTANT,1: variable',
  right_value      VARCHAR(64)
                   COLLATE utf8_general_ci COMMENT '表达式右值',
  create_time      DATETIME                      DEFAULT current_timestamp
)
  ENGINE = InnoDB;

#告警日志
DROP TABLE alarm_log_${appID};
CREATE TABLE IF NOT EXISTS alarm_log_${appID} (
  id          INT(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  d_id        INT(32) NOT NULL,
  m_id        INT(32) NOT NULL,
  c_id        INT(32) NOT NULL,
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
  l_log TEXT COLLATE utf8_general_ci,
  l_create_time DATETIME DEFAULT CURRENT_TIMESTAMP
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS sys_log (
  id              INT(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT,
  l_s_type        INT(32) NOT NULL,
  l_s_content     VARCHAR(256)
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
  a_name    VARCHAR(64)
            COLLATE utf8_general_ci,
  a_email   VARCHAR(64)
            COLLATE utf8_general_ci,
  a_phone   INT(15),
  a_company VARCHAR(64)
            COLLATE utf8_general_ci,
  a_label   VARCHAR(64)
            COLLATE utf8_general_ci,
  a_address VARCHAR(64)
            COLLATE utf8_general_ci,
  a_logo    VARCHAR(64)
            COLLATE utf8_general_ci
)
  ENGINE = InnoDB;

#监控关系
CREATE TABLE IF NOT EXISTS monitor_${appID}_relation (
  id INT (32
) NOT NULL PRIMARY KEY AUTO_INCREMENT,
  a_id INT (32
) NOT NULL COMMENT '子账号ID',
  c_id VARCHAR (64
) NOT NULL COLLATE utf8_general_ci COMMENT '设备clientID',

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
  COLLATE utf8_general_ci
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

#权限系统
CREATE DATABASE admin_iot;
USE admin_iot;
# 用户角色表
CREATE TABLE IF NOT EXISTS role (
  id          INT(32)     NOT NULL  PRIMARY KEY AUTO_INCREMENT, #角色ID
  name        VARCHAR(32) NOT NULL, # 角色名称
  create_time DATETIME                          DEFAULT current_timestamp
)
  ENGINE = InnoDB;

# 用户权限表
CREATE TABLE IF NOT EXISTS access (
  id          INT(32)      NOT NULL  PRIMARY KEY AUTO_INCREMENT, #权限ID
  r_id        INT(32)      NOT NULL, #角色ID
  name        VARCHAR(32)  NOT NULL
  COLLATE utf8_general_ci, # 权限名称
  action      VARCHAR(128) NOT NULL
  COLLATE utf8_general_ci, # 权限可访问动作:方法
  create_time DATETIME                           DEFAULT current_timestamp
)
  ENGINE = InnoDB;

# 工单系统
CREATE DATABASE wo_iot;
USE wo_iot;

# 工单表
CREATE TABLE IF NOT EXISTS wo (
  id            INT(32)      NOT NULL  PRIMARY KEY AUTO_INCREMENT, #工单ID
  u_id          INT(32)      NOT NULL,
  product_type  TINYINT                            DEFAULT 0, # 产品类型
  product_id    INT(32)      NOT NULL, # 产品ID
  problem_type  TINYINT                            DEFAULT 0, #问题类型
  title         VARCHAR(128) NOT NULL
  COLLATE utf8_general_ci, # 标题
  level         INT(32)      NOT NULL              DEFAULT 0, #紧急程度
  level_content VARCHAR(64)
                COLLATE utf8_general_ci, #紧急描述
  content       VARCHAR(256)
                COLLATE utf8_general_ci, # 问题描述
  attach        VARCHAR(128)
                COLLATE utf8_general_ci, # 附件
  contact       VARCHAR(64)  NOT NULL
  COLLATE utf8_general_ci, # 联系方式
  status        TINYINT      NOT NULL              DEFAULT 0, # 工单状态
  create_time   DATETIME                           DEFAULT current_timestamp
)
  ENGINE = InnoDB;

# 工单解决清单表
CREATE TABLE IF NOT EXISTS wo_solution (
  id          INT(32) NOT NULL  PRIMARY KEY AUTO_INCREMENT, #解决ID
  wo_id       INT(32) NOT NULL, # 工单ID
  u_id        INT(32) NOT NULL, # 处理人
  content     INT(32) NOT NULL, # 工单回复
  attach      VARCHAR(128)
              COLLATE utf8_general_ci, # 附件
  create_time DATETIME                      DEFAULT current_timestamp
)
  ENGINE = InnoDB;

# 添加论坛相关
CREATE DATABASE iot_forum;
USE iot_forum;

# 文章
CREATE TABLE IF NOT EXISTS article (
  id          INT(32) PRIMARY KEY  AUTO_INCREMENT,
  author_id   INT(32)     NOT NULL,
  title       VARCHAR(64) NOT NULL
  COLLATE utf8_general_ci,
  content     TEXT        NOT NULL
  COLLATE utf8_general_ci,
  read_count  INT(32)     NOT NULL DEFAULT 1,
  tags_id     VARCHAR(64)
              COLLATE utf8_general_ci,
  can_comment TINYINT              DEFAULT 1,
  abstract    VARCHAR(256)
              COLLATE utf8_general_ci,
  type        TINYINT              DEFAULT 0,
  start_count INT(32)     NOT NULL DEFAULT 1,
  from_where  VARCHAR(32)
              COLLATE utf8_general_ci,
  from_url    VARCHAR(128)
              COLLATE utf8_general_ci,
  star_count   INT(32)      NOT NULL  DEFAULT 1,
  fav_count    INT(32)    NOT NULL DEFAULT 1,
  del         TINYINT     NOT NULL DEFAULT 0,
  modify_time TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  create_time TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

# 作者
CREATE TABLE IF NOT EXISTS author (
  id             INT(32) PRIMARY KEY  AUTO_INCREMENT,
  nickname       VARCHAR(32) NOT NULL
  COLLATE utf8_general_ci,
  article_count  INT(32)     NOT NULL DEFAULT 0,
  question_count INT(32)     NOT NULL DEFAULT 0,
  answer_count   INT(32)     NOT NULL DEFAULT 0,
  follow_count   INT(32)     NOT NULL DEFAULT 1,
  start_count    INT(32)     NOT NULL DEFAULT 0,
  experience     INT(32)     NOT NULL DEFAULT 8,
  score          INT(32)     NOT NULL DEFAULT 0,
  del            TINYINT     NOT NULL DEFAULT 0,
  modify_time    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP,
  create_time    TIMESTAMP   NOT NULL DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

-- 5.21 号更新，作者表添加系统用户id.
ALTER TABLE author
  ADD sid INT(32) NOT NULL;

# 每日打卡签到
CREATE TABLE IF NOT EXISTS sign (
  id          INT(32) PRIMARY KEY                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             AUTO_INCREMENT,
  author_id   INT(32)   NOT NULL,
  del         TINYINT   NOT NULL                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              DEFAULT 0,
  modify_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  create_time TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

# 问题
CREATE TABLE IF NOT EXISTS question (
  id           INT(32) PRIMARY KEY    AUTO_INCREMENT,
  author_id    INT(32)      NOT NULL,
  title        VARCHAR(128) NOT NULL
  COLLATE utf8_general_ci,
  content      TEXT         NOT NULL
  COLLATE utf8_general_ci,
  tags_id      VARCHAR(64)
               COLLATE utf8_general_ci,
  type         TINYINT                DEFAULT 0,
  accept       TINYINT      NOT NULL  DEFAULT 0,
  answer_count INT(32)      NOT NULL  DEFAULT 0,
  fav_count    INT(32)    NOT NULL DEFAULT 1,
  star_count   INT(32)      NOT NULL  DEFAULT 1,
  del          TINYINT      NOT NULL  DEFAULT 0,
  modify_time  TIMESTAMP    NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  create_time  TIMESTAMP    NOT NULL  DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;
# 答案
CREATE TABLE IF NOT EXISTS answer (
  id          INT(32) PRIMARY KEY                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                          AUTO_INCREMENT,
  author_id   INT(32)      NOT NULL,
  question_id INT(32)      NOT NULL,
  is_accept   TINYINT      NOT NULL                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    DEFAULT 0,
  content     VARCHAR(512) NOT NULL
  COLLATE utf8_general_ci,
  star_count   INT(32)      NOT NULL  DEFAULT 1,
  del         TINYINT      NOT NULL DEFAULT 0,
  modify_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  create_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

# 评论
CREATE TABLE IF NOT EXISTS comment (
  id          INT(32) PRIMARY KEY   AUTO_INCREMENT,
  author_id   INT(32)      NOT NULL,
  for_type    TINYINT               DEFAULT 0,
  --   2018-5-24 添加被评论ID comment 新结构
  -- +-------------+--------------+------+-----+-------------------+----------------+
  -- | Field       | Type         | Null | Key | Default           | Extra          |
  -- +-------------+--------------+------+-----+-------------------+----------------+
  -- | id          | int(32)      | NO   | PRI | NULL              | auto_increment |
  -- | author_id   | int(32)      | NO   |     | NULL              |                |
  -- | for_type    | tinyint(4)   | YES  |     | 0                 |                |
  -- | content     | varchar(512) | NO   |     | NULL              |                |
  -- | del         | tinyint(4)   | NO   |     | 0                 |                |
  -- | modify_time | timestamp    | NO   |     | CURRENT_TIMESTAMP |                |
  -- | create_time | timestamp    | NO   |     | CURRENT_TIMESTAMP |                |
  -- | for_id      | int(32)      | NO   |     | NULL              |                |
  -- +-------------+--------------+------+-----+-------------------+----------------+
  for_id      INT(32)      NOT NULL,
  content     VARCHAR(512) NOT NULL
  COLLATE utf8_general_ci,
  star_count   INT(32)      NOT NULL  DEFAULT 1,
  del         TINYINT      NOT NULL DEFAULT 0,
  modify_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  create_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

# 活动
CREATE TABLE IF NOT EXISTS activity (
  id          INT(32) PRIMARY KEY   AUTO_INCREMENT,
  title       VARCHAR(128) NOT NULL
  COLLATE utf8_general_ci,
  content     VARCHAR(512) NOT NULL
  COLLATE utf8_general_ci,
  time        TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  address     VARCHAR(128) NOT NULL
  COLLATE utf8_general_ci,
  persons     VARCHAR(128) NOT NULL
  COLLATE utf8_general_ci,
  del         TINYINT      NOT NULL DEFAULT 0,
  modify_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  create_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

# 公告通知
CREATE TABLE IF NOT EXISTS attention (
  id          INT(32) PRIMARY KEY   AUTO_INCREMENT,
  title       VARCHAR(128) NOT NULL
  COLLATE utf8_general_ci,
  content     TEXT         NOT NULL
  COLLATE utf8_general_ci,
  del         TINYINT      NOT NULL DEFAULT 0,
  modify_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  create_time TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

# 标签
CREATE TABLE IF NOT EXISTS tag (
  id             INT(32) PRIMARY KEY                                                                                                                                                                                                                                                                             AUTO_INCREMENT,
  author_id INT(32)        NOT NULL                                                                                                                                                                                                                                                                                DEFAULT 0,
  name      VARCHAR(32) NOT NULL
  COLLATE utf8_general_ci,
  article_count INT(32) NOT NULL                                                                                                                                                                                                                                                                                DEFAULT 0,
  question_count INT(32) NOT NULL                                                                                                                                                                                                                                                                                DEFAULT 0,
  del            TINYINT NOT NULL                                                                                                                                                                                                                                                                                DEFAULT 0,
  modify_time    TIMESTAMP NOT NULL                                                                                                                                                                                                                                                                              DEFAULT CURRENT_TIMESTAMP,
  create_time    TIMESTAMP NOT NULL                                                                                                                                                                                                                                                                              DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

# 点赞
CREATE TABLE IF NOT EXISTS star (
  id          INT(32) PRIMARY KEY AUTO_INCREMENT,
  author_id INT(32)     NOT NULL    DEFAULT 0,
  star_for  TINYINT NOT NULL    DEFAULT 0,
  for_id    INT(32) NOT NULL    DEFAULT 0,
  del       TINYINT NOT NULL    DEFAULT 0,
  modify_time TIMESTAMP NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  create_time TIMESTAMP NOT NULL  DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

# 收藏
CREATE TABLE IF NOT EXISTS favorite (
  id           INT(32) PRIMARY KEY AUTO_INCREMENT,
  author_id INT(32)      NOT NULL    DEFAULT 0,
  favorite_for TINYINT NOT NULL    DEFAULT 0,
  for_id       INT(32) NOT NULL    DEFAULT 0,
  del          TINYINT NOT NULL    DEFAULT 0,
  modify_time  TIMESTAMP NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  create_time  TIMESTAMP NOT NULL  DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

# 关注
CREATE TABLE IF NOT EXISTS follow (
  id          INT(32) PRIMARY KEY AUTO_INCREMENT,
  author_id INT(32)     NOT NULL    DEFAULT 0,
  follow_id INT(32) NOT NULL    DEFAULT 0,
  del       TINYINT NOT NULL    DEFAULT 0,
  modify_time TIMESTAMP NOT NULL  DEFAULT CURRENT_TIMESTAMP,
  create_time TIMESTAMP NOT NULL  DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

# 快速入口
CREATE TABLE IF NOT EXISTS entry (
  id          INT(32) PRIMARY KEY  AUTO_INCREMENT,
  name VARCHAR(32)      NOT NULL
  COLLATE utf8_general_ci,
  name_url VARCHAR(32) NOT NULL
  COLLATE utf8_general_ci,
  del      TINYINT     NOT NULL DEFAULT 0,
  modify_time TIMESTAMP NOT NULL   DEFAULT CURRENT_TIMESTAMP,
  create_time TIMESTAMP NOT NULL   DEFAULT CURRENT_TIMESTAMP
)
  ENGINE = InnoDB;

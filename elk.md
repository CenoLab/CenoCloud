# ELK 安装部署

## 进入opt目录[可选,推荐]
```bash
    cd /opt
```
## 下载所需中间件
### 1. Elasticsearch 下载并解压
```bash
    wget -c https://artifacts.elastic.co/downloads/elasticsearch/elasticsearch-6.3.0.zip 
    unzip elasticsearch-6.3.0.zip 
    rm elasticsearch-6.3.0.zip 
   
```
### 2. LogStash 下载并解压
```bash
    wget -c https://artifacts.elastic.co/downloads/logstash/logstash-6.3.0.zip 
    unzip logstash-6.3.0.zip 
    rm logstash-6.3.0.zip 
```
### 3. Kibana 下载并解压
```bash
    wget -c https://artifacts.elastic.co/downloads/kibana/kibana-6.3.0-linux-x86_64.tar.gz 
    tar -zxvf kibana-6.3.0-linux-x86_64.tar.gz 
    rm  kibana-6.3.0-linux-x86_64.tar.gz
```

## 中间件配置
### 1. LogStash 配置
#### 创建管道配置文件并写入配置,将logstash作为服务, output为输出目标, 在这里我们输出到 Elasticsearch 中
```bash
    cd logstash-6.3.0/config
    touch es_conf.conf
    echo "input { tcp { 
                      host => \"127.0.0.1\" port => 9250 mode => \"server\" tags => [\"tags\"] codec => json_lines 
                    } 
                }
          output {
            elasticsearch { hosts => [\"localhost:9200\"] }
            stdout { codec => rubydebug }
          }" > es_conf.conf
    cd /opt
```
### 2. Elasticsearch 配置
```bash
```
### 3. Kibana 配置
#### 修改 config/kibana.yml 配置文件，设置 elasticsearch.url 指向 Elasticsearch 实例, 默认是comment掉的,所以直接追加就好.
```bash
    echo "elasticsearch.url: \"http://localhost:9200\"" >> kibana-6.3.0-linux-x86_64/config/kibana.yml
```
## 中间件启动
### 1. LogStash 启动
#### 启动成功
```bash
    ./bin/logstash -f config/es_conf.conf
```
### 2. Elasticsearch 启动
#### 由于ElasticSearch可以接收用户输入的脚本并且执行，为了系统安全考虑，建议创建一个单独的用户用来运行ElasticSearch
```bash
    groupadd elsearch
    useradd elsearch -g elsearch -p elasticsearch
```
#### 更改elasticsearch文件夹及内部文件的所属用户及组为elsearch:elsearch
```bash
    chown -R elsearch:elsearch  /opt
```
#### 切换用户
```bash
    su elsearch 
```
#### 启动
```bash
    nohup ./opt/elasticsearch-6.3.0/bin/elasticsearch > elasticsearch.out &
```
### 3. Kibana 启动
```bash
    ./opt/logstash-6.3.0/bin/kibana
```
## 中间件管理控制台

##### [Kibana WEB管理控制台](http://localhost:5601)
##### [Elasticsearch WEB管理控制台](http://localhost:9200)
##### [Logstash WEB管理控制台]()

# 单节点一键部署脚本

 [单节点一键部署脚本](/opt/elk.sh)
```bash
    cd /opt/
    
    wget -c https://artifacts.elastic.co/downloads/logstash/elasticsearch-6.3.0.zip 
    unzip elasticsearch-6.3.0.zip 
    rm elasticsearch-6.3.0.zip 
    
    wget -c https://artifacts.elastic.co/downloads/logstash/logstash-6.3.0.zip 
    unzip logstash-6.3.0.zip 
    rm logstash-6.3.0.zip 
    
    wget -c https://artifacts.elastic.co/downloads/kibana/kibana-6.3.0-linux-x86_64.tar.gz 
    tar -zxvf kibana-6.3.0-linux-x86_64.tar.gz 
    rm  kibana-6.3.0-linux-x86_64.tar.gz
   
    # config
    # logstash
    cd /opt/logstash-6.3.0/config
    touch es_conf.conf
     echo "input { tcp { 
                          host => \"127.0.0.1\" port => 9250 mode => \"server\" tags => [\"tags\"] codec => json_lines 
                        } 
                    }
              output {
                elasticsearch { hosts => [\"localhost:9200\"] }
                stdout { codec => rubydebug }
              }" > es_conf.conf
     cd /opt
    
    
    # kibana
    echo "elasticsearch.url: \"http://localhost:9200\"" >> kibana-6.3.0-linux-x86_64/config/kibana.yml
    # echo "server.port: 45601" >> kibana-6.3.0-linux-x86_64/config/kibana.yml
    cd /opt
    
    
    # elasticsearch
    groupadd elsearch
    useradd elsearch -g elsearch -p elasticsearch
    chown -R elsearch:elsearch  /opt/elasticsearch-6.3.0
    su elsearch 
  
    
    # run
    ./opt/logstash-6.3.0/bin/logstash -f config/es_conf.conf
    nohup ./opt/elasticsearch-6.3.0/bin/elasticsearch > elasticsearch.out &
    ./opt/logstash-6.3.0/bin/kibana
```

# 如何使用？
#### 默认您使用maven管理第jar包, 所以直直接添加以下依赖:

```xml
<dependency>
  <groupId>net.logstash.logback</groupId>
  <artifactId>logstash-logback-encoder</artifactId>
  <version>4.11</version>
</dependency>
```
#### 默认您的日志方案为 slf4j + logback,所以在 logback.xml 中添加 appender
```xml
<appender name="LOGSTASH" class="net.logstash.logback.appender.LogstashTcpSocketAppender">
  <!--destination 是 logstash 服务的 host:port，相当于和 logstash 建立了管道，将日志数据定向传输到 logstash-->
  <destination>127.0.0.1:9250</destination>
  <encoder charset="UTF-8" class="net.logstash.logback.encoder.LogstashEncoder"/>
</appender>
<logger name="io.github.dunwu.spring" level="TRACE" additivity="false">
  <appender-ref ref="LOGSTASH" />
</logger>
```

#### java代码示例:

```java
package com.iot.nero.middleware.dfs.index;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class App 
{
public static final Logger logger= LoggerFactory.getLogger(App.class);

    public static void main( String[] args )
    {
        logger.debug("This is a debug message!");
        logger.info("This is info message!");
        logger.warn("This is a warn message!");
        logger.error("This is error message!");

        DFSBootstrap dfsBootstrap = new DFSBootstrap();
        dfsBootstrap.start();
    }
}
```

## 文档版本说明

更新人 | 版本 | 备注 | 时间 
- | :-: | -: |- 
杨兴锋 | 0.0.1 | 首次编写 | 2018-06-19 
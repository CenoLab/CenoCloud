# 第三方开放接口
#### 基本信息
```
DOMAIN : "http://www.cenocloud.com"
API_DOMAIN : "http://119.28.155.88:8080"
```
#### Header :

```
FromAgent     : "third",
appKey        : "appkey",
appSecret     : "appSecret"
```
---
## 数据接口 V 1.2.2
### HTTP_METHOD : `get`

##### 1. 获取计算时序数据

###### URL : `/data/api/v1/data/{appId}/{clientId}/{dataPointId}/{index}/{method}/{from}/{to}`

###### 参数解释 :

```
{appId}       : "产品ID",
{clientId}    : "设备ID",
{dataPointId} : "数据点ID"
{index}       : "数据点索引位置"
{method}      : "计算函数"
{from}        : "启始时间"
{to}          : "结束时间"
```
###### `method` 计算函数，当前支持:

####### 数学统计
1. `getMax` 最大值
1. `getMin` 最小值
1. `getSum` 求和
1. `getMean` 均值
1. `getMode` 众数
1. `getMedian` 中位数
1. `getMidrange` 中列数
1. `getRange` 极差
1. `getQuartiles` 四分位数
1. `getQuartilesRange` 四分位数极差
1. `getVariance` 方差
1. `getAbsoluteAverageDeviation` 绝对平均偏差(AAD)
1. `getMedianAbsoluteDeviation` 中位数绝对偏差(MAD)
1. `getStandardDevition` 标准差
####### 数据变化-规范化
1. `minMaxNormalize` 最小-最大规范化
1. `zScoreNormalize` Z-score规范化
1. `decimalsNormalize` 小数定标规范化

###### 成功返回类型 :
```json
{
    "state": true,
    "data": {
        "appName": "CenoBox",
        "dataPointName": "Temperature",
        "index": 1,
        "method": "avg",
        "fromTime": "2016-07-06 12:00:00",
        "toTime": "2018-09-07 12:00:00",
        "value": 28.099999999999998
    },
    "msg": null
}
```
###### 失败返回类型 :
```json
{ 
  "state":false,
  "data":null,
  "msg":""
 }
```

##### 1. 获取设备当前值

###### URL : `/data/{appId}/{clientId}/current`

###### 参数解释 :

```
{appId}       : "产品ID",
{clientId}    : "设备ID"
```
###### 成功返回
```json
{
    "state": true,
    "data": {
        "d": {
            "s1001-workstatus": [
                false
            ],
            "s1002-workstatus": [
                true
            ],
            "s1004-onoff": [
                true
            ],
            "s1003-temperature": [
                11
            ],
            "s1005-current": [
                11
            ]
        },
        "ts": "2018-01-01 00:00:03"
    },
    "msg": null
}
```


##### 1. 获取设备历史数据

###### URL : `/data/{appId}/{clientId}/{from}/{to}/{page}/{num}/history`

###### 参数解释 :

```
{appId}       : "产品ID"
{clientId}    : "设备ID"
{from}        : "启始时间"
{to}          : "结束时间"
{page}        : "页数"
{num}         : "每页个数"
```
###### 成功返回
```json
{
    "state": true,
    "data": [
        {
            "d": {
                "s1001-workstatus": [
                    false
                ],
                "s1002-workstatus": [
                    true
                ],
                "s1004-onoff": [
                    true
                ],
                "s1003-temperature": [
                    11
                ],
                "s1005-current": [
                    11
                ]
            },
            "ts": "2018-01-01 00:00:03"
        },
        {
            "d": {
                "s1001-workstatus": [
                    false
                ],
                "s1002-workstatus": [
                    true
                ],
                "s1004-onoff": [
                    true
                ],
                "s1003-temperature": [
                    11
                ],
                "s1005-current": [
                    10
                ]
            },
            "ts": "2018-01-01 00:00:02"
        },
        {
            "d": {
                "s1001-workstatus": [
                    false
                ],
                "s1002-workstatus": [
                    true
                ],
                "s1004-onoff": [
                    true
                ],
                "s1003-temperature": [
                    10
                ],
                "s1005-current": [
                    10
                ]
            },
            "ts": "2018-01-01 00:00:01"
        },
        {
            "d": {
                "s1001-workstatus": [
                    false
                ],
                "s1002-workstatus": [
                    true
                ],
                "s1004-onoff": [
                    true
                ],
                "s1003-temperature": [
                    23.1
                ],
                "s1005-current": [
                    1.102
                ]
            },
            "ts": "2018-01-01 00:00:01"
        },
        {
            "d": {
                "s1001-workstatus": [
                    false
                ],
                "s1002-workstatus": [
                    true
                ],
                "s1004-onoff": [
                    true
                ],
                "s1003-temperature": [
                    23.1
                ],
                "s1005-current": [
                    1.102
                ]
            },
            "ts": "2018-01-01 00:00:03"
        }
    ],
    "msg": null
}
```
##### 1. 获取产品数据点

###### URL : `/dataPoint/{appId}/list`

###### 参数解释 :

```
{appId}       : "产品ID"
```
###### 成功返回
```json
{
    "state": true,
    "data": [
        {
            "access": 0,
            "appId": 53,
            "createTime": "2018-03-30 15:17:41.0",
            "id": 23,
            "type": "Bool",
            "name": "s1001-workstatus"
        },
        {
            "access": 0,
            "appId": 53,
            "createTime": "2018-03-30 15:19:15.0",
            "id": 24,
            "type": "Bool",
            "name": "s1002-workstatus"
        },
        {
            "access": 0,
            "appId": 53,
            "createTime": "2018-03-30 15:19:41.0",
            "id": 25,
            "type": "Float",
            "name": "s1003-temperature"
        },
        {
            "access": 0,
            "appId": 53,
            "createTime": "2018-03-30 15:19:55.0",
            "id": 26,
            "type": "Bool",
            "name": "s1004-onoff"
        },
        {
            "access": 0,
            "appId": 53,
            "createTime": "2018-03-30 15:20:05.0",
            "id": 27,
            "type": "Float",
            "name": "s1005-current"
        }
    ],
    "msg": null
}
```
##### 使用方式
######  拼接参数成`URL`,其中`appId`,`clientId`,`dataPointId`均可在平台查到
###### `GET`请求 `API_DOMAIN+URL`
###### 带上三个`Header`,分别是`FromAgent` 必须为 `third`,其他两个可以在平台查到
###### 为了您的秘钥安全，建议不要直接前端`ajax`请求这个地址,会暴露秘钥,建议后端`curl`

---
## 设备控制接口 V 1.1.5

### HTTP_METHOD : `post`
###### URL : `/control/api/v1/{appId}/{clientId}/control`

###### Header:
```
"Content-Type"  : "application/x-www-form-urlencoded"
```

###### URL 参数解释 :

```
{appId}       : "产品ID",
{clientId}    : "设备ID"
```
###### POST参数 data:
####### 该产品的只写数据点json，例如：
```json
{
  "data":{
    "double_test":[
      1.167,
      7.1656]
    }
}
```

###### 成功返回 :
```json
{
    "state": true,
    "data": {
        "control": {
            "double_test": [
                1.167,
                7.1656
            ]
        }
    },
    "msg": null
}
```

###### 失败返回 :
```json
{
  "state":false,
  "data":null,
  "msg":"数据点未找到"
}
```
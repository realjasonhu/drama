# Drama 文档
### WEB端API

### CLIENT端API
#### 数据列表
**请求方式：** `POST`。

**请求地址：**`https://{域名}/client/queryDramaListData`。

**请求参数说明：**

|参数|类型|是否必填|说明|
|---|---|---|---|
|page|INT(10)|否|默认值 1|
|rows|INT(10)|否|默认值 20|

**返回参数说明：**

|参数|类型|是否必填|说明|
|---|---|---|---|
|title|VARCHAR(100)|是|标题|
|is_hot|VARCHAR(1)|是|HOT标识 0 否 1 是|

 

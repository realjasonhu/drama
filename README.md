# Drama 文档

### CLIENT端API
#### 数据列表
**请求方式：** `POST`。

**请求地址：**`https://{域名}/client/queryDramaListData`。

**请求参数说明：**

|参数|类型|是否必填|说明|
|---|---|---|---|
|page|INT(10)|否|默认值 1|
|rows|INT(10)|否|默认值 20|
|title|VARCHAR(100)|否|查询标题|
|menu_id|BIGINT(64)|否|菜单ID|

**返回参数说明：**

|参数|类型|是否必填|说明|
|---|---|---|---|
|title|VARCHAR(100)|是|标题|
|sub_title|VARCHAR(100)|是|小标题，逗号分隔（以web端设置为准）|
|is_hot|VARCHAR(1)|是|HOT标识 0 否 1 是|
|number|VARCHAR(100)|是|人数|
|type_name|VARCHAR(100)|是|类型|
|duration|VARCHAR(100)|是|建议时长|
|price|VARCHAR(100)|是|价格|
|article_url|VARCHAR(100)|是|文章链接|
|picture_url|VARCHAR(100)|是|图片链接|
|description|VARCHAR(100)|是|描述|
|menu_id|VARCHAR(100)|是|菜单ID|
|play_status|VARCHAR(100)|是|剧本状态|

### WEB端API
**略 ...**


 

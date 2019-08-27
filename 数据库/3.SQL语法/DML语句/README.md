# 数据操作 DML

DML(Data Manipulation Language, 
DML)主要是包括插入数据、修改数据、以及删除数据3种语言，即插改删；

## 增
	
	INSERT [INTO] 表名 [(字段列表)] VALUES (值列表)[, (值列表), ...];
	
	INSERT [INTO] 表名 SET 字段名 = 值[, 字段名=值, ...];
	
- 如果要插入的值列表包含所有字段并且顺序一致，则可以省略字段列表
- 可同时插入多条数据记录！ 
- REPLACE 与 INSERT 完全一样，可互换 <br>

## 删
	
	DELETE FROM 表名[ 删除条件子句];
	
- 没有条件子句，则会删除全部
	
## 改
	
	UPDATE 表名 SET 字段名=新值[, 字段名=新值] [更新条件];
# 数据定义 DDL

DDL(Data Definition
Language)实现**数据定义**的功能，可以对数据库用户、视图、撤销、索引进行定义与撤销；

## 定义数据库

### 增
		
	CREATE DATABASE [ IF NOT EXISTS] 数据库名 数据库选项;
	数据库选项：
	CHARACTER SET charset_name // 指定字符编码集
	COLLATE collation_name  // 指定字符校准集
                
### 删
		
	DROP DATABASE[ IF EXISTS] 数据库名; 
	// 同时删除该数据库相关的目录及其目录内容
	
### 改
		
	ALTER DATABASE 库名 选项信息;
	
### 查
	
	SELECT DATABASE();                  // 查看当前数据库
	SELECT NOW(),USER(),VERSION();      // 显示当前时间、用户名、数据库版本
	SHOW DATABASES[ LIKE 'PATTERN'];    // 查看已有库
	SHOW CREATE DATABASE 数据库名;       // 查看当前库信息
	

### 选项信息

MySQL、数据库、表、字段均可设置编码
数据编码与客户端编码不需一致

- 编码集
		
		SHOW VARIABLES LIKE 'character_set_%';   -- 查看所有字符集编码项
		 character_set_client;        客户端向服务器发送数据时使用的编码
		 character_set_results;       服务器端将结果返回给客户端所使用的编码
		 character_set_connection;    连接层编码
				    
		SET 变量名 = 变量值;
		SET character_set_client = gbk;
		SET character_set_results = gbk;
		SET character_set_connection = gbk;
				    
		SET NAMES GBK;  -- 相当于完成以上三个设置
		
- 校对集：校对集用以排序
	
		SHOW CHARACTER SET [LIKE 'pattern'];
		SHOW CHARSET [LIKE 'pattern'];       // 查看所有字符集
		SHOW COLLATION [LIKE 'pattern'];     // 查看所有校对集
		CHARSET 字符集编码;     // 设置字符集编码
		COLLATE 校对集编码;     // 设置校对集编码

## 定义表

### 增
		
	CREATE [TEMPORARY] TABLE [ IF NOT EXISTS] [ 库名.]表名 ( 表的结构定义 )[ 表选项属性 ];
	  - TEMPORARY 临时表，会话结束时表自动消失
	  - IF NOT EXISTS 判断是否存在，如果不存在则创建
			
	CREATE TABLE 表名 LIKE 要复制的表名;      // 复制表结构
	CREATE TABLE 表名 [AS] SELECT * FROM 要复制的表名;  // 复制表结构和数据
			
### 删
		
	DROP TABLE[ IF EXISTS] 表名 ...;      // 删除一张表
	
### 改
		
	TRUNCATE [TABLE] 表名;         // 清空当前数据表信息
	ALTER TABLE 表名 表的选项;       // 修改表信息
	ALTER TABLE 表名 操作名;         // 修改表的字段信息
	RENAME TABLE 原表名 TO 新表名;    // 修改表名
	RENAME TABLE 原表名 TO 库名.表名;  // 将该表改名并可以移动到某库
		
### 查
		
	SHOW TABLES[ LIKE 'pattern'];       // 查看当前所有的表
	SHOW TABLES FROM  库名;              // 查看数据库中的表
	SHOW CREATE TABLE 表名; （信息更详细）  // 查看表的详细信息
	DESC 表名;                            // 显示表的状态 
	DESCRIBE 表名;                        // 查看表的设计信息
	EXPLAIN 表名;                         // 显示了mysql如何使用索引来处理SELECT语句以及连接表
	SHOW COLUMNS FROM 表名 [LIKE 'PATTERN'];  // 显示表字段结构详细信息 
	SHOW TABLE STATUS [FROM db_name] [LIKE 'pattern'];  // 获取表的信息

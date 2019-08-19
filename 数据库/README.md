
***SQL语言的功能有哪些***
	
		SQL是结构化查询语句(Structured Query Language)的缩写，
	其功能包括
		- 数据查询
				数据查询是是最常见的操作，通过select语句可以得到所需的信息；
						SELECT 选择符合条件的记录 
							语法格式：SELECT * FROM table_name WHERE 条件语句;
						
		- 数据操作
				DML(Data Manipulation Language, DML)主要是包括插入数据、修改数据、以及删除数据3种语言，即插改删；
						INSERT 插入一条记录 
							语法格式：INSERT INTO table_name (字段1, 字段2, ...) VALUES (值1, 值2, ...);
						UPDATE 更新语句
							语法格式：UPDATE TABLE SET 字段名 = 字段值 WHERE 条件表达式;
						DELETE 删除记录
							语法格式：DELETE FROM table_name WHERE 条件表达式;
				
				
		- 数据定义
				DLL(Data Definition Language)实现数据定义的功能，可以对数据库用户、视图、撤销、索引进行定义与撤销；
					CREATE 数据表的建立
						CREATE TABLE table_name (字段1, 字段2, ....);
					DROP 数据表的删除
						DROP TABLE table_name;
							
		- 数据控制
				DCL(Data Control Language)用于对数据库进行统一的控制管理，保证数据在多用户共享下能够按期
					GRANT 为用户授予系统权限
						GRANT <系统权限> | <角色> [, <系统权限> | <角色>] ...TO <用户名> | <角色> PUBLIC [, <用户名> | <角色>]...[WHIT ADMIN OPTION];
					REVOKE 收回系统权限				
						REVOKE <系统权限> | <角色> [, <系统权限> | <角色>] ...FROM <用户名> | <角色> PUBLIC [, <用户名> | <角色>]...

###SQL语法
	
	- 基本操作
		- 启动MySQL
			net start mysql;
		
		- 创建Windows服务
			sc create mysql binPath= Mysql的bin目录路径 (注意：等号右边有一个空格)
			
		- 连接和断开服务器
			mysql -h 地址 -P 端口 -u 用户名 -p 密码
		
		- 显示那些线程正在运行
			SHOW PROCESSLIST
		
		- 显示系统变量信息
			SHOW VARIABLES
	
	- 数据库操作
	 - 查看当前数据库
			SELECT DATABASE();
				
	 - 显示当前时间、用户名、数据库版本
	    SELECT NOW(), USER(), VERSION();
	 
	 - 创建库
	    CREATE DATABASE 数据库名 数据库选项;
	      数据库选项：
	       - 设置数据库字符编码集
          CHARACTER SET 字符集编码集;         
         - 设置数据表的校对规则，指定数据集如何排序比如：
            utf8_bin将字符串中的每一个字符用二进制数据存储，区分大小写。
            utf8_genera_ci不区分大小写，ci为case insensitive的缩写，即大小写不敏感。
            utf8_general_cs区分大小写，cs为case sensitive的缩写，即大小写敏感。
          COLLATE 校对规则;
	    
	 - 查看已有库
	     
	 
	 - 查看当前库信息
	 - 修改库的选项信息
	 - 删除库
	 
	 
	- 表的操作
	
	- 数据操作
	
	- 字符集编码
	
	- 数据类型(列类型)
	
	- 列属性(列约束)
	
	- 建表规范
	
	- SELECT
	
	- UNION
	
	- 子查询
	
	- 连接查询(join)
	
	- TRUNCATE
	
	- 备份和还原
	
	- 视图
	
	- 事务(transaction)
	
	- 锁表
	
	- 触发器
	
	- SQL编程
	
	- 存储过程
	
	- 用户和权限管理
	
	- 表维护
	
	- 杂项
	
	









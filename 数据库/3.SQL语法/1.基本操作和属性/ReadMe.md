## Windows服务

- 启动MySQL
	
		net start mysql
		
- 创建Windows服务
	
		sc create mysql binPath= mysqld_bin_path(注意：等号与值之间有空格)
    
## 连接与断开服务器
- 连接数据库
	
		mysql -h 地址 -P 端口 -u 用户名 -p 密码
		
- 显示哪些线程正在运行
	
		SHOW PROCESSLIST;
		
- 显示系统变量信息
	
		SHOW VARIABLES 
		
***数据库操作***

## 数据库操作
	
- 增
		
		CREATE DATABASE [ IF NOT EXISTS] 数据库名 数据库选项;
		数据库选项：
		CHARACTER SET charset_name // 指定字符编码集
		COLLATE collation_name  // 指定字符校准集
                
- 删
		
		DROP DATABASE[ IF EXISTS] 数据库名; 
		// 同时删除该数据库相关的目录及其目录内容
	
- 改
		
		ALTER DATABASE 库名 选项信息;
	
- 查
	
		SELECT DATABASE();                  // 查看当前数据库
		SELECT NOW(),USER(),VERSION();      // 显示当前时间、用户名、数据库版本
		SHOW DATABASES[ LIKE 'PATTERN'];    // 查看已有库
		SHOW CREATE DATABASE 数据库名;       // 查看当前库信息
	

## 选项信息

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

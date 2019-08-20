# 表的操作

## 增
		
	CREATE [TEMPORARY] TABLE [ IF NOT EXISTS] [ 库名.]表名 ( 表的结构定义 )[ 表选项属性 ];
	  - TEMPORARY 临时表，会话结束时表自动消失
	  - IF NOT EXISTS 判断是否存在，如果不存在则创建
			
	CREATE TABLE 表名 LIKE 要复制的表名;      // 复制表结构
	CREATE TABLE 表名 [AS] SELECT * FROM 要复制的表名;  // 复制表结构和数据
			
## 删
		
	DROP TABLE[ IF EXISTS] 表名 ...;      // 删除一张表
	
## 改
		
	TRUNCATE [TABLE] 表名;         // 清空当前数据表信息
	ALTER TABLE 表名 表的选项;       // 修改表信息
	ALTER TABLE 表名 操作名;         // 修改表的字段信息
	RENAME TABLE 原表名 TO 新表名;    // 修改表名
	RENAME TABLE 原表名 TO 库名.表名;  // 将该表改名并可以移动到某库
		
## 查
		
	SHOW TABLES[ LIKE 'pattern'];       // 查看当前所有的表
	SHOW TABLES FROM  库名;              // 查看数据库中的表
	SHOW CREATE TABLE 表名; （信息更详细）  // 查看表的详细信息
	DESC 表名;                            // 显示表的状态 
	DESCRIBE 表名;                        // 查看表的设计信息
	EXPLAIN 表名;                         // 显示了mysql如何使用索引来处理SELECT语句以及连接表
	SHOW COLUMNS FROM 表名 [LIKE 'PATTERN'];  // 显示表字段结构详细信息 
	SHOW TABLE STATUS [FROM db_name] [LIKE 'pattern'];  // 获取表的信息
    
## 其他

	CHECK TABLE tbl_name [, tbl_name] ... [option] ...;   // 检查表是否有错误
	OPTIMIZE [LOCAL | NO_WRITE_TO_BINLOG] TABLE tbl_name [, tbl_name] ...;  // 优化表
	REPAIR [LOCAL | NO_WRITE_TO_BINLOG] TABLE tbl_name [, tbl_name] ... [QUICK] [EXTENDED] [USE_FRM]; // 修复表
	ANALYZE [LOCAL | NO_WRITE_TO_BINLOG] TABLE tbl_name [, tbl_name] ...;   // 分析表

# 表的结构定义

## 字段

- 每个字段必须有数据类型
- 最后一个字段后不能有逗号
   
  对于字段的定义：
          
      字段名 数据类型 [NOT NULL | NULL] [DEFAULT default_value] [AUTO_INCREMENT] [UNIQUE [KEY] | [PRIMARY] KEY] [COMMENT 'string']
						
		- 基本：字段名 数据类型;
		- [NOT NULL | NULL] 约束，定义"非空"或"空"
		- [DEFAULT default_value] 默认值，定义字段的初始值
		- [AUTO_INCREMENT] 自增约束，仅可约束"主键"和“UNIQUE”的字段且只有一个，默认为1开始增长
		- [UNIQUE [KEY] | [PRIMARY] KEY] 唯一索引/字段，使该字段为"唯一索引"/"唯一字段"
		- [COMMENT 'string'] 表注释，为该字段添加"注释"
						
## 数据类型

#### 数值类型
		
- 整型
		
		    类型         字节     范围（有符号位）
		    tinyint     1字节    -128 ~ 127      无符号位：0 ~ 255
		    smallint    2字节    -32768 ~ 32767
		    mediumint   3字节    -8388608 ~ 8388607
		  * int         4字节
		    bigint      8字节
		    int(M)      M表示总位数
		    
		    - 默认存在符号位，unsigned 属性修改
		    - 显示宽度，如果某个数不够定义字段时设置的位数，则前面以0补填，zerofill 属性修改
		        例：int(5)   插入一个数'123'，补填后为'00123'
		    - 在满足要求的情况下，越小越好。
		    - 1表示bool值真，0表示bool值假。MySQL没有布尔类型，通过整型0和1表示。常用tinyint(1)表示布尔型。
		    
- 浮点型
	
		类型             字节     范围
		float(单精度)     4字节
		* double(双精度)    8字节
		    
		- 浮点型既支持符号位 unsigned 属性，也支持显示宽度 zerofill 属性。
		  不同于整型，前后均会补填0.
		- 定义浮点型时，需指定总位数和小数位数。
		  float(M, D)     double(M, D)
		  M表示总位数，D表示小数位数。
		  M和D的大小会决定浮点数的范围。不同于整型的固定范围。
		  M既表示总位数（不包括小数点和正负号），也表示显示宽度（所有显示符号均包括）。
		  支持科学计数法表示。
		  浮点数表示近似值。
        
- 定点数
		
		decimal         可变长度
		decimal(M, D)   M也表示总位数，D表示小数位数。
		  
		  - 保存一个精确的数值，不会发生数据的改变，不同于浮点数的四舍五入。
		  - 将浮点数转换为字符串来保存，每9位数字保存为4个字节。
    
#### 字符串类型

- char, varchar
		
		char    定长字符串，速度快，但浪费空间
		varchar 变长字符串，速度慢，但节省空间
		    
		- M表示能存储的最大长度，此长度是字符数，非字节数
		- 不同的编码，所占用的空间不同
		  char,最多255个字符，与编码无关
		  varchar,最多65535字符，与编码有关
		- 一条有效记录最大不能超过65535个字节
		  utf8 最大为21844个字符，gbk 最大为32766个字符，latin1 最大为65532个字符
		- varchar 是变长的，需要利用存储空间保存 varchar 的长度，如果数据小于255个字节，则采用一个字节来保存长度，反之需要两个字节来保存。
		  varchar 的最大有效长度由最大行大小和使用的字符集确定。
		- 最大有效长度是65532字节，因为在varchar存字符串时，第一个字节是空的，不存在任何数据，然后还需两个字节来存放字符串的长度，所以有效长度是64432-1-2=65532字节。
		  例：若一个表定义为 CREATE TABLE tb(c1 int, c2 char(30), c3 varchar(N)) charset=utf8; 问N的最大值是多少？ 答：(65535-1-2-4-30*3)/3
		    
		-- b. blob, text ----------
		
		    blob 二进制字符串（字节字符串）
		        tinyblob, blob, mediumblob, longblob
		    text 非二进制字符串（字符字符串）
		        tinytext, text, mediumtext, longtext
		    text 在定义时，不需要定义长度，也不会计算总长度。
		    text 类型在定义时，不可给default值
		    
		-- c. binary, varbinary ----------
		
		    类似于char和varchar，用于保存二进制字符串，也就是保存字节字符串而非字符字符串。
		    char, varchar, text 对应 binary, varbinary, blob.
		    
	3.日期时间类型

	一般用整型保存时间戳，因为PHP可以很方便的将时间戳进行格式化。
	
		 datetime    8字节    日期及时间    1000-01-01 00:00:00 到 9999-12-31 23:59:59
		 date        3字节    日期         1000-01-01 到 9999-12-31
		 timestamp   4字节    时间戳       19700101000000 到 2038-01-19 03:14:07
		 time        3字节    时间         -838:59:59 到 838:59:59
		 year        1字节    年份         1901 - 2155
		    
		datetime    YYYY-MM-DD hh:mm:ss
		
		timestamp   YY-MM-DD hh:mm:ss
		            YYYYMMDDhhmmss
		            YYMMDDhhmmss
		            YYYYMMDDhhmmss
		            YYMMDDhhmmss
		            
		date        YYYY-MM-DD
		            YY-MM-DD
		            YYYYMMDD
		            YYMMDD
		            YYYYMMDD
		            YYMMDD
		            
		time        hh:mm:ss
		            hhmmss
		            hhmmss
		            
		year        YYYY
		            YY
		            YYYY
		            YY
  4.枚举和集合

	-- 枚举(enum) ----------
		
		enum(val1, val2, val3...)
				
			- 在已知的值中进行单选。最大数量为65535.
			- 枚举值在保存时，以2个字节的整型(smallint)保存。每个枚举值，按保存的位置顺序，从1开始逐一递增。
			- 表现为字符串类型，存储却是整型。
			- NULL值的索引是NULL。
			- 空字符串错误值的索引值是0。
		    
	-- 集合（set） ----------
		
		set(val1, val2, val3...)
				
			- create table tab ( gender set('男', '女', '无') );
			- insert into tab values ('男, 女');
			- 最多可以有64个不同的成员。以bigint存储，共8个字节。采取位运算的形式。
			- 当创建表时，SET成员值的尾部空格将自动被删除。

***NULL 约束***

   - null不是数据类型，是列的一个属性。
   - 表示当前列是否可以为null，表示什么都没有。
   - null, 允许为空。默认。
   - not null, 不允许为空。
   - insert into tab values (null, 'val');
        -- 此时表示将第一个字段的值设为null, 取决于该字段是否允许为null
        
***DEFAULT 默认值属性***
		
		 - 当前字段的默认值。
        
        insert into tab values (default, 'val');    -- 此时表示强制使用默认值。
        create table tab ( add_time timestamp default current_timestamp ); -- 表示将当前时间的时间戳设为默认值。
        current_date, current_time;
        
***AUTO_INCREMENT 自动增长约束***
	
    - 自动增长必须为索引（主键或unique）
    - 只能存在一个字段为自动增长。
    - 默认为1开始自动增长。可以通过表属性 auto_increment = x 进行设置，或 alter table tbl auto_increment = x;

***UNIQUE 唯一索引（唯一约束）***

    使得某字段的值也不能重复。

***PRIMARY 主键***

    - 能唯一标识记录的字段，可以作为主键。
    - 一个表只能有一个主键。
    - 主键具有唯一性。
    - 声明字段时，用 primary key 标识。
        也可以在字段列表之后声明
            例：create table tab ( id int, stu varchar(10), primary key (id));
    - 主键字段的值不能为null。
    - 主键可以由多个字段共同组成。此时需要在字段列表后声明的方法。
        例：create table tab ( id int, stu varchar(10), age int, primary key (stu, age));

***COMMENT 表注释***
		
		COMMENT = 'string';
		例：create table tab ( id int ) comment '注释内容';

### 表的选项属性

***字符集***
	
	- 设定表的字符集编码
   
        CHARSET = charset_name;
   
        // 如果表没有设定，则使用数据库字符集
          
***存储引擎***
	 
	 - 设定表的存储引擎
	 
        ENGINE = engine_name
   
		   表在管理数据时采用的不同的数据结构，结构不同会导致处理方式、提供的特性操作等不同
		   常见的引擎：InnoDB MyISAM Memory/Heap BDB Merge Example CSV MaxDB Archive
		   不同的引擎在保存表的结构和数据时采用不同的方式
   
		   MyISAM表文件含义：.frm表定义，.MYD表数据，.MYI表索引
		   InnoDB表文件含义：.frm表定义，表空间数据和日志文件
          
          SHOW ENGINES; -- 显示存储引擎的状态信息
          SHOW ENGINE 引擎名 {LOGS|STATUS}; -- 显示存储引擎的日志或状态信息
          
***自增起始数***
   
	- 设定表的自增起始数：
   
    AUTO_INCREMENT = 行数;

***FOREIGN KEY 外键约束***

    - 用于限制主表与从表数据完整性。
    
    alter table t1 add constraint `t1_t2_fk` foreign key (t1_id) references t2(id);
        -- 将表t1的t1_id外键关联到表t2的id字段。
        -- 每个外键都有一个名字，可以通过 constraint 指定
        
    - 存在外键的表，称之为从表（子表），外键指向的表，称之为主表（父表）。
    - 作用：保持数据一致性，完整性，主要目的是控制存储在外键表（从表）中的数据。
    
    MySQL中，可以对InnoDB引擎使用外键约束：
    
		    语法：
				    foreign key (外键字段） references 主表名 (关联字段) [主表记录删除时的动作] [主表记录更新时的动作]
				    
				    - 此时需要检测一个从表的外键需要约束为主表的已存在的值。外键在没有关联的情况下，可以设置为null.前提是该外键列，没有not null。
				    - 可以不指定主表记录更改或更新时的动作，那么此时主表的操作被拒绝。
		    
    如果指定了 on update 或 on delete：在删除或更新时，有如下几个操作可以选择：
		    1. cascade，级联操作。主表数据被更新（主键值更新），从表也被更新（外键值更新）。主表记录被删除，从表相关记录也被删除。
		    2. set null，设置为null。主表数据被更新（主键值更新），从表的外键被设置为null。主表记录被删除，从表相关记录外键被设置成null。但注意，要求该外键列，没有not null属性约束。
		    3. restrict，拒绝父表删除和更新。
    
    注意，外键只被InnoDB存储引擎所支持。其他引擎是不支持的。
      	
***数据文件目录***

    DATA DIRECTORY = '目录';

***索引文件目录***

    INDEX DIRECTORY = '目录';
             
### 建表规范

    -- Normal Format, NF
    
        - 每个表保存一个实体信息
        - 每个具有一个ID字段作为主键
        - ID主键 + 原子表
        
    -- 1NF, 第一范式
    
        字段不能再分，就满足第一范式。
        
    -- 2NF, 第二范式
    
        满足第一范式的前提下，不能出现部分依赖。
        消除符合主键就可以避免部分依赖。增加单列关键字。
        
    -- 3NF, 第三范式
    
        满足第二范式的前提下，不能出现传递依赖。
        某个字段依赖于主键，而有其他字段依赖于该字段。这就是传递依赖。
        将一个实体信息的数据放在一个表内实现。      



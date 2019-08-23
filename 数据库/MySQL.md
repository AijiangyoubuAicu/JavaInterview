# MySQL数据库

[TOC]

------

## 1. 什么是数据库？

* 数据库（Database）是按照数据结构来组织、存储和管理数据的仓库

* 常见数据库

  * Oracle
  * DB2
  * SQL Server
  * Postgre SQL
  * MySQL

* 相关术语

  * 数据库系统（Database System）：DBS

    * 数据库（Database）
    * 数据库管理系统（Database Management System）：DBMS
    * 应用开发工具
    * 管理员及用户

  * SQL语言

    Structured Query Language：结构化查询语言

    * DDL（数据定义语言）
    * DML（数据操作语言）
    * DQL（数据查询语言）
    * DCL（数据控制语言）

------

## 2. MySQL相关操作

### 配置文件

`my.cnf`是MySQL的配置文件

### 登陆、退出MySQL

* 登陆

  * `mysql -uroot -p`

  * `mysql -uroot -proot`

  * 得到版本号

    * `mysql -V`
    * `mysql --version`

  * 登陆的同事打开指定数据库

    `mysql -uroot -p -D db_name`

* 退出

  * `exit`
  * `quit`
  * `\q`

* 登陆信息中需要掌握的

  * 命令行结束符默认使用`;`或者`\g`来结束
  * 可以通过`help`或者`\h`或者`?`加上相关关键字类查看手册
  * `\c`可以取消当前命令的执行

### SQL语句语法规范

* 常用MySQL的关键字我们需要大写，库名、表名、字段名称等使用小写
* SQL语句支持折行操作，才分的时候不能把完整单词拆开
* 数据库名称、表名称、字段名称不要使用MySQL的保留字，如果必须要使用，需要用反引号\`\`将其括起来

### 常用SQL语句

* 得到登陆的用户

  ```mysql
  SELECT USER()
  ```

* 得到MySQL的版本信息

  ```mysql
  SELECT VERSION()
  ```

* 得到当前的日期时间

  ```mysql
  SELECT NOW()
  ```

* 得到当前打开的数据库

  ```mysql
  SELECT DATABASE()
  ```

------

## 3. 数据库相关操作

### 创建数据库

```mysql
CREATE {DATABASE|SCHEMA} db_name;
```

* 检测数据库名称是否存在，不存在则创建

  ```mysql
  CREATE DATABASE [IF NOT EXISTS] db_neme;
  ```

* 在创建数据库的同时指定编码方式

  ```mysql
  CREATE DATABASE [IF NOT EXISTS] db_name [DEFAULT] CHARACTER SET [=] charset;
  ```

* 注意

  > 1. 数据库名称最好有意义
  > 2. 名称不要包含特殊字符或者是MySQL关键字

### 查看当前服务器下全部数据库

```mysql
SHOW DATABASES|SCHEMAS;
```

### 查看指定数据库的详细信息

```mysql
SHOW CREATE DATABASE db_name;
```

### 修改指定数据库的编码

```mysql
ALTER DATABASE db_name [DEFAULT] CHARACTER SET [=] charset;
```

### 打开指定数据库

```mysql
USE db_name;
```

### 得到当前打开的数据库

```mysql
SELECT DATABASE()|SCHEMA();
```

### 删除指定的数据库

```mysql
DROP DATABASE db_name;
```

如果数据库存在则删除

```mysql
DROP DATABASE [IF EXISTS] db_name;
```

------

## 4. 数据表相关操作

### 数据表

* 数据库最重要的组成部分之一，数据保存在数据表中
* 数据表由行（row）和列（column）来组成
* 每个数据表至少有一列，行可以有零行或者多行组成
* 表名要求唯一，不要包含特殊字符，最好含义明确

### 创建表

```mysql
CREATE TABLE [IF NOT EXISTS] tbl_name(
	字段名称 字段类型 [完整性的约束条件]，
    字段名称 字段类型 [完整性的约束条件]，
    ...
)ENGINE=存储引擎 CHARSET=编码方式;
```

* `UNSIGNED`：无符号，没有负数，从0开始
* `ZERFILL`：零填充，当数据的显示长度不够的时候可以使用补0的效果填充至指定长度
* `NOT NULL`：非空约束，也就是插入值的时候这个字段必须要给至
* `DEFAULT`：默认值，如果插入记录的时候没有给字段赋值，则使用默认值
* `AUTO_INCREMENT`：自增
* `PRIMARY KEY`：主键，标识记录的唯一性，值不能重复，一个表只能有一个主键，自动禁止为空
* `UNIQUE KEY`：唯一性，一个表中可以有多个字段是唯一索引，同样的值不能重复，但是NULL值除外
* `FOREIGN KEY`：外键约束
* `COMMENT`：备注

### 查看当前数据库下已有数据表

```mysql
SHOW [FULL] TABLES [{FROM | IN} db_name] [LIKE 'pattern' | WHERE expr]

SHOW TABLES;
```

### 查看指定数据表的详细信息

```mysql
SHOW CREATE TABLE tbl_name;
```

### 查看表结构

```mysql
DESC tbl_name;
DESCRIBE tbl_name;
SHOW COLUMNS FROM tbl_name;
```

### 删除指定数据表

```mysql
DROP TABLE [IF EXISTS] tbl_name;
```

### 表结构相关操作

* 添加字段

  ```mysql
  ALTER TABLE [IF EXISTS] tbl_name ADD 字段名称 字段属性 [完整性约束条件] [FIRST|AFTER 字段名称]
  ```

* 删除字段

  ```mysql
  ALTER TABLE tbl_name DROP 字段名称;
  ```

* 添加默认值

  ```mysql
  ALTER TABLE tbl_name
  ALTER 字段名称 SET DEFAULT 默认值
  ```

* 删除默认值

  ```mysql
  ALTER TABLE tbl_name
  ALTER 字段名称 DROP DEFAULT
  ```

* 修改字段类型、字段属性

  ```mysql
  ALTER TABLE tbl_name
  MODIFY 字段名称 字段类型 [字段属性][FIRST|AFTER 字段名称]
  ```

* 修改字段名称、字段类型、字段属性

  ```mysql
  ALTER TABLE tbl_name
  CHANGE 原字段名称 新字段名称 字段类型 [字段属性][FIRST|AFTER 字段名称]
  ```

* 添加主键

  ```mysql
  ALTER TABLE tbl_name
  ADD PRINARY KEY(字段名称)
  ```

* 删除主键

  ```mysql
  ALTER TABLE tbl_name
  DROP PRIMARY KET
  ```

* 添加唯一

  ```mysql
  ALTER TABLE tbl_name
  ADD UNIQUE KEY|INDEX [index_name](字段名称)
  ```

* 删除唯一

  ```mysql
  ALTER TABLE tbl_name
  DROP INDEX index_name
  ```

* 修改数据表名称

  ```mysql
  ALTER TABLE tbl_name
  RENAME [TO|AS] new_tbl_name
  
  RENAME TABLE tbl_name TO new_tbl_name
  ```

* 修改AUTO_INCREMENT的值

  ```mysql
  ALTER TABLE tbl_name AUTO_INCREMENT=值
  ```

------

## 5. MySQL中的数据类型

### 数值型

* 整数型

  | 数据类型     | 存储范围                                                     | 字节 |
  | ------------ | ------------------------------------------------------------ | :--: |
  | TINYINT      | 有符号值：-128到127（-2^7到2^7-1）<br />无符号值：0到255（0到2^8-1） |  1   |
  | SMALLINT     | 有符号值：-32768到32767（-2^15到2^15-1）<br />无符号值：0到65535（0到2^16-1） |  2   |
  | MEDIUMINT    | 有符号值：-8388608到8388607（-2^23到2^23-1）<br />无符号值：0到16777215（0到2^24-1） |  3   |
  | INT          | 有符号值：-2147683645到2147683647（-2^31到2^31-1）<br />无符号值：0到4294967295（0到2^32-1） |  4   |
  | BIGINT       | 有符号值：-9223372036854775808到9223372036854775807（-2^63到2^63-1）<br />无符号值：0到18446744073709551615（0到2^64-1） |  8   |
  | BOOL,BOOLEAN | 等价于TINYINT(1)，0为false，其余为true                       |  1   |

* 浮点型

  | 数据类型       | 存储范围                                                     | 字节 |
  | -------------- | ------------------------------------------------------------ | ---- |
  | FLOAT[(M,D)]   | 负数取值范围为-3.40E+38到-1.17E-38、0和1.175E-38到3.40E+38。<br />M是数字总位数，D是小数点后面的位数。如果M和D被省略，根据硬件允许的限制来保存值。单精度浮点数精确到大约7为小数位 | 4    |
  | DOUBLE[(M,D)]  | -1.79E+308到-2.22E-308、0和2.22E-308到1.79E+308。            | 8    |
  | DECIMAL[(M,D)] | 和DOUBLE一样，内部以字符串形式存储数值                       | M+2  |

### 字符串类型

| 列类型                      | 存储需求                                                   |
| --------------------------- | ---------------------------------------------------------- |
| CHAR(M)                     | M个字节，0<=M<=255                                         |
| VARCHAR(M)                  | L+1个字节，其中L<=M且0<=M<=65535                           |
| TINYTEXT                    | L+1个字节，其中L<2^8                                       |
| TEXT                        | L+2个字节，其中L<2^16                                      |
| MEDIUMTEXT                  | L+3个字节，其中L<2^24                                      |
| LOGTEXT                     | L+4个字节，其中L<2^32                                      |
| ENUM(‘value1’,'value2',...) | 1或2个字节，取决于枚举值的个数（最多65535个值）            |
| SET('value1','value2'...)   | 1、2、3、4或者8个字节，取决于set成员的数目（最多64个成员） |

* CHAR效率高于VARCHAR，CHAR相当于拿空间换时间，VARCHAR拿时间换空间
* CHAR默认存储数据的时候，后面会用空格填充到指定长度；而在检索的时候会去掉后面空格；VARCHAR在保存的时候不进行填充，尾部的空格会留下
* TEXT列不能有默认值，检索的时候不存在大小写转换

### 日期时间类型

| 列类型    | 存储范围                                    | 存储需求 |
| --------- | ------------------------------------------- | -------- |
| TIME      | -838:59:59~838:59:59                        | 3        |
| DATE      | 1000-01-01~9999-12-31                       | 3        |
| DATETIME  | 1000-01-01 00:00:00~9999-12-31 23:59:59     | 8        |
| TIMESTAMP | 1970-01-01 00:00:01 UTC~2038-01-19 03:14:07 | 4        |
| YEAR      | 1901~2155                                   | 1        |

### 二进制类型

## 6. MySQL存储引擎

### `MyISAM`存储引擎

* 默认`MyISAM`的表会在磁盘中产生3个文件

  * `.frm`：表结构文件
  * `.MYD`：数据文件
  * `MYI`：索引文件

* 可以在创建的时候指定数据文件和索引文件的存储位置，只有`MyISAM`表支持

  * `DATA DIRECORY [=] 数据保持的绝对路径`
  * `INDEX DIRECTORY [=] 索引文件保持的绝对路径`

* `MyISAM`表单最大支持的数据量2的64次方条记录

* 每个表最多可以建立64个索引

* 如果是复合索引，每个复合索引最多包含16个列，索引值最大长度是**1000B**

* `MyISAM`引擎的存储格式

  * 定长（FIXED静态）

    是指字段中不包含`VARCHAR/TEXT/BLOB`

  * 动态（DYNAMIC）

    只要字段中包含了`VARCHAR/TEXT/BlOB`

  * 压缩（COMPRESSED）

    `mysiampack`创建

### `InnoDB`存储引擎

* 设计遵循`ACID`模型，支持事务，具有从服务崩溃中恢复的能力，能够最大限度保护用户的数据
* 支持行级锁，可以提升多用户并发时的读写性能
* 支持外键，保证数据的一致性和完整性
* `InnoDB`拥有自己独立的缓冲池，常用的数据和索引都在缓存中
* 对于`INSERT`、`UPDATE`、`DELETE`操作，`InnoDB`会使用一种`change buffering`的机制来自动优化，还可以提供一致性的读，并且还能够缓存变更的数据，减少磁盘`I/O`，提高性能
* 创建`InnoDB`表之后会产生两个文件
  * `.frm`表结构文件
  * `.ibd`数据和索引存储表空间中
* 所有的表都需要创建主键，最好是配合上`AUTO_INCREMENT`，也可以放到经常查询的列作为主键

## 7. MySQL数据操作

### 添加记录

```mysql
INSERT [INTO] tbl_name[(col_name,...)]{VALUE|VALUES}(VALUES,...);
```

* 不指定字段名称

  ```mysql
  INSERT tbl_name VALUE(value...)
  ```

  需要按照建表时的字段循序给每一个字段赋值

* 列出指定字段

  ```mysql
  INSERT tbl_name(字段名称,...) VALUES(值,...)
  ```

* INSERT ... SET的形式

  ```mysql
  INSERT tbl_name SET 字段名称=值,...;
  ```

* INSERT ... SELECT

  ```mysql
  INSERT tbl_name[(字段名称...)] SELECT 字段名称,... FROM tbl_name [WHERE 条件]
  ```

* 一次添加多条记录

  ```mysql
  INSERT tbl_name[(字段名称,...)] VALUES(值,...),(值,...),...;
  ```

### 修改记录

```mysql
UPDATE tbl_name SET 字段名称=值,字段名称=值 [WHERE 条件]
```

如果不添加条件，整个表中的记录都会被更新

### 删除记录

```mysql
DELETE FROM tbl_name [WHERE 条件]
```

* 如果不添加条件，表中所有记录都会被删除

* `DELETE`清空数据表的时候不会充值`AUTO_INCREMENT`的值，可以通过`ALTER`语句将其重置为1

* 彻底清空数据表

  ```mysql
  TRUNCATE [TABLE] tbl_name;
  ```

  * 清除表中所有记录
  * 会重置`AUTO_INCREMENT`的值

### 查询记录

```mysql
SELECT select_expr,... FROM tbl_name [WHERE 条件] 
[GROUP BY {col_name|position} HAVING 二次筛选] 
[ORDER BY {col_name|position|expr} [ASC|DESC]] 
[LIMIT 限制结果集的显示条数]
```

* 查询表中所有记录

  ```mysql
  SELECT * FROM tbl_name;
  ```

  `*`所有字段

*  指定字段的信息

  ```mysql
  SELECT 字段名称,... FROM tbl_name;
  ```

* 库名.表名

  ```mysql
  SELECT 字段名称,... FROM db_name.tbl_name;
  ```

* 给字段起别名

  ```mysql
  SELECT 字段名称 [AS] 别名名称,... FROM db_name.tbl_name; 
  ```

* 给数据表起别名

  ```mysql
  SELECT 字段名称 ,... FROM tbl_name [AS] 别名;
  ```

* 表名.字段名的

  ```mysql
  SELECT tbl_name.col_name,... FROM tbl_name;
  ```

* WHERE 条件
  会筛选出符合条件的记录

  * 比较运算符

    `>` `>=` `<` `<=` `!=` `<>`  `<=>`

    * `<=>`和`=`的区别

      `<=>`可以检测NULL值

  * `IS [NOT] NULL`

    检测值是否为`NULL`或者`NOT NULL`

  * 指定范围

    `[NOT] BETWEEN ... AND`

  * 指定集合
    `[NOT] IN(值,...)`

  * 逻辑运算符

    * `AND`（逻辑与）
    * `OR`（逻辑或）

  * 匹配字符

    * `[NOT] LIKE`
    * `%`任意长度的字符串
    * `_`任意一个字符

* `GROUP BY`分组

  * 把值相同放到一个组中，最终查询出的结果只会显示组中一条记录
  * 分组配合`GROUP_CONCAT()`查看组中某个字段的详细信息
  * 配合聚合函数使用
    * `COUNT()`统计记录总数
      1. 如果写的是`COUNT(字段名称)`，字段中的值为`NULL`，不统计进来
      2. 写`COUNT(*)`会统计`NULL`值
    * `SUM()`求和
    * `MAX()`求最大值
    * `MIN()`求最小值
    * `AVG()`求平均值
  * 配合`WITH ROLLUP`关键使用
    会在记录末尾添加一条记录，是上面所有记录的总和
  * `HAVING`子句对分组结果进行二次筛选

* `ORDER BY`排序

  ```mysql
  ORDER BY 字段名称 ASC|DESC
  ```

* `LIMIT`限制结果集显示条数

  * `LIMIT 值`
    显示结果集的前几条记录
  * `LIMIT offset,row_count`
    从`offset`开始，显示几条记录，`offset`从0开始

### 多表查询

* 笛卡尔积的形式

* 内连接的形式

  查询两个表中符合连接条件的记录

  ```mysql
  SELECT 字段名称,... FROM tbl_name1
  INNER JOIN tbl_name2
  ON 连接条件
  ```

* 外连接的形式

  * 左外连接

    ```mysql
    SELECT 字段名称,... FROM tbl_name1
    LEFT [OUTER] JOIN tbl_name2
    ON 条件;
    ```

    先显示左表中的全部记录，再去右表中查询复合条件的记录，不符合的以NULL代替

  * 右外连接

    ```mysql
    SELECT 字段名称,... FROM tbl_name1
    RIGHT [OUTER] JOIN tbl_name2
    ON 条件;
    ```

    先显示右表中的全部记录，再去左表中查询复合条件的记录，不符合的以NULL代替

### 外键约束

- 只有`InnoDB`存储引擎支持外键

- 创建外键

  - 建表时指定外键

    ```mysql
    [CONSTRAINT 外键名称 ]FOREIGN KEY(字段名称) REFERENCES 主表(字段名称)
    ```

    - 子表的外键字段和主表的主键字段类型要相似；如果是数值型要求一致，并且无符号也要一致；如果是字符型，要求类型一致，长度可以不同

    - 如果外键字段没有创建索引，`MySQL`会自动帮我们添加索引

    - 子表的外键关联的必须是父表的主键

    - 外键约束的参照操作

      - `CASCADE`
        从附表删除或更新，子表也跟着删除或者更新，级联的操作

      - `SET NULL`

        从附表删除或者更新记录，并设置子表的外键列为`NULL`。

      - `NO ACTION | RESTRICT`
        拒绝对父表做更新或者删除操作

  - 动态添加外键

    - 动态添加外键

      ```mysql
      ALTER TABLE tbl_name
      [CONSTRAINT 外键名称] ADD FOREIGN KEY(外键字段) REFERENCES 主表(主键字段);
      ```

      动态添加外键之前表中的记录一定合法的记录，没有脏值，否则外键添加不成功

    - 动态删除外键

      ```mysql
      ALTER TABLE tbl_name
      DROP FOREIGN KEY fk_name;
      ```

### 特殊形式的查询

* 子查询

  ```mysql
  SELECT 字段名称 FROM tbl_name WHERE col_name=(SELECT col_name FROM tbl_name)
  ```

  * 内层语句查询的结果可以做为外层语句查询的条件

  * 由IN引发的子查询

  * 由比较运算符引出子查询

  * 由EXISTS引发的子查询

  * ANY SOME ALL

    | 运算符\关键字 | ANY    | SOME   | ALL    |
    | ------------- | ------ | ------ | ------ |
    | \>、>=        | 最小值 | 最小值 | 最大值 |
    | <、>=         | 最大值 | 最大值 | 最小值 |
    | =             | 任意值 | 任意值 |        |
    | <>、!=        |        |        | 任意值 |

  * INSERT ... SELECT

  * CREATE ... SELECT

  * CREATE TABLE tbl_name LIKE tbl_name;

* 联合查询

  * `UNION`

    ```mysql
    SELECT 字段名称,... FROM tbl_name1 
    UNION
    SELECT 字段名称... FROM tbl_name2;
    ```

  * `UNION ALL`

    ```mysql
    SELECT 字段名称,... FROM tbl_name1 
    UNION ALL
    SELECT 字段名称... FROM tbl_name2;
    ```

  * `UNION ALL`是简单的合并，`UNION`会去掉表中重复记录

* 自身连接查询

  无限级分类的实现形式

## 8. MySQL常用函数

### 数学函数

* `CEIL()`：进一取整
* `FLOOR()`：舍掉小数部分
* `ROUND()`：四舍五入
* `TRUNCATE()`：截取小数点后几位
* `MOD()`：取余数
* `ABS()`：取绝对值
* `POWER()`：幂运算
* `PI()`：圆周率
* `RAND()`或者`RAND(X)`：0~1之间的随机数
* `SIGN(X)`：得到数字符号
* `EXP(X)`：计算e的x次方

### 字符串函数

### 日期时间函数

### 其他常用函数

## 9. 图形化工具管理数据库

* MySQL Workbench

## 常用SQL语句

### 查看上一步操作参数的警告信息

```mysql
SHOW WARNINGS;
```

### mysql中的注释

* `# 注释内容`
* `-* 注释内容`



------

[回到顶部](#MySQL数据库)
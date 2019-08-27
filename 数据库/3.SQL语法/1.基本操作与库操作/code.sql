/* 显示哪些线程正在运行 */
SHOW PROCESSLIST;

/* 显示系统变量信息 */
SHOW VARIABLES;

/* 新建名为db1数据库 */
CREATE DATABASE db1;

/* 新建名为db2数据库并指定字符集为utf8，字符校准集为utf8_bin；并判断是否已存在，存在则不创建 */
CREATE DATABASE IF NOT EXISTS
    db2
CHARACTER SET
    utf8
COLLATE
    utf8_bin;

/* 删除名为db1的数据库 */
DROP DATABASE db1;

/* 修改db2的字符集为gbk */
ALTER DATABASE
    db2
CHARACTER SET
    gbk;

/* 查看当前数据库 */
SELECT DATABASE();

/* 显示当前时间、用户名、数据库版本 */
SELECT NOW(), USER(), VERSION();

/* 查看已有数据库 */
SHOW DATABASES;

/* 查看以"s"为开头的数据库 */
SHOW DATABASES LIKE 's%';

/* 查看指定数据库的信息 */
SHOW CREATE DATABASE aijiangdb;
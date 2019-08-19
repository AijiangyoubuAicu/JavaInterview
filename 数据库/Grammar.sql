/* 查看当前数据库 */
SELECT DATABASE();

/* 显示当前时间、用户名、数据库版本 */
SELECT NOW(), USER(), VERSION();

/* 创建库 */
CREATE DATABASE /* 该数据库未存在时 */ database_name;
    /*创建库并设置其字符集编码为UTF-8 */
    CREATE DATABASE database_name CHARACTER SET UTF8;
    /* 创建数据库并设置数据集排序规则为区分大小写 */
    CREATE DATABASE database_name COLLATE utf8_bin;

/* 查看已有库 */
SHOW DATABASES;



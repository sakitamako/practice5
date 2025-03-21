/*クライアントがSQLステートメントをサーバーに送信するために使用する文字セット*/
set names utf8;
/*MySQLで外部キー制約を適用しているテーブルにはDROP TABLEができない
 * 一時的に外部キー制約を無効にすることができる*/
set foreign_key_checks = 0;
/*DROP TABLE IF EXISTS でテーブルが存在すれば削除する*/
drop database if exists regist5;
/*もし存在しなければデータベースecsiteを作成*/
create database if not exists regist5;
use regist5;

/*DROP TABLE IF EXISTS でテーブルが存在すれば削除する*/
drop table if exists login_user_transaction;

create table login_user_transaction(
id int(100) not null primary key auto_increment,
family_name varchar(100),
last_name varchar(100),
family_name_kana varchar(100),
last_name_kana varchar(100),
mail varchar(255),
password varchar(255),
password_length int,  -- 追加：パスワードの長さを保存するカラム
gender int(1),
postal_code int(7)ZEROFILL,
prefecture varchar(100),
address_1 varchar(100),
address_2 varchar(255),
authority int(1),
delete_flag int(1) DEFAULT 0,
registered_time datetime DEFAULT CURRENT_TIMESTAMP,
update_time datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP);

INSERT INTO login_user_transaction(
family_name, last_name, family_name_kana,
last_name_kana, mail, password, password_length, gender, postal_code,
prefecture, address_1, address_2, authority)
VALUES("鈴木", "紗季", "スズキ", "サキ", "a@gmail.com",
"0910", LENGTH("0910"), 1, 0001111, "東京都", "新宿区", "1-1-1", 1);
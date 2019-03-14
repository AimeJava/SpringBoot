CREATE DATABASE IF NOT EXISTS `restaurant`;
USE `restaurant`;

CREATE TABLE IF NOT EXISTS `address` (
  `address_id`   int(11) NOT NULL AUTO_INCREMENT, -- id
  `address_info` varchar(100)     DEFAULT NULL, -- 地址信息
  `user_id`      int(11)          DEFAULT NULL, -- 用户id
  PRIMARY KEY (`address_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8; -- 地址
CREATE TABLE IF NOT EXISTS `admin` (
  `admin_id`       int(11) NOT NULL AUTO_INCREMENT, -- id
  `admin_name`     varchar(50)      DEFAULT NULL, -- 管理员姓名
  `admin_pwd`      varchar(50)      DEFAULT NULL, -- 管理员密码
  `admin_create`   datetime         DEFAULT NULL, -- 管理员创建时间
  `admin_modified` datetime         DEFAULT NULL, -- 管理员修改时间
  PRIMARY KEY (`admin_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8; -- 管理员
CREATE TABLE IF NOT EXISTS `menu_info` (
  `menu_id`        int(11) NOT NULL AUTO_INCREMENT,
  `menu_name`      varchar(50)      DEFAULT NULL, -- 菜名
  `type_id`        int(11)          DEFAULT NULL, -- 类别
  `menu_price`     decimal(10, 0)   DEFAULT NULL, -- 菜价格
  `menu_image`     varchar(100)     DEFAULT NULL, -- 菜图片
  `menu_buys`      int(11)          DEFAULT NULL, -- 总销售数量
  `menu_remark`    varchar(400)     DEFAULT NULL, -- 菜详情
  `menu_discounts` int(11)          DEFAULT NULL, -- 折扣/优惠 商家是否打折
  `menu_create`    datetime         DEFAULT NULL, -- 创建时间
  `menu_modified`  datetime         DEFAULT NULL, -- 修改时间
  PRIMARY KEY (`menu_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8; -- 菜单
CREATE TABLE IF NOT EXISTS `message` (
  `msg_id`       int(11)       DEFAULT NULL, -- 评论id
  `menu_id`      int(11)       DEFAULT NULL, -- 菜单id
  `msg_rating`   int(11)       DEFAULT NULL, -- 等级
  `user_id`      int(11)       DEFAULT NULL, -- 用户id
  `msg`          varchar(1000) DEFAULT NULL, -- 评论内容
  `msg_time`     datetime      DEFAULT NULL, -- 创建时间
  `msg_modified` datetime NOT NULL -- 修改时间-
)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8; -- 菜单评论
CREATE TABLE IF NOT EXISTS `order_info` (
  `order_id`        int(11)     NOT NULL AUTO_INCREMENT, -- 订单id
  `order_number`    varchar(12)          DEFAULT NULL, -- 订单号码
  `order_state`     varchar(8)  NOT NULL, -- 订单处理状态
  `order_time`      datetime             DEFAULT NULL, -- 订单生成时间
  `order_pay_state` varchar(20)          DEFAULT NULL, -- 订单支付状态
  `order_income`    decimal              DEFAULT NULL, -- 收入金额
  `order_remark`    varchar(20)          DEFAULT NULL, -- 订单留言
  `user_id`         int(11)              DEFAULT NULL, -- 用户id
  `address_id`      varchar(50) NOT NULL, -- 送餐地址id
  `order_create`    datetime    NOT NULL, -- 创建时间
  `order_modified`  datetime    NOT NULL, -- 修改时间
  PRIMARY KEY (`order_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1000
  DEFAULT CHARSET = utf8; -- 订单详情
CREATE TABLE IF NOT EXISTS `order_detail` (
  `order_id`       int(11) DEFAULT NULL, -- 订单id
  `menu_id`        int(11) DEFAULT NULL, -- 菜 id
  `menu_counts`    int(11)  NOT NULL, -- 数量
  `order_create`   datetime NOT NULL, -- 创建时间
  `order_modified` datetime NOT NULL -- 修改时间

)
  ENGINE = InnoDB
  DEFAULT CHARSET = utf8; -- 订单细节

CREATE TABLE IF NOT EXISTS `types` (
  `type_id`       int(11)  NOT NULL AUTO_INCREMENT, -- 类型 id
  `type_name`     varchar(20)       DEFAULT NULL, -- 类型 名称
  `type_create`   datetime NOT NULL, -- 创建时间
  `type_modified` datetime NOT NULL, -- 修改时间
  PRIMARY KEY (`type_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8; -- 类型
CREATE TABLE IF NOT EXISTS `user_info` (
  `user_id`       int(11) NOT NULL AUTO_INCREMENT, -- 用户id
  `user_name`     varchar(20)      DEFAULT NULL, -- 用户名称
  `user_pwd`      varchar(50)      DEFAULT NULL, -- 用户密码
  user_photos     varchar(20), -- 用户照片
  `address_id`    int(11)          DEFAULT NULL, -- 地址id
  `user_tel`      varchar(20)      DEFAULT NULL, -- 用户号码
  `user_create`   datetime         DEFAULT NULL, -- 创建时间
  `user_modified` datetime         DEFAULT NULL, -- 更改时间
  `discount_id`   int(11)          DEFAULT NULL, -- 折扣id
  PRIMARY KEY (`user_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8; -- 用户

CREATE TABLE cart (
  --  cart_id     int auto_increment primary key, -- 购物车id 可考虑不需要
  user_id       int, -- 用户id
  menu_id       int, -- 菜id
  menu_number   int, -- 菜数量
  menu_subtotal int default 0 -- 小计  可考虑不需要
); -- 购物车  注：当用户下单或移除购物车商品时再清理

CREATE TABLE IF NOT EXISTS `discount` (
  `discount_id`    int(11) NOT NULL AUTO_INCREMENT,
  `discount_name`  varchar(20)      DEFAULT NULL, -- 优惠劵名
  `discount_price` decimal(10, 0)   DEFAULT NULL, -- 优惠劵价格
  `user_id`        int(11)          DEFAULT NULL, -- 用户id
  PRIMARY KEY (`discount_id`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8; -- 优惠劵  第二版再考虑

-- 数据
insert into cart (user_id, menu_id, menu_number)
values (1, 23, 1),
       (2, 5, 1),
       (1, 18, 2),
       (3, 85, 2),
       (1, 2, 1); -- 购物车数据

INSERT INTO `admin` (`admin_id`, `admin_name`, `admin_pwd`, `admin_create`, `admin_modified`)
VALUES (1, 'admin', 'admin', now(), now()),
       (5, 'tina', '123456', now(), now()); -- 管理员数据

INSERT INTO `types` (`type_name`, `type_create`, `type_modified`)
VALUES ('家常菜', '2018-12-23 00:00:00', '2018-12-01 00:00:00'),
       ('私家菜', '2018-12-23 00:00:00', '2018-12-01 00:00:00'),
       ('凉菜', '2018-12-23 00:00:00', '2018-12-01 00:00:00'),
       ('海鲜', '2018-12-23 00:00:00', '2018-12-01 00:00:00'),
       ('汤粥', '2018-12-23 00:00:00', '2018-12-01 00:00:00'),
       ('素食', '2018-12-23 00:00:00', '2018-12-01 00:00:00'),
       ('甜品点心', '2018-12-23 00:00:00', '2018-12-01 00:00:00'),
       ('糕点主食', '2018-12-23 00:00:00', '2018-12-01 00:00:00'),
       ('配酱小吃', '2018-12-23 00:00:00', '2018-12-01 00:00:00'),
       ('时尚饮品', '2018-12-23 00:00:00', '2018-12-01 00:00:00'); -- 类型数据

INSERT INTO `user_info` (`user_name`,
                         `user_pwd`,
                         `address_id`,
                         `user_tel`,
                         `user_create`,
                         `user_modified`,
                         `discount_id`)
VALUES ('张三', '123456', 1, '13059349680', '2018-12-01 00:00:00', '2018-12-01 00:00:00', NULL),
       ('李四', '123456', 2, '12389052983', '2018-12-01 00:00:00', '2018-12-01 00:00:00', NULL),
       ('tina', '123456', 2, '12389052983', '2018-12-01 00:00:00', '2018-12-01 00:00:00', NULL); -- 用户数据

INSERT INTO `discount` (`discount_id`, `discount_name`, `discount_price`, `user_id`)
VALUES (1, '热炒折扣卷', 4, 1),
       (2, '汤类折扣卷', 3, 1),
       (3, '面食折扣卷', 1, 2),
       (4, '热炒折扣卷', 4, 1),
       (5, '通用卷', 1, 1); -- 优惠卷数据

insert into order_info
values (1001, '201902211001', '未接单', now(), '微信支付',10,'少肉多汁，多菜少肉', 1, 1, now(), now()),
       (1002, '201902211002', '未接单', now(), '支付宝支付',15, '变态辣', 2, 2, now(), now()),
       (1003, '201902211003', '为接单', now(), '微信',12, '多放点青菜', 3, 3, now(), now()); -- 订单数据

insert into order_detail
values (1001, 15, 1, now(), now()),
       (1002, 12, 1, now(), now()),
       (1003, 33, 1, now(), now()),
       (1002, 52, 1, now(), now()),
       (1001, 4, 1, now(), now()); -- 订单详情数据
INSERT INTO `menu_info` (menu_name, type_id, menu_price, menu_image)
values ('海胆蒸蛋', 1, 19, '1002.jpg'),
       ('酱爆茄子', 1, 15, '1003.jpg'),
       ('酱茄子', 1, 12, '1004.jpg'),
       ('风味茄子', 1, 13, '1005.jpg'),
       ('酱排骨', 1, 20, '1006.jpg'),
       ('红烧冬瓜', 1, 9, '1007.jpg'),
       ('干锅茶树菇', 1, 12, '1008.jpg'),
       ('爆炒田鸡', 1, 18, '1009.jpg'),
       ('减肥沙拉', 1, 10, '1010.jpg'); -- 家常菜数据
INSERT INTO `menu_info` (menu_name, type_id, menu_price, menu_image)
values ('夏威夷果炒西芹', 2, 12, '2001.jpg'),
       ('口蘑酿肉', 2, 19, '2002.jpg'),
       ('芝士蒜香红虾', 2, 15, '2003.jpg'),
       ('铁板鱿鱼', 2, 12, '2004.jpg'),
       ('秘制卤牛腱子肉', 2, 13, '2005.jpg'),
       ('荷叶叫花鸡', 2, 20, '2006.jpg'),
       ('八宝辣酱', 2, 9, '2007.jpg'),
       ('炝拌油麦菜', 2, 12, '2008.jpg'),
       ('乌梅核桃酱鸡翅', 2, 18, '2009.jpg'),
       ('金针菇培根卷', 2, 10, '2010.jpg'); -- 私房菜数据
INSERT INTO `menu_info` (menu_name, type_id, menu_price, menu_image)
values ('泡椒凤爪', 3, 15, '3001.jpg'),
       ('凉拌木耳', 3, 10, '3002.jpg'),
       ('凉拌藕片', 3, 22, '3003.jpg'),
       ('蔬菜沙拉', 3, 17, '3004.jpg'),
       ('糖醋蒜', 3, 20, '3005.jpg'),
       ('猪皮冻', 3, 15, '3006.jpg'),
       ('凉拌海带丝', 3, 18, '3007.jpg'),
       ('自制牛肉干', 3, 13, '3008.jpg'),
       ('腌萝卜', 3, 13, '3009.jpg'),
       ('凉拌黄瓜', 3, 12, '3010.jpg'); -- 凉菜数据
INSERT INTO `menu_info` (menu_name, type_id, menu_price, menu_image)
values ('蒜蓉蒸鲍鱼', 4, 10, '4001.jpg'),
       ('辣炒扇贝肉', 4, 22, '4002.jpg'),
       ('孜然鱿鱼', 4, 17, '4003.jpg'),
       ('滑蛋虾仁', 4, 20, '4004.jpg'),
       ('辣炒花蛤', 4, 15, '4005.jpg'),
       ('香辣小龙虾', 4, 18, '4006.jpg'),
       ('蒜蓉粉丝蒸扇贝', 4, 13, '4007.jpg'),
       ('西兰花炒虾仁', 4, 13, '4008.jpg'),
       ('白灼虾', 4, 12, '4009.jpg'),
       ('清蒸大闸蟹', 4, 15, '4010.jpg'),
       ('葱烧海参', 4, 10, '4011.jpg'); -- 海鲜数据
INSERT INTO `menu_info` (menu_name, type_id, menu_price, menu_image)
values ('四物汤', 5, 17, '5001.jpg'),
       ('冬瓜丸子汤', 5, 20, '5002.jpg'),
       ('鲍鱼粥', 5, 15, '5003.jpg'),
       ('八宝粥', 5, 18, '5004.jpg'),
       ('冰糖银耳汤', 5, 13, '5005.jpg'),
       ('南瓜粥', 5, 13, '5006.jpg'),
       ('香菇乌鸡汤', 5, 12, '5007.jpg'),
       ('罗宋汤', 5, 15, '5008.jpg'),
       ('小米南瓜粥', 5, 10, '5009.jpg'),
       ('心灵鸡汤', 5, 22, '5010.jpg'),
       ('鸽子汤', 5, 17, '5011.jpg'); -- 汤粥数据
INSERT INTO `menu_info` (menu_name, type_id, menu_price, menu_image)
values ('香菇油菜', 6, 10, '6001.jpg'),
       ('醋溜土豆丝', 6, 22, '6002.jpg'),
       ('蒜蓉西兰花', 6, 17, '6003.jpg'),
       ('什锦豆腐煲', 6, 20, '6004.jpg'),
       ('地三鲜', 6, 15, '6005.jpg'),
       ('手撕包菜', 6, 18, '6006.jpg'),
       ('蜂蜜烤板栗', 6, 13, '6007.jpg'),
       ('爆浆烤红薯', 6, 13, '6008.jpg'),
       ('砂锅烤红薯', 6, 12, '6009.jpg'),
       ('白玉萝卜片', 6, 15, '6010.jpg'); -- 素食数据
INSERT INTO `menu_info` (menu_name, type_id, menu_price, menu_image)
values ('南瓜饼', 7, 15, '7001.jpg'),
       ('绿豆糕', 7, 18, '7002.jpg'),
       ('煎饼果子', 7, 13, '7003.jpg'),
       ('双皮奶', 7, 13, '7004.jpg'),
       ('芝士蛋糕', 7, 12, '7005.jpg'),
       ('冰粉粉', 7, 15, '7006.jpg'),
       ('牛奶布丁', 7, 10, '7007.jpg'),
       ('椰子油火龙果果酱土司', 7, 22, '7008.jpg'),
       ('白富美脏脏包', 7, 17, '7009.jpg'),
       ('松软版脏脏包', 7, 20, '7010.jpg'),
       ('椰浆南瓜沙冰', 7, 15, '7011.jpg'),
       ('百利蜜桃西瓜冰', 7, 18, '7012.jpg'),
       ('李子果酱', 7, 13, '7013.jpg'),
       ('牛油果拌薯茸', 7, 13, '7014.jpg'),
       ('杂果榴莲冰', 7, 12, '7015.jpg'),
       ('清凉绿豆糕', 7, 15, '7016.jpg'); -- 甜品点心数据
INSERT INTO `menu_info` (menu_name, type_id, menu_price, menu_image)
values ('炸油条', 8, 22, '8001.jpg'),
       ('金银元宝水饺', 8, 17, '8002.jpg'),
       ('韭菜鲜肉水饺', 8, 20, '8003.jpg'),
       ('香葱烟肉小饼', 8, 15, '8004.jpg'),
       ('土豆鸡蛋饼', 8, 18, '8005.jpg'),
       ('萝卜丝饼', 8, 13, '8006.jpg'),
       ('糯米紫薯糕', 8, 13, '8007.jpg'),
       ('生煎小笼包', 8, 12, '8008.jpg'),
       ('多彩蛋卷', 8, 15, '8009.jpg'),
       ('美味荷叶饼', 8, 10, '8010.jpg'),
       ('葱香肉饼', 8, 22, '8011.jpg'),
       ('椰浆糯米团', 8, 17, '8012.jpg'),
       ('山西刀削面', 8, 20, '8013.jpg'); -- 糕点主食数据
INSERT INTO `menu_info` (menu_name, type_id, menu_price, menu_image)
values ('香菇肉酱', 9, 18, '9001.jpg'),
       ('酸黄瓜', 9, 13, '9002.jpg'),
       ('酱肉', 9, 13, '9003.jpg'),
       ('卤水猪蹄', 9, 12, '9004.jpg'),
       ('肉末花生米香菇酱', 9, 15, '9005.jpg'),
       ('五香鹌鹑蛋', 9, 10, '9006.jpg'),
       ('香辣卤肉', 9, 22, '9007.jpg'),
       ('周黑鸭风味之鸭掌', 9, 17, '9008.jpg'),
       ('五香茶叶蛋', 9, 20, '9009.jpg'),
       ('卤牛肉', 9, 15, '9010.jpg'); -- 配酱小吃数据
INSERT INTO `menu_info` (menu_name, type_id, menu_price, menu_image)
values ('蓝莓酒', 10, 15, '10001.jpg'),
       ('山楂红糖水', 10, 18, '10002.jpg'),
       ('冰糖银耳西瓜盅', 10, 13, '10003.jpg'),
       ('米酒', 10, 13, '10004.jpg'),
       ('杨枝甘露', 10, 12, '10005.jpg'),
       ('玫瑰花茶', 10, 15, '10006.jpg'),
       ('姜撞奶', 10, 10, '10007.jpg'),
       ('桂花酒', 10, 22, '10008.jpg'),
       ('生姜红糖水', 10, 17, '10009.jpg'),
       ('酸梅汤', 10, 20, '10010.jpg'); -- 时尚饮品数据


select *
from user_info;

select *
from menu_info
limit 0,10;

select menu_id,
       menu_name,
       m.type_id,
       type_name,
       menu_price,
       menu_image,
       menu_remark,
       menu_discounts,
       menu_create,
       menu_modified
from menu_info m
       left join types t on m.type_id = t.type_id
limit 0,8;


select type_id, type_name, type_create, type_modified
from types
limit 1,10;


select COUNT(*)
from menu_info;
select menu_id,
       menu_name,
       type_id,
       menu_price,
       menu_image,
       menu_buys,
       menu_remark,
       menu_discounts,
       menu_create,
       menu_modified
from menu_info
where menu_id = 1;
select *
from menu_info
where type_id = 1;
select count(*)
from menu_info
where menu_name like '%酱%';
-- 查询用户语句
select *
from user_info;
select *
from user_info
where user_name = 'admin'
  and user_pwd = '1234';

-- 查询订单语句
select *
from order_info;

select i.order_id,
       i.order_number,
       i.order_time,
       i.order_state,
       i.order_pay_state,
       m.menu_name,
       d.menu_counts,
       i.order_remark,
       a.address_info,
       u.user_name,
       u.user_tel
from order_info i
       left join order_detail d on i.order_id = d.order_id
       left join menu_info m on d.menu_id = m.menu_id
       left join user_info u on i.user_id = u.user_id
       left join address a on i.address_id = a.address_id
where order_state = '未接单';

select *
from order_detail d
       left join menu_info m on d.menu_id = m.menu_id;

-- 查询管理员的
select *
from Admin
where admin_name = 'admin'
  and admin_pwd = 'admin';

select *
from cart;
select m.menu_name, m.menu_image, m.menu_price, c.menu_number
from cart c
       left join user_info u on c.user_id = u.user_id
       left join menu_info m on c.menu_id = m.menu_id
where u.user_id = 1
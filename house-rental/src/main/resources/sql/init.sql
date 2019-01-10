/*前置语句*/
create database house_rental;
use house_rental;

/*建表语句*/
create table user
(
  user_id     varchar(42) not null
    primary key,
  user_name   varchar(32) not null,
  password    varchar(32) not null,
  create_time datetime    not null,
  update_time datetime    not null
);



create table rental_info
(
  rental_info_id         varchar(42)  not null
  comment '主键'
  primary key,
   house_name             varchar(255)  not null
  comment '小区名称',
  house_location             varchar(255)  not null
  comment '详细地址',
  bedroom_num            int          not null
  comment '室数目',
  living_room_num        int          not null
  comment '厅数目',
  bathroom_num           int          not null
  comment '卫数目',
  house_type             varchar(32)  not null
  comment '户型',
  house_area             varchar(32)  not null
  comment '面积',
  elevator               varchar(32)   not null
  comment '电梯0没有1有',
  house_rent             double       not null
  comment '租金',
  payment_method         varchar(42)  not null
  comment '付款方式',
  house_floor            int          not null
  comment '当前楼层数',
  floor_num              int          not null
  comment '总楼层数',
  parking_space          varchar(32)   not null
  comment '车位',
  house_desc             varchar(255) not null
  comment '房源描述',
  house_imgs             varchar(255) not null
  comment '图片',
  house_contact_name     varchar(32)  not null
  comment '联系人姓名',
  house_contact_identity varchar(32)   not null
  comment '联系人身份',
  house_contact_phone    varchar(11)  not null
  comment '联系人手机',
  rental_info_user_id    varchar(42)  not null
  comment '发布人主键',
  create_time            datetime     not null,
  update_time            datetime     not null
);


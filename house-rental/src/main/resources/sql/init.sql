create database house_rental;

create table user
(
  user_id     varchar(32) not null
    primary key,
  user_name   varchar(32) not null,
  password    varchar(32) not null,
  create_time datetime    not null,
  update_time datetime    not null
);


create table rental_info
(
  rental_info_id         varchar(32)  not null
  comment '主键'
    primary key,
  bedroom_num            int          not null
  comment '室数目',
  living_room_num        int          not null
  comment '厅数目',
  bathroom_num           int          not null
  comment '卫数目',
  house_type             varchar(32)  not null
  comment '户型',
  house_floor            int          not null
  comment '当前楼层数',
  floor_num              int          not null
  comment '总楼层数',
  parking_space          varchar(1)   not null
  comment '0没有1有',
  house_desc             varchar(255) not null
  comment '房源描述',
  house_imgs             varchar(255) not null
  comment '图片',
  house_contact_name     varchar(32)  not null
  comment '联系人姓名',
  house_contact_identity varchar(1)   not null
  comment '联系人身份',
  house_contact_phone    varchar(11)  not null
  comment '联系人手机',
  rental_info_user_id    varchar(32)  not null
  comment '发布人主键'
);


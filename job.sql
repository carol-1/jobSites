/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2022/1/19 14:28:17                           */
/*==============================================================*/


drop table if exists tb_article;

drop table if exists tb_certificate;

drop table if exists tb_channel;

drop table if exists tb_company;

drop table if exists tb_dict;

drop table if exists tb_experience;

drop table if exists tb_favor;

drop table if exists tb_intention;

drop table if exists tb_menu;

drop table if exists tb_post;

drop table if exists tb_profession;

drop table if exists tb_project;

drop table if exists tb_resume;

drop table if exists tb_send;

drop table if exists tb_student;

drop table if exists tb_train;

drop table if exists tb_type;

drop table if exists tb_user;

drop table if exists tb_user_menu;

/*==============================================================*/
/* Table: tb_article                                            */
/*==============================================================*/
create table tb_article
(
   id                   int(11) not null auto_increment,
   channel_id           int(11) not null,
   title                varchar(100),
   title_img            varchar(100),
   summary              varchar(200),
   author               varchar(100),
   url                  varchar(100),
   content              text,
   sort                 int(11),
   create_date          date,
   create_user          int(11),
   update_date          date,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_certificate                                        */
/*==============================================================*/
create table tb_certificate
(
   ID                   int not null auto_increment,
   name                 varchar(100),
   file                 varchar(100),
   obtain_date          date,
   resume_id            int,
   primary key (ID)
);

/*==============================================================*/
/* Table: tb_channel                                            */
/*==============================================================*/
create table tb_channel
(
   id                   int(11) not null auto_increment,
   name                 varchar(100),
   parent_id            int(11),
   channel_img          varchar(100),
   summary              varchar(200),
   single               char(1) comment 'Y单页|其他非单页',
   url                  varchar(100),
   content              text,
   sort                 int(11),
   create_date          date,
   create_user          int(11),
   deleted_flag         char(1) comment 'D删除',
   postion              int,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_company                                            */
/*==============================================================*/
create table tb_company
(
   id                   int not null auto_increment,
   name                 varchar(100),
   account              varchar(100),
   password             varchar(100),
   contact              varchar(100),
   telephone            varchar(100),
   email                varchar(100),
   addr                 varchar(200),
   url                  varchar(100),
   size                 varchar(100),
   type                 varchar(100),
   logo                 varchar(100),
   description          text,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_dict                                               */
/*==============================================================*/
create table tb_dict
(
   id                   int not null auto_increment,
   dict_key             varchar(100),
   dict_val             varchar(100),
   sort                 int,
   status               int comment '0正常1删除',
   type_id              int,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_experience                                         */
/*==============================================================*/
create table tb_experience
(
   id                   int not null,
   company              varchar(100),
   post                 varchar(100),
   salary               varchar(100),
   description          text,
   join_date            date,
   leave_date           date,
   resume_id            int,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_favor                                              */
/*==============================================================*/
create table tb_favor
(
   id                   int,
   company_id           int,
   post_id              int,
   student_id           int,
   favor_date           date
);

/*==============================================================*/
/* Table: tb_intention                                          */
/*==============================================================*/
create table tb_intention
(
   id                   int not null auto_increment,
   name                 varchar(100),
   salary               varchar(100),
   city                 varchar(100),
   type                 varchar(100),
   industry             varchar(100),
   resume_id            int,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_menu                                               */
/*==============================================================*/
create table tb_menu
(
   id                   int,
   name                 varchar(100),
   icon                 varchar(100),
   href                 varchar(100),
   perms                varchar(100),
   parent_id            int,
   type                 int comment '0管理员1企业2学生'
);

/*==============================================================*/
/* Table: tb_post                                               */
/*==============================================================*/
create table tb_post
(
   id                   int not null auto_increment,
   name                 varchar(100),
   education            varchar(100),
   salary               varchar(100),
   description          text,
   company_id           int,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_profession                                         */
/*==============================================================*/
create table tb_profession
(
   id                   int not null auto_increment,
   name                 varchar(100),
   parent_id            int,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_project                                            */
/*==============================================================*/
create table tb_project
(
   id                   int not null auto_increment,
   name                 varchar(100),
   description          text,
   start_date           date,
   end_date             date,
   resume_id            int,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_resume                                             */
/*==============================================================*/
create table tb_resume
(
   id                   int,
   name                 varchar(100),
   job_status           varchar(100),
   evaluate             text,
   skill                text,
   student_id           int,
   status               int comment '0关闭|1开放'
);

/*==============================================================*/
/* Table: tb_send                                               */
/*==============================================================*/
create table tb_send
(
   id                   int,
   company_id           int,
   post_id              int,
   resume_id            int,
   send_date            date,
   status               int comment '0待查看|1已查看|2有意向|3不合适',
   student_id           int
);

/*==============================================================*/
/* Table: tb_student                                            */
/*==============================================================*/
create table tb_student
(
   ID                   char(10),
   name                 varchar(100),
   account              varchar(100),
   password             varchar(100),
   birthday             date,
   profession_id        int,
   college              varchar(100),
   education            varchar(100),
   phone                varchar(100),
   sex                  int,
   photo                varchar(100),
   graduate_date        date
);

/*==============================================================*/
/* Table: tb_train                                              */
/*==============================================================*/
create table tb_train
(
   id                   int not null,
   start_date           date,
   end_date             date,
   company              varchar(100),
   course               varchar(100),
   resume_id            int,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_type                                               */
/*==============================================================*/
create table tb_type
(
   id                   int not null auto_increment,
   name                 varchar(100),
   primary key (id)
);

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
   id                   int not null auto_increment,
   user_name            varchar(100),
   name                 varchar(100),
   password             varchar(100),
   login_time           date,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_user_menu                                          */
/*==============================================================*/
create table tb_user_menu
(
   user_id              int not null,
   menu_id              int not null,
   primary key (user_id, menu_id)
);


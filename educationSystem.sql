
/*==============================================================*/
/* Table: user                                               */
/*==============================================================*/
create table user
(
   u_id                 int                            not null,
   u_number             varchar(30),
   u_role               int,
   u_pwd                varchar(30),
   u_status             int,
   constraint PK_USER primary key clustered (u_id)
);


/*==============================================================*/
/* Table: major                                                 */
/*==============================================================*/
create table major 
(
   ma_id                int                            not null,
   ma_name              varchar(30),
   constraint PK_MAJOR primary key clustered (ma_id)
);


/*==============================================================*/
/* Table: teacher                                               */
/*==============================================================*/
create table teacher 
(
   te_id                int                            not null,
   ma_id                int,
   te_num               varchar(30),
   te_name              varchar(30),
   te_salary            double,
   te_phone             varchar(30),
   te_behave            int,
   constraint PK_TEACHER primary key clustered (te_id)
);

alter table teacher
   add constraint FK_TEACHER_REFERENCE_MAJOR foreign key (ma_id)
      references major (ma_id)
      on update restrict
      on delete restrict;

	  
/*==============================================================*/
/* Table: sclass                                                */
/*==============================================================*/
create table sclass 
(
   cl_id                int                            not null,
   ma_id                int,
   te_id                int,
   cl_name              varchar(30),
   cl_count             int,
   constraint PK_SCLASS primary key clustered (cl_id)
);

alter table sclass
   add constraint FK_SCLASS_REFERENCE_MAJOR foreign key (ma_id)
      references major (ma_id)
      on update restrict
      on delete restrict;

alter table sclass
   add constraint FK_SCLASS_REFERENCE_TEACHER foreign key (te_id)
      references teacher (te_id)
      on update restrict
      on delete restrict;


/*==============================================================*/
/* Table: room                                                  */
/*==============================================================*/
create table room 
(
   ro_id                int                            not null,
   ro_name              varchar(30),
   constraint PK_ROOM primary key clustered (ro_id)
);
	  
	  


/*==============================================================*/
/* Table: student                                               */
/*==============================================================*/
create table student 
(
   st_id                int                            not null,
   cl_id                int,
   st_num               varchar(30),
   st_name              varchar(30),
   st_behave            varchar(30),
   constraint PK_STUDENT primary key clustered (st_id)
);

alter table student
   add constraint FK_STUDENT_REFERENCE_SCLASS foreign key (cl_id)
      references sclass (cl_id)
      on update restrict
      on delete restrict;
	 	  

/*==============================================================*/
/* Table: course                                                */
/*==============================================================*/
create table course 
(
   co_name              varchar(30),
   co_score             double,
   co_status            varchar(30),
   co_week              varchar(30),
   co_starttime         date,
   co_endtime           date,
   co_id                int                            not null,
   ma_id                int,
   constraint PK_COURSE primary key clustered (co_id)
);

alter table course
   add constraint FK_COURSE_REFERENCE_MAJOR foreign key (ma_id)
      references major (ma_id)
      on update restrict
      on delete restrict;

		  
		  
/*==============================================================*/
/* Table: en_course                                             */
/*==============================================================*/
create table en_course 
(
   en_id                int                            not null,
   te_id                int,
   co_id                int,
   cl_id                int,
   ro_id                int,
   en_day               varchar(30),
   en_start             varchar(30),
   en_end               varchar(30),
   constraint PK_EN_COURSE primary key clustered (en_id)
);

alter table en_course
   add constraint FK_EN_COURS_REFERENCE_ROOM foreign key (ro_id)
      references room (ro_id)
      on update restrict
      on delete restrict;

alter table en_course
   add constraint FK_EN_COURS_REFERENCE_TEACHER foreign key (te_id)
      references teacher (te_id)
      on update restrict
      on delete restrict;

alter table en_course
   add constraint FK_EN_COURS_REFERENCE_COURSE foreign key (co_id)
      references course (co_id)
      on update restrict
      on delete restrict;

alter table en_course
   add constraint FK_EN_COURS_REFERENCE_SCLASS foreign key (cl_id)
      references sclass (cl_id)
      on update restrict
      on delete restrict;


		  

/*==============================================================*/
/* Table: excourse                                              */
/*==============================================================*/
create table excourse 
(
   ex_id                int                            not null,
   cl_id                int,
   te_id                int,
   ex_name              varchar(30),
   ex_count             int,
   ex_week              varchar(30),
   ex_day               varchar(30),
   ex_start             datetime,
   ex_end               datetime,
   ex_score             int,
   constraint PK_EXCOURSE primary key clustered (ex_id)
);

alter table excourse
   add constraint FK_EXCOURSE_REFERENCE_SCLASS foreign key (cl_id)
      references sclass (cl_id)
      on update restrict
      on delete restrict;

alter table excourse
   add constraint FK_EXCOURSE_REFERENCE_TEACHER foreign key (te_id)
      references teacher (te_id)
      on update restrict
      on delete restrict;


/*==============================================================*/
/* Table: co_te_ev                                              */
/*==============================================================*/
create table co_te_ev 
(
   id                   int                            not null,
   en_id                int,
   te_id                int,
   answer1              int,
   answer2              int,
   answer3              int,
   answer4              int,
   answer5              int,
   st_num               varchar(30),
   constraint PK_CO_TE_EV primary key clustered (id)
);

alter table co_te_ev
   add constraint FK_CO_TE_EV_REFERENCE_EN_COURS foreign key (en_id)
      references en_course (en_id)
      on update restrict
      on delete restrict;

alter table co_te_ev
   add constraint FK_CO_TE_EV_REFERENCE_TEACHER foreign key (te_id)
      references teacher (te_id)
      on update restrict
      on delete restrict;



/*==============================================================*/
/* Table: ex_st                                                 */
/*==============================================================*/
create table ex_st 
(
   st_id                int,
   ex_id                int
);

alter table ex_st
   add constraint FK_EX_ST_REFERENCE_STUDENT foreign key (st_id)
      references student (st_id)
      on update restrict
      on delete restrict;

alter table ex_st
   add constraint FK_EX_ST_REFERENCE_EXCOURSE foreign key (ex_id)
      references excourse (ex_id)
      on update restrict
      on delete restrict;



/*==============================================================*/
/* Table: sroll                                                 */
/*==============================================================*/
create table sroll 
(
   sr_id                int                            not null,
   sr_num               varchar(30),
   sr_name              varchar(30),
   sr_sex               varchar(30),
   sr_address           varchar(100),
   sr_img               varchar(300),
   sr_time              date,
   sr_birthday          date,
   sr_idCard            varchar(100),
   sr_isRoll            varchar(10),
   constraint PK_SROLL primary key clustered (sr_id)
);


	  

/*==============================================================*/
/* Table: grade                                                 */
/*==============================================================*/
create table grade 
(
   gr_id                int                            not null,
   st_num               varchar(30),
   co_name              varchar(30),
   score                double,
   constraint PK_GRADE primary key clustered (gr_id)
);




/*==============================================================*/
/* Table: question                                              */
/*==============================================================*/
create table question 
(
   q_id                 int                            not null,
   q_content            varchar(30),
   q_a                  varchar(30),
   q_b                  varchar(30),
   q_c                  varchar(30),
   q_d                  varchar(30),
   constraint PK_QUESTION primary key clustered (q_id)
);








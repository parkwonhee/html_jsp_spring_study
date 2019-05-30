create table b_user(
  u_id varchar2(20) primary key,
  u_password varchar2(20) not null,
  u_name varchar(10) not null,
  u_email varchar2(30),
  u_birth varchar2(10)
)
commit;
drop schema if exists employee_reimbursement cascade;
create schema employee_reimbursement;
set schema   'employee_reimbursement';

create table ers_reimbursement_status(
reimb_status_id serial primary key,
reimb_status text
);

insert into employee_reimbursement.ers_reimbursement_status(reimb_status) values ('pending');
insert into ers_reimbursement_status (reimb_status) values ('denied');
insert into ers_reimbursement_status (reimb_status) values ('approved');



create table ers_reimbursement_type(
reimb_type_id serial primary key,
reim_type text
);

insert into ers_reimbursement_type (reim_type) values ('LODGING');
insert into ers_reimbursement_type (reim_type) values ('TRAVEL');
insert into ers_reimbursement_type (reim_type) values ('FOOD');
insert into ers_reimbursement_type (reim_type) values ('OTHER');


select * from ers_reimbursement_type ert;

create table ers_user_roles(
user_role_id serial primary key,
user_role text
);

insert into ers_user_roles(user_role) values ('employee');
insert into ers_user_roles(user_role) values ('financial_manager');

select * from ers_user_roles;

create table ers_users(
ers_users_id serial primary key,
ers_username text unique,
ers_password text,
user_first_name text,
user_last_name text,
user_email text unique,
user_role_id  int references ers_user_roles(user_role_id)
);


insert into ers_users (ers_username, ers_password,user_first_name,user_last_name,user_email,user_role_id) values ('aharris','12345','Ariela','Harris','aharris0@mit.edu',1);
insert into ers_users (ers_username, ers_password,user_first_name,user_last_name,user_email,user_role_id) values ('cmillet','22222','Cash','Millett','cmillett1@domainmarket.com',1);
insert into ers_users (ers_username, ers_password,user_first_name,user_last_name,user_email,user_role_id) values ('jbowdery','33333','Joanie','Bowdery','jbowdery2@mozilla.com',1);
insert into ers_users (ers_username, ers_password,user_first_name,user_last_name,user_email,user_role_id) values ('beccleston','44444','Benedikta','Eccleston','beclesston3@newyorker.com',2);
insert into ers_users (ers_username, ers_password,user_first_name,user_last_name,user_email,user_role_id) values ('bolivie','55555','Benjamine','Olivie','bolivie4@mit.edu',2);
insert into ers_users (ers_username, ers_password,user_first_name,user_last_name,user_email,user_role_id) values ('adudenie','66666','Alisander','Dudenie','adudenie5@icio.us',1);

select * from ers_users;

create table ers_reimbursement(
reimb_id serial primary key,
reimb_amount numeric(10,2),
reimb_submitted timestamp,
reimb_resolved timestamp,
reimb_description text,
reimb_receipt bytea,
reimb_author int references ers_users(ers_users_id),
reimb_resolver int references ers_users(ers_users_id),
reimb_status_id int references ers_reimbursement_status(reimb_status_id),
reimb_type_id int references ers_reimbursement_type(reimb_type_id)
);


--insert into ers_reimbursement (reimb_amount,reimb_submitted, reimb_resolved,reimb_description,reimb_receipt,reimb_author,reimb_resolver,reimb_status_id,reimb_type_id)
--values (79.99,'2020-12-01','2020-12-20','Drinks, snack during the trip',pg_escape_bytea('C:\Users\Krystyna\Documents\Revature\receipt\360px-ReceiptSwiss.jpg'),1,4,3);

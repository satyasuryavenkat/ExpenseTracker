create table expense(id int not null auto_increment,expensetype varchar(100),expenseitem varchar(100),expensemoney int,expensedate varchar(100), primary key(id));

create table expensetype(expensetype varchar(100));
                                             
insert into expensetype values("Food");
insert into expensetype values("Travel");
insert into expensetype values("Shopping");
insert into expensetype values("Rent");
insert into expensetype values("Bills");
insert into expensetype values("Medical");
insert into expensetype values("Groceries");                                             

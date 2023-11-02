create database shopdb;

use shopdb;

create table Category
(
    CategoryId   int auto_increment
        primary key,
    CategoryName varchar(50) not null
)
    charset = utf8;

create table Employee
(
    Employeeid int auto_increment
        primary key,
    EmpName    varchar(15)   not null,
    EmpPwd     varchar(15)   not null,
    Sex        char(2)       null,
    Age        int           null,
    HireLong   datetime      null,
    Salary     decimal(7, 2) null
)
    charset = utf8;

create table Offers
(
    OfferID   int auto_increment
        primary key,
    OfferName varchar(100) not null,
    LegalIP   varchar(25)  not null,
    Address   varchar(200) not null,
    Tel       varchar(50)  null
)
    charset = utf8;

create table Goods
(
    GoodId     int auto_increment
        primary key,
    GoodName   varchar(100)               not null,
    Price      decimal(7, 2) default 0.00 not null,
    CategoryId int                        not null,
    OfferID    int                        not null,
    Stockes    int                        null,
    constraint Goods_ibfk_1
        foreign key (CategoryId) references Category (CategoryId),
    constraint Goods_ibfk_2
        foreign key (OfferID) references Offers (OfferID)
)
    charset = utf8;

create index CategoryId
    on Goods (CategoryId);

create index OfferID
    on Goods (OfferID);

create table Sales
(
    SalesId    int auto_increment
        primary key,
    SellAmount int default 0 not null,
    GoodId     int           not null,
    EmployeeId int           not null,
    SellDate   datetime      not null,
    constraint Sales_ibfk_1
        foreign key (GoodId) references Goods (GoodId),
    constraint Sales_ibfk_2
        foreign key (EmployeeId) references Employee (Employeeid)
)
    charset = utf8;

create index EmployeeId
    on Sales (EmployeeId);

create index GoodId
    on Sales (GoodId);



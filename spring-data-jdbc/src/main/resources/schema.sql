
# simple entity
create table if not exists pet (
    id bigint unique auto_increment primary key,
    name varchar(30),
    birth_date date,
    pet_type varchar(30)
);

# one-to-one
create table if not exists movie (
    id bigint unique auto_increment primary key ,
    title varchar(50),
    description varchar(200)
);

create table if not exists rental (
    movie bigint primary key references movie(id),
    duration varchar(100),
    price integer
);

# three one-to-many
create table if not exists `shop_order` (
    id bigint unique  auto_increment primary key ,
    description varchar(200)
);
# only price and amount are reflected in entity
create table if not exists line_item (
    id bigint unique auto_increment primary key,
    `shop_order` bigint,
    price decimal(5,2),
    amount decimal(5,2),
    foreign key (`shop_order`) references `shop_order`(id)
);

create table if not exists shop_order_numbered (
    id bigint unique auto_increment primary key ,
    description varchar(200)
);

create table if not exists line_item_numbered (
    id bigint unique auto_increment primary key ,
    shop_order_numbered bigint,
    shop_order_numbered_key bigint,
    price decimal(5, 2),
    amount decimal(5, 2),
    foreign key (shop_order_numbered) references shop_order_numbered(id)
);

create table if not exists shop_order_keyed (
    id bigint unique auto_increment primary key ,
    description varchar(200)
);
create table if not exists line_item_keyed (
   id bigint unique auto_increment primary key ,
   shop_order_keyed bigint,
   shop_order_keyed_key varchar(100),
   price decimal(5, 2),
   amount decimal(5, 2),
   foreign key (shop_order_keyed) references shop_order_keyed(id)
);

# many to many

create table if not exists author (
    id bigint unique auto_increment primary key ,
    name varchar(100),
    birth_date date
);

create table if not exists book (
    id bigint unique auto_increment primary key ,
    title varchar(255),
    isbn varchar(255)
);

create table if not exists book_author (
    author bigint,
    book bigint,
    primary key (author, book),
    foreign key (author) references author(id),
    foreign key (book) references book(id)
);

# many to one

create table if not exists employee (
    id bigint unique auto_increment primary key ,
    name varchar(50),
    department bigint,
    foreign key (department) references department(id)
);

create table if not exists department (
    id bigint unique auto_increment primary key ,
    name varchar(50)
);
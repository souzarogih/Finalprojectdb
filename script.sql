create table Product (
                         id uuid not null,
                         created_at timestamp(6),
                         price numeric(38,2),
                         product_category varchar(255),
                         product_code bigint,
                         product_name varchar(255),
                         updated_at timestamp(6),
                         primary key (id))

create table Sale (
                      id uuid not null,
                      created_at timestamp(6),
                      delivery_date integer,
                      estimated_delivery_date integer,
                      installments integer,
                      payment_type varchar(255),
                      sale_date timestamp(6),
                      sales_value numeric(38,2),
                      product_id uuid,
                      user_id uuid,
                      primary key (id))

create table users (
                       id uuid not null,
                       cpf varchar(255),
                       created_at timestamp(6),
                       email varchar(255),
                       name varchar(255),
                       telefone varchar(255),
                       updated_at timestamp(6),
                       primary key (id))

alter table if exists Sale add constraint FKe2x41myjmpotnnm4o76atli7j foreign key (product_id) references Product
alter table if exists Sale add constraint FKedmsije2wjvs3dyahid4bmiui foreign key (user_id) references usersa
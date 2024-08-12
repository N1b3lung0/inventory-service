create EXTENSION if not exists "uuid-ossp";

create table inventories (
   id uuid not null,
   sku_code varchar(255),
   quantity int,
   primary key (id)
);
# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "users" ("id" VARCHAR NOT NULL,"name" VARCHAR NOT NULL,"iconUrl" VARCHAR NOT NULL,"updatedAt" TIMESTAMP NOT NULL);
alter table "users" add constraint "pk_id" primary key("id");

# --- !Downs

alter table "users" drop constraint "pk_id";
drop table "users";


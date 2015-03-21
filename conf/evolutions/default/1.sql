# --- Created by Slick DDL
# To stop Slick DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table "interactions" ("fromId" VARCHAR NOT NULL,"toId" VARCHAR NOT NULL,"count" INTEGER NOT NULL);
alter table "interactions" add constraint "pk_interactions" primary key("fromId","toId");
create table "users" ("id" VARCHAR NOT NULL,"name" VARCHAR NOT NULL,"iconUrl" VARCHAR NOT NULL,"updatedAt" TIMESTAMP NOT NULL);
alter table "users" add constraint "pk_users" primary key("id");

# --- !Downs

alter table "users" drop constraint "pk_users";
drop table "users";
alter table "interactions" drop constraint "pk_interactions";
drop table "interactions";


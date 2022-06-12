CREATE DATABASE student6;
create user oleksandr with password 'Secret';
grant all on database student6 to oleksandr;
CREATE TABLE "weather" (
	"id" serial PRIMARY KEY,
	"city" varchar,
	"date" varchar, 
	"temp" double precision, 
	"temp_min" double precision, 
	"temp_max" double precision, 
	"feels_like" double precision, 
	"description" varchar
	);

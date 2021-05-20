/*
 Navicat Premium Data Transfer

 Source Server         : new connection
 Source Server Type    : PostgreSQL
 Source Server Version : 120002
 Source Host           : 127.0.0.1:5432
 Source Catalog        : nashta-test
 Source Schema         : public

 Target Server Type    : PostgreSQL
 Target Server Version : 120002
 File Encoding         : 65001

 Date: 20/05/2021 11:35:58
*/


-- ----------------------------
-- Sequence structure for data_data_id_seq
-- ----------------------------
DROP SEQUENCE IF EXISTS "public"."data_data_id_seq";
CREATE SEQUENCE "public"."data_data_id_seq" 
INCREMENT 1
MINVALUE  1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

-- ----------------------------
-- Table structure for data
-- ----------------------------
DROP TABLE IF EXISTS "public"."data";
CREATE TABLE "public"."data" (
  "id" int8 NOT NULL DEFAULT nextval('data_data_id_seq'::regclass),
  "title" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "location" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "date" timestamp(6) NOT NULL,
  "note" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "image" varchar(255) COLLATE "pg_catalog"."default" NOT NULL,
  "participant" varchar(255) COLLATE "pg_catalog"."default" NOT NULL
)
;

-- ----------------------------
-- Records of data
-- ----------------------------

-- ----------------------------
-- Alter sequences owned by
-- ----------------------------
SELECT setval('"public"."data_data_id_seq"', 5, true);

-- ----------------------------
-- Primary Key structure for table data
-- ----------------------------
ALTER TABLE "public"."data" ADD CONSTRAINT "data_pkey" PRIMARY KEY ("id");

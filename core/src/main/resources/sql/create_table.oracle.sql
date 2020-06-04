
--------------------------------------------------------
--  DDL for Table BEST_MESSAGES
--------------------------------------------------------
drop TABLE "BEST_MESSAGES" ;

  CREATE TABLE "BEST_MESSAGES" 
   (	
    "ID" VARCHAR2(60 BYTE), 
	"TYPE" VARCHAR2(20 BYTE) DEFAULT 'CHAT', 
	"FROM_USER_ID" VARCHAR2(20 BYTE), 
	"NICK_NAME" VARCHAR2(20 BYTE), 
	"TO_USER_ID" VARCHAR2(20 BYTE), 
	"CONTENT" VARCHAR2(1000 BYTE), 
	"TIME" NUMBER(15,0),
	"STATUS" NUMBER(*,0) DEFAULT 0
   )  ;
 
--------------------------------------------------------
--  DDL for Index BEST_MESSAGES_INDEX1
--------------------------------------------------------

  CREATE INDEX "BEST_MESSAGES_INDEX1" ON "BEST_MESSAGES" ("TO_USER_ID" DESC, "TIME" DESC)  ;
--------------------------------------------------------
--  DDL for Index BEST_MESSAGES_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BEST_MESSAGES_PK" ON "BEST_MESSAGES" ("ID")   ;
--------------------------------------------------------
--  Constraints for Table BEST_MESSAGES
--------------------------------------------------------

  ALTER TABLE "BEST_MESSAGES" ADD CONSTRAINT "BEST_MESSAGES_PK" PRIMARY KEY ("ID") 

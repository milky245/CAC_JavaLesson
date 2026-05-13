INSERT INTO dept VALUES ('20','経理部','Redmond, WA 98052-7329 USA'); 
INSERT INTO dept VALUES ('21','水産食品開発部',NULL); 
INSERT INTO dept VALUES ('22','食品総合研究所',NULL); 

ROLLBACK;

INSERT INTO dept VALUES ('20','経理部','Redmond, WA 98052-7329 USA'); 

SAVEPOINT sp1; 

INSERT INTO dept VALUES ('21','水産食品開発部',NULL); 
INSERT INTO dept VALUES ('22','食品総合研究所',NULL); 

ROLLBACK TO sp1; 

COMMIT;
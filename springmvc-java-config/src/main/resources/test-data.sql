INSERT INTO user (USERNAME,PASSWORD,ENABLED) VALUES ('root','456123',TRUE);
INSERT INTO user (USERNAME,PASSWORD,ENABLED) VALUES ('admin','123456',TRUE);

INSERT INTO authorities (USERNAME,AUTHORITY) VALUES('admin','ROLE_ADMIN');
INSERT INTO authorities (USERNAME,AUTHORITY) VALUES('root','ROLE_USER');

INSERT INTO blog_post(CONTENT,DRAFT,PUBLISHDATE,TITLE,USER_ID) VALUES('Test Content',false,NOW(),'Test Title',1);
INSERT INTO blog_post(CONTENT,DRAFT,PUBLISHDATE,TITLE,USER_ID) VALUES('Test Contednt2',false,NOW(),'Test dTitle2',1);
INSERT INTO blog_post(CONTENT,DRAFT,PUBLISHDATE,TITLE,USER_ID) VALUES('Test Contednt2',false,NOW(),'Testd Title2',1);
INSERT INTO blog_post(CONTENT,DRAFT,PUBLISHDATE,TITLE,USER_ID) VALUES('Test Condtent2',false,NOW(),'Test dTitle2',1);


INSERT INTO USER (USERNAME,PASSWORD,ENABLED) VALUES ('root','456123',TRUE);
INSERT INTO USER (USERNAME,PASSWORD,ENABLED) VALUES ('admin','123456',TRUE);

INSERT INTO AUTHORITIES (USERNAME,AUTHORITY) VALUES('admin','ROLE_ADMIN');
INSERT INTO AUTHORITIES (USERNAME,AUTHORITY) VALUES('root','ROLE_USER');

INSERT INTO BLOG_POST(CONTENT,DRAFT,PUBLISHDATE,TITLE,USER_ID) VALUES('Test Content',false,NOW(),'Test Title',1);
INSERT INTO BLOG_POST(CONTENT,DRAFT,PUBLISHDATE,TITLE,USER_ID) VALUES('Test Content2',false,NOW(),'Test Title2',2);


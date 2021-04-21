DROP TABLE IF EXISTS prices;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS brands;

CREATE TABLE products(
                         ID INT AUTO_INCREMENT PRIMARY KEY,
                         NAME VARCHAR(255) NOT NULL
);



CREATE TABLE brands(
                       ID INT AUTO_INCREMENT PRIMARY KEY,
                       NAME VARCHAR(255) NOT NULL
);


CREATE TABLE prices(
                       ID INT AUTO_INCREMENT PRIMARY KEY,
                       BRAND_ID INT NOT NULL,
                       START_DATE TIMESTAMP WITH TIME ZONE NOT NULL,
                       END_DATE TIMESTAMP WITH TIME ZONE NOT NULL,
                       PRICE_LIST INT NOT NULL,
                       PRODUCT_ID INT NOT NULL,
                       PRIORITY INT NOT NULL,
                       PRICE DOUBLE NOT NULL,
                       CURR VARCHAR(5) NOT NULL,
                       FOREIGN KEY (BRAND_ID) REFERENCES brands(ID),
                       FOREIGN KEY (PRODUCT_ID) REFERENCES products(ID)
);


INSERT INTO products(ID, NAME) VALUES (35455, 'Example Product 1');

INSERT INTO brands(ID, NAME) VALUES (1, 'ZARA');

INSERT INTO prices(ID, BRAND_ID, START_DATE, END_DATE, PRICE_LIST, PRODUCT_ID, PRIORITY, PRICE, CURR) VALUES
(1, 1, PARSEDATETIME('2020/06/14 00:00:00', 'yyyy/MM/dd hh:mm:ss', 'es'), PARSEDATETIME('2020/12/31 23:59:59', 'yyyy/MM/dd hh:mm:ss', 'es'),1,35455,0,35.50,'EUR'),
(2, 1, PARSEDATETIME('2020/06/14 15:00:00', 'yyyy/MM/dd hh:mm:ss', 'es'), PARSEDATETIME('2020/06/14 18:30:00', 'yyyy/MM/dd hh:mm:ss', 'es'),2,35455,1,25.45,'EUR'),
(3, 1, PARSEDATETIME('2020/06/15 00:00:00', 'yyyy/MM/dd hh:mm:ss', 'es'), PARSEDATETIME('2020/06/15 11:00:00', 'yyyy/MM/dd hh:mm:ss', 'es'),3,35455,1,30.50,'EUR'),
(4, 1, PARSEDATETIME('2020/06/15 16:00:00', 'yyyy/MM/dd hh:mm:ss', 'es'), PARSEDATETIME('2020/12/31 23:59:59', 'yyyy/MM/dd hh:mm:ss', 'es'),4,35455,1,38.95,'EUR');
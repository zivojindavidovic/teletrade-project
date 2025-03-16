CREATE TABLE users (
                       user_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       email VARCHAR(255) NOT NULL,
                       username VARCHAR(255) NOT NULL
);

CREATE TABLE stock (
                       stock_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                       symbol VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE orders (
                        order_id BIGINT PRIMARY KEY AUTO_INCREMENT,
                        price DOUBLE NOT NULL,
                        quantity INT NOT NULL,
                        type ENUM('BUY', 'SELL') NOT NULL,
                        user_id BIGINT,
                        stock_id BIGINT,
                        FOREIGN KEY (user_id) REFERENCES users(user_id) ON DELETE CASCADE,
                        FOREIGN KEY (stock_id) REFERENCES stock(stock_id) ON DELETE CASCADE
);

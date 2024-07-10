CREATE TABLE address
(
    id                 BIGINT                                    NOT NULL,
    flat_number        VARCHAR(255),
    street             VARCHAR(255),
    postal_code        VARCHAR(255),
    city               VARCHAR(255),
    country            VARCHAR(255),
    customer           BIGINT,
    creation_timestamp TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    update_timestamp   TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    CONSTRAINT pk_address PRIMARY KEY (id)
);

CREATE TABLE customer
(
    id                 BIGINT                                    NOT NULL,
    display_name       VARCHAR(255),
    first_name         VARCHAR(255),
    last_name          VARCHAR(255),
    state              VARCHAR(255),
    type               VARCHAR(255),
    creation_timestamp TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    update_timestamp   TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    CONSTRAINT pk_customer PRIMARY KEY (id)
);

CREATE TABLE invoice
(
    id                 BIGINT                                    NOT NULL,
    customer           BIGINT,
    creation_timestamp TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    update_timestamp   TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    CONSTRAINT pk_invoice PRIMARY KEY (id)
);

CREATE TABLE line_item
(
    id             BIGINT NOT NULL,
    note           VARCHAR(255),
    customer_order BIGINT,
    product        BIGINT,
    quantity       INTEGER,
    CONSTRAINT pk_line_item PRIMARY KEY (id)
);

CREATE TABLE customer_order
(
    id                 BIGINT                                    NOT NULL,
    status             VARCHAR(255),
    payment            DECIMAL,
    creation_timestamp TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    update_timestamp   TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    CONSTRAINT pk_customer_order PRIMARY KEY (id)
);

CREATE TABLE payment
(
    id                 BIGINT                                    NOT NULL,
    customer           BIGINT,
    creation_timestamp TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    update_timestamp   TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    CONSTRAINT pk_payment PRIMARY KEY (id)
);

CREATE TABLE product
(
    id                 BIGINT                                    NOT NULL,
    name               VARCHAR(255),
    company            VARCHAR(255),
    quantity           INTEGER,
    price              DECIMAL,
    creation_timestamp TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    update_timestamp   TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE shipping
(
    id                 BIGINT                                    NOT NULL,
    order_id           BIGINT,
    address            BIGINT,
    note               VARCHAR(255),
    creation_timestamp TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    update_timestamp   TIMESTAMP WITHOUT TIME ZONE DEFAULT NOW() NOT NULL,
    CONSTRAINT pk_shipping PRIMARY KEY (id)
);

ALTER TABLE shipping
    ADD CONSTRAINT FK_SHIPPING_ON_ADDRESS FOREIGN KEY (address) REFERENCES address (id);

ALTER TABLE shipping
    ADD CONSTRAINT FK_SHIPPING_ON_ORDER FOREIGN KEY (order_id) REFERENCES customer_order (id);

ALTER TABLE payment
    ADD CONSTRAINT FK_PAYMENT_ON_CUSTOMER FOREIGN KEY (customer) REFERENCES customer (id);

ALTER TABLE line_item
    ADD CONSTRAINT FK_LINE_ITEM_ON_CUSTOMER_ORDER FOREIGN KEY (customer_order) REFERENCES customer_order (id);

ALTER TABLE line_item
    ADD CONSTRAINT FK_LINE_ITEM_ON_PRODUCT FOREIGN KEY (product) REFERENCES product (id);

ALTER TABLE invoice
    ADD CONSTRAINT FK_INVOICE_ON_CUSTOMER FOREIGN KEY (customer) REFERENCES customer (id);

ALTER TABLE address
    ADD CONSTRAINT FK_ADDRESS_ON_CUSTOMER FOREIGN KEY (customer) REFERENCES customer (id);
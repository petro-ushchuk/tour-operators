-- ADDING USERS --
INSERT INTO user (username, password, role) VALUES ('traveler1', '$2a$10$5Fd8MNuTS49sEWX1kYzQP.JS.rrIZ29K51sGWSg7M8eQ5Avvj2GDO', 0);
INSERT INTO user (username, password, role) VALUES ('traveler2', '$2a$10$5Fd8MNuTS49sEWX1kYzQP.JS.rrIZ29K51sGWSg7M8eQ5Avvj2GDO', 0);
INSERT INTO user (username, password, role) VALUES ('traveler3', '$2a$10$5Fd8MNuTS49sEWX1kYzQP.JS.rrIZ29K51sGWSg7M8eQ5Avvj2GDO', 0);

INSERT INTO user (username, password, role) VALUES ('company-head1', '$2a$10$5Fd8MNuTS49sEWX1kYzQP.JS.rrIZ29K51sGWSg7M8eQ5Avvj2GDO', 1);
INSERT INTO user (username, password, role) VALUES ('company-head2', '$2a$10$5Fd8MNuTS49sEWX1kYzQP.JS.rrIZ29K51sGWSg7M8eQ5Avvj2GDO', 1);
INSERT INTO user (username, password, role) VALUES ('company-head3', '$2a$10$5Fd8MNuTS49sEWX1kYzQP.JS.rrIZ29K51sGWSg7M8eQ5Avvj2GDO', 1);

-- ADDING COMPANIES --
INSERT INTO company (company_name, owner_id) VALUES('company1', 4);
INSERT INTO company (company_name, owner_id) VALUES('company2', 5);

-- ADDING TOURS --
INSERT INTO tour (name, tour_type, company_id) VALUES('Odesa', 0, 1);
INSERT INTO tour (name, tour_type, company_id) VALUES('Lviv', 1, 1);
INSERT INTO tour (name, tour_type, company_id) VALUES('Kyiv', 2, 1);

INSERT INTO tour (name, tour_type, company_id) VALUES('Kharkiv', 0, 2);
INSERT INTO tour (name, tour_type, company_id) VALUES('Vinnitsia', 1, 2);
INSERT INTO tour (name, tour_type, company_id) VALUES('Zhitomyr', 2, 2);

-- SET USERS TOURS --
INSERT INTO user_tours VALUES (1, 1);
INSERT INTO user_tours VALUES (1, 2);
INSERT INTO user_tours VALUES (1, 4);
INSERT INTO user_tours VALUES (1, 5);
INSERT INTO user_tours VALUES (2, 3);
INSERT INTO user_tours VALUES (2, 6);

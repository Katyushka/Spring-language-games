INSERT INTO users (id, email, is_verified, login, password, town, name, surname, role, deleted) VALUES (5, 'admin@mail.com', false, 'admin', '$2a$10$kdN43G6b8zic7NDFH/1mWO62RMXFUIQcyHnXYT/L07LQiAoaOVZra', 'Orenburg', 'Ekaterina', 'Chernova', 'ROLE_ADMIN', false);
INSERT INTO users (id, email, is_verified, login, password, town, name, surname, role, deleted) VALUES (6, 'user@mail.com', false, 'user', '$2a$10$OotQJrfFaEERZbNky/oXKeHxTobYRcia9xCiIBpGYp0Zb6V8Uui3e', 'Moscow',  'Vasya', 'Petrov', 'ROLE_USER', false);
INSERT INTO users (id, email, is_verified, login, password, town, name, surname, role, deleted) VALUES (30, 'kate@mail.com', false, 'kate', '$2a$10$kdN43G6b8zic7NDFH/1mWO62RMXFUIQcyHnXYT/L07LQiAoaOVZra', 'Orenburg', 'Ekaterina', 'Chernova', 'ROLE_USER', false);
INSERT INTO users (id, email, is_verified, login, password, town, name, surname, role, deleted) VALUES (31, 'vasya@mail.com', false, 'vasya', '$2a$10$OotQJrfFaEERZbNky/oXKeHxTobYRcia9xCiIBpGYp0Zb6V8Uui3e', 'Moscow',  'Vasya', 'Petrov', 'ROLE_USER', false);
INSERT INTO users (id, email, is_verified, login, password, town, name, surname, role, deleted) VALUES (32, 'yuliya@mail.com', false, 'yuliya', '$2a$10$OotQJrfFaEERZbNky/oXKeHxTobYRcia9xCiIBpGYp0Zb6V8Uui3e', 'Moscow',  'Vasya', 'Petrov', 'ROLE_USER', false);




INSERT INTO verification_token (id, expiry_date, token, token_type, verified, user_id) VALUES (8, '2015-07-17 08:28:45.878000', '78b1e6d775cec5260001af137a79dbd5', 'EMAIL_VERIFICATION', true, 5);
INSERT INTO verification_token (id, expiry_date, token, token_type, verified, user_id) VALUES (9, '2015-08-15 04:34:46.345000', '0e0530c1430da76495955eb06eb99d95', 'LOST_PASSWORD', true, 5);

INSERT INTO languages (id, name, description) VALUES (1, 'Russian', 'Russian language');
INSERT INTO languages (id, name, description) VALUES (2, 'English', 'English language');
INSERT INTO languages (id, name, description) VALUES (3, 'French', 'French language');
INSERT INTO languages (id, name, description) VALUES (4, 'Germany', 'Germany language');

INSERT INTO words (id, content, language_id) VALUES (12, 'cat', 2);
INSERT INTO words (id, content, language_id) VALUES (13, 'dog', 2);
INSERT INTO words (id, content, language_id) VALUES (14, 'father', 2);
INSERT INTO words (id, content, language_id) VALUES (15, 'sister', 2);
INSERT INTO words (id, content, language_id) VALUES (16, 'кошка', 1);
INSERT INTO words (id, content, language_id) VALUES (17, 'собака', 1);
INSERT INTO words (id, content, language_id) VALUES (18, 'папа', 1);
INSERT INTO words (id, content, language_id) VALUES (19, 'сестра', 1);
INSERT INTO words (id, content, language_id) VALUES (20, 'стул', 1);
INSERT INTO words (id, content, language_id) VALUES (21, 'шкаф', 1);
INSERT INTO words (id, content, language_id) VALUES (22, 'chair', 2);
INSERT INTO words (id, content, language_id) VALUES (23, 'cupboard', 2);
INSERT INTO words (id, content, language_id) VALUES (24, 'благодарный', 1);
INSERT INTO words (id, content, language_id) VALUES (25, 'забота', 1);
INSERT INTO words (id, content, language_id) VALUES (26, 'thankful', 2);
INSERT INTO words (id, content, language_id) VALUES (27, 'care', 2);



INSERT INTO word_sets (id, name, description, primary_language, user_id) VALUES (10, 'animals', 'set of the different animals', 2, 5);
INSERT INTO word_sets (id, name, description, primary_language, user_id) VALUES (11, 'family members', 'set of the different family members', 2, 5);
INSERT INTO word_sets (id, name, description, primary_language, user_id) VALUES (28, 'furniture', 'set of the furniture', 2, 6);
INSERT INTO word_sets (id, name, description, primary_language, user_id) VALUES (29, 'emotions', 'set of the different emotions', 2, 6);


INSERT INTO word_to_word (first_word_id, second_word_id) VALUES (12, 16);
INSERT INTO word_to_word (first_word_id, second_word_id) VALUES (13, 17);
INSERT INTO word_to_word (first_word_id, second_word_id) VALUES (14, 18);
INSERT INTO word_to_word (first_word_id, second_word_id) VALUES (15, 19);
INSERT INTO word_to_word (first_word_id, second_word_id) VALUES (20, 22);
INSERT INTO word_to_word (first_word_id, second_word_id) VALUES (21, 23);
INSERT INTO word_to_word (first_word_id, second_word_id) VALUES (24, 26);
INSERT INTO word_to_word (first_word_id, second_word_id) VALUES (25, 27);



INSERT INTO word_sets_words (word_set_id, word_id) VALUES (10, 12);
INSERT INTO word_sets_words (word_set_id, word_id) VALUES (10, 13);
INSERT INTO word_sets_words (word_set_id, word_id) VALUES (10, 16);
INSERT INTO word_sets_words (word_set_id, word_id) VALUES (10, 17);
INSERT INTO word_sets_words (word_set_id, word_id) VALUES (11, 14);
INSERT INTO word_sets_words (word_set_id, word_id) VALUES (11, 15);
INSERT INTO word_sets_words (word_set_id, word_id) VALUES (11, 18);
INSERT INTO word_sets_words (word_set_id, word_id) VALUES (11, 19);

INSERT INTO word_sets_words (word_set_id, word_id) VALUES (28, 20);
INSERT INTO word_sets_words (word_set_id, word_id) VALUES (28, 21);
INSERT INTO word_sets_words (word_set_id, word_id) VALUES (28, 22);
INSERT INTO word_sets_words (word_set_id, word_id) VALUES (28, 23);
INSERT INTO word_sets_words (word_set_id, word_id) VALUES (29, 24);
INSERT INTO word_sets_words (word_set_id, word_id) VALUES (29, 25);
INSERT INTO word_sets_words (word_set_id, word_id) VALUES (29, 26);
INSERT INTO word_sets_words (word_set_id, word_id) VALUES (29, 27);






-- languages
INSERT INTO public.languages (id, name, description) VALUES (1, 'Russian', 'Russian language');
INSERT INTO public.languages (id, name, description) VALUES (3, 'French', 'French language');
INSERT INTO public.languages (id, name, description) VALUES (2, 'English', 'English language');
INSERT INTO public.languages (id, name, description) VALUES (4, 'Germany', 'Germany language');


-- Users
INSERT INTO public.users (id, email, is_verified, name, password, role, deleted) VALUES (5, 'putin@mail.com', false, 'admin', '$2a$10$XIMNUKC5391WYGxbW.y4QurP67diyTHqvphPgZF2QSjEaAE5M4aiW', 'SUPER_ADMIN', false);
INSERT INTO public.users (id, email, is_verified, name, password, role, deleted) VALUES (6, 'medvedev@mail.com', false, 'user', '$2a$10$299sabD09jWyfys2OtUSMeoXSypH6riqrqqeJrQKZNQAvvdg/awB6', 'ADMIN', false);
INSERT INTO public.users (id, email, is_verified, name, password, role, deleted) VALUES (7, 'sharikov@mail.com', false, 'dog', '4d6341896a313c02d55a86eaaa8126b4', 'USER', false);



-- Verification token
INSERT INTO public.verification_token (id, expiry_date, token, token_type, verified, user_id) VALUES (8, '2015-07-17 08:28:45.878000', '78b1e6d775cec5260001af137a79dbd5', 'EMAIL_VERIFICATION', true, 5);
INSERT INTO public.verification_token (id, expiry_date, token, token_type, verified, user_id) VALUES (9, '2015-08-15 04:34:46.345000', '0e0530c1430da76495955eb06eb99d95', 'LOST_PASSWORD', true, 5);


-- Word sets
INSERT INTO public.word_sets (id, name, description, primary_language, user_id) VALUES (11, 'family members', 'set of the different family members', 2, 5);
INSERT INTO public.word_sets (id, name, description, primary_language, user_id) VALUES (20, 'животные', 'Набор слов различных животных', 1, 6);
INSERT INTO public.word_sets (id, name, description, primary_language, user_id) VALUES (21, 'члены семьи', 'Набор слов членов семьи', 1, 6);
INSERT INTO public.word_sets (id, name, description, primary_language, user_id) VALUES (22, 'animals', 'set of the different animals', 2, 5);
INSERT INTO public.word_sets (id, name, description, primary_language, user_id) VALUES (23, 'furniture', 'a set of things for household needs', 2, 6);
INSERT INTO public.word_sets (id, name, description, primary_language, user_id) VALUES (24, 'мебель', 'набор мебели', 1, 5);
INSERT INTO public.word_sets (id, name, description, primary_language, user_id) VALUES (25, 'electronic devices', 'set of the electronic things, which make our life easier and more convenient', 2, 5);
INSERT INTO public.word_sets (id, name, description, primary_language, user_id) VALUES (26, 'электронные устройства', 'набор электронных приборов, которые делают жизнь комфортной', 1, 5);


-- Word sets words
INSERT INTO public.word_sets_words (word_set_id, word_id) VALUES (11, 14);
INSERT INTO public.word_sets_words (word_set_id, word_id) VALUES (11, 15);
INSERT INTO public.word_sets_words (word_set_id, word_id) VALUES (20, 17);
INSERT INTO public.word_sets_words (word_set_id, word_id) VALUES (21, 18);
INSERT INTO public.word_sets_words (word_set_id, word_id) VALUES (21, 19);
INSERT INTO public.word_sets_words (word_set_id, word_id) VALUES (20, 16);
INSERT INTO public.word_sets_words (word_set_id, word_id) VALUES (21, 19);
INSERT INTO public.word_sets_words (word_set_id, word_id) VALUES (21, 19);
INSERT INTO public.word_sets_words (word_set_id, word_id) VALUES (23, 27);
INSERT INTO public.word_sets_words (word_set_id, word_id) VALUES (23, 29);
INSERT INTO public.word_sets_words (word_set_id, word_id) VALUES (24, 28);
INSERT INTO public.word_sets_words (word_set_id, word_id) VALUES (24, 30);
INSERT INTO public.word_sets_words (word_set_id, word_id) VALUES (25, 31);
INSERT INTO public.word_sets_words (word_set_id, word_id) VALUES (25, 33);
INSERT INTO public.word_sets_words (word_set_id, word_id) VALUES (26, 32);
INSERT INTO public.word_sets_words (word_set_id, word_id) VALUES (26, 34);



-- Word to word
INSERT INTO public.word_to_word (first_word_id, second_word_id) VALUES (12, 16);
INSERT INTO public.word_to_word (first_word_id, second_word_id) VALUES (13, 17);
INSERT INTO public.word_to_word (first_word_id, second_word_id) VALUES (14, 18);
INSERT INTO public.word_to_word (first_word_id, second_word_id) VALUES (15, 19);
INSERT INTO public.word_to_word (first_word_id, second_word_id) VALUES (27, 28);
INSERT INTO public.word_to_word (first_word_id, second_word_id) VALUES (29, 30);
INSERT INTO public.word_to_word (first_word_id, second_word_id) VALUES (31, 32);
INSERT INTO public.word_to_word (first_word_id, second_word_id) VALUES (33, 34);



-- Words
INSERT INTO public.words (id, content, language_id) VALUES (12, 'cat', 2);
INSERT INTO public.words (id, content, language_id) VALUES (13, 'dog', 2);
INSERT INTO public.words (id, content, language_id) VALUES (14, 'father', 2);
INSERT INTO public.words (id, content, language_id) VALUES (15, 'sister', 2);
INSERT INTO public.words (id, content, language_id) VALUES (16, 'кошка', 1);
INSERT INTO public.words (id, content, language_id) VALUES (17, 'собака', 1);
INSERT INTO public.words (id, content, language_id) VALUES (18, 'папа', 1);
INSERT INTO public.words (id, content, language_id) VALUES (19, 'сестра', 1);
INSERT INTO public.words (id, content, language_id) VALUES (27, 'chair', 2);
INSERT INTO public.words (id, content, language_id) VALUES (28, 'стул', 1);
INSERT INTO public.words (id, content, language_id) VALUES (29, 'table', 2);
INSERT INTO public.words (id, content, language_id) VALUES (30, 'стол', 1);
INSERT INTO public.words (id, content, language_id) VALUES (31, 'refrigerator', 2);
INSERT INTO public.words (id, content, language_id) VALUES (32, 'холодильник', 1);
INSERT INTO public.words (id, content, language_id) VALUES (33, 'washing machine', 2);
INSERT INTO public.words (id, content, language_id) VALUES (34, 'стиральная машина', 1);



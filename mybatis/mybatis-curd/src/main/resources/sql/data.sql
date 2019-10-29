-- 初始用户数据
INSERT INTO
  `user`(name, age, gid)
VALUES ('guolanren1', 23, 1),('guolanren2', 24, 1),('guolanren3', 25, 1);

-- 初始目标数据
INSERT INTO
  `goal`(name)
VALUES ('to be No.1');

-- 初始个人电脑数据
INSERT INTO
  `pc`(name, belong_to)
VALUES
  ('hp', 1),
  ('hp', 2),
  ('hp', 3),
  ('dell', 3);

-- 初始语言数据
INSERT INTO
  `language`(name)
VALUES ('java'),('python'),('javascript');

-- 初始关联数据
INSERT INTO
  `user_language`(uid, lid)
VALUES
  (1, 1),
  (2, 1),
  (2, 2),
  (3, 1),
  (3, 2),
  (3, 3);
-- 初始系统用户数据
INSERT INTO
  `example_sys_user`(name, is_deleted, gmt_create, gmt_modified)
VALUES
  ('甲', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  ('乙', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  ('丙', 0, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 初始用户角色数据
INSERT INTO
  `example_role`(name, gmt_create, gmt_modified)
VALUES
  ('管理员', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  ('普通用户', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 初始系统权限数据
INSERT INTO
  `example_privilege`(name, url, gmt_create, gmt_modified)
VALUES
  ('用户管理', '/systemUserManage', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  ('角色管理', '/roleManage', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  ('权限管理', '/privilegeManage', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 初始系统用户、用户角色关联数据
INSERT INTO
  `example_sys_user_role`(sys_user_id, role_id, gmt_create, gmt_modified)
VALUES
  (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (2, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (3, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

-- 初始用户角色、系统权限关联数据
INSERT INTO
  `example_role_privilege`(role_id, privilege_id, gmt_create, gmt_modified)
VALUES
  (1, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (1, 2, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (1, 3, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP),
  (2, 1, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
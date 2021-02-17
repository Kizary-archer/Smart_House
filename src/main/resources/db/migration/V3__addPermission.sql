INSERT INTO public.permisions (name_permission)
VALUES ('READ'),
       ('WRITE');
INSERT into public.permission_user_role(user_role, permission)
VALUES (1,1),
       (1,2),
       (2,1);

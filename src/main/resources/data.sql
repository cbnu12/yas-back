insert into users(`email`,`password`,`nickname`,
                  `shows_birth`,`career_start_at`,`is_active`, `is_deleted`, `last_password_update_at`,
                  `created_by`,`created_at`,`updated_by`,`updated_at`,`sign_in_fail_count`)
values ('temp@temp.com','password','nickname',
        true,now(),true,false,now(),
        'temp',now(),'temp',now(),3);

insert into techstacks(name, created_by, created_at, updated_by, updated_at)
values ('Spring','temp',now(),'temp',now());


insert into teams(`name`,`max_user_count`,`description`,
                  `owner_id`,`topic`,`is_active`,`created_by`,`created_at`,`updated_by`,`updated_at`)
values ('teamTest',10,'testesttstsetestsetset',
        1, 1, true, 'temp',now(),'temp',now());
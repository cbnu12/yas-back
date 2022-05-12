insert into USERS(`email`,`password`,`nickname`,
                  `shows_birth`,`career_start_at`,`is_active`,`last_password_update_at`,
                  `created_by`,`created_at`,`updated_by`,`updated_at`,`sign_in_fail_count`)
values ('temp@temp.com','password','nickname',
        true,now(),true,now(),
        'temp',now(),'temp',now(),3);
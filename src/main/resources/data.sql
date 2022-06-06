insert into users(`email`,`password`,`nickname`,
                  `shows_birth`,`career_start_at`,`IS_ACTIVE`, `is_deleted`, `last_password_update_at`,
                  `created_by`,`created_at`,`updated_by`,`updated_at`,`sign_in_fail_count`)
values ('temp@temp.com','password','nickname',
        true,now(),true,false,now(),
        'temp',now(),'temp',now(),3);

insert into techstacks(name, created_by, created_at, updated_by, updated_at)
values ('Spring','temp',now(),'temp',now());


insert into teams(`name`,`max_member_count`,`description`,
                  `owner_id`,`main_techstack_id`,`status`,`created_by`,`created_at`,`updated_by`,`updated_at`)
values ('teamTest',10,'testesttstsetestsetset',
        1, 1, 'ACTIVE', 'temp',now(),'temp',now());

INSERT INTO users (BIRTH, CAREER_START_AT, CREATED_AT, CREATED_BY, EMAIL, IS_ACTIVE, IS_DELETED, LAST_PASSWORD_UPDATE_AT, NICKNAME, PASSWORD, SHOWS_BIRTH, SIGN_IN_FAIL_COUNT, UPDATED_AT, UPDATED_BY, PROFILE_IMAGE_ID)
VALUES ('1995-01-01', '2021-01-01', now(), 'temp', 'jo.sung@yas.com', true, false, null, 'jinok', 'password1', true, 2, now(), 'temp', null);
INSERT INTO users (BIRTH, CAREER_START_AT, CREATED_AT, CREATED_BY, EMAIL, IS_ACTIVE, IS_DELETED, LAST_PASSWORD_UPDATE_AT, NICKNAME, PASSWORD, SHOWS_BIRTH, SIGN_IN_FAIL_COUNT, UPDATED_AT, UPDATED_BY, PROFILE_IMAGE_ID)
VALUES ('1994-01-01', '2020-01-01', now(), 'temp', 'sj.kang@yas.com', true, true, null, 'sungjo', 'password2', true, 3, now(), 'temp', null);
INSERT INTO users (BIRTH, CAREER_START_AT, CREATED_AT, CREATED_BY, EMAIL, IS_ACTIVE, IS_DELETED, LAST_PASSWORD_UPDATE_AT, NICKNAME, PASSWORD, SHOWS_BIRTH, SIGN_IN_FAIL_COUNT, UPDATED_AT, UPDATED_BY, PROFILE_IMAGE_ID)
VALUES ('1993-01-01', '2018-01-01', now(), 'temp', 'mh.park@yas.com', false, false, null, 'minhyuk', 'password3', true, 4, now(), 'temp', null);
INSERT INTO users (BIRTH, CAREER_START_AT, CREATED_AT, CREATED_BY, EMAIL, IS_ACTIVE, IS_DELETED, LAST_PASSWORD_UPDATE_AT, NICKNAME, PASSWORD, SHOWS_BIRTH, SIGN_IN_FAIL_COUNT, UPDATED_AT, UPDATED_BY, PROFILE_IMAGE_ID)
VALUES ('1993-01-01', '2019-01-01', now(), 'temp', 'sd.han@yas.com', false, true, null, 'seungdeok', 'password4', true, 5, now(), 'temp', null);

INSERT INTO techstacks (CREATED_AT, CREATED_BY, NAME, UPDATED_AT, UPDATED_BY)
VALUES (now(), 'temp', 'Spring', now(), 'temp');
INSERT INTO techstacks (CREATED_AT, CREATED_BY, NAME, UPDATED_AT, UPDATED_BY)
VALUES (now(), 'temp', 'React', now(), 'temp');
INSERT INTO techstacks (CREATED_AT, CREATED_BY, NAME, UPDATED_AT, UPDATED_BY)
VALUES (now(), 'temp', 'MySQL', now(), 'temp');
INSERT INTO techstacks (CREATED_AT, CREATED_BY, NAME, UPDATED_AT, UPDATED_BY)
VALUES (now(), 'temp', 'Django', now(), 'temp');
INSERT INTO techstacks (CREATED_AT, CREATED_BY, NAME, UPDATED_AT, UPDATED_BY)
VALUES (now(), 'temp', 'Express', now(), 'temp');
INSERT INTO techstacks (CREATED_AT, CREATED_BY, NAME, UPDATED_AT, UPDATED_BY)
VALUES (now(), 'temp', 'Oracle', now(), 'temp');


INSERT INTO teams (CREATED_AT, CREATED_BY, DESCRIPTION, STATUS, MAX_MEMBER_COUNT, NAME, UPDATED_AT, UPDATED_BY, OWNER_ID, SCHEDULE_ID, main_techstack_id)
VALUES (now(), 'temp', 'Yas Study', 'ACTIVE', 5, 'Yas', now(), 'temp', 1, null, 1);
INSERT INTO teams (CREATED_AT, CREATED_BY, DESCRIPTION, STATUS, MAX_MEMBER_COUNT, NAME, UPDATED_AT, UPDATED_BY, OWNER_ID, SCHEDULE_ID, main_techstack_id)
VALUES (now(), 'temp', 'Toss Study', 'ACTIVE', 10, 'Toss', now(), 'temp', 1, null, 5);
INSERT INTO teams (CREATED_AT, CREATED_BY, DESCRIPTION, STATUS, MAX_MEMBER_COUNT, NAME, UPDATED_AT, UPDATED_BY, OWNER_ID, SCHEDULE_ID, main_techstack_id)
VALUES (now(), 'temp', 'Kakao Study', 'ACTIVE', 15, 'Kakao', now(), 'temp', 1, null, 2);
INSERT INTO teams (CREATED_AT, CREATED_BY, DESCRIPTION, STATUS, MAX_MEMBER_COUNT, NAME, UPDATED_AT, UPDATED_BY, OWNER_ID, SCHEDULE_ID, main_techstack_id)
VALUES (now(), 'temp', 'Naver Study', 'ACTIVE', 20, 'Naver', now(), 'temp', 1, null, 6);

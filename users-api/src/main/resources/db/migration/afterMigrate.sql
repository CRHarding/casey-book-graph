INSERT INTO USERS (USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, LOCATION, ABOUT_ME)
VALUES
    ('CRHarding', '1234', 'Casey', 'Harding', 'casey.r.harding@gmail.com', 'New York, New York', 'I love making apps named after myself!'),
    ('RBritt', '1234', 'Ryan', 'Brit', 'r.britt@gmail.com', 'New York, New York', 'I like to program...'),
    ('Doodeitstom', '1234', 'Tom', 'Choe', 't.choe@gmail.com', 'New York, New York', 'I used to own a donut shop. Now I hate donuts'),
    ('SSontag', '1234', 'Susan', 'Sontag', 's.sontag@gmail.com', 'New York, New York', 'Youve never heard of me, have you?'),
    ('SBeauvoir', '1234', 'Simone', 'De Beauvoir', 's.beauvoir@gmail.com', 'New York, New York', 'You dont even read, bro');

INSERT INTO FRIENDS (STATUS, FRIEND_SENT_REQUEST, FRIEND_RECEIVED_REQUEST)
VALUES
    (2, 1, 2),
    (2, 1, 3),
    (1, 2, 3),
    (1, 1, 4),
    (3, 2, 4),
    (1, 5, 2),
    (1, 5, 3),
    (1, 5, 4),
    (1, 5, 1);

INSERT INTO COMMENTS (COMMENTER_ID, POST_ID, COMMENT_TEXT)
VALUES
    (2, 1, 'Welcome to Casey Book!'),
    (3, 1, 'Awesome! Welcome!'),
    (1, 2, 'Im glad you like it!'),
    (2, 3, 'Im friending ya!');
INSERT INTO USERS (USERNAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL, LOCATION, ABOUT_ME)
VALUES
    ('CRHarding', '1234', 'Casey', 'Harding', 'casey.r.harding@gmail.com', 'New York, New York', 'I love making apps named after myself!'),
    ('RBritt', '1234', 'Ryan', 'Brit', 'r.britt@gmail.com', 'New York, New York', 'I like to program...'),
    ('Doodeitstom', '1234', 'Tom', 'Choe', 't.choe@gmail.com', 'New York, New York', 'I used to own a donut shop. Now I hate donuts'),
    ('SSontag', '1234', 'Susan', 'Sontag', 's.sontag@gmail.com', 'New York, New York', 'Youve never heard of me, have you?'),
    ('SBeauvoir', '1234', 'Simone', 'De Beauvoir', 's.beauvoir@gmail.com', 'New York, New York', 'You dont even read, bro');

INSERT INTO FRIENDS (STATUS, FRIEND_SENT_REQUEST, FRIEND_RECEIVED_REQUEST, SENT_REQUEST_USERNAME, RECEIVED_REQUEST_USERNAME)
VALUES
    (2, 1, 2, 'CRHarding', 'RBritt'),
    (2, 1, 3, 'CRHarding', 'Doodeitstom'),
    (1, 2, 3, 'RBritt', 'Doodeitstom'),
    (1, 1, 4, 'CRHarding', 'SSontag'),
    (3, 2, 4, 'RBritt', 'SSontag'),
    (1, 5, 2, 'SBeauvoir', 'RBritt'),
    (1, 5, 3, 'SBeauvoir', 'Doodeitstom'),
    (1, 5, 4, 'SBeauvoir', 'SSontag'),
    (1, 5, 1, 'SBeauvoir', 'CRHarding');

INSERT INTO POSTS (POSTER_ID, POSTER_USERNAME, TITLE, POST_TEXT)
VALUES
    (1, 'CRHarding', 'First Post!', 'This is my first post!'),
    (2, 'RBritt', 'Best...app..every!', 'I love this app!'),
    (3, 'Doodeitstom', 'Hello world!', 'Friend me to find out more!'),
    (1, 'CRHarding', 'I wish I were more interesting...', 'This is my second post!'),
    (5, 'SBeauvoir', 'I really like this app!', 'One of the better social media apps that Ive encountered'),
    (4, 'SSontag', 'Ive seen better...', 'Seriously. What does everyone see in this app? Its a buncha fluff...');

INSERT INTO COMMENTS (COMMENTER_ID, POST_ID, COMMENTER_USERNAME, COMMENT_TEXT)
VALUES
    (2, 1, 'RBritt', 'Welcome to Casey Book!'),
    (3, 1, 'Doodeitstom', 'Awesome! Welcome!'),
    (1, 2, 'CRHarding', 'Im glad you like it!'),
    (2, 3, 'RBritt', 'Im friending ya!');
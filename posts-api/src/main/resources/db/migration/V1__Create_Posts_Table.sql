create table POSTS (
    ID SERIAL PRIMARY KEY,
    TITLE varchar(50),
    POSTER_ID integer,
    POST_TEXT varchar(500),
    NUMBER_OF_LIKES integer DEFAULT 0,
    NUMBER_OF_COMMENTS integer DEFAULT 0,
    ABLE_TO_VIEW integer DEFAULT 0,
    TIME_ADDED TIMESTAMP default CURRENT_TIMESTAMP
);
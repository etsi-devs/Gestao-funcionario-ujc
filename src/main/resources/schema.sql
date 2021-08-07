CREATE TABLE users(
username varchar_ignorecase(50) not null primary key,
password varchar_ignorecase(50) not null,
enabled boolean not null
);

CREATE TABLE authorities (
username varchar_ignorecase(50) not null,
authority varchar_ignorecase(50) not null,
constraint fk_authorities_users foreign key(username) references users(username)
);

CREATE unique index ix_auth_username on authorities (username,authority);

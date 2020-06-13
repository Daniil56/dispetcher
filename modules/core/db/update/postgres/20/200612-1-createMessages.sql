create table DISPATCHER_MESSAGES (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    TEMPERATURE integer,
    NUMBER_ integer,
    IS_SMOKE boolean,
    IS_BACK_DOOR boolean,
    IS_WORK boolean,
    --
    primary key (ID)
);
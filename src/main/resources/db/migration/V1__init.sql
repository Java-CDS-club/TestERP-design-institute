create table employees
(
    id              serial primary key,
    name            varchar(255) not null,
    employment_rate int default 0
);

insert into employees (name, employment_rate)
values ('Bob', 0),
       ('Den', 10),
       ('Max', 20);

create table work_tasks
(
    id                serial primary key,
    name              varchar(255) not null,
    in_progress       boolean default false,
    id_creator        int references employees (id),
    id_executor       int references employees (id),
    employment_number int
);

insert into work_tasks (name, in_progress, id_creator, id_executor, employment_number)
values ('Проект планировки территории', true, 1, 2, 10),
       ('Проект жилого здания', true, 1, 3, 20);

insert into work_tasks(name, id_creator, employment_number)
values ('Проект ГРО', 1, 30);
create table employees
(
    id   serial primary key,
    name varchar(255) not null
);

insert into employees (name)
values ('Bob'),
       ('Den'),
       ('Max');

create table work_tasks
(
    id          serial primary key,
    name        varchar(255) not null,
    in_progress boolean default false,
    id_creator  int references employees (id),
    id_executor int references employees (id)
);

insert into work_tasks (name, in_progress, id_creator, id_executor)
values ('Проект планировки территории', true, 1, 2),
       ('Проект жилого здания', true, 1, 3);

insert into work_tasks(name, id_creator)
values ('Проект ГРО', 1);
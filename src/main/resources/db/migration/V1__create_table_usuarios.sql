create table usuarios(
    id SERIAL PRIMARY KEY,
	nome varchar(255) not null,
    login varchar(100) not null unique,
    senha varchar(255) not null
);

create table pensamentos (
    id serial primary key,
    descricao varchar(255) not null,
    autoria varchar(20) not null,
    id_usuario integer,
    constraint fk_usuario foreign key (id_usuario) references usuarios(id)
);



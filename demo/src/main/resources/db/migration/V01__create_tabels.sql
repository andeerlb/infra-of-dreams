CREATE TABLE IF NOT EXISTS requisicao (
    id bigint(20) primary key auto_increment not null,
    server_name varchar(100) not null,
    hostname varchar(255) not null,
    ip varchar(255) not null,
    request_date datetime not null,
    k8s_svc_name varchar(255) not null
) engine = InnoDB;
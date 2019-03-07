CREATE DATABASE consultorio;
USE consultorio;

create table Roles
(
idRol int AUTO_INCREMENT,
nombre varchar(100)not null,
apellido varchar(100)not null,
telefono varchar(15)not null,
username varchar(100)not null,
pass varchar(100)not null,
nivelAcc int not null,

constraint PK_Roles primary key(idRol)
);


create table Paciente
(
idPaciente int AUTO_INCREMENT ,
nombre varchar(100)not null,
domicilio varchar(300)not null,
telefono varchar(15) not null,
fechaNac  varchar(25) not null,
estado varchar(15),
usuario varchar(20),
contra varchar(20),
constraint Pk_Paciente primary key(idPaciente)
);

create table Cita
(
idCita int AUTO_INCREMENT ,
idPaciente int  ,
fecha varchar(25) not null,
hora time not null,
estado varchar(50) not null,
comentarios varchar(100),

constraint Pk_Cita primary key(idCita),
foreign key (idPaciente)
references paciente(idPaciente)
);


create table Expediente
(
idExp int AUTO_INCREMENT ,
idPaciente int ,
tipoSangre varchar(15),
numSeguro varchar(10) not null,

constraint Pk_Expediente primary key(idExp),
foreign key (idPaciente)
references paciente(idPaciente)
);

create table DiagCorto
(
idDiagCorto int auto_increment primary key,
nombreDiag varchar(40)
);

create table Diagnosticos
(
idDiagnostico int AUTO_INCREMENT ,
idExp int  ,
descripcion varchar (600) not null,
presion varchar(50) not null,
altura varchar(50) not null,
peso varchar(50) not null,

fecha_Diag varchar(25) not null,
hora varchar(25) not null,

constraint Pk_Diagnosticos primary key(idDiagnostico),
foreign key (idExp)
references expediente(idExp)

);

create table DiagCortoRel
(
idDiagCorto int,
idDiagnostico int,
foreign key (idDiagnostico)
references diagnosticos(idDiagnostico),
 foreign key (idDiagCorto)
references DiagCorto(idDiagCorto)
);


create table medicamentos
(
idMedicamento int auto_increment primary key,
medicamento varchar(40)
);


 create table diagMedi
 (
 idDiagnostico int,
 idMedicamento int,
 fecha_inicio varchar(30),
foreign key (idDiagnostico)
references diagnosticos(idDiagnostico),
 foreign key (idMedicamento)
references medicamentos(idMedicamento)
 );

create table Enfermedades
(
idEnfermedades int auto_increment,
enfermedadesHere varchar (600),

constraint Pk_Enfermedades primary key(idEnfermedades)
);

CREATE TABLE ExpaEnfer
(
idExp int,
idEnfermedades int,
 foreign key (idExp)
references expediente(idExp),
foreign key (idEnfermedades)
references enfermedades(idEnfermedades)
);

create table alergias
(
idAlergia int auto_increment,
alergia varchar (600),
constraint Pk_Alergias primary key(idAlergia)
);

create table ExpaAler
(
idExp int,
idAlergia int,
 foreign key (idExp)
references expediente(idExp),
foreign key (idAlergia)
references alergias(idAlergia)
);


create table operaciones
(
idOperacion int auto_increment,
operacion varchar (600),


constraint Pk_Operaciones primary key(idOperacion)

);

create table ExpaOpera
(
idExp int,
idOperacion int,
fechaOperacion varchar(50),
foreign key (idExp)
references expediente(idExp),
foreign key (idOperacion)
references operaciones(idOperacion)

);



create table referencias
(
idReferencia int auto_increment,
referencia varchar (600),

constraint Pk_Referencias primary key(idReferencia)

);

create table ExpaREf
(
idExp int,
idReferencia int,
foreign key (idExp)
references expediente(idExp),
foreign key (idReferencia)
references referencias(idReferencia)
);

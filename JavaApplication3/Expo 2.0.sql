--Se pone el master por si se estaba en otra instancia
use master
go
--Se crea la base de datos
create database Expo_2
go
--se selecciona la base de datos
use Expo_2
go

--se crea la primera tabla
create table tipo_usuario(
id_tipousuario int not null primary key identity(1,1),
nombre_tipoU varchar(20) unique
)

create table estado_empleado(
id_estadoem int not null primary key identity(1,1),
nombre_estado varchar(15) unique 
)

create table estado_usuario(
id_estadousu int not null primary key identity(1,1),
nombre_estado varchar(15)
)

--se crea la tabla de los empleados, esta sera hija de los usuarios y padre de otras
create table empleado(
id_empleado int not null primary key identity(1,1),
id_tipousuario int not null references tipo_usuario(id_tipousuario),
nombres_emp varchar(25) not null,
apellidos_emp varchar(25) not null,
sueldo numeric(6,2) not null,
id_estadoempleado int not null references estado_empleado(id_estadoem) on delete cascade on update cascade,
id_estadousuario int references estado_usuario(id_estadousu) on delete cascade on update cascade,
ISS int not null unique,
AFP char(12) not null unique,
DUI varchar(10) unique check(DUI like '0%'),
NIT varchar(17) not null unique,	
telefono_emp varchar(9) not null unique check(telefono_emp like '7%' or telefono_emp like '6%'),
correo_emp varchar(100) not null unique,
Estado_civil varchar(20) not null
)

insert into empleado (id_tipousuario, nombres_emp, apellidos_emp, sueldo, id_estadoempleado, id_estadousuario, ISS, AFP, DUI, NIT, telefono_emp, correo_emp, Estado_civil) values (1, 'Eduardo', 'Lopez', 1234.00, 1, 1,123456789, '123456789012', '0294567890', '25345678901234', '72342348', 'joih023oh@noih.com', 'Casado')
select id_empleado, estado_empleado.nombre_estado, estado_usuario.nombre_estado, nombre_tipoU from empleado, tipo_usuario, estado_empleado, estado_usuario where tipo_usuario.id_tipousuario = empleado.id_tipousuario and estado_empleado.id_estadoem = empleado.id_estadoempleado and estado_usuario.id_estadousu = empleado.id_estadousuario
select id_empleado, nombres_emp, nombre_tipoU from empleado, tipo_usuario where empleado.id_tipousuario = tipo_usuario.id_tipousuario and id_empleado = 6
select id_usuario, empleado.id_tipousuario, nombre_usuario, contra, empleado.id_empleado from usuario,empleado, tipo_usuario where usuario.id_empleado = empleado.id_empleado and empleado.id_tipousuario = tipo_usuario.id_tipousuario and id_estadousuario = 1 
select id_usuario, empleado.id_tipousuario, nombre_usuario, contra, empleado.id_empleado from usuario,empleado, tipo_usuario where usuario.id_empleado = empleado.id_empleado and empleado.id_tipousuario = tipo_usuario.id_tipousuario and id_estadousuario = 1 and nombre_usuario = 'katia9'  
UPDATE usuario Set contra='lopez9' where nombre_usuario = 'katia9'
select * from usuario
select id_usuario, nombre_tipoU, nombre_usuario, correo_emp from usuario,empleado, tipo_usuario where usuario.id_empleado = empleado.id_empleado and empleado.id_tipousuario = tipo_usuario.id_tipousuario and id_estadousuario = 1 and correo_emp = 'eduaralberto_lopez@hotmail.com'

--se crea la tabla de los usuarios, hija de tipos de usuarios y padre de empleado
create table usuario(
id_usuario int not null primary key identity(1,1),
id_empleado int not null references empleado(id_empleado) on delete cascade on update cascade,
nombre_usuario varchar(20) unique,
contra nvarchar(90)
)

--se crea la tabla de los clientes
create table cliente(
id_cliente int not null primary key identity(1,1),
nombres_cliente varchar(25),
apellidos_cliente varchar(25),
DUI varchar(10) unique check(DUI like '0%'),
NIT varchar(17) unique,
Telefono varchar(9) unique check(telefono like '7%' or telefono like '6%'),
Correo varchar(70) unique
)

--se crea la tabla de los tipos de propiedad
create table tipo_propiedad(
id_tipoPropiedad int not null primary key identity(1,1),
nombre_tipoP varchar(20) unique,
)

--se crea la tabla de estado de propiedad
create table estado_AV(
id_estadoAV int not null primary key identity(1,1),
nombre_estadoAV varchar(20) unique,
)

--se crea la tabla de los departamentos del pais
create table departamentoES(
id_departamentos int not null primary key identity(1,1),
nombre_depa varchar(80) unique
)

--se crea los municipios de cada departamento
create table municipios(
id_municipio int not null primary key identity(1,1),
id_departamentos int not null references departamentoES(id_departamentos) on delete cascade on update cascade,
nombre_muni varchar(80) unique
)

create table estado_propi(
id_estadopropi int not null identity(1,1) primary key,
nombre_estadopropi varchar(30)
)

create table unidad_medida(
id_unidad int not null identity(1,1) primary key,
nombre_unidad varchar(30)
)

--se crea la tabla de las propiedades que sera padre de venta porque sin una propiedad no hay venta, por eso va primero
create table propiedad(
id_propiedad int not null identity (1,1) primary key,
id_muni int not null references municipios(id_municipio) on delete cascade on update cascade,
id_tipoPropiedad int not null references tipo_propiedad(id_tipoPropiedad) on delete cascade on update cascade,
id_estadopropi int not null references estado_propi(id_estadopropi) on delete cascade on update cascade,
id_unidad int not null references unidad_medida(id_unidad) on delete cascade on update cascade,
Direccion varchar(150),
Dimension varchar(30),
Descripcion_propiedad varchar(255),
Precio_base money,
Prima money,
fecha_ingreso date not null
)

--se crea la tabla fotos para contener la galeria de fotos.
create table fotos(
id_foto int not null identity(1,1) primary key,
id_propiedad int not null references propiedad(id_propiedad) on delete cascade on update cascade,
foto varchar(50)
)

--se crea la tabla hisotorial donde se registraran los movimientos dentro de la empresa
create table historial(
id_historial int not null primary key identity(1,1),
id_usuario int not null references usuario(id_usuario) on delete cascade on update cascade,
Descripcion varchar(250) not null,
Monto money
)

--Esta tabla es para enlazar los clientes con los empleados y las propiedades, por medio de esta se realizan las ventas y se guardan registros de estas
create table Agenda_ventas(
id_agenda int not null primary key identity(1,1),
id_cliente int not null references cliente(id_cliente) on delete cascade on update cascade,
id_empleado int not null references empleado(id_empleado) on delete cascade on update cascade,
id_propiedad int not null references propiedad(id_propiedad) on delete cascade on update cascade,
fecha date,
hora time,
id_estadoAV int not null references estado_AV(id_estadoAV),
)

-----------------------------------------------------------------------------------------------------------------------------------------

insert into estado_empleado values ('Renuncio')

insert into tipo_propiedad values('Casa')

insert into estado_propi values('Disponible')

insert into unidad_medida values('metros')

SELECT CONVERT (date, getdate())
insert into propiedad values (3,1, 1,1, 'ubicacion', 'dimension', 'descripcion', '2','2', GETDATE())

select * from tipo_usuario
insert into tipo_usuario values ('Vendedor')
insert into tipo_usuario values ('Comprador')
insert into tipo_usuario values ('Administrador')
insert into tipo_usuario values ('Recursos Humanos')
insert into tipo_usuario values ('Secretaria')

select * from tipo_usuario

create view filtro
as
select propiedad.id_propiedad, departamentoES.nombre_depa, municipios.nombre_muni, tipo_propiedad.nombre_tipoP, estado_propi.nombre_estadopropi, propiedad.Direccion, propiedad.Dimension,unidad_medida.nombre_unidad, propiedad.Descripcion_propiedad,propiedad.Precio_base, propiedad.Prima,propiedad.fecha_ingreso 
from unidad_medida, propiedad, tipo_propiedad, municipios, estado_propi, departamentoES 
where tipo_propiedad.id_tipoPropiedad = propiedad.id_tipoPropiedad and municipios.id_municipio = propiedad.id_muni and estado_propi.id_estadopropi = propiedad.id_estadopropi and 
municipios.id_departamentos = departamentoES.id_departamentos and unidad_medida.id_unidad = propiedad.id_unidad 
group by propiedad.id_propiedad, departamentoES.nombre_depa, municipios.nombre_muni, tipo_propiedad.nombre_tipoP, estado_propi.nombre_estadopropi, propiedad.Direccion, propiedad.Dimension,unidad_medida.nombre_unidad, propiedad.Descripcion_propiedad,propiedad.Precio_base, propiedad.Prima,propiedad.fecha_ingreso

Select empleado.id_empleado, nombres_emp, apellidos_emp, telefono_emp from empleado,usuario,tipo_usuario where empleado.id_empleado = usuario.id_empleado and empleado.id_tipousuario = tipo_usuario.id_tipousuario and empleado.id_tipousuario = 1

select id_empleado, nombres_emp, apellidos_emp, telefono_emp from empleado, tipo_usuario where empleado.id_tipousuario = tipo_usuario.id_tipousuario and empleado.id_tipousuario = 1
Select id_agenda, Agenda_ventas.id_cliente, cliente.apellidos_cliente, Agenda_ventas.id_propiedad, Direccion, Fecha, Hora, Agenda_ventas.id_estadoAV,  estado_AV.nombre_estadoAV from Agenda_ventas,empleado,cliente,propiedad,estado_AV where Agenda_ventas.id_cliente = cliente.id_cliente and Agenda_ventas.id_propiedad = propiedad.id_propiedad and Agenda_ventas.id_empleado = 48 and Agenda_ventas.id_estadoAV = estado_AV.id_estadoAV  and Agenda_ventas.id_empleado = empleado.id_empleado and Agenda_ventas.id_estadoAV != 1 and Agenda_ventas.id_estadoAV != 4
Select id_empleado from usuario where id_usuario = 10 
select *from usuario
select * from estado_AV
insert into empleado (id_tipousuario, nombres_emp, apellidos_emp, sueldo, estado_usuario, estado_empleado, ISS, AFP, DUI, NIT, telefono_emp, correo_emp, Estado_civil) values (1, 'Eduardo', 'Lopez', 1234.00, 'Si', 'Si' ,123456789, '123456789012', '0294567890', '25345678901234', '72342348', 'joih023oh@noih.com', 'Casado')
select id_empleado,nombre_tipoU, nombres_emp, apellidos_emp, sueldo, estado_usuario, estado_empleado, ISS, AFP, DUI, NIT, telefono_emp, correo_emp, Estado_civil from empleado, tipo_usuario where empleado.id_tipousuario = tipo_usuario.id_tipousuario
select * from empleado


select empleado.id_empleado, nombres_emp, apellidos_emp, nombre_tipoU, estado from empleado, tipo_usuario, usuario where empleado.id_tipousuario = tipo_usuario.id_tipousuario and usuario.id_empleado = empleado.id_empleado and nombre_tipoU like '%Administrador' and usuario.id_usuario is not null  

select id_empleado, nombres_emp, apellidos_emp, nombre_tipoU from empleado, tipo_usuario where empleado.id_tipousuario = tipo_usuario.id_tipousuario and nombre_tipoU like '%Vendedor'
select id_empleado, nombres_emp, apellidos_emp, nombre_tipoU from empleado, tipo_usuario where empleado.id_tipousuario = tipo_usuario.id_tipousuario and nombre_tipoU like '%Comprador'
select id_empleado, nombres_emp, apellidos_emp, nombre_tipoU from empleado, tipo_usuario where empleado.id_tipousuario = tipo_usuario.id_tipousuario and nombre_tipoU like '%Secretaria'
select id_empleado, nombres_emp, apellidos_emp, nombre_tipoU from empleado, tipo_usuario where empleado.id_tipousuario = tipo_usuario.id_tipousuario and nombre_tipoU like '%Recursos Humanos'

alter table empleado
drop column estado_usuario


select propiedad.id_propiedad, departamentoES.nombre_depa, municipios.nombre_muni, tipo_propiedad.nombre_tipoP, estado_propi.nombre_estadopropi, propiedad.Direccion, propiedad.Dimension,unidad_medida.nombre_unidad, propiedad.Descripcion_propiedad,propiedad.Precio_base, propiedad.Prima,propiedad.fecha_ingreso 
from unidad_

 select * from propiedad

 select id_usuario, empleado.id_tipousuario, nombre_usuario, contra from usuario,empleado, tipo_usuario where usuario.id_empleado = empleado.id_empleado and empleado.id_tipousuario = tipo_usuario.id_tipousuario and estado_usuario = 'Activado' and nombre_usuario = 'Alberto48'
insert into usuario values(47, 'Eduardo47', '123')

update empleado set estado_usuario = 'Activado' where id_empleado = 47
delete from usuario

insert into cliente values ('Eduardo', 'Lopez', '01234567-9', '12345678907234567', '71284567', 'jhqeojc@noqjwd.com')

insert into estado_propi values ('Compradas')

--Ingresar los tipos de usuarios y uno
--insert into tipo_usuario Values('Administrador')
/*select id_propiedad, departamentoSa, nombre_muni, nombre_tipoP, nombre_estadoAV, Ubicación, Dimension, Descripcion_propiedad,Precio_base, Prima from propiedad, tipo_propiedad, municipios, estado_AV where tipo_propiedad.id_tipoPropiedad = propiedad.id_tipoPropiedad and municipios.id_municipio = propiedad.id_municipio and estado_AV.id_estadoAV = propiedad.id_estadoAV and nombre_estadoAV='Disponible' and nombre_muni='Soyapango' and nombre_tipoP='Hogar' and departamentoSa='Sonsonate'

insert into propiedad values (1,1,'San Salvador', 1, 'ubicacion', 'dimension', 'descripcion', '2345','2345')
select id_departamentos, departamentoSa, nombre_muni, nombre_tipoP, nombre_estadoAV, Ubicación, Dimension, Descripcion_propiedad,Precio_base, Prima from propiedad, tipo_propiedad, municipios, estado_AV where tipo_propiedad.id_tipoPropiedad = propiedad.id_tipoPropiedad and municipios.id_municipio = propiedad.id_municipio and estado_AV.id_estadoAV = propiedad.id_estadoAV
select * from propiedad*/

--select id_propiedad, departamentoSa, nombre_muni, nombre_tipoP, nombre_estadoAV, Ubicación, Dimension, Descripcion_propiedad,Precio_base, Prima from propiedad, tipo_propiedad, municipios, estado_AV where tipo_propiedad.id_tipoPropiedad = propiedad.id_tipoPropiedad and municipios.id_municipio = propiedad.id_municipio and estado_AV.id_estadoAV = propiedad.id_estadoAV

/*SELECT id_tipousuario FROM tipo_usuario where nombre_tipoU = 'Comprador'
Select * from usuario where nombre_usuario = 'Oscar'*/



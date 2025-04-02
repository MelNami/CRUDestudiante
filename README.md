# API REST - Gestión de Estudiantes con Spring Boot

Este proyecto es una API REST construida con Spring Boot que permite realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre una lista de estudiantes almacenada en memoria.

## Tecnologías utilizadas

- Java 17
- Spring Boot 3.4.4
- Maven
- Git y GitHub
- Postman (para pruebas de endpoints)

## Estructura del proyecto

- `/controladores`: contiene los endpoints de la API
- `/servicios`: contiene la lógica de negocio
- `/dto`: clases que reciben datos desde el cliente
- `/dominio`: entidad principal `Estudiante`

# API CRUD de Estudiantes - Spring Boot

Proyecto backend que implementa una API REST para la gestión de estudiantes, usando Java y Spring Boot.

## Funcionalidades

- Crear estudiante (POST /estudiantes)
- Obtener estudiante por ID (GET /estudiantes/{id})
- Actualizar estudiante (PUT /estudiantes/{id})
- Eliminar estudiante (DELETE /estudiantes/{id})

## Tecnologías

- Java 17
- Spring Boot 3.4.4
- Maven

## Pruebas

Se realizaron pruebas con Postman para validar cada endpoint.
# Proyecto Tareas - Backend

1. Se debe editar la configuración de la base de datos en el archivo application.yml en la carpeta main/resources.
2. Ejecutar el script de la base de datos para crear la tabla de Tareas. Actualmente se utiliza Postgres.
3. Ejecutar los siguientes comandos de gradle para instalar dependencias y ejecutar el proyecto:
```
gradle build
```
```
gradle bootRun
```
4. Para probar endpoints se puede utilizar swagger:
```
http://localhost:8080/swagger-ui/index.html
```
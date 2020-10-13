## Prueba Zemsania

## Elaborado por:

Jimmy Armando Chirivi Nivia

## Descripcion

Crear una implementación de logueo con JWT. - Se definirá mediante un usuario y contraseña que lo obtendrá desde un archivo de texto (debe tener una lista de usuarios). Luego, si es correcto podrá generar un token de acceso para acceder a los recursos protegidos del carrito de compras indicados en el punto 2.

2.	En el carrito de compras deberá tener en cuenta las siguientes implementaciones:
-	Cliente [R]
-	Producto [G]
-	Venta [RC]
Leyenda:
[G] = Gestión Completa (CRUD)
[R] = Registro
[RC] = Registro y Consulta



## Tecnolgias de Desarrollo

- Java 8
- JavaScript 
- PostgreSQL
- Maven
- Spring Boot
- Jquery
- HTML
- Boostrap

## Usuarios de Prueba

usuario : 1234567879
clave : 1234

## Despliegue

Heroku: https://prueba-zemsania.herokuapp.com/

## Vistas

inicio: 

![image](https://user-images.githubusercontent.com/48265107/95799910-bdf06c80-0cbb-11eb-82ba-3727481bf675.png)

Productos: 

- Registro :

![image](https://user-images.githubusercontent.com/48265107/95799964-eaa48400-0cbb-11eb-9b99-9173473dded9.png)

- Actualización: 

![image](https://user-images.githubusercontent.com/48265107/95800038-17589b80-0cbc-11eb-96ba-d5d756055297.png)

- Eliminar: 

![image](https://user-images.githubusercontent.com/48265107/95800080-31927980-0cbc-11eb-8fb4-bfc07f21d1f2.png)


Ventas:

![image](https://user-images.githubusercontent.com/48265107/95800137-50910b80-0cbc-11eb-8cf2-c0ee7f4d7863.png)


Login:

![image](https://user-images.githubusercontent.com/48265107/95800177-63a3db80-0cbc-11eb-8b06-e5e55ac11ffb.png)

Registro usuario:

![image](https://user-images.githubusercontent.com/48265107/95800232-8d5d0280-0cbc-11eb-90b2-1f51ef06b0a9.png)

## 4.	Con sus propias palabras indique de qué forma podría mejorar la seguridad y optimizar el carrito de compras.

La solución más factible que yo veria es implentando una capa de protección cifrada donde se implementan certificados de seguridad para la trata de data,
y la optimizacion del carrito implementando en el front-end indexbd para no realizar tantas peticiones al servidor

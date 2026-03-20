🛰️ Comunicación entre Microservicios con OpenFeign
Este proyecto implementa la comunicación síncrona entre el Servicio de Reservas y el Servicio de Canchas utilizando Spring Cloud OpenFeign.

📝 Descripción de la Comunicación
La comunicación se realiza mediante una arquitectura de microservicios donde el servicio-reservas actúa como un cliente del servicio-canchas.

Declarativa: En lugar de usar RestTemplate con URLs manuales, usamos interfaces anotadas con @FeignClient.

Validación Pre-Persistencia: Antes de guardar una nueva reserva, el sistema realiza una petición GET al microservicio de Canchas para verificar la existencia del canchaId.

Manejo de Estados HTTP: El flujo detecta si el servicio remoto responde con un 200 OK (continúa el guardado) o un 404 Not Found (lanza una excepción de negocio).

🛠️ Cambios Implementados en el Proyecto
Para habilitar esta tecnología, se realizaron los siguientes cambios estructurales:

1. Configuración de Maven (pom.xml)
Se añadió la gestión de dependencias de Spring Cloud (BOM) para asegurar la compatibilidad de versiones:

Dependency Management: Se incluyó spring-cloud-dependencies (versión 2023.0.3).

Starters: Se agregaron spring-cloud-starter-openfeign y spring-cloud-starter-loadbalancer.

2. Activación de Feign
En la clase principal (ServicioreservasApplication.java), se añadió la anotación @EnableFeignClients para que Spring escanee y genere las implementaciones de las interfaces cliente.

3. Definición del Cliente (CanchaClient.java)
Se creó una interfaz con la anotación @FeignClient, especificando la URL base del microservicio de canchas y los métodos que "espejan" los endpoints del controlador remoto.

4. Lógica de Negocio (ReservaServicesImpl.java)
Se integró el cliente en el flujo de creación de reservas:

Se inyectó el CanchaClient mediante @Autowired.

Se implementó un bloque try-catch para capturar FeignException.NotFound.

Se sustituyó el guardado directo por un flujo validado: Consulta -> Validación -> Persistencia.

5. Manejo de Errores
Se ajustó el controlador de Canchas para devolver ResponseEntity.notFound() en lugar de null, permitiendo que Feign dispare las excepciones correctas y el usuario reciba un mensaje claro en lugar de un error 500 genérico.

¿Cómo probarlo?
Asegúrate de que el Servicio de Canchas esté corriendo en el puerto 8081.

Lanza el Servicio de Reservas en el puerto 8082.

Realiza un POST a /api/reservas. Si el canchaId no existe, recibirás un error validado indicando que la cancha no fue encontrada.
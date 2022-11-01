# Java Client Websocket

Esta es una aplicación SpringBoot cliente para conectarse y consumir mensajes a través del servicio de websockets del Core de Deliverar.

En este ejemplo, la aplicación se está conectando como si fuera el módulo cliente. Tener en cuenta modificar la [siguiente línea](https://github.com/roccacamila/javaclient-websocket/blob/main/src/main/java/spring/ConnectToWebSocket.java#L16) y reemplazar `/cliente` por el módulo que corresponda.

Dejamos como ayuda un listado con cómo quedaría modificada esta línea para cada uno de los módulos.
### Listado de conexiones por módulo

Módulo | Conexión
--- | --- |
Cliente | `session.send("/app/cliente", message);` |
Proveedor | `session.send("/app/proveedor", message);` |
Repartidor | `session.send("/app/repartidor", message);` |
Franquicia | `session.send("/app/franquicia", message);` |
Operador | `session.send("/app/operador", message);` |
Partners | `session.send("/app/partners", message);` |
Desarrollo interno | `session.desarrolloInterno("/app/cliente", message);` |
Administrador | `session.send("/app/administrador", message);` |

*De necesitar asistencia extra o más información, contactarse con el Team Core.*

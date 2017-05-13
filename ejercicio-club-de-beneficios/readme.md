Cobertura: 74%. Es más baja que la del resto de los trabajos que corregí. Deberían poder llegar a 100%, pero estoy pidiendo al menos 90%.

Tenés métodos enteros sin probar en "ClubDeBeneficio", que es la clase central del ejercicio. EJ: enviarReporteDeAhorros(Mes mes),
getVentasPorCliente(Cliente cliente, Mes mes),
enviarRegaloMensualASucursal(Mes mes), felicitarEstablecimiento(Mes mes).

Tests:
En general bien, pero veo que el "MailServiceTest" es un test más de integración que unitario
(para probarlo hace falta tener Establecimientos, Sucursales, Beneficios).

Bien por las Exceptions que creaste.

Código general: - "extends Exception{", deberías dejar un espacio entre "Exception" y la "{",
y hay dos espacios entre 'extends' y 'Exception', eso lo ví en ambas clases de excepciones (copy/paste?) -

El resto del código me parece bien! Hay prolijidad y respeta convenciones. Lo único que agregaría es no dejar saltos de línea entre la
línea que tiene el return y la de la llave que cierra el método.

- Otra cosa que no hace falta son los comentarios como "//por cada cliente" cuando haces un for-each. El código se entiende!

- Los números hardcodeados (el 5 y el 100 en Descuento.java), deberían ser constantes. Veremos algo de esto cuando veamos REFACTORING
en la siguiente clase. El modelo me parece que está bien y resuelve el problema.

 El trabajo está para tener una buena nota, pero necesito que re-entregues para mejorar la cobertura, incluír diagramas de secuencia
 (obligatoriamente) y emprolijar un poquito esas cositas del código (opcional, para subir la nota).
 Tengo que felicitarte porque me parece que el ejercicio está bien, pero para cumplir hace falta tener todo bien (cobertura y diagramas!)
 Saludos, Facundo



club de beneficios
==================

Correcciones:

    - Se agregaron los metodos de las clases al diagrama

    - En el diagrama omitì los getters y setters

    - Se agrego MailService al diagrama, y se agrego una nota en Mes en el diagrama de clases ya que estaba sin ninguna relaciòn

    - Se agregaron los tres diagramas de secuencia pedidos en el enunciado



Cambios:
    
    -Cambie el modelo que habia hecho con mis companeros porque algunas cosas no me convencian del todo
    
    -Los descuentos y dos por uno heredan de una misma clase que se llama Beneficio y aplican polimorfismo
    
    -Se agrego la clase venta que representa una venta realizada por una sucursal con un beneficio otorgado
    

Dudas:

    -No se me ocurrio como testear el tema de los mails mas que hacer un assert con el string esperado (me parecio medio una truchada)

Aclaraciones:

    -Me quede flojo con el tema de los test unitarios y con las convenciones si bien aprendi a usar la herramienta 
    
    -No realice los diagramas de secuencia, me gustaria que me den una oportunidad de reentrega si es posible 
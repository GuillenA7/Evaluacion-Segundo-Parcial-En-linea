# Evaluación Segundo Parcial - En línea

Desarrolle una aplicación móvil bajo plataforma Android. El diseño es libre, cumpliendo con el uso de componentes, información y características que se solicitan a continuación:
* El diseño de la **Activity de Ingreso** debe contemplar el ingreso a la aplicación mediante una lista predeterminada de usuarios (Spinner) y una contraseña numérica (caja de texto), además de dos botones: *Ingresar* y *Limpiar*.
* Para el **botón Ingresar** se debe realizar la validación de la contraseña, la cual será para todos *12345*. Mediante Toast debe notificar cuando alguno de los datos es incorrecto. En caso de datos correctos, se manda a la siguiente Activity de Menú.
* Para el **botón Limpiar**, debe borrar el contenido de la contraseña.
* Codificar la clase **Paciente** con cuatro atributos de distinto tipo de dato, usted los determina. Considere el uso de componentes solicitado en el punto 6 (Activity Registrar) para determinar el tipo de dato a utilizar.
* Diseñar la **Activity de menú** (de tipo desplegable) cuyas opciones sean:  *Registrar, Consultar y Salir.*  Declarar un arreglo de objetos de la clase antes mencionada para enviar/recibir como parámetro entre Activity's descritas posteriormente.
* Diseñar la **Activity de Registrar** considerando los atributos de la clase **Paciente**. Debe contar con los  botones para *Registrar, Limpiar y Regresar.* Debe utilizar para entrada de datos, al menos tres componentes de distinto tipo: cajas de texto, botones de opciones (chip, switch, togglebutton) y listas (spinner o  listView).
* En la Activity de *Registrar* el botón **Registrar** debe ingresar la información al arreglo. Aplicar validaciones sobre cajas de texto no vacías. Limpiar los campos una vez almacenado en el arreglo.
* En la Activity de *Registrar* el botón **Limpiar** debe borrar el contenido de los componentes, dejando el formulario en estado inicial.
* En la Activity de *Registrar* el botón **Regresar** debe volver al menú, retornando como parámetro el arreglo de objetos.
* Diseñar la **Activity de Consultar**, utilizando una etiqueta para mostrar la información y un botón de regreso.
* En la Activity de *Consultar* **dentro de una etiqueta** se deben mostrar el contenido de lo capturado dentro del arreglo de objetos.
* En la Activity de Consultar **botón Regresar** debe volver al menú.
* En la Activity de *M*enú la **opción Salir** debe regresar a la activity de ingreso.

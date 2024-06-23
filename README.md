Es un ejercicio de Clases y ArrayList

a) Implementa la clase Alumno en el paquete clase con los atributos privados: código, nombre, nota1 y nota2; un
constructor, los métodos de acceso público set/get, el método promedio, la mayor nota y la menor nota.
b) Implementa la clase ArregloAlumnos en el paquete arreglo con el atributo privado ArrayList alu de tipo Alumno.
Implementa como públicos:
- Un constructor que crea el ArrayList alu de tipo Alumno y autogenera ocho objetos.
- Un método adicionar que recibe la dirección de memoria de un nuevo alumno y lo adiciona al ArrayList.
- Un método tamaño que retorna la cantidad de alumnos registrados hasta ese momento.
- Un método obtener que recibe una posición y retorna la dirección de memoria del alumno respectivo.
- Un método buscar que busca un código y retorna la dirección de memoria del objeto que lo contiene.
En caso no existe retorna null.
- Un método eliminar que recibe la dirección de memoria de un objeto Alumno y lo retira del ArrayList.
c) En la clase Ejemplo declara y crea como variable global un objeto de tipo ArregloAlumnos e implementa el
método listar que visualiza todos los alumnos ingresados.
Implementa la pulsación de los botones:
- Adicionar : adiciona un nuevo alumno verificando que el código no se repita.
- Consultar : busca un código y si existe edita los datos del alumno.
- Modificar : busca un código y si existe modifica los datos de un alumno.
- Eliminar : busca un código y si existe retira al alumno del arreglo.

Formulario:

![image](https://github.com/antonylsalazarr/ArrayList/assets/149880665/7c200d8a-7ad8-4d02-9da5-68ad2b985377)

Luego de modificarse:

![image](https://github.com/antonylsalazarr/ArrayList/assets/149880665/d7f2cc9a-7363-4186-89a9-419c3d1f8235)


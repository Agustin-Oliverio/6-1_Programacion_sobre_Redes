# Programacion-Sobre-Redes
- Alumno: Agustín Ezequiel Oliverio Suárez
- Correo: agustin.oliverioet32@gmail.com
- Curso y División: 6°1 Computación
- Docente: Gonzalo Consorti
- Materia: Programación sobre Redes

*Organización y estructura*
- Las clases estan en ramas que se llaman como el tema visto en clase
- Las guias estan en ramas separadas llamadas igual
- Dentro de las ramas de guias estan las carpetas con los ejercicios

*Consigna*
1) Ingresar datos numéricos (por diferentes orígenes, sin usar la clase Scanner para leer o
escribir e ingresando, por lo menos, 2 veces el numero ‘0’ por cada uno de los orígenes de
datos entrantes e enviarlos a un algoritmo que los almacene en 2 sectores de memoria
distintos:
- volátil (en memoria) – “vectores”, para guardar la información en tiempo real (ingresar
por lo menos 5 valores). Vector de 5 espacios.
- no-volátil (disco) – “archivos de texto”, para guardar y leer los datos del proceso (guardar
por lo menos 5 valores). Uno por cada renglón. //no crear el archivo de texto a mano.


2) Leer los datos numéricos del vector cargado en el punto 1 y generar 2 archivos de salida:
-Por un lado, los resultados de dividir entre cada dato leído y el número que quede de la
siguiente operación (siguiente número del vector - 3) en un archivo “resultados.txt”. Con el
formato en un renglón por cuenta: numero1 / numero2 = resultado
-Y por el otro lado, cada vez que la división tire un error matemático o de falta de algún
número de entrada, guardar el error correspondiente en un archivo “error.txt” ubicado en
la carpeta del proyecto. ”. Con el formato en un renglón por cuenta: numero1 / numero2 =
error

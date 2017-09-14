@echo off

REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
REM Universidad Santiago de Cali (Santiago de Cali - Colombia)
REM Departamento de Ingeniería de Sistemas y Computación
REM Licenciado bajo el esquema Academic Free License version 2.1
REM
REM Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
REM Ejercicio: N1-Elecciones-Java
REM Autor: Joan Andrés Buriticá Salazar
REM ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

SET ClASSPATH=

REM ------------------------------------------------------------
REM Asegura la creación de los directorios classes y lib en test
REM ------------------------------------------------------------

cd ../test
mkdir classes
mkdir lib

REM ---------------------------------------------------------
REM Compila las clases del directotio test/src
REM ---------------------------------------------------------

cd src

javac -classpath ../../lib/elecciones.jar;../lib/junit.jar -d ../classes/ usaca/prax/elecciones/test/*.java

REM ---------------------------------------------------------
REM Crea el archivo jar a partir de los archivos compilados
REM --------------------------------------------------------

cd ../classes

jar cf ../lib/eleccionesTest.jar usaca/* -C ../data .

cd ../../bin

pause
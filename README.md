# ¡Proceso de selección Core Sura - Sofka! 🚀

Este repositorio contiene el desarrollo del componente de automatización web para el proceso de selección al Core de
Sura como Sofkiano con el rol de Analista de Automatización.

Las pruebas están centradas en el sitio web [SauceDemo](https://www.saucedemo.com/) con los siguientes escenarios:

- Inicio de sesión en el sitio web
- Agregar productos al carrito de compras
- Finalizar el proceso de compra

## Información General

| N°  | Item              |        Detalle |
|:---:|:------------------|---------------:|
|  1  | ID del Ejercicio  |     PFA_01_QAN |
|  2  | Java              |        11.0.15 |
|  3  | Gradle            |            7.4 |
|  4  | Navegador         |  Google Chrome |
|  5  | Sistema Operativo | Windows 10 Pro |
|  6  | Rama principal    |         Master |

## Pre-requisitos para ejecutar 📋

- Java: versión 1.8 o superior (variables de entorno configuradas).
- Entorno de desarrollo: Eclipse IDE o IntelliJ IDEA
- Gradle version 7.0 o superior (variables de entorno configuradas).
- Plugin de Cucumber para Java
- Gherkin Plugin

## Ejecutar pruebas 🔨

La herramienta de compilación de código y administrador de dependencias para este proyecto es **Gradle**, así que para
ejecutar las pruebas use el siguiente comando en la raíz del proyecto.

	gradle clean test aggregate -i

Si desea ejecutar algún Runner especifico puede usar el siguiente comando, por ejemplo para el Login.

    gradle clean test --tests "IniciarSesionRunner"

## Navegador Web 🌐

Actualmente la automatización se ejecuta por defecto con Chrome, si desea ampliar sus pruebas en diferentes navegadores
puede realizar esta configuración en el archivo **serenity.conf**

Es importante tener en cuenta que el archivo binario (driver) para que selenium interactue con el navegador es administrado completamente por el core de Serenity BDD, es por ello que no se encontrará con este archivo en la ruta **src/test/resources/drivers/*.exe**.

## Obtener el código

El código de la automatización está alojado en un repositorio de GitHub, para hacer uso de él puede clonarlo usando Git
o descargar el archivo zip del proyecto.

Git:

	 git clone https://github.com/DiegoPinzon20/sura-automation.git
	 cd sura-automation

o simplemente [descargar archivo zip](https://github.com/DiegoPinzon20/sura-automation/archive/refs/heads/master.zip).

## Ver los informes

El comando proporcionado anteriormente para la ejecución de las pruebas, generará un informe final de prueba de Serenity
BDD **index.html** en el directorio target/site/serenity. Adicionalmente, puede encontrar evidencias generadas por
Cucumber en la ruta **target/serenity-reports**, son los siguientes archivos:

- **rerun.txt**: Archivo de texto con la información de la línea donde falló el caso para su revisión en caso de que
  fallara.
- **serenity-html-report.html**: Reporte generado con el resultado de cada uno de los pasos del feature incluido en las
  pruebas.

## Construido con 🛠

La automatización fue desarrollada con:

- BDD - Estrategia de desarrollo guiada por el comportamiento
- POM - Patrón de diseño (Page Object Model)
- Gradle - Administrador de dependencias y del proyecto
- Selenium Web Driver - Herramienta para interactuar con navegadores web
- Cucumber - Herramienta que apoya la implementación de BDD
- Serenity BDD - Librería de código abierto para escribir pruebas de aceptación automatizadas
- Gherkin - Lenguaje DSL de lectura empresarial (lenguaje específico de dominio)

## Versionamiento 📌

Se usó Git para el control de versiones. 🔀

## Autor 👨

**Diego Pinzón** - [diego.pizon@sofka.com.co]()

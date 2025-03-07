# 🏥 Carné de Salud Infantil - Java Standalone App

## 📌 Descripción del Proyecto
Este proyecto es una aplicación de escritorio desarrollada en **Java Standard Edition (Java SE)** para la gestión de un **carné de salud infantil** de niños hasta 5 años. La aplicación permite registrar, consultar y administrar la información médica de los niños, como **vacunas, controles médicos y consultas**.  

El sistema está diseñado para ser utilizado en organizaciones de salud o por padres que deseen llevar un control de la salud de sus hijos.

---

## **Tecnologías Utilizadas**
- **Lenguaje:** Java SE  
- **Entorno de desarrollo:** NetBeans / Eclipse / Visual Studio Code  
- **Paradigma:** Programación Orientada a Objetos (POO)  
- **Persistencia:** Archivos de texto o Base de Datos  
- **Patrón de diseño:** Separación en capas (`logica`, `grafica`, `persistencia`)  
- **Manejo de excepciones y validaciones**  

---

## 🎯 **Características de la Aplicación**
 **Configuración inicial**: Permite definir la cantidad máxima de niños y registros médicos.  
 **Registro de niños**: Nombre, documento, edad y servicio de salud.  
 **Listado de niños**: Muestra los datos generales de los niños ingresados.  
 **Gestión de registros médicos**: Se pueden agregar **vacunas, consultas o controles** a cada niño.  
 **Búsqueda por cédula**: Permite ver todos los datos de un niño y su historial médico.  
 **Filtro de consultas médicas**: Se pueden listar las consultas médicas antes de una fecha específica.  

**Opcionalmente, la aplicación también puede:**  
🔹 Llevar un **registro detallado de las vacunas**, con información sobre dosis y edad recomendada.  
🔹 Verificar si un niño está **al día con sus vacunas** o cuándo debe recibir la próxima dosis.  
🔹 Permitir la **modificación de datos** de los niños y sus registros médicos.  

---

## 📂 **Estructura del Proyecto**
El código está organizado en tres **paquetes** principales para mantener una buena separación de responsabilidades:

📌 **`logica`** → Contiene las clases con la lógica de negocio.  
📌 **`grafica`** → Contiene las clases responsables de la interfaz de usuario.  
📌 **`persistencia`** → Contiene la lógica para guardar y recuperar datos (archivos o base de datos).  

---

## 🛠️ **Cómo Ejecutar el Proyecto**
1. **Clonar el repositorio**  
   ```sh
   git clone https://github.com/usuario/repo.git
   cd repo

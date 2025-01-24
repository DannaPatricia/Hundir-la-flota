# 🛠️ Proyecto: Hundir la Flota

¡Bienvenido/a! Este repositorio contiene un juego clásico de **Hundir la Flota** desarrollado en **Java**. A través de este proyecto, se ha utilizado la Programación Orientada a Objetos (POO), con técnicas como la herencia y la sobrecarga de métodos para crear una versión jugable del famoso juego de mesa.

---

### ✨ Descripción del Proyecto

**Hundir la Flota** es un juego en el que dos jugadores deben colocar sus barcos en un tablero y tratar de hundir los barcos del oponente. Este proyecto implementa los siguientes aspectos clave:

- **Tablero de Juego:** Creación de un tablero 10x10 para cada jugador.
- **Barcos:** Se incluyen barcos de diferentes tamaños (velero, fragata, buque, portaviones).
- **Colocación de Barcos:** La colocación de los barcos en el tablero se realiza de forma aleatoria o manual por el jugador, validando que no haya superposiciones ni que los barcos toquen otras posiciones.
- **Interacción:** Los jugadores realizan disparos en el tablero del oponente para intentar hundir sus barcos.
- **POO:** El proyecto usa clases y objetos para modelar los elementos del juego, como el tablero, las fichas y los barcos.
- **Herencia y Sobrecarga:** Se implementan conceptos de herencia en la creación de clases de barcos, y se utilizan métodos sobrecargados para gestionar las acciones del juego.

---

### 🛠️ Estructura del Proyecto

1. **`Tablero.java`**: Clase principal que maneja los tableros de ambos jugadores, la colocación de los barcos y la verificación de movimientos válidos.
2. **`Ficha.java`**: Clase que representa cada celda en el tablero, indicando si está vacía o ocupada por un barco.
3. **`Juego.java`**: Clase de control que gestiona la lógica del juego (turnos, disparos, y victorias).

---

### Características y Funcionalidades

- **Colocación de Barcos:** Los barcos pueden colocarse horizontal o verticalmente en el tablero. Se verifica que los barcos no se superpongan y que no haya casillas adyacentes ocupadas.
- **Disparos:** Los jugadores se turnan para disparar en las casillas del tablero del oponente. Si la casilla contiene un barco, se marca como "hundido".
- **Visualización del Tablero:** El tablero de cada jugador se muestra en consola con símbolos que representan el estado de las casillas.
- **Comprobaciones:** Se realizan verificaciones para asegurar que los barcos estén colocados correctamente y que el jugador no haya realizado movimientos inválidos.

---

### Requisitos

- **Java 8 o superior**: Asegúrate de tener instalado **Java 8 o una versión posterior** para compilar y ejecutar el proyecto.
- **IDE recomendada**: Usar un entorno de desarrollo como **IntelliJ IDEA**, **Eclipse**, o **NetBeans** para facilitar la edición y ejecución.

---

### 🚀 Ejecución del Proyecto

Para ejecutar el proyecto, sigue estos pasos:

1. Clona el repositorio:
    ```bash
    git clone https://github.com/DannaPatricia/Hundir-la-flota.git
    ```

2. Navega al directorio del proyecto:
    ```bash
    cd Hundir-la-flota
    ```

3. Compila el código:
    ```bash
    javac *.java
    ```

4. Ejecuta el juego:
    ```bash
    java Juego
    ```

---

## 🎨 Capturas de Pantalla

(Pendiente)
---

### Próximos Pasos

- **Mejoras en la interfaz:** Implementar una interfaz gráfica para hacer el juego más interactivo.
- **Desarrollo de AI:** Añadir un algoritmo para que el juego pueda ser jugado contra una inteligencia artificial (IA).
- **Funciones adicionales:** Implementar modos de juego adicionales, como multijugador en línea.

---

## 🤝 Contribuciones

1. Haz un fork del repositorio.
2. Crea una rama para tu funcionalidad:
   ```bash
    git checkout -b mejora-nueva-funcion
3. Realiza los cambios y haz commmit:
   ```bash
   git commit -m "Añadida nueva función X"
4. Haz push a tu rama:
   ```bash
    git push origin mejora-nueva-funcion
5. Crea un pull request desde GitHub.

---
¡Gracias por tu interés en este proyecto! 🚀

---

## Licencia

Este proyecto está bajo la **Licencia MIT**. Puedes ver el texto completo de la licencia a continuación:

---

MIT License

Copyright (c) [año] [Tu nombre o el de tu organización]

Se concede permiso, de forma gratuita, a cualquier persona que obtenga una copia de este software y los archivos asociados, para utilizarlo sin restricciones, incluyendo sin limitación los derechos de usar, copiar, modificar, fusionar, publicar, distribuir, sublicenciar y/o vender copias del software, y permitir a las personas a las que se les proporcione hacerlo, sujeto a las siguientes condiciones:

El aviso de copyright y este aviso de permiso deberán incluirse en todas las copias o partes sustanciales del software.

EL SOFTWARE SE PROPORCIONA "TAL CUAL", SIN GARANTÍA DE NINGÚN TIPO, EXPRESA O IMPLÍCITA, INCLUYENDO PERO NO LIMITÁNDOSE A LAS GARANTÍAS DE COMERCIABILIDAD, APTITUD PARA UN FIN PARTICULAR Y NO INFRACCIÓN. EN NINGÚN CASO LOS AUTORES O TITULARES DEL COPYRIGHT SERÁN RESPONSABLES POR CUALQUIER RECLAMO, DAÑO O CUALQUIER OTRA RESPONSABILIDAD, YA SEA EN UNA ACCIÓN DE CONTRATO, AGRAVIO O DE CUALQUIER OTRA FORMA, QUE SURJA DE O EN CONEXIÓN CON EL SOFTWARE O EL USO O CUALQUIER OTRO TIPO DE ACCIONES EN EL SOFTWARE.

 


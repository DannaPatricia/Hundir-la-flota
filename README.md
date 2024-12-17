🏴‍☠️ Hundir la Flota en Java 🚢
Hundir la Flota es una implementación en Java del popular juego de mesa en el que dos jugadores intentan hundir los barcos del oponente antes de que el suyo sea destruido. ¡Pon a prueba tus habilidades de estrategia en este emocionante juego!

🌟 Características del Proyecto
Este repositorio presenta una solución utilizando Programación Orientada a Objetos (POO), lo que hace que el código sea modular, extensible y fácil de entender. Algunas de las características clave incluyen:

🏗️ Programación Orientada a Objetos (POO):
Clases que representan los diferentes elementos del juego como el tablero, los barcos, los jugadores y las acciones del juego.

👑 Herencia:
Se usa para crear clases base y clases derivadas, lo que permite una estructura más limpia y organizada. Por ejemplo, los tipos de barcos derivan de una clase Barco base.

🚫 Manejo de Excepciones:
Se gestionan excepciones para garantizar que el juego siga funcionando, incluso si el jugador ingresa datos incorrectos (¡como disparos fuera del tablero!).

🔄 Sobrecarga de Métodos:
La sobrecarga de métodos permite múltiples formas de invocar las mismas funcionalidades con distintos parámetros, lo que hace el código más flexible.

🛠️ Requisitos
Java 8 o superior
Un editor de código (recomendados: IntelliJ IDEA o Eclipse)
📥 Instalación
Clona este repositorio en tu máquina local:

bash
Copiar código
git clone https://github.com/DannaPatricia/hundir-la-flota.git
Abre el proyecto en tu editor de código preferido.

Compila y ejecuta el archivo principal (por ejemplo, Main.java) para comenzar a jugar desde la consola.

🎮 Cómo Jugar
El juego comienza con la colocación de barcos en el tablero de 10x10 por ambos jugadores. Los barcos pueden ser colocados horizontal o verticalmente.

Los jugadores se alternan para disparar a las coordenadas del tablero del oponente.

Si un disparo acierta, el barco enemigo pierde vida. Si un barco pierde toda su vida, se hunde.

El primer jugador que hunda todos los barcos del oponente, ¡gana! 🏆

📝 Estructura del Código
Barco.java: Representa un barco en el tablero, incluyendo su tamaño, ubicación y estado (hundido o no).
Tablero.java: Gestiona el tablero del juego, incluyendo la colocación de barcos y la validación de disparos.
Jugador.java: Representa a un jugador y sus acciones durante la partida.
Juego.java: Gestiona la lógica del juego, alternando turnos y determinando el ganador.
Excepciones.java: Contiene las excepciones personalizadas para manejar errores, como coordenadas inválidas.
🤝 Contribuciones
Las contribuciones son bienvenidas. Si tienes sugerencias, mejoras o correcciones de errores, abre un issue o envía un pull request. ¡Todos son bienvenidos! 🎉

📜 Licencia
Este proyecto está licenciado bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

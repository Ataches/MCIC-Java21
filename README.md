# 21 - Black Jack - desarrollo basado en pruebas

## Integrantes

- Lider: Norbey Danilo Muñoz
- Javier Hospital Melo
- Brayan Leonardo Sierra
- Juan Sebastián Sánchez
- Camilo Enrique Rocha
- Ivan Daniel Villegas

### Entorno de desarrollo

```
IntelliJ IDEA
```

## Historias de usuario

### Jugador

- :white_check_mark: __Como__ jugador __quiero__ que al inicio del juego me repartan dos cartas, __para__ calcular si deseo otra carta o me planto.

- :white_check_mark: __Como__ jugador __quiero__ recibir todas las cartas que solicite a la casa siempre y cuando mi mano no supere 21 puntos, __para__ incrementar el valor de mi mano.

- :white_check_mark: __Como__ jugador __quiero__ tener una mano mayor al puntaje de la casa y menor a 21 puntos __para__ ganar el juego.

### Casa

- :white_check_mark:	__Como__ casa __quiero__ que al inicio del juego me repartan dos cartas, __para__ calcular si deseo otra carta o me planto.

- :white_check_mark: __Como__ casa __quiero__ recibir todas las cartas necesarias __para__ intentar llegar a 21 para vencer al jugador.

- :white_check_mark: __Como__ casa __quiero__ realizar el conteo para mi mano y la del jugador __para__ establecer el ganador y terminar la partida.

- :white_check_mark:	__Como__ casa __quiero__ conocer el resultado final del juego __para__ saber el ganador.


## Reglas

- Solo existen 2 jugadores, el jugador real y la computadora
- Existe solo un repartidor, este será la computadora

- La banca también juega pero tiene unas reglas muy definidas que se han de tener en cuenta. Si la suma de las cartas de la banca es 16 o menos, debe pedir carta y si suman 17 o más se debe plantar.

- ¿Cuándo gana y cuando pierde la banca? La banca gana a todos los jugadores que se pasen de 21 y a aquellos que tengan un jugada de menor valor, por otro lado, empata con aquellos jugadores que tengan la misma suma. La mano de la banca pierde con los jugadores que tengan una mano superior a la suya o, si la banca se pasa, con todos aquellos que se plantaron, tengan la suma de puntos que tengan.

- El As es la única carta de la baraja que tiene dos valores, 1 y 11, siendo el jugador que lo posea quien elige el valor entre ambos según le convenga. En caso que la suma con el valor 11 de un valor mayor a 21 el As tendra automaticamente el valor de 1.

- Las cartas numeradas con índice del dos al diez tienen el valor correspondiente a su numeración.

- Por su parte, todas las figuras (Jack, Queen y King), tienen el mismo valor: 10. Importante dato para el jugador, es saber que en 52 cartas, hay 16 con un valor de 10.

- **Plantarse:** Ya sea de inicio o tras haber pedido carta, si el jugador considera que tiene una jugada que puede ganar, o que pedir más cartas podría hacerle pasarse de 21, tiene la opción de cerrar su jugada y esperar el turno del crupier plantándose.

- **Pedir carta:** Con el fin de alcanzar 21 o acercarse lo máximo posible, se pueden pedir tantas cartas como se quieran hasta que se supere la suma objetivo. Si la suma de cartas supera 21 el jugador se ha pasado, se retirarán sus cartas y la apuesta correspondiente a esa mano.

## Pruebas unitarias

### Resultados de las pruebas

![](https://firebasestorage.googleapis.com/v0/b/dinny-chat-develop.appspot.com/o/WhatsApp%20Image%202021-10-01%20at%209.40.56%20PM.jpeg?alt=media&token=b347a7fb-4e03-4bca-be21-74faf84546c2)

![](https://firebasestorage.googleapis.com/v0/b/dinny-chat-develop.appspot.com/o/Captura%20de%20Pantalla%202021-10-01%20a%20la(s)%209.17.25%20p.%C2%A0m..png?alt=media&token=156d520d-b4f1-4088-961b-8752319447ba)

### Cobertura total del código:

![](reports/.img/coverage_total.jpg)

### Carta.java

![](reports/.img/coverage_carta.jpg)

### Ventiuno.java

![](reports/.img/coverage_veintiuno.jpg)

### Jugador.java 

![](reports/.img/coverage_jugador_1.jpg)
![](reports/.img/coverage_jugador_2.jpg)


### GameAsker.java

![](reports/.img/coverage_game_asker.jpg)

## Pruebas de aceptación

### Jugador

![image](https://user-images.githubusercontent.com/24207969/136636184-3ac3de3e-386b-48c5-9df2-cd426f192788.png)

Link: [Reporte de pruebas para jugador](https://github.com/Ataches/MCIC-Java21/blob/master/reports/Reporte_de_prueba_jugador.html)

### Casa

![image](https://user-images.githubusercontent.com/24207969/136636211-8b51ee05-df1b-4561-ae4c-b0e109363b04.png)

![image](https://user-images.githubusercontent.com/24207969/136636226-e4375b39-22c6-4031-9868-8c891e91b7e4.png)

Link: [Reporte de pruebas para casa](https://github.com/Ataches/MCIC-Java21/blob/master/reports/Reporte_de_prueba_casa.html)

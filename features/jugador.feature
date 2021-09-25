Feature: jugador juego 21
Esta Feature verifica las funcionalidades del jugador en el juego 21

Scenario: verificar que al jugador le repartan dos cartas. 
Given un jugador
When el juego inicia
Then el jugador tiene dos cartas

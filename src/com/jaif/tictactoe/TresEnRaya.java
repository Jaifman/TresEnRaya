package com.jaif.tictactoe;

public class TresEnRaya {
	
	//Declaramos atributos de la clase
	private Tablero tablero;
	private Jugador[] jugadores;
	private Turno turno;
	
	//Constructor de la clase
	public TresEnRaya(){
		//Intanciamos el tablero sobre el que se jugará
		tablero = new Tablero();
		//Creamos el número de jugadores
		jugadores = new Jugador[2];
		//Creamos a cada jugador asignándolo a un tipo de fichas
		jugadores[0] = new Jugador('x');
		jugadores [1] = new Jugador('o');
		//Creamos el objeto que maneja los turnos de juego
		turno = new Turno();
	}
	//Método que contiene la lógica del programa
	public void jugar(){
		
		do{
			//Hacemos visible el tablero
			tablero.mostrar();
			
			if(!tablero.estaCompleto(jugadores[turno.esTurno()])){				
				//Obtenemos el turno del jugador y establecemos su movimiento
				jugadores[turno.esTurno()].setFicha(tablero);				
			}else{
				//Ejecutamos el movimiento
				jugadores[turno.esTurno()].moverFicha(tablero);
			}			
			//Pasamos el turno al siguiente jugador
			turno.cambiar();
			
		}while(tablero.hayTresEnRaya());
		//Establecemos el vencedor
		jugadores[turno.noEsTurno()].esVencedor();
		
	}

}

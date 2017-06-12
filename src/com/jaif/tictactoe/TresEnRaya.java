package com.jaif.tictactoe;

public class TresEnRaya {
	
	//Declaramos atributos de la clase
	private Tablero tablero;
	private Jugador[] jugadores;
	private Turno turno;
	
	//Constructor de la clase
	public TresEnRaya(){
		//Intanciamos el tablero sobre el que se jugar�
		tablero = new Tablero();
		//Creamos el n�mero de jugadores
		jugadores = new Jugador[2];
		//Creamos a cada jugador asign�ndolo a un tipo de fichas
		jugadores[0] = new Jugador('x');
		jugadores [1] = new Jugador('o');
		//Creamos el objeto que maneja los turnos de juego
		turno = new Turno();
	}
	//M�todo que contiene la l�gica del programa
	public void jugar(){
		
	}

}

package com.jaif.tictactoe;

import java.util.Random;

public class Turno {
	
	private int valor;
	
	//Establecemos el turno inicial de forma aleatoria
	public Turno(){	
		
		valor = new Random().nextInt(2);
		
	}
	
	//M�todo que devuelve a quien le toca jugar
	public int esTurno() {
		
		return valor;
		
	}
	
	//M�todo que devuelve a quien no le toca jugar
	public int noEsTurno() {	
		
		return (valor+1)%2;
		
	}	
	
	//M�todo para cambiar el turno
	public void cambiar() {	
		
		this.noEsTurno();
		
	}	

}

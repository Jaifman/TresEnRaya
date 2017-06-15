package com.jaif.tictactoe;

import java.util.Scanner;

public class Coordenada {
	
	//Declaraci�n de atributos
	private int fila;
	private int columna;
	private static final Intervalo LIMITES = new Intervalo(1,3);
	
	//Constructor sin par�metros
	public Coordenada(){
		
	}
	
	//Constructor con par�metros
	public Coordenada(int fila, int columna){
		
		this.fila = fila;
		this.columna = columna;
		
	}
	
	//Getters
	public int getFila() {
		
		return fila;
		
	}

	public int getColumna() {
		
		return columna;
		
	}
	
	//M�todo que comprueba si una casilla coincide
	public boolean igual(Coordenada coordenada){
		
		return fila == coordenada.fila && columna == coordenada.columna;
		
	}
	
	//M�todo que recoge input del jugador
	public void obtener() {
		
		boolean error = false;
		Scanner sc = new Scanner(System.in);
		
		do{
			
			System.out.println("Introduzca fila (1,3): ");
			fila = sc.nextInt();
			System.out.println("Introduzca columna (1,3): ");
			columna = sc.nextInt();
			error = !this.valida();
			
			if(error){
				
				System.out.println("Error: Valores fuera de rango");
				
			}
			
		}while(error);
		
	}
	
	//Comprueba que las coordenadas del usuario est�n dentro del rango
	public boolean valida() {
		
		return LIMITES.incluye(fila) && LIMITES.incluye(columna);
		
	}
	
	//M�todo que comprueba donde ha colocado el jugador su ficha
	public int direccion(Coordenada coordenada) {
		
		if(fila == coordenada.fila){
			return 0;
		}
		if(columna == coordenada.columna){
			return 1;
		}
		if (fila - coordenada.fila == 0 && columna - coordenada.columna == 0 ){
			return 2;
		}
		if (fila + coordenada.fila == 4 && columna + coordenada.columna == 4){
			return 3;
		}
		
		return -1;
		
	}	

}

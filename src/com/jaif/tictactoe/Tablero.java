package com.jaif.tictactoe;

public class Tablero {
	
	//Declaramos atributos 
	//private char[][] casillas;
	private Coordenada[][] fichas;
	private static final int DIMENSION = 3;
	private static final char VACIA = '_';
	
	//Constructor de la clase
	public Tablero(){
		
		//Establecemos el tablero con 3x3 casillas sin rellenar
		fichas = new Coordenada[2][3];		
		
	}
	
	//Mostramos el tablero
	public void mostrar() {	
		
		for (int i = 0; i < DIMENSION; i++) {
			
			for (int j = 0; j < DIMENSION; j++) {	
				
				System.out.print(this.getFicha(new Coordenada(i,j)));	
				
			}
			
			System.out.println("\n");
			
		}
		
		System.out.println("\n");
		
	}
	
	//Métodos privados de apoyo al método mostrar()
	private char getFicha(Coordenada coordenada){
		
		if(this.incluye(coordenada,0)){
			
			return 'o';
		
		}if(this.incluye(coordenada,1)){
			
			return 'x';
		
		}
		return VACIA;
	}
	
	private boolean incluye(Coordenada coordenada,int jugador){
		
		for (int i = 0; i < fichas[jugador].length; i++) {
			
			if(fichas[jugador][i]!=null && fichas[jugador][i].igual(coordenada)){
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	//Método que determina si hay 3 en raya
	public boolean hayTresEnRaya() {
		
		return this.hayTresEnRaya('x') || this.hayTresEnRaya('o');
		
	}
	
	//Método que contiene el algoritmo para determinar si hay 3 en raya
	private boolean hayTresEnRaya(int jugador){
		
		int direccion = fichas[jugador][0].direccion(fichas[jugador][1]);
		
		if(direccion == -1){
			
			return false;
			
		}
		
		return direccion == fichas[jugador][1].direccion(fichas[jugador][2]);
		
	}
	
	//Método para comprobar que el jugador ha agotado sus fichas
	public boolean estaCompleto(Jugador jugador){
		
		int fila = this.getFila(jugador.getFicha());	
		int contador = 0;		
				
		for (int i = 0; i < fichas[fila].length; i++) {
			if(fichas[fila][i] != null){
				
				contador++;
				
			}
			
		}
		
		return contador == DIMENSION;
		
	}	
	
	//Método que devuelve casillas ocupadas
	public boolean ocupado(Coordenada coordenada, char ficha){
		
		int fila = this.getFila(ficha);		
		
		for (int i = 0; i < fichas[fila].length; i++) {
			
			if(fichas[fila][i] != null && fichas[fila][i].igual(coordenada)){
				
				return true;
				
			}
			
		}
		
		return false;
		
	}
	
	//Método que devuelve casillas ocupadas por una ficha determinada
	public boolean ocupado(Coordenada coordenada){
		
		return !this.ocupado(coordenada,VACIA);
		
	}
	
	//Método para colocar ficha
	public void setFicha(Coordenada coordenada, char ficha) {
		
		int fila = this.getFila(ficha);
		int i = 0;		
		
		while(fichas[fila][i] != null){
			i++;
		}
		
		fichas[fila][i] = coordenada;
	}
	
	private int getFila(char ficha){
				
		if(ficha == 'o'){
			
			return 0;
					
		}
		
		return 1;			
		
	}
	
	//Método para retirar una ficha
	public void retirarFicha(Coordenada coordenada){
		
		for (int i = 0; i < fichas.length; i++) {
			
			for (int j = 0; j < fichas[i].length; j++) {
				
				if(fichas[i][j] != null && fichas[i][j].igual(coordenada)){
					
					fichas[i][j] = null;
				}
				
			}
		}
	}

}

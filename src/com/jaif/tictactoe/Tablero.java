package com.jaif.tictactoe;

public class Tablero {
	
	//Declaramos atributos 
	private char[][] casillas;
	private static final int DIMENSION = 3;
	private static final char VACIA = '_';
	
	//Constructor de la clase
	public Tablero(){
		//Establecemos el tablero con 3x3 casillas sin rellenar
		casillas = new char[DIMENSION][DIMENSION];
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++){
				casillas[i][j] = VACIA;
			}
		}
		
	}
	
	//Mostramos el tablero
	public void mostrar() {	
		
		for (int i = 0; i < DIMENSION; i++) {
			
			for (int j = 0; j < DIMENSION; j++) {	
				
				System.out.print(" "+casillas[i][j]);	
				
			}
			
			System.out.println("\n");
			
		}
		
		System.out.println("\n");
		
	}
	
	//Método que determina si hay 3 en raya
	public boolean hayTresEnRaya() {
		
		return this.hayTresEnRaya('x') || this.hayTresEnRaya('o');
		
	}
	
	//Método que contiene el algoritmo para determinar si hay 3 en raya
	private boolean hayTresEnRaya(char ficha){
		
		int filas[] = new int[DIMENSION];
		int columnas[] = new int[DIMENSION];
		int diagonal = 0;
		int secundaria = 0;
		
		//Comprobamos fichas y sumamos posicionalmente para llegar a 3
		for (int i = 0; i < DIMENSION; i++) {
			
			for (int j = 0; j < DIMENSION; j++){
				
				if(ficha==casillas[i][j]){
					
					filas[i]++;
					columnas[j]++;
					
					if(i==j){
						
						diagonal++;
						
					}if(i+j==2){
						
						secundaria++;
						
					}
				}
			}
		}
		//Si alguna de las posibilidades suma 3 ya tenemos ganador
		if(diagonal==3 || secundaria==3){
			
			return true;
			
		}else{
			
			for (int i = 0; i < 3; i++) {
				
				if(filas[i]==3 || columnas[i]==3){
					
					return true;
					
				}
			}
		}
		
		return false;
		
	}
	
	//Método para comprobar que el jugador ha agotado sus fichas
	public boolean estaCompleto(Jugador jugador) {
		int fichas = 0;
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++){
				if(jugador.getFicha()==casillas[i][j]){
					fichas++;
				}
			}
		}
		
		return fichas == DIMENSION;
	}	
	
	//Método que devuelve casillas ocupadas
	public boolean ocupado(Coordenada coordenada) {
		
		return !this.ocupado(coordenada,VACIA);
		
	}
	
	//Método que devuelve casillas ocupadas por una ficha determinada
		public boolean ocupado(Coordenada coordenada, char ficha){
			
			return casillas[coordenada.getFila()-1][coordenada.getColumna()-1] == ficha;
			
		}
	
	//Método para colocar ficha
	public void setFicha(Coordenada coordenada, char ficha) {
		
		casillas[coordenada.getFila()-1][coordenada.getColumna()-1] = ficha;
		
	}
	
	//Método para retirar una ficha
	public void retirarFicha(Coordenada coordenada){
		this.setFicha(coordenada, VACIA);
	}

}

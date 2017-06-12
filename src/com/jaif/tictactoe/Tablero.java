package com.jaif.tictactoe;

public class Tablero {
	
	//Declaramos variables 
	private char[][] casillas;
	
	//Constructor de la clase
	public Tablero(){
		//Establecemos el tablero con 3x3 casillas
		casillas = new char[3][3];
	}
	
	//Mostramos el tablero
	public void mostrar() {		
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++) {
				
				casillas[i][j] = '_';
				
				System.out.print(" "+casillas[i][j]);
				
			}			
			System.out.println("\n");			
		}
	}
	
	//Método que determina si hay 3 en raya
	public boolean hayTresEnRaya() {
		
		return this.hayTresEnRaya('x') || this.hayTresEnRaya('o');
	}
	
	//Método que contiene el algoritmo para determinar si hay 3 en raya
	private boolean hayTresEnRaya(char ficha){
		
		int filas[] = new int[3];
		int columnas[] = new int[3];
		int diagonal = 0;
		int secundaria = 0;
		
		//Comprobamos fichas y sumamos posicionalmente para llegar a 3
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++){
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
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[i].length; j++){
				if(jugador.getFicha()==casillas[i][j]){
					fichas++;
				}
			}
		}
		
		return fichas == 3;
	}

	public boolean ocupado(Coordenada coordenada) {
		return casillas[coordenada.getFila()][coordenada.getColumna()] != '_';
	}

	public void setFicha(Coordenada coordenada, char ficha) {		
		
	}	

}

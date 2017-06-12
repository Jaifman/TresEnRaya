package com.jaif.tictactoe;

public class Jugador {
	
	private char ficha;
	
	//Contructor con parámetro para establecer tipo de ficha del jugador
	public Jugador(char ficha ) {
		this.ficha = ficha;
	}
	
	//Método para obtener la ficha
	public char getFicha() {		
		return ficha;
	}
	
	//Método para establecer la ficha en el tablero
	public void setFicha(Tablero tablero) {
		Coordenada coordenada = new Coordenada();
		do{
			coordenada.obtener();
		}while(!coordenada.valida() || tablero.ocupado(coordenada));
		
		tablero.setFicha(coordenada, ficha);
	}
	
	//Método que mueve las fichas de los jugadores
	public void moverFicha(Tablero tablero) {		
				
		
	}
	
	//Método para mostrar por pantalla al vencedor
	public void esVencedor() {		
		System.out.println("Enhorabuena. El jugador con "+ficha+ " ha ganado");
	}	

}

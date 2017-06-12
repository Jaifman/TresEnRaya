package com.jaif.tictactoe;

public class Jugador {
	
	private char ficha;
	
	//Contructor con par�metro para establecer tipo de ficha del jugador
	public Jugador(char ficha ) {
		this.ficha = ficha;
	}
	
	//M�todo para obtener la ficha
	public char getFicha() {		
		return ficha;
	}
	
	//M�todo para establecer la ficha en el tablero
	public void setFicha(Tablero tablero) {
		Coordenada coordenada = new Coordenada();
		do{
			coordenada.obtener();
		}while(!coordenada.valida() || tablero.ocupado(coordenada));
		
		tablero.setFicha(coordenada, ficha);
	}
	
	//M�todo que mueve las fichas de los jugadores
	public void moverFicha(Tablero tablero) {		
				
		
	}
	
	//M�todo para mostrar por pantalla al vencedor
	public void esVencedor() {		
		System.out.println("Enhorabuena. El jugador con "+ficha+ " ha ganado");
	}	

}

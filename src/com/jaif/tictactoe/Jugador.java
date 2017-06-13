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
		this.setFicha(tablero,null);
	}
	
	public void setFicha(Tablero tablero,Coordenada coordenadaRepe){
		System.out.println("Turno del jugador "+ficha+"\n");
		tablero.setFicha(this.getCoordenadaPuestaValida(tablero, coordenadaRepe),ficha);
	}
	
	private Coordenada getCoordenadaPuestaValida(Tablero tablero, Coordenada coordenadaRepe){
		Coordenada resultado = new Coordenada();
		String error = "";
		do{
			resultado.obtener();
			error = this.errorPuesta(tablero, resultado, coordenadaRepe);
			if(!error.equals("")){
				System.out.println("Error: "+error+"\n");
			}
					
		}while(!error.equals(""));
		
		return resultado;
		
	}
	
	//Método que comprueba que no se pisen las fichas
	private String errorPuesta(Tablero tablero, Coordenada coordenada, Coordenada coordenadaRepe){
		
		if(tablero.ocupado(coordenada)){
			
			return "Coordenada ya ocupada";
			
		}if (coordenadaRepe != null && coordenadaRepe.igual(coordenada)){
			
			return "No se puede colocar donde se retiró la ficha";
			
		}
				
		return "";
		
	}
	
	//Método que mueve las fichas de los jugadores
	public void moverFicha(Tablero tablero) {
		
		System.out.println("Turno del jugador con ficha: "+ficha+"\n");		
		Coordenada retirada = this.getCoordenadaRetiradaValida(tablero);
		tablero.retirarFicha(retirada);
		this.setFicha(tablero,retirada);			
		
	}
	
	private Coordenada getCoordenadaRetiradaValida(Tablero tablero){
		Coordenada resultado = new Coordenada();
		String error = "";
		
		do{
			resultado.obtener();
			error = this.errorRetirada(tablero, resultado);
			
			if(!error.equals("")){
				
				System.out.println("Error: "+error+"\n");
				
			}
					
		}while(!error.equals(""));
		
		return resultado;
	}
	
	private String errorRetirada(Tablero tablero, Coordenada coordenada){
		
		if(!tablero.ocupado(coordenada,ficha)){
			
			return "Coordenada no ocupada en el tablero por una ficha"+ficha;
			
		}
		
		return "";
	}
	
	//Método para mostrar por pantalla al vencedor
	public void esVencedor() {		
		System.out.println("Enhorabuena. El jugador con "+ficha+ " ha ganado");
	}	

}

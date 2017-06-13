package com.jaif.tictactoe;

public class Intervalo {
	
	//Declaramos atributos
	private double inferior;
	private double superior;
	
	//Constructor con parámetros
	public Intervalo(double inferior,double superior){
		
		this.inferior = inferior;
		this.superior = superior;
		
	}
	
	//Método que comprueba si los números se encuentran en el intervalo
	public boolean incluye(double valor){
		
		return inferior<=valor && valor <= superior;
		
	}	
	
}

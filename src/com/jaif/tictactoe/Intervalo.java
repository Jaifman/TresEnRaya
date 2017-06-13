package com.jaif.tictactoe;

public class Intervalo {
	
	//Declaramos atributos
	private double inferior;
	private double superior;
	
	//Constructor con par�metros
	public Intervalo(double inferior,double superior){
		
		this.inferior = inferior;
		this.superior = superior;
		
	}
	
	//M�todo que comprueba si los n�meros se encuentran en el intervalo
	public boolean incluye(double valor){
		
		return inferior<=valor && valor <= superior;
		
	}	
	
}

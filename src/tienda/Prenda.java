package tienda;

import java.io.Serializable;

public class Prenda implements Serializable {
	
	// Atributos
	private String tipo;
	private String talla;
	private double precio;
	private String color;
	private boolean disponible;
	
	// Constructores
	public Prenda(String tipo, String talla, double precio, String color, boolean disponible) {
		this.tipo = tipo;
		this.talla = talla;
		this.precio = precio;
		this.color = color;
		this.disponible = disponible;
	}
	public Prenda(String tipo, String talla, double precio, String color) {
		this.tipo = tipo;
		this.talla = talla;
		this.precio = precio;
		this.color = color;
		this.disponible = true;
	}
	
	// Getters, Setters
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getTalla() {
		return talla;
	}
	public void setTalla(String talla) {
		this.talla = talla;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public boolean isDisponible() {
		return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	

}
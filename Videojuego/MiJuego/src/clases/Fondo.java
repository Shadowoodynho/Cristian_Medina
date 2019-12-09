package clases;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;

public class Fondo {
	private int x;
	private int y;
	private int velocidad;
	private String indiceImagen;
	
	public Fondo(int x, int y, int velocidad, String indiceImagen) {
		super();
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
		this.indiceImagen = indiceImagen;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public String getIndiceImagen() {
		return indiceImagen;
	}

	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}
	
	public void pintar(GraphicsContext graficos) {
		graficos.drawImage(Juego.imagenes.get(indiceImagen), x, y);
		
	}
	public void mover() {
		/*if(Juego.accion) {
			this.velocidad=20;
			}
		else {
			this.velocidad=10;
			}*/
		if(Juego.derecha)
			
			x-=velocidad;
		if(Juego.izquierda)
			x+=velocidad;
		}
	}

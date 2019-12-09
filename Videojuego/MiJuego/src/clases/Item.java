package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Item {
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private HashMap<String, Animacion> items;
	private String indiceImagen;
	private boolean capturado;
	public Item(int x, int y, int ancho, int alto, String indiceImagen) {
		super();
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.indiceImagen = indiceImagen;
	}
	
	public void pintar(GraphicsContext graficos) {
		if (!capturado)
			graficos.drawImage(Juego.imagenes.get(indiceImagen), this.x, this.y);
		//graficos.fillRect(this.x, this.y, 18, 18);
	}
	
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, 18, 18);
	}
	
	/*public void inicializarItems() {
		items = new HashMap<String, Animacion>();
		Rectangle coordenadasCorrer[]= {
				new Rectangle(0, 0, 85, 106),
				new Rectangle(85, 0 , 85, 106),
				new Rectangle(170, 0 , 85, 1068),
				new Rectangle(255, 0 , 85, 106),
				new Rectangle(340, 0, 85, 106),
				new Rectangle(425, 0, 85, 106),
		}
	}*/
	
	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
}

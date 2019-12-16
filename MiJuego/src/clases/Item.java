package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Item extends Base{
	private int ancho;
	private int alto;
	private HashMap<String, Animacion> items;
	private String animacionActual;
	private String indiceImagen;
	private boolean capturado;
	private Animacion animaciones;
	private int xImagen;
	private int yImagen;
	private int anchoImagen;
	private int altoImagen;
	private int velocidad;
	
	
	
	public Item(int x, int y, int ancho, int alto, String indiceImagen) {
		super(x, y);
		this.ancho = ancho;
		this.alto = alto;
		this.indiceImagen = indiceImagen;
	}

	public void pintar(GraphicsContext graficos) {
		if (!capturado)
			graficos.drawImage(Juego.imagenes.get(indiceImagen), this.x, this.y);
		
		//graficos.fillRect(this.x, this.y, 18, 18);
	}
	public boolean isCapturado() {
		return capturado;
	}

	public void setCapturado(boolean capturado) {
		this.capturado = capturado;
	}
	public void actualizarAnimacion(double t) {
		Rectangle coordenadasActuales = this.animaciones.get(animacionActual).calcularFrame(t);
		this.xImagen = (int)coordenadasActuales.getX();
		this.yImagen = (int)coordenadasActuales.getY();
		this.anchoImagen = (int)coordenadasActuales.getWidth();
		this.altoImagen = (int)coordenadasActuales.getHeight();
	}
	public Rectangle obtenerRectangulo() {
		return new Rectangle(this.x, this.y, this.anchoImagen, this.altoImagen);
	}
	
	public void inicializarAnimaciones() {
			items = new HashMap<String, Animacion>();
			Rectangle coordenadasItems[]= {
					new Rectangle(0, 0, 85, 106),
					new Rectangle(85, 0 , 85, 106),
					new Rectangle(170, 0 , 85, 1068),
					new Rectangle(255, 0 , 85, 106),
					new Rectangle(340, 0, 85, 106),
					new Rectangle(425, 0, 85, 106),
					
				
			};
	}
	public Item(int tipoItem,int x, int y, String indiceImagen, int velocidad){
		super(x,y);
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
		//this.invertir = invertir;
		switch(tipoItem){
			case 1:
				this.altoImagen = 42;
				this.anchoImagen = 40;
				this.xImagen = 0;
				this.yImagen = 0;
			break;
	
		}
	}	
	public void pintar1(GraphicsContext graficos) {
			graficos.drawImage(
				Juego.imagenes.get(this.indiceImagen), 
				this.xImagen, this.yImagen, 
				this.anchoImagen, this.altoImagen, 
				this.x--, this.y,
				this.anchoImagen, this.altoImagen
			);
	}
}
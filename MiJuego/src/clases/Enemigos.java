package clases;

import java.util.HashMap;

import implementacion.Juego;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

public class Enemigos extends Base {
	private int altoImagen;
	private int anchoImagen;
	private int xImagen;
	private int yImagen;
	private Animacion animaciones;
	private String indiceImagen;
	private int velocidad;
	private HashMap<String, Animacion>enemigos;
	
	public Enemigos(int x, int y, int altoImagen, int anchoImagen, int xImagen, int yImagen, String indiceImagen,
			int velocidad) {
		super(x, y);
		this.altoImagen = altoImagen;
		this.anchoImagen = anchoImagen;
		this.xImagen = xImagen;
		this.yImagen = yImagen;
		this.indiceImagen = indiceImagen;
		this.velocidad = velocidad;
	}
		public Enemigos(int tipoEnemigos,int x, int y, String indiceImagen, int velocidad){
			super(x,y);
			this.indiceImagen = indiceImagen;
			this.velocidad = velocidad;
		    //this.invertir = invertir;
			switch(tipoEnemigos){
				case 1:
					this.altoImagen =70;
					this.anchoImagen = 90;
					this.xImagen = 0;
					this.yImagen = 0;
				break;
				case 2:
					this.altoImagen = 70;
					this.anchoImagen = 90;
					this.xImagen = 0;
					this.yImagen = 70;
				break;
			}
		}
	public int getAltoImagen() {
		return altoImagen;
	}
	public void setAltoImagen(int altoImagen) {
		this.altoImagen = altoImagen;
	}
	public int getAnchoImagen() {
		return anchoImagen;
	}
	public void setAnchoImagen(int anchoImagen) {
		this.anchoImagen = anchoImagen;
	}
	public int getxImagen() {
		return xImagen;
	}
	public void setxImagen(int xImagen) {
		this.xImagen = xImagen;
	}
	public int getyImagen() {
		return yImagen;
	}
	public void setyImagen(int yImagen) {
		this.yImagen = yImagen;
	}
	public String getIndiceImagen() {
		return indiceImagen;
	}
	public void setIndiceImagen(String indiceImagen) {
		this.indiceImagen = indiceImagen;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	public void pintar2(GraphicsContext graficos) {
		graficos.drawImage(
			Juego.imagenes.get(this.indiceImagen), 
			this.xImagen, this.yImagen, 
			this.anchoImagen, this.altoImagen, 
			this.x--, this.y,
			this.anchoImagen, this.altoImagen
		);
	}

	public void actualizarAnimacion(double t) {
		String animacionActual = null;
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
		enemigos = new HashMap<String, Animacion>();
		Rectangle coordenadasenemigos[]= {
				new Rectangle(0, 0, 85, 106),
				new Rectangle(85, 0 , 85, 106),
				new Rectangle(170, 0 , 85, 1068),
				new Rectangle(255, 0 , 85, 106),
				new Rectangle(340, 0, 85, 106),
				new Rectangle(425, 0, 85, 106),
				
			
		};
}
}
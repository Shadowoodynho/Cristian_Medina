package implementacion;


import java.util.ArrayList;
import java.util.HashMap;

import clases.Enemigos;
import clases.Fondo;
import clases.Item;
import clases.JugadorAnimado;
import clases.Tile;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Juego extends Application{
	private Scene escena;
	private Group root;
	private Canvas canvas;
	private GraphicsContext graficos;
	private int puntuacion = 0;
	//private Jugador jugador;
	private int y;
	private JugadorAnimado jugadorAnimado;
	private Fondo fondo1;
	public static boolean derecha=false;
	public static boolean izquierda=false;
	public static boolean arriba=false;
	public static boolean abajo=false;
	public static boolean salto=false;
	public static HashMap<String, Image> imagenes; //Shift+Ctrl+O
	private ArrayList<Item> item;
	private Item item2;
	private Item item3;
	//private ArrayList<Image> imagenes;
	
	private ArrayList<Tile> tiles;
	private ArrayList<Enemigos> enemigos;
	//private ArrayList<Item> items;
	
	private int[][] mapa = {
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
			{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},{0,0,0,1,0,0,1,2},
		
	};
	private int[][] enemigos1 = {
			{0,0,0,0,0,0,2},
			{0,0,0,1,0,0,1},
			{0,0,0,1,0,0,1},
			{0,0,0,1,0,0,1},
			{0,0,0,0,0,0,1},
			{0,0,0,1,0,0,1},
			{0,0,0,1,0,0,1},
			{0,0,0,1,0,0,1},
			{1,0,0,0,0,0,1},
			{0,0,0,1,0,0,1},
			{0,0,0,1,0,0,1},
			{0,0,0,1,0,0,1},
	};
	private int[][] monedas = {
			{0,0,0,0,0,0,0},
			{0,0,1,0,0,0,0},
			{0,0,1,0,0,0,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,1,0,0,1,0},
			{0,0,1,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0},
			{0,0,0,0,0,1,0},
			{0,0,0,0,0,0,0},
	};
	
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage ventana) throws Exception {
		inicializarComponentes();
		graficos = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		ventana.setScene(escena);
		ventana.setTitle("THE KNIGTH");
		gestionarEventos();
		ventana.show();
		cicloJuego();		
	}
	
	public void inicializarComponentes() {
		//jugador = new Jugador(-50,400,"goku",1);
		jugadorAnimado = new JugadorAnimado(50,330,"knight",4 , "correr");
		fondo1 = new Fondo(0 ,0 ,5 ,"fondo1");
		root = new Group();
		escena = new Scene(root,1000,500);
		canvas  = new Canvas(1000,500);
		imagenes = new HashMap<String,Image>();
		
		cargarImagenes();
		cargarTiles();
		cargarEnemigos();
		cargarItem();
		
		//item = new Item(200,350,0,0,"item");
		//item2 = new Item(400,350,0,0,"item");
		//item3 = new Item(600,350,0,0,"item");
		

	}
	
	public void cargarImagenes() {
		imagenes.put("tilemap", new Image("tilemap.png"));
		imagenes.put("item", new Image("item.png"));
		imagenes.put("knight", new Image("knight.png"));
		imagenes.put("enemigos", new Image("enemigo.png"));
		imagenes.put("fondo1", new Image("background.jpg"));
	}
	
 	public void pintar() { 
		graficos.setFill(Color.LIGHTBLUE);
		graficos.fillRect( 0, 0, 1000, 500);
		//jugador.pintar(graficos);
		fondo1.pintar(graficos);
		graficos.setFill( Color.BLACK);
		 graficos.fillText("Puntuacion: " + puntuacion, 10, 10);
		 graficos.setFill( Color.BLACK);
		 graficos.fillText("Puntuacion: " + puntuacion, 100, 10);
		///Pintar tiles
		for (int i=0;i<tiles.size();i++)
			tiles.get(i).pintar(graficos);
		for (int i=0;i<enemigos.size();i++)
			enemigos.get(i).pintar2(graficos);
		for (int i=0;i<item.size();i++)
			item.get(i).pintar1(graficos);

		
		jugadorAnimado.pintar(graficos);
		
		//item.pintar(graficos);item2.pintar(graficos);item3.pintar(graficos);
		/*item4.pintar(graficos);item5.pintar(graficos);item6.pintar(graficos);
		item7.pintar(graficos);item8.pintar(graficos);item9.pintar(graficos);
		item10.pintar(graficos);item11.pintar(graficos);item12.pintar(graficos);
		item13.pintar(graficos);item14.pintar(graficos);item15.pintar(graficos);*/
		
		
		

	}
	
	public void cargarTiles() {
		tiles = new ArrayList<Tile>();
		for(int i=0; i<mapa.length; i++) {
			for(int j=0; j<mapa[i].length; j++) {
				if (mapa[i][j]!=0)
					tiles.add(new Tile(mapa[i][j], i*70, j*70, "tilemap",0));
			}
		}
	}
	public void cargarEnemigos() {
		enemigos = new ArrayList<Enemigos>();
		for(int i=0; i<enemigos1.length; i++) {
			for(int j=0; j<enemigos1[i].length; j++) {
				if (enemigos1[i][j]!=0)
					enemigos.add(new Enemigos(enemigos1[i][j], i*70, j*70, "enemigo",0));
			}
		}
	}
	public void cargarItem() {
		item = new ArrayList<Item>();
		for(int i=0; i<monedas.length; i++) {
			for(int j=0; j<monedas[i].length; j++) {
				if (monedas[i][j]!=0)
					item.add(new Item(monedas[i][j], i*70, j*70, "item",0));
			}
		}
	}
	/*public void colisionItems() {
		for (int i = 0; i < item.size(); i++) {
			jugadorAnimado.verificarColisiones(item.get(i));
			
		}*/
	
	public void gestionarEventos() {
		//Evento cuando se presiona una tecla
		escena.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent evento) {
					//Aqui tengo que poner el codigo para identificar cuando se presiono una tecla
					switch (evento.getCode().toString()) {
						case "RIGHT"://derecha
							derecha=true;
							
							break;
						case "LEFT": //derecha
							izquierda=true;
						break;
						case "UP":
							if(arriba=true)
							break;
						case "DOWN":
							abajo=true;
							break;
						case "SPACE":
							jugadorAnimado.setVelocidad(5);
							//jugador.setIndiceImagen("goku-furioso");
							break;
						
						}
					}
			}			
		);
		
		escena.setOnKeyReleased(new EventHandler<KeyEvent>() {

			@Override
			public void handle(KeyEvent evento) {
				//Aqui tengo que poner el codigo para identificar cuando se soltó una tecla
				switch (evento.getCode().toString()) {
				case "RIGHT": //derecha
					derecha=false;
					break;
				case "LEFT": //derecha
					izquierda=false;
				break;
				case "UP":
					arriba=false;
					break;
				case "DOWN":
					abajo=false;
					break;
				case "SPACE":
					jugadorAnimado.setVelocidad(1);
					//jugador.setIndiceImagen("goku");
					break;
			}
				
			}
			
		});
		
	}
	
	public void cicloJuego() {
		long tiempoInicial = System.nanoTime();
		AnimationTimer animationTimer = new AnimationTimer() {
			//Esta rutina simula un ciclo de 60FPS
			@Override
			public void handle(long tiempoActualNanoSegundos) {
				double t = (tiempoActualNanoSegundos - tiempoInicial) / 1000000000.0;
				pintar();
				actualizar(t);
				
			}
			
		};
		animationTimer.start(); //Inicia el ciclo
	}
	
	public void actualizar(double t) {
		//fondo1.mover();
		jugadorAnimado.mover();
		jugadorAnimado.actualizarAnimacion(t);
		//colisionItems();
		/*for (int i = 0; i < item.size(); i++) {
			item.remove(item.get(i));
			
		}*/
	}
	
}

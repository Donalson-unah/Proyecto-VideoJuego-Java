package Implementacion;
import Clases.Disparo;
import Clases.Fondo;
import Clases.Item;
import Clases.Jugador;
import Clases.JugadorAnimado;
import Clases.Tilemap;
import Clases.Enemy;
import Clases.Usuario;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;


public class Juego extends Application {
        private GraphicsContext graficos;
        private Group root;
        private Scene escena;
        private Canvas lienzo;
        private int x;
        private Fondo fondo;
      //private Jugador jugador;
        private JugadorAnimado jugadorAnimado;
        private double t;
        private Enemy enemigo;
        private Enemy enemigo2;
        private Enemy enemigo3;
        private Enemy enemigo4;
        private Enemy enemigo5;
        private Enemy enemigo6;
        private Enemy enemigo7;
        private Enemy enemigo8;
        private Enemy enemigo9;
        private Enemy enemigo10;
        private Enemy enemigo11;
        private Enemy enemigo12;
        private Enemy enemigo13;
        private Enemy enemigo15;
        private Enemy enemigo14;
        private Enemy enemigo16;
        private Enemy enemigo17;
        private Enemy enemigo18;
        private Enemy enemigo19;
        private Enemy enemigo20;
        
        public static boolean arriba;
        public static boolean abajo;
        public static boolean derecha; 
        public static boolean izquierda;
        public static boolean espacio;
        public static boolean control;
        public static int positionX;
        public static int positionY;
        public static HashMap<String, Image> imagenes;
      //private Tilemap tile;
        public static ArrayList<Tilemap> tiles;
        private Item item;
        private Item item2;
        private Item item3;
        private Disparo disp;
        private int vecesSubidas=0;
        private int vecesSubidasReales=0;
        public static ArrayList<Disparo> cuetazos;
        private Usuario u;

        
        private int tilemap[][] = {
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,7,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,3,1,1,1,1,1,1,1,5,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,6},
                               
     };
            
     private int tilemap2[][] = {
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,2,6},
         {2,2,1,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,3,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,3,1,1,1,1,1,1,1,1,4,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,4,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
                               
     };     
     
     private int tilemap3[][] = {
         {2,2,1,1,1,1,1,1,1,1,4,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,3,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,3,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,7,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,3,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,3,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,4,1,1,1,1,1,1,1,3,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,4,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,4,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,3,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
                               
     };
        
     private int tilemap4[][] = {
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,3,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,2,6},
         {2,2,1,1,1,4,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,3,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,3,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,3,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,7,1,1,1,2,6},
                               
     }; 
      private int tilemap5[][] = {
         {2,2,1,8,1,1,1,1,1,1,1,1,1,1,5,1,1,3,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,3,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,8,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,5,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,7,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,4,1,1,1,1,1,1,1,3,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,3,1,1,1,1,8,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
         {2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
         {6,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,6},
                               
     };

    
      
    public static void main(String[] args){
    launch(args);
    }

    @Override
    public void start(Stage ventana) throws Exception {
    inicializarComponentes();
    gestionarEventos();
     ventana.setScene(escena);
     ventana.setTitle("Get Out!");
     ventana.show();
     cicloJuego();
     
    }
    
    public void cicloJuego(){
        AnimationTimer animationTimer = new AnimationTimer(){
 
            long tiempo = System.nanoTime();
            public void handle(long tiempoActual) {
            t = (tiempoActual-tiempo)/1000000000.0;
              //  System.out.println(t);
                
                actualizarEstado(t);
                pintar();
                
            }
 
        };
        
        animationTimer.start();
    }
    
   
    
    
    public void inicializarComponentes (){

        
      imagenes = new HashMap<String,Image>();
      cargarImagenes();
      //int x, int y, String nombreImagen, int velocidad, int ancho, int alto, int xImagen, int yImagen)
      //jugador = new Jugador(0, 300, 400, "muñeco", 1);
      jugadorAnimado = new JugadorAnimado(3,300,400,"sprite",2,"estaticoArriba");
      
      enemigo = new Enemy(3,80,20,"Womba",1,"animacionMonstruo",1);
      enemigo2 = new Enemy(3,110,0,"Womba",1,"animacionMonstruo",1);
      enemigo3 = new Enemy(3,0,0,"Womba",1,"animacionMonstruo",1);
      enemigo4 = new Enemy(3,0,300,"Womba",1,"animacionMonstruo",1);
      enemigo5 = new Enemy(3,0,0,"Womba",1,"animacionMonstruo",1);
      enemigo6 = new Enemy(3,0,0,"Womba",1,"animacionMonstruo",1);
      enemigo7 = new Enemy(3,200,0,"Womba",1,"animacionMonstruo",1);
      enemigo8 = new Enemy(3,0,0,"Womba",1,"animacionMonstruo",1);
      enemigo9 = new Enemy(3,110,10,"Womba",1,"animacionMonstruo",1);
      enemigo10 = new Enemy(3,300,0,"Womba",1,"animacionMonstruo",1);
      
      enemigo11 = new Enemy(3,400,0,"Womba",1,"animacionMonstruo",1);
      enemigo12 = new Enemy(3,-20,400,"Womba",1,"animacionMonstruo",1);
      enemigo13 = new Enemy(3,200,520,"Womba",1,"animacionMonstruo",1);
      enemigo14 = new Enemy(3,-30,300,"Womba",1,"animacionMonstruo",1);
      enemigo15 = new Enemy(3,440,0,"Womba",1,"animacionMonstruo",1);
      enemigo16 = new Enemy(3,650,400,"Womba",1,"animacionMonstruo",1);
      enemigo17 = new Enemy(3,650,0,"Womba",1,"animacionMonstruo",1);
      enemigo18 = new Enemy(3,100,100,"Womba",1,"animacionMonstruo",1);
      enemigo19 = new Enemy(3,-20,300,"Womba",1,"animacionMonstruo",1);
      enemigo20 = new Enemy(3,0,0,"Womba",1,"animacionMonstruo",1);
      
      
      fondo = new Fondo(0,0,"background",0);
      item = new Item (1,300,0,"corazon",0);
      item2 = new Item (3,222,-50,"rayo",0);
      item3 = new Item (1,200,-50,"corazon",0);
      disp = new Disparo (jugadorAnimado.getX(), jugadorAnimado.getY(), "shot", 3, "none", 1);
  
      
      
      inicializarTiles();
      //tile = new Tilemap(33,33,"tilemap",0,0,0,32,32);
      root = new Group();
      escena = new Scene(root, 640, 500);
      lienzo = new Canvas(640, 500);
      root.getChildren().add(lienzo);
      graficos = lienzo.getGraphicsContext2D();
       
        
    }
    
     public void actualizarEstado(double t){
          //jugador.mover();
         mover();
          jugadorAnimado.verificarColisionesItem(item);
          jugadorAnimado.verificarColisionesEnemy(enemigo);
          for (int i=1; i<cuetazos.size(); i++)
            enemigo.verificarColisionesEnemy(cuetazos.get(i));
          

          jugadorAnimado.mover();
          item.mover();
          enemigo.mover(); 
          for (int i=1; i<cuetazos.size(); i++)
            cuetazos.get(i).mover();
          
          enemigo.calcularFrame(t);
          jugadorAnimado.calcularFrame(t);
          for (int i=1; i<cuetazos.size(); i++)
          cuetazos.get(i).calcularFrame(t);
                   
       };
    
    
    
  public void inicializarTiles() {
		tiles = new ArrayList<Tilemap>();
                
		for(int i=0;i<tilemap.length;i++) {
			for(int j=0;j<tilemap[i].length;j++) {
				if (tilemap[i][j]!=0)
					this.tiles.add(new Tilemap(tilemap[i][j],j*32,i*32,"tilemap",0,32,32));
				
			}
			
		}
                
               
                
                
                
                
                
                
                cuetazos = new ArrayList<Disparo>();
                cuetazos.add(new Disparo (jugadorAnimado.getX(), jugadorAnimado.getY(), "shot", 3, "none", 1));

	}
    
    
    
    public void cargarImagenes(){
        imagenes.put("background", new Image("implementacion/lados.jpg"));
        
    /*    imagenes.put("muñeco", new Image("implementacion/muñeco.png"));
        imagenes.put("muñecoArriba", new Image("implementacion/muñecoArriba.png"));
        imagenes.put("muñecoAbajo", new Image("implementacion/muñecoAbajo.png"));
        imagenes.put("muñecoDerecha", new Image("implementacion/muñecaDerecha.png"));
        imagenes.put("muñecoIzquierda", new Image("implementacion/muñecoIzquierda.png"));*/
        imagenes.put("corazon", new Image("implementacion/heart.png"));
        imagenes.put("rayo", new Image("implementacion/thunder.png"));
        imagenes.put("tilemap", new Image("implementacion/tilemap.png"));
        imagenes.put("sprite", new Image("implementacion/SpriteSheet.png"));
        imagenes.put("Womba", new Image("implementacion/Womba.png"));
        imagenes.put("shot", new Image("implementacion/shot.png"));
    }
    
    public void pintar () {
      
     // graficos.drawImage(imagenes.get("tilemap"),32,32,32,32,0,0,70,70);
       for (int i=0; i<tiles.size(); i++)
           tiles.get(i).pintar(graficos);
       
       
      //jugador.pintar(graficos);
       item.pintar(graficos);
       item2.pintar(graficos);
       item3.pintar(graficos);
       jugadorAnimado.pintar(graficos);
       enemigo.pintar(graficos);
       enemigo2.pintar(graficos);
       enemigo3.pintar(graficos);
       enemigo4.pintar(graficos);
       enemigo5.pintar(graficos);
       enemigo6.pintar(graficos);
       enemigo7.pintar(graficos);
       enemigo8.pintar(graficos);
       enemigo9.pintar(graficos);
       enemigo10.pintar(graficos);
       enemigo11.pintar(graficos);
       enemigo12.pintar(graficos);
       enemigo13.pintar(graficos);
       enemigo14.pintar(graficos);
       enemigo15.pintar(graficos);
       enemigo16.pintar(graficos);
       enemigo17.pintar(graficos);
       enemigo18.pintar(graficos);
       enemigo19.pintar(graficos);
       enemigo20.pintar(graficos);
       
       if(espacio){
       for (int i=1; i<cuetazos.size(); i++)
       cuetazos.get(i).pintar(graficos);}
      
       
       graficos.fillText("Vidas : "+jugadorAnimado.getVidas(), 65, 15);
       graficos.fillText("Puntos : "+jugadorAnimado.getPuntos(), 65, 30);
      
       
       
       if(jugadorAnimado.isDead()){
        Usuario u = new Usuario();
        u.setNombre(JOptionPane.showInputDialog("Ingrese su nombre"));
        u.setPuntaje(jugadorAnimado.getPuntos());
        
        JOptionPane.showMessageDialog(null,u.toString());
        System.exit(0);
       }
       
       
       positionX = jugadorAnimado.getX();
       positionY = jugadorAnimado.getY();
      //tile.pintar(graficos);
    }
    
    public void gestionarEventos(){
    
    escena.setOnKeyPressed(new EventHandler<KeyEvent>(){

       
        public void handle(KeyEvent evento) {
         
         switch(evento.getCode().toString()){
             case "RIGHT":
                 derecha = true;
                 jugadorAnimado.setAnimacionActual("correrDerecha");
                break;
             case "LEFT":
                 izquierda = true;
                 jugadorAnimado.setAnimacionActual("correrIzquierda");
                 break;
             case "DOWN":
                 abajo = true;
                 jugadorAnimado.setAnimacionActual("correrAbajo");
                 break;
             case "UP":
                 arriba = true;
                 jugadorAnimado.setAnimacionActual("correrArriba");
                 break;     
             case "SPACE":
                espacio = true;
                cuetazos.add(new Disparo (jugadorAnimado.getX(), jugadorAnimado.getY(), "shot", 3, "none", 1));
                disp.setCapturado(false);
                break;
             case "CONTROL":
                 control = true;
                 if(jugadorAnimado.activarVelocidad){
                 jugadorAnimado.setAnimVelocidad(1.80);
                 jugadorAnimado.setVelocidad(5);}
                 break;  
                 
                         };
             
                    
             
         }
        }
    
    
    );
    
    escena.setOnKeyReleased(new EventHandler<KeyEvent>(){

       
        public void handle(KeyEvent evento) {
            switch(evento.getCode().toString()){
             case "RIGHT":
                 derecha = false;
                 jugadorAnimado.setAnimacionActual("estaticoDerecha");
                 break;
             case "LEFT":
                 izquierda = false;
                 jugadorAnimado.setAnimacionActual("estaticoIzquierda");
                 break;
             case "DOWN":
                 abajo = false;
                 jugadorAnimado.setAnimacionActual("estaticoAbajo");
                 break;
             case "UP":
                 arriba = false;
                jugadorAnimado.setAnimacionActual("estaticoArriba");
                 break;
             case "SPACE":
                 break;
             case "CONTROL":
                 control = false;
                 jugadorAnimado.setVelocidad(2);
                 jugadorAnimado.setAnimVelocidad(0.35);
                 break;
         }
            
            
        }
        
    
       
    });
    
   
        
        
    }
        
    
    public void mover(){
        
        
        if(positionY<-40){

        if(vecesSubidas == 0){
        for(int i=0;i<tilemap2.length;i++) {
			for(int j=0;j<tilemap2[i].length;j++) {
				if (tilemap2[i][j]!=0)
					this.tiles.add(new Tilemap(tilemap2[i][j],j*32,i*32,"tilemap",0,32,32));
				
			}
			
		}
        vecesSubidasReales++;
        vecesSubidas++;
        return;
        }

        if(vecesSubidas == 1){
        for(int i=0;i<tilemap3.length;i++) {
			for(int j=0;j<tilemap3[i].length;j++) {
				if (tilemap3[i][j]!=0)
					this.tiles.add(new Tilemap(tilemap3[i][j],j*32,i*32,"tilemap",0,32,32));
				
			}
			
		}
        
        vecesSubidas++;
        vecesSubidasReales++;
        return;
        }
        
        if(vecesSubidas == 2){
        for(int i=0;i<tilemap4.length;i++) {
			for(int j=0;j<tilemap4[i].length;j++) {
				if (tilemap4[i][j]!=0)
					this.tiles.add(new Tilemap(tilemap4[i][j],j*32,i*32,"tilemap",0,32,32));
				
			}
			
		}
        
        vecesSubidas=0;
        vecesSubidasReales++;
        return;
        }
        }//CIERRE IF PRINCIPAL
         //PROGRAMAR LOS MONSTRUOS POR CADA NIVEL ABAJO   
        
        if(vecesSubidasReales == 1){  
        jugadorAnimado.verificarColisionesEnemy(enemigo2);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo2.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo2.mover();
         enemigo2.calcularFrame(t);

         jugadorAnimado.verificarColisionesEnemy(enemigo3);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo3.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo3.mover();
         enemigo3.calcularFrame(t);

         
        jugadorAnimado.verificarColisionesEnemy(enemigo11);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo11.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo11.mover();
         enemigo11.calcularFrame(t);   
         
        jugadorAnimado.verificarColisionesEnemy(enemigo12);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo12.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo12.mover();
         enemigo12.calcularFrame(t);         
        return;
        }        
        
        if(vecesSubidasReales == 2){
        jugadorAnimado.verificarColisionesEnemy(enemigo2);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo2.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo2.mover();
         enemigo2.calcularFrame(t);

         jugadorAnimado.verificarColisionesEnemy(enemigo3);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo3.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo3.mover();
         enemigo3.calcularFrame(t);

         jugadorAnimado.verificarColisionesEnemy(enemigo4);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo4.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo4.mover();
         enemigo4.calcularFrame(t);     
         
         jugadorAnimado.verificarColisionesEnemy(enemigo5);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo5.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo5.mover();
         enemigo5.calcularFrame(t); 
         
        jugadorAnimado.verificarColisionesEnemy(enemigo11);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo11.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo11.mover();
         enemigo11.calcularFrame(t);   
         
        jugadorAnimado.verificarColisionesEnemy(enemigo12);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo12.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo12.mover();
         enemigo12.calcularFrame(t);
        
        jugadorAnimado.verificarColisionesEnemy(enemigo13);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo13.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo13.mover();
         enemigo13.calcularFrame(t);   
         
        jugadorAnimado.verificarColisionesEnemy(enemigo14);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo14.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo14.mover();
         enemigo14.calcularFrame(t);         
         return;
        }
        
        if(vecesSubidasReales == 3){
        jugadorAnimado.verificarColisionesEnemy(enemigo2);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo2.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo2.mover();
         enemigo2.calcularFrame(t);

         jugadorAnimado.verificarColisionesEnemy(enemigo3);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo3.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo3.mover();
         enemigo3.calcularFrame(t);

         jugadorAnimado.verificarColisionesEnemy(enemigo4);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo4.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo4.mover();
         enemigo4.calcularFrame(t);     
         
         jugadorAnimado.verificarColisionesEnemy(enemigo5);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo5.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo5.mover();
         enemigo5.calcularFrame(t);

         jugadorAnimado.verificarColisionesEnemy(enemigo6);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo6.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo6.mover();
         enemigo6.calcularFrame(t);      
         
        jugadorAnimado.verificarColisionesEnemy(enemigo11);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo11.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo11.mover();
         enemigo11.calcularFrame(t);   
         
        jugadorAnimado.verificarColisionesEnemy(enemigo12);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo12.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo12.mover();
         enemigo12.calcularFrame(t);
        
        jugadorAnimado.verificarColisionesEnemy(enemigo13);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo13.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo13.mover();
         enemigo13.calcularFrame(t);   
         
        jugadorAnimado.verificarColisionesEnemy(enemigo14);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo14.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo14.mover();
         enemigo14.calcularFrame(t);
         
        jugadorAnimado.verificarColisionesEnemy(enemigo15);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo15.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo15.mover();
         enemigo15.calcularFrame(t);   
         
        jugadorAnimado.verificarColisionesEnemy(enemigo16);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo16.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo16.mover();
         enemigo16.calcularFrame(t);         

        return;
        }
        
        if(vecesSubidasReales == 4){
        jugadorAnimado.verificarColisionesEnemy(enemigo2);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo2.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo2.mover();
         enemigo2.calcularFrame(t);

         jugadorAnimado.verificarColisionesEnemy(enemigo3);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo3.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo3.mover();
         enemigo3.calcularFrame(t);

         jugadorAnimado.verificarColisionesEnemy(enemigo4);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo4.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo4.mover();
         enemigo4.calcularFrame(t);     
         
         jugadorAnimado.verificarColisionesEnemy(enemigo5);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo5.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo5.mover();
         enemigo5.calcularFrame(t);

         jugadorAnimado.verificarColisionesEnemy(enemigo6);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo6.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo6.mover();
         enemigo6.calcularFrame(t); 
         
         jugadorAnimado.verificarColisionesEnemy(enemigo7);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo7.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo7.mover();
         enemigo7.calcularFrame(t);

         jugadorAnimado.verificarColisionesEnemy(enemigo8);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo8.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo8.mover();
         enemigo8.calcularFrame(t);
         
        jugadorAnimado.verificarColisionesEnemy(enemigo11);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo11.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo11.mover();
         enemigo11.calcularFrame(t);   
         
        jugadorAnimado.verificarColisionesEnemy(enemigo12);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo12.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo12.mover();
         enemigo12.calcularFrame(t);
        
        jugadorAnimado.verificarColisionesEnemy(enemigo13);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo13.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo13.mover();
         enemigo13.calcularFrame(t);   
         
        jugadorAnimado.verificarColisionesEnemy(enemigo14);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo14.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo14.mover();
         enemigo14.calcularFrame(t);
         
        jugadorAnimado.verificarColisionesEnemy(enemigo15);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo15.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo15.mover();
         enemigo15.calcularFrame(t);   
         
        jugadorAnimado.verificarColisionesEnemy(enemigo16);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo16.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo16.mover();
         enemigo16.calcularFrame(t);              
         
        jugadorAnimado.verificarColisionesEnemy(enemigo17);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo17.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo17.mover();
         enemigo17.calcularFrame(t);   
         
        jugadorAnimado.verificarColisionesEnemy(enemigo18);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo18.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo18.mover();
         enemigo18.calcularFrame(t);                  
         jugadorAnimado.verificarColisionesItem(item2);
         item2.mover();
        return;
        }
        
        
        if(vecesSubidasReales == 5){
        jugadorAnimado.verificarColisionesEnemy(enemigo2);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo2.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo2.mover();
         enemigo2.calcularFrame(t);

         jugadorAnimado.verificarColisionesEnemy(enemigo3);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo3.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo3.mover();
         enemigo3.calcularFrame(t);

         jugadorAnimado.verificarColisionesEnemy(enemigo4);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo4.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo4.mover();
         enemigo4.calcularFrame(t);     
         
         jugadorAnimado.verificarColisionesEnemy(enemigo5);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo5.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo5.mover();
         enemigo5.calcularFrame(t);

         jugadorAnimado.verificarColisionesEnemy(enemigo6);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo6.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo6.mover();
         enemigo6.calcularFrame(t); 
         
         jugadorAnimado.verificarColisionesEnemy(enemigo7);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo7.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo7.mover();
         enemigo7.calcularFrame(t);

         jugadorAnimado.verificarColisionesEnemy(enemigo8);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo8.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo8.mover();
         enemigo8.calcularFrame(t); 
            
         jugadorAnimado.verificarColisionesEnemy(enemigo9);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo9.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo9.mover();
         enemigo9.calcularFrame(t);
         
         jugadorAnimado.verificarColisionesEnemy(enemigo10);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo10.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo10.mover();
         enemigo10.calcularFrame(t);  
         
        jugadorAnimado.verificarColisionesEnemy(enemigo11);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo11.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo11.mover();
         enemigo11.calcularFrame(t);   
         
        jugadorAnimado.verificarColisionesEnemy(enemigo12);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo12.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo12.mover();
         enemigo12.calcularFrame(t);
        
        jugadorAnimado.verificarColisionesEnemy(enemigo13);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo13.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo13.mover();
         enemigo13.calcularFrame(t);   
         
        jugadorAnimado.verificarColisionesEnemy(enemigo14);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo14.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo14.mover();
         enemigo14.calcularFrame(t);
         
        jugadorAnimado.verificarColisionesEnemy(enemigo15);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo15.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo15.mover();
         enemigo15.calcularFrame(t);   
         
        jugadorAnimado.verificarColisionesEnemy(enemigo16);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo16.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo16.mover();
         enemigo16.calcularFrame(t);            
         
        jugadorAnimado.verificarColisionesEnemy(enemigo17);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo17.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo17.mover();
         enemigo17.calcularFrame(t);   
         
        jugadorAnimado.verificarColisionesEnemy(enemigo18);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo18.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo18.mover();
         enemigo18.calcularFrame(t);                  
         jugadorAnimado.verificarColisionesItem(item2);
         item2.mover();         
         
        jugadorAnimado.verificarColisionesEnemy(enemigo19);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo19.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo19.mover();
         enemigo19.calcularFrame(t);   
         
        jugadorAnimado.verificarColisionesEnemy(enemigo20);
         for (int i=1; i<cuetazos.size(); i++)
         enemigo20.verificarColisionesEnemy(cuetazos.get(i));    
         enemigo20.mover();
         enemigo20.calcularFrame(t);                 
         jugadorAnimado.verificarColisionesItem(item2);
         item2.mover();         
         jugadorAnimado.verificarColisionesItem(item3);
         item3.mover();
         

        return;
        }
        
        if(vecesSubidasReales == 6){
            
        if(enemigo.getVidas() <= 0)
         enemigo = new Enemy(3,80,20,"Womba",1,"animacionMonstruo",1);   
        if(enemigo2.getVidas() <= 0)
         enemigo2 = new Enemy(3,110,0,"Womba",1,"animacionMonstruo",1);
        if(enemigo3.getVidas() <= 0)
         enemigo3 = new Enemy(3,0,0,"Womba",1,"animacionMonstruo",1);
        if(enemigo4.getVidas() <= 0) 
        enemigo4 = new Enemy(3,0,300,"Womba",1,"animacionMonstruo",1);
        if(enemigo5.getVidas() <= 0)
        enemigo5 = new Enemy(3,0,0,"Womba",1,"animacionMonstruo",1);
        if(enemigo6.getVidas() <= 0)
        enemigo6 = new Enemy(3,0,0,"Womba",1,"animacionMonstruo",1);
        if(enemigo7.getVidas() <= 0)
        enemigo7 = new Enemy(3,200,0,"Womba",1,"animacionMonstruo",1);
        if(enemigo8.getVidas() <= 0)
        enemigo8 = new Enemy(3,0,0,"Womba",1,"animacionMonstruo",1);
        if(enemigo9.getVidas() <= 0)
        enemigo9 = new Enemy(3,110,10,"Womba",1,"animacionMonstruo",1);
        if(enemigo10.getVidas() <= 0)
        enemigo10 = new Enemy(3,300,0,"Womba",1,"animacionMonstruo",1);
        if(enemigo11.getVidas() <= 0)
        enemigo11 = new Enemy(3,100,0,"Womba",1,"animacionMonstruo",1);
        if(enemigo12.getVidas() <= 0)
        enemigo12 = new Enemy(3,-20,200,"Womba",1,"animacionMonstruo",1);
        if(enemigo13.getVidas() <= 0)
        enemigo13 = new Enemy(3,200,520,"Womba",1,"animacionMonstruo",1);
        if(enemigo14.getVidas() <= 0)
        enemigo14 = new Enemy(3,0,0,"Womba",1,"animacionMonstruo",1);
        if(enemigo15.getVidas() <= 0)
        enemigo15 = new Enemy(3,440,0,"Womba",1,"animacionMonstruo",1);
        if(enemigo16.getVidas() <= 0)
        enemigo16 = new Enemy(3,650,400,"Womba",1,"animacionMonstruo",1);
        if(enemigo17.getVidas() <= 0)
        enemigo17 = new Enemy(3,300,0,"Womba",1,"animacionMonstruo",1);
        if(enemigo18.getVidas() <= 0)
        enemigo18 = new Enemy(3,100,100,"Womba",1,"animacionMonstruo",1);
        if(enemigo19.getVidas() <= 0)
        enemigo19 = new Enemy(3,-20,300,"Womba",1,"animacionMonstruo",1);
        if(enemigo20.getVidas() <= 0)
        enemigo20 = new Enemy(3,0,0,"Womba",1,"animacionMonstruo",1);
         
        item2 = new Item (3,222,-50,"rayo",0);
        item3 = new Item (1,200,-50,"corazon",0); 
        jugadorAnimado.setVelocidad(2);
        vecesSubidasReales=0;    
        return;
        }
        
           
        
        
        
        
        
    }//CIERRE MOVIMIENTO
    
    
    

    
}//CIERRE

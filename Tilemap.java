package Clases;

import Implementacion.Juego;
import java.util.HashMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;


public class Tilemap extends ObjetoJuego {
    
       private int xImagen;
       private int yImagen;
       private int tipoTile;
       private HashMap<String,Animacion> animacionesTile;

    public Tilemap(int tipoTile,int x, int y,String nombreImagen, int velocidad, int alto, int ancho) {
        super(x, y, nombreImagen, velocidad);
        this.alto = alto;
        this.ancho = ancho;
        
        
        switch (tipoTile){
            case 1:
                this.xImagen=33;
                this.yImagen=33;
             
                break;
            case 2:
                this.xImagen=132;
                this.yImagen=66;
                break;
            case 3:
                this.xImagen=0;
                this.yImagen=165;
                break;
            case 4:
                this.xImagen=66;
                this.yImagen=165;
                break;
            case 5:
                this.xImagen=66;
                this.yImagen=231;
                break;
            case 6:
                this.xImagen=33;
                this.yImagen=132;
                break;
            case 7:
                this.xImagen=33;
                this.yImagen=231;
                break;
            case 8:
                this.xImagen=0;
                this.yImagen=231;
                break;
        }
        
    }

    public void setxImagen(int xImagen) {
        this.xImagen = xImagen;
    }

    public int getxImagen() {
        return xImagen;
    }

    public void setyImagen(int yImagen) {
        this.yImagen = yImagen;
    }

    public int getyImagen() {
        return yImagen;
    }

    @Override
    public void pintar(GraphicsContext graficos) {
        
        graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen,yImagen,ancho,alto,x,y,ancho,alto);
       
    }

    
    public void inicializarAnimacionesTile() {
        Rectangle animaciones[]={
            new Rectangle(33,33,32,32),
            new Rectangle(33,132,32,32)};
        
        Animacion anim = new Animacion(1,animaciones);
        animacionesTile.put("mover", anim);
        }        
    /*
    public void calcularFrame(double t){
//        Rectangle coordenadas = animacionesTile.get("mover").calcularFrameActual();
        this.xImagen = (int)coordenadas.getX();
        this.yImagen = (int)coordenadas.getY();
        this.alto = (int)coordenadas.getWidth();
        this.ancho = (int)coordenadas.getHeight();
        
        
    }
    */
    
    

    @Override
    public void mover() {   
       
    }
        
  
    
       
    
    
    
    
    
    
    
}//CIERRE CLASE

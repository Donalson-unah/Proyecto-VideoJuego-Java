package Clases;

import Implementacion.Juego;
import com.sun.prism.paint.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class Enemy extends ObjetoJuego{
    private HashMap<String,Animacion> animaciones;
    private int xImagen;
    private int yImagen;
    private int anchoImagen;
    private int altoImagen;
    private String animacionActual;
    private int cantidadPuntos;
    private int vidas;
    private boolean capturado = false;

    
    
    
    public Enemy(int vidas, int x, int y, String nombreImagen, int velocidad, String animacionActual, int cantidadPuntos) {
        super(x, y, nombreImagen, velocidad);
        this.animacionActual = animacionActual;
        this.cantidadPuntos = cantidadPuntos;
        this.vidas = vidas;
        animaciones = new HashMap<String, Animacion>();
        inicializarAnimaciones();
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getVidas() {
        return vidas;
    }
 
       
 
    public void setAnimacionActual(String animacionActual) {
        this.animacionActual = animacionActual;
    }

    public String getAnimacionActual() {
        return animacionActual;
    }

    public Rectangle obtenerRectangulo(){
       return new Rectangle(x, y, 50, 60);    
    }
    
    public void setCapturado(boolean capturado) {
        this.capturado = capturado;
    }

    public boolean isCapturado() {
        return capturado;
    }
    
    public void setCantidadPuntos(int cantidadPuntos) {
        this.cantidadPuntos = cantidadPuntos;
    }

    public int getCantidadPuntos() {
        return cantidadPuntos;
    }
    
    @Override
    public void pintar(GraphicsContext graficos){
        if(capturado)
           return;
         
       
        if(this.vidas <=0)
          capturado=true;
            
        
        else
          graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen,yImagen,anchoImagen, altoImagen, x, y,50,60);
 
        //graficos.strokeRect(x, y, 45, 40);
    }
    
    
    @Override
    public void mover(){
       
        if(x < Juego.positionX)
            x+=velocidad;
        
        if(x > Juego.positionX)
            x-=velocidad;
        
        if(y < Juego.positionY)
            y+=velocidad;
        
        if(y > Juego.positionY)
            y-=velocidad;
        
        
      
       
        
    }
    
    
    public void inicializarAnimaciones(){
        Rectangle coordenadasMonstruo[] = {
        new Rectangle(0,0,160,100),
        new Rectangle(98,0,160,94),
        new Rectangle(190,0,160,94),
        new Rectangle(284,0,160,94)
        };     
        Animacion animacionMonstruo = new Animacion(0.65,coordenadasMonstruo);
        animaciones.put("animacionMonstruo",animacionMonstruo);
  
              
        
    }
    
    
    public void verificarColisionesEnemy(Disparo disp){
     if (!disp.isCapturado() && this.obtenerRectangulo().getBoundsInLocal().intersects(disp.obtenerRectangulo().getBoundsInLocal())){   
         
                  
         this.vidas -= disp.getCantidadPuntos();
         
         
         if(this.vidas>=0) 
         disp.setCapturado(true);
         
         
         if(this.vidas>=0){
         JugadorAnimado.puntos += 1;
         disp.setCapturado(true);}
        
         
         
    }
    
    
    }
    
    
    
    
    public void calcularFrame(double t){
        Rectangle coordenadas = animaciones.get(animacionActual).calcularFrameActual(t);
        this.xImagen = (int)coordenadas.getX();
        this.yImagen = (int)coordenadas.getY();
        this.altoImagen = (int)coordenadas.getWidth();
        this.anchoImagen = (int)coordenadas.getHeight();
        
    }
    
    
   
    
}//CIERRE CLASE

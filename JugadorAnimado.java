package Clases;

import Implementacion.Juego;
import com.sun.prism.paint.Color;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;

public class JugadorAnimado extends ObjetoJuego{
    private int vidas;
    private HashMap<String,Animacion> animaciones;
    private int xImagen;
    private int yImagen;
    private int anchoImagen;
    private int altoImagen;
    private String animacionActual;
    public static boolean activarVelocidad = false;
    private double animVelocidad=0.35;
    public static int puntos=0;
    
    
    public JugadorAnimado(int vidas, int x, int y, String nombreImagen, int velocidad, String animacionActual) {
        super(x, y, nombreImagen, velocidad);
        this.vidas = vidas;
        this.animacionActual = animacionActual;
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
       return new Rectangle(x, y, 45, 40);    
    }

    public void setAnimVelocidad(double animVelocidad) {
        this.animVelocidad = animVelocidad;
    }

    public double getAnimVelocidad() {
        return animVelocidad;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    
    
    
    @Override
    public void pintar(GraphicsContext graficos){
        graficos.drawImage(Juego.imagenes.get(nombreImagen),xImagen,yImagen,anchoImagen, altoImagen, x, y,50,50);
 
        //graficos.strokeRect(x, y, 45, 40);
    }
    
    
    @Override
    public void mover(){
        
        if(y<-40)
            y=480;
        
        else if(y>500)
        y=-30;
        
        if(x>640)
        x=-25;
                
        else if (x<-30)        
        x=630;
        
        
        
        if (Juego.derecha) 
         x+=velocidad;
        if(Juego.izquierda)
         x-=velocidad;
        if(Juego.arriba)
         y-=velocidad;
        if(Juego.abajo)
         y+=velocidad;
 
    }
    
    
    public void inicializarAnimaciones(){
        Rectangle coordenadasCorrer[] = {
        new Rectangle(185,327,290,200),
        new Rectangle(565,329,290,200),};      
        Animacion animacionCorrer = new Animacion(animVelocidad,coordenadasCorrer);
        animaciones.put("correrArriba",animacionCorrer);
  
        Rectangle coordenadasDescanso[]={
        new Rectangle(0,320,290,200),};
        Animacion animacionDescanso = new Animacion(animVelocidad,coordenadasDescanso);
        animaciones.put("estaticoArriba",animacionDescanso);
        
        
        
        Rectangle coordenasDerecha[]={
        new Rectangle(0,896,290,200),
        new Rectangle(196,890,290,200),};
        Animacion animacionDerecha = new Animacion(animVelocidad,coordenasDerecha);
        animaciones.put("correrDerecha",animacionDerecha);
        
        Rectangle coordenadasDescansoDerecha[]={
        new Rectangle(196,890,290,200),};
        Animacion animacionDescansoDerecha = new Animacion(animVelocidad,coordenadasDescansoDerecha);
        animaciones.put("estaticoDerecha",animacionDescansoDerecha);
        
        
        
        Rectangle coordenasIzquierda[]={
        new Rectangle(0,600,290,200),
        new Rectangle(196,600,290,200),};
        Animacion animacionIzquierda = new Animacion(animVelocidad,coordenasIzquierda);
        animaciones.put("correrIzquierda",animacionIzquierda);
        
        Rectangle coordenasDescansoIzquierda[]={
        new Rectangle(0,600,290,200),};
        Animacion animacionDescansoIzquierda = new Animacion(animVelocidad,coordenasDescansoIzquierda);
        animaciones.put("estaticoIzquierda",animacionDescansoIzquierda);
        
        
        
        Rectangle coordenasAbajo[]={
        new Rectangle(180,40,290,200),
        new Rectangle(560,40,290,200),};
        Animacion animacionAbajo = new Animacion(animVelocidad,coordenasAbajo);
        animaciones.put("correrAbajo",animacionAbajo);
        
        Rectangle coordenasDescansoAbajo[]={
        new Rectangle(0,40,290,200),};
        Animacion animacionDescansoAbajo = new Animacion(animVelocidad,coordenasDescansoAbajo);
        animaciones.put("estaticoAbajo",animacionDescansoAbajo);
        
        
    }
    
    public void calcularFrame(double t){
        Rectangle coordenadas = animaciones.get(animacionActual).calcularFrameActual(t);
        this.xImagen = (int)coordenadas.getX();
        this.yImagen = (int)coordenadas.getY();
        this.altoImagen = (int)coordenadas.getWidth();
        this.anchoImagen = (int)coordenadas.getHeight();
        
    }
    
    
    public void verificarColisionesItem(Item item){
  if (!item.isCapturado() && this.obtenerRectangulo().getBoundsInLocal().intersects(item.obtenerRectangulo().getBoundsInLocal())){
            
            if(item.getNombreImagen() == "rayo"){
            activarVelocidad = true;
            item.setCapturado(true);
            JugadorAnimado.puntos+=5;
            return;
             }
      
            
            if(item.getNombreImagen() == "corazon"){
            this.vidas += item.getCantidadPuntos();
            JugadorAnimado.puntos+=5;
            item.setCapturado(true);
            return;
              }   
            
            
            
            
            
            
        }
        //System.out.println("si chocan");
        }
    
    
    
    public void verificarColisionesEnemy(Enemy enemigo){
     if (!enemigo.isCapturado() && this.obtenerRectangulo().getBoundsInLocal().intersects(enemigo.obtenerRectangulo().getBoundsInLocal())){   
         
         if(enemigo.getNombreImagen() == "Womba"){
         this.vidas -= enemigo.getCantidadPuntos();
        // System.out.println("si chocan");
         enemigo.setVidas(0);
         enemigo.setCapturado(true);
         }
         
         
         
    }
          
        }
    
    
    
       
     
     
     
    public boolean isDead(){
        if (this.vidas <= 0)
            return true;
        return false;
    }
    
    
}//CIERRE CLASE

package Clases;

public class Usuario {
    private String nombre;
    private int puntaje;

    public Usuario(String nombre, int puntaje) {
        this.nombre = nombre;
        this.puntaje = puntaje;
    }

    public Usuario() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public int getPuntaje() {
        return puntaje;
    }

    @Override
    public String toString() {
        return "Nombre: "+nombre+" \nPuntos: "+puntaje;
    }
    
   
    
    
    
}

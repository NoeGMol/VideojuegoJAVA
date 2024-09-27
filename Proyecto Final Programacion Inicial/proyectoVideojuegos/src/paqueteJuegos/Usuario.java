package paqueteJuegos;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private String contrasenia;
    private List<Puntajes> listaPuntajesPreguntas = new ArrayList<Puntajes>();
    private List<Puntajes> listaPuntajesRol = new ArrayList<Puntajes>();
    
    Usuario(String nombre, String contrasenia){
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }
//Getter y Setters
    public String getNombre(){
            return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasenia(){
        return contrasenia;
    }

    public void setContrasenia(String contrasenia){
        this.contrasenia = contrasenia;
    }
    public List<Puntajes> getListaPuntajesPreguntas(){
        return listaPuntajesPreguntas;
   }
   
   public void setListaPuntajesPreguntas(Puntajes puntajesPreguntas){
        listaPuntajesPreguntas.add(puntajesPreguntas);
   }
    public List<Puntajes> getListaPuntajesRol() {
        return listaPuntajesRol;
    }
    public void setListaPuntajesRol(Puntajes puntajesRol){
        listaPuntajesRol.add(puntajesRol);
    }
}
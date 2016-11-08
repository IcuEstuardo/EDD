package Dijkstra;

import java.util.ArrayList;

/**
 *
 * @author Isabel
 */
public class Vertice {
    
    private String nombre;
    private boolean estado;
    
    private Vertice antecesor;
    private ArrayList<Vertice> vertices;
    
    public Vertice(String nom)
    {
        this.nombre = nom;
        this.estado = false;
        
        this.antecesor = null;
        this.vertices = new ArrayList<>();
    }
    
    public void setVertice(Vertice nuevo)
    {
        this.vertices.add(nuevo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Vertice getAntecesor() {
        return antecesor;
    }

    public void setAntecesor(Vertice antecesor) {
        this.antecesor = antecesor;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }
    
    
    
    
    
}

package AVL;

/**
 *
 * @author estuardo
 */
public class nodoAVL {
    
    private nodoAVL ndIzquierda;
    private nodoAVL ndDerecha;
    private int clave;
    private int altura;
    
    
    public nodoAVL(int id){
        this.clave = id;
        this.altura = 0;
        
        this.ndDerecha = null;
        this.ndIzquierda = null;
    }

    public nodoAVL getNdIzquierda() {
        return ndIzquierda;
    }

    public void setNdIzquierda(nodoAVL ndIzquierda) {
        this.ndIzquierda = ndIzquierda;
    }

    public nodoAVL getNdDerecha() {
        return ndDerecha;
    }

    public void setNdDerecha(nodoAVL ndDerecha) {
        this.ndDerecha = ndDerecha;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    
    public String datosNodo(int tipo)
    {
        switch(tipo)
        {
            case 0:
                return "nodo" + this.getClave();
            case 1:
                return "nodo" + this.getClave() + " [label = \"" + this.getClave() + " # " + this.getAltura() +"\"];";
            default:
                return "";
        }
    }
    
}

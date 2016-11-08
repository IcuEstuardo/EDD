package SPL;

/**
 *
 * @author estuardo
 */
public class nodoSPL {
    
    private nodoSPL ndIzquierda;
    private nodoSPL ndDerecha;
    private int clave;
    private int altura;
    
    
    public nodoSPL(int id){
        this.clave = id;
        this.altura = -1;
        
        this.ndDerecha = null;
        this.ndIzquierda = null;
    }

    public nodoSPL getNdIzquierda() {
        return ndIzquierda;
    }

    public void setNdIzquierda(nodoSPL ndIzquierda) {
        this.ndIzquierda = ndIzquierda;
    }

    public nodoSPL getNdDerecha() {
        return ndDerecha;
    }

    public void setNdDerecha(nodoSPL ndDerecha) {
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

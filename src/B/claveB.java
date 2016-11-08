package B;

public class claveB
{

    private paginaB hijoIzq;
    private paginaB hijoDer;

    private claveB siguiente;
    private claveB anterior;

    private int clave;

    public claveB(int clv)
    {
        this.clave = clv;

        this.hijoIzq = null;
        this.hijoDer = null;

        this.siguiente = null;
        this.anterior = null;
    }

    public paginaB getHijoIzq() {
        return hijoIzq;
    }

    public void setHijoIzq(paginaB hijoIzq) {
        this.hijoIzq = hijoIzq;
    }

    public paginaB getHijoDer() {
        return hijoDer;
    }

    public void setHijoDer(paginaB hijoDer) {
        this.hijoDer = hijoDer;
    }

    public claveB getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(claveB siguiente) {
        this.siguiente = siguiente;
    }

    public claveB getAnterior() {
        return anterior;
    }

    public void setAnterior(claveB anterior) {
        this.anterior = anterior;
    }

    public int getClave() {
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }



}

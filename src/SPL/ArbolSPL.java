package SPL;

/**
 *
 * @author estuardo
 */
public class ArbolSPL {

    private nodoSPL Raiz;
    private String txtDatos;
    private int niveles;

    public ArbolSPL()
    {
        this.txtDatos = "";
        this.Raiz = null;
        this.niveles = -1;
    }

    public void Insercion(int id)
    {
        this.Raiz = this.InsertarNodo(this.Raiz, id);

        nodoSPL nodo = this.Busqueda(id);
        this.Raiz = this.BicelarArbol(this.Raiz, nodo.getClave(), nodo.getAltura());
    }

    private nodoSPL InsertarNodo(nodoSPL raiz, int id)
    {
        if(raiz == null)
        {
            raiz = new nodoSPL(id);
        }
        else
        {
            if(id < raiz.getClave())
                raiz.setNdIzquierda(this.InsertarNodo(raiz.getNdIzquierda(), id));
            else if (id > raiz.getClave())
                raiz.setNdDerecha(this.InsertarNodo(raiz.getNdDerecha(), id));
        }

        return raiz;
    }

    private nodoSPL BicelarArbol(nodoSPL raiz, int dato, int nivel)
    {
        if(raiz != null)
        {

            raiz.setNdIzquierda(this.BicelarArbol(raiz.getNdIzquierda(), dato, nivel));
            raiz.setNdDerecha(this.BicelarArbol(raiz.getNdDerecha(), dato, nivel));


            try {

                if(dato < raiz.getClave())
                {
                    if(raiz.getNdIzquierda() != null)
                    {
                        if(dato < raiz.getNdIzquierda().getClave())
                            return this.ZigZig(raiz);
                        else if(dato > raiz.getNdIzquierda().getClave())
                            return this.ZigZag(raiz);
                    }

                    return this.Zig(raiz);
                }
                else if(dato > raiz.getClave())
                {
                    if(raiz.getNdDerecha() != null)
                    {
                        if(dato > raiz.getNdDerecha().getClave())
                            return this.ZagZag(raiz);
                        else if(dato < raiz.getNdDerecha().getClave())
                            return this.ZagZig(raiz);
                    }

                    return this.Zag(raiz);
                }

            } catch (Exception e) {

            }
        }

        return raiz;
    }



    public nodoSPL Busqueda(int id)
    {
        nodoSPL nodo = this.BuscarNodo(this.Raiz, id);
        return nodo;
    }

    private nodoSPL BuscarNodo(nodoSPL raiz, int id)
    {
        if (raiz != null)
        {
            if (id == raiz.getClave())
                return raiz;
            else
            {
                if (id < raiz.getClave())
                    return this.BuscarNodo(raiz.getNdIzquierda(), id);
                else
                    return this.BuscarNodo(raiz.getNdDerecha(), id);
            }
        }

        return null;
    }

    private nodoSPL Zig(nodoSPL nodoP) {
        nodoSPL nodoH = nodoP.getNdIzquierda();

        nodoP.setNdIzquierda(nodoH.getNdDerecha());
        nodoH.setNdDerecha(nodoP);

        return nodoH;
    }

    private nodoSPL Zag(nodoSPL nodoP) {
        nodoSPL nodoH = nodoP.getNdDerecha();

        nodoP.setNdDerecha(nodoH.getNdIzquierda());
        nodoH.setNdIzquierda(nodoP);

        return nodoH;
    }

    private nodoSPL ZigZig(nodoSPL nodoA) {
        nodoSPL nodoP = this.Zig(nodoA);
        nodoSPL nodoH = this.Zig(nodoP);

        return nodoH;
    }

    private nodoSPL ZagZag(nodoSPL nodoA) {
        nodoSPL nodoP = this.Zag(nodoA);
        nodoSPL nodoH = this.Zag(nodoP);

        return nodoH;
    }


    private nodoSPL ZigZag(nodoSPL nodoA) {
        nodoSPL nodoP = nodoA.getNdIzquierda();
        nodoSPL nodoH = this.Zag(nodoP);
        nodoA.setNdIzquierda(nodoH);
        nodoH = this.Zig(nodoA);

        return nodoH;
    }

    private nodoSPL ZagZig(nodoSPL nodoA) {
        nodoSPL nodoP = nodoA.getNdDerecha();
        nodoSPL nodoH = this.Zig(nodoP);
        nodoA.setNdDerecha(nodoH);
        nodoH = this.Zag(nodoA);

        return nodoH;
    }




    public String Grafica() {
        this.txtDatos = "";
        this.graficarArbol(this.Raiz);
        return this.txtDatos;
    }

    private void graficarArbol(nodoSPL raiz) {
        if (raiz != null) {
            txtDatos += raiz.datosNodo(1) + "\n";

            if (raiz.getNdIzquierda() != null) {
                txtDatos += raiz.datosNodo(0) + " -> " + raiz.getNdIzquierda().datosNodo(0) + ";\n";
                this.graficarArbol(raiz.getNdIzquierda());
            }

            if (raiz.getNdDerecha() != null) {
                txtDatos += raiz.datosNodo(0) + " -> " + raiz.getNdDerecha().datosNodo(0) + ";\n";
                this.graficarArbol(raiz.getNdDerecha());
            }
        }
    }

    public void Recorrido(int tipo)
    {
        switch(tipo)
        {
            case 1:
                this.preOrden(this.Raiz);
                break;
            case 2:
                this.enOrden(this.Raiz);
                break;
            case 3:
                this.postOrden(this.Raiz);
                break;
        }
        System.out.println("");
    }

    private void enOrden(nodoSPL raiz)
    {
        if(raiz != null)
        {
            this.enOrden(raiz.getNdIzquierda());
            System.out.print(raiz.getClave() + " ");
            this.enOrden(raiz.getNdDerecha());
        }
    }

    private void preOrden(nodoSPL raiz)
    {
        if(raiz != null)
        {
            System.out.print(raiz.getClave() + " ");
            this.enOrden(raiz.getNdIzquierda());
            this.enOrden(raiz.getNdDerecha());
        }
    }

    private void postOrden(nodoSPL raiz)
    {
        if(raiz != null)
        {
            this.enOrden(raiz.getNdIzquierda());
            this.enOrden(raiz.getNdDerecha());
            System.out.print(raiz.getClave() + " ");
        }
    }

    private int Altura(nodoSPL raiz) {
        if (raiz == null) {
            return -1;
        } else {
            return raiz.getAltura();
        }
    }

    private int asignarAltura(nodoSPL raiz)
    {
        return Math.max(this.Altura(raiz.getNdIzquierda()), this.Altura(raiz.getNdDerecha())) +1;
    }


}

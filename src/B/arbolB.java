package B;

/**
 *
 * @author Estuardo
 */
public class arbolB {

    private paginaB Raiz;
    private int Orden;
    private String txtDatos;

    public arbolB(int rdn)
    {
        this.Raiz = new paginaB(0);
        this.Orden = rdn;
    }

    public void Insercion(int dato)
    {
        this.Raiz = this.InsertarClave(this.Raiz, dato);
    }

    public paginaB InsertarClave(paginaB raiz, int dato)
    {
        if(raiz != null)
        {
            if(raiz.getNivel() == 0)
            {
                raiz.InsertarClave(new claveB(dato));
            }
            else
            {
                raiz.DefinirHijo(this.InsertarClave(raiz.ObtenerHijo(dato), dato), dato);
                if (raiz.ObtenerHijo(dato).getNivel() == raiz.getNivel()) {
                    raiz.InsertarClave(raiz.ObtenerHijo(dato).ObtenerClave(1));
                }

            }

            if (raiz.getContadorClave() == this.Orden)
            {
                raiz = this.ElevarRaiz(raiz);
            }
        }

        return raiz;
    }

    public paginaB ElevarRaiz(paginaB nodo)
    {
        try {
            paginaB nodoR = new paginaB(nodo.getNivel() + 1);
            paginaB nodoA = new paginaB(nodo.getNivel());
            paginaB nodoB = new paginaB(nodo.getNivel());

            nodoB = nodo.DividirPagina(nodoB, 2);
            nodoB.LimpiarEnlaces();

            nodoR = nodo.DividirPagina(nodoR, 0);
            nodoR.LimpiarEnlaces();

            nodoA = nodo.DividirPagina(nodoA, 1);
            nodoA.LimpiarEnlaces();

            nodoR.ObtenerClave(1).setHijoIzq(nodoA);
            nodoR.ObtenerClave(1).setHijoDer(nodoB);

            return nodoR;
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;
        }

    }




    public void RecorrerArbol(paginaB raiz)
    {
        if (raiz != null) {
            System.out.println("Nivel: " + raiz.getNivel() + " | " + raiz.RecorrerClaveIF());

            this.RecorrerArbol(raiz.ObtenerClave(1).getHijoIzq());
            for (int i = 1; i <= raiz.getContadorClave(); i++)
            {
                this.RecorrerArbol(raiz.ObtenerClave(i).getHijoDer());
            }
        }
    }


    public String Grafica()
    {
        this.txtDatos = "";
        this.graficarArbol(this.Raiz);
        return this.txtDatos;
    }

    private void graficarArbol(paginaB raiz)
    {
//        if(raiz != null)
//        {
//            txtDatos += raiz.datosNodo(1,0) + "\n";
//
//            for (int i = 0; i < raiz.getContadorClave(); i++) {
//                if (raiz.ListaHijos()[i] != null) {
//                    txtDatos += raiz.datosNodo(0,0) + " -> " + raiz.ListaHijos()[i].datosNodo(0,0) + ";\n";
//                    this.graficarArbol(raiz.ListaHijos()[i]);
//                }
//            }
//        }
    }

    public paginaB getRaiz() {
        return Raiz;
    }

    public void setRaiz(paginaB Raiz) {
        this.Raiz = Raiz;
    }

    public int getOrden() {
        return Orden;
    }

    public void setOrden(int Orden) {
        this.Orden = Orden;
    }

}

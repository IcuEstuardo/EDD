package B;

/**
 *
 * @author Estuardo
 */
public class paginaB {

    private int ContadorClave, Nivel;
    private claveB claveIni, claveFin;

    public paginaB(int nivel)
    {
        this.Nivel = nivel;
        this.ContadorClave = 0;

        this.claveIni = null;
        this.claveFin = null;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::: CLAVES :::::::::::::::::::::::::::::::::::::::::::::::::::::

    private boolean clavesVacio()
    {
        return this.claveIni == null;
    }

    public claveB InsertarClave(claveB nuevo)
    {

        if (this.clavesVacio())
        {
            this.claveIni = nuevo;
            this.claveFin = nuevo;
        }
        else if(nuevo.getClave() < this.claveIni.getClave())
        {
            this.claveIni.setHijoIzq(nuevo.getHijoDer());

            nuevo.setSiguiente(this.claveIni);
            this.claveIni.setAnterior(nuevo);
            this.claveIni = nuevo;
        }
        else if(nuevo.getClave() >= this.claveFin.getClave())
        {
            this.claveFin.setHijoDer(nuevo.getHijoIzq());

            nuevo.setAnterior(this.claveFin);
            this.claveFin.setSiguiente(nuevo);
            this.claveFin = nuevo;
        }
        else
        {
            claveB aux = this.claveIni;

            while(aux.getSiguiente() != null)
            {
                if((nuevo.getClave() > aux.getClave() || nuevo.getClave() == aux.getClave()) && nuevo.getClave() < aux.getSiguiente().getClave())
                {

                    aux.setHijoDer(nuevo.getHijoIzq());
                    aux.getSiguiente().setHijoIzq(nuevo.getHijoDer());

                    nuevo.setSiguiente(aux.getSiguiente());
                    nuevo.setAnterior(aux);

                    aux.getSiguiente().setAnterior(nuevo);
                    aux.setSiguiente(nuevo);

                    break;
                }

                aux = aux.getSiguiente();
            }
        }

        this.ContadorClave++;
        return nuevo;
    }

    public claveB BuscarClave(int dato)
    {
        claveB aux = this.claveIni;
        while(aux != null)
        {
            if(dato == aux.getClave())
                return aux;

            aux = aux.getSiguiente();
        }

        return null;
    }

    public claveB EliminarClave(int dato)
    {
        if (!this.clavesVacio())
        {
            if (this.ContadorClave == 1)
            {
                claveB aux = this.claveIni;

                this.claveIni = null;
                this.claveFin = null;

                this.ContadorClave--;
                return aux;
            }
            else
            {
                if(dato == this.claveIni.getClave())
                {
                    claveB aux = this.claveIni;

                    this.claveIni.getSiguiente().setAnterior(null);
                    this.claveIni = this.claveIni.getSiguiente();

                    this.ContadorClave--;
                    return aux;
                }
                else if(dato == this.claveFin.getClave())
                {
                    claveB aux = this.claveFin;

                    this.claveFin.getAnterior().setSiguiente(null);
                    this.claveFin = this.claveFin.getAnterior();

                    this.ContadorClave--;
                    return aux;
                }
                else
                {
                    claveB aux = this.BuscarClave(dato);
                    if (aux != null) {
                        aux.getAnterior().setSiguiente(aux.getSiguiente());
                        aux.getSiguiente().setAnterior(aux.getAnterior());

                        this.ContadorClave--;
                        return aux;
                    }
                }
            }
        }
        return null;
    }

    public claveB ObtenerClave(int dato)
    {
        if (dato <= this.ContadorClave) {

            claveB aux = this.claveIni;
            for (int i = 1; i < dato; i++) {
                aux = aux.getSiguiente();
            }

            return aux;
        }

        return null;
    }


    private int numClaves()
    {
        if ((this.ContadorClave % 2) == 0) {
            return this.ContadorClave/2;
        }
        else
        {
            return (this.ContadorClave/2) + 1;
        }
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::: HIJOS :::::::::::::::::::::::::::::::::::::::::::::::::::::

    public paginaB ObtenerHijo(int dato)
    {
        if (dato < this.claveIni.getClave())
            return this.claveIni.getHijoIzq();
        else if (dato > this.claveFin.getClave())
            return this.claveFin.getHijoDer();
        else
        {
            claveB aux = this.claveIni;
            while(aux.getSiguiente() != null)
            {
                if((dato > aux.getClave() || dato == aux.getClave()) && dato < aux.getSiguiente().getClave())
                    return aux.getHijoDer();

                aux = aux.getSiguiente();
            }
            return null;
        }
    }

    public void DefinirHijo(paginaB hijo, int dato)
    {
        if (dato < this.claveIni.getClave())
            this.claveIni.setHijoIzq(hijo);
        else if (dato > this.claveFin.getClave())
            this.claveFin.setHijoDer(hijo);
        else
        {
            claveB aux = this.claveIni;
            while(aux.getSiguiente() != null)
            {
                if((dato > aux.getClave() || dato == aux.getClave()) && dato < aux.getSiguiente().getClave())
                {
                    aux.setHijoDer(hijo);
                    aux.getSiguiente().setHijoIzq(hijo);
                }

                aux = aux.getSiguiente();
            }
        }
    }

    public paginaB DividirPagina(paginaB nodo, int tipo)
    {
        switch(tipo)
        {
            case 0:
                nodo.InsertarClave(this.ObtenerClave(this.numClaves()));
                break;
            case 1:
                for (int i = 1; i < this.numClaves(); i++) {
                    nodo.InsertarClave(this.ObtenerClave(i));
                }
                break;
            case 2:
                for (int i = (this.numClaves() +1 ); i <= this.ContadorClave; i++) {
                    nodo.InsertarClave(this.ObtenerClave(i));
                }
                break;
        }

        return nodo;
    }

    public void LimpiarEnlaces()
    {
        this.claveIni.setAnterior(null);
        this.claveFin.setSiguiente(null);

    }

    public String RecorrerClaveIF()
    {
        String retorno = "";

        claveB aux = this.claveIni;
        while(aux != null)
        {
            retorno += aux.getClave() + " | ";

            aux = aux.getSiguiente();
        }

        return retorno;
    }


    //::::::::::::::::::::::::::::::::::::::::::::::::::: ENCAPSULADO :::::::::::::::::::::::::::::::::::::::::::::::::::::

    public String datosNodo(int tipo, int pos)
    {
        String retorno = "nodoH" + this.getNivel() + "P" + pos;

        switch(tipo)
        {
            case 0:
                retorno += ":h" + pos;
                break;
            case 1:

                claveB aux = this.claveIni;
                retorno += "[label = \"";

                for (int i = 1; i <= this.ContadorClave; i++) {
                    retorno += "<h" + i + ">|<c"+ i + "> "+ aux.getClave() + " |";

                    aux = aux.getSiguiente();
                }

                retorno += "<h" + (this.ContadorClave  + 1) + ">\"];\n";
                break;
        }

        return retorno;
    }

    //::::::::::::::::::::::::::::::::::::::::::::::::::: ENCAPSULADO :::::::::::::::::::::::::::::::::::::::::::::::::::::

    public int getContadorClave() {
        return ContadorClave;
    }

    public int getNivel() {
        return Nivel;
    }

    public void setNivel(int Nivel) {
        this.Nivel = Nivel;
    }


}

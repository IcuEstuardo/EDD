package AVL;

/**
 *
 * @author estuardo
 */
public class ArbolAVL {
    
    private nodoAVL Raiz;
    private String txtDatos;
    
    public ArbolAVL()
    {
        this.txtDatos = "";
        this.Raiz = null;
    }
    
    public void Insercion(int id)
    {
        this.Raiz = this.InsertarNodo(this.Raiz, id);
        this.Raiz = this.BalancearArbol(this.Raiz);
    }
    
    private nodoAVL InsertarNodo(nodoAVL raiz, int id)
    {
        if(raiz == null)
            raiz = new nodoAVL(id);
        else
        {
            if(id < raiz.getClave())
                raiz.setNdIzquierda(this.InsertarNodo(raiz.getNdIzquierda(), id));
            else if (id > raiz.getClave())
                raiz.setNdDerecha(this.InsertarNodo(raiz.getNdDerecha(), id));   
        }
        
        raiz.setAltura(Math.max(this.Altura(raiz.getNdIzquierda()), this.Altura(raiz.getNdDerecha())) +1);
        return raiz;
    }
    
    
    private nodoAVL BalancearArbol(nodoAVL raiz)
    {
        if(raiz != null)
        {
            raiz.setNdIzquierda(this.BalancearArbol(raiz.getNdIzquierda()));
            raiz.setNdDerecha(this.BalancearArbol(raiz.getNdDerecha()));

            if (this.FactorEq(raiz) == 2) 
            {
                if (this.FactorEq(raiz.getNdIzquierda()) == 1)
                    return this.RotacionII(raiz);
                else if (this.FactorEq(raiz.getNdIzquierda()) == -1)
                    return this.RotacionID(raiz);    
                    
            }
            
            else if (this.FactorEq(raiz) == -2) 
            {
                if (this.FactorEq(raiz.getNdDerecha()) == -1)
                   return this.RotacionDD(raiz);
                else if (this.FactorEq(raiz.getNdDerecha()) == 1)
                    return this.RotacionDI(raiz);
            }
        }
        return raiz;
    }
    
    private nodoAVL RotacionII(nodoAVL nodo)
    {
        nodoAVL nodo1 = nodo.getNdIzquierda();
        
        nodo.setNdIzquierda(nodo1.getNdDerecha());
        nodo1.setNdDerecha(nodo);
        
        nodo.setAltura(Math.max(this.Altura(nodo.getNdIzquierda()), this.Altura(nodo.getNdDerecha()))+1);
        nodo1.setAltura(Math.max(this.Altura(nodo1.getNdIzquierda()), this.Altura(nodo1.getNdDerecha()))+1);
        
        return nodo1;
    }
    
    private nodoAVL RotacionDD(nodoAVL nodo)
    {
        nodoAVL nodo1 = nodo.getNdDerecha();
        
        nodo.setNdDerecha(nodo1.getNdIzquierda());
        nodo1.setNdIzquierda(nodo);
        
        nodo.setAltura(Math.max(this.Altura(nodo.getNdIzquierda()), this.Altura(nodo.getNdDerecha()))+1);
        nodo1.setAltura(Math.max(this.Altura(nodo1.getNdIzquierda()), this.Altura(nodo1.getNdDerecha()))+1);
        
        return nodo1;        
    }
    
    private nodoAVL RotacionID(nodoAVL nodo)
    {
        nodoAVL nodo1 = nodo.getNdIzquierda();
        nodoAVL nodo2 = nodo1.getNdDerecha();
        
        nodo1.setNdDerecha(nodo2.getNdIzquierda());
        nodo2.setNdIzquierda(nodo1);
        
        nodo.setNdIzquierda(nodo2.getNdDerecha());
        nodo2.setNdDerecha(nodo);
        
        nodo.setAltura(Math.max(this.Altura(nodo.getNdIzquierda()), this.Altura(nodo.getNdDerecha()))+1);
        nodo1.setAltura(Math.max(this.Altura(nodo1.getNdIzquierda()), this.Altura(nodo1.getNdDerecha()))+1);
        nodo2.setAltura(Math.max(this.Altura(nodo2.getNdIzquierda()), this.Altura(nodo2.getNdDerecha()))+1);
        
        return nodo2;
    }
    
    private nodoAVL RotacionDI(nodoAVL nodo)
    {
        nodoAVL nodo1 = nodo.getNdDerecha();
        nodoAVL nodo2 = nodo1.getNdIzquierda();
        
        nodo1.setNdIzquierda(nodo2.getNdDerecha());
        nodo2.setNdDerecha(nodo1);
        
        nodo.setNdDerecha(nodo2.getNdIzquierda());
        nodo2.setNdIzquierda(nodo);
        
        nodo.setAltura(Math.max(this.Altura(nodo.getNdIzquierda()), this.Altura(nodo.getNdDerecha()))+1);
        nodo1.setAltura(Math.max(this.Altura(nodo1.getNdIzquierda()), this.Altura(nodo1.getNdDerecha()))+1);
        nodo2.setAltura(Math.max(this.Altura(nodo2.getNdIzquierda()), this.Altura(nodo2.getNdDerecha()))+1);
        
        return nodo2;
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
    
    private void enOrden(nodoAVL raiz)
    {
        if(raiz != null)
        {
            this.enOrden(raiz.getNdIzquierda());
            System.out.print(raiz.getClave() + " ");
            this.enOrden(raiz.getNdDerecha());
        }
    }
    
    private void preOrden(nodoAVL raiz)
    {
        if(raiz != null)
        {
            System.out.print(raiz.getClave() + " ");
            this.enOrden(raiz.getNdIzquierda());
            this.enOrden(raiz.getNdDerecha());
        }
    }    

    private void postOrden(nodoAVL raiz)
    {
        if(raiz != null)
        {
            this.enOrden(raiz.getNdIzquierda());
            this.enOrden(raiz.getNdDerecha());
            System.out.print(raiz.getClave() + " ");
        }
    }    
    
    
    public nodoAVL Busqueda(int id)
    {
        return this.buscarHoja(this.Raiz, id);
    }
    
    private nodoAVL buscarHoja(nodoAVL raiz, int id)
    {
        if(raiz != null)
        {
            if(id == raiz.getClave())
                return raiz;
            else
            {
                if(id < raiz.getClave())
                    return this.buscarHoja(raiz.getNdIzquierda(), id);
                else
                    return this.buscarHoja(raiz.getNdDerecha(), id);
            }
        }
        return null;
    }
    
    
    public String Grafica()
    {
        this.txtDatos = "";
        this.graficarArbol(this.Raiz);
        return this.txtDatos;
    }
    
    private void graficarArbol(nodoAVL raiz)
    {
        if(raiz != null)
        {
            txtDatos += raiz.datosNodo(1) + "\n";
            
            if(raiz.getNdIzquierda() != null)
            {
                txtDatos += raiz.datosNodo(0) + " -> " + raiz.getNdIzquierda().datosNodo(0) + ";\n";
                this.graficarArbol(raiz.getNdIzquierda());
            }
            
            if(raiz.getNdDerecha() != null)
            {
                txtDatos += raiz.datosNodo(0) + " -> " + raiz.getNdDerecha().datosNodo(0) + ";\n";
                this.graficarArbol(raiz.getNdDerecha());
            }
        }
    }
   
    
    private int FactorEq(nodoAVL raiz)
    {
        return this.Altura(raiz.getNdIzquierda()) - this.Altura(raiz.getNdDerecha());
    }
    
    private int Altura(nodoAVL raiz)
    {
        if(raiz == null)
            return -1;
        else
            return raiz.getAltura();
    }
}

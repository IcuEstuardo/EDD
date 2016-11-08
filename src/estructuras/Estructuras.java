package estructuras;

import AVL.ArbolAVL;
import SPL.ArbolSPL;

public class Estructuras {

    public static void main(String[] args) {

        try {
            Herramientas ven = new Herramientas();
//            ArbolAVL arbolAVL = new ArbolAVL();
//
//            arbolAVL.Insercion(34);
//            arbolAVL.Insercion(56);
//            arbolAVL.Insercion(19);
//            arbolAVL.Insercion(89);
//            arbolAVL.Insercion(43);
//            arbolAVL.Insercion(0);
//            arbolAVL.Insercion(8);
//            arbolAVL.Insercion(4);
//            arbolAVL.Insercion(20);
//
//            arbolAVL.Recorrido(1);
//            arbolAVL.Recorrido(2);
//            arbolAVL.Recorrido(3);
//
//            ven.graficarEstructura(arbolAVL.Grafica());

            ArbolSPL arbolSPL = new ArbolSPL();

            arbolSPL.Insercion(34);
            arbolSPL.Insercion(56);
            arbolSPL.Insercion(19);
            arbolSPL.Insercion(89);
            arbolSPL.Insercion(43);

            // arbolSPL.Insercion(0);
            // arbolSPL.Insercion(8);
            // arbolSPL.Insercion(4);
            // arbolSPL.Insercion(20);

            arbolSPL.Recorrido(1);
            arbolSPL.Recorrido(2);
            arbolSPL.Recorrido(3);

            ven.graficarEstructura(arbolSPL.Grafica());

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + "\n       " + e.toString());
        }
    }

}

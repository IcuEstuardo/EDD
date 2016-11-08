package Dijkstra;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

/**
 *
 * @author Isabel
 */
public class Dijkstra {

    private ArrayList<Vertice> ListaVertices;

    public void AgregarVertices(String ubi) {
        this.ListaVertices = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(ubi));
            String line = br.readLine();

            while (null != line) {
                String[] fields = line.split("->");


                line = br.readLine();
            }

        } catch (Exception e) {

        }

    }

    public void MostrarVertices() {
        for (Vertice nodo : this.ListaVertices) {
            System.out.println(nodo.getNombre());
        }
    }

}

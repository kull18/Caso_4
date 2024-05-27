import java.io.FileWriter;
import java.io.PrintWriter;
public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void agregar(Participante participante) {
        raiz = agregarRecursivo(raiz, participante);
    }

    public Nodo agregarRecursivo(Nodo nodo, Participante participante) {
        if (nodo == null) {
            return new Nodo(participante);
        }

        if (participante.getFolio() < nodo.participante.getFolio()) {
            nodo.izquierdo = agregarRecursivo(nodo.izquierdo, participante);
        } else if (participante.getFolio() > nodo.participante.getFolio()) {
            nodo.derecho = agregarRecursivo(nodo.derecho, participante);
        } else {
            System.out.println("El folio " + participante.getFolio() + " ya existe. No se puede agregar el participante.");
        }

        return nodo;
    }

    public boolean mostrarInOrden() {
        mostrarInOrdenRecursivo(raiz);
        return false;
    }

    private boolean mostrarInOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            mostrarInOrdenRecursivo(nodo.izquierdo);
            System.out.println(nodo.participante);
            mostrarInOrdenRecursivo(nodo.derecho);
        }
        return false;
    }

    public void mostrarNodoDerecho() {
        if (raiz != null && raiz.derecho != null) {
            System.out.println(raiz.derecho.participante);
        } else {
            System.out.println("No hay nodo derecho.");
        }
    }

    public void mostrarNodoIzquierdo() {
        if (raiz != null && raiz.izquierdo != null) {
            System.out.println(raiz.izquierdo.participante);
        } else {
            System.out.println("No hay nodo izquierdo.");
        }
    }

    public void escribirInformacion() {

        try (FileWriter fichero = new FileWriter("prueba.txt"))//Nombre del archivo de texto
        {
            PrintWriter pw = new PrintWriter(fichero);

            pw.println(mostrarInOrdenRecursivo(raiz));


        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
import java.util.ArrayList;
import java.util.List;

public class ArbolBinario {
    private Nodo raiz;

    public ArbolBinario() {

    }

    public void agregar(Participante participante) {
        raiz = agregarRecursivo(raiz, participante);
    }

     Nodo agregarRecursivo(Nodo nodoActual, Participante participante) {
        if (nodoActual == null) {
            return new Nodo(participante);
        }

        if (participante.getFolio() < nodoActual.participante.getFolio()) {
            nodoActual.izquierdo = agregarRecursivo(nodoActual.izquierdo, participante);
        } else if (participante.getFolio() > nodoActual.participante.getFolio()) {
            nodoActual.derecho = agregarRecursivo(nodoActual.derecho, participante);
        }

        return nodoActual;
    }

    public List<Participante> inorden() {
        List<Participante> participantes = new ArrayList<>();
        inordenRecursivo(raiz, participantes);
        return participantes;
    }

    public void inordenRecursivo(Nodo nodoActual, List<Participante> lista) {
        if (nodoActual != null) {
            inordenRecursivo(nodoActual.izquierdo, lista);
            lista.add(nodoActual.participante);
            inordenRecursivo(nodoActual.derecho, lista);
        }
    }
}


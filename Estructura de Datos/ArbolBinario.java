import java.util.HashMap;
import java.util.Map;
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

    private Nodo agregarRecursivo(Nodo nodo, Participante participante) {
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

    private void mostrarInOrdenRecursivo(Nodo nodo) {
        if (nodo != null) {
            mostrarInOrdenRecursivo(nodo.izquierdo);
            System.out.println(nodo.participante);
            mostrarInOrdenRecursivo(nodo.derecho);
        }
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

    public void mostrarPromedioEdad() {
        int[] sumAndCount = calcularSumaYCuentaEdades(raiz);
        if (sumAndCount[1] == 0) {
            System.out.println("No hay participantes en el árbol.");
        } else {
            double promedio = (double) sumAndCount[0] / sumAndCount[1];
            System.out.println("El promedio de edad de los participantes es: " + promedio);
        }
    }

    private int[] calcularSumaYCuentaEdades(Nodo nodo) {
        if (nodo == null) {
            return new int[]{0, 0};
        }
        int[] izq = calcularSumaYCuentaEdades(nodo.izquierdo);
        int[] der = calcularSumaYCuentaEdades(nodo.derecho);
        int suma = izq[0] + der[0] + nodo.participante.getEdad();
        int cuenta = izq[1] + der[1] + 1;
        return new int[]{suma, cuenta};
    }

    public void mostrarCantidadPorCategoria() {
        Map<String, Integer> conteoCategorias = contarParticipantesPorCategoria(raiz, new HashMap<>());
        for (Map.Entry<String, Integer> entry : conteoCategorias.entrySet()) {
            System.out.println("Categoría: " + entry.getKey() + ", Cantidad: " + entry.getValue());
        }
    }

    private Map<String, Integer> contarParticipantesPorCategoria(Nodo nodo, Map<String, Integer> conteo) {
        if (nodo == null) {
            return conteo;
        }
        conteo.put(nodo.participante.getCategoria(), conteo.getOrDefault(nodo.participante.getCategoria(), 0) + 1);
        contarParticipantesPorCategoria(nodo.izquierdo, conteo);
        contarParticipantesPorCategoria(nodo.derecho, conteo);
        return conteo;
    }



}
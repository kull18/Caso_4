import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        if(participante.getCategoria().equals("Principiante") || participante.getCategoria().equals("Intermedio") || participante.getCategoria().equals("Avanzado")) {
            if (participante.getFolio() < nodo.participante.getFolio()) {
                nodo.izquierdo = agregarRecursivo(nodo.izquierdo, participante);
            } else if (participante.getFolio() > nodo.participante.getFolio()) {
                nodo.derecho = agregarRecursivo(nodo.derecho, participante);
            } else {
                System.out.println("El folio " + participante.getFolio() + " ya existe. No se puede agregar el participante.");
            }

        }else {
            System.out.println("error al escribir la categoria");
        }
        return nodo;
    }

    public List<Participante> mostrarInOrden() {
        List<Participante> participantes = new ArrayList<>();
        mostrarInOrdenRecursivo(raiz, participantes);
        return participantes;
    }

    private void mostrarInOrdenRecursivo(Nodo nodo, List<Participante> participantes) {
        if (nodo != null) {
            mostrarInOrdenRecursivo(nodo.izquierdo, participantes);
            participantes.add(nodo.participante);
            System.out.println(nodo.participante);
            mostrarInOrdenRecursivo(nodo.derecho, participantes);
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

    // Inner class Nodo and class Participante should be defined here or separately
}
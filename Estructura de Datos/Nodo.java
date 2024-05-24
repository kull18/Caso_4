public class Nodo {
    Participante participante;
    Nodo izquierdo, derecho;

    public Nodo(Participante participante) {
        this.participante = participante;
        izquierdo = derecho = null;
    }
}


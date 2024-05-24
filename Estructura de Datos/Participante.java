public class Participante {
    private int folio;
    private String categoria;
    private int edad;

    public Participante(int folio, String categoria, int edad) {
        this.folio = folio;
        this.categoria = categoria;
        this.edad = edad;
    }

    public int getFolio() {
        return folio;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "Folio: " + folio + ", Categoría: " + categoria + ", Edad: " + edad;
    }
}


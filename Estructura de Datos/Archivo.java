import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.List;

public class Archivo {
    public void showALL(List<Participante> particpante) {
        try(FileWriter fichero = new FileWriter("participantes.txt")) {
            PrintWriter escribir = new PrintWriter(fichero);
            for(Participante participante: particpante) {
                escribir.println(participante);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}

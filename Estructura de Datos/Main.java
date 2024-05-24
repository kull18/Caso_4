import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArbolBinario arbol = new ArbolBinario();
        Scanner scanner = new Scanner(System.in);
        Participante[] participantesIniciales = {
            new Participante(1001, "Principiante", 20),
            new Participante(1002, "Intermedio", 25),
            new Participante(1003, "Avanzado", 30),
            new Participante(1004, "Principiante", 22),
            new Participante(1005, "Intermedio", 27)
        };

        for (Participante p : participantesIniciales) {
            arbol.agregar(p);
        }

        ArbolBinario arbolbinario = new ArbolBinario();

        int opcion=0;

        do{
            System.out.println("Elige una opción");
            System.out.println("1. Ingresar los datos \n 2. Mostrar datos \n 3.Mostar datos \n 4.Mostrar nodo derecho \n 5.Mostrar ndo izquierdo");

            opcion = scanner.nextInt();
            switch(opcion){
                case 1:
                    Participante participantes= new Participante (0,"",0);
                    break;

                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;

                case 6:
                    break;
                default: System.out.println("Ingresa otros datos");
            }
        }while(opcion != 7);
    }
}

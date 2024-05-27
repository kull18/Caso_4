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

        for (Participante p : participantesIniciales) {;
            arbol.agregar(p);
        }

        int opcion = 0;

        do {
            System.out.println("Elige una opción");
            System.out.println("1. Ingresar datos");
            System.out.println("2. Mostrar datos en orden");
            System.out.println("3. Mostrar nodo derecho");
            System.out.println("4. Mostrar nodo izquierdo");
            System.out.println("5. Salir");

            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next();
            }

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch(opcion) {
                case 1:
                    int folio = leerEnteroPositivo(scanner, "Ingresa el folio:");
                    System.out.println("Ingresa la categoría:");
                    String categoria = scanner.nextLine();
                    int edad = leerEnteroPositivo(scanner, "Ingresa la edad:");
                    if(categoria.equals("intermedio") || categoria.equals("avanzado") || categoria.equals("principiante")) {
                        Participante participante = new Participante(folio, categoria, edad);
                        arbol.agregar(participante);
                    }else {
                        System.out.println("no existe esa categoria");
                    }
                    break;

                case 2:
                    arbol.mostrarInOrden();
                    break;

                case 3:
                    arbol.mostrarNodoDerecho();
                    break;

                case 4:
                    arbol.mostrarNodoIzquierdo();
                    break;

                case 5:
                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while(opcion != 5);

        scanner.close();
    }

    private static int leerEnteroPositivo(Scanner scanner, String mensaje) {
        int numero = -1;
        while (numero < 0) {
            System.out.println(mensaje);
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingresa un número válido.");
                scanner.next();
            }
            numero = scanner.nextInt();
            scanner.nextLine();
            if (numero < 0) {
                System.out.println("El número debe ser positivo. Inténtalo de nuevo.");
            }
        }
        return numero;
    }
}
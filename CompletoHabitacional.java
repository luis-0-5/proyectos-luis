import java.util.Random;

public class CompletoHabitacional {

    public static void main(String[] args) {
        final int TORRES = 7;
        final int PISOS = 20;
        final int APTO_PISOS = 6;

        int[][][] apartamentos = new int[TORRES][PISOS][APTO_PISOS];
        Random rand = new Random();

        
        for (int t = 0; t < TORRES; t++)
            for (int p = 0; p < PISOS; p++)
                for (int a = 0; a < APTO_PISOS; a++)
                    apartamentos[t][p][a] = rand.nextInt(6);


        for (int t = 0; t < TORRES; t++) {
            System.out.println("\n╔══════════════════════════════════╗");
            System.out.printf( "║         TORRE  #%-2d               ║%n", (t+1));
            System.out.println("╠══════╦═════╦═════╦═════╦═════╦═════╦═════╣");
            System.out.println("║ Piso ║ A1  ║ A2  ║ A3  ║ A4  ║ A5  ║ A6  ║");
            System.out.println("╠══════╬═════╬═════╬═════╬═════╬═════╬═════╣");
            for (int p = 0; p < PISOS; p++) {
                System.out.printf("║  %2d  ║", (p+1));
                for (int a = 0; a < APTO_PISOS; a++) {
                    if (apartamentos[t][p][a] == 0)
                        System.out.printf("  -  ║");
                    else
                        System.out.printf("  %d  ║", apartamentos[t][p][a]);
                }
                System.out.println();
            }
            System.out.println("╚══════╩═════╩═════╩═════╩═════╩═════╩═════╝");
        }


        System.out.println("\n\n╔══════════════════════════════════════════════════╗");
        System.out.println("║    REPORTE FINAL DEL COMPLEJO HABITACIONAL       ║");
        System.out.println("╚══════════════════════════════════════════════════╝");


        System.out.println("\n1. Promedio de habitantes por PISO:");
        for (int p = 0; p < PISOS; p++) {
            int suma = 0;
            for (int t = 0; t < TORRES; t++)
                for (int a = 0; a < APTO_PISOS; a++)
                    suma += apartamentos[t][p][a];
            double promedio = (double) suma / (TORRES * APTO_PISOS);
            System.out.printf("   Piso %2d: %.2f hab. promedio%n", (p+1), promedio);
        }


        System.out.println("\n2. Habitantes del COMPLEJO:");
        int totalapartamentos = 0;
        for (int t = 0; t < TORRES; t++) {
            int sumaTorre = 0;
            for (int p = 0; p < PISOS; p++)
                for (int a = 0; a < APTO_PISOS; a++)
                    sumaTorre += apartamentos[t][p][a];
            System.out.println("   Torre " + (t+1) + ": " + sumaTorre + " habitantes");
            totalapartamentos += sumaTorre;
        }
        System.out.println("   TOTAL: " + totalapartamentos + " habitantes");


        System.out.println("\n3. Promedio de habitantes por TORRE:");
        for (int t = 0; t < TORRES; t++) {
            int suma = 0;
            for (int p = 0; p < PISOS; p++)
                for (int a = 0; a < APTO_PISOS; a++)
                    suma += apartamentos[t][p][a];
            double promedio = (double) suma / (PISOS * APTO_PISOS);
            System.out.printf("   Torre %d: %.2f hab. promedio%n", (t+1), promedio);
        }


        System.out.println("\n4. Apartamentos  disponibles :");
        int totalDisponibles = 0;
        for (int t = 0; t < TORRES; t++)
            for (int p = 0; p < PISOS; p++)
                for (int a = 0; a < APTO_PISOS; a++)
                    if (apartamentos[t][p][a] == 0) {
                        System.out.println("   Torre " + (t+1) + " - Piso " + (p+1) + " - Apto " + (a+1));
                        totalDisponibles++;
                    }
        System.out.println("   Total disponibles: " + totalDisponibles);
    }
}
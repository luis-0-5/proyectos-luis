import java.util.Scanner;
import java.text.NumberFormat;
import java.util.Locale;
/*Nomina Luis#5 5toE

 */

public class Nomina {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Locale rd = new Locale("es", "DO");
        NumberFormat formatoRD = NumberFormat.getCurrencyInstance(rd);

        final int PRSNAS_MAX = 10;

        String[] nombre = new String[PRSNAS_MAX];
        String[] apellido = new String[PRSNAS_MAX];
        String[] departamento = new String[PRSNAS_MAX];
        String[] puesto = new String[PRSNAS_MAX];
        int[] ingreso = new int[PRSNAS_MAX];

        double[] salario = new double[PRSNAS_MAX];
        double[] prestamo = new double[PRSNAS_MAX];

        double[] sfs = new double[PRSNAS_MAX];
        double[] sfse = new double[PRSNAS_MAX];

        double[] afp = new double[PRSNAS_MAX];
        double[] afpe = new double[PRSNAS_MAX];

        double[] isr = new double[PRSNAS_MAX];
        double[] totalDesc = new double[PRSNAS_MAX];
        double[] salarioNeto = new double[PRSNAS_MAX];

        int cantidad = 0;
        int opcion;

        do {
            System.out.println("\n========= NOMINA DE EMPLEADOS CCN =========");
            System.out.println("1. Crear Nomina");
            System.out.println("2. Modificar Registro");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {

                case 1:

                    System.out.print("Cuantos empleados desea ingresar (Maximo de 10): ");
                    cantidad = sc.nextInt();
                    sc.nextLine();

                    for (int i = 0; i < cantidad; i++) {

                        System.out.println("\nEmpleado #" + (i + 1));

                        System.out.print("Nombre: ");
                        nombre[i] = sc.nextLine();

                        System.out.print("Apellido: ");
                        apellido[i] = sc.nextLine();

                        System.out.print("Departamento: ");
                        departamento[i] = sc.nextLine();

                        System.out.print("Puesto: ");
                        puesto[i] = sc.nextLine();

                        System.out.print("Año de ingreso: ");
                        ingreso[i] = sc.nextInt();

                        System.out.print("Salario mensual: ");
                        salario[i] = sc.nextDouble();

                        System.out.print("Descuento de prestamo (0 si no tiene): ");
                        prestamo[i] = sc.nextDouble();
                        sc.nextLine();


                        sfs[i] = salario[i] * 0.0304;
                        sfse[i] = salario[i] * 0.0709;

                        afp[i] = salario[i] * 0.0287;
                        afpe[i] = salario[i] * 0.0710;



                        double salarioAnual = salario[i] * 12;
                        double baseISR = salarioAnual - (sfs[i] * 12) - (afp[i] * 12);

                        double isrAnual;

                        if (baseISR <= 416220.00) {
                            isrAnual = 0;
                        } else if (baseISR <= 624329.00) {
                            isrAnual = (baseISR - 416220.01) * 0.15;
                        } else if (baseISR <= 867123.00) {
                            isrAnual = (baseISR - 624329.01) * 0.20 + 31216.00;
                        } else {
                            isrAnual = (baseISR - 867123.01) * 0.25 + 79776.00;
                        }


                        isr[i] = isrAnual / 12;

                        totalDesc[i] = prestamo[i] + sfs[i] + afp[i] + isr[i];
                        salarioNeto[i] = salario[i] - totalDesc[i];
                    }

                    System.out.println("\nEMPRESA CCN");
                    System.out.println("NOMINA MES DE FEBRERO 2026");
                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                    System.out.printf("%-8s %-10s %-12s %-12s %-12s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s%n",
                            "CODIGO", "DEPTO", "PUESTO", "NOMBRE", "APELLIDO",
                            "SALARIO", "PREST", "SFS", "SFSE",
                            "AFP", "AFPE", "ISR", "S.NETO");

                    System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

                    for (int i = 0; i < cantidad; i++) {

                        String codigo = (i + 1) + "" +
                                nombre[i].charAt(0) +
                                apellido[i].charAt(0) +
                                ingreso[i];

                        System.out.printf("%-8s %-10s %-12s %-12s %-12s %-15s %-15s %-15s %-15s %-15s %-15s %-15s %-15s%n",
                                codigo,
                                departamento[i],
                                puesto[i],
                                nombre[i],
                                apellido[i],
                                formatoRD.format(salario[i]),
                                formatoRD.format(prestamo[i]),
                                formatoRD.format(sfs[i]),
                                formatoRD.format(sfse[i]),
                                formatoRD.format(afp[i]),
                                formatoRD.format(afpe[i]),
                                formatoRD.format(isr[i]),
                                formatoRD.format(salarioNeto[i]));
                    }

                    break;

                case 2:

                    System.out.print("Ingrese numero de empleado a modificar: ");
                    int modif_emp = sc.nextInt() - 1;
                    sc.nextLine();

                    if (modif_emp >= 0 && modif_emp < cantidad) {
                        System.out.println("Modificar:" +
                                " \nNombre" +
                                "\nApellido" +
                                "\nFecha de ingreso"+
                                "\nSalario" +
                                "\nDescuento" +
                                "\n");
                        int elecc_emp = sc.nextInt();
                        switch (elecc_emp) {
                            case 1:
                                System.out.println("Nuevo nombre:");
                                nombre[modif_emp] = sc.nextLine();

                            case 2:
                                System.out.println("Nuevo apellido: ");
                                apellido[modif_emp] = sc.nextLine();

                            case 3:
                                System.out.println("Nuevo ingreso: ");
                                ingreso[modif_emp] = sc.nextInt();

                            case 4:
                                System.out.print("Nuevo salario mensual: ");
                                salario[modif_emp] = sc.nextDouble();

                            case 5:
                                System.out.print("Nuevo descuento prestamo: ");
                                prestamo[modif_emp] = sc.nextDouble();
                                sc.nextLine();
                            default:
                                System.out.println("Opcion invalida");
                                break;
                        }




                        sfs[modif_emp] = salario[modif_emp] * 0.0304;
                        sfse[modif_emp] = salario[modif_emp] * 0.0709;

                        afp[modif_emp] = salario[modif_emp] * 0.0287;
                        afpe[modif_emp] = salario[modif_emp] * 0.0710;

                        double salarioAnual = salario[modif_emp] * 12;
                        double baseISR = salarioAnual - (sfs[modif_emp] * 12) - (afp[modif_emp] * 12);

                        double isrAnual;

                        if (baseISR <= 416220.00) {
                            isrAnual = 0;
                        } else if (baseISR <= 624329.00) {
                            isrAnual = (baseISR - 416220.01) * 0.15;
                        } else if (baseISR <= 867123.00) {
                            isrAnual = (baseISR - 624329.01) * 0.20 + 31216.00;
                        } else {
                            isrAnual = (baseISR - 867123.01) * 0.25 + 79776.00;
                        }

                        isr[modif_emp] = isrAnual / 12;

                        totalDesc[modif_emp] = prestamo[modif_emp] + sfs[modif_emp] + afp[modif_emp] + isr[modif_emp];
                        salarioNeto[modif_emp] = salario[modif_emp] - totalDesc[modif_emp];

                        System.out.println("Se actualizaron correctamente los datos.");
                    } else {
                        System.out.println("Empleado no encontrado.");
                    }

                    break;

                case 3:
                    System.out.println("Gracias por su visita.");
                    break;

                default:
                    System.out.println("Opcion invalida.");
            }

        } while (opcion != 3);

        sc.close();
    }
}

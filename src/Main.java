import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);


        System.out.println("Ingrese su nombre");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese su apellido");
        String apellido = scanner.nextLine();


        Universidad universidad = Universidad.seleccionarUniversidad();
        System.out.println("Ha seleccionado la universidad "+universidad);

        System.out.println("Ingrese su matricula");
        String matricula = scanner.nextLine();

        Estudiante estudiante = new Estudiante(nombre,apellido,matricula,universidad);


        System.out.println("Bienvenido, "+estudiante.getNombre()+" "+estudiante.getApellido());
        menuPrincipal(estudiante);



    }

    public static void menuPrincipal(Estudiante estudiante){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu Principal"+"\n"+
                "1.Seleccionar una carrera"+"\n"+
                "2.Seleccionar asignatura"+"\n"+
                "3.Seleccionar profesor"+"\n"+
                "4.Consultar Asignaturas"+"\n"+
                "5.Realizar pagos"+"\n"+
                "6.Consultar Pagos"+"\n"+
                "7.Salir del programa"+"\n"

        );

        String opcion = scanner.nextLine();

        switch (opcion){
            case "1":
                Carrera.seleccionarCarrera(estudiante);

                break;
            case "2":
                Asignatura.seleccionarAsignatura(estudiante);
                break;
            case "3":
                Profesor.seleccionarProfesor(estudiante);
                break;
            case "4":
                Asignatura.consultarAsignaturas(estudiante);
                break;
            case "5":
                Pago.realizarPagos(estudiante);
                break;
            case"6":
                Pago.consultarPagos(estudiante);
                break;
            case "7":
                System.exit(0);
            default:
                System.out.println("Opcion no valida");
                menuPrincipal(estudiante);
        }
        menuPrincipal(estudiante);
    }


}



import java.util.List;
import java.util.Scanner;

public class Profesor extends Empleado {

    private static final Profesor [] profesores = {
            new Profesor("Juan","Perez"),
            new Profesor("Maria","Rojas"),
            new Profesor ("Jose","Lopez"),
            new Profesor("Aquiles","Castro"),
            new Profesor("Jose Rafael","Rojas Beriguete")
    };

    public Profesor(String nombre, String apellido) {
        super(nombre, apellido);
    }

    @Override
    public String toString() {
        return getNombre()+" "+getApellido();
    }

    public static void seleccionarProfesor(Estudiante estudiante){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione un profesor");

        for (int i=0;i<profesores.length;i++){
            System.out.println((i+1)+"."+profesores[i]);
        }

        int opcion = Integer.parseInt(scanner.nextLine());
        if (opcion>0 && opcion<=profesores.length){
            estudiante.agregarProfesor(profesores[opcion-1]);
            System.out.println("Ha seleccionado el/la profesor@ "+profesores[opcion-1]+" con exito!"+"\n");
        }else{
            System.out.println("Opcion incorrecta"+"\n");
            seleccionarProfesor(estudiante);
        }

    }
}

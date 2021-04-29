import java.util.List;
import java.util.Scanner;

public class Asignatura {

    public static final int  PRECIO_POR_CREDITO= 500;

    private static  final Asignatura[] asignaturas= {
            new Asignatura("Fisica Basica",4),
            new Asignatura("Matematica Basica",5),
            new Asignatura("Filosofia 1",3),
            new Asignatura("Biologia Basica",3),
            new Asignatura("Laboratorio de Fisica Basica",1),
            new Asignatura("Metodologia de la investigacion cientifica",3),
            new Asignatura("Lengua Espanola",4),
            new Asignatura("Programacion Estructurada",4)

    };


    private String nombre;
    private int creditos;

    public Asignatura(String nombre, int creditos) {
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    @Override
    public String toString() {
        return getNombre()+"  ("+getCreditos()+" creditos )";
    }

    public static void  consultarAsignaturas(Estudiante estudiante){


        List<Asignatura> asignaturas = estudiante.getAsignaturas();


        for(Asignatura asignatura:asignaturas){

            System.out.println("Nombre de la asignatura: "+asignatura.getNombre());
            System.out.println("Cantidad de creditos de la asignatura: "+asignatura.getCreditos()+"\n");


        }

    }

    public static void seleccionarAsignatura(Estudiante estudiante){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione una asignatura");

        for (int i=0;i<asignaturas.length;i++){
            System.out.println((i+1)+"."+asignaturas[i]);
        }

        int opcion = Integer.parseInt(scanner.nextLine());
        if (opcion>0 && opcion<=asignaturas.length){
            estudiante.agregarAsignatura(asignaturas[opcion-1]);
            System.out.println("Ha seleccionado la asignatura "+asignaturas[opcion-1]+" con exito!"+"\n");
        }else{
            System.out.println("Opcion incorrecta");
            seleccionarAsignatura(estudiante);
        }

    }


}

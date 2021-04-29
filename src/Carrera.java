import java.util.Scanner;

public class Carrera {
    private String nombre;


    public static final Carrera [] carreras = {
            new Carrera("Ingenieria en Sistemas"),
            new Carrera("Medicina"),
            new Carrera("Contabilidad"),
            new Carrera("Educacion"),
            new Carrera("Ingenieria Industrial"),
            new Carrera("Derecho")
    };

    public Carrera(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    public static void seleccionarCarrera(Estudiante estudiante){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione una carrera");

        for (int i = 0; i< carreras.length; i++){
            System.out.println((i+1)+"."+ carreras[i]);
        }

        int opcion = Integer.parseInt(scanner.nextLine());
        if (opcion>0 && opcion<=carreras.length){
            estudiante.setCarrera(carreras[opcion-1]);
            System.out.println("Ha seleccionado la carrera "+carreras[opcion-1]+" con exito!"+"\n");
        }else{
            System.out.println("Opcion incorrecta");
            seleccionarCarrera(estudiante);
        }

    }
}


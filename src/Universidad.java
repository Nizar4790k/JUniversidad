import java.util.Scanner;

public class Universidad {
    private String nombre;
    private String abreviatura;

    private static Universidad[] universidades = {
            new Universidad("Universidad Autonoma de Santo Domingo","UASD"),
            new Universidad("Universidad APEC","APEC"),
            new Universidad("Pontificia Universidad Católica Madre y Maestra","PUCMM"),
            new Universidad("Universidad Organizacion y Metodo ","O&M"),
            new Universidad("Instituto Tecnologico de Santo Domingo","INTEC")
    };

    public Universidad(String nombre,String abreviatura) {
        this.nombre = nombre;
        this.abreviatura = abreviatura;
    }


    public String toString(){
        return nombre+"-("+abreviatura+")";
    }

    public static Universidad seleccionarUniversidad(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Seleccione la universidad");

        for(int i=0;i<universidades.length;i++){
            System.out.println((i+1)+"."+universidades[i]);
        }

        int opcion  =Integer.parseInt(scanner.nextLine());

        if(opcion>0 && opcion<=universidades.length){
            return universidades[opcion-1];
        }else {
            System.out.println("Opcion no valida");
            seleccionarUniversidad();
        }

        return  null;
    }



}

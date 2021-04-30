import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Pago {
    private String concepto;
    private double monto;
    private Date fecha;
    private String reporte;


    public Pago(String concepto, double monto, Date fecha, String reporte) {
        this.concepto = concepto;
        this.monto = monto;
        this.fecha = fecha;
        this.reporte = reporte;
    }

    @Override
    public String toString(){
        return reporte;
    }

    public static void pagarInscripcion(Estudiante estudiante){

        StringBuilder sb = new StringBuilder();
        Date fecha = new Date();

        sb.append("*******************************PAGO DE INSCRIPCION********************************"+"\n");
        sb.append("**********************************************************************************"+"\n");


        sb.append("Fecha...."+fecha+"\n");
        sb.append("Nombre completo del estudiante.....:"+estudiante+"\n");
        sb.append("Matricula......"+estudiante.getMatricula()+"\n");
        sb.append("Universidad....."+estudiante.getUniversidad()+"\n");
        sb.append("*****************************************************************************"+"\n");
        sb.append("Precio por inscripcion: "+6500+" DOP "+"\n");


        String reporte = sb.toString();

        estudiante.agregarPago(new Pago("Pago de inscripcion", 6500, new Date(),reporte));

        System.out.println(reporte);
        System.out.println("Pago realizado con exito!"+"\n");

    }

    public static  void pagarAsignaturas(Estudiante estudiante){

        StringBuilder sb = new StringBuilder();

        List<Asignatura> asignaturas = estudiante.getAsignaturas();
        Date fecha = new Date();
        double montoTotal = 0;


        sb.append("*******************************PAGO DE CREDITOS********************************"+"\n");
        sb.append("****************************************************************************"+"\n");
        sb.append("Fecha...."+fecha+"\n");
        sb.append("Nombre completo del estudiante.....:"+estudiante+"\n");
        sb.append("Matricula......"+estudiante.getMatricula()+"\n");
        sb.append("Universidad....."+estudiante.getUniversidad()+"\n");
        sb.append("Precio por credito.......:"+Asignatura.PRECIO_POR_CREDITO+" DOP"+"\n");
        sb.append("*****************************************************************************"+"\n");

        sb.append("Nombre de la asignatura    "+"Cantidad de creditos      "+"Precio de la materia      "+"\n");

        sb.append("*****************************************************************************"+"\n");

        for (Asignatura as: asignaturas){
            int precioPorMateria = as.getCreditos()*Asignatura.PRECIO_POR_CREDITO;
            montoTotal+=precioPorMateria;
            sb.append("     "+as.getNombre()+"               "+as.getCreditos()+"                           "+precioPorMateria+"DOP"+"\n");

        }

        sb.append("-------------------------------------------------------------------------------------"+"\n");
        sb.append("Monto total:"+montoTotal+" DOP"+"\n");

        Pago pago = new Pago("Pago de creditos",montoTotal,fecha, sb.toString());
        estudiante.agregarPago(pago);
        System.out.println(pago.reporte);

        System.out.println("Pago realizado con exito!");
    }

    public static void consultarPagos(Estudiante estudiante){
        List<Pago> pagosRealizados = estudiante.getPagosRealizados();

        System.out.println("-----PAGOS REALIZADOS POR EL ESTUDIANTE "+estudiante);

        for (Pago pago: pagosRealizados){
            System.out.println(pago);
        }
    }

    public static void realizarPagos(Estudiante estudiante){

        Scanner scanner = new Scanner(System.in);


        System.out.println("Realizar pagos");
        System.out.println(
                "1.Pagar Inscripcion (6500 DOP/cuatrimestre)"+"\n"+
                        "2.Pagar Creditos (500 DOP/credito)"+"\n"+
                        "3.Volver al menu anterior"+"\n"
        );



        String opcion = scanner.nextLine();

        switch (opcion){
            case "1":
                Pago.pagarInscripcion(estudiante);
                break;
            case "2":
                Pago.pagarAsignaturas(estudiante);
                break;
            case "3":
                Main.menuPrincipal(estudiante);
            default:
                System.out.println("Opcion no valida");
                realizarPagos(estudiante);
                break;




        }

    }

}


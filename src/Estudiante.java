import java.util.ArrayList;
import java.util.List;

public class Estudiante {
    private String nombre;
    private String apellido;
    private String matricula;
    private Carrera carrera;
    private Universidad universidad;
    private List<Asignatura> asignaturas;
    private List<Profesor> profesores;
    private List<Pago> pagosRealizados;


    public Estudiante(String nombre, String apellido, String matricula,Universidad universidad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.matricula = matricula;
        this.universidad= universidad;
        asignaturas = new ArrayList<>();
        profesores = new ArrayList<>();
        pagosRealizados = new ArrayList<>();
    }

    public void setUniversidad(Universidad universidad) {
        this.universidad = universidad;
    }


    public Universidad getUniversidad() {
        return universidad;
    }

    public Carrera getCarrera() {
        return carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getMatricula() {
        return matricula;
    }

    public List<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public List<Pago> getPagosRealizados() {
        return pagosRealizados;
    }

    public void agregarAsignatura(Asignatura asignatura){
        this.asignaturas.add(asignatura);
    }

    public void setCarrera(Carrera carrera) {
        this.carrera = carrera;
    }

    public void agregarProfesor(Profesor profesor){
        this.profesores.add(profesor);
    }

    public void agregarPago(Pago pago){
        this.pagosRealizados.add(pago);
    }

    @Override
    public String toString() {
        return nombre+" "+apellido;
    }


}

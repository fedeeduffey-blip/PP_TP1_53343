import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class EventoUniversitario {
    private final String Id;
    private String titulo;
    private double costoBase;
    private boolean gratuito;
    private Sala sala;
    private List<Actividad> actividades= new ArrayList<>();

    private static int cantidadEventos;


    static {
        cantidadEventos = 0;
        System.out.println("Inicializador estático: se cargó la clase EventoUniversitario.");
    }

    public EventoUniversitario(String id, String nombre,  double costo, boolean esGratuito) {
        this.Id = id;
        setTitulo(nombre);
        this.gratuito = esGratuito;
        this.costoBase = gratuito ? 0 : costo;
        cantidadEventos++;
    }

    public EventoUniversitario(EventoUniversitario otroEvento) {
        this(
                otroEvento.Id + "-COPIA",
                otroEvento.titulo,
                otroEvento.costoBase,
                otroEvento.gratuito
        );
    }

    public String getId() {return Id;}

    public String getTitulo() {return titulo;}

    public void setTitulo(String nombre) {
        if (nombre != null && !nombre.isBlank()) {
            this.titulo = nombre;
        }
    }
    public double calcularCostoEstimado() {
        if (gratuito) {
            return 0;
        }
        return costoBase * 1.21;
    }
    public Sala getSala() {
        return sala;
    }

    public void asignarSala(Sala sala) {

        this.sala = sala;
    }
    public void crearActividad(int id, String titulo, int cupo) {
        Actividad actividad = new Actividad(id,titulo,cupo);

        this.actividades.add(actividad);
    }

    public List<Actividad> getActividades() {
        return Collections.unmodifiableList(actividades);
    }

    public void  mostrarDatos() {
        System.out.println("===================================================================================");
        System.out.println("Evento codigo=" + Id);
        System.out.println("TÍtulo=" + titulo);
        System.out.println("Costo=" + this.calcularCostoEstimado());
        System.out.println("Sala asignada: " + (sala != null ? sala.getNombre() : "Sin sala")+"\n");
        System.out.println("Actividades:");
        System.out.println("____________");
        for (Actividad actividad : actividades) {
            System.out.println("- " + actividad.getTitulo() + " (id=" + actividad.getId() + ")" + " - Cupo máximo: " + actividad.getCupoMaximo());
            actividad.mostrarInscripciones();
        }
        System.out.println("=====================================================================================");
    }

    public static int getCantidadEventos() {return cantidadEventos;}
}

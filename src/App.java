import java.util.ArrayList;
import java.util.List;
public class App {
    public static void main(String[] args) {
        Sala sala1 = new Sala(1, "Aula Magna");
        EventoUniversitario eventoPrincipal = new EventoUniversitario(
                "EVT-1",
                "Jornada de Tecnología",
                10000,
                false);

        Charla charla = new Charla(1, "Introducción a Algoritmos", "Alberto Cortez", 40);
        Taller taller = new Taller(2, "Taller de Java", true, 15);

        eventoPrincipal.asignarSala(sala1);
        eventoPrincipal.crearActividad(1, "Introducción a Algoritmos", 40, "charla");
        eventoPrincipal.crearActividad(2, "Taller de Java", 15, "taller");

        EventoUniversitario copiaeventoPrincipal = new EventoUniversitario("EVT-2", "Jornada de Tecnología Copia", 10000, false);

        eventoPrincipal.asignarSala(sala1);

        Estudiante e1 = new Estudiante("53343", "Federica Duffey");
        Estudiante e2 = new Estudiante("58731", "Tomás Herrera");
        Estudiante e3 = new Estudiante("53345", "Guadalupe Ríos");

        List<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(e1);
        estudiantes.add(e2);
        estudiantes.add(e3);


        charla.inscribir(e1);
        charla.inscribir(e2);

        taller.inscribir(e2);
        taller.inscribir(e3);

        System.out.println("EVENTO PRINCIPAL");
        eventoPrincipal.mostrarDatos();

        System.out.println();


        System.out.println("COPIA DEL EVENTO");
    copiaeventoPrincipal.mostrarDatos();

        System.out.println("Eventos creados: "+ EventoUniversitario.getCantidadEventos());
     }
}
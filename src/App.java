//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class App {
    public static void main(String[] args) {
        Sala sala1 = new Sala(1, "Aula Magna");
        EventoUniversitario evento1 = new EventoUniversitario(
                    "EVT-1",
                    "Jornada de Programación",
                    10000,
                    false
            );
    EventoUniversitario copiaEvento1 = new EventoUniversitario(evento1);

    evento1.asignarSala(sala1);
    evento1.crearActividad(101, "Taller de Java OO", 30);
    evento1.crearActividad(102, "Conferencia de Algoritmos", 50);
    System.out.println("EVENTO ORIGINAL");
    evento1.mostrarDatos();

    System.out.println();

    System.out.println("COPIA DEL EVENTO");
    copiaEvento1.mostrarDatos();

    System.out.println("Eventos creados: "+ EventoUniversitario.getCantidadEventos());
     }
}
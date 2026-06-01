import java.util.ArrayList;

public class MotorJuego {

    private String estado;
    private ArrayList<EntidadVideojuego> entidades;
    private SistemaPuntuacion sistemaPuntuacion;

    public MotorJuego() {
        estado = "MENU";
        entidades = new ArrayList<>();
        sistemaPuntuacion = new SistemaPuntuacion();
    }

    public void iniciarPartida() {
        estado = "JUGANDO";
        System.out.println("Partida iniciada");
    }

    public void pausar() {
        estado = "PAUSA";
        System.out.println("Juego pausado");
    }

    public void reanudar() {
        estado = "JUGANDO";
        System.out.println("Juego reanudado");
    }

    public void gameOver() {
        estado = "GAME_OVER";
        System.out.println("GAME OVER");
    }

    public void agregarEntidad(EntidadVideojuego entidad) {
        entidades.add(entidad);
        System.out.println(entidad.getNombre() + " añadida al juego");
    }

    public void eliminarEntidad(EntidadVideojuego entidad) {
        entidades.remove(entidad);
        System.out.println(entidad.getNombre() + " eliminada del juego");
    }

    public void actualizar() {

        if (!estado.equals("JUGANDO")) {
            System.out.println("El juego no está en ejecución");
            return;
        }

        System.out.println("=== NUEVO TICK DEL JUEGO ===");

        for (EntidadVideojuego entidad : entidades) {

            if (entidad.getTipo().equals("Defensa")) {
                entidad.mover(-1, 0);
            }
        }

        comprobarColisiones();
    }

    private void comprobarColisiones() {

        EntidadVideojuego jugador = null;

        for (EntidadVideojuego entidad : entidades) {
            if (entidad.getTipo().equals("Jugador")) {
                jugador = entidad;
                break;
            }
        }

        if (jugador == null) {
            return;
        }

        ArrayList<EntidadVideojuego> eliminar = new ArrayList<>();

        for (EntidadVideojuego entidad : entidades) {

            if (entidad == jugador) {
                continue;
            }

            boolean colision =
                    jugador.getX() == entidad.getX() &&
                    jugador.getY() == entidad.getY();

            if (colision) {

                if (entidad.getTipo().equals("Balon")) {

                    sistemaPuntuacion.sumarPuntos(10);

                    System.out.println("¡Balón recogido!");

                    eliminar.add(entidad);
                }

                if (entidad.getTipo().equals("Defensa")) {

                    jugador.recibirDanio(10);

                    if (jugador.getVida() <= 0) {
                        gameOver();
                    }
                }
            }
        }

        entidades.removeAll(eliminar);
    }

    public ArrayList<EntidadVideojuego> getEntidades() {
        return entidades;
    }

    public SistemaPuntuacion getSistemaPuntuacion() {
        return sistemaPuntuacion;
    }

    public String getEstado() {
        return estado;
    }
}

public class GestorEntradas {

    private MotorJuego motorJuego;

    public GestorEntradas(MotorJuego motorJuego) {
        this.motorJuego = motorJuego;
    }

    public void moverJugador(String direccion) {

        for (EntidadVideojuego entidad : motorJuego.getEntidades()) {

            if (entidad.getTipo().equals("Jugador")) {

                switch (direccion.toUpperCase()) {

                    case "ARRIBA":
                        entidad.mover(0, -1);
                        break;

                    case "ABAJO":
                        entidad.mover(0, 1);
                        break;

                    case "IZQUIERDA":
                        entidad.mover(-1, 0);
                        break;

                    case "DERECHA":
                        entidad.mover(1, 0);
                        break;

                    default:
                        System.out.println("Dirección no válida");
                }

                return;
            }
        }
    }

    public void accion() {
        System.out.println("El jugador realiza una acción");
    }
}
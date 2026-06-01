public class Main {

    public static void main(String[] args) {

        MotorJuego motor = new MotorJuego();

        GestorEntradas entradas = new GestorEntradas(motor);

        EntidadVideojuego jugador =
                new EntidadVideojuego(
                        "Jugador",
                        "Jugador",
                        0,
                        0,
                        1,
                        1,
                        100,
                        "jugador.png"
                );

        EntidadVideojuego balon1 =
                new EntidadVideojuego(
                        "Balon1",
                        "Balon",
                        1,
                        0,
                        1,
                        1,
                        1,
                        "balon.png"
                );

        EntidadVideojuego balon2 =
                new EntidadVideojuego(
                        "Balon2",
                        "Balon",
                        2,
                        0,
                        1,
                        1,
                        1,
                        "balon.png"
                );

        EntidadVideojuego balon3 =
                new EntidadVideojuego(
                        "Balon3",
                        "Balon",
                        3,
                        0,
                        1,
                        1,
                        1,
                        "balon.png"
                );

        EntidadVideojuego defensa =
                new EntidadVideojuego(
                        "Defensa",
                        "Defensa",
                        5,
                        0,
                        1,
                        1,
                        100,
                        "defensa.png"
                );

        motor.agregarEntidad(jugador);
        motor.agregarEntidad(balon1);
        motor.agregarEntidad(balon2);
        motor.agregarEntidad(balon3);
        motor.agregarEntidad(defensa);

        System.out.println("----- INICIO PARTIDA -----");

        motor.iniciarPartida();

        entradas.moverJugador("DERECHA");
        motor.actualizar();

        entradas.moverJugador("DERECHA");
        motor.actualizar();

        entradas.moverJugador("DERECHA");
        motor.actualizar();

        System.out.println("Estado actual: " + motor.getEstado());

        motor.pausar();

        System.out.println("Estado actual: " + motor.getEstado());

        motor.reanudar();

        System.out.println("Estado actual: " + motor.getEstado());

        entradas.moverJugador("DERECHA");
        motor.actualizar();

        entradas.moverJugador("DERECHA");
        motor.actualizar();

        System.out.println(
                "Puntos finales: "
                + motor.getSistemaPuntuacion().getPuntos()
        );

        motor.gameOver();

        System.out.println(
                "Estado final: "
                + motor.getEstado()
        );
    }
}
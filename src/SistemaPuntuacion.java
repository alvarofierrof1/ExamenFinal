public class SistemaPuntuacion {

    private int puntos;
    private boolean logroDesbloqueado;

    public SistemaPuntuacion() {
        puntos = 0;
        logroDesbloqueado = false;
    }

    public void sumarPuntos(int cantidad) {
        puntos += cantidad;

        System.out.println("Puntos actuales: " + puntos);

        verificarLogro();
    }

    public void verificarLogro() {

        if (puntos >= 30 && !logroDesbloqueado) {

            logroDesbloqueado = true;

            System.out.println("LOGRO DESBLOQUEADO: Maestro del Futbol");
        }
    }

    public int getPuntos() {
        return puntos;
    }

    public boolean isLogroDesbloqueado() {
        return logroDesbloqueado;
    }
}

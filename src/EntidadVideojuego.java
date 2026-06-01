public class EntidadVideojuego {

    private String nombre;
    private String tipo;

    private int x;
    private int y;

    private int w;
    private int h;

    private int vida;

    private String imagen;

    public EntidadVideojuego(String nombre, String tipo, int x, int y,
                             int w, int h, int vida, String imagen) {

        this.nombre = nombre;
        this.tipo = tipo;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.vida = vida;
        this.imagen = imagen;
    }

    public void mover(int dx, int dy) {
        x += dx;
        y += dy;

        System.out.println(nombre + " se mueve a (" + x + "," + y + ")");
    }

    public void recibirDanio(int cantidad) {
        vida -= cantidad;

        if (vida < 0) {
            vida = 0;
        }

        System.out.println(nombre + " recibe " + cantidad +
                " de daño. Vida restante: " + vida);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public int getVida() {
        return vida;
    }

    public String getImagen() {
        return imagen;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}
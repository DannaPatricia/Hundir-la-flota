package practicaflota;

public class Ficha {
    private String tipoFicha;
    private String contenido;
    private String sentido;
    private boolean dado;
    private boolean ocupado;
    private int vida;

    public Ficha(String tipoFicha, String sentido) {
        this.tipoFicha = tipoFicha;
        if (tipoFicha.equals("velero")) {
            this.sentido = sentido;
            this.dado = false;
            this.ocupado = true;
            this.contenido = " V ";
            this.vida = 1;
        } else if (tipoFicha.equals("buque")) {
            this.sentido = sentido;
            this.dado = false;
            this.ocupado = true;
            this.contenido = " B ";
            this.vida = 3;
        } else if (tipoFicha.equals("portaviones")) {
            this.sentido = sentido;
            this.dado = false;
            this.ocupado = true;
            this.contenido = " P ";
            this.vida = 4;
        } else if (tipoFicha.equals("fragata")) {
            this.sentido = sentido;
            this.dado = false;
            this.ocupado = true;
            this.contenido = " F ";
            this.vida = 2;
        }
    }

    public Ficha(String tipoFicha) {
        this.tipoFicha = tipoFicha;
        if (tipoFicha.equals("agua")) {
            this.dado = false;
            this.ocupado = false;
            this.contenido = " * ";
        } else if (tipoFicha.equals("casillaDada")) {
            this.dado = true;
            this.ocupado = true;
            this.contenido = " o ";
        } else if (tipoFicha.equals("casillaTocada")) {
            this.dado = true;
            this.ocupado = true;
            this.contenido = " x ";
        }
    }

    public String getTipoFicha() {
        return tipoFicha;
    }

    public void setTipoFicha(String tipoFicha) {
        this.tipoFicha = tipoFicha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public boolean isDado() {
        return dado;
    }

    public void setDado(boolean dado) {
        this.dado = dado;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public String getSentido() {
        return sentido;
    }

    public void setSentido(String sentido) {
        this.sentido = sentido;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }
}

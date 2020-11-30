import java.util.Random;

public class Kompartment {
    private int popyt;
    private int producenci;
    private int zapas;
    private int limit;
    private int cena;
    private int flota;


    // Konstruktor
    public Kompartment(int popyt, int producenci, int zapas, int limit, int cena, int flota) {
        this.popyt = popyt;
        this.producenci = producenci;
        this.zapas = zapas;
        this.limit = limit;
        this.cena = cena;
        this.flota = flota;
    }


    // Ta metoda ma rzucić n razy kością sześciościenną (k6) i zwrócić sumę wyników.
    static int rzutK6(int n) {
        int suma = 0;
        for (int i = 0; i < n; i++) {
            int k6 = new Random().nextInt(6) + 1;
            suma += k6;
        }
        return suma;
    }

    // Ta metoda ma zaktualizować zapas poprzez dodanie do niego tegorocznej podazy i odjecie popytu
    public void zniwa() {
        zapas = zapas + rzutK6(producenci) - popyt;
        if (zapas < 0) {
            zapas = 0;
        }
        if (zapas > limit) {
            zapas = limit;
        }
        System.out.println(zapas);
    }

    // Poniżej są gettery i settery

    public int getPopyt() {
        return popyt;
    }

    public void setPopyt(int popyt) {
        this.popyt = popyt;
    }

    public int getProducenci() {
        return producenci;
    }

    public void setProducenci(int producenci) {
        this.producenci = producenci;
    }

    public int getZapas() {
        return zapas;
    }

    public void setZapas(int zapas) {
        this.zapas = zapas;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getCena() {
        return cena;
    }

    public void setCena(int cena) {
        this.cena = cena;
    }


    public int getFlota() {
        return flota;
    }

    public void setFlota(int flota) {
        this.flota = flota;
    }


}


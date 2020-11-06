import java.util.Random;

public class Handel {
    /*Rynek zbytu w Maszracji jest trójkompartmentowy.
     * Celem administracji każdego kompartmentu jest utrzymanie "zapasu" na poziomie połowy "limitu".
     * Jedynym narzędziem jest cena. Cena będzie odwrotnie zależna od zapasu.
     * Koszt przewozu miedzy kompartmentami ustalmy na 5. Warunkiem transportu jest zatem różnica ceny >5.
     * Wyściowa cena będzie wynosić 10 dla kompartmentu A, 15 dla B, 20 dla C.
     * Popyt każdego kompart. będzie stopniowo, powoli rósł jeśli cena będzie <40, a zapas >0,2*limit.
     * Maksymalny transfer pomiędzy kompart. (flota) wyjściowo wynosi 1 i jeśli różnica ceny wynosi >6 to
     * w następnym roku flota zwiększy się o 1. Natomiast jeśli transfer był mnijeszy niż połowa floty
     * wtenczas flota zmniejszy sie o 1.
     *
     *
     *
     * */




    // Ta metoda ma rzucić n razy kością sześciościenną (k6) i zwrócić sumę wyników.
    static int podarz(int n) {
        int suma = 0;
        for (int i = 0; i < n; i++) {
            int k6 = new Random().nextInt(6) + 1;
            suma += k6;
        }
        return suma;
    }

    // Zapas nie może przekroczyć limitu i nie może być mniejszy od 0. Zależy od tegorocznej podarzy i popytu
    static int aktualizacjaZapasu(int zapas, int podarz, int popyt, int limit) {
        int aktualnyZapas = zapas + podarz - popyt;
        if (aktualnyZapas < 0) aktualnyZapas = 0;
        if (aktualnyZapas > limit) aktualnyZapas = limit;
        return aktualnyZapas;
    }

    //Cena zmienia się w zależności od stopnia zapełnienia magazynu (czyli zapasu)
    static int zmianaCeny(int zapas, int limit) {
        int zmianaCeny = 0;
        int stZapMag = 100 * zapas / limit; // stopień zapełnienia magazynu
        if (stZapMag <= 10) zmianaCeny = 5;
        else if (stZapMag <= 20) zmianaCeny = 4;
        else if (stZapMag <= 30) zmianaCeny = 3;
        else if (stZapMag <= 40) zmianaCeny = 2;
        else if (stZapMag <= 45) zmianaCeny = 1;
        else if (stZapMag >= 90) zmianaCeny = -5;
        else if (stZapMag >= 80) zmianaCeny = -4;
        else if (stZapMag >= 70) zmianaCeny = -3;
        else if (stZapMag >= 60) zmianaCeny = -2;
        else if (stZapMag >= 55) zmianaCeny = -1;
        return zmianaCeny;
    }

    // zapasC += transfer(flotaBC, cenaC, cenaB, zapasC, zapasB);
    // Transfer zależy od różnicy w cenie
    static int transfer(int flota, int cenaWewn, int cenaZewn, int zapasWewn, int zapasZewn) {
        int transfer = 0;
        int gr = cenaWewn - cenaZewn;
        if (gr > 5) {
            transfer = gr - 5;
            //if (transfer>flota) transfer=flota;
        } else if (gr < -5) {
            transfer = gr + 5;
            //if (transfer<-flota) transfer=-flota;
        }

        return transfer;
    }

    public static void main(String[] args) {
        int popytA = 10;
        int popytB = 25;
        int popytC = 50;
        int zapasA = 10;
        int zapasB = 25;
        int zapasC = 50;
        int limitA = 20;
        int limitB = 50;
        int limitC = 100;
        int cenaA = 10;
        int cenaB = 15;
        int cenaC = 20;
        int podarzA;
        int podarzB;
        int podarzC;
        int flotaZA = 1;        // ilość jednostek transportowych pomiędzy Maszracją a kompartmentem A
        int flotaAB = 1;        // ilość jednostek transportowych pomiędzy kompartmentami A i B
        int flotaBC = 1;        // ilość jednostek transportowych pomiędzy kompartmentami B i C

        for (int rok = 0; rok < 5; rok++) {
            podarzA = podarz(3);        //podarzA wynosi 3k6
            podarzB = podarz(7);        //podarzB wynosi 7k6
            podarzC = podarz(14);       //podarzC wynosi 14k6

            zapasA = aktualizacjaZapasu(zapasA, podarzA, popytA, limitA);
            zapasB = aktualizacjaZapasu(zapasB, podarzB, popytB, limitB);
            zapasC = aktualizacjaZapasu(zapasC, podarzC, popytC, limitC);

            cenaA = cenaA + zmianaCeny(zapasA, limitA);
            if (cenaA<0) cenaA=0;
            cenaB = cenaB + zmianaCeny(zapasB, limitB);
            if (cenaB<0) cenaB=0;
            cenaC = cenaC + zmianaCeny(zapasC, limitC);
            if (cenaC<0) cenaC=0;

            zapasC += transfer(flotaBC, cenaC, cenaB, zapasC, zapasB);
            zapasB += transfer(flotaBC, cenaB, cenaC, zapasB, zapasC);
            zapasB += transfer(flotaAB, cenaB, cenaA, zapasB, zapasA);
            zapasA += transfer(flotaAB, cenaA, cenaB, zapasA, zapasB);

            System.out.println("Rok:" + rok + " Podarz A=" + podarzA + " B=" + podarzB + " C=" + podarzC
                    + "  Zapas A=" + zapasA + " B=" + zapasB + " C=" + zapasC
                    + "  Cena A=" + cenaA + " B=" + cenaB + " C=" + cenaC);
        }
    }

}

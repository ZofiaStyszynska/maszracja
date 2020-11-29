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
     * */

    public static void main(String[] args) {
        Kompartment a = new Kompartment(10, 3, 10, 20, 1);
        Kompartment b = new Kompartment(25, 7, 25, 50, 1);
        Kompartment c = new Kompartment(50, 14, 50, 100, 1);

    }

}

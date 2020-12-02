public class Mapa {

    private static final int COLS = 10;
    private static final int ROWS = 9;

    public static void draw1stLine(int cols) {
        System.out.print("       *****");
        for (int i = 1; i < cols; i++) {
            System.out.print("             *****");
        }
        System.out.println();
    }

    public static void draw2ndLine(int cols) {
        System.out.print("   ****");
        for (int i = 1; i < cols * 2; i++) {
            System.out.print("     ****");
        }
        System.out.println();
    }

    public static void draw3rdLine(int cols) {
        System.out.print("***");
        for (int i = 1; i < cols; i++) {
            System.out.print("             *****");
        }
        System.out.println("             ***");
    }

    public static void draw4thLine(int cols) {
        System.out.print("*");
        for (int i = 0; i < cols; i++) {
            System.out.print("                 *");
        }
        System.out.println("");
    }

    public static void draw9thLine(int cols) {
        System.out.print("         *");
        for (int i = 1; i < cols; i++) {
            System.out.print("                 *");
        }
        System.out.println();
    }

    public static void drawMap(int rows, int cols) {
        int r = (rows-1)/2;
        draw1stLine(cols);
        draw2ndLine(cols);
        draw3rdLine(cols);
        draw4thLine(cols);
        draw4thLine(cols);
        draw3rdLine(cols);
        draw2ndLine(cols);
        draw1stLine(cols);
        for (int i = 0; i < r; i++) {
            draw9thLine(cols);
            draw9thLine(cols);
            draw1stLine(cols);
            draw2ndLine(cols);
            draw3rdLine(cols);
            draw4thLine(cols);
            draw4thLine(cols);
            draw3rdLine(cols);
            draw2ndLine(cols);
            draw1stLine(cols);
        }

    }

    public static void main(String[] args) {
        /*
        System.out.println("       *****             *****             *****");
        System.out.println("   ****     ****     ****     ****     ****     ****");
        System.out.println("***   R01 K01   *****   R01 K03   *****   R01 K05   ***");
        System.out.println("*                 *                 *                 *");
        System.out.println("*                 *                 *                 *");
        System.out.println("***             *****             *****             ***");
        System.out.println("   ****     ****     ****     ****     ****     ****");
        System.out.println("       *****   R02 K02   *****   R02 K04   *****");
        System.out.println("         *                 *                 *");
        System.out.println("         *                 *                 *");
        System.out.println("       *****             *****             *****");
        System.out.println("   ****     ****     ****     ****     ****     ****");
        System.out.println("***   R03 K01   *****   R03 K03   *****   R03 K05   ***");
        System.out.println("*                 *                 *                 *");
        System.out.println("*                 *                 *                 *");
        System.out.println("***             *****             *****             ***");
        System.out.println("   ****     ****     ****     ****     ****     ****");
        System.out.println("       *****             *****             *****");*/

        drawMap(ROWS, COLS);
    }
}

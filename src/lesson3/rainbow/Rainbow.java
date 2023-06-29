package lesson3.rainbow;

public class Rainbow {

    public static final String RED = "RED";
    public static final String ORANGE  = "ORANGE";
    public static final String YELLOW = "YELLOW";
    public static final String GREEN  = "GREEN";
    public static final String BLUE  = "BLUE";
    public static final String NAVY = "NAVY";
    public static final String VIOLET  = "VIOLET";
    public static final String ERROR = "No, it's not right number! Try again!";

    public void printColor(int num) {
        switch (num) {
            case 1 :
            case 2 :
            case 3 :
            case 4 :
            case 5 :
            case 6 :
            case 7 :
            case 8 :
            case 9 :
                System.out.println(RED + "ISH");
                break;
            case 10 :
                System.out.println(RED);
                break;
            case 11 :
            case 12 :
            case 13 :
            case 14 :
            case 15 :
            case 16 :
            case 17 :
            case 18 :
            case 19 :
                System.out.println(RED + "-" + ORANGE );
                break;
            case 20 :
                System.out.println(ORANGE);
                break;
            case 30 :
                System.out.println(YELLOW);
                break;
            case 40 :
                System.out.println(GREEN);
                break;
            case 50 :
                System.out.println(BLUE);
                break;
            case 60 :
                System.out.println(NAVY);
                break;
            case 70 :
                System.out.println(VIOLET);
                break;
            default:
                if (num >=21 & num<=29) {
                    System.out.println(ORANGE + "-" + YELLOW);
                }
                else if (num >=31 & num<=39) {
                    System.out.println(YELLOW + "-" + GREEN);
                }
                else if (num >=41 & num<=49) {
                    System.out.println(GREEN + "-" + BLUE);
                }
                else if (num >=51 & num<=59) {
                    System.out.println(BLUE + "-" + NAVY);
                }
                else {
                    System.out.println(NAVY + "-" + VIOLET);
                }

        }
    }
}

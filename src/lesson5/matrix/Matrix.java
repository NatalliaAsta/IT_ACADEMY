package lesson5.matrix;

import java.util.Arrays;
import java.util.Random;
import java.util.regex.Pattern;

public class Matrix {

    public static final int SIZE = 10;
    public static final int ITEM_LENGTH = 7;
    public static String ITEM_PATTERN = "\\d\\.\\d{5}";
    public static String DELIMITER = ",";
    public static double FOR_COMPARE = 1.7;
    public static int START_POSITION = 2;
    public static int FINISH_POSITION = 4;

    /*
    Метод для генерации произвольной стоки заданной длины
     */
    public static String generateStringVal(int lng) {
        Random random = new Random();
        String retVal = "";
        for (int i = 1; i <= lng; i++) {
            retVal = retVal + (char) (random.nextInt(26) + 'A');
        }
        return retVal;
    }

    /*
    Метод генерации двумерного массива
     */
    public static String[][] create() {
        String[][] matrix = new String[SIZE][SIZE];
        for (int i = 0; i <= SIZE - 1; i++) {
            for (int j = 0; j <= SIZE - 1; j++) {
                if ((i + j + 1) % 3 == 0) {
                    double rnd = Math.random();
                    matrix[i][j] = String.valueOf(rnd * 10).substring(0, 7);
                } else {
                    matrix[i][j] = generateStringVal(ITEM_LENGTH);
                }
            }
        }
        return matrix;
    }

    /*
    Метод для печати двумерного массива строк
     */
    public static void print(String[][] m) {
        for (int i = 0; i <= SIZE - 1; i++) {
            for (int j = 0; j <= SIZE - 1; j++) {
                System.out.print(m[i][j] + ' ');
            }
            System.out.println();
        }
    }

    /*
    Перегрузим метод для печати одномерного массива строк
     */
    public static void print(String[] m) {
        System.out.println(String.join(DELIMITER, m));
        System.out.println();
    }

    /*
    Перегрузим метод для печати одномерного массива значений типа double
     */
    public static void print(double[] d) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i<= d.length-1; i++) {
            if (i != (d.length - 1)) {
                sb = sb.append(d[i]).append('_');
            } else {
                sb = sb.append(d[i]);
            }
        }
        System.out.println(sb);
    }

    /*
    Формирование массива из элементов главной диагонали заданной матрицы
     */
    public static String[] mainDiagonalToArray(String[][] m) {
        String[] mainDiagonal = new String[SIZE];
        for (int i = SIZE - 1; i >= 0; i--) {
            mainDiagonal[i] = m[i][i];
        }
        return mainDiagonal;
    }

    /*
    Формирование массива из элементов побочной диагонали заданной матрицы
     */
    public static String[] minorDiagonalToArray(String[][] m) {
        String[] minorDiagonal = new String[SIZE];
        for (int i = SIZE - 1; i >= 0; i--) {
            minorDiagonal[i] = m[i][SIZE - 1 - i];
        }
        return minorDiagonal;
    }

    /*
    Метод для сравнения главной и побочной диагоналей заданного двумерного массива
     */
    public static void equalDiagonals(String[][] m) {
        System.out.println();
        boolean isDiagonalsEquals = Arrays.equals(mainDiagonalToArray(m), minorDiagonalToArray(m));
        System.out.println(isDiagonalsEquals
                ? "Главная и побочная диагонали идентичны"
                : "Главная и побочная диагонали различны");
    }

    /*
    Метод формирует одномерный массив из диагоналей заданного двумерного массива
    */
    public static String[] diagonalsToArray(String[][] m) {
        String[] diagonals = new String[SIZE * 2];
        String[] minor = minorDiagonalToArray(m);
        String[] major = mainDiagonalToArray(m);
        for (int i = 0; i <= SIZE - 1; i++) {
            diagonals[i] = minor[i];
        }
        for (int i = SIZE; i <= SIZE * 2 - 1; i++) {
            diagonals[i] = major[i - SIZE];
        }
        return diagonals;
    }

    /*
    Метод опеределяет, является ли элемент заданного одномерного массива строкой, и если элемент да, то выводит
    символы в промежутке заданных позиций; если элемент - число, то записывает в новый массив, округляя в меньшую
    сторону, если число < 1.7, в противном случае - в большую сторону.
     */
    public static void performArray(String[] s, int posStart, int posFinish, double forCompare) {
        int countDouble = 0;
        System.out.println();
        StringBuilder sb = new StringBuilder();
        Pattern pattern = Pattern.compile(ITEM_PATTERN);
        for (String item : s) {
            if (!Pattern.matches(ITEM_PATTERN, item)) {
                sb.append(item.substring(posStart - 1, posFinish)).append(DELIMITER);
            } else {
                countDouble++;
            }
        }
        System.out.println(sb);
        if (countDouble > 0) {
            double[] itemsDouble = new double[countDouble];
            int n = 0;
            double tmpDouble = 0;
            for (String item : s) {
                if (Pattern.matches(ITEM_PATTERN, item)) {
                    tmpDouble = Double.parseDouble(item);
                    itemsDouble[n] = tmpDouble > forCompare
                            ? Math.ceil(tmpDouble)
                            : Math.floor(tmpDouble);
                    n++;
                }
            }
            print(itemsDouble);
        }
    }

}

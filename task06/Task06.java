package by.epamtc.mtv.viaryshko.task06;

//Магическим квадратом порядка n называется квадратная матрица размера nxn, составленная из чисел 1, 2, 3, ...,
// так, что суммы по каждому столбцу, каждой строке и каждой из двух больших диагоналей равны между собой.
// Построить такой квадрат.

public class Task06 {

    private int[][] array;

    //заполнение массива числами
    private void fillArray(int size) {
        array = new int[size][size];
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                counter++;
                array[i][j] = counter;
            }
        }
    }

    //печать массива
    public void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }

    //магический квадрат для 8
    public void getMagicSquareForEight() {
        fillArray(8);
        int counter = 0;
        for (int i = 0; i < array.length / 2; i++) {
            int transition;
            if (i < array.length / 2) {
                transition = array[i][i];
                array[i][i] = array[array.length - 1 - counter][array.length - 1 - counter];
                array[array.length - 1 - counter][array.length - 1 - counter] = transition;
                counter++;
            }
        }
        counter = 0;
        for (int i = 0; i < array.length / 2; i++) {
            int transition;
            if (i < array.length / 2) {
                transition = array[array.length - 1 - counter][i];
                array[array.length - 1 - counter][i] = array[i][array.length - 1 - counter];
                array[i][array.length - 1 - counter] = transition;
                counter++;
            }
        }
        counter = 0;
        for (int i = 0; i < array.length / 2; i++) {
            int transition;
            counter++;
            transition = array[i][array.length / 2 - counter];
            array[i][array.length / 2 - counter] = array[array.length - counter][array.length / 2 + counter - 1];
            array[array.length - counter][array.length / 2 + counter - 1] = transition;
        }

        counter = 0;
        for (int i = 0; i < array.length / 2; i++) {
            int transition;
            counter++;
            transition = array[i][array.length / 2 + counter - 1];
            array[i][array.length / 2 + counter - 1] = array[array.length - counter][array.length / 2 - counter];
            array[array.length - counter][array.length / 2 - counter] = transition;

        }
        printArray(array);
    }

    //магический квадрат для 5
    public void getMagicSquareForFive() {
        fillArray(5);
        int[][] magicSquare = new int[5][5];
        final int magicConst = (5 * ((5 * 5) + 1)) / 2;
        int amountFirstLine = 0;
        int amountFifthLine = 0;
        int amountFirstColumn = 0;
        int amountFifthColumn = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i == j) {
                    magicSquare[i][j] = array[array.length / 2][j];
                } else if (i == array.length - j - 1) {
                    magicSquare[i][j] = array[i][array.length / 2];
                } else if (i < array.length / 2 && i != 0 && j < array.length / 2) {
                    magicSquare[i][j] = array[i - 1][array.length - i - 1];

                } else if (i == array.length / 2 && j < array.length / 2 && j != 0) {
                    magicSquare[i][j] = array[i - i][array.length - j];
                } else if (i > array.length / 2 && i != array.length - 1 && j < array.length / 2) {
                    magicSquare[i][j] = array[array.length - i - 1][array.length - j - 1];
                } else if (i < array.length / 2 && i != 0 && j > array.length / 2) {
                    magicSquare[i][j] = array[array.length - i - 1][array.length - j - 1];
                } else if (i == array.length / 2 && j > array.length / 2 && j != array.length - 1) {
                    magicSquare[i][j] = array[array.length - i + 1][array.length - j - 2];
                } else if (i > array.length / 2 && j > array.length / 2 && i != array.length - 1) {
                    magicSquare[i][j] = array[i + 1][array.length - j];
                } else if (i == 0 && j < array.length / 2) {
                    magicSquare[i][j] = array[array.length - i - 1][array.length - j - 1];
                } else if (i == array.length - 1 && j < array.length / 2) {
                    magicSquare[i][j] = array[array.length - i][j - 1];
                } else if (i == 0 && j > array.length / 2) {
                    magicSquare[i][j] = array[array.length - i - 2][j + 1];
                } else if (i == array.length - 1 && j > array.length / 2) {
                    magicSquare[i][j] = array[array.length - i - 1][array.length - j - 1];
                } else if (j == array.length / 2 && i < array.length / 2 && i != 0) {
                    magicSquare[i][j] = array[array.length - i][array.length - i];
                } else if (j == array.length / 2 && i > array.length / 2 && i != array.length - 1) {
                    magicSquare[i][j] = array[array.length - i - 2][array.length - i - 2];
                }
            }
        }
        for (int i = 0; i < magicSquare.length; i++) {
            amountFirstLine += magicSquare[0][i];
            amountFifthLine += magicSquare[magicSquare.length - 1][i];
            amountFirstColumn += magicSquare[i][0];
            amountFifthColumn += magicSquare[i][magicSquare.length - 1];
        }
        magicSquare[0][magicSquare.length / 2] = magicConst - amountFirstLine;
        magicSquare[magicSquare.length - 1][magicSquare.length / 2] = magicConst - amountFifthLine;
        magicSquare[magicSquare.length / 2][0] = magicConst - amountFirstColumn;
        magicSquare[magicSquare.length / 2][magicSquare.length - 1] = magicConst - amountFifthColumn;

        printArray(magicSquare);
    }
}


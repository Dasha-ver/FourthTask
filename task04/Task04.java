package by.epamtc.mtv.viaryshko.task04;

//Дан линейный массив . Получить действительную квадратную матрицу порядка n:

public class Task04 {

    private double[] arrayForFirstLine;
    private double[][] array;
    private int size;

    public Task04(int size) {

        this.size = size;

        if (isValidSize()) {
            arrayForFirstLine = new double[size];
            array = new double[size][size];
            fillArrayForFirstLine();
            fillArray();
            printArray(array);
        } else {
            System.out.println("Введите корректный размер");
        }

    }

    //проверка размера массива
    private boolean isValidSize() {
        return size > 0;
    }


    //заполнение линейного массива числами
    private double[] fillArrayForFirstLine() {
        for (int i = 0; i < array.length; i++) {
            arrayForFirstLine[i] = ((Math.random() * 31) - 15);
        }
        return arrayForFirstLine;
    }

    //заполнение массива числами
    private void fillArray() {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                array[i][j] = Math.pow(arrayForFirstLine[j], i + 1);
            }
        }
    }

    public static void printArray(double[][] arrayForPrint){

        for (int i = 0; i < arrayForPrint.length; i++) {
            for (int j = 0; j < arrayForPrint[0].length; j++) {
                System.out.print(arrayForPrint[i][j] + "\t");

            }
            System.out.println();
        }

    }
}

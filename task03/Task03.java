package by.epamtc.mtv.viaryshko.task03;

// Сформировать квадратную матрицу порядка n по заданному образцу(n - четное)

public class Task03 {

    private int[][] array;
    private int size;

    public Task03(int size) {

        this.size = size;
        if (isEvenSize()) {
            array = new int[size][size];
            fillArray();
            printArray(array);
        } else {
            System.out.println("Введите корректный размер");
        }
    }

    //проверка размера массива
    private boolean isEvenSize() {
        return size % 2 == 0 && size > 0;
    }


    private void fillArray() {

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i > j && i < (array.length - j - 1) || i > (array.length - j - 1) && i < j) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = 1;
                }
            }
        }
    }

    public static void printArray(int[][] arrayForPrint) {
        for (int i = 0; i < arrayForPrint.length; i++) {
            for (int j = 0; j < arrayForPrint[0].length; j++) {
                System.out.print(arrayForPrint[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

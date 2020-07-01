package by.epamtc.mtv.viaryshko.task01;

// Сформировать квадратную матрицу порядка n по заданному образцу(n - четное):

public class Task01 {

    private int[][] array;
    private int size;

    public Task01(int size) {

        this.size = size;
        if (isEvenSize()) {
            array = new int[size][size];
            fillArray();
        } else {
            System.out.println("Введите корректный размер");
        }
    }

    //проверка размера массива
    private boolean isEvenSize() {
        return size % 2 == 0 && size > 0;
    }

    //заполнение массива числами
    private void fillArray() {
        for (int j = 0; j < array.length; j++) {
            array[0][j] = j+1;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i % 2 == 0) {
                    System.out.print(array[0][j] + "\t");
                }
                else{
                    System.out.print(array[0][array.length-1-j] + "\t");
                }
            }
            System.out.println();
        }
    }
}

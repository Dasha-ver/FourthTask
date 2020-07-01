package by.epamtc.mtv.viaryshko.task02;

public class Task02 {

    private int [][] array;
    private int size;

    public Task02(int size){

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

    private void fillArray() {

        for (int j = 0; j < array.length; j++) {
            array[0][j] = j+1;
        }

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (i==j) {
                    array[i][j] = (i+1)*(i+2) ;
                } else {
                    array[i][j] = 0;
                }
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

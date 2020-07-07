package by.epamtc.mtv.viaryshko.task05;
import by.epamtc.mtv.viaryshko.task04.Task04;

//Найдите произведение двух матриц.
public class Task05 {

    private double[][] arrayMultiplicand;
    private double[][] arrayMultiplier;
    private double[][] arrayResult;

    public Task05(double[][] arrayMultiplicand, double[][] arrayMultiplier) {

        this.arrayMultiplicand = arrayMultiplicand;
        this.arrayMultiplier = arrayMultiplier;
        if (arrayMultiplicand[0].length != arrayMultiplier.length) {
            System.out.println("Умножение невозможно");
        } else {
            multiplyByMatrix();
            Task04.printArray(arrayResult);
        }
    }

    //умножение
    private void multiplyByMatrix() {

        arrayResult = new double[arrayMultiplicand.length][arrayMultiplier[0].length];
        for (int i = 0; i < arrayMultiplicand.length; i++) {
            for (int j = 0; j < arrayMultiplier[0].length; j++) {
                for (int k = 0; k < arrayMultiplicand[0].length; k++) {
                    arrayResult[i][j] += arrayMultiplicand[i][k] * arrayMultiplier[k][j];
                }
            }
        }
    }
}

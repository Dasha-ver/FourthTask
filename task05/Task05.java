package by.epamtc.mtv.viaryshko.task05;

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
            getResult();
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

    //результат
    private void getResult() {

        for (double[] result : arrayResult) {
            for (int j = 0; j < arrayResult[0].length; j++) {
                System.out.print(result[j] + "\t");
            }
            System.out.println();
        }

    }
}

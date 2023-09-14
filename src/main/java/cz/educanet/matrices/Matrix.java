package cz.educanet.matrices;

import java.util.Arrays;

public class Matrix implements IMatrix {

    private final double[][] rawArray;

    public Matrix(double[][] rawArray) {
        this.rawArray = rawArray;
    }

    @Override
    public IMatrix times(IMatrix matrix) {
        Matrix a = new Matrix(rawArray);
        Matrix b = (Matrix) matrix;

        double[][] c = new double[a.getRows()][b.getColumns()];
        if (a.getColumns() != b.getRows())
            throw new IllegalArgumentException();

        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c[i].length; j++) {
                for (int k = 0; k < b.getRows(); k++) {
                    c[i][j] += (a.get(i, k) * b.get(k, j));
                }
            }
        }

        return new Matrix(c);
    }

    @Override
    public IMatrix times(Number scalar) {
        double[][] timedMatrix = rawArray;
        for (int i = 0; i < timedMatrix.length; i++)
            for (int j = 0; j < timedMatrix[i].length; j++)
                timedMatrix[i][j] *= (int) scalar;
        return new Matrix(timedMatrix);
    }

    @Override
    public IMatrix add(IMatrix matrix) {
        double[][] timedMatrix = rawArray;
        for (int i = 0; i < timedMatrix.length; i++)
            for (int j = 0; j < timedMatrix[0].length; j++)
                timedMatrix[i][j] += matrix.get(i, j);
        return new Matrix(timedMatrix);
    }

    @Override
    public IMatrix transpose() {
        double[][] inputMatrix = rawArray;
        double[][] tMatrix = new double[rawArray.length][rawArray[0].length];
        for (int i = 0; i < inputMatrix.length; i++)
            for (int j = 0; j < inputMatrix[0].length; j++)
                tMatrix[i][j] = inputMatrix[j][i];
        return new Matrix(tMatrix);
    }

    /**
     * TODO: 4x4 and more
     */
    @Override
    public double determinant() {
        if (isSquare()) {
            double[][] a = rawArray;
            if (a.length == 1)
                return a[0][0];
            if (a.length == 2)
                return ((a[0][0] * a[1][1]) - (a[1][0] * a[0][1]));
            if (a.length == 3)
                return ((a[0][0] * a[1][1] * a[2][2] + a[0][1] * a[1][2] * a[2][1] + a[0][2] * a[1][1] * a[2][2]) - (a[2][0] * a[1][1] * a[0][2] + a[2][1] * a[1][2] * a[0][1] + a[2][2] * a[1][1] * a[0][2]));
            return 0;
        } else
            throw new RuntimeException("Matice není čtvercová");
    }

    @Override
    public boolean isSquare() {
        return rawArray.length == rawArray[0].length;
    }

    @Override
    public boolean isDiagonal() {
        if (!isSquare())
            throw new IllegalArgumentException();
        double[][] matrixDiagonal = new double[rawArray.length][rawArray[0].length];
        for (int i = 0; i < rawArray.length; i++)
            matrixDiagonal[i][i] = rawArray[i][i];
        return Arrays.deepEquals(matrixDiagonal, rawArray);
    }

    @Override
    public Number getTrace() {
        if (isSquare()) {
            double sum = 0;
            for (int i = 0; i < rawArray.length; i++)
                sum += rawArray[i][i];
            return sum;
        } else
            throw new RuntimeException("Matice není čtvercová");
    }

    @Override
    public int getRows() {
        return rawArray.length;
    }

    @Override
    public int getColumns() {
        if (getRows() > 0)
            return rawArray[0].length;

        return 0;
    }

    @Override
    public double get(int n, int m) {
        if (n >= getRows() || n < 0 || m >= getColumns() || m < 0)
            throw new IllegalArgumentException();

        return rawArray[n][m];
    }
}

package cz.educanet.matrices.matrix;

import cz.educanet.matrices.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixIsSquareTest {
    @Test
    public void should_ReturnTrue_When_MatrixIsSquare() {
        double[][] data = {
                {0, 0, 0},
                {1, 1, 1},
                {1, 1, 1}};
        double[][] data2 = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}};

        Matrix a = new Matrix(data);
        Matrix b = new Matrix(data2);

        Assertions.assertEquals(true, a.isSquare());
        Assertions.assertEquals(true, b.isSquare());
    }

    @Test
    public void should_ReturnFalse_When_MatrixIsNot() {
        double[][] data = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 7, 5},
                {1, 1, 1, 4, 1}};
        double[][] data2 = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1},
                {0, 0, 0, 1},
                {0, 0, 0, 1}};

        Matrix a = new Matrix(data);
        Matrix b = new Matrix(data2);

        Assertions.assertEquals(false, a.isSquare());
        Assertions.assertEquals(false, b.isSquare());
    }

}

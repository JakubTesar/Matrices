package cz.educanet.matrices.matrix;

import cz.educanet.matrices.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixTimesTest {
    @Test
    public void should_Succeed_When_MatrixTimesMatrixFits() {
        double[][] data = {
                {0, 0, 0},
                {1, 1, 1}};
        double[][] data2 = {
                {0, 0},
                {2, 2},
                {3, 5},
                {2, 2}};
        double[][] dataLegit = {
                {0, 0, 0},
                {2, 2, 2},
                {5, 5, 5},
                {2, 2, 2},
        };

        Matrix a = new Matrix(data);
        Matrix b = new Matrix(data2);
        Matrix c = (Matrix) b.times(a);

        for (int i = 0; i < c.getRows(); i++) {
            for (int j = 0; j < c.getColumns(); j++) {
                //System.out.println(c.get(i, j));
                Assertions.assertEquals(dataLegit[i][j], c.get(i, j));
            }
            System.out.println();
        }
    }
    @Test
    public void should_Throw_Exception_When_M1ColumnsNotEqualsM2Rows() {
        double[][] data = {
                {0, 0, 0},
                {1, 1, 1}};
        double[][] data2 = {
                {0, 0},
                {2, 2},
                {3, 5},
                {2, 2}};
        double[][] dataLegit = {
                {0, 0, 0},
                {2, 2, 2},
                {5, 5, 5},
                {2, 2, 2},
        };

        Matrix a = new Matrix(data);
        Matrix b = new Matrix(data2);
        Assertions.assertThrows(IllegalArgumentException.class,() -> a.times(b));
    }

}

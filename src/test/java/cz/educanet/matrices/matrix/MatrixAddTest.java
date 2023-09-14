package cz.educanet.matrices.matrix;

import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.Matrix;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixAddTest {
    private final IMatrixFactory matrixFactory = MatrixFactory.instance;


    @Test
    public void should_Succeed_When_AddMatrixFits() {
        double[][] data = {{1, 4, 2, 3}, {0, 0, 0, 0}};
        double[][] data2 = {{0, 0, 0, 0}, {1, 1, 1, 1}};
        double[][] finalData = {{1, 4, 2, 3}, {1, 1, 1, 1}};
        Matrix a = new Matrix(data);
        Matrix b = new Matrix(data2);
        Matrix expected = (Matrix) a.add(b);

        for (int i = 0; i < finalData.length; i++) {
            for (int j = 0; j < finalData[0].length; j++) {
                Assertions.assertEquals(finalData[i][j] , expected.get(i,j));
            }
        }
    }
}

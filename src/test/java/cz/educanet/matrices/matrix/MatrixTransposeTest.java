package cz.educanet.matrices.matrix;

import cz.educanet.matrices.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixTransposeTest {
    @Test
    public void should_Succeed_When_TransposeFits() {
        double[][] data = {{1, 4, 2}, {0, 0, 0}, {5, 4, 8}};
        double[][] finalData = {{1, 0, 5}, {4, 0, 4}, {2, 0, 8}};
        Matrix a = new Matrix(data);
        Matrix expected = (Matrix) a.transpose();

        for (int i = 0; i < finalData.length; i++) {
            for (int j = 0; j < finalData[0].length; j++) {
                Assertions.assertEquals(finalData[i][j] , expected.get(i,j));
            }
        }
    }
}

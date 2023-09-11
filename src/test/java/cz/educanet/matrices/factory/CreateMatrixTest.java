package cz.educanet.matrices.factory;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.Matrix;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateMatrixTest {

    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_Succeed_When_NumbersFits() {
        double[][][] datas = {{{1, 3, 6, 0, 1}}, {{0, 7, 2, 0, 0}}, {{1, 1, 1, 3, 2}}};
        for (double[][] data : datas) {
            IMatrix matrix = matrixFactory.create(data);
            assertMatrix((Matrix) matrix, data);
        }
    }

    @Test
    public void should_Succeed_When_SizeFits() {
        double[][][] datas = {{{1, 3, 6, 0, 1}}, {{0, 7, 9, 0, 0}}, {{1, 0, -1, 3, 2}}};
        for (double[][] data : datas) {
            IMatrix matrix = matrixFactory.create(data);
            Assertions.assertEquals(data.length, matrix.getRows());
            Assertions.assertEquals(data[0].length, matrix.getColumns());
        }
    }

    public void assertMatrix(Matrix matrix, double[][] data) {
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                Assertions.assertEquals(data[i][j], matrix.get(i, j));
            }
        }
    }
}
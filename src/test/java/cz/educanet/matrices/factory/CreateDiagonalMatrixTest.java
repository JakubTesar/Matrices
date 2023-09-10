package cz.educanet.matrices.factory;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateDiagonalMatrixTest {
    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_Succeed_When_DiagonalFits() {
        double[][] validDiagonals = {{2, 4, 6, 10}, {0, 10}, {0, 10, 8, 9, 1}, {0}};

        for (double[] diagonal : validDiagonals) {
            IMatrix matrix = matrixFactory.createDiagonal(diagonal);
            assertDiagonal(matrix, diagonal);
        }
    }

    @Test
    public void should_ThrowException_When_DiagonalIsEmpty() {
        double[] emptyDiagonal = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> matrixFactory.createDiagonal(emptyDiagonal));
    }

    public void assertDiagonal(IMatrix matrix, double[] diagonal) {
        for (int i = 0; i < diagonal.length; i++)
            for (int j = 0; j < diagonal.length; j++)
                Assertions.assertEquals(i == j ? diagonal[i] : 0, matrix.get(i, j));
    }

}

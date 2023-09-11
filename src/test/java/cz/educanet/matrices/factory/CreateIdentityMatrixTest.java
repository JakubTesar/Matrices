package cz.educanet.matrices.factory;

import cz.educanet.matrices.IMatrix;
import cz.educanet.matrices.IMatrixFactory;
import cz.educanet.matrices.MatrixFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreateIdentityMatrixTest {
    private final IMatrixFactory matrixFactory = MatrixFactory.instance;

    @Test
    public void should_Succeed_When_IdentityFits() {
        int[] sizes = {1, 3, 6, 7, 2};

        for (int size : sizes) {
            IMatrix matrix = matrixFactory.createIdentity(size);
            assertIdentity(matrix, size);
        }
    }

    @Test
    public void should_ThrowException_When_SizeIsLessThanZero() {
        int size = -1;
        Assertions.assertThrows(IllegalArgumentException.class, () -> matrixFactory.createIdentity(size));
    }

    public void assertIdentity(IMatrix matrix, int size) {
        for (int i = 0; i < matrix.getColumns(); i++)
            for (int j = 0; j < matrix.getRows(); j++)
                if (i == j)Assertions.assertEquals( 1, matrix.get(i, j));
    }
}

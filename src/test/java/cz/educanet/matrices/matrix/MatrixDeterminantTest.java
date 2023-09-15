package cz.educanet.matrices.matrix;

import cz.educanet.matrices.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixDeterminantTest {
    @Test
    public void should_Succeed_When_Determinant2x2Fits() {
        double[][] data = {{1, 4}, {5,8}};
        int det = -12;
        Matrix a = new Matrix(data);
        Assertions.assertEquals(det, a.determinant());
    }

}

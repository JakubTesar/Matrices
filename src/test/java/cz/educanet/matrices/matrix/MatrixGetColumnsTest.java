package cz.educanet.matrices.matrix;

import cz.educanet.matrices.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixGetColumnsTest {
    @Test
    public void should_Succeed_When_GetRowsFits() {
        double[][] data = {{1, 4, 2, 3}, {0, 0, 0, 0}};
        double[][] data2 = {{0, 0, 0, 0}, { 1, 1, 1},{ 1, 1, 1},{ 1, 1, 1}};
        Matrix a = new Matrix(data);
        Matrix b = new Matrix(data2);
        Assertions.assertEquals(2, a.getRows());
        Assertions.assertEquals(4, b.getRows());
    }
}

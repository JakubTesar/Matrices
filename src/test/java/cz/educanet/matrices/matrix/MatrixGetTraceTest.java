package cz.educanet.matrices.matrix;

import cz.educanet.matrices.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixGetTraceTest {
    @Test
    public void should_Succeed_When_GetTraceFits() {
        double[][] data = {{1, 4, 2}, {0, 0, 0}, {0, 0, 5}};
        double sum = 6;
        Matrix a = new Matrix(data);
        Number expected =  a.getTrace();

        for (int i = 0; i < a.getRows(); i++) {
            for (int j = 0; j < a.getColumns(); j++) {
                Assertions.assertEquals(sum , expected);
            }
        }
    }
}

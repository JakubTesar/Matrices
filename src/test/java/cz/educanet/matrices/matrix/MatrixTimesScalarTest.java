package cz.educanet.matrices.matrix;

import cz.educanet.matrices.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixTimesScalarTest {
    @Test
    public void should_Succeed_When_MatrixTimesScalarFits() {
        double[][] data = {
                {0, 0, 0},
                {1, 1, 1},
                {1, 1, 1}};
        double[][] dataLegit = {
                {0, 0, 0},
                {2, 2, 2},
                {2, 2, 2}};

        Matrix a = new Matrix(data);
        Matrix b = new Matrix(dataLegit);
        a = (Matrix) a.times(2);

        for (int i = 0; i < a.getRows(); i++)
            for (int j = 0; j < a.getColumns(); j++)
                Assertions.assertEquals(b.get(i,j), a.get(i,j));
    }
}

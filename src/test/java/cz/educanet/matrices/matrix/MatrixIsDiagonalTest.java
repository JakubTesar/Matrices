package cz.educanet.matrices.matrix;

import cz.educanet.matrices.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MatrixIsDiagonalTest {
    @Test
    public void should_Succeed_When_MatrixIsSquare() {
        double[][] data = {
                {0, 0, 0},
                {1, 1, 1},
                {1, 1, 1}};
        double[][] data2 = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}};

        Matrix a = new Matrix(data);
        Matrix b = new Matrix(data2);

        Assertions.assertEquals(false, a.isDiagonal());
        Assertions.assertEquals(true, b.isDiagonal());
    }

    @Test
    public void should_Throw_Exception_When_MatrixIsNotSquare() {
        double[][] data = {
                {0, 0, 0, 0, 0},
                {1, 1, 1, 5, 4},
                {1, 1, 1, 6, 4}};
        double[][] data2 = {
                {1, 0, 0, 0},
                {0, 1, 0, 0}};

        Matrix a = new Matrix(data);
        Matrix b = new Matrix(data2);

        Assertions.assertThrows(IllegalArgumentException.class, a::isDiagonal);
        Assertions.assertThrows(IllegalArgumentException.class, b::isDiagonal);
    }
}

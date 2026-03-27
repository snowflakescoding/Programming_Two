package w9.tutorials.exercise3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Matrix {
    private final int rows;
    private final int cols;
    private final double[][] data;

    public Matrix(int n, int m) {
        if (n <= 0 || m <= 0) {
            throw new IllegalArgumentException("Matrix dimensions must be positive!");
        }
        this.rows = n;
        this.cols = m;
        this.data = new double[n][m];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public double get(int i, int j) {
        checkBounds(i, j);
        return data[i][j];
    }

    public void set(int i, int j, double value) {
        checkBounds(i, j);
        data[i][j] = value;
    }

    public void save(String filename) throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            pw.println(rows + " " + cols);
            for (int i = 0; i < rows; i++) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < cols; j++) {
                    if (j > 0) sb.append(' ');
                    sb.append(data[i][j]);
                }
                pw.println(sb);
            }
        }
    }

     public static Matrix read(String filename) throws IOException {
        try (Scanner sc = new Scanner(new BufferedReader(new FileReader(filename)))) {
            if (!sc.hasNextInt()) throw new IllegalArgumentException("Missing row count.");
            int n = sc.nextInt();
            if (!sc.hasNextInt()) throw new IllegalArgumentException("Missing column count.");
            int m = sc.nextInt();
 
            Matrix matrix = new Matrix(n, m);
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!sc.hasNextDouble()) {
                        throw new IllegalArgumentException(
                                "Not enough values in file (expected " + n * m + ").");
                    }
                    matrix.data[i][j] = sc.nextDouble();
                }
            }
            return matrix;
        }
    }
    
    public Matrix sum(Matrix m) {
        if (m == null || this.rows != m.rows || this.cols != m.cols) {
            return null;
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result.data[i][j] = this.data[i][j] + m.data[i][j];
            }
        }
        return result;
    }

     public Matrix product(Matrix m) {
        if (m == null || this.cols != m.rows) {
            return null;
        }
        int n = this.rows;
        int k = this.cols;   // == m.rows
        int p = m.cols;
 
        Matrix result = new Matrix(n, p);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < p; j++) {
                double sum = 0.0;
                for (int l = 0; l < k; l++) {
                    sum += this.data[i][l] * m.data[l][j];
                }
                result.data[i][j] = sum;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            sb.append('[');
            for (int j = 0; j < cols; j++) {
                if (j > 0) sb.append(", ");
                sb.append(data[i][j]);
            }
            sb.append("]\n");
        }
        return sb.toString();
    }

    private void checkBounds(int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            throw new IndexOutOfBoundsException(
                    "Index (" + i + ", " + j + ") out of bounds for matrix " + rows + "×" + cols);
        }
    }

    public static void main(String[] args) throws IOException {
        // Build a 2×3 matrix
        Matrix a = new Matrix(2, 3);
        a.set(0, 0, 1); a.set(0, 1, 2); a.set(0, 2, 3);
        a.set(1, 0, 4); a.set(1, 1, 5); a.set(1, 2, 6);
        System.out.println("Matrix A:");
        System.out.print(a);
 
        // Save and reload
        a.save("matrix_a.txt");
        Matrix aLoaded = Matrix.read("matrix_a.txt");
        System.out.println("Matrix A (reloaded):");
        System.out.print(aLoaded);
 
        // Sum
        Matrix b = new Matrix(2, 3);
        b.set(0, 0, 9); b.set(0, 1, 8); b.set(0, 2, 7);
        b.set(1, 0, 6); b.set(1, 1, 5); b.set(1, 2, 4);
        Matrix sumAB = a.sum(b);
        System.out.println("A + B:");
        System.out.print(sumAB);
 
        // Product: A (2×3) × C (3×2) → result (2×2)
        Matrix c = new Matrix(3, 2);
        c.set(0, 0, 7); c.set(0, 1, 8);
        c.set(1, 0, 9); c.set(1, 1, 10);
        c.set(2, 0, 11); c.set(2, 1, 12);
        Matrix prod = a.product(c);
        System.out.println("A × C:");
        System.out.print(prod);
 
        // Incompatible sum → null
        Matrix incompatible = new Matrix(3, 3);
        System.out.println("Incompatible sum is null: " + (a.sum(incompatible) == null));
 
        // Incompatible product → null
        System.out.println("Incompatible product is null: " + (a.product(b) == null));
    }
}

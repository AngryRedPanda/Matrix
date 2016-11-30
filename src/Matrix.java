import java.util.regex.Pattern;
import java.util.Scanner;

public class Matrix {

    int n, m;
    double arr[][];
    Scanner sc = new Scanner(System.in);

    Matrix() {
        this.n = 1;
        this.arr = new double[1][1];
        this.arr[0][0] = 0;
    }

    Matrix(int a) {
        this.n = a;
        this.m = a;
        this.arr = new double[this.n][this.m];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) this.arr[i][j] = sc.nextInt();
        }
    }

    Matrix(int a, int b) {
        this.n = a;
        this.m = b;
        this.arr = new double[this.n][this.m];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) this.arr[i][j] = 0;
        }
    }

    Matrix(double arr[][]) {
        this.n = arr.length;
        this.m = arr[0].length;
        this.arr = new double[this.n][this.m];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) this.arr[i][j] = arr[i][j];
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Matrix { \n");
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                sb.append(j + 1 + "." + (int) this.arr[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append("}");
        return (sb.toString());
    }

    Matrix sum(Matrix a) {
        if (this.n == a.n && this.m == a.m) {
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < this.m; j++) {
                    this.arr[i][j] += a.arr[i][j];
                }
            }
            return (new Matrix(this.arr));
        } else {
            return null;
        }
    }

    Matrix mult(int a) {

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++) {
                this.arr[i][j] *= a;
            }
        }
        return (new Matrix(this.arr));
    }

    Matrix mult(Matrix a) {
        if (this.m == a.n) {
            double newArr[][] = new double[this.n][a.m];
            for (int i = 0; i < this.n; i++) {
                for (int j = 0; j < a.m; j++) {
                    for (int k = 0, l = 0; k < this.m || l < a.n; k++, l++)
                        newArr[i][j] += this.arr[i][k] * a.arr[l][i];
                }
            }
            return (new Matrix(newArr));
        } else {
            return null;
        }
    }

    Matrix inv() {
        double newArr[][] = new double[this.n][this.m];
        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.m; j++)
                newArr[i][j] = this.arr[this.arr[i].length - i - 1][this.arr.length - j - 1];
        }
        return new Matrix(newArr);
    }

/*
Matrix det () {

}
 */

    static Matrix getIndentMatrix(int n) {
        double arr[][] = new double[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) arr[i][j] = 1;
        }
        return new Matrix(arr);
    }

    static Matrix getNullMatrix(int n, int m) {
        double arr[][] = new double[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) arr[i][j] = 0;
        }
        return new Matrix(arr);
    }

    static Matrix getIndentMatrix() {
        double arr[][] = new double[ln][ln];
        for (int i = 0; i < ln; i++) {
            for (int j = 0; j < ln; j++) arr[i][j] = 1;
        }
        return new Matrix(arr);
    }
}

    static final int ln = 3;

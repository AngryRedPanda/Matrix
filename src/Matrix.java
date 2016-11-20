
public class Matrix {

    int n, m;
    public int arr[][];

    Matrix() {
        int arr[] = new int[1];
        arr[0] = 0;
    }

    Matrix(int n) {
        int arr[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = 0;
            }
        }
    }

    Matrix(int n, int m) {
        int arr[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = 0;
            }
        }
    }


}

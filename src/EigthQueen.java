import java.util.Date;

/**
 * Created by bigbilii on 2017/6/12.
 *
 */
public class EigthQueen {
    private static final short N = 8;
    private static int count = 0;


    public static void main(String[] args) {
        Date start = new Date();
        short[][] chess = new short[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                chess[i][j] = 0;
            }
        }

        putQueenAtRow(chess,0);
        Date end = new Date();
        System.out.println(N + "皇后问题，用时：" + String.valueOf(end.getTime() - start.getTime()) + "ms");
        System.out.println("计算结果：" + count);
    }

    private static void putQueenAtRow(short[][] chess, int row) {
        if (row == N) { //递归出口，
            count++;
            printChess(chess);
            return;
        }

        short[][] chessTemp = chess.clone();

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {
                chessTemp[row][j] = 0;
            }

            chessTemp[row][i] = 1;
            if (isSafety(chessTemp, row, i)) {
                putQueenAtRow(chessTemp, row + 1);
            }
        }
    }
    private static boolean isSafety(short[][] chess,int row ,int col) {
        int step = 1;
        while(row - step >= 0) {
            if (chess[row - step][col] == 1) { //中
                return false;
            }
            if (col - step >= 0 && chess[row - step][col - step] == 1) { //左
                return false;
            }
            if (col + step < N && chess[row - step][col + step] == 1) { //右
                return false;
            }
            step ++; //下移行
        }
        return true;
    }

    private static void printChess(short[][] chess) {
        System.out.println("第" + count + "种解决方案");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("----------------------------");
    }
}

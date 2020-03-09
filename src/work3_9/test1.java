package work3_9;

public class test1 {
    public static void main(String[] args) {
        int counter = 0;
        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= 7; j++) {
                if (i == j) continue;
                System.out.printf("(%d, %d)     ", i, j);
                counter++;
            }
            System.out.println();
        }
        System.out.println("组合总数：" + counter);
    }
}

package work.work3_17;

/**
 * A program for viewing images.
 *
 * @author Lance
 * @version 1.00 2020-03-08
 */

public class ly {

    public static void main(String[] args) {
        int [][] p=new int[4][4];
        System.out.println("随机生成的矩阵为：");
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                int ps=(int)(Math.random()*10);
                if(ps>=5)
                    p[i][j]=1;
                else p[i][j]=0;
                System.out.print(p[i][j]+" ");
            }
            System.out.println();
        }
        int [] pr= {0,0,0,0};
        int [] pl= {0,0,0,0};
        int r=0,l=0,r1=0,l1=0;
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                if(p[i][j]==1) {
                    pr[i]++;
                    pl[j]++;
                }
            }
        }
        for(int i=0;i<4;i++) {
            if(pr[i]>r) {
                r=pr[i];
                r1=i;
            }
            if(pl[i]>l) {
                l=pl[i];
                l1=i;
            }

        }
        r1++;
        l1++;
        System.out.println("1最多的行数是第"+r1+"行");
        System.out.println("1最多的列数是第"+l1+"列");
    }
}
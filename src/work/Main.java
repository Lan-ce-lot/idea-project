package work;

import java.util.*;
import java.io.*;

public class Main {
    public static long gcd(long n, long m){ if(m > n) return gcd(m,n); if(m == 0) return n; return gcd(m, n%m);}
    public static long lcm(long m, long n){ return (m/gcd(m,n))*n;}
    static int mod = 1000000007;
    static int INF = Integer.MAX_VALUE;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[] dx8 = {0,0,1,-1,1,1,-1,-1};
    static int[] dy8 = {1,-1,0,0,1,-1,-1,1};
    public static void main(String[] args){
        FastScanner scanner = new FastScanner();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = scanner.nextInt();
        }
        Arrays.sort(a);
        if(n <= m){
            long ans = 1;
            for(int i = 0; i < n; i++){
                for(int j = i+1; j < n; j++){
                    ans *= a[j]-a[i];
                    ans %= m;
                }
            }
            System.out.println(ans);
        }else{
            System.out.println(0);
        }

    }
    static class Edge{
        int to;
        Edge(int to){
            this.to = to;
        }
    }
    static class Edge2 implements Comparable<Edge2>{
        int to;
        int cost;
        Edge2(int to, int cost){
            this.to = to;
            this.cost = cost;
        }
        public int compareTo(Edge2 e){
            return cost-e.cost;
        }
    }
    static class Pair2 implements Comparable<Pair2>{
        long first;
        long second;
        Pair2(long first, long second){
            this.first = first;
            this.second = second;
        }
        @Override
        public int compareTo(Pair2 p){
            return Long.valueOf(first).compareTo(Long.valueOf(p.first));
        }
    }
    static class Pair implements Comparable<Pair>{
        int first, second;
        Pair(int a, int b){
            first = a;
            second = b;
        }
        @Override
        public boolean equals(Object o){
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair p = (Pair) o;
            return first == p.first && second == p.second;
        }
        @Override
        public int compareTo(Pair p){
            // first == p.first ? second - p.second : first - p.first; //firstで昇順にソート
            //return (first == p.first ? second - p.second : first - p.first) * -1; //firstで降順にソート
            return second == p.second ? first - p.first : second - p.second;//secondで昇順にソート
            //return (second == p.second ? first - p.first : second - p.second)*-1;//secondで降順にソート
            //return first * 1.0 / second > p.first * 1.0 / p.second ? 1 : -1; // first/secondの昇順にソート
            //return first * 1.0 / second < p.first * 1.0 / p.second ? 1 : -1; // first/secondの降順にソート
            //return second * 1.0 / first > p.second * 1.0 / p.first ? 1 : -1; // second/firstの昇順にソート
            //return second * 1.0 / first < p.second * 1.0 / p.first ? 1 : -1; // second/firstの降順にソート
            //return Math.atan2(second, first) > Math.atan2(p.second, p.first) ? 1 : -1; // second/firstの昇順にソート
            //return first + second > p.first + p.second ? 1 : -1; //first+secondの昇順にソート
            //return first + second < p.first + p.second ? 1 : -1; //first+secondの降順にソート
            //return first - second < p.first - p.second ? 1 : -1; //first-secondの降順にソート
            //return second - first < p.second - p.first ? 1 : -1; //first-secondの昇順にソート
            //return second - first < p.second - p.first ? -1 : 1; //second-firstの昇順にソート
            //return Math.atan2(second,first) > Math.atan2(p.second, p.first) ? 1 : -1;
            //return Math.max(first,second)-Math.max(p.first,p.second);
        }
    }
    static class RMQ {
        private int size_, dat[];
        private int query_(int a, int b, int k, int l, int r) {
            if(r <= a || b <= l) return 2147483647;
            if(a <= l && r <= b) return dat[k];
            int lc = query_(a, b, 2 * k, l, (l + r) / 2);
            int rc = query_(a, b, 2 * k + 1, (l + r) / 2, r);
            return Math.min(lc, rc);
        }
        RMQ(int s) {
            for(size_ = 1; size_ < s;) size_ *= 2;
            dat = new int[size_ * 2];
            for(int i = 0; i < size_ * 2; i++) dat[i] = 2147483647;
        }
        public void update(int pos, int x) {
            pos += size_; dat[pos] = x;
            while(pos > 1) {
                pos /= 2;
                dat[pos] = Math.min(dat[2 * pos], dat[2 * pos + 1]);
            }
        }
        public int query(int l, int r) {
            return query_(l, r, 1, 0, size_);
        }
    }
    static int size = 2100000;
    static long[] fac = new long[size];
    static long[] finv = new long[size];
    static long[] inv = new long[size];
    //繰り返し二乗法
    public static long pow(long x, long n){
        long ans = 1;
        while(n > 0){
            if((n & 1) == 1){
                ans = ans * x;
                ans %= mod;
            }
            x = x * x % mod;
            n >>= 1;
        }
        return ans;
    }
    public static long div(long x, long y){
        return (x*pow(y, mod-2))%mod;
    }
    //fac, inv, finvテーブルの初期化、これ使う場合はinitComb()で初期化必要
    public static  void initComb(){
        fac[0] = finv[0] = inv[0] = fac[1] = finv[1] = inv[1] = 1;
        for (int i = 2; i < size; ++i) {
            fac[i] = fac[i - 1] * i % mod;
            inv[i] = mod - (mod / i) * inv[(int) (mod % i)] % mod;
            finv[i] = finv[i - 1] * inv[i] % mod;
        }
    }
    //nCk % mod
    public static long comb(int n, int k){
        return fac[n] * finv[k] % mod * finv[n - k] % mod;
    }
    //n! % mod
    public static long fact(int n){
        return fac[n];
    }
    //(n!)^-1 with % mod
    public static long finv(int n){
        return finv[n];
    }
    private static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1024];
        private int ptr = 0;
        private int buflen = 0;
        private boolean hasNextByte() {
            if (ptr < buflen) {
                return true;
            }else{
                ptr = 0;
                try {
                    buflen = in.read(buffer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (buflen <= 0) {
                    return false;
                }
            }
            return true;
        }
        private int readByte() { if (hasNextByte()) return buffer[ptr++]; else return -1;}
        private static boolean isPrintableChar(int c) { return 33 <= c && c <= 126;}
        public boolean hasNext() { while(hasNextByte() && !isPrintableChar(buffer[ptr])) ptr++; return hasNextByte();}
        public String next() {
            if (!hasNext()) throw new NoSuchElementException();
            StringBuilder sb = new StringBuilder();
            int b = readByte();
            while(isPrintableChar(b)) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }
        public long nextLong() {
            if (!hasNext()) throw new NoSuchElementException();
            long n = 0;
            boolean minus = false;
            int b = readByte();
            if (b == '-') {
                minus = true;
                b = readByte();
            }
            if (b < '0' || '9' < b) {
                throw new NumberFormatException();
            }
            while(true){
                if ('0' <= b && b <= '9') {
                    n *= 10;
                    n += b - '0';
                }else if(b == -1 || !isPrintableChar(b)){
                    return minus ? -n : n;
                }else{
                    throw new NumberFormatException();
                }
                b = readByte();
            }
        }
        public int nextInt() {
            long nl = nextLong();
            if (nl < Integer.MIN_VALUE || nl > Integer.MAX_VALUE) throw new NumberFormatException();
            return (int) nl;
        }
        public double nextDouble() { return Double.parseDouble(next());}
    }
}

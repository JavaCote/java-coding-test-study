class Solution {
    public long solution(int w, int h) {
        long a = (long)w;
        long b = (long)h;
        long g = gcd(a,b);

        return a * b - ( a + b - g);

    }


    public long gcd(long a, long b){
        while( b!= 0 ){
            long temp = a % b;
            a = b ;
            b = temp;
        }
        return a;
    }
}
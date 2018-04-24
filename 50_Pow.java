class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1f;
        if (n < 0) {
            x = 1.0 / x;
            n = -n;
        }
        return pow(x, n);
    }

    private double pow(double cand, int n){
        if (n == 0) return 1.0;
        else{
            return (n % 2 == 0) ? pow(cand * cand, n / 2) : cand * pow(cand * cand, n / 2);
        }
    }
}

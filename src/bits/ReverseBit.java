package bits;

public class ReverseBit {
    public int reverse(int x) {
        if(x > -10 && x < 10)return x;
        int res = 0;
        int max = Integer.MAX_VALUE, min = Integer.MIN_VALUE;
        while(x !=0){
            int digit = x % 10;
            x /= 10;
            int m = max / 10;
            if(res > max / 10 || (res == max / 10 && digit > max % 10)) return 0;
            if(res < min / 10 || (res == min / 10 && digit < min % 10)) return 0;
            res = res * 10 + digit;
        }
        return res;
    }

    public static void main(String[] args) {
        int x = 1534236469;
        ReverseBit r = new ReverseBit();
        System.out.println(r.reverse(x));
    }
}

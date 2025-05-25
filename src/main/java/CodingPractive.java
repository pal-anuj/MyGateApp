public class CodingPractive {
    public static void main(String[] args) {
        //System.out.println(isPalindrome(1251));
        System.out.println(armstrongNumber(153));
    }

    static boolean armstrongNumber(int n) {
        // code here
        int tempN= n;
        int a=0;
        while(n>0){
            int temp = n%10;
            a = a+ (temp*temp*temp);
            System.out.println(a);
            n=n/10;

        }
        System.out.println(n);
        if(a==tempN)
            return true;
        else
            return false;
    }

    public static boolean isPalindrome1(int x) {
        String s = Integer.toString(x);
        int j = s.length() - 1;
        for (int i = 0; i < j; i++) {
            if (s.charAt(i) != s.charAt(j)) return false;
            j--;
        }
        return true;
    }

    public static boolean isPalindrome(int x) {

        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reserveHalf = 0;

        while (x > reserveHalf) {
            int digit = x % 10;
            reserveHalf = reserveHalf * 10 + digit;
            x /= 10;
        }

        return x == reserveHalf || x == reserveHalf / 10;
    }
}

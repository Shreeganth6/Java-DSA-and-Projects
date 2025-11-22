import java.util.Scanner;

class reversenumexponentiation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int num = n,rev=0,digit;
        while(num!=0){
            digit = num%10;
            rev=rev*10+digit;
            num=num/10;
        }
        rev=rev*rev;
        System.out.println(n*rev);
    }
}


import java.util.Scanner;

public class MathApt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int num = sc.nextInt();
        int result = sumofnaturalnumbers(num);
        System.out.print(result);
        ElementPresent();
        sum_n_product();
    }
    public static int placeValue(int num) {
        int pv = 1;
        while (num / pv != 0) {
            pv = pv * 10;
        }
        pv = pv / 10;
        return pv;
    }

    public static void sum_n_product() {
        // In this method we will find sum of odd digits and product of even digits
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number to find place value : ");
        int num = sc.nextInt();
        int pv, digit, sum = 0, prod = 1, count = 0;
        pv = placeValue(num);
        System.out.println("The place value is " + pv);
        while (pv >= 1 && num / pv != 0) {
            digit = (num / pv) % 10;
            count++;
            if (count % 2 != 0) {
                sum = sum + digit;
            } else if (count % 2 == 0) {
                prod = prod * digit;
            }
            pv = pv / 10;
        }
        System.out.println("The product value is " + prod);
        System.out.println("The sum is " + sum);
    }

    public static void InsertNumber() {
        Scanner sc = new Scanner(System.in);
    }

    public static void ElementPresent() {
        System.out.println("Enter the size of the array : ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        boolean found = false;
        int arr[] = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.print("Enter the element to be found : ");
        int key = sc.nextInt();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                System.out.println("Element found at index : " + i);
                found = true;
                break;
            } else {
                found = false;
            }
        }
        if (!found) {
            System.out.println("Element not found");
        }
    }
    public static void removeDuplicate(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array : ");
        int size = sc.nextInt();
        String[] arr = new String[size];
        System.out.print("Enter the elements in the array : ");
        for(int i=0;i<size;i++){
            arr[i] = sc.next();
        }
        int positions[] = new int[10];
        for(int i=0;i<size-1;i++){
            if(arr[i]==arr[i+1]){
                positions[i]=i;
            }
        }
    }
    public static String longestCommonPrefix(String[] strs) {
        int count = 0;
        boolean mismatch=false;
        for(int i=0;i<strs.length;i++){
            char temp = strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length() || temp != strs[j].charAt(i)){
                    mismatch = true;
                    break;
                }
            }
            if(mismatch == true) break;
            count = count + 1;
        }
        String prefix ="";
        for(int i=0;i<count;i++){
            prefix += strs[0].charAt(i);
        }
        return prefix;
    }
    public static int sumofnaturalnumbers(int num){
        int sum = 0;
        if(num==0) return 0;
        else {
            return (num*(num+1))/2;
        }
    }
}
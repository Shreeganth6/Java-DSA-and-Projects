package technical_aptitude;

import java.util.Scanner;

class IndexValue{
    public static void main(String args[]){
        int n,i,target,temp,flag=1;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array : ");
        n = scanner.nextInt();
        int numbers[] = new int[n];
        System.out.println("Enter the elements of the array : ");
        for(i=0;i<n;i++){
            temp = scanner.nextInt();
            numbers[i] = temp;
        }
        System.out.println("Enter the element to find the index of that element : ");
        target = scanner.nextInt();
        for(i=0;i<n;i++){
            if(numbers[i]==target){
                flag = 0;
                n=i;
            }
        }
        if(flag==0){
            System.out.println("The element is found at "+n);
        }
        else{
            System.out.println("The element is not found");
         }
    }
}
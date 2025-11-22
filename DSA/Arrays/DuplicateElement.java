package technical_aptitude;

import java.util.Scanner;

public class DuplicateElement{
    public static void main(String args[]){
        int numbers[],temp,i,j;
        System.out.println("Enter the size of the array : ");
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        numbers = new int[size];
        System.out.println("Enter the elements in the array \n");
        for(i=0; i<size; i++){
            temp = scanner.nextInt();
            numbers[i] = temp;
        }

        for(i=0;i<size;i++){
            for(j=i+1;j<size;j++){
                if(numbers[i]==numbers[j]){
                    System.out.println("The duplicate element is " + numbers[j]);
                }
            }
        }
    }    
}
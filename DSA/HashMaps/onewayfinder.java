

import java.util.*;
class onewayfinder{
    public static void main(String[] args){
        System.out.print("One way route distance finder");
        HashMap<String,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the total number of routes : ");
        int total_routes = sc.nextInt();
        for(int i=0;i<total_routes;i++){
            System.out.println("Enter the Route : ");
            String route = sc.nextLine();
            sc.next();
            System.out.println("Enter the distance of that route : ");
            int val = sc.nextInt();
            map.put(route,val);
        }
        for(Map.Entry<String,Integer> maps :map.entrySet()){
            System.out.println("Route : "+maps.getKey() +" Distance : "+maps.getValue());
        }
        system.out.println(map[0].getKey());
    }
}
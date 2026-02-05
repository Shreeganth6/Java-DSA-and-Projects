import java.util.*;
class OneWayFinder{
    public static void main(String[] args){
        System.out.print("One way route distance finder");
        HashMap<String,Integer> map = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("\nEnter the total number of routes : ");
        int total_routes = sc.nextInt();
        for(int i=0;i<total_routes;i++){
            System.out.println("Enter the Route : ");
            String route = sc.next();
            System.out.println("Enter the distance of that route : ");
            int val = sc.nextInt();
            map.put(route,val);
        }
        // ROUTES AB 4 BC 5 CD 8 DE 7
        System.out.print("Enter the path : "); // it should be like A-B-C-D THEN IT SHOULD GIVE 18 AB+BC+CD
        String path = sc.next(); // 01 12 23
        String[] results = paths(path);
        int total_distance = 0;
        for(String result : results){
            if(map.containsKey(result)){
                total_distance += map.get(result);
            }
        }
        System.out.print(total_distance);
        sc.close();
    }
    public static String[] paths(String path){
        ArrayList<Character> pathArrayList = new ArrayList<>();
        for(char ch:path.toCharArray()){
            if(ch!='-'){
                pathArrayList.add(ch);
            }
        }
        String[] result = new String[pathArrayList.size()];
        for(int i=0;i<pathArrayList.size()-1;i++){
            result[i] = ""+ pathArrayList.get(i) + pathArrayList.get(i+1);
        }
        return result;
    }
}

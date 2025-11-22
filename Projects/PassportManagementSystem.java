package technical_aptitude;
import java.util.*;

//@author shree
class Record {
    int app_id;
    String app_name;
    public Record(int app_id, String app_name){
        this.app_id = app_id;
        this.app_name = app_name;
    }
    
    @Override
    public String toString(){
        return "ID "+ app_id + "Name " + app_name;
    }
}

public class PassportSystem {
    static List<Record> appointments = new ArrayList<Record>();
    static Scanner sc = new Scanner(System.in);
    public static void main(String args[]){
        Boolean flag = true;
        do{
        int ch;
        System.out.println("1. View 2. Add 3. Search 4. Delete 5. exit ");
        System.out.println("Enter your choice : ");
        ch = sc.nextInt();
        switch(ch){
            case 1:
                for(int i=0;i<appointments.size();i++){
                    System.out.println(appointments.get(i));
                    System.out.println("\t");
                }
                break;
            case 2:
                System.out.println("Enter the application id : ");
                int new_app_id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the application name : ");
                String new_app_name = sc.nextLine();
                appointments.add(new Record(new_app_id,new_app_name));
                break;
            case 3:
                System.out.println("Enter the search application id : ");
                int search = sc.nextInt();
                Boolean found = false;
                for(Record r:appointments){
                    if(r.app_id == search){
                        System.out.println("The element is found "+r);
                        found = true;
                    }
                    else{
                    }
                }
                if(found==false){
                    System.out.println("The element is not found ");
                }
                break;
            case 4:
                continue;
            case 5:
                flag = false;
        }      
        }while(flag == true);
    }

}

import java.util.*;
public class Application{
    public static void main(String[] args) {
        int noOfFloors,slotsInEachFloor;
        String parkingId,vehicle_type,reg_no,color,ticketId,input;
        Scanner sc=new Scanner(System.in);
        System.out.print("create_parking_lot ");
        parkingId=sc.next();
        noOfFloors=sc.nextInt();
        slotsInEachFloor=sc.nextInt(); 
        ParkingLot pt;
        Vehicle[][] v;
        pt=new ParkingLot(parkingId,noOfFloors,slotsInEachFloor);
        v=new Vehicle[noOfFloors][slotsInEachFloor];
        System.out.println("Created parking lot with "+noOfFloors+" floors and "+slotsInEachFloor+" slots per floor");
        do{
            System.out.println("\n1.park_vehicle 2.unpark_vehicle 3.display_free_count 4.display_free_slots 5.display_occupied_slots 6.exit");
            int chioce=sc.nextInt();
            switch(chioce){
                case 1:
                System.out.print("park_vehicle ");
                sc.nextLine();
                input=sc.nextLine();
                String inpu[]=input.split(" ");
                vehicle_type=inpu[0];
                reg_no=inpu[1];
                color=inpu[2];
                pt.park_vehicle(vehicle_type,reg_no,color,v,parkingId);
                break;
                case 2:
                System.out.print("unpark_vehicle ");
                sc.nextLine();
                ticketId=sc.next();
                pt.unpark_vehicle(ticketId,v);
                break;
                case 3:
                System.out.print("display free_count ");
                sc.nextLine();
                vehicle_type=sc.nextLine();
                pt.displayFreeCount(vehicle_type,v);
                break;
                case 4:
                System.out.print("display free_slots ");
                sc.nextLine();
                vehicle_type=sc.next();
                pt.displayFreeSlots(vehicle_type,v);
                break;
                case 5:
                System.out.print("display occupied_slots ");
                sc.nextLine();
                vehicle_type=sc.nextLine();
                pt.displayOccupiedSlots(vehicle_type,v);
                break;
                case 6:
                sc.close();
                System.exit(0);
            }
        }while(true);
    }
}
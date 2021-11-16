import java.util.ArrayList;

public class ParkingLot{
    Vehicle v;
    int noOfFloors,slotsInEachFloor,flag,freeCountOfCar=0,freeCountOfTruck=0,freeCountOfBike=0,freeCountOfVehicle=0;
    String parkingId;
    int i,j,k;
    int floorForCarSlot=0,floorForBikeSlot=0,floorForTruckSlot=0;

    ParkingLot(String parkingId,int noOfFloors,int slotsInEachFloor){
        this.parkingId=parkingId;
        this.noOfFloors=noOfFloors;
        this.slotsInEachFloor=slotsInEachFloor;
    }

    public void park_vehicle(String vehicle_type,String reg_no,String color,Vehicle[][] vehicle,String parkingId){
        try{
            if(vehicle_type.equals("CAR")){
                if(slotsInEachFloor<4){
                    System.out.println("No slot available for car"+"\n");
                    return;
                }
                for(i=3;i<slotsInEachFloor;i++){
                    if(floorForCarSlot==noOfFloors)
                    {
                        System.out.println("Parking Lot for CAR is full");
                        return;
                    }
                    if(vehicle[floorForCarSlot][i]==null)
                    {
                        vehicle[floorForCarSlot][i]=new Car(reg_no, color);
                        System.out.println("Parked vehicle. Ticket ID: "+parkingId+"_"+(floorForCarSlot+1)+"_"+(i+1));
                        return;
                    }
                    if(i==slotsInEachFloor-1)
                    {
                        i=2;
                        floorForCarSlot++;
                    }
                } 
            }

            if(vehicle_type.equals("BIKE")){
                if(slotsInEachFloor<2){
                    System.out.println("No slot available for Bike"+"\n");
                    return;
                }
                for(j=1;j<3;j++){
                    if(floorForBikeSlot==noOfFloors)
                    {
                        System.out.println("Parking Lot for BIKE is full");
                        return;
                    }
                    if(vehicle[floorForBikeSlot][j]==null)
                    {
                        vehicle[floorForBikeSlot][j]=new Bike(reg_no, color);
                        System.out.println("Parked vehicle. Ticket ID: "+parkingId+"_"+(floorForBikeSlot+1)+"_"+(j+1));
                        return;
                    }
                    if(j==2)
                    {
                        j=0;
                        floorForBikeSlot++;
                    }
                }
            }

            if(vehicle_type.equals("TRUCK")){
            if(slotsInEachFloor<1){
                System.out.println("No slot available for Truck"+"\n");
                return;
            }
            for(k=0;k<1;k++){
                if(floorForTruckSlot==1)
                {
                    System.out.println("Parking Lot for TRUCK is full");
                    return;
                }
                if(vehicle[floorForTruckSlot][k]!=null){
                    floorForTruckSlot++;
                }
                if(vehicle[floorForTruckSlot][k]==null)
                {
                    vehicle[floorForTruckSlot][k]=new Truck(reg_no, color);
                    System.out.println("Parked vehicle. Ticket ID: "+parkingId+"_"+(floorForTruckSlot+1)+"_"+(k+1));
                    return;
                }
            }
        }
        }
        catch(Exception e){
            System.out.println("Enter exact input for parking lot");
        }
    }

    public ArrayList<ArrayList<Integer>> display(Vehicle[][] vehicle,int startIndex,int endIndex){
        ArrayList<ArrayList<Integer>> freeCount=new ArrayList<ArrayList<Integer>>();
        int temp=noOfFloors;
        if(slotsInEachFloor<startIndex+1){
            System.out.println("No slot available for car");
        }
        else{
            
            while(temp>0){
                freeCountOfVehicle=0;
                ArrayList<Integer> freeSlotsInParticularFloor=new ArrayList<Integer>();
                for(int i=startIndex;i<endIndex;i++){
                    if(vehicle[noOfFloors-temp][i]==null)
                    freeSlotsInParticularFloor.add(i+1);

                }
                freeCount.add(freeSlotsInParticularFloor);
                temp--;
            }
        }
        return freeCount;
    }

    public ArrayList<ArrayList<Integer>> displayOccupied(Vehicle[][] vehicle,int startIndex,int endIndex){
        ArrayList<ArrayList<Integer>> occupied=new ArrayList<ArrayList<Integer>>();
        int temp=noOfFloors;
        if(slotsInEachFloor<startIndex+1){
            System.out.println("No slot available for car");
        }
        else{
            
            while(temp>0){
                freeCountOfVehicle=0;
                ArrayList<Integer> occupiedSlotsInParticularFloor=new ArrayList<Integer>();
                for(int i=startIndex;i<endIndex;i++){
                    if(vehicle[noOfFloors-temp][i]!=null)
                    occupiedSlotsInParticularFloor.add(i+1);

                }
                occupied.add(occupiedSlotsInParticularFloor);
                temp--;
            }
        }
        return occupied;
    }
    
    public void displayFreeSlots(String vehicle_type,Vehicle[][] vehicle,int startIndex,int endIndex){
        ArrayList<ArrayList<Integer>> res=display(vehicle, startIndex, endIndex);
        int temp=noOfFloors;
        while(temp>0){
            System.out.print("Free slots for "+vehicle_type+" on Floor "+((noOfFloors-temp)+1)+": "+res.get(noOfFloors-temp).toString().replace("[", "").replace("]", "")+"\n");
            temp--;
        }
    }

    public void displayFreeCount(String vehicle_type,Vehicle[][] vehicle,int startIndex1,int endIndex1){
        int startIndex=startIndex1;
        int endIndex=endIndex1;
        ArrayList<ArrayList<Integer>> res=display(vehicle, startIndex, endIndex);
        int temp=noOfFloors;
        while(temp>0){
            System.out.print("No. of free slots for "+vehicle_type+" on Floor "+((noOfFloors-temp)+1)+" : "+res.get(noOfFloors-temp).size()+"\n");
            temp--;
        }  
    }

    public void displayOccupiedSlots(String vehicle_type,Vehicle[][] vehicle,int startIndex1,int endIndex1){
        ArrayList<ArrayList<Integer>> res=displayOccupied(vehicle, startIndex1, endIndex1);
        int temp=noOfFloors;
        while(temp>0){
            System.out.print("Occupied slots for "+vehicle_type+" on Floor "+((noOfFloors-temp)+1)+": "+res.get(noOfFloors-temp).toString().replace("[", "").replace("]", "")+"\n");
            temp--;
        }
    }

    public void unpark_vehicle(String ticket_id,Vehicle[][] vehicle){
        try{
            String[] word=ticket_id.split("_");
            int floor=Integer.parseInt(word[1]);
            int slotOfParticularFloor=Integer.parseInt(word[2]);
            if((floor-1)>=noOfFloors || (floor<0) || ((slotOfParticularFloor-1)>=slotsInEachFloor) || (slotOfParticularFloor<0)){
                System.out.println("Invalid Ticket");
                return;
            }   
            v=vehicle[floor-1][slotOfParticularFloor-1];
            //System.out.println(v);
            if(vehicle[floor-1][slotOfParticularFloor-1]==null)
            System.out.println("Invalid Ticket");
            else{
                System.out.println("Unparked vehicle with Registration Number: "+v.reg_no+" and Color: "+v.color);
                vehicle[floor-1][slotOfParticularFloor-1]=null;
                floorForCarSlot=0;
                floorForBikeSlot=0;
                floorForTruckSlot=0;
            }
        }
        catch(Exception e){
            System.out.println("Invalid ticket....");
        }
    }
}
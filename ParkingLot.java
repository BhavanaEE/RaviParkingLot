public class ParkingLot{
    Vehicle v;
    int noOfFloors,slotsInEachFloor,flag,freeCountOfCar=0,freeCountOfTruck=0,freeCountOfBike=0;
    String parkingId;
    int floorForCarSlot=0,floorForBikeSlot=0,floorForTruckSlot=0,i,j,k=0;
    int[][] freeCount;
    
    ParkingLot(String parkingId,int noOfFloors,int slotsInEachFloor){
        this.parkingId=parkingId;
        this.noOfFloors=noOfFloors;
        this.slotsInEachFloor=slotsInEachFloor;
        this.freeCount = new int[noOfFloors][3];
    }

    public void park_vehicle(String vehicle_type,String reg_no,String color,Vehicle[][] vehicle,String parkingId){
        if(vehicle_type.equals("CAR")){
            if(slotsInEachFloor<4){
                System.out.println("No slot available for car"+"\n");
                return;
            }
            for(i=3;i<slotsInEachFloor;i++){
                if(floorForCarSlot==noOfFloors)
                {
                    flag=1;
                    break;
                }
                if(vehicle[floorForCarSlot][i]==null)
                {
                    vehicle[floorForCarSlot][i]=new Car(reg_no, color);
                    flag=2;
                    break;
                }
                if(i==slotsInEachFloor-1)
                {
                    i=2;
                    floorForCarSlot++;
                }
            } 
            if(flag==2)
            System.out.println("Parked vehicle. Ticket ID: "+parkingId+"_"+(floorForCarSlot+1)+"_"+(i+1));
            if(flag==1)
            System.out.println("Parking Lot for CAR is full");
        }

        if(vehicle_type.equals("BIKE")){
            if(slotsInEachFloor<2){
                System.out.println("No slot available for Bike"+"\n");
                return;
            }
            for(j=1;j<3;j++){
                if(floorForBikeSlot==noOfFloors)
                {
                    flag=1;
                    break;
                }
                if(vehicle[floorForBikeSlot][j]==null)
                {
                    vehicle[floorForBikeSlot][j]=new Bike(reg_no, color);
                    flag=2;
                    break;
                }
                if(j==2)
                {
                    j=0;
                    floorForBikeSlot++;
                }
            }
            if(flag==2)
            System.out.println("Parked vehicle. Ticket ID: "+parkingId+"_"+(floorForBikeSlot+1)+"_"+(j+1));
            if(flag==1)
            System.out.println("Parking Lot for BIKE is full");
        }

        if(vehicle_type.equals("TRUCK")){
            if(slotsInEachFloor<1){
                System.out.println("No slot available for Truck"+"\n");
                return;
            }
            for(k=0;k<1;k++){
                if(floorForTruckSlot==1)
                {
                    flag=1;
                    break;
                }
                if(vehicle[floorForTruckSlot][k]!=null){
                    floorForTruckSlot++;
                }
                if(vehicle[floorForTruckSlot][k]==null)
                {
                    vehicle[floorForTruckSlot][k]=new Truck(reg_no, color);
                    flag=2;
                    break;
                }
            }
            if(flag==2)
            {
                System.out.println("Parked vehicle. Ticket ID: "+parkingId+"_"+(floorForTruckSlot+1)+"_"+(k+1));
            }

            if(flag==1)
            System.out.println("Parking Lot for TRUCK is full");
        }
    }

    public void displayFreeSlots(String vehiche_type,Vehicle[][] vehicle){
        int temp=noOfFloors;
        if(vehiche_type.equals("CAR")){
            if(slotsInEachFloor<4){
                System.out.println("No slot available for car");
                return;
            }
            while(temp>0){
                freeCountOfCar=0;
                System.out.print("Free slots for CAR on Floor "+((noOfFloors-temp)+1)+": ");
                for(i=3;i<slotsInEachFloor;i++){
                    if(i==slotsInEachFloor-1 && vehicle[noOfFloors-temp][i]==null){
                        freeCountOfCar+=1;
                        System.out.print((i+1)+"\n");
                        break;
                    }
                    if(vehicle[noOfFloors-temp][i]==null){
                        freeCountOfCar+=1;
                        System.out.print((i+1)+", ");
                    }
                }
                System.out.println();
                temp--;
            }
        }

        if(vehiche_type.equals("BIKE")){
            if(slotsInEachFloor<2){
                System.out.println("No slot available for Bike");
                return;
            }
            while(temp>0){
                freeCountOfBike=0;
                System.out.print("Free slots for BIKE on Floor "+((noOfFloors-temp)+1)+": ");
                for(j=1;j<3;j++){
                    if(j==2 && vehicle[noOfFloors-temp][j]==null){
                        freeCountOfBike+=1;
                        System.out.print((j+1)+"\n");
                        break;
                    }
                    if(vehicle[noOfFloors-temp][j]==null){
                        freeCountOfBike+=1;
                        System.out.print((j+1)+", ");
                    }
                }
                System.out.println();
                freeCount[noOfFloors-temp][1]=freeCountOfBike;
                temp--;
            }
        }
        
        if(vehiche_type.equals("TRUCK")){
            if(slotsInEachFloor<1){
                System.out.println("No slot available for Truck");
                return;
            }
            while(temp>0){
                freeCountOfTruck=0;
                System.out.print("Free slots for TRUCK on Floor "+((noOfFloors-temp)+1)+": ");
                for(k=0;k<1;k++){
                    if(vehicle[noOfFloors-temp][k]==null){
                        freeCountOfTruck+=1;
                        System.out.print((k+1)+"\n");
                    }
                }
                System.out.println();
                freeCount[noOfFloors-temp][2]=freeCountOfTruck;
                temp--;
            }
        }
    }

    public void displayFreeCount(String vehiche_type,Vehicle[][] vehicle){
        int temp=noOfFloors;
        if(vehiche_type.equals("CAR")){
            if(slotsInEachFloor<4){
                System.out.println("No slot available for car"+"\n");
                return;
            }
            while(temp>0){
                freeCountOfCar=0;
                System.out.print("No. of free slots for CAR on Floor "+((noOfFloors-temp)+1)+" : ");
                for(i=3;i<slotsInEachFloor;i++){
                    if(i==slotsInEachFloor-1 && vehicle[noOfFloors-temp][i]==null){
                        freeCountOfCar+=1;
                        break;
                    }
                    if(vehicle[noOfFloors-temp][i]==null){
                        freeCountOfCar+=1;
                    }
                }
                //freeCount[noOfFloors-temp][0]=freeCountOfCar;
                System.out.print(freeCountOfCar+"\n");
                temp--;
            }
        }

        if(vehiche_type.equals("BIKE")){
            if(slotsInEachFloor<2){
                System.out.println("No slot available for Bike"+"\n");
                return;
            }
            while(temp>0){
                freeCountOfBike=0;
                System.out.print("No. of free slots for BIKE on Floor "+((noOfFloors-temp)+1)+" :");
                for(j=1;j<3;j++){
                    if(j==2 && vehicle[noOfFloors-temp][j]==null){
                        freeCountOfBike+=1;
                        break;
                    }
                    if(vehicle[noOfFloors-temp][j]==null){
                        freeCountOfBike+=1;
                    }
                }
                //freeCount[noOfFloors-temp][1]=freeCountOfBike;
                System.out.print(freeCountOfBike+"\n");
                temp--;
            }
        }
        
        if(vehiche_type.equals("TRUCK")){
            if(slotsInEachFloor<1){
                System.out.println("No slot available for Truck"+"\n");
                return;
            }
            while(temp>0){
                freeCountOfTruck=0;
                System.out.print("No. of free slots for TRUCK on Floor "+((noOfFloors-temp)+1)+" : ");
                for(k=0;k<1;k++){
                    if(vehicle[noOfFloors-temp][k]==null){
                        freeCountOfTruck+=1;
                    }
                }
                //freeCount[noOfFloors-temp][2]=freeCountOfTruck;
                System.out.println(freeCountOfTruck);
                temp--;
            }
        }  
    }

    public void displayOccupiedSlots(String vehiche_type,Vehicle[][] vehicle){
        int temp=noOfFloors;
        if(vehiche_type.equals("CAR")){
            if(slotsInEachFloor<4){
                System.out.println("No slot available for car"+"\n");
                return;
            }
            while(temp>0){
                freeCountOfCar=0;
                System.out.print("Occupied slots for CAR on Floor "+((noOfFloors-temp)+1)+": ");
                for(i=3;i<slotsInEachFloor;i++){
                    if(i==slotsInEachFloor-1 && vehicle[noOfFloors-temp][i]!=null){
                        System.out.print((i+1)+"\n");
                        break;
                    }
                    if(vehicle[noOfFloors-temp][i]!=null){
                        System.out.print((i+1)+", ");
                    }
                }
                System.out.println();
                temp--;
            }
        }

        if(vehiche_type.equals("BIKE")){
            if(slotsInEachFloor<2){
                System.out.println("No slot available for Bike"+"\n");
                return;
            }
            while(temp>0){
                freeCountOfBike=0;
                System.out.print("Occupied slots for BIKE on Floor "+((noOfFloors-temp)+1)+": ");
                for(j=1;j<3;j++){
                    if(j==2 && vehicle[noOfFloors-temp][j]!=null){
                        System.out.print((j+1)+"\n");
                        break;
                    }
                    if(vehicle[noOfFloors-temp][j]!=null){
                        System.out.print((j+1)+", ");
                    }
                }
                System.out.println();
                temp--;
            }
        }

        if(vehiche_type.equals("TRUCK")){
            if(slotsInEachFloor<1){
                System.out.println("No slot available for Truck"+"\n");
                return;
            }
            while(temp>0){
                freeCountOfTruck=0;
                System.out.print("Occupied slots for TRUCK on Floor "+((noOfFloors-temp)+1)+": ");
                for(k=0;k<1;k++){
                    if(vehicle[noOfFloors-temp][k]!=null){
                        System.out.print((k+1)+"\n");
                    }
                }
                System.out.println();
                temp--;
            }
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
                floorForCarSlot=floor-1;
        }
        }
        catch(Exception e){
            System.out.println("Invalid ticket....");
        }
    }
}
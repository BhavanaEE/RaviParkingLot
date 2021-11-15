public class Vehicle{
    String vehicle_type,reg_no,color;
}
class Car extends Vehicle{
    public Car(String reg_no, String color){
        this.reg_no=reg_no;
        this.color=color;
    }
}
class Bike extends Vehicle{
    public Bike(String reg_no, String color){
        this.reg_no=reg_no;
        this.color=color;
    }
}
class Truck extends Vehicle{
    public Truck(String reg_no, String color){
        this.reg_no=reg_no;
        this.color=color;
    }
}
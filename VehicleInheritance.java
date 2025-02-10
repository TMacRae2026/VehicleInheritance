/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.vehicleinheritance;

/**
 *
 * @author TMacRae2026
 */
public class VehicleInheritance {

    public static void main(String[] args) {
        
        Boat boat = new Boat("Boston Whaler", 40, 5, 6000, 100, true, "Motor");
        System.out.println(boat);
        System.out.println();
        Boat kayak = new Boat("Kayak", 8, 1, 200, 4, false, "Paddle");
        System.out.println(kayak);
        System.out.println();
        
        SailBoat mySailBoat = new SailBoat("Yacht Brand", 40.5, 10, 5000.0, 30, true, "Wind", 50.0);
        System.out.println(mySailBoat);
        System.out.println();
        
        AirlineAirplane airlinePlane = new AirlineAirplane("Boeing", 550, 200, 25000, 
                                                           35000, 120, "Delta Airlines", 4500);
        System.out.println(airlinePlane);
        System.out.println();
        
        PropellerAirplane smallAirplane = new PropellerAirplane("Cessna", 220, 4, 500, 15000, 35, 2);
        System.out.println(smallAirplane);
        System.out.println();
        
        Bike bike1 = new Bike(2, 1, 2, "Schwinn", 15.5, 1, 0.0);
        System.out.println(bike1);
        System.out.println();
        Bike comicallyLargeBike = new Bike(20, 20, 40, "Giant Bike", 10.0, 20, 2000.0);
        System.out.println(comicallyLargeBike);
        System.out.println();
        
        Blimp myBlimp = new Blimp("Goodyear", 45.0, 10, 5000.0, 2000.0, 156100.583);
        System.out.println(myBlimp);
        
    }
}

class Boat extends Vehicle {
    private int boatSize;
    private boolean forPartying;
    private String powerType;
    public Boat() {
        super();
        boatSize = 0;
        forPartying = false;
        powerType = "";
    }
    
    public Boat(String inBrand, double inSpeed, int inPassengers, double inCargo, int boatSize, boolean forPartying, String powerType) {
        super(inBrand, inSpeed, inPassengers, inCargo);
        this.forPartying = forPartying;
        this.boatSize = boatSize;
        this.powerType = powerType;
    }
    
    public int howManyPartyGuestsCanHost() { // calculates how many guests to invite to your next yatcht party
        if(this.forPartying)
            return (boatSize / 5) + 3;
        else
            return 0;
    }
    
    @Override
    public String toString() {
        String result = super.toString();
        result += "Party Guests:\t" + howManyPartyGuestsCanHost();
        result += "\nBoat size:\t" + boatSize;
        result += "\nPowerType\t" + powerType;
        return result;
    }
}

class SailBoat extends Boat{
    public double sailSize;
    public SailBoat(){
        super();
        sailSize = 0;
    }
    
    public SailBoat(String inBrand, double inSpeed, int inPassengers, double inCargo, int boatSize, boolean forPartying, String powerType, double sailSize){
        super(inBrand, inSpeed, inPassengers, inCargo, boatSize, forPartying, powerType);
        this.sailSize = sailSize;
    }

    public double getSailSize() {
        return sailSize;
    }

    public void setSailSize(double sailSize) {
        this.sailSize = sailSize;
    }
    
    public String toString() {
        String result = super.toString();
        result += "\nsail size:\t" + sailSize;
        return result;
    }
    
}

class Airplane extends Vehicle {
    // Airline Airplane-specific properties
    private double altitude; //in feet
    private double wingspan; //in feet

    // Default constructor
    public Airplane() {
        super(); // Call the parent class's constructor
        altitude = 0.0;
        wingspan = 0.0;
    }

    // Constructor with parameters
    public Airplane(String inBrand, double inSpeed, int inPassengers, double inCargo, double inAltitude, double inWingspan) {
        super(inBrand, inSpeed, inPassengers, inCargo); // Call the parent class's constructor
        altitude = inAltitude;
        wingspan = inWingspan;
    }

    // Getter and Setter for Altitude
    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double inAltitude) {
        altitude = inAltitude;
    }

    // Getter and Setter for Wingspan
    public double getWingspan() {
        return wingspan;
    }

    public void setWingspan(double inWingspan) {
        wingspan = inWingspan;
    }

    // Override the toString method to include Airplane-specific details
    @Override
    public String toString() {
        String result = super.toString(); // Get Vehicle details
        result += "Altitude (ft): \t" + getAltitude() + "\n" +
                  "Wingspan (ft): \t" + getWingspan();
        return result;
    }
}

class AirlineAirplane extends Airplane {
    // AirlineAirplane-specific properties
    private String airlineName; // Name of the airline
    private double flightRange; // Maximum flight range in miles

    // Default constructor
    public AirlineAirplane() {
        super(); // Call the parent class's constructor
        airlineName = "";
        flightRange = 0.0;
    }

    // Constructor with parameters
    public AirlineAirplane(String inBrand, double inSpeed, int inPassengers, double inCargo, 
                           double inAltitude, double inWingspan, String inAirlineName, double inFlightRange) {
        super(inBrand, inSpeed, inPassengers, inCargo, inAltitude, inWingspan); // Call the parent class's constructor
        airlineName = inAirlineName;
        flightRange = inFlightRange;
    }

    // Getter and Setter for Airline Name
    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String inAirlineName) {
        airlineName = inAirlineName;
    }

    // Getter and Setter for Flight Range
    public double getFlightRange() {
        return flightRange;
    }

    public void setFlightRange(double inFlightRange) {
        flightRange = inFlightRange;
    }

    // Override the toString method to include AirlineAirplane-specific details
    @Override
    public String toString() {
        String result = super.toString(); // Get Airplane details
        result += "\nAirline Name: \t" + getAirlineName() + "\n" +
                  "Flight Range (miles): \t" + getFlightRange();
        return result;
    }
}



class PropellerAirplane extends Airplane {
    // PropellerAirplane-specific property
    private int numberOfPropellers; // number of propellers on the airplane

    // Default constructor
    public PropellerAirplane() {
        super(); // Call the parent class's constructor
        numberOfPropellers = 0; // Default to 0 propellers
    }

    // Constructor with parameters
    public PropellerAirplane(String inBrand, double inSpeed, int inPassengers, double inCargo, 
                             double inAltitude, double inWingspan, int inNumberOfPropellers) {
        super(inBrand, inSpeed, inPassengers, inCargo, inAltitude, inWingspan); //call the parent class's constructor
        numberOfPropellers = inNumberOfPropellers;
    }

    // Getter and Setter for Number of Propellers
    public int getNumberOfPropellers() {
        return numberOfPropellers;
    }

    public void setNumberOfPropellers(int inNumberOfPropellers) {
        numberOfPropellers = inNumberOfPropellers;
    }

    // Override the toString method to include PropellerAirplane-specific details
    @Override
    public String toString() {
        String result = super.toString(); // Get Airplane details
        result += "\nNumber of Propellers: \t" + getNumberOfPropellers();
        return result;
    }
}

class Blimp extends Vehicle {
    //blimp-specific properties
    private double altitude;  //altitude of the blimp (in feet)
    private double size; //size of the blimp (in cubic feet)

    public Blimp() {
        super();
        altitude = 0.0;
        size = 0.0;
    }

    // Constructor
    public Blimp(String inBrand, double inSpeed, int inPassengers, double inCargo, 
                 double inAltitude, double inSize) {
        super(inBrand, inSpeed, inPassengers, inCargo);
        altitude = inAltitude;
        size = inSize;
    }

    public double getAltitude() {
        return altitude;
    }

    public void setAltitude(double inAltitude) {
        altitude = inAltitude;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double inSize) {
        size = inSize;
    }

    // Override the toString method to include Blimp-specific details
    @Override
    public String toString() {
        String result = super.toString(); // Get Vehicle details
        result += "Altitude (ft): \t" + getAltitude() + 
                  "\nSize (cubic feet): \t" + getSize();
        return result;
    }
}


class Bike extends Vehicle {
    private int pedals;
    private int seats;
    private int wheels;
    
    public Bike(){
        super();
        pedals = 0;
        seats = 0;
        wheels = 0;
    }

    public Bike(int pedals, int seats, int wheels) {
        this.pedals = pedals;
        this.seats = seats;
        this.wheels = wheels;
    }

    public Bike(int pedals, int seats, int wheels, String inBrand, double inSpeed, int inPassengers, double inCargo) {
        super(inBrand, inSpeed, inPassengers, inCargo);
        this.pedals = pedals;
        this.seats = seats;
        this.wheels = wheels;
    }

    public Bike(int pedals, int seats, int wheels, String inBrand) {
        super(inBrand);
        this.pedals = pedals;
        this.seats = seats;
        this.wheels = wheels;
    }

    public int getPedals() {
        return pedals;
    }

    public void setPedals(int pedals) {
        this.pedals = pedals;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }
    
    public String toString() {
        String result = super.toString();
        result += "pedals: \t" + pedals;
        result += "\nseats: \t" + seats;
        result += "\nwheels: \t" + wheels;
        return result;
    }
    
}


// The Base Vehicle Class, implements the Speedometer interface
class Vehicle implements Speedometer{
    //base (Class wide) variables
    protected String brandName = "";
    protected double speed = 0.0;
    protected int passengers = 0;
    protected double cargoWeight = 0.0;
    //Base default constructor 
    public Vehicle(){
        brandName = "";
        speed = 0.0;
        passengers = 0;
        cargoWeight = 0.0;
    }

    public Vehicle(String inBrand, double inSpeed, int inPassengers, double inCargo){
        brandName = inBrand;
        speed = inSpeed;
        passengers = inPassengers;
        cargoWeight = inCargo;
    }

    //getters and setters
    public Vehicle(String inBrand){
        brandName = inBrand;
    }

    public String getBrand(){
        return brandName;
    }

    public  void setBrandName(String inBrand){
        brandName = inBrand;
    }

    public double getSpeed(){
        return  speed;
    }

    public void setSpeed(double inSpeed){
        speed = inSpeed;
    }

    public int getPassengers(){
        return  passengers;
    }

    public void setPassengers(int inPassengers){
        speed = inPassengers;
    }

    public double getCargoWeight(){
        return  cargoWeight;
    }

    public void setCargoWeight(double inCargoWeight){
        cargoWeight = inCargoWeight;
    }

    //Base toString
    public String toString(){
        String result = "";
        result = "Brand: \t\t\t" + getBrand() + "\n" +
                "Speed (mph): \t" + getSpeed() + "\n" +
                "Passengers: \t" + getPassengers() + "\n" +
                "Cargo (lbs): \t" + getCargoWeight() + "\n";
        return result;
    }
}
//the Speedometer interface to show the speed of any vehicle in the same way
interface Speedometer{
    public void setSpeed(double inSpeed);
    public double getSpeed();
 }

// Car Class inherits from Vehicle Class
class Car extends Vehicle{
    int wheels = 4;
    String color = "White";
    boolean spoiler = false;
    boolean stereo = false;
    double mpg = 0.0; //has an extra variable, mpg

    public Car(String inBrand, double inSpeed, int inPassengers, double inCargo, double inMPG){
        super(inBrand, inSpeed, inPassengers, inCargo); //uses the super constructor
        mpg = inMPG; //also include the extra variable in the Car constructor
    }
    //another additional variable
    public void setSpoiler(boolean inSpoiler){
        spoiler = inSpoiler;
    }

    public boolean getSpoiler(){
        return spoiler;
    }
    //another additional variable
    public void setStereo(boolean inStereo){
        stereo = inStereo;
    }

    public boolean getStereo(){
        return  stereo;
    }
    //overrides the super getSpeed method
    @Override
    public double getSpeed() {
        if (spoiler)
            return super.getSpeed() + 20;
        else
            return super.getSpeed();
    }

    public void setMpg(double mpg) {
        this.mpg = mpg;
    }

    public double getMPG(){
        if(stereo)
            return mpg - (mpg / 10);
        else
            return mpg;
    }
    //usesd the super toString, as well as addingnthe new variable to it.
    public String toString(){
        String result = super.toString() +
                "MPG :\t\t\t" + this.getMPG();
        return  result ;
    }
}


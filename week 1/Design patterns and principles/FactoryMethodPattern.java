interface Vehicle {
    void drive();
}

class Car implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving Car");
    }
}

class Bike implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving Bike");
    }
}

class Truck implements Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving Truck");
    }
}

class VehicleFactory {

    public static Vehicle getVehicle(String type) {

        if (type == null)
            return null;

        if (type.equalsIgnoreCase("Car")) {
            return new Car();
        }
        else if (type.equalsIgnoreCase("Bike")) {
            return new Bike();
        }
        else if (type.equalsIgnoreCase("Truck")) {
            return new Truck();
        }

        return null;
    }
}

public class FactoryMethodPattern {

    public static void main(String[] args) {

        Vehicle v1 = VehicleFactory.getVehicle("Car");
        v1.drive();

        Vehicle v2 = VehicleFactory.getVehicle("Bike");
        v2.drive();

        Vehicle v3 = VehicleFactory.getVehicle("Truck");
        v3.drive();
    }
}
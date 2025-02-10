public class Car {
 private String carNumber;
 private String carModel;

    public Car(String carNumber, String carModel) {
        this.carNumber = carNumber;
        this.carModel = carModel;
    }

    @Override
    public String toString() {
        return "carNumber='" + carNumber + '\'' +
                ", carModel='" + carModel + '\'' ;
    }

    public String getCarNumber() {
        return carNumber;
    }

    public String getCarModel() {
        return carModel;
    }
}

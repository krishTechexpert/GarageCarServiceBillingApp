import java.util.ArrayList;
import java.util.UUID;
import java.util.List;
/*
* When new customer come for car service then Garage shop will store customer information into
* his record such as
* customer name, phone number
* customer car number, car model
* customer take which service such as car wash, oil change etc.
* after customer take service and payment done.
* our Car Garage will provide Bill/Invoice to the customer.
* */

public class Customer {
    private final String id;
    private String customerName;
    private String customerPhone;
    private Car car;
    private ArrayList<Service> selectService;
//    private Date date;
    // we can create restriction like if customer have car then Constructor will create
    public Customer(String name,String phone,Car car){
        this.id= UUID.randomUUID().toString(); // Generate unique ID
        this.customerName=name;
        this.customerPhone=phone;
        this.car=car;
        this.selectService=new ArrayList<>();
    }

    public Car getCar() {
        return car;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                "," + car.toString() + '\'' +
                "selectService=" + selectService +
                '}';
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Service> getSelectService() {
        return selectService;
    }

    public void selectService(Service s){
        System.out.println(s);
        selectService.add(s);
    }
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
/*
* this class is responsible for generate Invoice
* */
public class Invoice {
    private final String billId;
    private String paymentType="Cash";
    private Customer customer;
    private double totalAmount;

    public Invoice(Customer customer) {
        this.customer = customer;
        this.billId= UUID.randomUUID().toString(); // Generate unique ID
    }

    public Customer getCustomer() {
        return customer;
    }

    public String getBillId() {
        return billId;
    }

    public void generateInvoice(){
        LocalDateTime now = LocalDateTime.now(); //Get current date and time
        // Format the date as dd/MM/yyyy (08/02/2025)
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String billDate = now.format(dateFormatter);

        // Format the time as hh:mm a (06:52 PM)
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm a");
        String billTime = now.format(timeFormatter);


        System.out.println("------Print Invoice-----");
        System.out.println("Krish Car Garage service shop");
        System.out.println("Bill No:"+ getBillId() + " | " + "Payment Type:"+ paymentType);
        System.out.println("Bill Date:"+ billDate + " | " + "Bill Time:"+ billTime);
        System.out.println("Customer Name=" + this.customer.getCustomerName());
        System.out.println("Car Number=" + this.customer.getCar().getCarNumber() + " | " + "Car Model=" + this.customer.getCar().getCarModel());
        System.out.println("Service=" + this.customer.getSelectService().toString());
        System.out.println("Total Bill Amount=" + calculateAmount());
        System.out.println("Thank you Visit again...");
    }
    public double calculateAmount(){
        for(Service s : customer.getSelectService()){
            totalAmount+=s.getPrice();
        }
        return totalAmount;

    }
}

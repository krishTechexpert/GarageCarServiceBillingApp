import java.util.ArrayList;
/*
* this class is responsible for such as
* add new service into system (inside service List)
* add new customer record
* generate Bill/Invoice
* */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CarGarageSystem {
    private ArrayList<Customer> customers;
    private ArrayList<Service> myServices;
    private HashMap<String, Invoice> invoiceRecords;// Store all invoices for future reference
    public CarGarageSystem() {
        this.customers = new ArrayList<>();
        this.myServices = new ServiceLists().getServices();
        this.invoiceRecords = new HashMap<>(); // Initialize invoice storage
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public HashMap<String, Invoice> getInvoiceRecords() {
        return invoiceRecords;
    }

    public ArrayList<Service> getMyServices() {
        return myServices;
    }
    //customer
    public void addNewCustomer(Customer c){
        customers.add(c);
    }
    public void displayAllCustomersList(){
        if(customers.isEmpty()) {
            System.out.println("No user found");
            return;
        }
        for(Customer c:customers){
            System.out.println(c.toString());
        }
    }
    //Service
    public void addNewService(String name,double price){
        myServices.add(new Service(name,price));
    }

    public void displayAllService(){
        for(int i=0;i<myServices.size();i++){
            System.out.println((i+1)+":"+ myServices.get(i).toString());//{service: 'Car Wash', price: 500}

        }
//        for (Service service : myServices) {
//            System.out.println(service.toString());//{service: 'Car Wash', price: 500}
//        }
    }

    // Generate invoice and store purchase history
    public void generateInvoice(Customer customer){
        Invoice invoice = new Invoice(customer);
        invoice.generateInvoice(); // Generate bill
        invoiceRecords.put(invoice.getBillId(), invoice); // Store invoice
    }

    // Display purchase history from invoices
    public void displayPurchaseHistory() {
        if (invoiceRecords.isEmpty()) {
            System.out.println("No purchase history available.");
            return;
        }
        System.out.println("\n===== Purchase History =====");
        for (Map.Entry<String, Invoice> entry : invoiceRecords.entrySet()) { //{bill,invoice}
            Invoice invoice = entry.getValue(); // Get the Invoice object
            Customer customer = invoice.getCustomer(); // Directly get the Customer

            System.out.println("Bill ID: " + entry.getKey());
            System.out.println("Customer Name: " + customer.getCustomerName());
            System.out.println("Car Number: " + customer.getCar().getCarNumber());
            System.out.println("Car Model: " + customer.getCar().getCarModel());
            System.out.println("Total Amount: " + invoice.calculateAmount());
            System.out.println("--------------------------");
        }

    }

}

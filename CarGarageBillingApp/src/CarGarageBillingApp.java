import java.util.Scanner;

public class CarGarageBillingApp {
    public static void main(String[] args) {
        CarGarageSystem app = new CarGarageSystem();
        System.out.println("----- Krish Car Garage Service-----");

        Scanner sc = new Scanner(System.in);
        /*Simple Rule to Remember
🔹 After using nextInt(), nextDouble(), or next() for numbers, always call sc.nextLine()
before reading a full line.
     This prevents issues when switching from numbers to text input.

         */
        Customer currentCustomer=null;
        while (true) { // Keep looping until user chooses to exit
            System.out.println("press 1 for store Customer Information");
            System.out.println("press 2 for Display All services");
            System.out.println("press 3 for Display All Customers List");
            System.out.println("press 4 for Add new Service");
            System.out.println("press 5 for Display All Invoice Purchase history");
            System.out.println("press 0 for exist");
            System.out.println("Enter your option: ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    System.out.println("Customer Name: ");
                    //next()	First whitespace (space, tab, enter)	❌ No (stops at space)
                    String name = sc.next();
                    System.out.println("Customer Phone Number: ");
                    String phone = sc.next();
                    System.out.println("Car Number: ");
                    String carNumber = sc.next();
                    System.out.println("Car Model");
                    String carModel = sc.next();  // Reads only until first space

                    Car car = new Car(carNumber, carModel);
                    Customer customer = new Customer(name, phone, car);
                    currentCustomer=customer;
                    app.addNewCustomer(customer);
                    System.out.println("Customer added successfully!");
                    break;
                case 2:
                    System.out.println("Display services");
                    app.displayAllService();
                    while(true){
                        System.out.println("Select service");
                        int choice = sc.nextInt();
                        sc.nextLine();
                        if(choice>0 && choice <= app.getMyServices().size()){
                            Service s = app.getMyServices().get(choice-1);
                            if(currentCustomer != null){
                                currentCustomer.selectService(s);
                            }
                            //customer.selectService(s);
                            //System.out.println(new Invoice(customer,s));
                                //break;
                        }
                        else {
                            System.out.println("you have selected service :"+currentCustomer.getSelectService());
                            //sc.close();
                            app.generateInvoice(currentCustomer);
                            break; // Exit the loop and program
                        }

                    }
                    //generate bill
                    break;
                case 3:
                    System.out.println("Find All Customer List");
                    app.displayAllCustomersList();
                    break;
                case 4:
                    System.out.println("Enter New service name");
                    //nextLine()	End of the line (until Enter is pressed)	✅ Yes (reads full line)
                    sc.nextLine(); // Consume any leftover newline character such as key lock repair
                    //sc.nextLine();  // This clears the leftover newline

                    try{
                        String serviceName = sc.nextLine(); // Read full line
                        System.out.println("Enter price for new "+serviceName+" service");
                        String priceInput = sc.nextLine(); // Read price as a string
                        int servicePrice = Integer.parseInt(priceInput); // Convert to integer

                        app.addNewService(serviceName,servicePrice);
                        break;
                    }catch (NumberFormatException e) {
                        System.out.println("Invalid price. Please enter a numeric value.");
                    }
                case 5:
                    System.out.println("-----Invoice purchase history----");
                    app.displayPurchaseHistory();
                    break;
                case 0:
                    System.out.println("Exist... Thank you!");
                    sc.close();
                    return; // Exit the loop and program
                default:
                    System.out.println("Invalid option, please try again.");
            }
            System.out.println(); // Adds a blank line for better readability
        }
    }
}
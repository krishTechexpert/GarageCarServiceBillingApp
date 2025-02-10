import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

/*
* this class is responsible such as
* what service will be provided by our Car garage shop
* services class contains list of predefined service such as
* Car Wash : $500
* Oil change : $300
* Car Panchar : $100
* Tyre replacement : $3000
* Ac filter : $100
*
* and one important thing I have to mention that
* All above service will be added by the Car Garage owner(CarGarageSystem class responsible)
* */
public class ServiceLists {
    private ArrayList<Service> services;
    //private Map<String,Number> serviceList;//{carWash,300}

    public ServiceLists() {
        //this.serviceList = new HashMap<>();
        this.services = new ArrayList<>();
        loadedServices();
    }

    public void loadedServices(){
        services.add(new Service("Car Wash",500));
        services.add(new Service("Oil Change",300));
        services.add(new Service("Car Panchar",100));
        services.add(new Service("Tyre replacement",3000));
        services.add(new Service("Ac filter",100));
    }
     public ArrayList<Service> getServices() {
        return services;
    }

//    public void addService(String name,Number price){
//        //serviceList.put(name,price);
//    }


    // you can used also HashMap
    //    public void displayService(){
    //        System.out.println(serviceList);//{Oil Change=3000,Car Wash=500}
    //
    //        //way to iteare HashMap in such format
    //        //{service: 'Oil Change', price: 300}
    //        for (Map.Entry<String, Number> entry : serviceList.entrySet()) {
    //            services.add(new Service(entry.getKey(),entry.getValue()));
    //            System.out.println("{service: '" + entry.getKey() + "', price: " + entry.getValue() + "}");
    //        }
    //
    //    }
}

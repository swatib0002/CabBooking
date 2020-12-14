package CabBooking.Dao;

import CabBooking.Exceptions.CreateException;
import CabBooking.models.CabDriver;
import CabBooking.models.Location;
import CabBooking.models.Ride;
import CabBooking.models.Rider;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDao {

    HashMap<String, CabDriver> driverHashMap = new HashMap<>();
    HashMap<String, Rider> riderHashMap = new HashMap<>();

    public CabDriver createDriver(String name, String mobileNo,String vehicleNo) throws CreateException {
       CabDriver driver = new CabDriver(name,mobileNo);
       if(driverHashMap.containsKey(vehicleNo)){
         throw new CreateException();
       }else{
           driverHashMap.put(vehicleNo,driver);
       }
       return driver;
    }

    public Rider createRider(String name, String mobileNo) throws CreateException {
        Rider rider = new Rider(name,mobileNo);
        if(riderHashMap.containsKey(mobileNo)){
            throw new CreateException();
        }else{
            riderHashMap.put(mobileNo,rider);
        }
        return rider;
    }

    public Rider getRider(String mobileNo){
        return riderHashMap.get(mobileNo);
    }

    public CabDriver getDriver(String vehicleNo){
        return driverHashMap.get(vehicleNo);
    }

    public List<CabDriver> getCabs(Location fromLocation){
        List<CabDriver> availabeCabs = new ArrayList<>();
        for(CabDriver cabDriver:driverHashMap.values()){
            if(cabDriver.getIsAvailable()){
              availabeCabs.add(cabDriver);
            }
        }
        return availabeCabs;
    }

}

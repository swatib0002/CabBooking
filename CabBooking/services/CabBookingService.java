package CabBooking.services;

import CabBooking.Dao.UserDao;
import CabBooking.Exceptions.NoCabAvailableException;
import CabBooking.models.*;
import java.util.*;

public class CabBookingService {

    UserDao userDao = new UserDao();
    private Map<String, List<Ride>> trips = new HashMap<>();
    Ride ride;

    public void createTrip(Location fromLocation, Location toLocation, Rider rider) throws NoCabAvailableException {
        List<CabDriver> nearByCabs = userDao.getCabs(fromLocation);
        if(nearByCabs == null)
            throw new NoCabAvailableException();
        final CabDriver selectedCab = nearByCabs.get(0);
        //price matching
        Double price = 0.0;
        Ride newRide = new Ride(fromLocation,toLocation,price,rider,selectedCab);
        if(!trips.containsKey(rider.getId())){
            trips.put(rider.getId(),new ArrayList<Ride>());
        }
        trips.get(rider.getId()).add(newRide);
        selectedCab.setCurrentRide(newRide);

    }

    public List<Ride> riderHistory(String riderId){
        return trips.get(riderId);
    }

    public void endTrip(String driverId){
       CabDriver cabDriver =  userDao.getDriver(driverId);
         cabDriver.setIsAvailable(true);
         ride.setRideStatus(RideStatus.FINISHED);
    }
}

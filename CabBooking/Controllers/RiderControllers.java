package CabBooking.Controllers;

import CabBooking.Dao.UserDao;
import CabBooking.Exceptions.CreateException;
import CabBooking.Exceptions.NoCabAvailableException;
import CabBooking.models.Location;
import CabBooking.models.Ride;
import CabBooking.models.Rider;
import CabBooking.services.CabBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RiderControllers {

    private UserDao userDao;

    private CabBookingService cabBookingService;

    @RequestMapping(value = "/register/rider", method = RequestMethod.POST)
    public ResponseEntity registerRider(final String riderMobileNo, final String riderName) throws CreateException {
        userDao.createRider(riderName,riderMobileNo);
        return ResponseEntity.ok("");
    }


    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public ResponseEntity book(
            final String riderMobileNo,
            final Double sourceX,
            final Double sourceY,
            final Double destX,
            final Double destY) throws NoCabAvailableException {
        cabBookingService.createTrip(new Location(sourceX,sourceY), new Location(destX,destY),userDao.getRider(riderMobileNo));
        return ResponseEntity.ok("");
    }

    @RequestMapping(value = "/getRides", method = RequestMethod.GET)
    public ResponseEntity fetchHistory(String riderId){
        List<Ride> rides =  cabBookingService.riderHistory(riderId);
        return ResponseEntity.ok(rides);
    }

}

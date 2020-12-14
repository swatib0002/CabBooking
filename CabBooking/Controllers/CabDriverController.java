package CabBooking.Controllers;

import CabBooking.Dao.UserDao;
import CabBooking.Exceptions.CreateException;
import CabBooking.services.CabBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class CabDriverController {

    private UserDao userDao;

    private CabBookingService cabBookingService;

    @RequestMapping(value = "/register/driver", method = RequestMethod.POST)
    public ResponseEntity registerDriver(final String driverMobileNo, final String driverName, final String vechicleNo) throws CreateException {
        userDao.createDriver(driverName,driverMobileNo,vechicleNo);
        return ResponseEntity.ok("");
    }

    public void endTrip(String vechicleNo){
       cabBookingService.endTrip(vechicleNo);
    }
}

package CabBooking.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ride {

    private Location fromLocation;
    private Location toLocation;
    private Double price;
    private Rider rider;
    private CabDriver driver;
    private RideStatus rideStatus;

    public Ride(Location fromLocation,Location toLocation, Double price, Rider rider, CabDriver driver){
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.price = price;
        this.rider = rider;
        this.driver = driver;
        this.rideStatus = RideStatus.IN_PROGRESS;
    }

    public void endTrip(){
       this.rideStatus = RideStatus.FINISHED;
    }

}

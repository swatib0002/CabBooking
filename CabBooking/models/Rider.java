package CabBooking.models;

import java.util.ArrayList;
import java.util.List;

public class Rider extends User {

    private Location location;
    private List<Ride> rides = new ArrayList<>();

    public Rider(String name, String mobileNo) {
        super(name, mobileNo);
        this.location = location;
    }

    public List<Ride> getRides() {
        return rides;
    }

    public void setRides(List<Ride> rides) {
        this.rides = rides;
    }

}

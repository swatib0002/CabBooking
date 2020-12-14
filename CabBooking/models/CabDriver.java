package CabBooking.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CabDriver extends User{
    private String vechicleNumber;

    @Setter
    private Location location;
    @Setter
    private Boolean isAvailable;
    @Setter
    private Ride currentRide;


    public CabDriver(String name,String mobileNo){
        super(name,mobileNo);
        isAvailable = true;
//        this.location = location;
    }

//    public boolean RiderAvailable(){
//        return isAvailable;
//    }
//
//    public void setIsAvailable(Boolean isAvailable){
//        this.isAvailable = isAvailable;
//    }

}

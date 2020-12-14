package CabBooking.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class User {

    String id;
    String name;
    String mobileNo;

    public User(String name,String mobileNo){
        this.name = name;
        this.mobileNo = mobileNo;
    }
}


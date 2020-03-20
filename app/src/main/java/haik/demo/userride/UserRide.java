package haik.demo.userride;

import haik.demo.ride.Ride;
import haik.demo.user.User;

import javax.persistence.*;


@Entity
@Table(name = "user_ride")
public class UserRide {

    @EmbeddedId
    UserRideId userRideId;

    @ManyToOne
    @MapsId("rideId")
    Ride ride;

    @ManyToOne
    @MapsId("userId")
    User user;

    public Ride getRide() {
        return ride;
    }

    public void setRide(Ride ride) {
        this.ride = ride;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

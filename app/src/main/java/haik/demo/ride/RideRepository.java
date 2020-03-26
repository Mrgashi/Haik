package haik.demo.ride;

import haik.demo.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RideRepository extends CrudRepository<Ride, Long> {

    Iterable<Ride> findAllBySeatsavailable(int seats);

    Optional<Ride> findById(Long id);

    Iterable<Ride> findAllByDriver(User driver);

//    Optional<Ride> findByRide_id(Optional<Ride> ride_id);



    @Query(nativeQuery = true, value = "select user.firstname,  ride.startdate , ride.starttime , ride.startlocation  , ride.destination, ride.comments, ride.seatsavailable from user join ride on ride.createdById = user.user_id ")
    Iterable<Ride> findAllRides();

//    Tror denne blir feil
    @Query(nativeQuery = true, value = "select ride.ride_id from ride join user on ride.createdbyid=user.user_id where ride.ride_id =?1")
   Optional<Ride> findFirstNameOfDriverOnSpesificRide(Optional<Ride> ride_id);


    Iterable<Ride> findAllByComments(String word);



}

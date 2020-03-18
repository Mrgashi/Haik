package haik.demo.ride;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface RideRepository extends CrudRepository<Ride, Long> {

}

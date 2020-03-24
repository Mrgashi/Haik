package haik.demo.ride;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RideRepository extends CrudRepository<Ride, Long> {

    Iterable<Ride> findAllByCreatedbyid(Long id);

    Iterable<Ride> findAllBySeatsavailable(int seats);

    Optional<Ride> findById(Long id);




}

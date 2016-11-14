package pl.bskorka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import pl.bskorka.model.Reservation;

/**
 * Created by sages on 14.11.16.
 */

@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

    @RestResource(path = "by-name", rel = "find-by-name")
    Reservation findByName(@Param("name") String name);

}

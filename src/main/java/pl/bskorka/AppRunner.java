package pl.bskorka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pl.bskorka.model.Reservation;
import pl.bskorka.repository.ReservationRepository;

import java.util.Arrays;
import java.util.List;

/**
 * Created by sages on 14.11.16.
 */
@Component
public class AppRunner implements ApplicationRunner {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        reservationRepository.deleteAll();
        List<Reservation> reservations = Arrays.asList(new Reservation(null, "Bartek"), new Reservation(null, "John"));
        reservationRepository.save(reservations);

    }

}

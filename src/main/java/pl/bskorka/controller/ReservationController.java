package pl.bskorka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.bskorka.model.Reservation;
import pl.bskorka.repository.ReservationRepository;

import java.net.URI;
import java.util.List;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.http.ResponseEntity.*;

/**
 * Created by sages on 14.11.16.
 */
@Slf4j
@RestController
@RequestMapping("/custom-reservations")
public class ReservationController {

    @Autowired
    ReservationRepository reservations;

    @GetMapping
    public List<Reservation> getReservations() {
        return reservations.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{name}")
    public ResponseEntity<?> findOne(@PathVariable("name") String name) {
        Reservation reservation = reservations.findByName(name);
        if(reservation != null)
            return ok(reservation);
        else
            return notFound().build();
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody Reservation reservation) {
        if (reservations.exists(Example.of(reservation))) {
            return status(HttpStatus.CONFLICT).build();
        }
        reservations.save(reservation);
        return created(selfUri(reservation)).build();
    }

    private URI selfUri(@RequestBody Reservation reservation) {
        return linkTo(
                methodOn(ReservationController.class).findOne(reservation.getName()))
                .toUri();
    }

}

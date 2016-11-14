package pl.bskorka;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;
import org.springframework.stereotype.Component;
import pl.bskorka.model.Reservation;

import static java.lang.String.format;

/**
 * Created by sages on 14.11.16.
 */
@Component
public class ReservationResourceProcessor implements ResourceProcessor<Resource<Reservation>> {

    @Override
    public Resource<Reservation> process(Resource<Reservation> resource) {
        Reservation reservation = resource.getContent();
        String url = format("https://www.google.pl/search?tbm=isch&q=%s",
                reservation.getName());
        resource.add(new Link(url, "photo"));
        return resource;
    }
}
package pl.bskorka;

import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * Created by sages on 14.11.16.
 */
@Component
public class MyHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        return Health.status("Great health").build();
    }
}

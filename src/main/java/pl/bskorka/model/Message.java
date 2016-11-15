package pl.bskorka.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by sages on 15.11.16.
 */
@ConfigurationProperties
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {

    String message;

}

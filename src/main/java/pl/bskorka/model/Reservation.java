package pl.bskorka.model;

import lombok.*;

import javax.persistence.*;

/**
 * Created by sages on 14.11.16.
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@ToString
@Table(uniqueConstraints = {
        @UniqueConstraint(columnNames = "name")
})
public class Reservation {

    @Id
    @GeneratedValue
    private Integer id;

    @Getter
    @Setter
    private String name;

}

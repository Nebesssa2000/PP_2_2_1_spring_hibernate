package hiber.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@FieldDefaults(makeFinal = false,level = AccessLevel.PRIVATE)
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "car_id")
    Long id;

    @Column(name = "model")
    String model;

    @Column(name = "series")
    int series;
}

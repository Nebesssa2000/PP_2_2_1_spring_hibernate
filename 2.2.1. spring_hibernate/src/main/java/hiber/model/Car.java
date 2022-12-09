package hiber.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
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

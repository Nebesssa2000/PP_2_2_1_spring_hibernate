package hiber.model;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;

@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "model")
    String model;

    @Column(name = "series")
    int series;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "usercar", fetch = FetchType.LAZY)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    User user;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    @Override
    public String toString() {
        return "" + model + " "+ series ;
    }
}

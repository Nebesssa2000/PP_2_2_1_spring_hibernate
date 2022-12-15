package hiber.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.io.Serializable;

@Setter
@Getter
@ToString
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@Table(name = "cars")
public class Car implements Serializable {
    static long serialVersionUID = 1L;
    @Id
    @Column(name = "id",nullable = false)
    Long id;

    @Column(name = "model")
    String model;

    @Column(name = "series")
    int series;

    @MapsId
    @OneToOne(optional = false)
    User user;

    public Car(String model, int series) {
        this.model = model;
        this.series = series;
    }
}

package hiber.service;

import hiber.dao.CarDao;
import hiber.model.Car;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Service
public class CarServiceImp implements CarService {

    CarDao carDao;

    @Autowired
    public CarServiceImp(CarDao carDao) {
        this.carDao = carDao;
    }

    @Transactional
    @Override
    public void add(Car car) {
        carDao.add(car);
    }
}

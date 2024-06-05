package com.cuong.springbootdemo.service;
import com.cuong.springbootdemo.model.Vehicle;
import com.cuong.springbootdemo.model.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VehicleService {
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(long id);
    Vehicle saveVehicle(Vehicle vehicle);
    Vehicle updateVehicle(Vehicle vehicle, long id);
    void deleteVehicle(long id);
}

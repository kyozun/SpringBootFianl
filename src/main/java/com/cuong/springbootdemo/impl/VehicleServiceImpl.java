package com.cuong.springbootdemo.impl;

import com.cuong.springbootdemo.model.Vehicle;
import com.cuong.springbootdemo.model.Vehicle;
import com.cuong.springbootdemo.repository.VehicleRepository;
import com.cuong.springbootdemo.service.VehicleService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        super();
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public Vehicle saveVehicle(Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

    @Override
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @Override
    public Vehicle getVehicleById(long id) {
        return vehicleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found"));
    }

    @Override
    public Vehicle updateVehicle(Vehicle vehicle, long id) {
        // we need to check whether vehicle with given id is exist in DB or not
        Vehicle existingVehicle = vehicleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found"));

        existingVehicle.setVehicle_name(vehicle.getVehicle_name());
        existingVehicle.setVehicle_color(vehicle.getVehicle_color());
        existingVehicle.setVehicle_model(vehicle.getVehicle_model());
        existingVehicle.setYear_of_manufacture(vehicle.getYear_of_manufacture());
        // save existing vehicle to DB
        vehicleRepository.save(existingVehicle);
        return existingVehicle;
    }

    @Override
    public void deleteVehicle(long id) {
        // check whether a vehicle exist in a DB or not
        vehicleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found"));
        vehicleRepository.deleteById(id);
    }
}

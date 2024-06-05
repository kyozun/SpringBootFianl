package com.cuong.springbootdemo.controller;

import com.cuong.springbootdemo.model.Vehicle;
import com.cuong.springbootdemo.service.VehicleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VehicleController {
    private final VehicleService vehicleService;

    public VehicleController(VehicleService vehicleService) {
        super();
        this.vehicleService = vehicleService;
    }


    // List all vehicles
    @GetMapping("/vehicles")
    public String getAllVehicles(Model model) {
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "vehicles";
    }

    // Create 1
    @GetMapping("/vehicles/new")
    public String createVehicleForm(Model model) {
        // create vehicle object to hold vehicle form data
        Vehicle vehicle = new Vehicle();
        model.addAttribute("vehicle", vehicle);
        return "create_vehicle";
    }

    // Add 1
    @PostMapping("/vehicles")
    public String saveVehicle(@ModelAttribute("vehicle") Vehicle vehicle) {
        vehicleService.saveVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/vehicles/edit/{id}")
    public String editVehicleForm(@PathVariable Long id, Model model) {
        model.addAttribute("Vehicle", vehicleService.getVehicleById(id));
        return "edit_Vehicle";
    }

    @PostMapping("/vehicles/{id}")
    public String updateVehicle(@PathVariable Long id, @ModelAttribute("Vehicle") Vehicle Vehicle, Model model) {
        // get Vehicle from database by id
        Vehicle existingVehicle = vehicleService.getVehicleById(id);
        existingVehicle.setId(id);
        existingVehicle.setVehicle_id(Vehicle.getVehicle_id());
        existingVehicle.setVehicle_color(Vehicle.getVehicle_color());
        existingVehicle.setVehicle_name(Vehicle.getVehicle_name());
        existingVehicle.setVehicle_model(Vehicle.getVehicle_model());
        existingVehicle.setYear_of_manufacture(Vehicle.getYear_of_manufacture());


        // save updated Vehicle object
        vehicleService.updateVehicle(existingVehicle, id);
        return "redirect:/vehicles";
    }

    // handler method to handle delete Vehicle request

    @GetMapping("/vehicles/{id}")
    public String deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicles";
    }
}

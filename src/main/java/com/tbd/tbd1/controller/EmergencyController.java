package com.tbd.tbd1.controller;

import com.tbd.tbd1.model.Emergency;
import com.tbd.tbd1.repository.EmergencyRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmergencyController {

    @Autowired
    private EmergencyRepositoryImp emergencyRepositoryImp;

    @PostMapping("/emergency/new")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public int saveEmergency(@RequestBody Emergency emergency) {
        int newId = this.emergencyRepositoryImp.saveEmergency(emergency);
        return newId;
    }

    @GetMapping("/emergency/{id}")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public Emergency getEmergencyById(@PathVariable("id") int id) {
        Emergency emergency = this.emergencyRepositoryImp.getEmergencyById(id);
        return emergency;
    }

    @GetMapping("/emergency/all")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public List<Emergency> getEmergencies() {
        List<Emergency> emergencies = this.emergencyRepositoryImp.getAllEmergencies();
        return emergencies;
    }

    @GetMapping("/emergency/update")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public int updateEmergency(@RequestBody Emergency emergency) {
        int id = this.emergencyRepositoryImp.updateEmergency(emergency);
        return id;
    }
}
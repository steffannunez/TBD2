package com.tbd.tbd1.controller;

import com.tbd.tbd1.model.Volunteer;
import com.tbd.tbd1.repository.VolunteerRepository;
import com.tbd.tbd1.repository.VolunteerRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class VolunteerController {

    @Autowired
    private VolunteerRepositoryImp volunteerRepositoryImp;
    @Autowired
    private TaskController taskController;

    @PostMapping("/volunteer/new")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public int saveVolunteer(@RequestBody Volunteer volunteer){
        return this.volunteerRepositoryImp.saveVolunteer(volunteer);

    }

    @GetMapping("/volunteer/{id}")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public Volunteer saveVolunteer(@PathVariable("id") int id){
        return this.volunteerRepositoryImp.getVolunteerById(id);
    }

    @GetMapping("/volunteer/all")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public List<Volunteer> getVolunteers(){
        List<Volunteer> volunteers = this.volunteerRepositoryImp.getAllVolunteers();
        return volunteers;
    }

    @GetMapping("/volunteer/update")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public int updateVolunteer(@RequestBody Volunteer volunteer) {
        int id = this.volunteerRepositoryImp.updateVolunteer(volunteer);
        return id;
    }


    @PostMapping("/volunteer/addSkill/{idVolunteer}/{idSkill}")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public int setSkill( @PathVariable("idVolunteer") int idVolunteer, @PathVariable("idSkill")  int idSkill) {
        return this.volunteerRepositoryImp.setSkill(idVolunteer, idSkill);
    }

    @PostMapping("/volunteer/bySkill/{idSkill}")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public List<Volunteer> getVolunteersBySkill( @PathVariable("idSkill")  int idSkill) {
        List<Integer> ids = this.volunteerRepositoryImp.getBySkill(idSkill);
        List<Volunteer> volunteers = this.volunteerRepositoryImp.getVolunteers(ids);
        return volunteers;
    }

    @GetMapping("/volunteer/byEmergency/{idEmergency}")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public List<Volunteer> getVolunteersByEmergency( @PathVariable("idEmergency")  int idEmergency) {
        List<Integer> taskIds = this.taskController.getTasksByEmergency(idEmergency);
        //Para cada idtask, debo ir al ranking y pedir los voluntarios asociados
        List<Integer> idVolunteers = new ArrayList<>();
        for (int idTask : taskIds){
            idVolunteers.addAll(this.volunteerRepositoryImp.getVolunteersByTask(idTask));
        }

        for (int idVolunteer : idVolunteers){
            System.out.println(idVolunteer);
        }
        List<Volunteer> volunteers = this.volunteerRepositoryImp.getVolunteers(idVolunteers);
        return volunteers;
    }

}

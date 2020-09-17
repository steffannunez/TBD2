package com.tbd.tbd1.controller;

import com.tbd.tbd1.model.Skill;
import com.tbd.tbd1.model.Task;
import com.tbd.tbd1.repository.TaskRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    private TaskRepositoryImp taskRepositoryImp;

    @PostMapping("/task/new")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public int saveSkill(@RequestBody Task task){
        int newId = this.taskRepositoryImp.saveTask(task);
        return newId;
    }

    @GetMapping("/task/{id}")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public Task saveSkill(@PathVariable("id") int id){
        Task task = this.taskRepositoryImp.getTaskById(id);
        return task;
    }

    @GetMapping("/task/all")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public List<Task> getTasks() {
        List<Task> tasks = this.taskRepositoryImp.getAllTasks();
        return tasks;
    }


    public List<Integer> getTasksByEmergency(int idEmergency) {
        return this.taskRepositoryImp.getTasksByEmergency(idEmergency);
    }


    public void addEnrolledVolunteer(int id_task) {
        this.taskRepositoryImp.updateEnrolledVolunteer(id_task);
    }
}

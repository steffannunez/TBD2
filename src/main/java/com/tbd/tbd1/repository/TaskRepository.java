package com.tbd.tbd1.repository;

import com.tbd.tbd1.model.Skill;
import com.tbd.tbd1.model.Task;

import java.util.List;

public interface TaskRepository {
    public List<Integer> getTasksByEmergency(int idEmergency);

    List<Task> getAllTasks();

    Task getTaskById(int id);

    int saveTask(Task task);

    void updateEnrolledVolunteer(int id_task);
}

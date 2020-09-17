package com.tbd.tbd1.repository;


import com.tbd.tbd1.model.Emergency;
import com.tbd.tbd1.model.Skill;
import com.tbd.tbd1.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class TaskRepositoryImp implements TaskRepository {

    @Autowired
    private Sql2o sql2o;

    @Override
    public List<Task> getAllTasks() {
        String sql = "SELECT * FROM tasks";
        try (Connection connection = sql2o.open()){
            List<Task> tasks = connection.createQuery(sql).executeAndFetch(Task.class);
            return tasks;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public Task getTaskById(int id) {
        try (Connection connection = sql2o.open()){
            Task task = connection.createQuery("SELECT * FROM tasks WHERE id = "+id).executeAndFetchFirst(Task.class);
            return task;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public int saveTask(Task task) {
        String sql = "INSERT INTO tasks(name, description, req_volunteers, enrolled_volunteers, id_emergency, startdate, enddate, id_status) " +
                "VALUES (:name, :desc, :req_vol, :enrolled_vol, :id_emergency, :startdate, :enddate, :id_status)";
        try (Connection connection = sql2o.open()){
            int newId = (int) connection.createQuery(sql, true)
                    .addParameter("name", task.getName())
                    .addParameter("desc", task.getDescription())
                    .addParameter("req_vol", task.getReq_volunteers())
                    .addParameter("enrolled_vol", task.getEnrolled_volunteers())
                    .addParameter("id_emergency", task.getId_emergency())
                    .addParameter("startdate", task.getStartDate())
                    .addParameter("enddate", task.getEndDate())
                    .addParameter("id_status", task.getId_status())
                    .executeUpdate().getKey();
            task.setId(newId);
            return newId;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return 0;
        }
    }

    @Override
    public void updateEnrolledVolunteer(int id_task) {
        try (Connection connection = sql2o.open()){

            int enrolledVolunteers = connection.createQuery("SELECT enrolled_volunteers FROM tasks WHERE id = "+id_task).executeScalar(Integer.class);
            enrolledVolunteers = enrolledVolunteers + 1;
            connection.createQuery("UPDATE tasks SET enrolled_volunteers = :enrolled_volunteers "
                    + "WHERE id_task = :id")
                    .addParameter("enrolled_volunteers", enrolledVolunteers)
                    .addParameter("id", id_task);
            connection.createQuery("CALL public.close_full_tasks()").executeUpdate();

        }catch(Exception exception){
            System.out.println(exception.getMessage());
        }

    }


    public List<Integer> getTasksByEmergency(int idEmergency) {

        String sql = "SELECT id FROM tasks WHERE id_emergency = "+idEmergency;
        try (Connection connection = sql2o.open()){
            List<Integer> idTasks = connection.createQuery(sql).executeScalarList(int.class);
            return idTasks;
        }catch(Exception exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
}

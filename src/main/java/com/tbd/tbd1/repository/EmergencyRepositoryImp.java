package com.tbd.tbd1.repository;

import com.tbd.tbd1.model.Emergency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class EmergencyRepositoryImp implements EmergencyRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int saveEmergency(Emergency emergency){
        System.out.println("es :"+emergency.getName());
        String sql = "INSERT INTO emergencies(name, description, startDate, endDate, idInstitution) " +
                "VALUES (:name, :desc, :start, :end, :idInstitution)";
        try (Connection connection = sql2o.open()){
            int newId = (int) connection.createQuery(sql, true)
                    .addParameter("name", emergency.getName())
                    .addParameter("desc", emergency.getDescription())
                    .addParameter("start", emergency.getStartDate())
                    .addParameter("end", emergency.getEndDate())
                    .addParameter("idInstitution", emergency.getIdInstitution())
                    .executeUpdate().getKey();
            emergency.setIdEmergency(newId);
            return newId;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return 0;
        }
    }

    @Override
    public boolean deleteEmergency(Emergency emergency){ return false; }

    @Override
    public Emergency getEmergencyById(int id){
        Emergency emergency = new Emergency();
        try (Connection connection = sql2o.open()){
            String name = connection.createQuery("SELECT name FROM emergencies WHERE id = "+id).executeScalar(String.class);
            String description = connection.createQuery("SELECT description FROM emergencies WHERE id = "+id).executeScalar(String.class);
            String startDate = connection.createQuery("SELECT startDate FROM emergencies WHERE id = "+id).executeScalar(String.class);
            String endDate = connection.createQuery("SELECT endDate FROM emergencies WHERE id = "+id).executeScalar(String.class);
            int institution = connection.createQuery("SELECT idInstitution FROM emergencies WHERE id = "+id).executeScalar(Integer.class);
            if (name != null){
                emergency.setIdEmergency(id);
                emergency.setName(name);
                emergency.setDescription(description);
                emergency.setStartDate(startDate);
                emergency.setEndDate(endDate);
                emergency.setIdInstitution(institution);
                return emergency;
            }
            return null;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public int updateEmergency(Emergency emergency){
        String sql = "UPDATE emergencies " +
                "SET emergency_name = :name, description = :desc, startdate = :start, enddate = :end, idInstitution = :inst" +
                "WHERE id_emergency = :id";
        try (Connection connection = sql2o.open()){
            connection.createQuery(sql)
                    .addParameter("name", emergency.getName())
                    .addParameter("desc", emergency.getDescription())
                    .addParameter("start", emergency.getStartDate())
                    .addParameter("end", emergency.getEndDate())
                    .addParameter("inst", emergency.getIdInstitution())
                    .addParameter("id", emergency.getIdEmergency());
            return emergency.getIdEmergency();
        }catch(Exception exception) {
            System.out.println(exception.getMessage());
            return 0;
        }
    }

    @Override
    public List<Emergency> getAllEmergencies() {
        String sql = "SELECT * FROM emergencies";
        try (Connection connection = sql2o.open()){
            List<Emergency> emergencies = connection.createQuery(sql).executeAndFetch(Emergency.class);
            return emergencies;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
}

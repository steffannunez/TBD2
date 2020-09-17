package com.tbd.tbd1.repository;

import com.tbd.tbd1.model.Skill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Sql2o;
import org.sql2o.Connection;

import java.util.List;

@Repository
public class SkillRepositoryImp implements SkillRepository{

    @Autowired
    private Sql2o sql2o;

    @Override
    public int saveSkill(Skill skill){
        System.out.println(skill.getDescription());
        try (Connection connection = sql2o.open()){
            int newId = (int) connection.createQuery("INSERT INTO skills(description) VALUES (:description)", true)
                    .addParameter("description", skill.getDescription())
                    .executeUpdate().getKey();
            skill.setIdSkill(newId);
            return newId;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return 0;
        }
    }

    @Override
    public boolean deleteSkill(Skill skill) { return false; }

    @Override
    public Skill getSkillById(int id){
        String sql = "SELECT description FROM skills WHERE id = "+id;
        Skill skill = new Skill();
        try (Connection connection = sql2o.open()){
            String description = connection.createQuery(sql).executeScalar(String.class);
            if (description != null){
                skill.setIdSkill(id);
                skill.setDescription(description);
                return skill;
            }
            return null;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public int updateSkill(Skill skill) {
        try (Connection connection = sql2o.open()){
            connection.createQuery("UPDATE skills SET description = :description "
                    + "WHERE id_skill = :id")
                    .addParameter("description", skill.getDescription())
                    .addParameter("id", skill.getIdSkill())
                    .executeUpdate();
            return skill.getIdSkill();
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return 0;
        }
    }

    @Override
    public List<Skill> getAllSkills(){
        String sql = "SELECT * FROM skills";
        try (Connection connection = sql2o.open()){
            List<Skill> skills = connection.createQuery(sql).executeAndFetch(Skill.class);
            return skills;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    public int hashSkill(List<Skill> skills){
        for(Skill skill : skills){
            int priority= skill.getPriority();
            if(priority%3 == 0){
                try (Connection connection = sql2o.open()){
                    int newId = (int) connection.createQuery("INSERT INTO skill1(id, description ,priority) VALUES (:id_skill, :description, :priority)",
                            true)
                            .addParameter("id_skill", skill.getIdSkill())
                            .addParameter("description", skill.getDescription())
                            .addParameter("priority", skill.getPriority())
                            .executeUpdate().getKey();
                    return newId;
                }catch(Exception exception){
                    System.out.println(exception.getMessage());
                    return 0;
                }
            }

            if(priority%3 == 1){
                try (Connection connection = sql2o.open()){
                    int newId = (int) connection.createQuery("INSERT INTO skill2(id, description ,priority) VALUES (:id_skill, :description, :priority)",
                            true)
                            .addParameter("id_skill", skill.getIdSkill())
                            .addParameter("description", skill.getDescription())
                            .addParameter("priority", skill.getPriority())
                            .executeUpdate().getKey();
                    return newId;
                }catch(Exception exception){
                    System.out.println(exception.getMessage());
                    return 0;
                }

            }

            if(priority%3 == 2){
                try (Connection connection = sql2o.open()){
                    int newId = (int) connection.createQuery("INSERT INTO skill3(id, description ,priority) VALUES (:id_skill, :description, :priority)",
                            true)
                            .addParameter("id_skill", skill.getIdSkill())
                            .addParameter("description", skill.getDescription())
                            .addParameter("priority", skill.getPriority())
                            .executeUpdate().getKey();
                    return newId;
                }catch(Exception exception){
                    System.out.println(exception.getMessage());
                    return 0;
                }
            }
        }
        return 0;
    }
}

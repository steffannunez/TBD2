package com.tbd.tbd1.repository;

import com.tbd.tbd1.model.Skill;

import java.util.List;

public interface SkillRepository {
    int saveSkill(Skill skill);
    boolean deleteSkill(Skill skill);
    Skill getSkillById(int id);
    int updateSkill(Skill skill);
    List<Skill> getAllSkills();
    int hashSkill(List<Skill> skills);
}

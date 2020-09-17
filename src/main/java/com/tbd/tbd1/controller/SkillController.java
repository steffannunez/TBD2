package com.tbd.tbd1.controller;

import com.tbd.tbd1.model.Skill;
import com.tbd.tbd1.repository.SkillRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SkillController {

    @Autowired
    private SkillRepositoryImp skillRepositoryImp;

    @PostMapping("/skill/new")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public int saveSkill(@RequestBody Skill skill){
        int newId = this.skillRepositoryImp.saveSkill(skill);
        return newId;
    }

    @GetMapping("/skill/{id}")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public Skill saveSkill(@PathVariable("id") int id){
        Skill skill = this.skillRepositoryImp.getSkillById(id);
        return skill;
    }

    @GetMapping("/skill/all")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public List<Skill> getSkills() {
        List<Skill> skills = this.skillRepositoryImp.getAllSkills();
        return skills;
    }

    @GetMapping("/skill/update")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public int updateSkill(@RequestBody Skill skill){
        int id = this.skillRepositoryImp.updateSkill(skill);
        return id;
    }

}

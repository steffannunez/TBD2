package com.tbd.tbd1.controller;


import com.tbd.tbd1.model.Ranking;
import com.tbd.tbd1.model.Task;
import com.tbd.tbd1.repository.RankingRepositoryImp;
import com.tbd.tbd1.repository.TaskRepositoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RankingController {

    @Autowired
    private RankingRepositoryImp rankingRepositoryImp;
    @Autowired
    private TaskController taskController;


    @PostMapping("/ranking/new")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public int saveSkill(@RequestBody Ranking ranking){
        int newId = this.rankingRepositoryImp.saveRanking(ranking);
        if (ranking.isFlg_joins()){
            this.taskController.addEnrolledVolunteer(ranking.getId_task());
        }
        return newId;
    }

    @GetMapping("/ranking/{id}")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public Ranking saveSkill(@PathVariable("id") int id){
        Ranking ranking = this.rankingRepositoryImp.getRankingById(id);
        return ranking;
    }

    @GetMapping("/ranking/all")
    @CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
    public List<Ranking> getTasks() {
        List<Ranking> ranking = this.rankingRepositoryImp.getAllRankings();
        return ranking;
    }





}

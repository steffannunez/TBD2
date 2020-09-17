package com.tbd.tbd1.repository;

import com.tbd.tbd1.model.Ranking;
import com.tbd.tbd1.model.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

@Repository
public class RankingRepositoryImp implements RankingRepository{

    @Autowired
    private Sql2o sql2o;

    public int saveRanking(Ranking ranking) {
        String sql = "INSERT INTO rankings(id_volunteer, id_task, score, flg_invited, flg_joins) " +
                "VALUES (:id_volunteer, :id_task, :score, :flg_invited, :flg_joins)";
        try (Connection connection = sql2o.open()){
            int newId = (int) connection.createQuery(sql, true)
                    .addParameter("id_volunteer", ranking.getId_volunteer())
                    .addParameter("id_task", ranking.getId_task())
                    .addParameter("score", ranking.getScore())
                    .addParameter("flg_invited", ranking.isFlg_invited())
                    .addParameter("flg_joins", ranking.isFlg_joins())
                    .executeUpdate().getKey();
            ranking.setId(newId);
            return newId;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return 0;
        }
    }



    @Override
    public Ranking getRankingById(int id) {
        try (Connection connection = sql2o.open()){
            Ranking ranking = connection.createQuery("SELECT * FROM rankings WHERE id = "+id).executeAndFetchFirst(Ranking.class);
            return ranking;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }

    @Override
    public List<Ranking> getAllRankings() {
        String sql = "SELECT * FROM rankings";
        try (Connection connection = sql2o.open()){
            List<Ranking> rankings = connection.createQuery(sql).executeAndFetch(Ranking.class);
            return rankings;
        }catch(Exception exception){
            System.out.println(exception.getMessage());
            return null;
        }
    }
}

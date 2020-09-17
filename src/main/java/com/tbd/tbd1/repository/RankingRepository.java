package com.tbd.tbd1.repository;

import com.tbd.tbd1.model.Ranking;

import java.util.List;

public interface RankingRepository {

    int saveRanking(Ranking ranking);
    Ranking getRankingById(int id);

    List<Ranking> getAllRankings();
}

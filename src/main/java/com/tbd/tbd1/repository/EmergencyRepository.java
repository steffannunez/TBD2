package com.tbd.tbd1.repository;

import com.tbd.tbd1.model.Emergency;

import java.util.List;

public interface EmergencyRepository {
    int saveEmergency(Emergency emergency);
    boolean deleteEmergency(Emergency emergency);
    Emergency getEmergencyById(int id);
    int updateEmergency(Emergency emergency);
    List<Emergency> getAllEmergencies();
}
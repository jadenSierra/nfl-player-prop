package com.project.nflplayerprop.repository.RunningBackRepository;

import com.project.nflplayerprop.model.RunningBackModel.RunningBackEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RunningBackRepo extends JpaRepository <RunningBackEntity, Long> {
    boolean existsByName(String name);
}

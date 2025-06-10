package com.project.nflplayerprop.service.RunningBackService;

import com.project.nflplayerprop.model.RunningBackModel.RunningBackEntity;
import com.project.nflplayerprop.repository.RunningBackRepository.RunningBackRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RunningBackService {
    private final RunningBackRepo runningBackRepo;

    public RunningBackService(RunningBackRepo runningBackRepo){
        this.runningBackRepo = runningBackRepo;
    }

    public List<RunningBackEntity> getAllRunningBacks(){
        return runningBackRepo.findAll();
    }


    public Optional<RunningBackEntity> getRunningBackById(Long id) {
        return runningBackRepo.findById(id);
    }

    public RunningBackEntity createRunningBack(RunningBackEntity runningBack) {
        return runningBackRepo.save(runningBack);
    }

    public Optional<RunningBackEntity> updateRunningBack(Long id, RunningBackEntity updatedRunningBack) {
        return runningBackRepo.findById(id).map(runningBack -> {
            runningBack.setName(updatedRunningBack.getName());
            runningBack.setTeam(updatedRunningBack.getTeam());
            runningBack.setNumber(updatedRunningBack.getNumber());
            return runningBackRepo.save(runningBack);
        });
    }

    public void deleteRunningBack(Long id) {
        runningBackRepo.deleteById(id);
    }
}

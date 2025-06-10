package com.project.nflplayerprop.controller.RunningBackController;

import com.project.nflplayerprop.model.RunningBackModel.RunningBackEntity;
import com.project.nflplayerprop.service.RunningBackService.RunningBackService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/runningBack")
public class RunningBackController {

    private final RunningBackService runningBackService;

    public RunningBackController(RunningBackService runningBackService) {
        this.runningBackService = runningBackService;
    }

    @GetMapping
    public List<RunningBackEntity> getAllUsers() {
        return runningBackService.getAllRunningBacks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RunningBackEntity> getUserById(@PathVariable Long id) {
        return runningBackService.getRunningBackById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public RunningBackEntity createRunningBack(@RequestBody RunningBackEntity runningBack) {
        return runningBackService.createRunningBack(runningBack);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RunningBackEntity> updateUser(@PathVariable Long id, @RequestBody RunningBackEntity updatedRunningBack) {
        return runningBackService.updateRunningBack(id, updatedRunningBack)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        runningBackService.deleteRunningBack(id);
        return ResponseEntity.noContent().build();
    }
}

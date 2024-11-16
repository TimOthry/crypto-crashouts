package cc.hackathon.shef.uk.cryptocrashouts.service;

import cc.hackathon.shef.uk.cryptocrashouts.repository.CompletedBattleRepository;
import org.springframework.stereotype.Service;

@Service
public class CompletedBattleService {
    private final CompletedBattleRepository completedBattleRepository;

    public CompletedBattleService(CompletedBattleRepository completedBattleRepository) {
        this.completedBattleRepository = completedBattleRepository;
    }
}

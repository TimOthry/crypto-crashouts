package cc.hackathon.shef.uk.cryptocrashouts.service;

import cc.hackathon.shef.uk.cryptocrashouts.models.CompletedBattle;
import cc.hackathon.shef.uk.cryptocrashouts.repository.CompletedBattleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompletedBattleService {
    private final CompletedBattleRepository completedBattleRepository;

    public CompletedBattleService(CompletedBattleRepository completedBattleRepository) {
        this.completedBattleRepository = completedBattleRepository;
    }

    public CompletedBattle findById(long id) {
        return completedBattleRepository.findById(id).orElse(null);
    }

    public CompletedBattle save(CompletedBattle completedBattle) {
        return completedBattleRepository.save(completedBattle);
    }

    public CompletedBattle findByPlayer2Id(long playerId) {
        return completedBattleRepository.findByPlayer2Id(playerId);
    }
}

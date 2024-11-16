package cc.hackathon.shef.uk.cryptocrashouts.service;

import cc.hackathon.shef.uk.cryptocrashouts.models.BattleQue;
import cc.hackathon.shef.uk.cryptocrashouts.repository.BattleQueRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BattleQueService {
    private final BattleQueRepository battleQueRepository;

    public BattleQueService(BattleQueRepository battleQueRepository) {
        this.battleQueRepository = battleQueRepository;
    }

    public BattleQue addToQueue(BattleQue battleQue) {
        return battleQueRepository.save(battleQue);
    }

    public List<BattleQue> getQueue() {
        return battleQueRepository.findAll();
    }

    public BattleQue findById(Long id) {
        return battleQueRepository.findById(id).orElse(null);
    }

    public void removeFromQueue(BattleQue battleQue) {
        battleQueRepository.delete(battleQue);
    }
}

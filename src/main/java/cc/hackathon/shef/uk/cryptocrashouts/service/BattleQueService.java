package cc.hackathon.shef.uk.cryptocrashouts.service;

import cc.hackathon.shef.uk.cryptocrashouts.repository.BattleQueRepository;
import org.springframework.stereotype.Service;

@Service
public class BattleQueService {
    private final BattleQueRepository battleQueRepository;

    public BattleQueService(BattleQueRepository battleQueRepository) {
        this.battleQueRepository = battleQueRepository;
    }
}

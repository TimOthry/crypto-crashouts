package cc.hackathon.shef.uk.cryptocrashouts.service;

import cc.hackathon.shef.uk.cryptocrashouts.models.Player;
import cc.hackathon.shef.uk.cryptocrashouts.repository.PlayerRepository;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Player getPlayerById(Long id) {
        return playerRepository.findById(id).orElse(null);
    }

    public Player save(Player player) {
        return playerRepository.save(player);
    }
}

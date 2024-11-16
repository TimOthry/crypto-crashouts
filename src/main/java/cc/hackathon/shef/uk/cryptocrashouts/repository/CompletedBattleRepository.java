package cc.hackathon.shef.uk.cryptocrashouts.repository;

import cc.hackathon.shef.uk.cryptocrashouts.models.CompletedBattle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedBattleRepository extends JpaRepository<CompletedBattle, Long> {

    public CompletedBattle findByPlayer2Id (long player2Id);

    public CompletedBattle findByPlayer1Id (long player1Id);
}

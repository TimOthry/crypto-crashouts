package cc.hackathon.shef.uk.cryptocrashouts.repository;

import cc.hackathon.shef.uk.cryptocrashouts.models.CompletedBattle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedBattleRepository extends JpaRepository<CompletedBattle, Long> {
}

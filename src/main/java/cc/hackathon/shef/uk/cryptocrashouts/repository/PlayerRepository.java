package cc.hackathon.shef.uk.cryptocrashouts.repository;

import cc.hackathon.shef.uk.cryptocrashouts.models.Player;
import org.springframework.data.repository.CrudRepository;

public interface PlayerRepository extends CrudRepository<Player, Long> {
}

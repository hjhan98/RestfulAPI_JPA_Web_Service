package syscon.restapijpaservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import syscon.restapijpaservice.domain.RobotMaster;

import java.util.Optional;

public interface RobotRepository extends JpaRepository<RobotMaster,String> {
    RobotMaster findFirstById(String id);
}

package adamd.javaarchdemo.port;

import adamd.javaarchdemo.port.model.Cat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatsRepository extends JpaRepository<Cat, Long> {
    
}

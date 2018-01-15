package adamd.javaarchdemo.domain;

import adamd.javaarchdemo.port.CatsRepository;
import adamd.javaarchdemo.port.model.Cat;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class CatController {
    
    @Autowired
    private CatsRepository catsRepository;
    
    @GetMapping("/cats")
    public List<Cat> getCats() {
        log.info("Getting those kitties!");
        return catsRepository.findAll();
    }
}

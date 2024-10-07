package Project.Backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class MyService {
    
    @Autowired
    private MyRepository repository;
    
    public List<MyEntity> getAllEntities() {
        return repository.findAll();
    }

    public MyEntity addEntity(MyEntity entity) {
        return repository.save(entity);
    }

    public MyEntity getEntityById(Long id) {
        return repository.findById(id).orElse(null);
    }
}
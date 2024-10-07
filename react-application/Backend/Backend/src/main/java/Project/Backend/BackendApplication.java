package Project.Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.http.ResponseEntity;

import Project.Backend.MyEntity;
import Project.Backend.MyRepository;
import Project.Backend.MyService;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import org.springframework.web.bind.annotation.RequestParam;


@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		System.out.println("Hello, World!");

		ConfigurableApplicationContext context = SpringApplication.run(BackendApplication.class, args);

        MyService myService = context.getBean(MyService.class);

        // List<MyEntity> entities = myService.getAllEntities();
        // System.out.println(entities);

        // myService.addEntity(entity);
        // MyEntity retrievedEntity = myService.getEntityById(retrievedId);
        // System.out.println(retrievedEntity);
	}

}

@RestController
@CrossOrigin(origins = "http://localhost:3000")
class MyController {

    @Autowired
    private MyService service;

    @GetMapping("/")
    public ResponseEntity<String> hello() {
        String body = "Hello, world!";
        return ResponseEntity.ok(body);
    }

    @GetMapping("/add_entity")
    public Long addEntity(@RequestParam String name) {
        MyEntity entity = new MyEntity();
        entity.setName(name);
        MyEntity savedEntity = service.addEntity(entity);
        Long retrievedId = savedEntity.getId();
        return retrievedId;
    }

    @GetMapping("/get_all_entities")
    public List<MyEntity> getAllEntities() {
        return service.getAllEntities();
    }

    @GetMapping("/get_entity_by_id")
    public MyEntity getEntityById(@RequestParam Long id) {
        MyEntity retrievedEntity = service.getEntityById(id);
        return retrievedEntity;
    }
    
}
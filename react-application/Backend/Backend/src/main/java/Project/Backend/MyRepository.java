package Project.Backend;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface MyRepository extends JpaRepository<MyEntity, Long> {
    // Define your data access methods here
}
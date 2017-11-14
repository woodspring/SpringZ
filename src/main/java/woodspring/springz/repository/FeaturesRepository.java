package woodspring.springz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import woodspring.springz.dto.Features;
@Repository
public interface FeaturesRepository extends JpaRepository<Features, Integer>{

}

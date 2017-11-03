package woodspring.springz.repository;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import woodspring.springz.dto.*;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

	Customer findByFirstname( String firstname);
	Customer findByEmail( String email);
}

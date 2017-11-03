package woodspring.springz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;

import woodspring.springz.config.JpaConfiguration;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages= {"woodspring.springz.*"})
//@EntityScan(basePackages = "woodspring.springz.dto")
public class SpringZApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringZApplication.class, args);
	}
}

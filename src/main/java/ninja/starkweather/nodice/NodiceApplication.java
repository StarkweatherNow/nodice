package ninja.starkweather.nodice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("ninja.starkweather.nodice.dice")
@EntityScan("ninja.starkweather.nodice.dice")
@SpringBootApplication
public class NodiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NodiceApplication.class, args);
	}

}

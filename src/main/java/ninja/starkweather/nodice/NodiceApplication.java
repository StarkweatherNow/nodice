package ninja.starkweather.nodice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

//Repository Search
@EnableJpaRepositories("ninja.starkweather.nodice")
@EntityScan("ninja.starkweather.nodice")

@SpringBootApplication
public class NodiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(NodiceApplication.class, args);
	}

}

package TrackingCaloriesProject.FirstApp;

import TrackingCaloriesProject.FirstApp.Service.UserService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FirstAppApplication implements ApplicationRunner {

	public static void main(String[] args) {
		SpringApplication.run(FirstAppApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

	}
}

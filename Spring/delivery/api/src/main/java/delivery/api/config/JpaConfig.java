package delivery.api.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan(basePackages = "delivery.db")
@EnableJpaRepositories(basePackages = "delivery.db")
public class JpaConfig {
}

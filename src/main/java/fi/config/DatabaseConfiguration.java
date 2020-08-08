package fi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Configuración de aspectos relacionados con base de datos
 *
 * @author Leonel Pineda
 */


@Configuration
@EnableJpaRepositories("fi.dao")
@EnableTransactionManagement
public class DatabaseConfiguration {
}



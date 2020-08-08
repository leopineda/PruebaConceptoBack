package fi;

import fi.config.ApplicationProperties;
import fi.util.DefaultProfileUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Collection;

@EnableAsync
@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
@EntityScan(basePackageClasses = {Application.class, Jsr310JpaConverters.class})
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);
    private final Environment env;

    /**
     * Inyección de dependencias por constructor
     *
     * @param env Entorno
     */
    public Application(Environment env) {
        this.env = env;
    }


    /**
     * Inicializa la aplicación.
     * <p>
     * Los profiles de Spring pueden ser especificados como argumentos de línea de
     * comandos: --spring.profiles.active=el-profile-activo
     */
    @PostConstruct
    public void initApplication() {
        Collection<String> activeProfiles = Arrays.asList(env.getActiveProfiles());
    }

    /**
     * Metodo principal
     *
     * @param args argumentos de línea de comandos
     * @throws UnknownHostException Si ocurre alguna excepcion
     */
    public static void main(String[] args) throws UnknownHostException {
        System.setProperty("spring.security.strategy", "MODE_INHERITABLETHREADLOCAL");
        SpringApplication app = new SpringApplication(Application.class);
        DefaultProfileUtil.addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        String protocol = "http";
        if (env.getProperty("server.ssl.key-store") != null) {
            protocol = "https";
        }
        LOGGER.info("\n----------------------------------------------------------\n\t" +
                        "Aplicacion '{}' en ejecucion. URLs de acceso:\n\t" +
                        "Local: \t\t{}://localhost:{}\n\t" +
                        "Externa: \t{}://{}:{}\n\t" +
                        "Profile(s): \t{}\n----------------------------------------------------------",
                env.getProperty("spring.application.name"),
                protocol,
                env.getProperty("server.port"),
                protocol,
                InetAddress.getLocalHost().getHostAddress(),
                env.getProperty("server.port"),
                env.getActiveProfiles());

    }
}

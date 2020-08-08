package fi.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

import static springfox.documentation.builders.PathSelectors.regex;

/**
 * Configuración de documentación de API por Swagger
 *
 * @author Leonel Pineda
 */


@Configuration
@EnableSwagger2
@Import(BeanValidatorPluginsConfiguration.class)
@Profile(Constants.SPRING_PROFILE_SWAGGER)
public class SwaggerConfiguration {
    private final Logger log = LoggerFactory.getLogger(SwaggerConfiguration.class);

    private final ApplicationProperties applicationProperties;

    /**
     * Inyección de dependencias por constructor
     *
     * @param applicationProperties
     */
    public SwaggerConfiguration(ApplicationProperties applicationProperties) {
        this.applicationProperties = applicationProperties;
    }

    /**
     * Configuración Springfox para la documentación de API por Swagger
     *
     * @return configuración Swagger Springfox
     */
    @Bean
    public Docket swaggerSpringfoxApiDocket() {
        log.debug("Iniciando Swagger...");
        StopWatch watch = new StopWatch();
        watch.start();
        Contact contact = new Contact(
                applicationProperties.getSwagger().getContactName(),
                applicationProperties.getSwagger().getContactUrl(),
                applicationProperties.getSwagger().getContactEmail());

        ApiInfo apiInfo = new ApiInfo(
                applicationProperties.getSwagger().getTitle(),
                applicationProperties.getSwagger().getDescription(),
                applicationProperties.getSwagger().getVersion(),
                applicationProperties.getSwagger().getTermsOfServiceUrl(),
                contact,
                applicationProperties.getSwagger().getLicense(),
                applicationProperties.getSwagger().getLicenseUrl(),
                new ArrayList<>());

        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo)
                .forCodeGeneration(true)
                .directModelSubstitute(java.nio.ByteBuffer.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .select()
                //.paths(PathSelectors.any())
                .paths(regex(applicationProperties.getSwagger().getDefaultIncludePattern()))
                .build();
        watch.stop();
        log.debug("Swagger iniciado en {} ms", watch.getTotalTimeMillis());
        return docket;
    }

    /**
     * Configuración de Springfox para los endpoints de administración (actuator)
     *
     * @param appName               Nombre de la aplicación
     * @param managementContextPath path de acceso a los endpoints de administración
     * @param appVersion            versión de la aplicación
     * @return configuración Swagger Springfox
     */
    @Bean
    public Docket swaggerSpringfoxManagementDocket(@Value("${spring.application.name}") String appName,
                                                   @Value("${management.context-path}") String managementContextPath,
                                                   @Value("${info.project.version}") String appVersion) {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(new ApiInfo(appName + " API Administracion", "Documentacion de endpoints de Administracion",
                        appVersion, "", ApiInfo.DEFAULT_CONTACT, "", "", new ArrayList<VendorExtension>()))
                .groupName("management")
                .forCodeGeneration(true)
                .directModelSubstitute(java.nio.ByteBuffer.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .select()
                .paths(regex(managementContextPath + ".*"))
                .build();
    }

}


package com.library.sroy.LibraryProject.configuration;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
/*
 *This is the Swagger docuemntation of the application
 * The Swagger can be accessed using the url
 * http://localhost:8080/swagger-ui.html#/
 */
@Configuration
@EnableSwagger2
public class Swagger2UiConfiguration {

    @Bean
    public Docket postsApi(){
        return new Docket(DocumentationType.SWAGGER_2).groupName("libraryProject-Api")
                    .apiInfo(apiInfo()).select().paths(postPaths()).build();
    }

    private Predicate<String> postPaths() {return or(regex("/library.*"), regex("/library.*"));}

    private ApiInfo apiInfo(){
        return new ApiInfoBuilder().title("My Library Application Project")
                    .description("A Library Application ")
                    .termsOfServiceUrl("http://library.com")
                    .contact("roysudeepto168@gmail.com").license("Library License")
                    .licenseUrl("rayvicky712@gmail.com").version("1.0").build();
    }
}

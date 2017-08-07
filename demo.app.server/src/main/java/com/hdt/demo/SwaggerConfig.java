/**
 * 
 */
package com.hdt.demo;
import com.google.common.base.Predicate;

import static com.google.common.base.Predicates.or;
import static springfox.documentation.builders.PathSelectors.regex;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Sathiyan
 *
 */
@EnableSwagger2
@PropertySource("classpath:swagger.property")//optional one 
@ComponentScan(basePackages="com.hdt.demo.Controllers")//optional one
@Configuration
public class SwaggerConfig {
	/**
	 * Any API will have below info SWAGGER_API_VERSION,LICENCE,TITLE,DESCRIPTION
	 *  
	 *  To configure Swagger UI we need to do below steps
	 *  1.Configure APIInfo
	 *  2.Configure Docket (docket is important configuraion to generate API documentation)
	 *  3.Path Config
	 *  
	 *  
	 *  
	 */
	
	private static final String SWAGGER_API_VERSION="1.0";	
	private static final String  LICENCE="LICENCE";	
	private static final String TITLE="DEMO API";	
	private static final String DESCRIPTION ="API for sample App create by Sathiyan ";
	
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title(TITLE)
				.description(DESCRIPTION)
				.version(SWAGGER_API_VERSION)	
				.license(LICENCE)
				.build();
	}

	@Bean
	public Docket demoapi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.useDefaultResponseMessages(false)
				.select()
				.apis(RequestHandlerSelectors.any())
				.apis(RequestHandlerSelectors.basePackage("com.hdt.demo.Controllers"))
				.paths(paths()).build()
				.apiInfo(apiInfo());
	}

	
	@SuppressWarnings("unchecked")
	private Predicate<String> paths() {
		return or(
				//regex("/users.*"),
				//regex("/role.*"),
				//regex("/login.*")
				regex("/api.*")
				);
	}

}

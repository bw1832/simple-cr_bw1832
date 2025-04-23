package org.gitlab4j.simplecr;

import org.gitlab4j.simplecr.config.SimpleCrConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@SpringBootApplication
@EnableConfigurationProperties(SimpleCrConfiguration.class)
public class SimpleCrApplication implements WebMvcConfigurer {
    
	public static void main(String[] args) {

	    // Set up the embedded Tomcat to allow for encoded slashes in the URLs
	    System.setProperty("org.apache.tomcat.util.buf.UDecoder.ALLOW_ENCODED_SLASH", "true");

		SpringApplication.run(SimpleCrApplication.class, args);
	}
/**/

    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        urlPathHelper.setUrlDecode(false);
        configurer.setUrlPathHelper(urlPathHelper);
    }
}

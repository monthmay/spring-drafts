package xyz.demo.thymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.format.FormatterRegistry;
import org.springframework.validation.Validator;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import xyz.demo.thymeleaf.converter.EmailAddressFormatter;
import xyz.demo.thymeleaf.converter.StringToEnumConverter;
import xyz.demo.thymeleaf.validation.PeopleValidator;

//@SpringBootApplication
@EnableAutoConfiguration
@SpringBootConfiguration
//@Import(value = {HomeController.class})
@ComponentScan
public class ThymeleafDemoApplication implements WebMvcConfigurer {

	@Override
	public Validator getValidator() {
		return new PeopleValidator();
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new EmailAddressFormatter());
		registry.addConverterFactory(new StringToEnumConverter());
	}

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafDemoApplication.class, args);
	}

}

package kr.green.core.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/*
@Repository – Used to mark a bean as DAO Component on persistence layer
@Service – Used to mark a bean as Service Component on business layer
@Controller – Used to mark a bean as Controller Component on Presentation layer
@Configuration – Used to mark a bean as Configuration Component.
@Component – General purpose annotation, can be used as a replacement for above annotations.
*/

@Configuration
@ComponentScan(basePackages = {"kr.green.core"})
public class AppConfig {

}

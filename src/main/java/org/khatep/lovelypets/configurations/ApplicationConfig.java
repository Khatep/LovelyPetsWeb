package org.khatep.lovelypets.configurations;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("org.khatep.lovelypets")
@EnableAspectJAutoProxy
public class ApplicationConfig {

}
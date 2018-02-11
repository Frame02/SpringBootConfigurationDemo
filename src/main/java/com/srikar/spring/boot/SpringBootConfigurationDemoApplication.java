package com.srikar.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class SpringBootConfigurationDemoApplication {

    @Value("${configuration.projectName}")
    void setProjectName(String projectName){
        System.out.println("Setting project name: " + projectName);
    }

    @Autowired
    void setEnvironment(Environment env){
        System.out.println("Setting environment: " + env.getProperty("configuration.projectName"));
    }

    @Autowired
    void setConfigurationProjectProperties(ConfigurationProjectProperties properties){
        System.out.println("Setting configurationProjectProperties: " + properties.getProjectName());
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringBootConfigurationDemoApplication.class, args);
	}
}


@Component
@ConfigurationProperties("configuration")
class ConfigurationProjectProperties{
    private String projectName;

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
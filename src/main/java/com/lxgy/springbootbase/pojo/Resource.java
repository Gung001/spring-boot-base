package com.lxgy.springbootbase.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author Gryant
 */
@Configuration
@ConfigurationProperties(prefix="com.lxgy.conf.constant")
@PropertySource(value="classpath:resource.properties")
public class Resource {

	private String projectName;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
}

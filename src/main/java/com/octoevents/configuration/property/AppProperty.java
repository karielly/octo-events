package com.octoevents.configuration.property;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("appProperty")
public class AppProperty {
	
	private final SecurityApp security = new SecurityApp();

    public SecurityApp getSecurityApp() {
        return security;
    }

    public static class SecurityApp {

        private boolean enableHttps;
        private String allowedServer = "*";

        public boolean isEnableHttps() {
            return enableHttps;
        }

        public String getAllowedServer() {
            return allowedServer;
        }
    }
}

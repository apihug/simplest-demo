package com.apihug.demo;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class DemoAppApplication {
    private static final Logger log = LoggerFactory.getLogger(DemoAppApplication.class);

    public static final String APP_NAME = "demo-app";

    /**
     * @see SpringApplicationBuilder
     * @param args  main enter arguments
     */
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(DemoAppApplication.class);
        addDefaultProfile(app);
        Environment env = app.run(args).getEnvironment();
        logApplicationStartup(env);
    }

    public static void addDefaultProfile(SpringApplication app) {
        final Map<String, Object> defProperties = new HashMap<>();
        /*
         * The default profile to use when no other profiles are defined
         * This cannot be set in the application.yml file.
         * See https://github.com/spring-projects/spring-boot/issues/1219
         */
        defProperties.put("spring.profiles.default", "dev");
        defProperties.put("spring.application.name", APP_NAME);
        app.setDefaultProperties(defProperties);
    }

    private static void logApplicationStartup(Environment env) {
        String protocol =
                Optional.ofNullable(env.getProperty("server.ssl.key-store"))
                        .map(key -> "https")
                        .orElse("http");
        String serverPort = env.getProperty("server.port");
        String contextPath =
                Optional.ofNullable(env.getProperty("server.servlet.context-path"))
                        .filter(it -> it != null && !it.isBlank())
                        .orElse("/");
        String hostAddress = "localhost";
        try {
            hostAddress = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            log.warn("The host name could not be determined, using `localhost` as fallback");
        }

        StringBuffer sb = new StringBuffer();

       sb.append(
                        String.format(
                                "\t%-32s  %-64s\n", "Local", protocol + "://localhost:" + serverPort + contextPath))
                .append(
                        String.format(
                                "\t%-32s  %-64s\n",
                                "External", protocol + "://" + hostAddress + ":" + serverPort + contextPath))
                .append(
                        String.format(
                                "\t%-32s  %-64s\n",
                                "OAS",
                                protocol + "://" + hostAddress + ":" + serverPort + contextPath + "v3/api-docs"))
                .append(
                        String.format(
                                "\t%-32s  %-64s\n",
                                "Actuator",
                                protocol + "://" + hostAddress + ":" + serverPort + contextPath + "management"))
                .append(
                        String.format(
                                "\t%-32s  %-64s\n",
                                "Api-Errors",
                                protocol + "://" + hostAddress + ":" + serverPort + contextPath + "hope/meta/errors"))
                .append(
                        String.format(
                                "\t%-32s  %-64s\n",
                                "Api-Dictionaries",
                                protocol + "://" + hostAddress + ":" + serverPort + contextPath + "hope/meta/dictionaries"))
                .append(
                        String.format(
                                "\t%-32s  %-64s\n",
                                "Api-Authorities",
                                protocol + "://" + hostAddress + ":" + serverPort + contextPath + "hope/meta/authorities"))
                .append(
                        String.format(
                                "\t%-32s  %-64s\n",
                                "Profile(s)",
                                String.join(
                                        ",",
                                        env.getActiveProfiles().length == 0
                                                ? env.getDefaultProfiles()
                                                : env.getActiveProfiles())));

        log.info(
                "\n----------------------------------------------------------\n\n"
                        + "Application '{}' is running! Access URLs:\n\n{}\n",
                env.getProperty("spring.application.name"),
                sb);


    }
}
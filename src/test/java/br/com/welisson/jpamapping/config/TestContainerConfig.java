package br.com.welisson.jpamapping.config;


import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Testcontainers;


@AutoConfigureTestDatabase(
        replace = AutoConfigureTestDatabase.Replace.NONE
)
@ContextConfiguration(initializers = {TestContainerConfig.class})
@Testcontainers
public class TestContainerConfig implements ApplicationContextInitializer<ConfigurableApplicationContext> {

    public static PostgreSQLContainer<?> postgresDBContainer;

    @Override
    public void initialize(final ConfigurableApplicationContext applicationContext) {
        TestContainerConfig.postgresDBContainer = new PostgreSQLContainer<>("postgres:9.5");
        TestContainerConfig.postgresDBContainer.start();

        final String jdbcUrl = String.format("jdbc:postgresql://localhost:%s/mapping",
                TestContainerConfig.postgresDBContainer.getMappedPort(5432).toString());

        System.setProperty("spring.datasource.url", TestContainerConfig.postgresDBContainer.getJdbcUrl());
        System.setProperty("spring.datasource.username", TestContainerConfig.postgresDBContainer.getUsername());
        System.setProperty("spring.datasource.password", TestContainerConfig.postgresDBContainer.getPassword());
    }
}

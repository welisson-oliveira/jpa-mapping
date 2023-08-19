package br.com.welisson.jpamapping.repository;

import br.com.welisson.jpamapping.config.AbstractTestsConfig;
import br.com.welisson.jpamapping.domain.Many;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ManyRepositoryTests extends AbstractTestsConfig {

    @Autowired
    private ManyRepository repository;

    @Test
    public void test() {
        this.repository.save(new Many(null));

        this.repository.findAll();
    }

}

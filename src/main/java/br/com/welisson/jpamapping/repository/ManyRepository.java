package br.com.welisson.jpamapping.repository;

import br.com.welisson.jpamapping.domain.Many;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManyRepository extends JpaRepository<Many, Long> {
}

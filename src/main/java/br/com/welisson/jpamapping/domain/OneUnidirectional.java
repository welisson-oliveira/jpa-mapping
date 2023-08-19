package br.com.welisson.jpamapping.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class OneUnidirectional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * mapeado apenas nessa entidade, cria uma tabela de relacionamento que armazenda o id das duas entidades
     */
    @OneToMany
    private final List<Many> many = new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "one_id")// opcional
    private One one;
}

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
public class ManyUnidirectional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * mapeado apenas nessa entidade, cria um campo one_id na tabela ManyUnidirectional
     */
    @ManyToOne
    @JoinColumn(name = "one_id")
    private One one;


    @ManyToMany
    @JoinTable(name = "many_to_many_unidirectional",
            joinColumns = @JoinColumn(name = "many_uni_id"),
            inverseJoinColumns = @JoinColumn(name = "many_id"))
    private final List<Many> many = new ArrayList<>();

}

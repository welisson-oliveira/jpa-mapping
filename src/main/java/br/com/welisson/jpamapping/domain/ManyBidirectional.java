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
public class ManyBidirectional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * mapeado nas duas classes, cria o campo one_id na tabela ManyBidirectional
     */
    @ManyToOne
    @JoinColumn(name = "one_id")
    private One one;

    @ManyToMany
    @JoinTable(name = "many_to_many_bidirectional",
            joinColumns = @JoinColumn(name = "many_uni_id"),
            inverseJoinColumns = @JoinColumn(name = "many_id"))
    private final List<Many> many = new ArrayList<>();

}

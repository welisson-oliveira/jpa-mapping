package br.com.welisson.jpamapping.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class OneBidirectional {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    /**
     * é obrigatorio que uma das duas entidades utilize o mappedby, para nao gerar uma dependencia ciclica
     * mappedby diz que a outra entidade é a mandatoria
     */
    @OneToOne(mappedBy = "oneBidirectional")
    private One one;
}

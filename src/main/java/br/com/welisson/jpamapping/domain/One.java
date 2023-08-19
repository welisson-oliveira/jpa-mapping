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
public class One {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * mapeado nas duas classes, mappedBy se torna obrigatorio para informar quem é dono do relacionamento.
     * caso não informado, o hibernate irá criar uma tabela derelacionamento entre essas duas entidades
     */
    @OneToMany(mappedBy = "one")
    private final List<ManyBidirectional> manyBidirectional = new ArrayList<>();

    /**
     * é obrigatorio que uma das duas entidades utilize o mappedby, para nao gerar uma dependencia ciclica
     * o mappedby foi definido na outra entidade, por isso essa é a mandatoria,
     * um campo referente a outra entidade sera criado
     */
    @OneToOne
    @JoinColumn(name = "one_bidirectional") // define o nome do campo que sera criado nessa entidade
    private OneBidirectional oneBidirectional;

}

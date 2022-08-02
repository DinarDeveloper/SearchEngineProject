package gatiiatullin_dinar.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "`index`")
public class Index {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "page_id")
    private Page page;

    @Column(name = "lemma_id")
    private Lemma lemma;

    @Column(name = "rank")
    private float rank;
}
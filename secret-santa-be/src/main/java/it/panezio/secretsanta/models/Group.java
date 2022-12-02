package it.panezio.secretsanta.models;

import javax.persistence.*;

@Entity
@Table(name = "GROUPS")
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id", unique = true)
    private Long id;

    @Column(name = "name")
    private String name;

}

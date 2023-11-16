package org.goit.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "planet")
@Getter
@Setter
public class Planet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    private long id;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @OneToMany(mappedBy = "fromPlanet", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Getter
    List<Ticket> fromTickets;

    @OneToMany(mappedBy = "toPlanet", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Getter
    List<Ticket> toTickets;

    @Override
    public String toString(){
        return id + ") " + name;
    }
}

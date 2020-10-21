package com.astra.getyourmusic.model.contractSystem;


import com.astra.getyourmusic.model.userSystem.Musician;
import com.astra.getyourmusic.model.userSystem.Organizer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "qualifications")
public class Qualification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    private Long score;
    @ManyToOne()
    @JoinColumn(name = "organizer_id", nullable = false)
    private Organizer organizer;
    @ManyToOne()
    @JoinColumn(name = "musician_id", nullable = false)
    private Musician musician;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "contract_id", referencedColumnName = "id")
    private Contract contract;
}

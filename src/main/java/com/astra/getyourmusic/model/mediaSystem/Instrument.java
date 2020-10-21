package com.astra.getyourmusic.model.mediaSystem;

import com.astra.getyourmusic.model.userSystem.Musician;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@JsonIgnoreProperties(value = "musicians")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "instruments")
public class Instrument {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany(mappedBy = "instruments")
    List<Musician> musicians;
}

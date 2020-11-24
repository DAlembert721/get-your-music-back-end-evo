package com.astra.getyourmusic.model.userSystem;

import com.astra.getyourmusic.model.contractSystem.Contract;
import com.astra.getyourmusic.model.contractSystem.Qualification;
import com.astra.getyourmusic.model.mediaSystem.Following;
import com.astra.getyourmusic.model.mediaSystem.Genre;
import com.astra.getyourmusic.model.mediaSystem.Instrument;
import com.astra.getyourmusic.model.mediaSystem.Publication;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"contracts", "publications", "genres", "instruments",
        "qualifications", "followers", "followed"})
@PrimaryKeyJoinColumn(name = "musician_id")
@Table(name = "musicians")
public class Musician extends Profile {
    @Column(name = "rating")
    private float rating = 0;

    @JoinTable(
            name = "musician_genre",
            joinColumns = @JoinColumn(name = "musician_id"),
            inverseJoinColumns = @JoinColumn(name = "genre_id")
    )
    @ManyToMany(cascade = CascadeType.ALL)
    List<Genre> genres;
    @JoinTable(
            name = "musician_instrument",
            joinColumns = @JoinColumn(name = "musician_id"),
            inverseJoinColumns = @JoinColumn(name = "instrument_id")
    )
    @ManyToMany(cascade = CascadeType.ALL)
    List<Instrument> instruments;

    @OneToMany(mappedBy = "musician")
    private List<Contract> contracts;
    @OneToMany(mappedBy = "musician")
    private List<Publication> publications;
    @OneToMany(mappedBy = "musician")
    private List<Qualification> qualifications;
    @OneToMany(mappedBy = "follower")
    private List<Following> followers;
    @OneToMany(mappedBy = "followed")
    private List<Following> followed;
}

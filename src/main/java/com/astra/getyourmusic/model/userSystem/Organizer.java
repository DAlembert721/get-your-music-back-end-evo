package com.astra.getyourmusic.model.userSystem;

import com.astra.getyourmusic.model.contractSystem.Contract;
import com.astra.getyourmusic.model.contractSystem.Qualification;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(value = {"contracts", "qualifications"})
@PrimaryKeyJoinColumn(name = "organizer_id")
@Table(name = "organizers")
public class Organizer extends Profile {
    @OneToMany(mappedBy = "organizer")
    private List<Contract> contracts;
    @OneToMany(mappedBy = "organizer")
    private List<Qualification> qualifications;
}

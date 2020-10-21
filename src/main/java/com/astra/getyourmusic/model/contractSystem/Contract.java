package com.astra.getyourmusic.model.contractSystem;

import com.astra.getyourmusic.model.locations.District;
import com.astra.getyourmusic.model.userSystem.*;
import com.astra.getyourmusic.service.pattern.Observer;
import com.astra.getyourmusic.service.pattern.Subject;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@Entity
@Table(name = "contracts")
public class Contract implements Subject {
    @Transient
    private ArrayList<Observer> observersList = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "address")
    private String address;
    @Column(name = "reference")
    private String reference;
    @Column(name = "start_date")
    private String startDate;
    @Column(name = "end_date")
    private String endDate;
    @ManyToOne()
    @JoinColumn(name = "organizer_id", nullable = false)
    private Organizer organizer;
    @ManyToOne()
    @JoinColumn(name = "musician_id", nullable = false)
    private Musician musician;
    @ManyToOne
    @JoinColumn(name = "district_id", nullable = false)
    private District district;
    @Column(name = "contract_state_id")
    @Enumerated(value = EnumType.ORDINAL)
    private ContractState contractState;
    @OneToOne(mappedBy = "contract")
    private Qualification qualification;

    @Override
    public void addObserver(Observer o) {
        observersList.add(o);
    }

    @Override
    public void notifyObservers() {
        for(Observer observer: observersList) {
            observer.update(this);
        }
    }
}

package com.astra.getyourmusic.model.mediaSystem;

import com.astra.getyourmusic.model.userSystem.Musician;
import com.astra.getyourmusic.service.pattern.Observer;
import com.astra.getyourmusic.service.pattern.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "followings")
public class Following implements Subject {
    @Transient
    private ArrayList<Observer> observersList = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "follower_id", referencedColumnName = "musician_id",nullable = false)
    private Musician follower;
    @ManyToOne
    @JoinColumn(name = "followed_id", referencedColumnName = "musician_id",nullable = false)
    private Musician followed;
    @Column(name = "active")
    private boolean active;

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

package com.astra.getyourmusic.model.chatSystem;

import com.astra.getyourmusic.model.userSystem.Profile;
import com.astra.getyourmusic.service.pattern.Observer;
import com.astra.getyourmusic.service.pattern.Subject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "messages")
public class Message implements Subject {
    @Transient
    private ArrayList<Observer> observersList = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "text")
    private String text;
    @Column(name = "send_date")
    private String sendDate;
    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "profile_id", nullable = false)
    private Profile sender;
    @ManyToOne
    @JoinColumn(name = "receiver_id", referencedColumnName = "profile_id",nullable = false)
    private Profile receiver;

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

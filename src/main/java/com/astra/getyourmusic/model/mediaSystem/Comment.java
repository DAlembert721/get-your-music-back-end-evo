package com.astra.getyourmusic.model.mediaSystem;

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
@Table(name = "comments")
public class Comment implements Subject {
    @Transient
    private ArrayList<Observer> observersList = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String text;
    @ManyToOne()
    @JoinColumn(name = "profile_id", nullable = false)
    private Profile commenter;
    @ManyToOne()
    @JoinColumn(name = "publication_id", nullable = false)
    private Publication publication;

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

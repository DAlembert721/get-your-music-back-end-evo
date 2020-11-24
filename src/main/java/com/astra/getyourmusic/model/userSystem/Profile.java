package com.astra.getyourmusic.model.userSystem;

import com.astra.getyourmusic.model.chatSystem.Message;
import com.astra.getyourmusic.model.locations.District;
import com.astra.getyourmusic.model.mediaSystem.Comment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(value = {"comments", "senders", "receivers"})
@Entity
@PrimaryKeyJoinColumn(name = "profile_id")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "profiles")
public class Profile extends User {
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "birth_date")
    private String birthDate;
    @Column(name = "phone")
    private String phone;
    @Column(name = "personal_web")
    private String personalWeb;
    @Column(name = "description")
    private String description;
    @Column(name = "register_date")
    private String registerDate;
    @Column(name = "photo_url")
    private String photoUrl;
    @ManyToOne()
    @JoinColumn(name = "district_id", nullable = false)
    private District district;
    @Column(name = "type")
    private String type;
    @OneToMany(mappedBy = "commenter")
    private List<Comment> comments;
    @OneToMany(mappedBy = "sender")
    private List<Message> senders;
    @OneToMany(mappedBy = "receiver")
    private List<Message> receivers;
    @OneToMany(mappedBy = "profile")
    List<Notification> notifications;
}

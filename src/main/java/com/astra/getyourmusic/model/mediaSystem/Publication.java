package com.astra.getyourmusic.model.mediaSystem;

import com.astra.getyourmusic.model.userSystem.Musician;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@JsonIgnoreProperties(value = "comments")
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "publications")
public class Publication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "video_url")
    private String videoUrl;
    @Column(name = "content")
    private String content;
    @Column(name = "type")
    private Long type;
    @Column(name = "update_time")
    private String updateTime;
    @ManyToOne()
    @JoinColumn(name = "musician_id", nullable = false)
    private Musician musician;
    @OneToMany(mappedBy = "publication")
    private List<Comment> comments;
}

package com.astra.getyourmusic.resource.contractResource;

import com.astra.getyourmusic.model.contractSystem.Contract;
import com.astra.getyourmusic.model.userSystem.Musician;
import com.astra.getyourmusic.model.userSystem.Organizer;
import lombok.Data;

import javax.persistence.*;


@Data
public class QualificationResource {
    private Long id;
    private String text;
    private Long score;
    private String organizerName;
}

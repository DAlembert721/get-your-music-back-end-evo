package com.astra.getyourmusic.resource.userResource;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MusicianResource extends ProfileResource{
    private float rating;
}

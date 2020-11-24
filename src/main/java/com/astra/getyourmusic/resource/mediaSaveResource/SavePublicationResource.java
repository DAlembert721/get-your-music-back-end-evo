package com.astra.getyourmusic.resource.mediaSaveResource;

import lombok.Data;

@Data
public class SavePublicationResource {
    private String videoUrl;
    private String content;
    private Long type;
}

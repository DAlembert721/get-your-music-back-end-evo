package com.astra.getyourmusic.resource.chatResource;

import lombok.Data;

@Data
public class MessageResource {
    private String text;
    private String sendDate;
    private String SenderName;
    private String SenderLastName;
    private String ReceiverName;
    private String ReceiverLastName;
}

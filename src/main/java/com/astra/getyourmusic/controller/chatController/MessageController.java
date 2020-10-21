package com.astra.getyourmusic.controller.chatController;

import com.astra.getyourmusic.model.chatSystem.Message;
import com.astra.getyourmusic.model.contractSystem.Contract;
import com.astra.getyourmusic.resource.chatResource.MessageResource;
import com.astra.getyourmusic.resource.chatSaveResource.SaveMessageResource;
import com.astra.getyourmusic.resource.contractResource.ContractResource;
import com.astra.getyourmusic.service.chatService.MessageService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class MessageController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private MessageService messageService;

    @PostMapping("/profiles/{senderId}/profiles/{receiverId}/messages")
    private MessageResource create(@RequestBody SaveMessageResource message,
                           @PathVariable(name = "senderId") Long senderId,
                           @PathVariable(name = "receiverId") Long receiverId)
    {
        Message exist = messageService.save(convertToEntity(message), senderId, receiverId);
        return convertToResource(exist);
    }

    @GetMapping("/profiles/messages/{messageId}")
    private MessageResource getById(@PathVariable(name = "messageId") Long messageId)
    {
        Message exist = messageService.getById(messageId);
        return convertToResource(exist);
    }

    @GetMapping("/profiles/{receiverId}/messages/received")
    private List<MessageResource> getAllMessagesByReceiverId(@PathVariable(name = "receiverId") Long receiverId)
    {
        List<Message> messages = messageService.getAllByReceiverId(receiverId);
        return messages.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/profiles/{senderId}/messages/sent")
    private List<MessageResource> getAllMessagesBySenderId(@PathVariable(name = "senderId") Long senderId)
    {
        List<Message> messages = messageService.getAllBySenderId(senderId);
        return messages.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @PostConstruct
    public void init(){
        mapper.addMappings(new PropertyMap< Message, MessageResource>() {

            @Override
            protected void configure() {
                map().setSenderName(source.getSender().getFirstName());
                map().setSenderLastName(source.getSender().getLastName());
                map().setReceiverName(source.getReceiver().getFirstName());
                map().setReceiverLastName(source.getReceiver().getLastName());
            }
        });
    }

    private MessageResource convertToResource(Message entity)
    {
        return mapper.map(entity, MessageResource.class);
    }

    private Message convertToEntity(SaveMessageResource resource)
    {
        return mapper.map(resource, Message.class);
    }
}

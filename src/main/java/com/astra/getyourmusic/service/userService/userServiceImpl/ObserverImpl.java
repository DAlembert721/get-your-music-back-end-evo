package com.astra.getyourmusic.service.userService.userServiceImpl;

import com.astra.getyourmusic.model.chatSystem.Message;
import com.astra.getyourmusic.model.contractSystem.Contract;
import com.astra.getyourmusic.model.mediaSystem.Comment;
import com.astra.getyourmusic.model.mediaSystem.Following;
import com.astra.getyourmusic.model.mediaSystem.Publication;
import com.astra.getyourmusic.model.userSystem.Notification;
import com.astra.getyourmusic.model.userSystem.Profile;
import com.astra.getyourmusic.repository.mediaRepository.PublicationRepository;
import com.astra.getyourmusic.repository.userRepository.NotificationRepository;
import com.astra.getyourmusic.service.pattern.Observer;
import com.astra.getyourmusic.service.pattern.Subject;
import org.springframework.beans.factory.annotation.Autowired;

public class ObserverImpl implements Observer {
    @Autowired
    private NotificationRepository notificationRepository;

    public ObserverImpl(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    @Override
    public void update(Subject subject) {
        Notification n = send(subject);
        notificationRepository.save(n);
    }

    public Notification send(Subject subject) {
        Notification n = new Notification();
        if(subject instanceof Contract)
        {
            if(((Contract) subject).getContractState().id() == 0)
            {
                String name = ((Contract) subject).getOrganizer().getFirstName();
                Profile profile = ((Contract) subject).getMusician();
                n.setMessage(name + " has sent you a contract");
                n.setProfile(profile);
            }
            if(((Contract) subject).getContractState().id() == 2)
            {
                String name = ((Contract) subject).getMusician().getFirstName();
                Profile profile = ((Contract) subject).getOrganizer();
                n.setMessage(name + " has accepted you a contract");
                n.setProfile(profile);
            }
            if(((Contract) subject).getContractState().id() == 3)
            {
                String name = ((Contract) subject).getMusician().getFirstName();
                Profile profile = ((Contract)subject).getOrganizer();
                n.setMessage(name + " has rejected you a contract");
                n.setProfile(profile);
            }
            if(((Contract) subject).getContractState().id() == 1)
            {
                String name2 = ((Contract) subject).getMusician().getFirstName();
                Profile profile2 = ((Contract) subject).getOrganizer();
                Notification n2 = new Notification();
                n2.setMessage(name2 + " your contract has ended");
                n2.setProfile(profile2);
                notificationRepository.save(n2);
                String name = ((Contract) subject).getOrganizer().getFirstName();
                Profile profile = ((Contract) subject).getMusician();
                n.setMessage(name + " your contract has ended");
                n.setProfile(profile);
            }
        }
        if(subject instanceof Following)
        {
            String name = ((Following) subject).getFollower().getFirstName();
            Profile profile = ((Following) subject).getFollowed();
            n.setMessage(name + " has started to follow you");
            n.setProfile(profile);
        }
        if(subject instanceof Message)
        {
            String name = ((Message) subject).getSender().getFirstName();
            Profile profile = ((Message) subject).getReceiver();
            n.setMessage(name + " has sent you a message : ");
            n.setProfile(profile);
        }
        if(subject instanceof Comment)
        {
            String name = ((Comment) subject).getCommenter().getFirstName();
            Profile profile = ((Comment) subject).getPublication().getMusician();
            n.setMessage(name + "has commented on your publication");
            n.setProfile(profile);
        }
        return n;
    }
}

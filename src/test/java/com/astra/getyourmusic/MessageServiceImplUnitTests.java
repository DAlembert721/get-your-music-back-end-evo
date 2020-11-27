package com.astra.getyourmusic;

import com.astra.getyourmusic.model.chatSystem.Message;
import com.astra.getyourmusic.service.chatService.MessageService;
import com.astra.getyourmusic.service.chatService.chatServiceImpl.MessageServiceImpl;
import org.joda.time.DateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class MessageServiceImplUnitTests {

    @MockBean
    private MessageService messageServiceMock;

    @Autowired
    private MessageService messageService;

    @TestConfiguration
    static class MessageServiceImplUnitTestConfiguration {
        @Bean
        public MessageService messageService() {
            return new MessageServiceImpl();
        }
    }

    @Test
    @DisplayName("When Create Message With Correct Information Then Returns The Message")
    public void WhenCreateMessageWithCorrectInformationThenReturnsABadMessage() {
        Message newMessage = new Message();
        newMessage.setId(1L);
        newMessage.setText("Abduzcan");
        newMessage.setSendDate(DateTime.now().toString());
        newMessage.setSender(null);
        newMessage.setReceiver(null);
        newMessage.notifyObservers();

        when(messageServiceMock.save(newMessage, 1L, 1L))
                .thenReturn(newMessage);

        Message message = messageService.save(newMessage, 1L, 1L);

        assertThat(message).isEqualTo(newMessage);
    }

    @Test
    @DisplayName("When Create Message With Incorrect Information Then Returns A Bad Message")
    public void WhenCreateMessageWithIncorrectInformationThenReturnsABadMessage() {
        Message newMessage = new Message();
        newMessage.setId(1L);
        newMessage.setText(null);
        newMessage.setSendDate(null);
        newMessage.setSender(null);
        newMessage.setReceiver(null);
        newMessage.notifyObservers();

        String messageError = "This is a bad Message";

        when(messageServiceMock.save(newMessage, 1L, 1L))
                .thenThrow(new RuntimeException(messageError));

        //Act
        Throwable exception = catchThrowable(() -> {
            Message message = messageService.save(newMessage, 1L, 1L);
        });
        //Assert
        assertThat(exception)
                .hasMessage(messageError);
    }

}

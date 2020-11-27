package com.astra.getyourmusic;

import com.astra.getyourmusic.model.contractSystem.Qualification;
import com.astra.getyourmusic.service.contractService.QualificationService;
import com.astra.getyourmusic.service.contractService.contractServiceImpl.QualificationServiceImpl;
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
public class QualificationServiceImplUnitTest {

    @MockBean
    private QualificationService qualificationServiceMock;

    @Autowired
    private QualificationService qualificationService;

    @TestConfiguration
    static class QualificationServiceImplTestConfiguration {
        @Bean
        public QualificationService qualificationService() {
            return new QualificationServiceImpl();
        }
    }

    @Test
    @DisplayName("When Create Qualification With Correct Information Then Returns The Qualification")
    public void WhenCreateQualificationWithCorrectInformationThenReturnsTheQualification() {
        Qualification newQualification = new Qualification();
        newQualification.setId(1L);
        newQualification.setOrganizer(null);
        newQualification.setContract(null);
        newQualification.setMusician(null);
        newQualification.setOrganizer(null);
        newQualification.setScore(4L);
        newQualification.setText("Best musician I have ever met");

        when(qualificationServiceMock.save(newQualification, 1L, 1L, 1L))
                .thenReturn(newQualification);

        Qualification qualification = qualificationService.save(newQualification, 1L, 1L, 1L);

        assertThat(qualification).isEqualTo(newQualification);
    }

    @Test
    @DisplayName("When Create Qualification With Incorrect Information Then Returns A Bad Message")
    public void WhenCreateQualificationWithIncorrectInformationThenReturnsABadMessage() {
        //Arrange
        Qualification newQualification = new Qualification();
        newQualification.setId(1L);
        newQualification.setOrganizer(null);
        newQualification.setContract(null);
        newQualification.setMusician(null);
        newQualification.setOrganizer(null);

        String message = "This is a bad Message";

        when(qualificationServiceMock.save(newQualification, 1L, 1L, 1L))
                .thenThrow(new RuntimeException(message));

        //Act
        Throwable exception = catchThrowable(() -> {
                Qualification qualification = qualificationService.save(newQualification, 1L, 1L, 1L);
        });
        //Assert
        assertThat(exception)
                .hasMessage(message);

    }
}

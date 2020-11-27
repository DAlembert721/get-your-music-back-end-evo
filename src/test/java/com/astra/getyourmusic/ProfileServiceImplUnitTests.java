package com.astra.getyourmusic;

import com.astra.getyourmusic.model.userSystem.Musician;
import com.astra.getyourmusic.model.userSystem.Organizer;
import com.astra.getyourmusic.model.userSystem.Profile;
import com.astra.getyourmusic.service.userService.ProfileService;
import com.astra.getyourmusic.service.userService.userServiceImpl.ProfileServiceImpl;
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
public class ProfileServiceImplUnitTests {

    @MockBean
    private ProfileService profileServiceMock;

    @Autowired
    private ProfileService profileService;

    @TestConfiguration
    static class ContractServiceImplTestConfiguration {
        @Bean
        public ProfileService profileService() {
            return new ProfileServiceImpl();
        }
    }

    @Test
    @DisplayName("When Create Musician With Correct Information Then Returns The Profile")
    public void whenCreateMusicianWithCorrectInformationThenReturnsTheProfile() {

        //Arrange
        Profile newProfile = new Musician();
        newProfile.setEmail("random@gmail.com");
        newProfile.setPassword("fasomctiovrnivrcqpir954ijcotvadceSADCDSasfsdafa");
        newProfile.setFirstName("random");
        newProfile.setLastName("randomsor");
        newProfile.setBirthDate(DateTime.now().toString());
        newProfile.setPhone("132412343");
        newProfile.setType("musician");
        newProfile.setDistrict(null);

        when(profileServiceMock.save(newProfile, 1L))
                .thenReturn(newProfile);

        //Act
        Profile profile = profileService.save(newProfile,  1L);

        //Assert
        assertThat(profile).isEqualTo(newProfile);
    }

    @Test
    @DisplayName("When Create Organizer With Correct Information Then Returns The Profile")
    public void whenCreateOrganizerWithCorrectInformationThenReturnsTheProfile() {

        //Arrange
        Profile newProfile = new Organizer();
        newProfile.setEmail("random@gmail.com");
        newProfile.setPassword("fasomctiovrnivrcqpir954ijcotvadceSADCDSasfsdafa");
        newProfile.setFirstName("random");
        newProfile.setLastName("randomsor");
        newProfile.setBirthDate(DateTime.now().toString());
        newProfile.setPhone("132412343");
        newProfile.setType("organizer");
        newProfile.setDistrict(null);

        when(profileServiceMock.save(newProfile, 1L))
                .thenReturn(newProfile);

        //Act
        Profile profile = profileService.save(newProfile,  1L);

        //Assert
        assertThat(profile).isEqualTo(newProfile);
    }
}

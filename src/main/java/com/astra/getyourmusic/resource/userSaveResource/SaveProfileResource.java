package com.astra.getyourmusic.resource.userSaveResource;

import com.astra.getyourmusic.model.locations.District;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;

@Data
public class SaveProfileResource {
    @NotBlank
    @NotNull
    private String email;
    @NotBlank
    @NotNull
    private String password;
    @NotBlank
    @NotNull
    private String firstName;
    @NotBlank
    @NotNull
    private String lastName;
    private String birthDate;
    private String phone;
    private String personalWeb;
    private String description;
    private String registerDate;
    @NotBlank
    @NotNull
    private String type;
}

package com.astra.getyourmusic.resource.contractSaveResource;


import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class SaveContractResource {
    @NotBlank
    @NotNull
    private String name;
    @NotBlank
    @NotNull
    private String address;
    @NotBlank
    @NotNull
    private String reference;
    @NotBlank
    @NotNull
    private String startDate;
    @NotBlank
    @NotNull
    private String endDate;
}

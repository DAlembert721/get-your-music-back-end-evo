package com.astra.getyourmusic.resource.contractResource;


import lombok.Data;

@Data
public class ContractResource {
    private Long id;
    private String name;
    private String address;
    private String reference;
    private String startDate;
    private String endDate;
    private String organizerName;
    private String musicianName;
    private String districtName;
    private int contractStateId;
    private String contractStateResponse;
}

package com.astra.getyourmusic.controller.contractController;

import com.astra.getyourmusic.model.contractSystem.Contract;
import com.astra.getyourmusic.model.contractSystem.ContractState;
import com.astra.getyourmusic.model.contractSystem.Qualification;
import com.astra.getyourmusic.resource.contractResource.ContractResource;
import com.astra.getyourmusic.resource.contractResource.QualificationResource;
import com.astra.getyourmusic.resource.contractSaveResource.SaveContractResource;
import com.astra.getyourmusic.resource.contractSaveResource.SaveQualificationResource;
import com.astra.getyourmusic.service.contractService.ContractService;
import com.astra.getyourmusic.service.userService.ProfileService;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class ContractController {
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private ContractService contractService;

    @GetMapping("/organizers/{organizerId}/contracts")
    public List<ContractResource> getAllContractsByOrganizerId(@PathVariable(name = "organizerId") Long organizerId) {
        List<Contract> contracts = contractService.getAllContractsByOrganizerId(organizerId);
        return contracts.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @GetMapping("/musicians/{musicianId}/contracts")
    public List<ContractResource> getAllContractsByMusicianId(@PathVariable(name = "musicianId") Long musicianId) {
        List<Contract> contracts = contractService.getAllContractsByMusicianId(musicianId);
        return contracts.stream().map(this::convertToResource).collect(Collectors.toList());
    }

    @PostMapping("/organizers/{organizerId}/musicians/{musicianId}/districts/{districtId}/contracts")
    public ContractResource save(@RequestBody SaveContractResource contract,
                         @PathVariable(name = "organizerId") Long organizerId,
                         @PathVariable(name = "musicianId") Long musicianId,
                         @PathVariable(name = "districtId") Long districtId){
        Contract newContract = contractService.save(convertToEntity(contract), organizerId, musicianId, districtId);
        return convertToResource(newContract);
    }

    @PutMapping("/contracts/{id}/contractStates/{stateId}")
    public ContractResource update(@PathVariable("id") Long contractId,
                                   @PathVariable("stateId") int actionId){
        Contract updated = contractService.updateContractState(contractId, ContractState.values()[actionId]);
        return convertToResource(updated);
    }

    @PostConstruct
    public void init(){
        mapper.addMappings(new PropertyMap< Contract, ContractResource>() {

            @Override
            protected void configure() {
                map().setOrganizerName(source.getOrganizer().getFirstName());
                map().setMusicianName(source.getMusician().getFirstName());
                map().setDistrictName(source.getDistrict().getName());
                map().setContractStateId(source.getContractState().id());
                map().setContractStateResponse(source.getContractState().response());
            }
        });
    }

    private ContractResource convertToResource(Contract entity)
    {
        return mapper.map(entity, ContractResource.class);
    }

    private Contract convertToEntity(SaveContractResource resource)
    {
        return mapper.map(resource, Contract.class);
    }
}

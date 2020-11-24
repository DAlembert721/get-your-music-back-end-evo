package com.astra.getyourmusic.service.contractService;

import com.astra.getyourmusic.model.contractSystem.Contract;
import com.astra.getyourmusic.model.contractSystem.ContractState;

import java.util.List;

public interface ContractService {
    Contract findContractById(Long id);
    List<Contract> getAllContractsByOrganizerId(Long organizerId);
    List<Contract> getAllContractsByMusicianId(Long musicianId);
    Contract save(Contract contract, Long organizerId, Long musicianId, Long districtId);
    Contract updateContractState(Long id, ContractState contractState);
    void deleteById(Long contractID);
}
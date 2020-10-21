package com.astra.getyourmusic.service.contractService.contractServiceImpl;

import com.astra.getyourmusic.model.contractSystem.ContractState;
import com.astra.getyourmusic.repository.contractRepository.ContractRepository;
import com.astra.getyourmusic.model.contractSystem.Contract;
import com.astra.getyourmusic.repository.locationsRepository.DistrictRepository;
import com.astra.getyourmusic.repository.userRepository.MusicianRepository;
import com.astra.getyourmusic.repository.userRepository.NotificationRepository;
import com.astra.getyourmusic.repository.userRepository.OrganizerRepository;
import com.astra.getyourmusic.service.contractService.ContractService;
import com.astra.getyourmusic.service.userService.userServiceImpl.ObserverImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {
    @Autowired
    private ContractRepository contractRepository;
    @Autowired
    private OrganizerRepository organizerRepository;
    @Autowired
    private MusicianRepository musicianRepository;
    @Autowired
    private DistrictRepository districtRepository;
    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Contract save(Contract contract, Long organizerId, Long musicianId, Long districtId) {
        Contract newContract = new Contract();
        newContract.setName(contract.getName());
        newContract.setOrganizer(organizerRepository.findById(organizerId).orElse(null));
        newContract.setMusician(musicianRepository.findById(musicianId).orElse(null));
        newContract.setDistrict(districtRepository.findById(districtId).orElse(null));
        newContract.setAddress(contract.getAddress());
        newContract.setReference(contract.getReference());
        newContract.setStartDate(contract.getStartDate());
        newContract.setEndDate(contract.getEndDate());
        newContract.setContractState(ContractState.UNANSWERED);
        newContract.addObserver(new ObserverImpl(this.notificationRepository));
        newContract.notifyObservers();

        return contractRepository.save(newContract);
    }

    @Override
    public Contract findContractById(Long id){
        return contractRepository.findContractById(id);
    }

    @Override
    public List<Contract> getAllContractsByOrganizerId(Long organizerId) {
        return contractRepository.findByOrganizerId(organizerId);
    }

    @Override
    public List<Contract> getAllContractsByMusicianId(Long musicianId) {
        return contractRepository.findByMusicianId(musicianId);
    }

    @Override
    public Contract updateContractState(Long id, ContractState contractState){
        Contract exist = contractRepository.findById(id).orElse(null);
        if(exist == null)
        {
            return null;
        }
        exist.setContractState(contractState);
        exist.addObserver(new ObserverImpl(this.notificationRepository));
        exist.notifyObservers();
        return contractRepository.save(exist);
    }

    @Override
    public void deleteById(Long contractID){
        contractRepository.deleteById(contractID);
    }
}
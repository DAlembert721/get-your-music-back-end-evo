package com.astra.getyourmusic.repository.contractRepository;

import com.astra.getyourmusic.model.contractSystem.Contract;
import com.astra.getyourmusic.model.contractSystem.ContractState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ContractRepository extends JpaRepository<Contract,  Long> {
    Contract findContractById(Long id);
    List<Contract> findByOrganizerId(Long organizerId);
    List<Contract> findByMusicianId(Long musicianId);
    void deleteById(Long id);
}

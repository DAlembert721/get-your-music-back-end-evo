package com.astra.getyourmusic;

import com.astra.getyourmusic.model.contractSystem.Contract;
import com.astra.getyourmusic.model.contractSystem.ContractState;
import com.astra.getyourmusic.service.contractService.ContractService;
import com.astra.getyourmusic.service.contractService.contractServiceImpl.ContractServiceImpl;
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
import java.util.Date;

@ExtendWith(SpringExtension.class)
public class ContractServiceImplUnitTests {

    @MockBean
    private ContractService contractServiceMock;

    @Autowired
    private ContractService contractService;

    @TestConfiguration
    static class ContractServiceImplTestConfiguration {
        @Bean
        public ContractService contractService() {
            return new ContractServiceImpl();
        }
    }

    @Test
    @DisplayName("When Create Contract With Correct Information Then Returns The Contract")
    public void whenCreateContractWithCorrectInformationThenReturnsTheContract() {

        //Arrange
        Contract newContract = new Contract();
        newContract.setId(1L);
        newContract.setName("contract");
        newContract.setOrganizer(null);
        newContract.setMusician(null);
        newContract.setDistrict(null);
        newContract.setAddress("address");
        newContract.setReference("reference");
        newContract.setStartDate(DateTime.now().toString());
        newContract.setEndDate(DateTime.now().toString());
        newContract.setContractState(ContractState.UNANSWERED);

        when(contractServiceMock.save(newContract, 1L, 1L, 1L))
                .thenReturn(newContract);

        //Act
        Contract contract = contractService.save(newContract, 1L, 1L, 1L);

        //Assert
        assertThat(contract).isEqualTo(newContract);

    }

    @Test
    @DisplayName("When Create Contract With Incorrect Information Then Returns A Bad Message")
    public void whenCreateContractWithIncorrectInformationThenReturnsABadMessage() {

        //Arrange
        Contract newContract = new Contract();
        newContract.setId(1L);
        newContract.setName("contract");
        newContract.setOrganizer(null);
        newContract.setMusician(null);
        newContract.setDistrict(null);
        newContract.setAddress("address");
        newContract.setReference("reference");

        String message = "This is a bad Message";

        when(contractServiceMock.save(newContract, 1L, 1L, 1L))
                .thenThrow(new RuntimeException(message));

        //Act
        Throwable exception = catchThrowable(() -> {
                Contract contract = contractService.save(newContract, 1L, 1L, 1L);
        });
        //Assert
        assertThat(exception)
                .hasMessage(message);
    }
}

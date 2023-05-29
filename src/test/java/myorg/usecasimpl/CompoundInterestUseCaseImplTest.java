package myorg.usecasimpl;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import myorg.dto.CompoundInterestRequest;
import myorg.dto.CompoundInterestResponse;
import myorg.usecase.CompoundInterestUseCase;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
class CompoundInterestUseCaseImplTest {
    @Inject
    CompoundInterestUseCase compoundInterestUseCase;

    private CompoundInterestRequest loadRequest(){
        CompoundInterestRequest request = CompoundInterestRequest.builder()
                    .capital(1000.0)
                    .taxaJuros(6.6)
                    .tempoInvestimento(1)
                .build();

        return request;
    }

    private CompoundInterestResponse buildResponse(){
        CompoundInterestResponse response = CompoundInterestResponse.builder()
                .jurosCompostos(66.0)
                .tempoInvestimento(1)
                .totalInvestimento(1066.0)
                .build();

        return response;
    }
    @Test
    void CompoundInterestTest(){
        CompoundInterestRequest request = this.loadRequest();
        CompoundInterestResponse buildResponse = this.buildResponse();
        //Calling test
        CompoundInterestResponse response = this.compoundInterestUseCase.compoundInterest(request);

        assertEquals(request.getTempoInvestimento(), response.getTempoInvestimento());

        request.setCapital(1066.0);
        assertEquals(request.getCapital(), response.getTotalInvestimento());
        assertEquals(66.0, response.getJurosCompostos());
    }
}

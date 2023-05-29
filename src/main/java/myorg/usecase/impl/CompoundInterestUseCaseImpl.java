package myorg.usecase.impl;

import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import myorg.dto.CompoundInterestRequest;
import myorg.dto.CompoundInterestResponse;
import myorg.usecase.CompoundInterestUseCase;

import java.text.DecimalFormat;
@Slf4j
@ApplicationScoped
public class CompoundInterestUseCaseImpl implements CompoundInterestUseCase {
    @Override
    public CompoundInterestResponse compoundInterest(CompoundInterestRequest jurosRequest) {
        log.info("[compoundInterest] - begin");
        CompoundInterestResponse calcularJuros = new CompoundInterestResponse();

        double totalInvestimento = 0.0;
        double totalJuros = 0.0;

        totalInvestimento = jurosRequest.getCapital() * Math.pow((1 + (jurosRequest.getTaxaJuros() / 100)), jurosRequest.getTempoInvestimento());
        totalJuros = totalInvestimento - jurosRequest.getCapital();

        DecimalFormat df_obj = new DecimalFormat("#.##");

        calcularJuros.setTotalInvestimento(Double.valueOf((df_obj.format(totalInvestimento))));
        calcularJuros.setJurosCompostos(Double.valueOf((df_obj.format(totalJuros))));
        calcularJuros.setTempoInvestimento(jurosRequest.getTempoInvestimento());

        log.info("[compoundInterest] - end");
        return calcularJuros;
    }

}

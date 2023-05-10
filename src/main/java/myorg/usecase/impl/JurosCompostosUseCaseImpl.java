package myorg.usecase.impl;

import jakarta.enterprise.context.ApplicationScoped;
import myorg.dto.JurosCompostosRequest;
import myorg.dto.JurosCompostosResponse;
import myorg.usecase.JurosCompostosUseCase;

@ApplicationScoped
public class JurosCompostosUseCaseImpl implements JurosCompostosUseCase {
    @Override
    public JurosCompostosResponse JurosCompostos(JurosCompostosRequest jurosRequest) {
        JurosCompostosResponse calcularJuros = new JurosCompostosResponse();

        double totalInvestimento = 0.0;
        double totalJuros = 0.0;

        totalInvestimento = jurosRequest.getCapital() * Math.pow((1 + (jurosRequest.getTaxaJuros() / 100)), jurosRequest.getTempoInvestimento());
        totalJuros = totalInvestimento - jurosRequest.getCapital();

        calcularJuros.setTotalInvestimento(totalInvestimento);
        calcularJuros.setJurosCompostos(totalJuros);
        calcularJuros.setTempoInvestimento(jurosRequest.getTempoInvestimento());

        return calcularJuros;
    }

}

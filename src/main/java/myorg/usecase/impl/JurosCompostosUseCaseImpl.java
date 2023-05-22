package myorg.usecase.impl;

import jakarta.enterprise.context.ApplicationScoped;
import myorg.dto.JurosCompostosRequest;
import myorg.dto.JurosCompostosResponse;
import myorg.usecase.JurosCompostosUseCase;

import java.text.DecimalFormat;

@ApplicationScoped
public class JurosCompostosUseCaseImpl implements JurosCompostosUseCase {
    @Override
    public JurosCompostosResponse jurosCompostos(JurosCompostosRequest jurosRequest) {
        JurosCompostosResponse calcularJuros = new JurosCompostosResponse();

        double totalInvestimento = 0.0;
        double totalJuros = 0.0;

        totalInvestimento = jurosRequest.getCapital() * Math.pow((1 + (jurosRequest.getTaxaJuros() / 100)), jurosRequest.getTempoInvestimento());
        totalJuros = totalInvestimento - jurosRequest.getCapital();

        DecimalFormat df_obj = new DecimalFormat("#.##");

        calcularJuros.setTotalInvestimento(Double.valueOf((df_obj.format(totalInvestimento))));
        calcularJuros.setJurosCompostos(Double.valueOf((df_obj.format(totalJuros))));
        calcularJuros.setTempoInvestimento(jurosRequest.getTempoInvestimento());

        return calcularJuros;
    }

}

package myorg.usecase;

import myorg.dto.JurosCompostosRequest;
import myorg.dto.JurosCompostosResponse;

public interface JurosCompostosUseCase {
    public JurosCompostosResponse jurosCompostos(JurosCompostosRequest jurosRequest);
}

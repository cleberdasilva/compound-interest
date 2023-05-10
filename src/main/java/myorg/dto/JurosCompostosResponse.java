package myorg.dto;

import io.quarkus.runtime.annotations.RegisterForReflection;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@RegisterForReflection
public class JurosCompostosResponse {
    private Double totalInvestimento;
    private Double jurosCompostos;
    private Integer tempoInvestimento;
}

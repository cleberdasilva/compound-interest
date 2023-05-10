package myorg.rest;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import myorg.dto.JurosCompostosRequest;
import myorg.usecase.JurosCompostosUseCase;

@Path("/compound-interest")
public class CompoundInterestRest {
	@Inject
	private JurosCompostosUseCase jurosCompostosUseCase;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response calcularJuros(@QueryParam("capital") Double capital, @QueryParam("taxaJuros") Double taxaJuros,
			@QueryParam("tempoInvestimento") Integer tempoInvestimento) {
		JurosCompostosRequest request = new JurosCompostosRequest();

		request.setCapital(capital);
		request.setTaxaJuros(taxaJuros);
		request.setTempoInvestimento(tempoInvestimento);

		return Response.ok(this.jurosCompostosUseCase.JurosCompostos(request)).build();
	}
}

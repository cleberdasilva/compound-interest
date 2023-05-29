package myorg.rest;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.http.ContentType;
import myorg.dto.CompoundInterestRequest;
import myorg.usecase.CompoundInterestUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@QuarkusTest
public class CompoundInterestRestTest {
    @InjectMock
    CompoundInterestUseCase compoundInterestUseCase;
    @Test
    void calculateInterest(){
        CompoundInterestRequest request = CompoundInterestRequest.builder().build();

        Mockito.when(compoundInterestUseCase.compoundInterest(any())).thenReturn(null);

        var httpResponse = given()
                    .contentType(ContentType.JSON)
                    .body(request)
                .when()
                    .post("/compound-interest")
                 .then()
                .extract()
                    .response();

        assertEquals(200, httpResponse.statusCode());
    }
}

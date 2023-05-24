package myorg.usecase;

import myorg.dto.CompoundInterestRequest;
import myorg.dto.CompoundInterestResponse;

public interface CompoundInterestUseCase {
    public CompoundInterestResponse compoundInterest(CompoundInterestRequest jurosRequest);
}

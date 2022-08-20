package uz.pd.click_full.service;


import uz.pd.click_full.payload.ApiResponse;
import uz.pd.click_full.payload.StatusDto;

public interface StatusService {
    ApiResponse addStatus(StatusDto dto);

    ApiResponse edetStatus(StatusDto dto, Long id);
}

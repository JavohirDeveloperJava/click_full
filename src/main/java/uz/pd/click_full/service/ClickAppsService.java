package uz.pd.click_full.service;


import uz.pd.click_full.payload.ApiResponse;
import uz.pd.click_full.payload.ClickAppsDto;

public interface ClickAppsService {
    ApiResponse addClickApps(ClickAppsDto dto);

    ApiResponse edetClickApps(Long id, ClickAppsDto dto);
}

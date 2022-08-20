package uz.pd.click_full.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import uz.pd.click_full.entity.ClickApps;
import uz.pd.click_full.payload.ApiResponse;
import uz.pd.click_full.payload.ClickAppsDto;
import uz.pd.click_full.repository.ClickAppsRepository;
import uz.pd.click_full.repository.IconRepository;
import uz.pd.click_full.service.ClickAppsService;


import java.util.Optional;

@Service
public class ClickAppsServiceImpl implements ClickAppsService {
    @Autowired
    ClickAppsRepository clickAppsRepository;

    @Autowired
    IconRepository iconRepository;

    @Override
    public ApiResponse addClickApps(ClickAppsDto dto) {
        if (clickAppsRepository.existsByName(dto.getName()))
            return new ApiResponse("Bunday clickApps mavjud", false);

        ClickApps clickApps = new ClickApps(
                dto.getName(),
                dto.getIconId()==null?null:iconRepository.findById(dto.getIconId()).orElseThrow(() -> new ResourceNotFoundException("Icon"))
        );
        clickAppsRepository.save(clickApps);
        return new ApiResponse("Saqlandi", true);
    }

    @Override
    public ApiResponse edetClickApps(Long id, ClickAppsDto dto) {
        Optional<ClickApps> optionalClickApps = clickAppsRepository.findById(id);
        if (!optionalClickApps.isPresent())
            return new ApiResponse("Bunday clickApps yo'q", false);
        ClickApps clickApps = optionalClickApps.get();
        clickApps.setName(dto.getName());
        clickApps.setIcon(dto.getIconId()==null?null:iconRepository.findById(dto.getIconId()).orElseThrow(() -> new ResourceNotFoundException("Icon")));
        clickAppsRepository.save(clickApps);
        return new ApiResponse("Edet qilindi", true);
    }
}

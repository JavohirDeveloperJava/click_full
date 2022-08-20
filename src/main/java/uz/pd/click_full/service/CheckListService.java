package uz.pd.click_full.service;



import uz.pd.click_full.payload.ApiResponse;
import uz.pd.click_full.payload.CheckListDto;
import uz.pd.click_full.payload.CheckListItemDto;

import java.util.UUID;

public interface CheckListService {
    ApiResponse addCheckList(CheckListDto dto);

    ApiResponse addCheckListItem(CheckListItemDto dto);

    ApiResponse addAssignCheckList(Long id, UUID userId);

    ApiResponse edetCheckList(CheckListDto dto, Long id);

    ApiResponse deleteCheckList(Long id);


    ApiResponse edetItemCheckList(CheckListItemDto dto, Long id);
}

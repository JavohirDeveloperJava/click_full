package uz.pd.click_full.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import uz.pd.click_full.payload.ApiResponse;


import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public interface AttachmentService {
    ApiResponse uploadFileSystem(MultipartHttpServletRequest request);


    void getSystemFile(HttpServletResponse response, UUID id) throws IOException;
}

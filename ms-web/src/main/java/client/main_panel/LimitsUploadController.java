package client.main_panel;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class LimitsUploadController {

    @RequestMapping(value = "limits_upload/validate_file", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String validateUploadedLimits(@RequestParam("uploadedLimits") MultipartFile multipartFile) {
        MultipartFile file = multipartFile;
        return null;
    }

}

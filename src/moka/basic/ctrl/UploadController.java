package moka.basic.ctrl;

import moka.basic.annotation.IgnoreSecurity;
import moka.basic.util.Util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by moka on 2017/5/2 0002.
 */
@Controller
@RequestMapping(value = "/upload")
public class UploadController extends BasicController {

    @Value("#{propertyConfigurer['data_upload_url']}")
    protected String uploadUrl;

    @Value("#{propertyConfigurer['data_root_path']}")
    protected String rootPath;

    @Value("#{propertyConfigurer['data_root_path_type']}")
    protected String rootPathType;

    @Value("#{propertyConfigurer['data_root_path_tmp']}")
    protected String rootPathTmp;

    @Value("#{propertyConfigurer['data_file_prefix']}")
    protected String prefixs;

    /**
     * 文件上传
     *
     * @return
     */
    @IgnoreSecurity
    @RequestMapping(value = "uploadPhoto.htm")
    @ResponseBody
    protected Object uploadPhoto(HttpServletRequest request) throws IOException {
        File dir = new File(rootPath + rootPathTmp);
        if (!dir.exists()) dir.mkdirs();
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        List<String> fileUrls = new ArrayList<>();
        for (String key : multipartRequest.getMultiFileMap().keySet()) {
            List<MultipartFile> f = multipartRequest.getMultiFileMap().get(key);
            for (MultipartFile m : f) {

                String uuid = Util.getTokenMd5();
                String fileUrl = dir.getAbsolutePath() + File.separator + uuid + ".";

                String prefix = getFilePrefix(m);
                File serverFile = new File(fileUrl + prefix);
                m.transferTo(serverFile);

                String url = uploadUrl + rootPathType + "/" + Util.dateFormat() + "/" + uuid + "." + prefix;

                fileUrls.add(url);
            }
        }
        return result(fileUrls);
    }

    /**
     * 获取文件后缀
     *
     * @param m
     * @return
     */
    public String getFilePrefix(MultipartFile m) {
        String fileName = m.getOriginalFilename();
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}

package moka.basic.service;

import moka.basic.exception.ConvertValueException;
import moka.basic.image.Exif;
import moka.basic.log4j.LoggerService;
import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by moka on 2017/3/6 0006.
 */
@Service("basicService")
public class BasicServiceImpl implements BasicService {

    @Value("#{propertyConfigurer['data_root_path']}")
    protected String rootPath;
    @Value("#{propertyConfigurer['data_root_path_tmp']}")
    protected String rootPathTmp;

    private Logger logger = LoggerService.getLogger(this.getClass());


    @Override
    public <T> T convertBusinessValue(Object resource, Class<T> target, String... ignoreProperties) {
        try {
            T t = target.newInstance();
            if (resource != null) {
                BeanUtils.copyProperties(resource, t, ignoreProperties);
            }
            return t;
        } catch (Exception e) {
            throw new ConvertValueException(e.getMessage(), e);
        }
    }

    @Override
    public <T> T convertBusinessValue(Object resource, Object target, String... ignoreProperties) {
        if (resource != null) {
            BeanUtils.copyProperties(resource, target, ignoreProperties);
        }
        return (T) target;
    }

    @Override
    public ArrayList<Exif> movePhoto(String[] urls) {
        ArrayList<Exif> array = new ArrayList<>();
        try {
            for (int i = 0; i < urls.length; i++) {
                Exif exif = new Exif();
                URL url = new URL(urls[i]);
                String path = url.getPath();
                String fileName = path.substring(path.lastIndexOf("/") + 1);
                String filePath = path.substring(0, path.lastIndexOf("/"));
                File f1 = new File(rootPath);
                File f2 = new File(rootPath + filePath);
                if (!f2.exists()) f2.mkdirs();
                File f3 = new File(f1.getAbsolutePath() + rootPathTmp + "/" + fileName);
                File f4 = new File(f2.getAbsolutePath() + "/" + fileName);
                if(!f4.isFile()){
                    if(!f3.renameTo(f4)) throw new Exception();
                }

                exif.setFilePath(f4.getAbsolutePath());
                exif.setPath(path);
                exif.setUrl(url.toString());

                array.add(exif);
            }
            return array;
        } catch (Exception e) {
            logger.debug("文件转移出错", e);
            e.printStackTrace();
        }

        return null;
    }
}

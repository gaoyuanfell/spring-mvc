package moka.basic.image;

import com.drew.imaging.ImageMetadataReader;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;

import java.io.File;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 获取图片EXIF信息
 * Created by moka on 2017/5/3 0003.
 */
public class ExifInfo {
    public static String getLngLat(String[] s) {
        BigDecimal s1 = new BigDecimal(s[0]);
        BigDecimal s2 = new BigDecimal(s[1]);
        BigDecimal s3 = new BigDecimal(s[2]);
        BigDecimal s4 = new BigDecimal("60.00");
        BigDecimal s5 = s2.add(s3.divide(s4, 5, BigDecimal.ROUND_UP)).divide(s4, 5, BigDecimal.ROUND_UP).add(s1);
        return s5.toString();
    }

    public static Exif analysisImg(Exif exif) {
        String reg = "°|'|\"";
        try {
            File file = new File(exif.getFilePath());
            Metadata metadata = ImageMetadataReader.readMetadata(file);
            for (Directory directory : metadata.getDirectories()) {

                if (directory.getName().equals("Exif IFD0")) {
                    for (Tag tag : directory.getTags()) {
                        String value = tag.getDescription();
                        switch (tag.getTagName()) {
                            case "Model":
                                exif.setModel(value);
                                break;
                            case "Make":
                                exif.setMake(value);
                                break;
                            case "Date/Time":
                                exif.setTime(new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse(value));
                                break;
                        }
                    }
                }

                if (directory.getName().equals("GPS")) {
                    for (Tag tag : directory.getTags()) {
                        String value = tag.getDescription();
                        switch (tag.getTagName()) {
                            case "GPS Longitude":
                                exif.setLongitude(value);
                                value = value.replaceAll(reg, "");
                                String[] s1 = value.split(" ");
                                exif.setLng(getLngLat(s1));
                                break;
                            case "GPS Latitude":
                                exif.setLatitude(value);
                                value = value.replaceAll(reg, "");
                                String[] s2 = value.split(" ");
                                exif.setLat(getLngLat(s2));
                                break;
                        }
                    }
                }

                if (directory.getName().equals("File")) {
                    for (Tag tag : directory.getTags()) {
                        String value = tag.getDescription();
                        switch (tag.getTagName()) {
                            case "File Name":
                                exif.setFileName(value);
                                break;
                            case "File Size":
                                exif.setFileSize(Integer.valueOf(value.split(" ")[0]));
                                break;
                        }
                    }
                }

                if (directory.getName().equals("JPEG") || directory.getName().equals("PNG-IHDR")) {
                    for (Tag tag : directory.getTags()) {
                        String value = tag.getDescription();
                        switch (tag.getTagName()) {
                            case "Image Height":
                                exif.setHeight(Integer.valueOf(value.split(" ")[0]));
                                break;
                            case "Image Width":
                                exif.setWidth(Integer.valueOf(value.split(" ")[0]));
                                break;
                        }
                    }
                }
            }
            return exif;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}

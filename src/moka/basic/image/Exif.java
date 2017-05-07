package moka.basic.image;

/**
 * [JPEG] - Compression Type = Baseline
 * [JPEG] - Data Precision = 8 bits
 * [JPEG] - Image Height = 3120 pixels
 * [JPEG] - Image Width = 4160 pixels
 * [JPEG] - Number of Components = 3
 * [JPEG] - Component 1 = Y component: Quantization table 0, Sampling factors 2 horiz/2 vert
 * [JPEG] - Component 2 = Cb component: Quantization table 1, Sampling factors 1 horiz/1 vert
 * [JPEG] - Component 3 = Cr component: Quantization table 1, Sampling factors 1 horiz/1 vert
 * [Exif IFD0] - Date/Time = 2017:05:04 00:09:43
 * [Exif IFD0] - Model = Smartisan T2
 * [Exif IFD0] - YCbCr Positioning = Center of pixel array
 * [Exif IFD0] - Resolution Unit = Inch
 * [Exif IFD0] - Y Resolution = 72 dots per inch
 * [Exif IFD0] - X Resolution = 72 dots per inch
 * [Exif IFD0] - Make = Smartisan
 * [GPS] - GPS Date Stamp = 2017:05:03
 * [GPS] - GPS Altitude Ref = Unknown (2)
 * [GPS] - GPS Longitude Ref = E
 * [GPS] - GPS Img Direction = 356 degrees
 * [GPS] - GPS Longitude = 121° 15' 18.07"
 * [GPS] - GPS Processing Method = ASCII
 * [GPS] - GPS Latitude Ref = N
 * [GPS] - GPS Img Direction Ref = Magnetic direction
 * [GPS] - GPS Time-Stamp = 16:09:43.000 UTC
 * [GPS] - GPS Altitude = 0 metres
 * [GPS] - GPS Latitude = 31° 7' 8.19"
 * [Exif SubIFD] - Color Space = sRGB
 * [Exif SubIFD] - Date/Time Digitized = 2017:05:04 00:09:43
 * [Exif SubIFD] - F-Number = f/2.0
 * [Exif SubIFD] - Focal Length = 3.8 mm
 * [Exif SubIFD] - Aperture Value = f/2.0
 * [Exif SubIFD] - Exposure Mode = Auto exposure
 * [Exif SubIFD] - Sub-Sec Time Digitized = 355196
 * [Exif SubIFD] - Exif Image Height = 3120 pixels
 * [Exif SubIFD] - Focal Length 35 = 28 mm
 * [Exif SubIFD] - Max Aperture Value = f/2.0
 * [Exif SubIFD] - Scene Capture Type = Standard
 * [Exif SubIFD] - Scene Type = Directly photographed image
 * [Exif SubIFD] - Sub-Sec Time Original = 355196
 * [Exif SubIFD] - Exposure Program = Program normal
 * [Exif SubIFD] - White Balance Mode = Auto white balance
 * [Exif SubIFD] - Exif Image Width = 4160 pixels
 * [Exif SubIFD] - Sub-Sec Time = 355196
 * [Exif SubIFD] - Shutter Speed Value = 1/9 sec
 * [Exif SubIFD] - Metering Mode = Center weighted average
 * [Exif SubIFD] - Date/Time Original = 2017:05:04 00:09:43
 * [Exif SubIFD] - Components Configuration = YCbCr
 * [Exif SubIFD] - Flash = Flash did not fire, auto
 * [Exif SubIFD] - Exif Version = 2.20
 * [Exif SubIFD] - Exposure Bias Value = 0 EV
 * [Exif SubIFD] - Brightness Value = -81/50
 * [Exif SubIFD] - ISO Speed Ratings = 400
 * [Exif SubIFD] - Sensing Method = One-chip color area sensor
 * [Exif SubIFD] - FlashPix Version = 1.00
 * [Exif SubIFD] - Makernote = [58 values]
 * [Exif SubIFD] - Exposure Time = 0.1 sec
 * [Interoperability] - Interoperability Index = Recommended Exif Interoperability Rules (ExifR98)
 * [Interoperability] - Interoperability Version = 1.00
 * [Exif Thumbnail] - Y Resolution = 72 dots per inch
 * [Exif Thumbnail] - Thumbnail Length = 13172 bytes
 * [Exif Thumbnail] - Thumbnail Offset = 1127 bytes
 * [Exif Thumbnail] - Compression = JPEG (old-style)
 * [Exif Thumbnail] - Resolution Unit = Inch
 * [Exif Thumbnail] - X Resolution = 72 dots per inch
 * [Huffman] - Number of Tables = 4 Huffman tables
 * [File] - File Name = 微信图片_20170504001054.jpg
 * [File] - File Size = 6567157 bytes
 * [File] - File Modified Date = 星期四 五月 04 00:11:06 +08:00 2017
 * Created by moka on 2017/5/4 0004.
 */

import java.util.Date;

/**
 * 图片exif信息
 */
public class Exif {
    private Integer height;//高
    private Integer width;//宽
    private Date time;//创建时间
    private String model;//手机型号
    private String make;//手机厂商
    private String longitude;//经度
    private String latitude;//纬度
    private String fileName;//文件名称
    private Integer fileSize;//文件大小
    private String fileType;//文件类型
    private String lng;
    private String lat;
    private String url;//线上地址
    private String path;
    private String filePath;//本地储存地址

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getFileSize() {
        return fileSize;
    }

    public void setFileSize(Integer fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}

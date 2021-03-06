package moka.basic.util;

import moka.basic.exception.BusinessRuntimeException;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by moka on 2017/4/25 0025.
 */
public class Util {

    public static String getTokenMd5() {
        BigDecimal time = BigDecimal.valueOf(System.currentTimeMillis());
        BigDecimal random = BigDecimal.valueOf(Math.floor(Math.random() * 1000));
        BigDecimal t = time.add(random);
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(t.toString().getBytes());
            return new BigInteger(1, md5.digest()).toString(16);
        } catch (Exception e) {
            throw new BusinessRuntimeException(e.getMessage(), e);
        }
    }

    public static String dateFormat(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date());
    }

    public static String dateFormat(Date d){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(d);
    }
}

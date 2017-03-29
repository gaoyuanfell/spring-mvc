package moka.basic.log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.RollingFileAppender;

/**
 * Created by moka on 2017/3/29 0029.
 */
public class LoggerService {
    public static Logger getLogger(Class c) {
        return Logger.getLogger(c.getName());
    }
}

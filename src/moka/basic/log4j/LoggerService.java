package moka.basic.log4j;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/**
 * Created by moka on 2017/3/29 0029.
 */
public class LoggerService {
    public static Logger getLogger(Class c) {
        return LogManager.getLogger(c);
    }
}

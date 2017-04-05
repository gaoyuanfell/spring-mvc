package moka.basic.log4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by moka on 2017/3/29 0029.
 */
public class LoggerService {
    public static Logger getLogger(Class c) {
        return LoggerFactory.getLogger(c);
    }
}

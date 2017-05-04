package moka.basic.service;

import moka.basic.image.Exif;

import java.util.ArrayList;

/**
 * Created by moka on 2017/3/6 0006.
 */
public interface BasicService {

    <T> T convertBusinessValue(Object resource, Class<T> target, String... ignoreProperties);

    <T> T convertBusinessValue(Object resource, Object target, String... ignoreProperties);

    ArrayList<Exif> movePhoto(String[] urls);
}

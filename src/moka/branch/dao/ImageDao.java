package moka.branch.dao;

import moka.basic.dao.BasicDao;
import moka.branch.bo.Image;
import moka.branch.to.ImageTo;
import org.springframework.stereotype.Repository;

/**
 * Created by moka on 2017/5/4 0004.
 */
@Repository("imageDao")
public interface ImageDao extends BasicDao<Image, ImageTo> {

}

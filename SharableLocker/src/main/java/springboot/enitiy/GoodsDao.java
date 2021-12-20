package springboot.enitiy;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 04181026 Chen Yuwen
 * @date 2021-05-19 12:20
 */

@Repository
@Mapper
public interface GoodsDao {
    @Select("SELECT  `barcode`,`Gname`,`price`,`rest`,`Memo`FROM `shop`.`goods`LIMIT 0, 1000;")
    List<Goods> getAllGoods();
}

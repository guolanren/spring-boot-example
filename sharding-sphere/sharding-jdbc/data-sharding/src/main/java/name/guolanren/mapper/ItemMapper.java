package name.guolanren.mapper;

import name.guolanren.model.Item;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @author guolanren
 */
@Mapper
public interface ItemMapper {

    @Select("SELECT i.* FROM t_order o JOIN t_order_item i ON o.order_id = i.order_id WHERE o.user_id = #{userId} AND o.order_id = #{orderId}")
    Set<Item> list(@Param("userId") Long userId, @Param("orderId") Long orderId);

}

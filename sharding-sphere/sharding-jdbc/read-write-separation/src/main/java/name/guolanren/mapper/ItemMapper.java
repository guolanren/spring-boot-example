package name.guolanren.mapper;

import name.guolanren.model.Item;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.Set;

/**
 * @author guolanren
 */
@Mapper
public interface ItemMapper {

    @Insert("INSERT INTO t_order(order_id, user_id) VALUES(#{orderId} , #{user_id}) ")
    void createOrder(@Param("orderId") Long orderId, @Param("user_id") Long userId);

    @Insert("INSERT INTO t_order_item(order_id, `name`) VALUES(#{orderId} , #{name}) ")
    void createItem(@Param("orderId") Long orderId, @Param("name") String name);

    @Select("SELECT i.* FROM t_order o JOIN t_order_item i ON o.order_id = i.order_id WHERE o.user_id = #{userId} AND o.order_id = #{orderId}")
    Set<Item> list(@Param("userId") Long userId, @Param("orderId") Long orderId);

}

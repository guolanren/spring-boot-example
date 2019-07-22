package name.guolanren.util;

import name.guolanren.common.JpaConstant;
import org.springframework.data.domain.Sort;

/**
 * @author guolanren
 */
public class JpaUtil {

    public static Sort.Order[] generateOrders(String... sorts) {
        Sort.Order[] orders = new Sort.Order[sorts.length];
        for (int i = 0; i < sorts.length; i++) {
            orders[i] = sorts[i].startsWith(JpaConstant.UNORDER_PREFFIX) ?
                    new Sort.Order(Sort.Direction.DESC, sorts[i].replace(JpaConstant.UNORDER_PREFFIX, JpaConstant.EMPTY_STRING)) :
                    new Sort.Order(Sort.Direction.ASC, sorts[i]);
        }
        return orders;
    }

}

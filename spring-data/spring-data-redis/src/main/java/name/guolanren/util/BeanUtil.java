package name.guolanren.util;

import org.springframework.beans.BeanUtils;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * @author guolanren
 */
public class BeanUtil extends BeanUtils {

    /**
     * 获取目标类实例中value为空的field字符串数组
     *
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String[] getNullFieldNames(T t) {
        Set<String> fieldNames = new HashSet<>();
        Field[] fields = t.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            fields[i].setAccessible(true);
            try {
                if (fields[i].get(t) == null) {
                    fieldNames.add(fields[i].getName());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return fieldNames.toArray(new String[fieldNames.size()]);
    }

}

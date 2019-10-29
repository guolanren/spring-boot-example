package name.guolanren.mapper;

import name.guolanren.model.Pc;

import java.util.List;

/**
 * @author guolanren
 */
public interface PcMapper {

    List<Pc> getByBelongTo(Long belongTo);

}

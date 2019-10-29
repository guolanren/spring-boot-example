package name.guolanren.mapper;

import name.guolanren.model.Language;

/**
 * @author guolanren
 */
public interface LanguageMapper {

    Language getByUserId(Long uid);

}

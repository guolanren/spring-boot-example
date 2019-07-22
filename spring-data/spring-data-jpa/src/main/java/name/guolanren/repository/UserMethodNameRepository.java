package name.guolanren.repository;

import name.guolanren.entity.User;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author guolanren
 */
public interface UserMethodNameRepository extends Repository<User, Long> {

    List<User> findAll();

    List<User> findByName(String name);

    List<User> findByAge(Integer age);

    List<User> findByNameAndAge(String name, Integer age);

    List<User> findByNameOrAge(String name, Integer age);

}

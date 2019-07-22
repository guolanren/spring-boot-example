package name.guolanren.repository;

import name.guolanren.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * @author guolanren
 */
public interface UserQueryAnnotationRepository extends Repository<User, Long> {

    @Query("select u from User u where u.name = ?1")
    List<User> findAllByName(String name);

    @Query(value = "select * from user where name = ?1", nativeQuery = true)
    List<User> findAllByNameNative(String name);

    @Query("select u from User u where u.name like :name%")
    List<User> findAllByNameStartsWith(@Param("name") String name);

    @Query("select u from User u")
    List<User> findAllAndOrder(Sort sort);

    @Query(value = "select * from user", nativeQuery = true)
    List<User> findAllAndOrderNative(Pageable pageable);

    @Query("select u from #{#entityName} u")
    List<User> findAll();

    @Query("update User u set u.name = :name where u.id = :id")
    @Modifying
    void update(@Param("id") Long id, @Param("name") String name);

}

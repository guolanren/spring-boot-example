package name.guolanren.repository;

import name.guolanren.entity.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.scheduling.annotation.Async;

import java.util.List;
import java.util.concurrent.Future;
import java.util.stream.Stream;

/**
 * @author guolanren
 */
public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User, Long> {

    List<User> findFirst3By();

    List<User> findTop3By();

    @Query("select u from User u")
    Slice<User> findAllToSlice(Pageable pageable);

    @Query("select u from User u")
    Stream<User> findAllToStream(Pageable pageable);

    @Async
    Future<List<User>> findAllByName(String name);
}

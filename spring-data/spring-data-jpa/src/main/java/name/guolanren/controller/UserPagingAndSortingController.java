package name.guolanren.controller;

import name.guolanren.repository.UserPagingAndSortingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author guolanren
 */
@RestController
@RequestMapping("/pas")
public class UserPagingAndSortingController {

    @Autowired
    private UserPagingAndSortingRepository userPagingAndSortingRepository;

    @GetMapping("/findAllSorting")
    public Object findAllsorting() {
        return userPagingAndSortingRepository.findAll(Sort.by(
                new Sort.Order(Sort.Direction.ASC, "name"),
                new Sort.Order(Sort.Direction.DESC, "age")
        ));
    }

    @GetMapping("/findAllPaging")
    public Object findAllPaging(@RequestParam Integer page, @RequestParam Integer size) {
        return userPagingAndSortingRepository.findAll(PageRequest.of(page, size));
    }

    @GetMapping("/findAllPagingAndSorting")
    public Object findAllPagingAndSorting(@RequestParam Integer page, @RequestParam Integer size) {
        return userPagingAndSortingRepository.findAll(
                PageRequest.of(page, size,
                        Sort.by(
                                new Sort.Order(Sort.Direction.ASC, "name"),
                                Sort.Order.desc("age")
                        )));
    }

    @GetMapping("/findAllToSlice")
    public Object findAllToSlice(@RequestParam Integer page, @RequestParam Integer size) {
        return userPagingAndSortingRepository.findAllToSlice(PageRequest.of(page, size));
    }

    @GetMapping("/findAllToStream")
    @Transactional(rollbackFor = Exception.class)
    public Object findAllToStream(@RequestParam Integer page, @RequestParam Integer size) {
        userPagingAndSortingRepository.findAllToStream(PageRequest.of(page, size)).forEach(user -> System.out.println(user.getId()));
        return "finish";
    }

    @GetMapping("/findAllByNameToFuture")
    public Object findAllByNameToFuture(@RequestParam String name) {
        return userPagingAndSortingRepository.findAllByName(name);
    }

    @GetMapping("/findFirst3")
    public Object findFirst3() {
        return userPagingAndSortingRepository.findFirst3By();
    }

    @GetMapping("/findTop3")
    public Object findTop3() {
        return userPagingAndSortingRepository.findTop3By();
    }
}

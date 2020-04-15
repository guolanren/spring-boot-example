package name.guolanren.controller;

import name.guolanren.group.CreateValidationGroup;
import name.guolanren.group.ModifyValidationGroup;
import name.guolanren.group.SearchValidationGroup;
import name.guolanren.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.groups.Default;

/**
 * @author guolanren
 */
@RestController
@Validated
public class ValidateController {

    @GetMapping("/search")
    public ResponseEntity<String> search(@NotBlank String name) {
        return ResponseEntity.ok("success");
    }

    @PostMapping("/add")
    public ResponseEntity<String> add(@RequestBody
                                      @Validated(value = {CreateValidationGroup.class, Default.class}) User user) {
        return ResponseEntity.ok("success");
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modify(@RequestBody
                                         @Validated(value = {ModifyValidationGroup.class, Default.class}) User user) {
        return ResponseEntity.ok("success");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@NotNull @Positive Long id) {
        return ResponseEntity.ok("success");
    }
}

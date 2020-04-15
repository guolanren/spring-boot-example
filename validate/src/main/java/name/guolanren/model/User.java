package name.guolanren.model;

import name.guolanren.group.CreateValidationGroup;
import name.guolanren.group.ModifyValidationGroup;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.*;
import java.io.Serializable;

/**
 * @author guolanren
 */
public class User implements Serializable {

    private static final long serialVersionUID = 444782163087923223L;

    @Positive
    @NotNull(groups = {ModifyValidationGroup.class})
    private Long id;

    @NotBlank(groups = {CreateValidationGroup.class})
    private String name;

    @NotNull(groups = {CreateValidationGroup.class})
    @Range(min = 1, max = 120)
    private Short age;

    @NotBlank(groups = {CreateValidationGroup.class})
    @Pattern(message = "性别只支持男、女", regexp = "男|女")
    private String gender;

    public User() {
    }

    public User(Long id, String name, Short age, String gender) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }
}

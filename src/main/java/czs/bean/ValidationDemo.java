package czs.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class ValidationDemo {


    private Integer id;

    @Length(min = 4, max = 8, message = "用户名长度要求在{min}-{max}之间")
    @NotNull(message = "用户名不可为空")
    private String username;

    @Email(message = "邮箱格式错误")
    private String email;

    @Past(message = "出生日期错误")
    private Date birthday;

    @Min(value = 18, message = "未成年不满足注册要求")
    @Max(value = 80, message = "年龄错误")
    private Integer age;

    @Range(min = 0, max = 1, message = "性别选择错误")
    private Integer sex;


}

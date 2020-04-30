package czs.bean;

import lombok.Data;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * 分组校验数据
 */
@Data
public class UserEntity implements Serializable {

    //定义分组
    public interface AddGroup {
    }

    public interface UpdateGroup {
    }

    private static final long serialVersionUID = -7375937748809705055L;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户名
     */
    @NotBlank(message = "用户名不能为空", groups = {AddGroup.class})
    private String username;

    /**
     * 邮箱
     */
    @Email(message = "邮箱格式不正确", groups = {AddGroup.class, UpdateGroup.class})
    private String email;

    @Min(value = 18, message = "未成年不能注册")
    private Integer age;

    /**
     * 手机号
     */
    @NotNull(message = "手机号不能为空")
    private String mobile;

}

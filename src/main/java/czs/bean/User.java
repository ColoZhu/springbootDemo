package czs.bean;

import lombok.Data;

import java.util.Date;

@Data
public class User {

    private String uid;
    private String name;
    private Integer age;
    private Date birthday;


}

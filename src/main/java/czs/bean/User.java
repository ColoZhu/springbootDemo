package czs.bean;

import lombok.Data;

import java.util.Date;

@Data
public class User {
    private String uid;
    private String name;
    private Integer age;
    private Date birthday;

    private int yellowFlag; //0表示不高亮,1表示高亮

}

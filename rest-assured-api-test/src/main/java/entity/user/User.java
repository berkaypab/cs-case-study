package entity.user;

import lombok.Data;

@Data
public class User {
    private String email;
    private String password;
    private int statusCode;

}

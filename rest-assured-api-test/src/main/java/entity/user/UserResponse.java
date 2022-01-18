package entity.user;

import lombok.Data;

@Data
public class UserResponse {
    private String accessToken;
    private int statusCode;
    private String message;
    private String error;
}

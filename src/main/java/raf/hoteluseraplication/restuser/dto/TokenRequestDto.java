package raf.hoteluseraplication.restuser.dto;

/**
 * Created on 14.01.2022. by Andrija inside package raf.hoteluseraplication.restuser.dto.
 */
public class TokenRequestDto {
    private String email;
    private String password;

    public TokenRequestDto() {
    }

    public TokenRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

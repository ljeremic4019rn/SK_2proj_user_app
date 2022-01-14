package raf.hoteluseraplication.restuser.dto;

/**
 * Created on 14.01.2022. by Andrija inside package raf.hoteluseraplication.restuser.dto.
 */
public class TokenResponseDto {
    private String token;

    public TokenResponseDto() {
    }

    public TokenResponseDto(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

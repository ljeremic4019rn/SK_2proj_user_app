package raf.hoteluseraplication;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import raf.hoteluseraplication.restuser.tableComponents.UserInfoHolder;

import java.util.ArrayList;

public class TokenParser {


    public TokenParser(){
    }

    public UserInfoHolder parseToken (String token){
        UserInfoHolder userInfoHolder = new UserInfoHolder();
        System.out.println("parsiramo " + token);
        //{"id":2,
        // "role":"ROLE_CLIENT"
        // "username":"string"
        // "firstname":"string"
        // "lastname":"string"
        // "email":"mail"}

        String [] parseByComma = token.split(",");
        String [] tmp;
        String [] tmp2;
        Long id;
        ArrayList<String> elementi = new ArrayList<>();


        for (int i = 0; i < parseByComma.length; i++) {
            tmp = parseByComma[i].split(":");
            if (tmp[1].contains("\"")){
                tmp2 = tmp[1].split("\"");
                elementi.add(tmp2[1]);
            }
            else{
                elementi.add(tmp[1]);
            }
        }


        userInfoHolder.setId(Long.parseLong(elementi.get(0)));
        userInfoHolder.setRole(elementi.get(1));
        userInfoHolder.setUsername(elementi.get(2));
        userInfoHolder.setFirstname(elementi.get(3));
        userInfoHolder.setLastname(elementi.get(4));
        userInfoHolder.setEmail(elementi.get(5));


        return userInfoHolder;
    }

}

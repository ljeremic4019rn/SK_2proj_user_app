package raf.hoteluseraplication.restuser;

import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import raf.hoteluseraplication.restuser.dto.*;

import java.io.IOException;

/**
 * Created on 14.01.2022. by Andrija inside package raf.hoteluseraplication.restuser.
 */
public class UserServiceRESTClient {

    public static final String URL = "http://localhost:8080/api";

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    OkHttpClient user = new OkHttpClient();
    OkHttpClient manager = new OkHttpClient();
    OkHttpClient client = new OkHttpClient();
    ObjectMapper objectMapper = new ObjectMapper();

    public String login(String email, String password) throws IOException {

        // ruta login prihvata samo TokenRequestDto, zato treba da se napravi
        TokenRequestDto tokenRequestDto = new TokenRequestDto(email, password);
        // pretvaramo TokenRequestDto u formatu JSON
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(tokenRequestDto));

        Request request = new Request.Builder()
                .url(URL + "/user/login") // URL koji gadjamo
                .post(body) // saljemo JSON kao body (username, password)
                .build();

        Call call = user.newCall(request);

        Response response = call.execute();

        // ako je login vratio 200, deserijalizujemo i dobijamo TokenResponseDto koji sadrzi token, koji vracamo u View da ga pamtimo
        if (response.code() == 200) {
            String json = response.body().string();
            TokenResponseDto dto = objectMapper.readValue(json, TokenResponseDto.class);
            return dto.getToken();
        }

        throw new RuntimeException("Invalid email or password");
    }

    public void registerManager(ManagerCreateDto managerCreateDto) throws IOException{
        System.out.println(managerCreateDto.getUsername());
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(managerCreateDto));

        Request request = new Request.Builder()
                .url(URL + "/manager/register") // URL koji gadjamo
                .post(body) // saljemo JSON kao body (username, password)
                .build();

        Call call = manager.newCall(request);

        Response response = call.execute();

        // ako je login vratio 200, deserijalizujemo i dobijamo TokenResponseDto koji sadrzi token, koji vracamo u View da ga setuje globalno
        if (response.code() == 201) {
            String json = response.body().string();
            TokenResponseDto dto = objectMapper.readValue(json, TokenResponseDto.class);
        }
    }

    public void registerClient(ClientCreateDto clientCreateDto) throws IOException {
        System.out.println(clientCreateDto.getUsername());

        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(clientCreateDto));

        Request request = new Request.Builder()
                .url(URL + "/client/register") // URL koji gadjamo
                .post(body) // saljemo JSON kao body (username, password)
                .build();

        Call call = client.newCall(request);

        Response response = call.execute();

        // ako je login vratio 200, deserijalizujemo i dobijamo TokenResponseDto koji sadrzi token, koji vracamo u View da ga pamtimo
        if (response.code() == 201) {
            String json = response.body().string();
            ClientDto dto = objectMapper.readValue(json, ClientDto.class);
        }


    }

}

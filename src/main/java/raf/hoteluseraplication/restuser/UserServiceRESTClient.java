package raf.hoteluseraplication.restuser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;
import raf.hoteluseraplication.HotelUserApplication;
import raf.hoteluseraplication.restuser.dto.*;
import raf.hoteluseraplication.restuser.dto.notificationDtos.UserPasswordDto;


import java.io.IOException;
import java.util.List;

/**
 * Created on 14.01.2022. by Andrija inside package raf.hoteluseraplication.restuser.
 */
public class UserServiceRESTClient {

    public static final String URL = "http://localhost:8080/api";

    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");

    private OkHttpClient user = new OkHttpClient();
    private ObjectMapper objectMapper = new ObjectMapper();

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

        Call call = user.newCall(request);

        Response response = call.execute();

    }

    public void registerClient(ClientCreateDto clientCreateDto) throws IOException {
        System.out.println(clientCreateDto.getUsername());
        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(clientCreateDto));

        System.out.println(body);

        Request request = new Request.Builder()
                .url(URL + "/client/register") // URL koji gadjamo
                .post(body) // saljemo JSON kao body (username, password)
                .build();

        Call call = user.newCall(request);

        Response response = call.execute();

        // ako je login vratio 200, deserijalizujemo i dobijamo TokenResponseDto koji sadrzi token, koji vracamo u View da ga pamtimo
        if (response.code() == 201) {
            String json = response.body().toString();
//            ClientDto dto = objectMapper.readValue(json, ClientDto.class);
            System.out.println(json);
        }
    }

//    public void banUser(Long id) throws IOException {
//        String token = HotelUserApplication.getInstance().getToken();
//        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(id));
//
//        Request request = new Request.Builder()
//                .url(URL + String.format("/user/%d/ban_unban", id)) // URL koji gadjamo
//                .put(body)
//                .header("Authorization", "Bearer " + token)
//                .build();
//        Call call = user.newCall(request);
//
//        Response response = call.execute();
//
//        if (response.code() == 200) {
//            String json = response.body().string();
//        } else {
//            throw new RuntimeException();
//        }
//    }

    public RankListDto getRanks() throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        Request request = new Request.Builder()
                .url(URL + "/user/rank")
                .header("Authorization", "Bearer " + HotelUserApplication.getInstance().getToken())
                .get()
                .build();

        Call call = user.newCall(request);

        Response response = call.execute();
        System.out.println(response.code());
        if (response.code() == 200) {
            String json = response.body().string();

            return objectMapper.readValue(json, RankListDto.class);
        }

        throw new RuntimeException();
    }

    public void changePassword(Long id, UserPasswordDto userPasswordDto) throws IOException {

        RequestBody body = RequestBody.create(JSON, objectMapper.writeValueAsString(userPasswordDto));

        Request request = new Request.Builder()
                .url(URL + String.format("/user/%d/changePassword", id))
                .header("Authorization", "Bearer " + HotelUserApplication.getInstance().getToken())
                .put(body)
                .build();

        Call call = user.newCall(request);

        Response response = call.execute();

//        if (response.code() == 200) {
//            String json = response.body().string();
//        }
//        else
//            throw new RuntimeException();
    }
}

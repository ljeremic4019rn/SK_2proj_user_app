package raf.hoteluseraplication.restuser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.*;

import java.io.IOException;

/**
 * Created on 14.01.2022. by Andrija inside package raf.hoteluseraplication.restuser.
 */
public class NotificationServiceRESTClient {

    public static final String URL = "http://localhost:8081/api";

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");

    private ObjectMapper objectMapper = new ObjectMapper();
    private OkHttpClient user = new OkHttpClient();


//    public NotificationListDto getNotificationsByEmail(String email) throws IOException {
//        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        JavaTimeModule module = new JavaTimeModule();
//        objectMapper.registerModule(module);
//        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//
//
//        Request request = new Request.Builder()
//                .url(URL + String.format("/notification/filter/email=%s", email))
//                .header("Authorization", "Bearer " + HotelClientApplication.getInstance().getToken())
//                .get()
//                .build();
//
//        Call call = client.newCall(request);
//
//        Response response = call.execute();
//
//        if (response.code() == 200) {
//            String json = response.body().string();
//
//
//            return objectMapper.readValue(json, Page.class);
//        }
//        throw new RuntimeException();
//    }

}

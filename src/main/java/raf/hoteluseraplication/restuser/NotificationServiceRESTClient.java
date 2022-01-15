package raf.hoteluseraplication.restuser;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import okhttp3.*;
import raf.hoteluseraplication.HotelUserApplication;
import raf.hoteluseraplication.restuser.tableComponents.NotificationListDto;

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


    public NotificationListDto getActivationNotificationsByEmail(String email) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JavaTimeModule module = new JavaTimeModule();
        objectMapper.registerModule(module);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        System.out.println("kupimo mailove");

        Request request = new Request.Builder()
                .url(URL + String.format("/notification/sort/email_%s", email))
                .header("Authorization", "Beareri " + HotelUserApplication.getInstance().getToken())
                .get()
                .build();

        Call call = user.newCall(request);

        Response response = call.execute();

        if (response.code() == 200) {
            String json = response.body().string();

            System.out.println(json);


            return objectMapper.readValue(json, NotificationListDto.class);
        }
        throw new RuntimeException();
    }

    public NotificationListDto getNotificationsBetweenDates(String startDate,String endDate) throws IOException {
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JavaTimeModule module = new JavaTimeModule();
        objectMapper.registerModule(module);
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        Request request = new Request.Builder()
                .url(URL + String.format("/sort/between_%s&%s", startDate,endDate))
                .header("Authorization", "Bearer " + HotelUserApplication.getInstance().getToken())
                .get()
                .build();

        Call call = user.newCall(request);

        Response response = call.execute();

        if (response.code() == 200) {
            String json = response.body().string();


            return objectMapper.readValue(json, NotificationListDto.class);
        }
        throw new RuntimeException();
    }

}

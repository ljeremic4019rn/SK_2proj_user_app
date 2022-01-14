package raf.hoteluseraplication.restuser;

import okhttp3.MediaType;

/**
 * Created on 14.01.2022. by Andrija inside package raf.hoteluseraplication.restuser.
 */
public class NotificationServiceRESTClient {

    public static final String URL = "http://localhost:8081/api";

    public static final MediaType JSON
            = MediaType.get("application/json; charset=utf-8");
}

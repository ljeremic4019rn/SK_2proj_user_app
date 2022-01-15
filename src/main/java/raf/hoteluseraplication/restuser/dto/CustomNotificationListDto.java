package raf.hoteluseraplication.restuser.dto;

import raf.hoteluseraplication.restuser.tableComponents.NotificationDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 15.01.2022. by Andrija inside package raf.hoteluseraplication.restuser.dto.
 */
public class CustomNotificationListDto {
    List<CustomNotificationDto> content = new ArrayList<>();

    public CustomNotificationListDto() {
    }


    public List<CustomNotificationDto> getContent() {
        return content;
    }

    public void setContent(List<CustomNotificationDto> content) {
        this.content = content;
    }
}

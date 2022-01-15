package raf.hoteluseraplication.restuser.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import raf.hoteluseraplication.restuser.tableComponents.NotificationDto;

/**
 * Created on 15.01.2022. by Andrija inside package raf.hoteluseraplication.restuser.dto.
 */
public class ActivationNotifDto {
    private Long id;
    private String activationLink;
    @JsonProperty("notification")
    private NotificationDto notificationDto;

    public String getActivationLink() {
        return activationLink;
    }

    public void setActivationLink(String activationLink) {
        this.activationLink = activationLink;
    }

    public NotificationDto getNotificationDto() {
        return notificationDto;
    }

    public void setNotificationDto(NotificationDto notificationDto) {
        this.notificationDto = notificationDto;
    }
}

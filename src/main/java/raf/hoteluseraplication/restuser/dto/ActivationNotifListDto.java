package raf.hoteluseraplication.restuser.dto;

import raf.hoteluseraplication.restuser.tableComponents.NotificationDto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created on 15.01.2022. by Andrija inside package raf.hoteluseraplication.restuser.dto.
 */
public class ActivationNotifListDto {
    List<ActivationNotifDto> content = new ArrayList<>();


    public List<ActivationNotifDto> getContent() {
        return content;
    }

    public void setContent(List<ActivationNotifDto> content) {
        this.content = content;
    }
}

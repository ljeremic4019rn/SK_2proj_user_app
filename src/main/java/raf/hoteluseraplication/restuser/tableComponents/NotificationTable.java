package raf.hoteluseraplication.restuser.tableComponents;

import raf.hoteluseraplication.restuser.dto.CustomNotificationDto;
import raf.hoteluseraplication.restuser.dto.CustomNotificationListDto;
import raf.hoteluseraplication.restuser.dto.NotificationListDto;

import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;

public class NotificationTable extends DefaultTableModel {

    private CustomNotificationListDto notificationListDto = new CustomNotificationListDto();

    public NotificationTable(){
        super(new String[]{"Email", "Type", "Date", "Text"}, 0);
    }

    @Override
    public void addRow(Object[] rowData) {
        super.addRow(rowData);
        CustomNotificationDto notificationDto = new CustomNotificationDto();
        notificationDto.setEmail(String.valueOf(rowData[0]));
        notificationDto.setType((String) rowData[1]);
        notificationDto.setCreationDate((LocalDate) rowData[2]);
        notificationDto.setText(String.valueOf(rowData[3]));
        notificationListDto.getContent().add(notificationDto);

    }

    public CustomNotificationListDto getNotificationListDto() {
        return notificationListDto;
    }

    public void setNotificationListDto(CustomNotificationListDto notificationListDto) {
        this.notificationListDto = notificationListDto;
    }
}

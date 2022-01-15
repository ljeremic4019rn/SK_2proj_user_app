package raf.hoteluseraplication.restuser.tableComponents;

import javax.swing.table.DefaultTableModel;
import java.time.LocalDate;

public class NotificationTable extends DefaultTableModel {

    private NotificationListDto notificationListDto = new NotificationListDto();

    public NotificationTable(){
        super(new String[]{"Email", "Type", "Date", "Text"}, 0);
    }

    @Override
    public void addRow(Object[] rowData) {
        super.addRow(rowData);
        NotificationDto notificationDto = new NotificationDto();
        notificationDto.setClientEmail(String.valueOf(rowData[0]));
        notificationDto.setNotificationTypeDto((NotificationTypeDto) rowData[1]);
        notificationDto.setCreationDate((LocalDate) rowData[2]);
        notificationDto.setText(String.valueOf(rowData[3]));
        notificationListDto.getContent().add(notificationDto);

    }

    public NotificationListDto getNotificationListDto() {
        return notificationListDto;
    }

    public void setNotificationListDto(NotificationListDto notificationListDto) {
        this.notificationListDto = notificationListDto;
    }
}

package raf.hoteluseraplication.restuser.tableComponents;

/**
 * Created on 12.01.2022. by Andrija inside package app.domain.
 */

public class NotificationType {

    private Long id;
    private String name;

    public NotificationType() {
    }

    public NotificationType(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

package org.screen.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.screen.entity.status.MessagesStatus;
import org.screen.entity.status.Season;

import javax.persistence.*;

@EqualsAndHashCode(callSuper = true)
@NamePattern("%s|number")
@Table(name = "DISPATCHER_MESSAGES")
@Entity(name = "dispatcher_Messages")
@Data
@Slf4j
public class Messages extends StandardEntity {
    private static final long serialVersionUID = 856093958844289203L;

    @Column(name = "TEMPERATURE")
    protected Integer temperature;

    @Column(name = "NUMBER_")
    protected Integer number;

    @Column(name = "IS_SMOKE")
    protected Boolean isSmoke;

    /**
     * level of smoke in percent
     */
    @Column(name = "SMOKE_TIER")
    protected Integer smokeTier;

    @Column(name = "IS_BACK_DOOR")
    protected Boolean isBackDoor;

    @Column(name = "STATUS")
    protected Integer messagesStatus;


    @Column(name = "SEASON")
    protected Integer season;

    @Column(name = "IS_WORK")
    protected Boolean isWork;


    public   Integer calculateStatusMessages(Integer temperature) {
        int result  = 1;
        final Integer errorId = MessagesStatus.ERROR.getId();
        if (getSeason().equals(Season.SUMMER) && temperature > 35) {
            result = errorId;
        }
        if (getSeason().equals(Season.AUTUMN) && temperature > 25) {
            result = errorId;
        }
        if (getSeason().equals(Season.WINTER) && temperature > 20) {
            result = errorId;
        }
        if (getSeason().equals(Season.SPRING) && temperature > 30) {
            result = errorId;
        }
        log.info("status {}", result);

        return result;
    }

    @PrePersist
    @PreUpdate
    public void updateStatus() {
        messagesStatus = calculateStatusMessages(temperature);
    }



    public MessagesStatus getMessagesStatus() {
        return messagesStatus == null ? null : MessagesStatus.fromId(messagesStatus);
    }

    public void setMessagesStatus(MessagesStatus messagesStatus) {
        this.messagesStatus = messagesStatus == null ? null : messagesStatus.getId();
    }

    public Season getSeason() {
        return season == null ? null : Season.fromId(season) ;
    }

    public void setSeason(Season season) {
        this.season = season == null ? null : season.getId();
    }
}
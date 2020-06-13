package org.screen.portal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class MsgPlayloadDto {
    protected Integer temperature;

    protected Integer number;

    protected Boolean isSmoke;

    protected Integer smokeTier;

    protected Boolean isBackDoor;

    protected Integer messagesStatus;

    protected Integer season;

    protected Boolean isWork;

    public Map<String, Object> toMap() {
        final Map<String, Object> map = new HashMap<>();
        map.put("temperature", this.temperature);
        map.put("number", this.number);
        map.put("isSmoke", this.isSmoke);
        map.put("smokeTier", this.smokeTier);
        map.put("isBackDoor,", this.isBackDoor);
        map.put("messagesStatus", this.messagesStatus);
        map.put("season", this.season);
        map.put("isWork", this.isWork);
        return map;

    }
}

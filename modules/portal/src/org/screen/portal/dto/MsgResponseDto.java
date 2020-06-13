package org.screen.portal.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.screen.entity.Messages;
import org.screen.entity.status.MessagesStatus;

import java.util.UUID;
@Data
@NoArgsConstructor
public class MsgResponseDto {

    protected MessagesStatus status;

    protected UUID id;

    public MsgResponseDto(Messages message) {
        this.status = message.getMessagesStatus();
        this.id = message.getId();
    }
}

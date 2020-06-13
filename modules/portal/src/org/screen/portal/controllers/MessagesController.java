package org.screen.portal.controllers;

import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import lombok.RequiredArgsConstructor;
import org.screen.entity.Messages;
import org.screen.entity.status.MessagesStatus;
import org.screen.entity.status.Season;
import org.screen.portal.dto.MsgPlayloadDto;
import org.screen.portal.dto.MsgResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.HeaderParam;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("api/messages")
@RequiredArgsConstructor
public class MessagesController {
    @Inject
    private DataManager dataService;



    @RequestMapping(name = "/create/", method = RequestMethod.POST)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public MsgResponseDto createMessages(@Valid @RequestBody MsgPlayloadDto playloadDto,
                                         @HeaderParam("Session id")
                                         @RequestHeader(value = "Auth-token", required = false)
                                         final UUID authToken
    ) {
        final Messages messages = createMessages(playloadDto.toMap());
        return new MsgResponseDto(messages);
    }





    private Messages createMessages(Map<String, Object> playloadMsg) {
        final Messages messages = mapToMessages(playloadMsg);
        create(messages);
        return messages;



    }


    private Messages mapToMessages(Map<String, Object> dtoMsg) {
        Messages msg = new Messages();
        msg.setIsBackDoor((boolean) dtoMsg.get("isBackDoor"));
        msg.setIsSmoke((boolean) dtoMsg.get("isSmoke"));
        msg.setIsWork((boolean) dtoMsg.get("isWork"));
        msg.setMessagesStatus(MessagesStatus.fromId((Integer) dtoMsg.get("messagesStatus")));
        msg.setTemperature((Integer) dtoMsg.get("temperature"));
        msg.setNumber((Integer) dtoMsg.get("number"));
        msg.setSmokeTier((Integer) dtoMsg.get("smokeTier"));
        msg.setSeason(Season.fromId((Integer) dtoMsg.get("season")));
        return msg;
    }

    public Boolean create(Messages messages) {
        boolean result = false;
        CommitContext commitContext = new CommitContext(messages);
        if (!dataService.commit(commitContext).isEmpty()) {
            result = true;
        }
        return result;
    }




}

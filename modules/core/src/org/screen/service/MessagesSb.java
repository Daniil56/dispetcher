package org.screen.service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MessagesSb {

//
//    private final MessagesRepository messagesRepository;
//
//
//
//    public Messages createMessages(Map<String, Object> playloadMsg) {
//        final Messages messages = mapToMessages(playloadMsg);
//         messagesRepository.create(messages);
//         return messages;
//
//
//
//    }
//
//    public Messages mapToMessages(Map<String, Object> dtoMsg) {
//        Messages msg = new Messages();
//        msg.setIsBackDoor((boolean) dtoMsg.get("isBackDoor"));
//        msg.setIsSmoke((boolean) dtoMsg.get("isSmoke"));
//        msg.setIsWork((boolean) dtoMsg.get("isWork"));
//        msg.setMessagesStatus(MessagesStatus.fromId((Integer) dtoMsg.get("messagesStatus")));
//        msg.setTemperature((Integer) dtoMsg.get("temperature"));
//        msg.setNumber((Integer) dtoMsg.get("number"));
//        msg.setSmokeTier((Integer) dtoMsg.get("smokeTier"));
//        msg.setSeason(Season.fromId((Integer) dtoMsg.get("season")));
//        return msg;
//    }
}
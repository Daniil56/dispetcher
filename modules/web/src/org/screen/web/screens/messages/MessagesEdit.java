package org.screen.web.screens.messages;

import com.haulmont.cuba.gui.screen.*;
import org.screen.entity.Messages;

@UiController("dispatcher_Messages.edit")
@UiDescriptor("messages-edit.xml")
@EditedEntityContainer("messagesDc")
@LoadDataBeforeShow
public class MessagesEdit extends StandardEditor<Messages> {
}
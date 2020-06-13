package org.screen.web.screens.messages;

import com.haulmont.cuba.gui.screen.*;
import org.screen.entity.Messages;

@UiController("dispatcher_Messages.browse")
@UiDescriptor("messages-browse.xml")
@LookupComponent("messagesesTable")
@LoadDataBeforeShow
public class MessagesBrowse extends StandardLookup<Messages> {
}
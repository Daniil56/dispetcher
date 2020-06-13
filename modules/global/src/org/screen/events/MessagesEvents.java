package org.screen.events;

import com.haulmont.addon.globalevents.transport.EventOrigin;
import org.springframework.context.ApplicationEvent;

public class MessagesEvents extends ApplicationEvent {

    private EventOrigin eventOrigin = new EventOrigin();
    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public MessagesEvents(Object source) {
            super(source);

    }
    public EventOrigin getEventOrigin() {
        return eventOrigin;
    }
}

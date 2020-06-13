package org.screen.repository;

import com.haulmont.cuba.core.global.CommitContext;
import com.haulmont.cuba.core.global.DataManager;
import lombok.RequiredArgsConstructor;
import org.screen.entity.Messages;

import javax.inject.Inject;

@RequiredArgsConstructor
public class MessagesRepository {

    private  DataManager dataService;

    public Boolean create(Messages messages) {
        boolean result = false;
        CommitContext commitContext = new CommitContext(messages);
        if (!dataService.commit(commitContext).isEmpty()) {
            result = true;
        }
        return result;
    }
}

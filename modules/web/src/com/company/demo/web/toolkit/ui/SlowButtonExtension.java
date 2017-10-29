package com.company.demo.web.toolkit.ui;

import com.company.demo.web.toolkit.ui.client.SlowButtonExtensionState;
import com.vaadin.server.AbstractExtension;
import com.vaadin.ui.Button;

public class SlowButtonExtension extends AbstractExtension {

    public SlowButtonExtension() {
        setNotificationMessage("Please wait");
    }

    public void extend(Button target) {
        super.extend(target);
    }

    @Override
    protected SlowButtonExtensionState getState() {
        return (SlowButtonExtensionState) super.getState();
    }

    @Override
    protected SlowButtonExtensionState getState(boolean markAsDirty) {
        return (SlowButtonExtensionState) super.getState(markAsDirty);
    }

    public void setNotificationMessage(String message) {
        getState().notificationMessage = message;
    }

    public String getNotificationMessage() {
        return getState(false).notificationMessage;
    }
}
package com.company.demo.web.toolkit.ui.client;

import com.company.demo.web.toolkit.ui.SlowButtonExtension;
import com.google.gwt.core.client.Scheduler;
import com.vaadin.client.ServerConnector;
import com.vaadin.client.WidgetUtil;
import com.vaadin.client.extensions.AbstractExtensionConnector;
import com.vaadin.client.ui.VButton;
import com.vaadin.client.ui.VNotification;
import com.vaadin.client.ui.button.ButtonConnector;
import com.vaadin.shared.Position;
import com.vaadin.shared.ui.Connect;

@Connect(SlowButtonExtension.class)
public class SlowButtonExtensionConnector extends AbstractExtensionConnector {
    @Override
    protected void extend(ServerConnector target) {
        VButton button = ((ButtonConnector) target).getWidget();
        button.addClickHandler(event -> {
            VNotification notification = VNotification.createNotification(0, button);
            String message = "<h1 style=\"color:white;font-weight:bold;\">" +
                    WidgetUtil.escapeHTML(getState().notificationMessage) + "</h1>";
            notification.show(message, Position.TOP_CENTER, "system");

            // hide after 3 sec
            Scheduler.get().scheduleFixedDelay(() -> {
                if (notification.isAttached()) {
                    notification.hide();
                }
                return false;
            }, 3000);
        });
    }

    @Override
    public SlowButtonExtensionState getState() {
        return (SlowButtonExtensionState) super.getState();
    }
}
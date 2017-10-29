package com.company.demo.web.screens;

import com.company.demo.web.toolkit.ui.SlowButtonExtension;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.web.app.mainwindow.AppMainWindow;

import javax.inject.Inject;
import java.util.Map;

public class ExtAppMainWindow extends AppMainWindow {
    @Inject
    private Button demoBtn;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        com.vaadin.ui.Button vButton = demoBtn.unwrap(com.vaadin.ui.Button.class);

        SlowButtonExtension slowButtonExtension = new SlowButtonExtension();
        slowButtonExtension.setNotificationMessage("Please wait while data is loading!");
        slowButtonExtension.extend(vButton);
    }

    public void onDemoBtnClick() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {
        }
    }
}
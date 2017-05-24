package com.personal.demo.event;

import com.personal.demo.domain.model.User;
import lombok.Data;
import org.springframework.context.ApplicationEvent;

import java.util.Locale;

/**
 * Created by jomher on 24/05/17.
 */
@Data
public class OnRegistrationCompleteEvent extends ApplicationEvent{

    private String appUrl;
    private Locale locale;
    private User user;

    public OnRegistrationCompleteEvent(User user, Locale locale, String appUrl) {
        super(user);

        this.user = user;
        this.locale = locale;
        this.appUrl = appUrl;
    }
}

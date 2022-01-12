package Mail.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/local.properties"
})
public interface WebConfig extends Config {
    @Key("web.url")
    String webUrl();

    @Key("login.mail")
    String loginMail();

    @Key("password.mail")
    String passwordMail();
}



package Mail.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:config/credentials.properties"
})
public interface RemoteConfig extends Config {

    String login();
    String password();
}
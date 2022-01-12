package Mail.config;

import org.aeonbits.owner.ConfigFactory;

public class ConfigHelper {

    public static String getUsername() {
        return webConfig().loginMail();
    }

    public static String getPassword() {
        return webConfig().passwordMail();
    }


    public static WebConfig webConfig() {
        return ConfigFactory.newInstance().create(WebConfig.class, System.getProperties());
    }


}

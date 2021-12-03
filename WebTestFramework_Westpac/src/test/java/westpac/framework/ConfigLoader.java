package westpac.framework;

import org.slf4j.LoggerFactory;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(ConfigLoader.class);

    private static ConfigLoader instance = null;
    private Properties properties;

    protected ConfigLoader() throws IOException{
        properties = new Properties();
        properties.load(getClass().getClassLoader().getResourceAsStream("config.properties"));
    }

    public static ConfigLoader getInstance(){
        if (instance == null){
            try{
                instance = new ConfigLoader();
            }catch (IOException ioe){
                ioe.printStackTrace();
            }
        }
        return instance;
    }

    public String getProperty(String key){
        return properties.getProperty(key, "");
    }
}

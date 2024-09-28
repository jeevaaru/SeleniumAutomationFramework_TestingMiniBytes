package org.jeeva.utils;

import org.jeeva.constants.FrameworkConstants;
import org.jeeva.enums.ConfigProperties;

import java.io.FileInputStream;



import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;



public final class PropertyUtils {

    private PropertyUtils(){

    }

    // Eager Initialisation

    private static Properties property = new Properties();
    private static final Map<String, String> CONFIGMAP = new HashMap<>();

    static {
        try {
            FileInputStream file = new FileInputStream(FrameworkConstants.getConfigFilePath());
            property.load(file);

           /* for(Object key : property.keySet()) {
                CONFIGMAP.put(String.valueOf(key), String.valueOf(property.getProperty(key.toString())));
            }

            */
            for(Map.Entry<Object, Object> entry: property.entrySet()) {
                CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue()).trim());
            }

            // property.entrySet().forEach(entry ->CONFIGMAP.put(String.valueOf(entry.getKey()), String.valueOf(entry.getValue())));
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    public static String get(ConfigProperties key) throws Exception {
        if(Objects.isNull(key) || Objects.isNull(CONFIGMAP.get(key.name().toLowerCase()))){
            throw new Exception("Property name " + key +" is not found. Please check config.properties");
        }
        return CONFIGMAP.get(key.name().toLowerCase());
    }
    // Works like Hashtable. -> little slow but thread safe


  /* public static String getValue(String key) throws Exception {

        if(Objects.isNull(property.getProperty(key)) || Objects.isNull(key)){
            throw new Exception("Property name " + key +" is not found. Please check config.properties");
        }
        return property.getProperty(key);

    }
    */


}

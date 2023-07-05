package engine.pp.healthmonitor.config;

import android.content.Context;
import androidx.annotation.NonNull;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class DBConfig {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory(@NonNull Context context) {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                configuration.configure(); // Loads the default configuration file (hibernate.cfg.xml)

                // Load the properties from database.properties in assets
                configuration.addProperties(loadPropertiesFromAssets(context, "database.properties"));

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties())
                        .build();

                sessionFactory = configuration.buildSessionFactory(serviceRegistry);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }

    private static Properties loadPropertiesFromAssets(@NonNull Context context, String fileName) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = context.getAssets().open(fileName);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}


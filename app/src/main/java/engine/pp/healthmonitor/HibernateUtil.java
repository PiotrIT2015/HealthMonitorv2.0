package engine.pp.healthmonitor;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    // Initialize the SessionFactory
    public static void initialize() {
        try {
            // Load configuration from hibernate.cfg.xml file
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");

            // Load properties from the provided context
            Properties properties = new Properties();
            properties.load(new FileInputStream("./database.properties"));
            configuration.setProperties(properties);

            // Build the SessionFactory
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception ex) {
            System.err.println("Failed to initialize Hibernate SessionFactory: " + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    // Get the SessionFactory
    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            throw new IllegalStateException("Hibernate SessionFactory has not been initialized.");
        }
        return sessionFactory;
    }

    // Open a session using the SessionFactory and the provided context
    public static Session openSession() {

        if (sessionFactory == null) {
            initialize();
        }
        Session session = sessionFactory.openSession(); //null
        return session;
    }

    // Load properties from the specified properties file
    private static Properties loadProperties(String propertiesPath) throws IOException {
        Properties properties = new Properties();
        FileInputStream fis = new FileInputStream(propertiesPath);
        properties.load(fis);
        fis.close();
        return properties;
    }
}




package engine.pp.healthmonitor;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class LoginModelImpl implements LoginModel {
    @Override
    public void login(String email, String password, OnLoginFinishedListener listener) {
        //Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            // Perform login using Hibernate and MySQL
            Query<User> query=null; //= session.createQuery("FROM User WHERE email = :email AND password = :password");
            query.setParameter("email", email);
            query.setParameter("password", password);
            User user = query.uniqueResult();

            if (user != null) {
                // Login successful
                listener.onLoginSuccess();
            } else {
                // Login failed
                listener.onLoginError("Invalid email or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
            listener.onLoginError("An error occurred during login");
        } /*finally {
            session.close();
        }*/
    }
}



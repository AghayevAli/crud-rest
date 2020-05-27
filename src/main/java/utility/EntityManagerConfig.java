package utility;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerConfig {
    public static EntityManager entityOpen(String persistence) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistence);
        return entityManagerFactory.createEntityManager();
    }
}

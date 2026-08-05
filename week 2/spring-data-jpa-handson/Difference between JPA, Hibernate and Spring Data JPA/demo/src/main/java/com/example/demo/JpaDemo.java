package com.example.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import org.springframework.stereotype.Component;

/**
 * APPROACH 1 — Pure JPA (javax/jakarta.persistence API)
 *
 * - Uses EntityManagerFactory and EntityManager directly.
 * - This is the standard JPA specification (defined by Jakarta EE).
 * - No Spring, no Hibernate-specific classes — just the JPA API.
 * - You manage transactions manually.
 * - Hibernate is the underlying provider, but we never touch Hibernate classes here.
 */
@Component
public class JpaDemo {

    private final EntityManagerFactory emf;

    public JpaDemo(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void run() {
        System.out.println("\n========== APPROACH 1: Pure JPA (EntityManager) ==========");

        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            // Save
            tx.begin();
            Student student = new Student("Alice (JPA)", "alice@jpa.com");
            em.persist(student);          // JPA API: persist()
            tx.commit();
            System.out.println("Saved via JPA: " + student);

            // Find
            Student found = em.find(Student.class, student.getId()); // JPA API: find()
            System.out.println("Found via JPA: " + found);

            // JPQL Query
            em.createQuery("SELECT s FROM Student s WHERE s.name LIKE :name", Student.class)
              .setParameter("name", "%JPA%")
              .getResultList()
              .forEach(s -> System.out.println("Queried via JPA JPQL: " + s));

        } finally {
            em.close();
        }
    }
}

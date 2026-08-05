package com.example.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

/**
 * APPROACH 2 — Hibernate (Hibernate-specific API)
 *
 * - Uses Hibernate's SessionFactory and Session directly.
 * - Hibernate is a JPA *provider* but also has its own richer API.
 * - Extra features: Session.saveOrUpdate(), Criteria API, HQL, caching config, etc.
 * - You still manage transactions manually (or via Spring @Transactional).
 * - More powerful than plain JPA but ties you to Hibernate.
 */
@Component
public class HibernateDemo {

    private final SessionFactory sessionFactory;

    // Spring Boot auto-configures SessionFactory via EntityManagerFactory (unwrap)
    public HibernateDemo(jakarta.persistence.EntityManagerFactory emf) {
        this.sessionFactory = emf.unwrap(SessionFactory.class); // Hibernate-specific unwrap
    }

    public void run() {
        System.out.println("\n========== APPROACH 2: Hibernate (SessionFactory / Session) ==========");

        // Hibernate Session (superset of JPA EntityManager)
        try (Session session = sessionFactory.openSession()) {
            session.beginTransaction();

            Student student = new Student("Bob (Hibernate)", "bob@hibernate.com");
            session.persist(student);                    // Hibernate also supports persist()
            session.getTransaction().commit();
            System.out.println("Saved via Hibernate: " + student);

            // Hibernate-specific: get()
            Student found = session.get(Student.class, student.getId());
            System.out.println("Found via Hibernate get(): " + found);

            // HQL (Hibernate Query Language — similar to JPQL but Hibernate-native)
            session.createQuery("FROM Student s WHERE s.name LIKE :name", Student.class)
                   .setParameter("name", "%Hibernate%")
                   .list()
                   .forEach(s -> System.out.println("Queried via Hibernate HQL: " + s));
        }
    }
}

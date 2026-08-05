package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

/**
 * APPROACH 3 — Spring Data JPA (Repository abstraction)
 *
 * - Just an interface — Spring generates the implementation at runtime.
 * - No EntityManager, no Session, no transaction management needed.
 * - Built-in CRUD: save(), findById(), findAll(), delete(), etc.
 * - Derived query methods from method names (findByName, findByEmail, etc.)
 * - Internally uses JPA (EntityManager) which uses Hibernate as the provider.
 */
public interface StudentRepository extends JpaRepository<Student, Long> {

    // Spring Data derives the SQL automatically from the method name
    List<Student> findByNameContaining(String keyword);
}

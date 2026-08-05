package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(JpaDemo jpaDemo,
                           HibernateDemo hibernateDemo,
                           StudentRepository studentRepository) {
        return args -> {

            // ── Approach 1: Pure JPA ──────────────────────────────────────────
            jpaDemo.run();

            // ── Approach 2: Hibernate ─────────────────────────────────────────
            hibernateDemo.run();

            // ── Approach 3: Spring Data JPA ───────────────────────────────────
            System.out.println("\n========== APPROACH 3: Spring Data JPA (Repository) ==========");

            Student saved = studentRepository.save(new Student("Charlie (Spring Data JPA)", "charlie@spring.com"));
            System.out.println("Saved via Spring Data JPA: " + saved);

            studentRepository.findById(saved.getId())
                .ifPresent(s -> System.out.println("Found via Spring Data JPA: " + s));

            studentRepository.findByNameContaining("Spring Data JPA")
                .forEach(s -> System.out.println("Queried via derived method: " + s));

            System.out.println("Total students in DB: " + studentRepository.count());

            // ── Summary ───────────────────────────────────────────────────────
            System.out.println("""

            ╔══════════════════════════════════════════════════════════════════════╗
            ║              COMPARISON: JPA vs Hibernate vs Spring Data JPA        ║
            ╠══════════════╦═══════════════════════╦══════════════════════════════╣
            ║ Feature      ║ JPA                   ║ Hibernate      ║ Spring Data ║
            ╠══════════════╬═══════════════════════╬════════════════╬═════════════╣
            ║ Type         ║ Specification (API)   ║ Implementation ║ Abstraction ║
            ║ API          ║ EntityManager         ║ Session        ║ Repository  ║
            ║ Boilerplate  ║ High                  ║ High           ║ None        ║
            ║ Tx Mgmt      ║ Manual                ║ Manual         ║ Automatic   ║
            ║ Queries      ║ JPQL                  ║ HQL + Criteria ║ Method name ║
            ║ Portability  ║ High (any provider)   ║ Low (Hibernate)║ High        ║
            ╚══════════════╩═══════════════════════╩════════════════╩═════════════╝
            """);
        };
    }
}

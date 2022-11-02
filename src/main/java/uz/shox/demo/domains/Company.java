package uz.shox.demo.domains;

import javax.persistence.*;
import java.util.List;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 02/11/22 19:38 (Wednesday)
 * restInSpring/IntelliJ IDEA
 */
@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String website;
    @OneToMany(mappedBy = "company")

    private List<Vacancy> vacancies;
}

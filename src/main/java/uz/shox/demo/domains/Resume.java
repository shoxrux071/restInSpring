package uz.shox.demo.domains;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import uz.shox.demo.enums.City;
import uz.shox.demo.enums.Employment;

import javax.persistence.*;
import java.util.List;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 02/11/22 19:48 (Wednesday)
 * restInSpring/IntelliJ IDEA
 */
@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DynamicInsert
@DynamicUpdate
@Builder
public class Resume {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private City city = City.TASHKENT;

    @Column(nullable = false)
    private String jobTitle;

    @Column(nullable = false)
    private Employment employment;

    @Column(nullable = true)
    private String aboutMe;

    @Column(nullable = true)
    private Double salary;

    @Embedded
    private Auditable auditable;

    @OneToMany(mappedBy = "resume")
    private List<Education> educations;

    @OneToMany(mappedBy = "resume")
    private List<Language> languages;

    @OneToMany(mappedBy = "resume")
    private List<Experience> experiences;

    @OneToMany(mappedBy = "resume")
    private List<Skills> skills;

}

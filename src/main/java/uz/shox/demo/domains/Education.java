package uz.shox.demo.domains;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import uz.shox.demo.enums.EducationLevel;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 02/11/22 19:43 (Wednesday)
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
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Auditable auditable;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private EducationLevel educationLevel;

    @Column(nullable = false)
    private String department;

    @Column(nullable = false)
    private String faculty;

    @Column(nullable = false)
    private LocalDateTime yearOfGraduation;

    @ManyToOne
    private Resume resume;

}

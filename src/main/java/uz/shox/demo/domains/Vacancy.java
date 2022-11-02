package uz.shox.demo.domains;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import uz.shox.demo.enums.JobSchedule;
import uz.shox.demo.enums.JobType;

import javax.persistence.*;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 02/11/22 19:52 (Wednesday)
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
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Auditable auditable;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Double salary;
    @Column
    private String experience;

    @Column(nullable = false)
    private JobSchedule jobSchedule;

    @Column(nullable = false)
    private JobType jobType;

    private String offer;

    private String demands;

    @ManyToOne
    private Company company;

}

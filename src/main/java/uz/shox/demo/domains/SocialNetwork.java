package uz.shox.demo.domains;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 02/11/22 19:51 (Wednesday)
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
public class SocialNetwork {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Embedded
    private Auditable auditable;

    @Column(nullable = false,unique = true)
    private String link;

    @ManyToOne
    private Users users;
}
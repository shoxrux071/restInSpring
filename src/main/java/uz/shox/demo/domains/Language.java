package uz.shox.demo.domains;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import uz.shox.demo.enums.LanguageDegree;
import uz.shox.demo.enums.LanguageType;

import javax.persistence.*;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 02/11/22 19:46 (Wednesday)
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
public class Language {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Embedded
    private Auditable auditable;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private LanguageType languageType;

    @Column(nullable = false)
    private LanguageDegree languageDegree;

    @ManyToOne
    private Resume resume;


}

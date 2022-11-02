package uz.shox.demo.domains;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import uz.shox.demo.enums.Location;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private Auditable auditable;

    @Column(name = "full_name")
    private String fullName;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "users")
    private List<SocialNetwork> socialNetworks;

    @Column(nullable = false)
    private Location location;

    private String image_url;


    @Enumerated(EnumType.STRING)
    private Status status = Status.NOT_ACTIVE;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastLoginAt;

    private Integer loginTryCount;

    @ManyToMany
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles = new HashSet<>();

    public enum Status {
        ACTIVE,
        NOT_ACTIVE,
        ACCOUNT_EXPIRED,
        CREDENTIALS_EXPIRED;

        public boolean notEquals(Status status) {

            return !this.equals(status);
        }
    }


}

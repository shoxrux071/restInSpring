package uz.shox.demo.domains;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * @author "Berdimurodov Shoxrux"
 * @since 02/11/22 18:13 (Wednesday)
 * restInSpring/IntelliJ IDEA
 */
@Getter
@Setter
@Embeddable
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Auditable {

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt",
            columnDefinition = "timestamp NOT NULL default CURRENT_TIMESTAMP")
    private Date createdAt;
    private Long updatedBy;
    private Long createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    @Column(name = "deleted", columnDefinition = "BOOLEAN NOT NULL default false")
    private Boolean deleted;

}

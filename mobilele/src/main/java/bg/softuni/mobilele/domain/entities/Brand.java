package bg.softuni.mobilele.domain.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "brands")
public class Brand extends BaseEntity {

    @Column(unique = true, nullable = false)
    private String name;

    @Column
    private Date created;

    @Column
    private Date modified;

    public String getName() {
        return name;
    }

    public Brand setName(String name) {
        this.name = name;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public Brand setCreated(Date created) {
        this.created = created;
        return this;
    }

    public Date getModified() {
        return modified;
    }

    public Brand setModified(Date modified) {
        this.modified = modified;
        return this;
    }
}

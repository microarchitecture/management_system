package parentEntity;

import javax.persistence.*;

@MappedSuperclass
public class ParentId {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GEN")
    @SequenceGenerator(name = "SEQ_GEN", sequenceName = "HIB_SEQ")
    @Column(name = "ID")
    private long id;

    public void setId(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }

}

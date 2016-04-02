package parentEntity;

import javax.persistence.*;

@MappedSuperclass
public class ParentId {

    @Id
//    @SequenceGenerator(name = "", sequenceName = "")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    public void setId(long id) {
        this.id = id;
    }
    public long getId() {
        return id;
    }

}

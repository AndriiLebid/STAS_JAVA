package alebid.stasjavademo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class ScanType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "typeId")
    private int id;

    @NotBlank(message = "Scan Name Can't be blank")
    @Size(min = 3, max = 20, message = "Scan name can't be more 20 and less 3 characters")
    private String typeName;

    @OneToMany(mappedBy = "RawScan", fetch = FetchType.LAZY)
    private List<RawScan> scanList;


    public ScanType() {
    }

    public ScanType(int id, String typeName) {
        this.id = id;
        this.typeName = typeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank(message = "Scan Name Can't be blank") @Size(min = 3, max = 20, message = "Roll name can't be more 20 and less 3 characters") String getTypeName() {
        return typeName;
    }

    public void setTypeName(@NotBlank(message = "Scan Name Can't be blank") @Size(min = 3, max = 20, message = "Roll name can't be more 20 and less 3 characters") String typeName) {
        this.typeName = typeName;
    }

    public List<RawScan> getScanList() {
        return scanList;
    }

    public void setScanList(List<RawScan> scanList) {
        this.scanList = scanList;
    }
}


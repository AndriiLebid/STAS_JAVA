package alebid.stasjavademo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    private int id;

    @NotBlank(message = "Roll Name Can't be blank")
    @Size(min = 3, max = 20, message = "Roll name can't be more 20 and less 3 characters")
    private String roleName;

    @OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
    private List<User> userList;

    public Role() {
    }

    public Role(int id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank(message = "Roll Name Can't be blank") @Size(min = 3, max = 20, message = "Roll name can't be more 20 and less 3 characters") String getRoleName() {
        return roleName;
    }

    public void setRoleName(@NotBlank(message = "Roll Name Can't be blank") @Size(min = 3, max = 20, message = "Roll name can't be more 20 and less 3 characters") String roleName) {
        this.roleName = roleName;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}

package alebid.stasjavademo.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserId")
    private int id;

    @NotBlank(message = "User Name Can't be blank")
    @Size(min = 3, max = 20, message = "User name can't be more 20 and less 3 characters")
    private String userName;

    @NotBlank(message = "User Password Can't be blank")
    @Size(min = 8, max = 64, message = "User passworf can't be more 64 and less 8 characters")
    private String password;

    private String salt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "roleId", foreignKey = @ForeignKey(name = "FK_User_Role"))
    @NotNull(message = "Role is required")
    private Role role;

    public User() {
    }

    public User(int id, String userName, String password, String salt, Role role) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.salt = salt;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank(message = "User Name Can't be blank") @Size(min = 3, max = 20, message = "User name can't be more 20 and less 3 characters") String getUserName() {
        return userName;
    }

    public void setUserName(@NotBlank(message = "User Name Can't be blank") @Size(min = 3, max = 20, message = "User name can't be more 20 and less 3 characters") String userName) {
        this.userName = userName;
    }

    public @NotBlank(message = "User Password Can't be blank") @Size(min = 8, max = 64, message = "User passworf can't be more 64 and less 8 characters") String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank(message = "User Password Can't be blank") @Size(min = 8, max = 64, message = "User passworf can't be more 64 and less 8 characters") String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public @NotNull(message = "Role is required") Role getRole() {
        return role;
    }

    public void setRole(@NotNull(message = "Role is required") Role role) {
        this.role = role;
    }
}

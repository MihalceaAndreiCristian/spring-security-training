package ro.amihalcea.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="users")
@ToString
public class User {

    @Id
    private int id;
    private String username;
    private String password;
}

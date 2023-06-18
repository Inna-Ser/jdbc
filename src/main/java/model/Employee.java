package model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "employee")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    private String gender;
    private Integer age;
//    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn
    @Column(name = "city_id")
    private int city;

}

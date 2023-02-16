package com.nighthawk.spring_portfolio.mvc.location;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import org.hibernate.annotations.TypeDef;
import com.vladmihalcea.hibernate.type.json.JsonType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@TypeDef(name="json", typeClass = JsonType.class)
public class Location {

    // automatic unique identifier for Location record
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    // email, password, roles are key attributes to login and authentication
    @NotEmpty
    @Column(unique=true)
    private Location coordinates;

    // @NonNull, etc placed in params of constructor: "@NonNull @Size(min = 2, max = 30, message = "Name (2 to 30 chars)") String name"
    @NonNull
    @Size(min = 2, max = 30, message = "Name (2 to 30 chars)")
    private String name;

    private String description;

    private String image_link;

    public String getName() {
        return this.name;
    }
    
}
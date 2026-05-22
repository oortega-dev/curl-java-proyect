package com.airtek.CURL.Entity;

import com.airtek.CURL.Model.Enums.RequestType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.validation.Schema;
import java.time.LocalDateTime;

@Entity
@Getter @Setter
@NoArgsConstructor
@Table(schema = "base_proyect", )
public class request {

    @Id
    @SequenceGenerator(name = "")
    @GeneratedValue()
    private Long id;

    private String name;
    private RequestType type;
    private String body;
    private String url;
    private LocalDateTime created;
}

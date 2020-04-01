package com.kfaino.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "payment")
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class Payment implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;
    private String serial;
}

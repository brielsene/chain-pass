package br.com.chainpass.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "chain")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String senha;
    private LocalDateTime data;

    private String descricao;
}

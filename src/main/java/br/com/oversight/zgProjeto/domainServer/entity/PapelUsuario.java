package br.com.oversight.zgProjeto.domainServer.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import br.com.oversight.zgProjeto.domainServer.entity.enumerable.EnumPapel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(uniqueConstraints = { @UniqueConstraint(columnNames = { "usuario_id", "papel" }) })
public class PapelUsuario implements Serializable {

    private static final long serialVersionUID = 6867576289920618618L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "Informe a data de cadastro.")
    private Date dataCadastro;

    @Enumerated(EnumType.STRING)
    @Column(length = 255, nullable = false)
    @NotNull(message = "Informe o papel do usuário.")
    private EnumPapel papel;

    @PrePersist
    private void atualizarData() {
        this.dataCadastro = new Date();
    }

    public PapelUsuario(EnumPapel enumPapel) {
        this.papel = enumPapel;
    }
}
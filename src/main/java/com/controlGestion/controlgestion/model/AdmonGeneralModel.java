package com.controlGestion.controlgestion.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cgc_admon_general", schema = "gestdoc")
public class AdmonGeneralModel {

    @Id
    @Column(name = "cve_id_admon_general")
    private Integer id;

    @Column(name = "acronimo", length = 20)
    private String acronimo;

    @Column(name = "administracion", length = 150)
    private String administracion;

    @Column(name = "puesto", length = 150)
    private String puesto;

    @Column(name = "fec_registro_alta")
    private LocalDateTime fecRegistroAlta;

    @OneToMany(mappedBy = "admonGeneral")
    @JsonIgnore
    private List<AdmonCentralModel> centrales;

    @OneToMany(mappedBy = "admonGeneral")
    @JsonManagedReference
    private List<AdministradorGeneralModel> administradoresGenerales;
    
}

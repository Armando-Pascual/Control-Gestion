package com.controlGestion.controlgestion.model;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cgc_admon_central", schema = "gestdoc")
public class AdmonCentralModel {

    @Id
    @Column(name = "cve_id_admon_central")
    private Integer id;

    @Column(name = "acronimo", length = 20)
    private String acronimo;

    @Column(name = "administracion", length = 150)
    private String nombre;

    @Column(name = "puesto", length = 150)
    private String puesto;

    @ManyToOne
    @JoinColumn(name = "cve_id_admon_general")
    private AdmonGeneralModel admonGeneral;

    @Column(name = "fec_registro_alta")
    private LocalDateTime fecRegistroAlta;

    @Column(name = "fec_registro_baja")
    private LocalDateTime fecRegistroBaja;

    @OneToMany(mappedBy = "admonCentral")
    private List<AdministracionModel> administraciones;

    @OneToMany(mappedBy = "admonCentral")
    private List<AdministradorCentralModel> administradoresCentrales;
}

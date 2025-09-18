package com.controlGestion.controlgestion.model.Enum;

import com.controlGestion.controlgestion.model.EstatusModel;

public enum EstatusEnum {
    INICIADA(1, "Solicitud iniciada"),
    ASIGNACION_INICIADA(2, "Solicitud Asignación Iniciada"),
    ASIGNADA(3, "Solicitud Asignada"),
    REVISION(4, "Solicitud en Revisión"),
    PROCESO_DE_ENTREGA(5, "Solicitud en proceso de entrega"),
    DOCUMENTO_ACUSE(6, "Documento De Acuse"),
    ATENDIDA(7, "Solicitud Atendida"),;

    private final int id;
    private final String descripcion;

    EstatusEnum(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }
     public int getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static EstatusEnum fromId(int id) {
        for (EstatusEnum e : values()) {
            if (e.id == id) return e;
        }
        throw new IllegalArgumentException("ID de estatus inválido: " + id);
    }

    public static EstatusEnum fromModel(EstatusModel model) {
        return fromId(model.getId());
    }


}

package com.carlariela.universidad.universidad_backend.modelo.dto;

import lombok.*;

/*
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
*/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarreraDTO {

    private Integer codigo;
    private String nombre;
    private Integer cantidad_materias;
    private Integer cantidad_anios;


    /*
    public CarreraDTO() {
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad_materias() {
        return cantidad_materias;
    }

    public void setCantidad_materias(Integer cantidad_materias) {
        this.cantidad_materias = cantidad_materias;
    }

    public Integer getCantidad_anios() {
        return cantidad_anios;
    }

    public void setCantidad_anios(Integer cantidad_anios) {
        this.cantidad_anios = cantidad_anios;
    }
    */

}

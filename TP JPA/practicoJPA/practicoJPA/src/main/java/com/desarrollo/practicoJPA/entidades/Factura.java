package com.desarrollo.practicoJPA.entidades;

import com.desarrollo.practicoJPA.enumeraciones.FormaPago;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Factura extends BaseEntidad {

    private int numero;

    private Date fecha;

    private double descuento;
    private FormaPago formaPago;
    private int totalFactura;

}

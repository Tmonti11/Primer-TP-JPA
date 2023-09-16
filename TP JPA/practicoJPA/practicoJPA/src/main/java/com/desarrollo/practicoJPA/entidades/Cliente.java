package com.desarrollo.practicoJPA.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Cliente extends BaseEntidad {

    private String nombre;

    private String apellido;

    private String telefono;

    private String email;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "persona-id")
    @Builder.Default

    private List<Domicilio> domicilios = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "cliente_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();

    public void agregarDomicilio(Domicilio domi){

        domicilios.add(domi);
    }
    public void mostrarDomicilios(){
        System.out.println("Domicilios de " + nombre + " " + apellido + ":");

        for (Domicilio domicilio : domicilios)
            System.out.println("Calle: " + domicilio.getCalle() + ", Numero: " + domicilio.getNumero());
    }

    public void agregarPedido(Pedido pedido){
    pedidos.add(pedido);
    }
}

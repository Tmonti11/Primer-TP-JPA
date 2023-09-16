package com.desarrollo.practicoJPA;

import com.desarrollo.practicoJPA.entidades.*;
import com.desarrollo.practicoJPA.enumeraciones.Estado;
import com.desarrollo.practicoJPA.enumeraciones.FormaPago;
import com.desarrollo.practicoJPA.enumeraciones.TipoEnvio;
import com.desarrollo.practicoJPA.enumeraciones.TipoProducto;
import com.desarrollo.practicoJPA.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;

@SpringBootApplication
public class PracticoJpaApplication {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	RubroRepository rubroRepository;

	public static void main(String[] args) {SpringApplication.run(PracticoJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ClienteRepository clienteRepository, DetallePedidoRepository detallePedidoRepository, DomicilioRepository domicilioRepository, FacturaRepository facturaRepository, PedidoRepository pedidoRepository, ProductoRepository productoRepository, RubroRepository rubroRepository) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");

			SimpleDateFormat formato = new SimpleDateFormat("yyyy-MM-dd");

			Cliente cliente1 = Cliente.builder()
					.nombre("Julian")
					.apellido("Estodio")
					.telefono("2615542395")
					.email("estodiojuli@mail.com")
					.build();
			Domicilio domicilio1 = Domicilio.builder()
					.calle("Panquehua")
					.numero("532")
					.localidad("Ciudad")
					.build();
			Domicilio domicilio2 = Domicilio.builder()
					.calle("Dr. Maribo")
					.numero("420")
					.localidad("Lujan de Cuyo")
					.build();

			Pedido pedido1 = Pedido.builder()
					.estado(Estado.iniciado)
					.fecha(formato.parse("2022-12-18"))
					.tipoEnvio(TipoEnvio.delivery)
					.total(8500)
					.build();
			Pedido pedido2 = Pedido.builder()
					.estado(Estado.entregado)
					.fecha(formato.parse("2022-12-20"))
					.tipoEnvio(TipoEnvio.retiro)
					.total(12500)
					.build();
			Factura factura1 = Factura.builder()
					.numero(13)
					.fecha(formato.parse("2022-12-19"))
					.descuento(1000)
					.formaPago(FormaPago.etc)
					.totalFactura(7500)
					.build();
			Factura factura2 = Factura.builder()
					.numero(12)
					.fecha(formato.parse("2022-12-24"))
					.descuento(1500)
					.formaPago(FormaPago.efectivo)
					.totalFactura(11000)
					.build();
			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(1)
					.subtotal(3500)
					.build();
			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(1500)
					.build();
			DetallePedido detallePedido3 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(7000)
					.build();
			DetallePedido detallePedido4 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(2200)
					.build();
			Producto producto1 = Producto.builder()
					.tipo(TipoProducto.manufacturado)
					.tiempoEstimadoCocina(50)
					.denominacion("Lomo")
					.precioVenta(3500)
					.precioCompra(1500)
					.stockActual(20)
					.stockMinimo(10)
					.unidadMedida("cm")
					.receta("A")
					.build();
			Producto producto2 = Producto.builder()
					.tipo(TipoProducto.insumo)
					.tiempoEstimadoCocina(10)
					.denominacion("Gaseosa")
					.precioVenta(750)
					.precioCompra(300)
					.stockActual(60)
					.stockMinimo(25)
					.unidadMedida("L")
					.receta("B")
					.build();
			Producto producto3 = Producto.builder()
					.tipo(TipoProducto.insumo)
					.tiempoEstimadoCocina(10)
					.denominacion("Cerveza")
					.precioVenta(1100)
					.precioCompra(350)
					.stockActual(40)
					.stockMinimo(15)
					.unidadMedida("L")
					.receta("C")
					.build();
			Rubro rubro1 = Rubro.builder()
					.denominacion("Comida")
					.build();
			Rubro rubro2 = Rubro.builder()
					.denominacion("Bebida")
					.build();


			cliente1.agregarDomicilio(domicilio1);
			cliente1.agregarDomicilio(domicilio2);
			cliente1.agregarPedido(pedido1);
			cliente1.agregarPedido(pedido2);

			pedido1.setFactura(factura1);
			pedido1.agregarDetalle(detallePedido1);
			pedido1.agregarDetalle(detallePedido2);

			pedido2.setFactura(factura2);
			pedido2.agregarDetalle(detallePedido3);
			pedido2.agregarDetalle(detallePedido4);

			rubro1.agregarProducto(producto1);

			rubro2.agregarProducto(producto2);
			rubro2.agregarProducto(producto3);

		clienteRepository.save(cliente1);
		domicilioRepository.save(domicilio1);
		domicilioRepository.save(domicilio2);
		detallePedidoRepository.save(detallePedido1);
		detallePedidoRepository.save(detallePedido2);
		detallePedidoRepository.save(detallePedido3);
		detallePedidoRepository.save(detallePedido4);
		facturaRepository.save(factura1);
		facturaRepository.save(factura2);
		pedidoRepository.save(pedido1);
		pedidoRepository.save(pedido2);
		rubroRepository.save(rubro1);
		rubroRepository.save(rubro2);
		productoRepository.save(producto1);
		productoRepository.save(producto2);
		productoRepository.save(producto3);


		};


	}
}
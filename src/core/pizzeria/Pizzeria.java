/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package core.pizzeria;

import core.cliente.Cliente;
import core.item.Item;
import core.pedido.Pedido;
import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class Pizzeria {

    private String nombre;
    private ArrayList<Cliente> Clientes;
    private ArrayList<Item> Items;
    private ArrayList<Pedido> Pedidos;

    public Pizzeria() {
        this.nombre = nombre;
        this.Clientes = Clientes;
        this.Items = Items;
        this.Pedidos = Pedidos;
    }

    public void addCliente(Cliente Cliente) {
        Clientes.add(Cliente);
    }

    public Item getItem(int i) {
        if (i >= 0 && i < Items.size()) {
            return Items.get(i);
        }
        return null;
    }

    public Cliente getCliente(int i) {
        if (i >= 0 && i < Clientes.size()) {
            return Clientes.get(i);
        }
        return null;
    }

    public void addPedido(Pedido Pedido) {
        Pedidos.add(Pedido);
    }

    public int calcProdMasVendidoCliente(int numCliente) {
        // Verificar que el número de cliente sea válido
        if (numCliente < 0 || numCliente >= Clientes.size()) {
            return -1; // Retornar -1 si el número de cliente no es válido
        }

        Cliente cliente = Clientes.get(numCliente);
        int[] contadorProductos = new int[Items.size()]; // Array para contar la cantidad vendida de cada producto

        // Iterar sobre los pedidos del cliente
        for (Pedido pedido : Pedidos) {
            if (pedido.getCliente().equals(cliente)) {
                for (Item item : pedido.getItems()) {
                    int index = Items.indexOf(item); // Obtener el índice del producto en el inventario
                    if (index != -1) {
                        contadorProductos[index]++; // Incrementar el contador del producto
                    }
                }
            }
        }

        // Encontrar el producto más vendido
        int maxVendidos = 0;
        int indexProducto = -1;
        for (int i = 0; i < contadorProductos.length; i++) {
            if (contadorProductos[i] > maxVendidos) {
                maxVendidos = contadorProductos[i];
                indexProducto = i;
            }
        }

        return indexProducto;
    }

    public void addItem(Item Item) {
        Items.add(Item);
    }

}

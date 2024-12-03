/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

/**
 *
 * @author Jeff Alehx
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AlarmaStockp {

    public static void main(String[] args) {
        // Llamar al método para mostrar la notificación de prueba
        mostrarNotificacionPrueba();
    }

    // Método para mostrar una notificación de prueba con un mensaje aleatorio
    private static void mostrarNotificacionPrueba() {
        // Mensajes de prueba aleatorios
        String[] mensajes = {
            "¡Alerta! El stock de productos está bajo.",
            "Recuerda revisar el inventario, algunos productos están cerca del límite.",
            "¡Atención! Algunos productos están por agotarse.",
            "Alerta: Los productos en stock se están agotando rápidamente."
        };

        // Seleccionar un mensaje aleatorio
        Random random = new Random();
        String mensajeAleatorio = mensajes[random.nextInt(mensajes.length)];

        // Llamar al método para mostrar la notificación con el mensaje aleatorio
        mostrarNotificacion(mensajeAleatorio, new Color(0, 123, 255), "TOP");  // Color azul personalizado
    }

    // Método para mostrar la notificación con desvanecimiento
    private static void mostrarNotificacion(String mensaje, Color color, String ubicacion) {
        // Crear un JPanel para la notificación
        JPanel notificationPanel = new JPanel();
        notificationPanel.setBackground(color); // Color del panel
        notificationPanel.setLayout(new BorderLayout());

        // Crear un JLabel con el mensaje
        JLabel messageLabel = new JLabel(mensaje, JLabel.CENTER);
        messageLabel.setForeground(Color.WHITE); // Texto en color blanco
        messageLabel.setFont(new Font("Arial", Font.BOLD, 15));

        notificationPanel.add(messageLabel, BorderLayout.CENTER);

        // Crear una ventana temporal para mostrar la notificación
        JDialog notificationDialog = new JDialog();
        notificationDialog.setUndecorated(true); // Sin bordes
        notificationDialog.setSize(500, 80); // Tamaño reducido (más delgado)
        notificationDialog.getContentPane().add(notificationPanel);

        // Ubicar la notificación en la pantalla según la ubicación deseada
        switch (ubicacion.toUpperCase()) {
            case "TOP":
                notificationDialog.setLocationRelativeTo(null); // Centrado en la parte superior
                notificationDialog.setLocation(notificationDialog.getX(), 0); // Colocarla en la parte superior
                break;
            case "BOTTOM":
                notificationDialog.setLocationRelativeTo(null); // Centrado en la parte inferior
                notificationDialog.setLocation(notificationDialog.getX(), Toolkit.getDefaultToolkit().getScreenSize().height - notificationDialog.getHeight()); // Colocarla en la parte inferior
                break;
            default:
                notificationDialog.setLocationRelativeTo(null); // Centrado en la pantalla por defecto
        }

        // Mostrar la notificación
        notificationDialog.setVisible(true);

        // Hacer que la notificación desaparezca después de 3 segundos
        Timer timer = new Timer(3000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                notificationDialog.dispose(); // Cerrar la notificación
            }
        });
        timer.setRepeats(false); // Solo se ejecuta una vez
        timer.start();
    }
}
import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;


public class SocialNetwork extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTabbedPane tabbedPane1;
    private JTextField txtNombre;
    private JTextField txtEdad;
    private JTextField txtPrioridad;
    private JTextField txtAmigos;
    private JButton btnAgregarParticipante;
    private JTextField txtId;
    private JTextField txtBuscarporId;
    private JButton btnBuscarMayorP;
    private JTextArea resultadoId;
    private JTextArea resultadoPrioridad;
    private JTextArea mostrarDatos;
    private JButton btnMostrarDP;
    private JButton btnBuscarId;
    Queue <Persona> paraSerActivados=new LinkedList<>();
    Queue<Persona> prioridad = new PriorityQueue<>();
    Stack<Persona> eliminados=new Stack<Persona>();
    Persona p1=new Persona(txtNombre.getText(),Integer.parseInt(txtId.getText()),Integer.parseInt(txtEdad.getText()),Integer.parseInt(txtPrioridad.getText()),Integer.parseInt(txtAmigos.getText()));



    public SocialNetwork() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        btnMostrarDP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                datosPredet();
                mostrarDatos();
            }
        });
        btnAgregarParticipante.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                agregar();
            }
        });
        btnBuscarId.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtBuscarporId.getText().equals(p1)){

                }
            }
        });
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    //MÉTODOS
    private void agregar(){
        Persona p1=new Persona(txtNombre.getText(),Integer.parseInt(txtId.getText()),Integer.parseInt(txtEdad.getText()),Integer.parseInt(txtPrioridad.getText()),Integer.parseInt(txtAmigos.getText()));
       //paraSerActivados.add(new Persona(txtNombre.getText(),Integer.parseInt(txtId.getText()),Integer.parseInt(txtEdad.getText()),Integer.parseInt(txtPrioridad.getText()),Integer.parseInt(txtAmigos.getText())));
        //paraSerActivados.poll();
        paraSerActivados.add(p1);

        System.out.println(p1.edad);


    }
    private void datosPredet(){
        Persona persona1 = new Persona("Kristiany Cerón", 53, 19,25,3);
        Persona persona2 = new Persona("Camila Vega", 76,35 ,45,4);
        Persona persona3 = new Persona("Pamela Ortiz", 20, 26,23,15);
        Persona persona4 = new Persona("Nayeli Luna", 47, 55,60,12);
        Persona persona5 = new Persona("Francis López", 94, 60,75,41);
        Persona persona6 = new Persona("Luciana Reyes", 17, 10,15,10);

        paraSerActivados.add(persona1);
        paraSerActivados.add(persona2);
        paraSerActivados.add(persona3);
        paraSerActivados.add(persona4);
        paraSerActivados.add(persona5);
        paraSerActivados.add(persona6);
    }
    private void mostrarDatos(){
        String nombre, cadena="";
        int edad, prioridad, amigos;
        for (Persona p:paraSerActivados) {
            edad= p.getEdad();
            prioridad= p.getPrioridad();
            amigos= p.getAmigos();
            cadena = cadena + "\n" + p.getNombreCompleto() + ", " + edad + ", " + prioridad+", "+amigos;
            System.out.println(cadena);
            mostrarDatos.setText(cadena);
            System.out.println(cadena);

        }
    }


    public static void main(String[] args) {
        SocialNetwork dialog = new SocialNetwork();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}

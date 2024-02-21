import java.awt.Color;
import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Restaurants extends JFrame {
    JLabel Customer, Name, Contact, Food, Drinks, Type, title1, thankYou;
    JTextField tname, tcontact, tnumber;
    JComboBox<String> c1, c2;
    JRadioButton b1, b2;
    JTextArea area1;
    JButton reset, print, receipt;

    Restaurants() {
        title1 = new JLabel("!!!Restaurant Management System!!!");
        title1.setFont(new Font("Cambria", Font.BOLD, 20));
        title1.setForeground(new Color(255, 0, 0));
        title1.setBounds(250, 10, 350, 30);
        getContentPane().setBackground(new Color(255, 255, 204));

       Customer = new JLabel("Customer No:");
        Customer.setBounds(20, 50, 120, 30);

        Name = new JLabel("Name:");
        Name.setBounds(20, 100, 120, 30);

        Contact = new JLabel("Contact:");
        Contact.setBounds(20, 150, 120, 30);

        Food = new JLabel("Food:");
        Food.setBounds(20, 200, 120, 30);

        Drinks = new JLabel("Drinks:");
        Drinks.setBounds(20, 250, 120, 30);

        Type = new JLabel("Type:");
        Type.setBounds(20, 300, 120, 30);

        tname = new JTextField();
        tname.setBounds(150, 100, 200, 30);

        tnumber = new JTextField();
        tnumber.setBounds(150, 50, 200, 30);

        tcontact = new JTextField();
        tcontact.setBounds(150, 150, 200, 30);

        String[] foods = {"Pizza-50", "FastFood-100", "Burger-60", "Pasta-70", "Salad-40", "Sandwich-50", "Steak-120", "Sushi-90", "Soup-30", "Tacos-65"};
        c1 = new JComboBox<>(foods);
        c1.setBounds(200, 200, 120, 30);

        String[] drinks = {"Lemon Juice-30", "Apple Juice-50", "Water-20", "Soda-25", "Iced Tea-35", "Milkshake-45", "Coffee-40", "Smoothie-60", "Beer-70", "Wine-80"};
        c2 = new JComboBox<>(drinks);
        c2.setBounds(200, 250, 120, 30);

        b1 = new JRadioButton("Diet");
        b2 = new JRadioButton("Normal");
        b1.setBounds(200, 300, 60, 30);
        b2.setBounds(300, 300, 70, 30);

        area1 = new JTextArea();
        area1.setBounds(400, 110, 80, 40);
        area1.setSize(260, 260);

        reset = new JButton("Reset");
        reset.setBounds(400, 50, 80, 40);

        print = new JButton("Print");
        print.setBounds(490, 50, 80, 40);

        receipt = new JButton("Receipt");
        receipt.setBounds(580, 50, 80, 40);

        getContentPane().add(Customer);
        getContentPane().add(Name);
        getContentPane().add(Contact);
        getContentPane().add(Food);
        getContentPane().add(Drinks);
        getContentPane().add(Type);
        getContentPane().add(tname);
        getContentPane().add(tnumber);
        getContentPane().add(tcontact);

        getContentPane().add(c1);
        getContentPane().add(c2);
        getContentPane().add(b1);
        getContentPane().add(b2);
        getContentPane().add(reset);
        getContentPane().add(print);
        getContentPane().add(receipt);
        getContentPane().add(area1);
        getContentPane().add(title1);
       

        setSize(800, 500);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tname.setText("");
                tcontact.setText("");
                tnumber.setText("");
            }
        });

        print.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    area1.print();
                } catch (PrinterException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });

        receipt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                area1.setText("Customer Name: " + tname.getText() + "\nCustomer Contact: " + tcontact.getText() + "\nCustomer Number: " + tnumber.getText());
                area1.append("\nFoods: " + c1.getSelectedItem());
                area1.append("\nDrinks: " + c2.getSelectedItem());

                // Calculate total amount
                String[] foodPrice = c1.getSelectedItem().toString().split("-");
                String[] drinkPrice = c2.getSelectedItem().toString().split("-");
                int total = Integer.parseInt(foodPrice[1]) + Integer.parseInt(drinkPrice[1]);

                area1.append("\nTotal Amount: " + total);

                // Add "Thank you for visiting!" to the receipt
                area1.append("\n\nThank you for visiting!");

                // Center and bold the receipt
                area1.setFont(new Font("Arial", Font.BOLD, 12));
           
            }
        });
    }

    public static void main(String[] args) {
        new Restaurants();
    }
}

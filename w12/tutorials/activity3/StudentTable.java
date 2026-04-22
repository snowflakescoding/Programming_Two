package w12.tutorials.activity3;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

public class StudentTable extends JFrame {

    public StudentTable() {
        setTitle("Student Table");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        String[] columns = {"ID", "Name", "Age"};
        Object[][] data = {
            {1, "Nguyen Van A", 20},
            {2, "Nguyen Van B", 22},
            {3, "Nguyen Van C", 19}
        };

        DefaultTableModel tableModel = new DefaultTableModel(data, columns) {
            @Override
            public boolean isCellEditable(int row, int col) {
                return false;
            }
        };

        JTable table = new JTable(tableModel);
        table.setRowHeight(25);
        table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
        table.setFont(new Font("Arial", Font.PLAIN, 13));

        TableColumnModel colModel = table.getColumnModel();
        colModel.getColumn(0).setPreferredWidth(50);   
        colModel.getColumn(1).setPreferredWidth(200);  
        colModel.getColumn(2).setPreferredWidth(80);   

        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(StudentTable::new);
    }
}

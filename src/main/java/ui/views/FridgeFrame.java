package main.java.ui.views;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

import main.java.dto.Food;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import java.util.EnumSet;
import java.util.List;

@Component
public class FridgeFrame extends JFrame {

    private JPanel contentPane;
    private JTable table;
    private static ArrayList<Food> foods = new ArrayList<>();
    private JButton backButton;
    private JButton addButton;

    public enum Actions {
        EDIT(255, 165, 0),
        DELETE(220, 20, 60);

        private Color color;

        Actions(int r, int g, int b) {
            this.color = new Color(r, g, b);
        }
    }

    /**
     * Create the frame.
     */
    public FridgeFrame() {

        try {
            setIconImage(Toolkit.getDefaultToolkit().getImage(new ClassPathResource("/images/fridge.png").getURL()));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        setTitle("Smart Fridge");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 740, 510);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(135, 206, 235));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        backButton = new JButton("Back");
        backButton.setForeground(new Color(255, 255, 255));
        backButton.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 18));
        backButton.setBackground(new Color(30, 144, 255));

        addButton = new JButton("Add");
        addButton.setForeground(new Color(255, 255, 255));
        addButton.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 18));
        addButton.setBackground(new Color(30, 144, 255));

        JLabel lblFoodsList = new JLabel("Foods List");
        lblFoodsList.setForeground(new Color(255, 255, 255));
        lblFoodsList.setFont(new Font("Perpetua Titling MT", Font.BOLD, 31));

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportBorder(null);
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(458, Short.MAX_VALUE)
                                .addComponent(addButton)
                                .addGap(18)
                                .addComponent(backButton)
                                .addGap(84))
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(68)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
                                        .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblFoodsList))
                                .addContainerGap(74, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addGap(51)
                                .addComponent(lblFoodsList)
                                .addGap(18)
                                .addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 188, GroupLayout.PREFERRED_SIZE)
                                .addGap(18)
                                .addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(addButton)
                                        .addComponent(backButton))
                                .addContainerGap(109, Short.MAX_VALUE))
        );

        table = new JTable() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 3;
            }
        };
        table.setRowHeight(36);
        scrollPane.setViewportView(table);
        table.setFillsViewportHeight(true);
        table.setBorder(new LineBorder(new Color(0, 0, 0), 0));
        table.setFont(new Font("Arial Narrow", Font.PLAIN, 16));
        contentPane.setLayout(gl_contentPane);
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JTable getTable() {
        return table;
    }

    class ButtonsPanel extends JPanel {
        public final List<JButton> buttons = new ArrayList<>();

        public ButtonsPanel() {
            super(new FlowLayout(FlowLayout.LEFT));
            setOpaque(true);
            for (Actions a : Actions.values()) {
                JButton b = new JButton(a.toString());

                b.setForeground(new Color(255, 255, 255));
                b.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 18));
                b.setBackground(a.color);

                b.setFocusable(false);
                b.setRolloverEnabled(false);
                add(b);
                buttons.add(b);
            }
        }

        protected void updateButtons(Object value) {
            if (value instanceof EnumSet) {
                EnumSet ea = (EnumSet) value;
                removeAll();
                if (ea.contains(Actions.EDIT)) {
                    add(buttons.get(0));
                }
                if (ea.contains(Actions.DELETE)) {
                    add(buttons.get(1));
                }
            }
        }
    }

    class ButtonsRenderer implements TableCellRenderer {
        private final ButtonsPanel panel = new ButtonsPanel();
        @Override public java.awt.Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            panel.setBackground(isSelected ? table.getSelectionBackground() : table.getBackground());
            panel.updateButtons(value);
            return panel;
        }
    }

    class EditAction extends AbstractAction {
        private final JTable table;

        public EditAction(JTable table) {
            super(Actions.EDIT.toString());
            this.table = table;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = table.convertRowIndexToModel(table.getEditingRow());
            Object o = table.getModel().getValueAt(row, 0);
            JOptionPane.showMessageDialog(table, "Editing: " + o);
        }
    }

    class DeleteAction extends AbstractAction {
        private final JTable table;

        public DeleteAction(JTable table) {
            super(Actions.DELETE.toString());
            this.table = table;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            int row = table.convertRowIndexToModel(table.getEditingRow());
            Object o = table.getModel().getValueAt(row, 0);
            JOptionPane.showMessageDialog(table, "Deleting: " + o);
        }
    }

    class ButtonsEditor extends AbstractCellEditor implements TableCellEditor {
        private final ButtonsPanel panel = new ButtonsPanel();
        private final JTable table;
        private Object o;

        private class EditingStopHandler extends MouseAdapter implements ActionListener {

            @Override
            public void mousePressed(MouseEvent e) {
                Object o = e.getSource();
                if (o instanceof TableCellEditor) {
                    actionPerformed(null);
                } else if (o instanceof JButton) {
                    System.out.println("Button pressed!");
                    ButtonModel m = ((JButton) e.getComponent()).getModel();
                    if (m.isPressed() && table.isRowSelected(table.getEditingRow()) && e.isControlDown()) {
                        panel.setBackground(table.getBackground());
                    }
                }
            }

            @Override
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        fireEditingStopped();
                    }
                });
            }
        }

        public ButtonsEditor(JTable table) {
            super();
            this.table = table;
            panel.buttons.get(0).setAction(new EditAction(table));
            panel.buttons.get(1).setAction(new DeleteAction(table));

            EditingStopHandler handler = new EditingStopHandler();
            for (JButton b : panel.buttons) {
                b.addMouseListener(handler);
                b.addActionListener(handler);
            }
            panel.addMouseListener(handler);
        }

        @Override
        public java.awt.Component getTableCellEditorComponent(
                JTable table, Object value, boolean isSelected, int row, int column) {
            panel.setBackground(table.getSelectionBackground());
            panel.updateButtons(value);
            o = value;
            return panel;
        }

        @Override
        public Object getCellEditorValue() {
            return o;
        }
    }

    public void initializeFoodTable(DefaultTableModel model) {

        table.setModel(model);

        // these column configs should be applied after the model is set
        table.getColumnModel().getColumn(0).setPreferredWidth(36);
        table.getColumnModel().getColumn(1).setPreferredWidth(10);
        table.getColumnModel().getColumn(2).setPreferredWidth(10);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(3).setCellRenderer(new ButtonsRenderer());
        table.getColumnModel().getColumn(3).setCellEditor(new ButtonsEditor(table));

    }
}

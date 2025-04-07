package wars;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * Provide a GUI interface for the game
 * 
 * @author A.A.Marczyk
 * @version 20/02/12
 */
public class GameGUI {
    private final SeaBattles game = new SeaBattles("Jarvis");
    private final JFrame frame = new JFrame("Game GUI");
    private final JTextArea display = new JTextArea(20, 40);

    public GameGUI() {
        setupFrame();
        setupMenu();
        setupButtons();
        frame.pack();
        frame.setVisible(true);
    }

    private void setupFrame() {
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        display.setEditable(false);
        frame.add(new JScrollPane(display), BorderLayout.CENTER);
    }

    private void setupButtons() {
        JPanel buttonPanel = new JPanel(new GridLayout(4, 1));
        
        String[] buttonLabels = {"View State", "Fight", "Clear", "Quit"};
        ActionListener[] actions = {
            e -> display.setText(game.toString()),
            e -> handleFight(),
            e -> display.setText(""),
            e -> System.exit(0)
        };
        
        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = new JButton(buttonLabels[i]);
            button.addActionListener(actions[i]);
            buttonPanel.add(button);
        }
        
        frame.add(buttonPanel, BorderLayout.EAST);
    }

    private void setupMenu() {
        JMenuBar menuBar = new JMenuBar();
        JMenu shipsMenu = new JMenu("Ships");
        
        String[] menuItems = {"List Squadron", "View a Ship", "Commission a Ship"};
        ActionListener[] menuActions = {
            e -> display.setText(game.getSquadron()),
            e -> handleViewShip(),
            e -> handleCommissionShip()
        };
        
        for (int i = 0; i < menuItems.length; i++) {
            JMenuItem item = new JMenuItem(menuItems[i]);
            item.addActionListener(menuActions[i]);
            shipsMenu.add(item);
        }
        
        menuBar.add(shipsMenu);
        frame.setJMenuBar(menuBar);
    }

    private void handleFight() {
        String input = JOptionPane.showInputDialog("Enter Encounter Number:");
        if (input != null && !input.trim().isEmpty()) {
            try {
                String result = game.fightEncounter(Integer.parseInt(input));
                JOptionPane.showMessageDialog(frame, result);
            } catch (NumberFormatException e) {
                showError("Invalid encounter number");
            }
        }
    }

    private void handleViewShip() {
        String shipName = JOptionPane.showInputDialog("Enter Ship Name:");
        if (shipName != null && !shipName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, game.getShipDetails(shipName));
        }
    }

    private void handleCommissionShip() {
        String shipName = JOptionPane.showInputDialog("Enter Ship Name to Commission:");
        if (shipName != null && !shipName.trim().isEmpty()) {
            JOptionPane.showMessageDialog(frame, game.commissionShip(shipName));
        }
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(frame, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new GameGUI());
    }
}
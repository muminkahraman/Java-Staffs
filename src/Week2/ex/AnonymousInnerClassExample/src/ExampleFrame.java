
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author gdm1
 */
public class ExampleFrame extends JFrame
{

    public ExampleFrame()
    {
        super("Anonymous Inner Class Example");
        setSize(400, 300);
        setLocation(200, 100);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setupGUI();

        setVisible(true);
    }

    private void setupGUI()
    {
        this.getContentPane().setBackground(Color.yellow);

        JPanel buttonsPanel = setupButtonsPanel();
        this.getContentPane().add(buttonsPanel, BorderLayout.SOUTH);
    }

    private JPanel setupButtonsPanel()
    {
        JButton b1 = new JButton("Blue background");
        b1.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        getContentPane().setBackground(Color.BLUE);
                    }
                }
        );
        
        JButton b2 = new JButton("Red background");
        b2.addActionListener(
                new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent ae)
                    {
                        getContentPane().setBackground(Color.RED);
                    }
                }
        );
        
        JPanel p = new JPanel(new FlowLayout());
        
        p.add(b1);
        p.add(b2);
        
        return p;
    }
}

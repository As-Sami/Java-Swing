import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class MAIN {
    public static void main(String[] args) {
        // JOptionPane = pop up a standard dialogue box that 
        // prompt user for a value or informs something

        // ParentComponent message title messageType
        // JOptionPane.showMessageDialog(null, "This is useless", "Title", JOptionPane.PLAIN_MESSAGE); 
        //INFORMATION_MESSAGE, QUESTION_MESSAGE, WARNING_MESSAGE, ERROR_MESSAGE
        
        // int answer = JOptionPane.showConfirmDialog(null, "Yes option", "This is title", JOptionPane.YES_OPTION);
        // System.out.println(answer);                             // YES_NO_CANCEL_OPTION, YES_NO_OPTION, 

        // String name = JOptionPane.showInputDialog(null, "What's your name ?");
        // Integer age = Integer.valueOf(JOptionPane.showInputDialog(null, "What's your age?"));
        // System.out.println(name);
        // System.out.println(age);

        ImageIcon icon = new ImageIcon("Gandu.png");
        String responces[] = {"Shishir", "Shohan", "Shohanuzzaman Shishir"};

        JOptionPane.showOptionDialog(null, 
                "Gandu kaun hein???", 
                "Select Gandu", 
                JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                icon, responces, null);


    }
}

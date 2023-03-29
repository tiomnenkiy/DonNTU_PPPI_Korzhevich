import java.nio.file.Files;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

/**
 * Модуль работы с документами
 * @author Vladimir
 * @version 1.0.1
 */
public class DocumentModule {
    List<String> data;
    JFrame frame;
    String path;

    public DocumentModule(JFrame frame) {
        this.frame = frame;
    }

    public void openDocument(String filename) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "bmp", "jpg", "jpeg", "gif", "png");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            data = Files.readAllLines(path);
        }
    }
    
    public void createDocument(String filename) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "bmp", "jpg", "jpeg", "gif", "png");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showSaveDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            Files.createFile(path);
        }
    }
    
    public void saveDocument(String filename) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "bmp", "jpg", "jpeg", "gif", "png");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showSaveDialog(frame);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            path = selectedFile.getAbsolutePath();
            Files.createFile(path);
            for (String str : data)
                Files.writeString(path, str);
        }
    }
}

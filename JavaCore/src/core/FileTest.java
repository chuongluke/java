package core;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Demonstrating the File class
 * 
 * @author no_name
 *
 */
public class FileTest extends JFrame implements ActionListener{
	
	private JTextField enter;
	private JTextArea output;
	
	public FileTest() {
		super("Testing class file");
		
		enter = new JTextField("Enter file or directory name here: ");
		enter.addActionListener(this);
		output = new JTextArea();
		Container c = getContentPane();
		ScrollPane p = new ScrollPane();
		
		p.add(output);
		c.add(enter, BorderLayout.NORTH);
		c.add(p, BorderLayout.CENTER);
		setSize(400, 400);
		show();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		File name = new File(e.getActionCommand());
		if(name.exists()){
			output.setText(name.getName()+" exists\n" + 
					(name.isFile() ? " is a file\n" : "is not a file\n") + 
					(name.isDirectory() ? "is a directory\n" : "is not a directory\n") +
					(name.isAbsolute() ? "is absolute path\n" : "is not absolute path\n") + 
					"Last modified: " + name.lastModified() +
					"\nLength: " + name.length() +
					"\nPath: " + name.getPath() + 
					"\nAbsolute path: " + name.getAbsolutePath()+
					"\nParent: " + name.getParent());
			
			if(name.isFile()){
				try {
					RandomAccessFile r = new RandomAccessFile(name, "r");
					StringBuffer buf = new StringBuffer();
					String text;
					output.append("\n\n");
					
					while((text = r.readLine()) != null){
						buf.append(text + "\n");
					}
					
					output.append(buf.toString());
					
				} catch (IOException e2) {
					JOptionPane.showMessageDialog(this, "FILE ERROR", "FILE ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}else if(name.isDirectory()){
				String directory[] = name.list();
				output.append("\n\nDirecto contents:\n");
				for (int i = 0; i < directory.length; i++) {
					output.append(directory[i] + "\n");
				}
			}
		}else{
			JOptionPane.showMessageDialog(this, e.getActionCommand() + " Does not exist!", "FILE ERROR", JOptionPane.ERROR_MESSAGE);
		}
	}

	public static void main(String[] args) {
		FileTest app = new FileTest();
		app.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
			
		});
	}
}

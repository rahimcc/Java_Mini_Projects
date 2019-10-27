import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.*;

public class MenuBar {
       JFrame j;
        Edit ed;
   ObjectOutputStream out;



        public MenuBar(Edit ed, JFrame j){
            this.ed=ed;
            this.j=j;
        }

    public JMenuBar getMenuBar() {
        JMenuBar  menuBar= new JMenuBar();
        JMenu  menu1=new JMenu("File");
        JMenu  menu2= new JMenu("Edit");
        JMenu  menu3=new JMenu("Tools");

        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        JMenuItem menu1_item1= new JMenuItem(new AbstractAction("New Project") {  //new project button that is creates a file which user gives and creates Object streamer to that file
            @Override
            public void actionPerformed(ActionEvent e) {

                JFileChooser jfc = new JFileChooser();
                int value = jfc.showOpenDialog(null);
                if (value == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jfc.getSelectedFile();
                    String name = selectedFile.getAbsolutePath(); // gets the path and name of file that user want to create

                    File file = new File( name + ".swg"); //project is created with extension of .swg
                    FileOutputStream fos = null;
                    try {
                        fos = new FileOutputStream(file, false);
                        out = new ObjectOutputStream(fos);  // object streamer to that file
                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }

                }
            }
        });


        menu1.add(menu1_item1);

        JMenuItem menu1_item2= new JMenuItem(new AbstractAction("Open File") {  // Open File Creates ObjectInputStreamer to existing file gets object inside of that file
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jfc = new JFileChooser();
                int value = jfc.showOpenDialog(null);
                if (value == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = jfc.getSelectedFile(); // gets the file user want to open

                    FileInputStream fin = null;
                    try {
                        fin = new FileInputStream(selectedFile.getAbsolutePath());
                        ObjectInputStream ois = new ObjectInputStream(fin); //Input streamer is created to that file
                        ed = (Edit) ois.readObject(); //getting the object inside of that file which should instance of Edit
                        j.setContentPane(ed); // setting that instance contentPane

                    } catch (FileNotFoundException e1) {
                        e1.printStackTrace();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    } catch (ClassNotFoundException e1) {
                        e1.printStackTrace();
                    }


                }
            }
        });


        menu1.add(menu1_item2);
        JMenuItem menu1_item3= new JMenuItem(new AbstractAction("Save Project") { // saves the object into created file using ObjectOutputStream out
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    out.writeObject(ed);
                    out.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

System.out.println("Succesful save ");

                }
            });


                menu1.add(menu1_item3);



        JMenuItem menu2_item1 = new JMenuItem(new AbstractAction("Create") { //Turns the state of application to be "Create"
            public void actionPerformed(ActionEvent e) {
                ed.state="Create";


            }
        });
        menu2.add(menu2_item1);

        JMenuItem menu2_item2 =  new JMenuItem(new AbstractAction("Move") { //Turns the state of application to be "Move"
            @Override
            public void actionPerformed(ActionEvent e) {
                ed.state="Move";
            }
        });

        menu2.add(menu2_item2);
        JMenuItem menu2_item3= new JMenuItem(new AbstractAction("Remove") { //Turns the state of application to be "Remove"
            @Override
            public void actionPerformed(ActionEvent e) {
                ed.state="Remove";

            }
        });
        menu2.add(menu2_item3);
        JMenuItem menu2_item4= new JMenuItem(new AbstractAction("Change") { //Turns the state of application to be "Change
            // "
            @Override
            public void actionPerformed(ActionEvent e) {
                ed.state="Change";
            }
        });
        menu2.add(menu2_item4);


        JMenuItem menu3_item1=new JMenuItem(new AbstractAction("Color") { //sets the color using JColorChooser
            @Override
            public void actionPerformed(ActionEvent e) {
                ed.c=JColorChooser.showDialog(new JFrame(),"Color",null);
            }
        });



        menu3.add(menu3_item1);
        JMenu menu3_item2=new JMenu("Shape");

        JMenuItem menu3_item3= new JMenuItem(new AbstractAction("Oval") { //sets the isOval variable to be true, to draw circle
            @Override
            public void actionPerformed(ActionEvent e) {
                ed.isOval=true;
            }
        });
        menu3_item2.add(menu3_item3);

        JMenuItem menu3_item4= new JMenuItem(new AbstractAction("Rectangle") { // sets the isOval variable to be false , to draw rectangle
            @Override
            public void actionPerformed(ActionEvent e) {
                ed.isOval=false;
            }
        });

        menu3_item2.add(menu3_item4);

        menu3.add(menu3_item2);






        return menuBar;
    }

}

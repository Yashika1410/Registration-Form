package registration_form_jdbc;


import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
public class registration_form {
String username,firstname,lastname,gender,password,mobileNumber,email,area,state,nationality,selectedState;
String course="",dob_day="",dob_month="",dob_year="",dob="";
private JFrame frame;
private JTextField textField;
private ButtonGroup gengp;
private JTextField textField_1;
private JTextField textField_2;
private JPasswordField passwordField;
private JTextField textField_3;
private JTextField textField_4;
private JTextField textField_6;
private JComboBox comboBox;
private JComboBox comboBox_1;
private JComboBox comboBox_2;
//private ButtonGroup cours;
int index,count;
private String dates[]
       = { "","1", "2", "3", "4", "5",
           "6", "7", "8", "9", "10",
           "11", "12", "13", "14", "15",
           "16", "17", "18", "19", "20",
           "21", "22", "23", "24", "25",
           "26", "27", "28", "29", "30",
           "31" };
   private String months[]
       = { "","1", "2", "3", "4", "5",
               "6", "7", "8", "9", "10",
               "11", "12" };
   private String years[]
       = { "","1995", "1996", "1997", "1998",
           "1999", "2000", "2001", "2002",
           "2003", "2004", "2005", "2006",
           "2007", "2008", "2009", "2010",
           "2011", "2012", "2013", "2014",
           "2015", "2016", "2017", "2018",
           "2019" };

/**
* Launch the application.
*/
public static void main(String[] args) {
EventQueue.invokeLater(new Runnable() {
public void run() {
try {
registration_form window = new registration_form();
window.frame.setVisible(true);
} catch (Exception e) {
e.printStackTrace();
}
}
});
}

/**
* Create the application.
*/
public registration_form() {
initialize();
}

/**
* Initialize the contents of the frame.
*/
private void initialize() {
frame = new JFrame("Registration Form");
frame.getContentPane().setFont(new Font("Dialog", Font.BOLD, 18));
frame.setBounds(100, 100, 837, 736);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

JLabel label = new JLabel("User Name");
label.setBounds(35, 30, 150, 37);
label.setFont(new Font("Dialog", Font.BOLD, 20));

textField = new JTextField();
textField.setBounds(285, 30, 180, 27);
textField.setFont(new Font("Dialog", Font.BOLD, 16));

JLabel lblNewLabel = new JLabel("First name");
lblNewLabel.setBounds(35, 78, 150, 22);
lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 20));

JLabel lblNewLabel_1 = new JLabel("Last name");
lblNewLabel_1.setBounds(35, 111, 162, 22);
lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 20));

textField_1 = new JTextField();
textField_1.setFont(new Font("Dialog", Font.BOLD, 16));
textField_1.setBounds(285, 68, 180, 32);
textField_1.setColumns(10);

textField_2 = new JTextField();
textField_2.setFont(new Font("Dialog", Font.BOLD, 16));
textField_2.setBounds(285, 112, 180, 23);
textField_2.setColumns(10);

JLabel label_1 = new JLabel("Gender");
label_1.setBounds(35, 144, 150, 40);
label_1.setFont(new Font("Dialog", Font.BOLD, 20));

JRadioButton radioButton = new JRadioButton("Male");
radioButton.setBounds(285, 155, 98, 25);
radioButton.setFont(new Font("Dialog", Font.BOLD, 18));
radioButton.setSelected(true);
radioButton.setActionCommand("Male");
JRadioButton radioButton_1 = new JRadioButton("Female");
radioButton_1.setBounds(385, 153, 103, 25);
radioButton_1.setFont(new Font("Dialog", Font.BOLD, 18));
radioButton_1.setActionCommand("Female");
gengp = new ButtonGroup();
gengp.add(radioButton);//for gender rb is male
gengp.add(radioButton_1);//rb_1 is for female

JLabel label_2 = new JLabel("Password");
label_2.setBounds(35, 204, 150, 37);
label_2.setFont(new Font("Dialog", Font.BOLD, 20));

passwordField = new JPasswordField();
passwordField.setBounds(285, 204, 180, 27);
passwordField.setFont(new Font("Dialog", Font.BOLD, 16));

JLabel label_3 = new JLabel("Date Of Birth");
label_3.setBounds(35, 261, 150, 38);
label_3.setFont(new Font("Dialog", Font.BOLD, 20));

comboBox= new JComboBox(dates);
comboBox.setBounds(285, 274, 54, 20);

comboBox_1 = new JComboBox(months);
comboBox_1.setBounds(340, 274, 54, 20);

comboBox_2 = new JComboBox(years);
comboBox_2.setBounds(391, 274, 67, 20);

JLabel label_4 = new JLabel("Mobile Number");
label_4.setBounds(35, 319, 150, 37);
label_4.setFont(new Font("Dialog", Font.BOLD, 20));

textField_3 = new JTextField();
textField_3.setBounds(285, 319, 180, 27);
textField_3.setFont(new Font("Dialog", Font.BOLD, 16));

JLabel label_5 = new JLabel("E-mail");
label_5.setBounds(35, 376, 150, 37);
label_5.setFont(new Font("Dialog", Font.BOLD, 20));

textField_4 = new JTextField();
textField_4.setBounds(285, 376, 180, 27);
textField_4.setFont(new Font("Dialog", Font.BOLD, 16));


JLabel label_8 = new JLabel("Nationality");
label_8.setBounds(35, 430, 150, 37);
label_8.setFont(new Font("Dialog", Font.BOLD, 20));

textField_6 = new JTextField();
textField_6.setBounds(285, 436, 180, 27);
textField_6.setFont(new Font("Dialog", Font.BOLD, 16));

//
JButton btnNewButton = new JButton("Register");
//
btnNewButton.setFont(new Font("Dialog", Font.BOLD, 18));
//
btnNewButton.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
getUserInformation();
validation();
registerUserData();

}

});
//
btnNewButton.setBounds(35, 610, 150, 23);
//
JButton btnNewButton_1 = new JButton("cancel");
//
btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 18));
//

//
btnNewButton_1.setBounds(255, 610, 103, 23);
frame.getContentPane().setLayout(null);
frame.getContentPane().add(btnNewButton);
frame.getContentPane().add(btnNewButton_1);
frame.getContentPane().add(label);
frame.getContentPane().add(textField);
frame.getContentPane().add(lblNewLabel);
frame.getContentPane().add(textField_1);
frame.getContentPane().add(lblNewLabel_1);
frame.getContentPane().add(textField_2);
frame.getContentPane().add(label_1);
frame.getContentPane().add(radioButton);
frame.getContentPane().add(radioButton_1);
frame.getContentPane().add(label_2);
frame.getContentPane().add(passwordField);
frame.getContentPane().add(label_3);
frame.getContentPane().add(comboBox_2);
frame.getContentPane().add(comboBox);
frame.getContentPane().add(comboBox_1);
frame.getContentPane().add(label_4);
frame.getContentPane().add(textField_3);
frame.getContentPane().add(label_5);
frame.getContentPane().add(textField_4);
frame.getContentPane().add(label_8);
frame.getContentPane().add(textField_6);
JRadioButton rdbtnOther = new JRadioButton("Other");
rdbtnOther.setFont(new Font("Dialog", Font.BOLD, 18));
rdbtnOther.setBounds(495, 154, 149, 23);
frame.getContentPane().add(rdbtnOther);
rdbtnOther.setActionCommand("Other");
gengp.add(rdbtnOther);
JCheckBox checkBox = new JCheckBox("C/C++");
checkBox.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		course+=" C/C++,";
	}
});
checkBox.setFont(new Font("Dialog", Font.BOLD, 16));
checkBox.setBounds(35, 521, 97, 26);
frame.getContentPane().add(checkBox);
JCheckBox checkBox_1 = new JCheckBox("Java");
checkBox_1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		course+=" Java,";
	}
});
checkBox_1.setFont(new Font("Dialog", Font.BOLD, 16));
checkBox_1.setBounds(151, 521, 97, 26);
frame.getContentPane().add(checkBox_1);
JCheckBox checkBox_2 = new JCheckBox("Python");
checkBox_2.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
	course+=" Python,";}
});
checkBox_2.setFont(new Font("Dialog", Font.BOLD, 16));
checkBox_2.setBounds(261, 523, 97, 23);
frame.getContentPane().add(checkBox_2);
JCheckBox checkBox_3 = new JCheckBox("IOT");
checkBox_3.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		course+=" IOT,";
	}
});
checkBox_3.setFont(new Font("Dialog", Font.BOLD, 16));
checkBox_3.setBounds(267, 567, 97, 23);
frame.getContentPane().add(checkBox_3);
JCheckBox checkBox_4 = new JCheckBox("ML");
checkBox_4.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		course+=" ML,";
	}
});
checkBox_4.setFont(new Font("Dialog", Font.BOLD, 16));
checkBox_4.setBounds(35, 567, 97, 23);
frame.getContentPane().add(checkBox_4);
JCheckBox checkBox_5 = new JCheckBox("Bigdata");
checkBox_5.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		course+=" BigData,";
	}
});
checkBox_5.setFont(new Font("Dialog", Font.BOLD, 16));
checkBox_5.setBounds(151, 567, 97, 23);
frame.getContentPane().add(checkBox_5);
JLabel label_6 = new JLabel("Course You Want to be Enroll");
label_6.setFont(new Font("Dialog", Font.BOLD, 22));
label_6.setBounds(45, 492, 311, 22);
frame.getContentPane().add(label_6);
btnNewButton_1.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent e) {
textField.setText("");
textField_1.setText("");
textField_2.setText("");
textField_3.setText("");
textField_4.setText("");
textField_6.setText("");
passwordField.setText("");
username = textField.getText();
firstname = textField_1.getText();
lastname = textField_2.getText();
password = passwordField.getText();
mobileNumber = textField_3.getText();
email = textField_4.getText();
nationality = textField_6.getText();
comboBox.setSelectedIndex(0);
comboBox_1.setSelectedIndex(0);
comboBox_2.setSelectedIndex(0);
radioButton.setSelected(true);
checkBox.setSelected(false);
checkBox_1.setSelected(false);
checkBox_2.setSelected(false);
checkBox_3.setSelected(false);
checkBox_4.setSelected(false);
checkBox_5.setSelected(false);
gender="";
course="";
}
});

}
//
public void getUserInformation() {
username = textField.getText();
firstname = textField_1.getText();
lastname = textField_2.getText();
password = passwordField.getText();
mobileNumber = textField_3.getText();
email = textField_4.getText();
nationality = textField_6.getText();
dob_day=(comboBox.getSelectedItem()).toString();
dob_month=(comboBox_1.getSelectedItem()).toString();
dob_year=(comboBox_2.getSelectedItem()).toString();
dob=dob_day+"-"+dob_month+"-"+dob_year;
gender=(gengp.getSelection().getActionCommand()).toString(); 
course=course.substring(0, course.length() - 1);
}
public void validation() {
count = 0;
if(username.equals(""))
{
JOptionPane.showMessageDialog(frame,"Enter User Name");
}
else if(firstname.equals(""))
{
JOptionPane.showMessageDialog(frame,"Enter First Name");
}
else if(lastname.equals(""))
{
JOptionPane.showMessageDialog(frame,"Enter Last Name");
}
else if(password.equals(""))
{
JOptionPane.showMessageDialog(frame,"Enter Password");
}
else if(dob_day.equals(""))
{
JOptionPane.showMessageDialog(frame,"Please Select DOB Date");
}
else if(dob_month.equals(""))
{
JOptionPane.showMessageDialog(frame,"Please Select DOB Month");
}
else if(dob_year.equals(""))
{
JOptionPane.showMessageDialog(frame,"Please Select DOB Year");
}
else if(mobileNumber.equals(""))
{
JOptionPane.showMessageDialog(frame,"Enter Mobile Number");
}

else if(email.equals(""))
{
JOptionPane.showMessageDialog(frame,"Enter E-Mail address");
}
else if(nationality.equals(""))
{
JOptionPane.showMessageDialog(frame,"Enter Nationality");
}
else {
if(email.contains("@") && email.contains(".com")) {
if(mobileNumber.length( )==10) {
count++;
}
else {
JOptionPane.showMessageDialog(frame,"Enter 10-digit moblie number");
}
}
else {
JOptionPane.showMessageDialog(frame,"Enter valid mail ID");
}

}
}

public void registerUserData() {
try {
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection(
	"jdbc:mysql://localhost:3306/DataBase","UserName","Password");
	//here sonoo is database name, root is username and password is 
	Statement stmt=con.createStatement();
		
if(count==1) {
//System.out.println("insert into reg_form (User_Name,First_Name,Last_Name,Gender,Password,DOB,Mobile_No,Email,Nationality) values (\""+username+"\",\""+firstname+"\",\""+lastname+"\",\""+gender+"\",\""+password+"\",\""+dob+"\",\""+mobileNumber+"\",\""+email+"\",\""+nationality+"\");");
stmt.executeUpdate("insert into reg_form (User_Name,First_Name,Last_Name,Gender,Password,DOB,Mobile_No,Email,Nationality,Course) values (\""+username+"\",\""+firstname+"\",\""+lastname+"\",\""+gender+"\",\""+password+"\",\""+dob+"\",\""+mobileNumber+"\",\""+email+"\",\""+nationality+"\",\""+course+"\");");
JOptionPane.showMessageDialog(frame,"You are Registered Successfully ");
}
con.close();
}
catch (Exception e) {
System.out.println("Exception1 is " + e);
}

}
}
//
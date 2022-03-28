//Technology Used: Java , Mysql and Used JDBC (Java Database Connectivity)
//and I didn't mentioned the code of Mysql tables here , so if anyone looking for those table , please make your own tables and you van take hints from fields declared here.
//Thanks
//First user will be required to login
private void loginbtnActionPerformed(java.awt.event.ActionEvent evt) {
String ID = txt.getText();
String pwd = new String(txtpwd.getPassword());
String str = null;
Statement stmt = null;
ResultSet rs = null;
Connection conn = null;
try{
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql:// localhost:3306 /airbase","root","123456");
stmt = conn.createStatement();
String sql = "Select * From login where ID = ' "+ID+"' ; ";
rs = stmt.executeQuery(sql);
rs.next();
str = rs.getString("Password");
rs.close();
stmt.close();
conn.close();
if(str.equals(pwd)){
8
new Menu().setVisible(true);
this.setVisible(false);
}
else {
JOptionPane.showMessageDialog(rootPane,"Incorrect ID or Password");
txt.setText("");
txtpwd.setText("");
txt.grabFocus();
}
}
catch (Exception e){ JOptionPane.showMessageDialog(rootPane, "Incorrect Password or ID or
Error In Connection");
}

//NOW A NEW MAIN MENU WILL OPEN IN FRONT OF USER IF USER ID AND PASSWORD MATCHES TO STORED VALUES IN AIRBASE DATABASE IN MY SQL.Customer will be required to choose only one option from available choices.


private void nextbtnActionPerformed(java.awt.event.ActionEvent evt) {
if(optb.isSelected()){
JOptionPane.showMessageDialog(rootPane,"Welcome To Flight Booking Section");
new Booking().setVisible(true);
9
this.setVisible(false);
}
else if(optc.isSelected()){
JOptionPane.showMessageDialog(rootPane,"We are procedding you to ticket Cancel Section");
new Cancel().setVisible(true);
this.setVisible(false);
}
else if(optF.isSelected()){
JOptionPane.showMessageDialog(rootPane,"We are proceeding you to view flight details");
new viewflight().setVisible(true);
this.setVisible(false);
}
else if(optT.isSelected()){
JOptionPane.showMessageDialog(rootPane,"We are proceeding you to view Ticket details");
new viewticket1().setVisible(true);
this.setVisible(false);
}
else if(opte.isSelected()){
JOptionPane.showMessageDialog(rootPane,"Thank You For Visiting us");
System.exit(0);
}

//IF USER CHOOSE BOOKING TICKETS OPTION THEN BOOKING TICKET SECTION WILL APPEAR IN FRONT OF USER.
//Customer will book ticket from here and pay money by visiting link sent to him/her to the provided Email Id .

private void submitbtnActionPerformed(java.awt.event.ActionEvent evt) {
String Name = txtN.getText();
String DOB = txtD.getText();
String Gender = null;
if(optM.isSelected()) Gender = "Male";
else Gender = "Female";
String Mobile = txtM.getText();
String Address = txtA.getText();
String Journey = txtJ.getText();
String Fcity = txtF.getText();
String Tcity = txtT.getText();
String Email = txtE.getText();
Statement stmt = null;
Connection conn = null;
try{
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airbase","root","123456");
11
stmt = conn.createStatement();
String sql ="Insert into book values (
'"+Name+"','"+DOB+"','"+Gender+"','"+Mobile+"','"+Address+"','"+Journey+"','"+Email+"','"+Fcity+"','"+Tcity+"') ";
stmt.executeUpdate(sql);
stmt.close();
conn.close();
JOptionPane.showMessageDialog(rootPane,"Ticket Booking is Successful");
JOptionPane.showMessageDialog(rootPane, "You are request to Pay ticket charges . Payment
Information and other Details are Emailed to your Email ID.");
new Menu().setVisible(true);
this.setVisible(false);
}
catch (Exception e ){
JOptionPane.showMessageDialog(rootPane, "Incorrect Records Or Error In Connection");
txtN.setText("");
txtD.setText("");
txtM.setText("");
txtA.setText("");
txtJ.setText("");
txtE.setText("");
btg.clearSelection();
}
private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {
txtN.setText("");
txtD.setText("");
txtM.setText("");
txtA.setText("");
txtJ.setText("");
txtE.setText("");
btg.clearSelection();
}
12
private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {
new Menu().setVisible(true);
this.setVisible(false);
}
private void cancelbtnActionPerformed(java.awt.event.ActionEvent evt) {
JOptionPane.showMessageDialog(rootPane, "Thanks for visiting us");
System.exit(0);
}

//IF CANCEL TICKETS OPTION IS CHOOSED THEN CANCEL TICKET SECTION WILL APPEAR IN FRONT OF USER AND RECORDS AND SAVED TO TABLE NAMED ‘CANCEL’ IN MY SQL. User will be required to enter his/her ticket booking details to cancel his/her tickets.

private void submitbtnActionPerformed(java.awt.event.ActionEvent evt) {
String Name = txtN.getText();
String DOB = txtD.getText();
String Journey = txtJ.getText();
String Mobile = txtM.getText();
String Email = txtE.getText();
Statement stmt = null;
Connection conn = null;
13
try{
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airbase","root","123456");
stmt = conn.createStatement();
String sql ="Insert into cancel values ( '"+Name+"','"+DOB+"','"+Mobile+"','"+Journey+"','"+Email+"') ";
stmt.executeUpdate(sql);
stmt.close();
conn.close();
JOptionPane.showMessageDialog(rootPane,"Ticket Cancellation Is Successfull");
JOptionPane.showMessageDialog(rootPane, "Your Money will be refunded within 24 hours. Other
Details are Emailed to your Email ID.");
new Menu().setVisible(true);
this.setVisible(false);
} catch (Exception e ){
JOptionPane.showMessageDialog(rootPane, "Incorrect Records Or Error In Connection");
txtN.setText("");
txtD.setText("");
txtM.setText("");
txtJ.setText("");
txtE.setText("");
txtN.grabFocus();
}
}
private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {
txtN.setText("");
txtD.setText("");
txtM.setText("");
txtJ.setText("");
txtE.setText("");
txtN.grabFocus();
14
}
private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {
new Menu().setVisible(true);
this.setVisible(false);
}
private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {
JOptionPane.showMessageDialog(rootPane, "Thanks for visiting us");
System.exit(0);
}

//IF VIEW FLIGHT DETAILS OPTION IS SELECTED ,THEN VIEW FLIGHT DETAILS SECTION WILL APPEAR IN FRONT OF USER . USER WILL BE REQUIRED TO ENTER FLIGHT NUMBER AND THEN BY CLICKING ON BUTTON USER WILL KNOW ABOUT FROM CITY TO TOCITY LOCATION OF FLIGHT
private void showbtnActionPerformed(java.awt.event.ActionEvent evt) {
String FlightNO = txt.getText();
String From =null;
String To=null;
Statement stmt = null;
ResultSet rs = null;
Connection conn = null;
try{
Class.forName("com.mysql.jdbc.Driver");
15
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airbase","root","123456");
stmt = conn.createStatement();
String sql = "Select * From flight where FlightNO = '"+FlightNO+"' ; ";
rs = stmt.executeQuery(sql);
rs.next();
From = rs.getString("FCity");
To = rs.getString("TCity");
rs.close();
stmt.close();
conn.close();
lblF.setText(From);
lblT.setText(To);
}
catch (Exception e){JOptionPane.showMessageDialog(rootPane, "Incorrect Flight Number OR Error In
Connection");
}
}
private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {
System.exit(0);
}
private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {
JOptionPane.showMessageDialog(rootPane,"Thank you for reaching us");
new Menu().setVisible(true);
this.setVisible(false);
}
private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {
txt.setText("");
lblF.setText("");
lblT.setText("");
txt.grabFocus();
}

//IF USER CLICKS CHECK TICKET STATUS AND WILL BE REQUIRED TO ENTER NAME AND MOBILE NUMBER .
// APPLICATION SEARCHES THESE TWO FIELDS IN THE ‘BOOK’ TABLE IN MYSQL. IF RECORD WITH THE ENTERED DETILS IS PRESENT THEN IT WILL RETURN ALL DETAILS OF THE USER WHEN CLICKED ON BUTTON AND A CONFIRMATION MESSAGE TO THE USER ABOUT CONFIRMED TICKET . IF RECORD IS NOT PRESENT ,THEN IT WILL RETURN AN ERROR .

private void findbtnActionPerformed(java.awt.event.ActionEvent evt) {
String Name = txtN.getText();
String Mobile = txtM.getText();
Statement stmt = null;
ResultSet rs = null;
Connection conn = null;
try{
Class.forName("com.mysql.jdbc.Driver");
conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/airbase","root","123456");
stmt = conn.createStatement();
17
String sql = "Select * From book where Name = '"+Name+"' and Mobile = '"+Mobile+"' ; ";
rs = stmt.executeQuery(sql);
rs.next();
String DOB = rs.getString("DOB");
String Journey = rs.getString("Journey");
String From = rs.getString("Fcity");
String Tocity = rs.getString("TCity");
String Email = rs.getString("Email");
rs.close();
stmt.close();
conn.close();
lblDOB.setText(DOB);
lblJ.setText(Journey);
lblF.setText(From);
lblT.setText(Tocity);
lblE.setText(Email);
JOptionPane.showMessageDialog(rootPane,"CONGRATULATIONS! YOUR Ticket Has been
Confirmed.");
}
catch (Exception e){JOptionPane.showMessageDialog(rootPane, "Incorrect Name OR Mobile Number
OR Error In Connection");
}
}
private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {
txtN.setText("");
txtM.setText("");
lblDOB.setText("");
lblJ.setText("");
lblF.setText("");
lblT.setText("");
lblE.setText("");
18
txtN.grabFocus();
}
private void backbtnActionPerformed(java.awt.event.ActionEvent evt) {
JOptionPane.showMessageDialog(rootPane,"You Will be redirected to Main Menu");
new Menu().setVisible(true);
this.setVisible(false);
}
private void exitbtnActionPerformed(java.awt.event.ActionEvent evt) {
System.exit(0);
}

//IF USER SELECT EXIT OPTION IN MAIN MENU ,THEN ON CLICK OF NEXT BUTTON , APPLICATION WILL CLOSE.


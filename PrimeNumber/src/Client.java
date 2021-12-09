import java.io.*;
import java.net.*;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Client extends Application {
  // IO streams
  DataOutputStream toServer = null;
  DataInputStream fromServer = null;

  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
// initiating the panel by setting styles and padding
    BorderPane topPanel = new BorderPane();
    topPanel.setPadding(new Insets(10, 10, 10, 10)); 
    topPanel.setStyle("-fx-border-color: orange");
    topPanel.setLeft(new Label("Enter a number to check if prime: "));
    
    TextField field = new TextField();
    field.setAlignment(Pos.BOTTOM_RIGHT);
    topPanel.setCenter(field);
    
    BorderPane mainPane = new BorderPane();
    // Text area to display contents
    TextArea textBox = new TextArea();
    mainPane.setCenter(new ScrollPane(textBox));
    mainPane.setStyle("-fx-border-color: yellow");
    mainPane.setTop(topPanel);
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(mainPane, 500, 250);
    primaryStage.setTitle("Client"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    field.setOnAction(e -> {
      try {
        // Getting the number entered from the text field as double
        
        double number = Double.parseDouble(field.getText().trim());
    	  //int number = Integer.parseInt(tf.getText().trim());
  
        // sending the number to the server
       toServer.writeDouble(number);  
        //toServer.writeInt(number);
        toServer.flush();
  
        // getting the answer from the server
        //double area = fromServer.readDouble();
        //boolean base = fromServer.readBoolean();
       
       //boolean value = fromServer.readBoolean();
       // boolean isprime = fromServer.readBoolean();
        // ta.appendText("\n");
        //double answer = fromServer.readDouble();
        String answer = fromServer.readUTF();
        //System.out.println(answer);
        //String answer_yes = fromServer.readUTF();
        
        //ta.appendText("Number entered is " + number + "\n");
        //displaying to the textbox the results from the server about the number entered
        textBox.appendText("Is "  + number + " a prime number? ----> " +answer + "!"+ "\n");
//        if(answer_yes == "Yes") {
//        	System.out.println("yes prime - client");
//        	ta.appendText("Yes!" + number + " is a prime number.\n");
//        	ta.appendText("\n");
//        }
//
//        else{
//        	System.out.println("no prime - client");
//        	ta.appendText("No! " + number + " is not a prime number.\n");
//        	ta.appendText("\n");
//        }
        
      }
      catch (IOException ex) {
        System.err.println(ex);
      }
    });
  
    try {
      // Creating a socket to connect to the server
      Socket socket = new Socket("localhost", 8000);

      // Creating an input stream to receive data from the server
      fromServer = new DataInputStream(socket.getInputStream());

      // Creating an output stream to send data to the server
      toServer = new DataOutputStream(socket.getOutputStream());
    }
    catch (IOException ex) {
    	textBox.appendText(ex.toString() + "\n");
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}

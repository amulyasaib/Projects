
import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Server extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    // Text area for displaying contents
    TextArea textBox = new TextArea();

    // creating the scene and staging it
    Scene scene = new Scene(new ScrollPane(textBox), 450, 200);
    primaryStage.setTitle("Server");
    primaryStage.setScene(scene);
    primaryStage.show(); 
    
    new Thread( () -> {
      try {
        // Creating the server socket
        ServerSocket serverSocket = new ServerSocket(8000);
        Platform.runLater(() ->
        textBox.appendText("Server started at " + new Date() + '\n'));
  
        // Connection request
        Socket socket = serverSocket.accept();
  
        // Creating the data input and output streams
        DataInputStream inputFromClient = new DataInputStream(
          socket.getInputStream());
        DataOutputStream outputToClient = new DataOutputStream(
          socket.getOutputStream());
  
        while (true) {
        	// reading the number from the client as double
        	double number = inputFromClient.readDouble();
        	// int number = inputFromClient.readInt();
//        if(number == 0 || number == 1) {
//        	boolean incorrect = false;
//        	outputToClient.writeBoolean(incorrect);
//        }
        	// assignign the value out putted from the prime function to the answer string 
        	String answer = Prime(number);
        	//out putting to the client the asnwer as UTF(string)
        	outputToClient.writeUTF(answer);
  
          Platform.runLater(() -> {

        	  //displaying to the textbox the number entered from the client
        	  textBox.appendText("Number received from client to check if the number is prime is " + number + '\n'); 
          });
        }
      }
      catch(IOException ex) {
        ex.printStackTrace();
      }
    }).start();
  }


  public static void main(String[] args) {
    launch(args);
  }
  // function to determine if the number entered is prime
  public static String Prime(double number) {
	  // base case - 0 and 1 are never prime
	  if(number == 0 || number == 1) {
    		return "No";
	  }
	  // for loop to check if the values greater than 1 are prime
      for(int i =2; i<Math.sqrt(number);i++) {
//    	  System.out.println( number + " divided by " + i);
      	// if statement to check if the remainder is zero -> if zero then it is  not a prime number
      	if(number % i ==0) {

      		return "No";

      	}
      }
      // if the remainder is not zero then the number is prime
	return "Yes";
  }
}



import javafx.application.Application;
import javafx.event.ActionEvent;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import javafx.stage.Stage;

public class CalcFX extends Application
{
  TextField txtnum1, txtnum2;
  Button btnadd, btnsub, btndiv, btnmul, btnmod, btnexp, btnfac, btnsqr, btnsin, btncos, btntan, btnclear;
  Label lblanswer;

  @Override
  public void start(Stage theStage)
  {
    //make controls
    txtnum1   = new TextField();
    txtnum2   = new TextField();
    btnadd    = new Button("+");
    btnsub    = new Button("-");
    btnmul    = new Button("x");
    btndiv    = new Button("/");
    btnmod    = new Button("%");
    btnexp    = new Button("^");
    btnfac    = new Button("x!");
    btnsqr    = new Button("sqrt");
    btnsin    = new Button("sin");
    btncos    = new Button("cos");
    btntan    = new Button("tan");
    btnclear  = new Button("Clear");
    lblanswer = new Label("?");

    //Clear 'em
    txtnum1.setText("0");
    txtnum2.setText("0");

    //center text in Label
    lblanswer.setAlignment(Pos.CENTER);
    //apply css-like style to Label

    lblanswer.setStyle("-fx-border-color: #000; -fx-padding: 5px;");

    //make container for app
    GridPane root = new GridPane();
    //put container in middle of scene
    root.setAlignment(Pos.CENTER);
    //set spacing between controls
    root.setHgap(10);
    root.setVgap(10);
    //add to grid, cell by cell
    root.add(btnadd,  0,0);
    root.add(btnsub,  1,0);
    root.add(btnmul,  0,1);
    root.add(btndiv,  1,1);
    root.add(btnmod,  0,2);
    root.add(btnexp,  1,2);
    root.add(btnfac,  0,3);
    root.add(btnsqr,  1,3);
    root.add(btnsin,  0,4);
    root.add(btncos,  1,4);
    root.add(btntan,  0,5);
    root.add(txtnum1, 0,6);
    root.add(txtnum2, 1,6);

    root.add(lblanswer, 0, 7, 2, 1);
    root.add(btnclear, 0, 8, 2, 1);
    //set widths of all controls in method
    setWidths();
    //attach buttons to code in method
    linkButtonFunctions();
    //usual stuff for apps
    Scene scene = new Scene(root, 300, 500);
    theStage.setTitle("Mathemagic 2.0");
    theStage.setScene(scene);
    theStage.show();
  }
    public void setWidths()
    {
      //set widths of all controls
      txtnum1.setPrefWidth(70);
      txtnum2.setPrefWidth(70);
      btnadd.setPrefWidth(70);
      btnsub.setPrefWidth(70);
      btnmul.setPrefWidth(70);
      btndiv.setPrefWidth(70);
      btnmod.setPrefWidth(70);
      btnexp.setPrefWidth(70);
      btnfac.setPrefWidth(70);
      btnsqr.setPrefWidth(70);
      btnsin.setPrefWidth(70);
      btncos.setPrefWidth(70);
      btntan.setPrefWidth(70);
      btnclear.setPrefWidth(150);
      lblanswer.setPrefWidth(150);
    }
    public void linkButtonFunctions()
    {
      //have each button run buttonFunctions when clicked
      btnadd.setOnAction(e    -> buttonFunctions(e));
      btnsub.setOnAction(e    -> buttonFunctions(e));
      btnmul.setOnAction(e    -> buttonFunctions(e));
      btndiv.setOnAction(e    -> buttonFunctions(e));
      btnmod.setOnAction(e    -> buttonFunctions(e));
      btnexp.setOnAction(e    -> buttonFunctions(e));
      btnfac.setOnAction(e    -> buttonFunctions(e));
      btnsqr.setOnAction(e    -> buttonFunctions(e));
      btnsin.setOnAction(e    -> buttonFunctions(e));
      btncos.setOnAction(e    -> buttonFunctions(e));
      btntan.setOnAction(e    -> buttonFunctions(e));
      btnclear.setOnAction(e  -> buttonFunctions(e));
    }

    public void buttonFunctions(ActionEvent e)
    {
      Double num1, num2, answer;
      String symbol;
      //e tells us which button was clicked "Event"

      if(e.getSource() == btnclear)
      {
        txtnum1.setText("0");
        txtnum2.setText("0");
        lblanswer.setText("?");
        txtnum1.requestFocus();
        return;
      }
      //read numbers in from textfields
      num1 = Double.parseDouble(txtnum1.getText());
      num2 = Double.parseDouble(txtnum2.getText());
      if(e.getSource() == btnadd)
      {
        symbol = "+";
        answer = num1 + num2;
        lblanswer.setText("" + num1 + symbol + num2 + " = " + answer);
      }
      else if(e.getSource() == btnsub)
      {
        symbol = "-";
        answer = num1 - num2;
        lblanswer.setText("" + num1 + symbol + num2 + " = " + answer);
      }
      else if(e.getSource() == btnmul)
      {
        symbol = "x";
        answer = num1 * num2;
        lblanswer.setText("" + num1 + symbol + num2 + " = " + answer);
      }
      else if(e.getSource() == btnmod)
      {
        symbol = "%";
        answer = num1 % num2;
        lblanswer.setText("" + num1 + symbol + num2 + " = " + answer);
      }
      else if(e.getSource() == btnexp)
      {
        symbol = "^";
        answer = Math.pow(num1,num2);
      }
      else if(e.getSource() == btnfac)
      {
        symbol      = "!";
        answer      = Double.parseDouble(txtnum1.getText());
        int count   = Integer.parseInt(txtnum1.getText());
        for(int i = 1; i < count; i++) {
          answer = answer * i;
        }
        num2 = 0.0;
        lblanswer.setText(num1 + "! = " + answer);
      }
      else if(e.getSource() == btnsqr)
      {
        symbol = "sqrt";
        answer = Math.sqrt(num1);
        lblanswer.setText("sqrt(" + num1 + ") = " + answer);
      }
      else if(e.getSource() == btnsin)
      {
        symbol = "sin";
        answer = Math.sin(num1);
        lblanswer.setText("sin(" + num1 + ") = " + answer);
      }
      else if(e.getSource() == btncos)
      {
        symbol = "cos";
        answer = Math.cos(num1);
        lblanswer.setText("cos(" + num1 + ") = " + answer);
      }
      else if(e.getSource() == btntan)
      {
        symbol = "tan";
        answer = Math.tan(num1);
        lblanswer.setText("tan(" + num1 + ") = " + answer);
      }
      else
      {
        symbol = "/";
        answer = num1 / num2;
        lblanswer.setText("" + num1 + symbol + num2 + " = " + answer);
      }

      //display answer
      //lblanswer.setText("" + num1 + symbol + num2 + " = " + answer);

    }
    public static void main(String[] args) {
      launch(args);
    }

}

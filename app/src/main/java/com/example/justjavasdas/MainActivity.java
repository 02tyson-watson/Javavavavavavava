package com.example.justjavasdas;

import androidx.appcompat.app.AppCompatActivity;
import java.text.NumberFormat;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

/**

 This app displays an order form to order coffee
 */

public class MainActivity extends AppCompatActivity {
    int numberOfCoffees = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**

     This method is called when the order is clicked.
     */
    public void submitOrder(View view) {
        TextView ordered = (TextView)findViewById(R.id.ordered);
        ordered.setText("Successfully Ordered!");
    }

    public void plus_quantity(View view){
        numberOfCoffees++;
        display(numberOfCoffees);
        displayPrice(numberOfCoffees * 5);
    }

    public void minus_quantity (View view){
        if (numberOfCoffees < 1) {
            display(0);
            displayPrice(numberOfCoffees * 5);
        }
        else {
            numberOfCoffees--;
            display(numberOfCoffees);
            displayPrice(numberOfCoffees * 5);
        }
    }
    /**

     This method displays the given quantity value on screen.
     */
    private void display(int number) {
        TextView quantityTextView = findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance(new Locale("en", "US")).format(number));
    }
}
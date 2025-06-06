// Java program for the 
// above approach
import java.util.*;
class GFG{

// Stores the current 
// visiting page
static String current_state_url = "";

// Stores url when pressed forward
static Stack<String> 
       forward_stack = new Stack<>();

// Stores url when pressed backward
static Stack<String> 
       backward_stack = new Stack<>();

// Function for when visit a url
static void visit_new_url(String url)
{
  // If current URL is empty
  if (current_state_url != "")
  {
    // Push into backward_stack
    backward_stack.add(
             current_state_url);
  }

  // Set curr_state_url to url
  current_state_url = url;
}

// Function to handle state 
// when the forward button 
// is pressed
static void forward()
{
  // If current url is the last url
  if (forward_stack.isEmpty() || 
      current_state_url == 
      forward_stack.peek()) 
  {
    System.out.print("Not Available\n");
    return;
  }

  // Otherwise
  else 
  {
    // Push current state to the
    // backward stack
    backward_stack.add(
             current_state_url);

    // Set current state to top
    // of forward stack
    current_state_url = 
            forward_stack.peek();

    // Remove from forward 
    // stack
    forward_stack.pop();
  }
}

// Function to handle state
// when the backward button 
// is pressed
static void backward()
{
  // If current url is the 
  // last url
  if (backward_stack.isEmpty() || 
      current_state_url == 
      backward_stack.peek()) 
  {
    System.out.print("Not Available\n");
    return;
  }

  // Otherwise
  else 
  {
    // Push current url to the
    // forward stack
    forward_stack.add(
            current_state_url);

    // Set current url to top
    // of backward stack
    current_state_url = 
            backward_stack.peek();

    // Pop it from backward 
    // stack
    backward_stack.pop();
  }
}

// Function that performs the 
// process of pressing forward 
// and backward button in a
// Browser
static void simulatorFunction()
{
  // Current URL
  String url = "ajay.com";

  // Visit the current URL
  visit_new_url(url);

  // Print the current URL
  System.out.print("Current URL is: " + 
                   current_state_url + 
                   " \n");

  // New current URL
  url = "abc.com";

  // Visit the current URL
  visit_new_url(url);

  // Print the current URL
  System.out.print("Current URL is: " + 
                   current_state_url + 
                   " \n");

  // Pressed backward button
  backward();

  // Print the current URL
  System.out.print("Current URL after pressing" + 
                   " Backward button is: " + 
                   current_state_url + " \n");

  // Pressed forward button
  forward();

  // Print the current URL
  System.out.print("Current URL after pressing" + 
                   " Forward button is: " + 
                   current_state_url + " \n");

    // New current URL
    url = "nikhil.com";

    // Visit the current URL
    visit_new_url(url);

    // Print the current URL
    System.out.print("Current URL is: " + 
                     current_state_url + 
                     " \n");

    // Pressed forward button
    forward();

    // Print the current URL
    System.out.print("Current URL after pressing" + 
                     " Forward button is: " + 
                     current_state_url + " \n");
    // Pressed backward button
    backward();

    // Print the current URL
    System.out.print("Current URL after pressing" + 
                     " Backward button is: " + 
                     current_state_url + " \n");
}

// Driver Code
public static void main(String[] args)
{
  // Function to simulate process of
  // pressing forward & backward button
  simulatorFunction();
}
}

// This code is contributed by shikhasingrajput
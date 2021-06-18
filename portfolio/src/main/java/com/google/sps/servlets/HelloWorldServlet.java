package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import com.google.gson.Gson;
/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    ArrayList<String> stringList = new ArrayList<String>();
    stringList.add("Favorite Quote: Per Aspera Ad Astra");
    stringList.add("Favorite Movie: Good Will Hunting");
    stringList.add("Favorite Book: Crime and Punishment");
    String json = convertToJson(stringList);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }
  private String convertToJson(ArrayList<String> stringList) {
    Gson gson = new Gson();
    String json = gson.toJson(stringList);
    return json;
  }
}

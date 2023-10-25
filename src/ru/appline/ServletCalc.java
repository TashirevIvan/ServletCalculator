package ru.appline;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/post")
public class ServletCalc extends HttpServlet {

    public static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private final Calculator calculator = new Calculator();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        StringBuffer jb = new StringBuffer();
        String line;
        try {
            BufferedReader reader = request.getReader();
            while ((line = reader.readLine()) != null) {
                jb.append(line);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }

        JsonObject jobj = gson.fromJson(String.valueOf(jb), JsonObject.class);

        request.setCharacterEncoding("UTF-8");

        double firstVal = jobj.get("firstVal").getAsDouble();
        String operand = jobj.get("operand").getAsString();
        double secVal = jobj.get("secVal").getAsDouble();

        double res = calculator.calculate(firstVal, operand, secVal);

        response.setContentType("application/json=utf=8");
        PrintWriter pw = response.getWriter();
        pw.print(gson.toJson(res));
    }

}

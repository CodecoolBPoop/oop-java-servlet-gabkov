package com.codecool.servlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ShoppingCartServlet", urlPatterns = {"/shopping-cart"}, loadOnStartup = 2)
public class ShoppingCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();

        StringBuilder sb = new StringBuilder();

        String title = "Shopping Cart";

        sb.append("<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<table>\n");

        for (Item item: ItemStore.getItemList()){
            sb.append("<tr>" +
                    "<td>" + item.getName() + "</td>" +
                    "<td>" + (int) item.getPrice() + " USD</td>" +
                    "</tr>\n");
        }

        sb.append("</table>\n" +
                "<br>" +
                "<div>Sum of Price: "+ ItemStore.getSumPrice() + " USD</div>\n" +
                "</body></html>");

        out.println(sb.toString());
    }
}

package com.codecool.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "WebShopServlet", urlPatterns = {"/"}, loadOnStartup = 1)
public class WebShopServlet extends HttpServlet {

    public void init() throws ServletException {
        ItemStore.addToAvailable(new Item("DVD", 20));
        ItemStore.addToAvailable(new Item("LAPTOP", 200));
        ItemStore.addToAvailable(new Item("CHIPS", 5));
        ItemStore.addToAvailable(new Item("BEER", 6));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {

        PrintWriter out = response.getWriter();
        String title = "WebShop by GabKov";

        if(request.getParameter("add") != null){
            for(Item item : ItemStore.getAvailableItems()){
                if(request.getParameter("add").equals(item.getName())) {
                    ItemStore.add(item);
                }
            }
            response.sendRedirect("/");
        } else if(request.getParameter("remove") != null){
            for(Item item : ItemStore.getItemList()){
                if(request.getParameter("remove").equals(item.getName())) {
                    ItemStore.remove(item);
                    break;
                }
            }
            response.sendRedirect("/");
        }

        StringBuilder sb = new StringBuilder();

        sb.append("<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body>\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<table>\n");

        for (Item item: ItemStore.getAvailableItems()){
            sb.append("<tr>" +
                        "<td>" + item.getName() + "</td>" +
                        "<td>" + (int) item.getPrice() + " USD</td>" +
                        "<form action=\"/\"><td><button type=\"submit\" name=\"add\" value=\""+ item.getName() + "\">Add</button></td></form>\n"+
                        "<form action=\"/\"><td><button type=\"submit\" name=\"remove\" value=\"" + item.getName() + "\">Remove</button></td></form>\n" +
                    "</tr>\n");
        }

        sb.append("</table>\n" +
                "<br>" +
                "<div><a href=\"/shopping-cart\">Check Shopping Cart</a></div>\n" +
                "</body></html>");

        out.println(sb.toString());

    }
}

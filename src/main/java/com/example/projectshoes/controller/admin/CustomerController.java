package com.example.projectshoes.controller.admin;

import com.example.projectshoes.model.CustomerModel;
import com.example.projectshoes.service.ICustomerService;
import java.io.IOException;
import java.util.List;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/admin-customers")
public class CustomerController extends HttpServlet {

    @Inject
    ICustomerService customerService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        List<CustomerModel> customerModels = customerService.findAllCustomer();
        req.setAttribute("customers", customerModels);
        for (CustomerModel c : customerModels) {
            if (c.getUser().getStatus().equals("Active")) {
                c.setBadge("success");
            } else {
                c.setBadge("danger");
            }
        }
        RequestDispatcher rd = req.getRequestDispatcher("/views/admin/LIST/ListCustomer.jsp");
        rd.forward(req, resp);
    }
}

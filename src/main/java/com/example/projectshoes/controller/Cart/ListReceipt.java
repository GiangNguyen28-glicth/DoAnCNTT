package com.example.projectshoes.controller.Cart;

import com.example.projectshoes.constant.SystemConstant;
import com.example.projectshoes.model.SaledetailModel;
import com.example.projectshoes.model.UserModel;
import com.example.projectshoes.service.ISaledetailService;
import com.example.projectshoes.utils.FormUtil;
import com.example.projectshoes.utils.SessionUtil;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list-receipt")
public class ListReceipt extends HttpServlet {

  @Inject
  ISaledetailService saledetailService;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    SaledetailModel saledetailModel = FormUtil.toModel(SaledetailModel.class, req);
    UserModel user = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");

    List<SaledetailModel> saledetailModelList;
    if (user != null) {
      if (saledetailModel.getPage() == null) {
        saledetailModel.setPage(1);
      }
//      saledetailModelList = saledetailService.findAllbyUserID(user.getId(),
//          saledetailModel.getPage());
//      int size = saledetailModelList.size();
//      user.setTotalItem(size);
//      user.setTotalPage(SystemConstant.totalPageReceipt / 5);
      user.setPage(saledetailModel.getPage());
//      req.setAttribute("receipts", saledetailModelList);
      req.setAttribute("model", user);
    }
    RequestDispatcher rq = req.getRequestDispatcher("/views/web/listReceipt.jsp");
    rq.forward(req, resp);
  }
}

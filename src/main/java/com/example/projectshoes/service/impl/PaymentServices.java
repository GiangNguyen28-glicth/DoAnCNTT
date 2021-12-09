package com.example.projectshoes.service.impl;

import com.example.projectshoes.model.LineItem;
import com.example.projectshoes.service.IPaymentServices;
import com.example.projectshoes.utils.CartModel;
import com.paypal.api.payments.*;
import com.paypal.base.rest.APIContext;
import com.paypal.base.rest.PayPalRESTException;

import java.util.ArrayList;
import java.util.List;

public class PaymentServices implements IPaymentServices {

  private static final String CLIENT_ID ="AdY9SCvo7omxFUNxQQgapxexPYsEzQBId55TrT4BwoqQk25HxRViuE4jI1vqcazjVRS2cUbKboBG0xG-";
  private static final String CLIENT_SECRET = "ENumMlDmymh8vtjFINaNS4U-OGcpi_rWYlGpS1_oFPgWeEiOKYiZE2qVt6d-m4V82H81MIqfNIofqAY7";
  private static final String MODE = "sandbox";

  @Override
  public String authorizePayment(CartModel cartModel) {
    try {
      Payer payer = getPayerInformation();
      RedirectUrls redirectUrls = getRedirectUrls();
      List<Transaction> listTransactions = getTransactionInformation(cartModel);
      Payment requestPayment = new Payment();
      requestPayment.setTransactions(listTransactions)
          .setRedirectUrls(redirectUrls)
          .setPayer(payer)
          .setIntent("authorize");
      APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
      Payment approvedPayment = requestPayment.create(apiContext);
      return getApprovalLink(approvedPayment);
    } catch (PayPalRESTException e) {
      e.printStackTrace();
      return null;
    }
  }

  public Payment getPaymentDetails(String paymentId) throws PayPalRESTException {
    APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
    return Payment.get(apiContext, paymentId);
  }

  private String getApprovalLink(Payment approvedPayment) {
    List<Links> links = approvedPayment.getLinks();
    String approvalLink = null;
    for (Links e : links) {
      if (e.getRel().equalsIgnoreCase("approval_url")) {
        approvalLink = e.getHref();
      }
    }
    return approvalLink;
  }

  private RedirectUrls getRedirectUrls() {
    RedirectUrls redirectUrls = new RedirectUrls();
    redirectUrls.setCancelUrl("http://localhost:8080/cart?action=addtocart");
    redirectUrls.setReturnUrl("http://localhost:8080/review_payment");
    return redirectUrls;
  }

  private List<Transaction> getTransactionInformation(CartModel cartModel) {

    Details details = new Details();
    details.setShipping(String.format("%.2f", 0F));
    details.setSubtotal(String.format("%.2f",cartModel.totalPrice()));
    details.setTax(String.format("%.2f", 0F));

    Amount amount = new Amount();
    amount.setCurrency("USD");
    amount.setTotal(String.format("%.2f", cartModel.totalPrice()));
    amount.setDetails(details);

    Transaction transaction = new Transaction();
    transaction.setAmount(amount);
//    transaction.setDescription(saledetailModel.getProduct().getName());
    ItemList itemList = new ItemList();
    List<Item> items = new ArrayList<Item>();
    for (int i = 0; i < cartModel.getItems().size(); i++) {
      LineItem lineItem = cartModel.getItems().get(i);
      Item item = new Item();
      item.setCurrency("USD")
              .setName(lineItem.getProduct().getName())
              .setPrice(lineItem.getProduct().getPrice().toString())
              .setQuantity(String.valueOf(lineItem.getQuantity()));
      items.add(item);
    }
    itemList.setItems(items);
    transaction.setItemList(itemList);
    List<Transaction> listTransaction = new ArrayList<Transaction>();
    listTransaction.add(transaction);
    return listTransaction;
  }

  public Payer getPayerInformation() {
    Payer payer = new Payer();
    payer.setPaymentMethod("paypal");

    PayerInfo payerInfo = new PayerInfo();
    payerInfo.setFirstName("Ho")
        .setLastName("Phong")
        .setEmail("19110262@student.hcmute.edu.vn");
    payer.setPayerInfo(payerInfo);
    return payer;
  }

  public Payment executePayment(String paymentId, String payerId) throws PayPalRESTException {
    PaymentExecution paymentExecution = new PaymentExecution();
    paymentExecution.setPayerId(payerId);
    Payment payment = new Payment().setId(paymentId);
    APIContext apiContext = new APIContext(CLIENT_ID, CLIENT_SECRET, MODE);
    return payment.execute(apiContext, paymentExecution);
  }
}

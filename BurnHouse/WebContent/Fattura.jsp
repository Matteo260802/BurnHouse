<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" import="java.util.*, model.Orderbean, model.ProductBean"%>
<%@ page import="model.*" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>BurnHouse</title>
<link rel="stylesheet" type="text/css" href="./CSS/FatturaStile.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/html2pdf.js/0.10.1/html2pdf.bundle.min.js"></script>
<script>
  function downloadAsPDF() {
    var element = document.getElementById("content").cloneNode(true);
    var options = {
      filename: 'fattura.pdf',
      html2canvas: {
        scale: 2
      },
      jsPDF: {
        unit: 'mm',
        format: 'a4',
        orientation: 'portrait'
      }
    };

    // Rimuovi i pulsanti dalla copia del contenuto
    var downloadButton = element.querySelector("#downloadButton");
    var printButton = element.querySelector("#printButton");
    if (downloadButton) {
      downloadButton.parentNode.removeChild(downloadButton);
    }
    if (printButton) {
      printButton.parentNode.removeChild(printButton);
    }

    html2pdf()
      .set(options)
      .from(element)
      .save();
  }
</script>
</head>
<body>
	
	

	<%
	String Ordine=request.getParameter("nOrdine");
	int nOrdine = Integer.parseInt(Ordine);
    OrderDAO model = new OrderDAO();
    Collection<CartProduct> products = model.DoRetrieveByOrder(nOrdine);
    String codice=request.getParameter("code");
    int cod=Integer.parseInt(codice);
    Orderbean ordine = model.DoRetrieveByKey(cod);
	%>

	

  <div id="content">
    <h2><div style="text-align:center">BURN HOUSE</div></h2>
    

	<h1>Fattura</h1>
  
  
  <%
  String data=request.getParameter("data");
  String nome=request.getParameter("nome");
  String cognome=request.getParameter("cognome");
  String indirizzo=ordine.GetInd();
  %>
  
  <table>
    <tr>
      <th>Numero fattura:</th>
      <td><%=nOrdine %></td>
    </tr>
    <tr>
      <th>Data fatturazione:</th>
      <td><%=data%></td>
    </tr>
    <tr>
      <th>Cliente:</th>
      <td><%=nome%> <%=cognome%></td>
    </tr>
    <tr>
      <th>Indirizzo di spedizione:</th>
      <td><%=indirizzo%></td>
    </tr>
  </table>
  
  
  
  <h2>Dettagli Fattura</h2>
  
  <table>
    <tr>
      <th>Prodotto</th>
      <th>Quantità</th>
      <th>Prezzo unitario</th>
      <th>Totale</th>
    </tr>
    
    <% for (CartProduct bean : products) { %>
    <tr>
      <td><%=bean.GetNome() %></td>
      <td><%=bean.GetQuantita() %></td>
      <td><%=bean.GetPrezzo() %>€</td>
      <td><%=bean.GetPrezzo()*bean.GetQuantita() %>€</td>
    </tr>
	<%} %>  
  </table>
  
  <h2>Totale: <%=String.format("%.2f", ordine.GetPrice())%>€</h2>


    <br>
    <button id="downloadButton" onclick="downloadAsPDF()">Scarica fattura come PDF</button>
    <br>
    <button id="printButton" onclick="window.print();">Stampa fattura</button>
  </div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8" 
pageEncoding="UTF-8" import="java.util.*, model.Orderbean, model.ProductBean"%>
<%@ page import="model.*" %>
<%@taglib prefix="e" uri="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>BurnHouse</title>
<link rel="stylesheet" type="text/css" href="./CSS/FatturaStile.css">
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
  
  /*
  Prima di prendere i dati dalla richiesta per essere usati devono essere controllati, 
  altrimenti potrebbero essere inviati dati dannosi o indesiderati, per fare questo usiamo
  la funzione forHtml che esegue l'encoding dei dati, andando a trasformare eventuali 
  caratteri speciali e prevenendo il Cross-Site Scripting.
  */
  
  
  String data=request.getParameter("data");
  String encodedData = org.owasp.encoder.Encode.forHtml(data);
  
  
  String nome=request.getParameter("nome");
  String encodedNome = org.owasp.encoder.Encode.forHtml(nome);
  
  String cognome=request.getParameter("cognome");
  String encodedCognome = org.owasp.encoder.Encode.forHtml(cognome);
  
  String indirizzo=ordine.GetInd();
  String encodedInd = org.owasp.encoder.Encode.forHtml(indirizzo);
  %>
  
  <table>
    <tr>
      <th>Numero fattura:</th>
      <td><%=nOrdine %></td>
    </tr>
    <tr>
      <th>Data fatturazione:</th>
      <td><%= encodedData%></td>
    </tr>
    <tr>
      <th>Cliente:</th>
      <td><%=encodedNome%> <%=encodedCognome%></td>
    </tr>
    <tr>
      <th>Indirizzo di spedizione:</th>
      <td><%=encodedInd%></td>
    </tr>
  </table>
  
  
  
  <h2>Dettagli Fattura</h2>
  
  <table>
    <tr>
      <th>Prodotto</th>
      <th>Quantità</th>
      <th>Prezzo unitario</th>
      <th>Iva</th>
      <th>Totale</th>
    </tr>
    
    <% for (CartProduct bean : products) { %>
    <tr>
      <td><%=bean.GetNome() %></td>
      <td><%=bean.GetQuantita() %></td>
      <td><%=String.format("%.2f",bean.GetPrezzo()) %>€</td>
      <% double iva = (bean.GetPrezzo()*22)/100; %>
      <td><%= String.format("%.2f",iva) %>€</td>
      <td><%=String.format("%.2f",(bean.GetPrezzo()+iva)*bean.GetQuantita()) %>€</td>
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
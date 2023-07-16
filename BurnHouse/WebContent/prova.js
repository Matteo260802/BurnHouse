// Aggiungi un gestore di eventi per il pulsante di scorrimento precedente
    document.querySelector('.pre-btn1').addEventListener('click', function() {
        const productContainer = document.querySelector('.product-container1');
        productContainer.scrollLeft -= productContainer.offsetWidth;
    });

    // Aggiungi un gestore di eventi per il pulsante di scorrimento successivo
    document.querySelector('.nxt-btn1').addEventListener('click', function() {
        const productContainer = document.querySelector('.product-container1');
        productContainer.scrollLeft += productContainer.offsetWidth;
    });
     
    
// Aggiungi un gestore di eventi per il pulsante di scorrimento precedente
document.querySelector('.pre-btn2').addEventListener('click', function() {
    const productContainer = document.querySelector('.product-container2');
    productContainer.scrollLeft -= productContainer.offsetWidth;
});

// Aggiungi un gestore di eventi per il pulsante di scorrimento successivo
document.querySelector('.nxt-btn2').addEventListener('click', function() {
    const productContainer = document.querySelector('.product-container2');
    productContainer.scrollLeft += productContainer.offsetWidth;
});   



// Aggiungi un gestore di eventi per il pulsante di scorrimento precedente
document.querySelector('.pre-btn3').addEventListener('click', function() {
    const productContainer = document.querySelector('.product-container3');
    productContainer.scrollLeft -= productContainer.offsetWidth;
});

// Aggiungi un gestore di eventi per il pulsante di scorrimento successivo
document.querySelector('.nxt-btn3').addEventListener('click', function() {
    const productContainer = document.querySelector('.product-container3');
    productContainer.scrollLeft += productContainer.offsetWidth;
}); 

    
  
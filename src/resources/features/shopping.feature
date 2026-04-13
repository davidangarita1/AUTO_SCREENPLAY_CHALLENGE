Feature: Compras en la tienda

  Scenario: Agregar dos productos al carrito
    Given el usuario se encuentra en la pagina principal de la tienda
    When agrega el producto "MacBook" al carrito
    And agrega el producto "iPhone" al carrito
    Then el carrito muestra 2 productos en total

  Scenario: Visualizar el carrito
    Given el usuario se encuentra en la pagina principal de la tienda
    When agrega el producto "MacBook" al carrito
    And agrega el producto "iPhone" al carrito
    And accede al carrito de compras
    Then el carrito muestra el producto "MacBook"
    And el carrito muestra el producto "iPhone"

  Scenario: Completar el checkout como invitado
    Given el usuario se encuentra en la pagina principal de la tienda
    When agrega el producto "MacBook" al carrito
    And accede al checkout
    And selecciona la opcion de checkout como invitado
    And completa los datos de facturacion
    Then el paso de metodo de pago es visible

  Scenario: Finalizar la compra hasta la confirmacion
    Given el usuario se encuentra en la pagina principal de la tienda
    When agrega el producto "MacBook" al carrito
    And accede al checkout
    And selecciona la opcion de checkout como invitado
    And completa los datos de facturacion
    And acepta los terminos y continua con el metodo de pago
    And confirma el pedido
    Then el sistema muestra el mensaje "Your order has been placed!"

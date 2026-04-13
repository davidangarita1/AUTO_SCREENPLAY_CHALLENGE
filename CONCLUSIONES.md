# Conclusiones

## Hallazgos del ejercicio

### Proceso de compra en la tienda

La tienda OpenCart permite a los clientes completar una compra en **4 pasos**:

1. **Opciones de cuenta** - El cliente elige si desea registrarse o continuar como invitado.
2. **Datos de facturacion** - Se ingresan los datos personales y la direccion de envio.
3. **Metodo de pago** - Se selecciona la forma de pago y se aceptan los terminos y condiciones.
4. **Confirmacion del pedido** - Se revisa el resumen de la compra y se confirma el pedido.

La tienda no incluye un paso separado para seleccionar el metodo de envio, lo cual simplifica el flujo para el usuario final.

### Experiencia del usuario al agregar productos

- Al agregar un producto al carrito, la tienda muestra una notificacion de exito que confirma la accion al cliente. Esta notificacion se cierra automaticamente o de forma manual.
- El contador del carrito en la parte superior de la pagina se actualiza de inmediato, permitiendo al cliente conocer la cantidad de productos y el monto total sin necesidad de navegar al carrito.

### Formulario de facturacion

- Cuando el cliente selecciona un pais, las opciones de region o estado se actualizan de forma dinamica. Esto es importante porque garantiza que solo se presenten opciones validas segun el pais seleccionado, reduciendo errores en el proceso de compra.

### Carrito de compras

- El carrito de compras muestra en detalle cada producto agregado, incluyendo nombre, modelo, cantidad, precio unitario y total. Esto permite al cliente verificar su seleccion antes de proceder al checkout.
- El acceso al carrito es posible tanto desde el enlace en el encabezado de la tienda como mediante navegacion directa, lo cual brinda flexibilidad al usuario.

### Confirmacion de compra

- Al finalizar el proceso, la tienda presenta el mensaje **"Your order has been placed!"**, lo cual confirma al cliente que su pedido fue registrado exitosamente.

## Resultados

Se validaron los 4 escenarios principales del flujo de compra:

| Escenario | Descripcion | Estado |
|---|---|---|
| Agregar productos al carrito | El cliente puede agregar multiples productos y el carrito refleja la cantidad correcta | Exitoso |
| Visualizar el carrito | El cliente puede ver los productos agregados con su nombre y detalle | Exitoso |
| Checkout como invitado | El cliente puede completar el proceso de pago sin necesidad de crear una cuenta | Exitoso |
| Compra completa | El cliente recibe la confirmacion de su pedido al finalizar todo el flujo | Exitoso |

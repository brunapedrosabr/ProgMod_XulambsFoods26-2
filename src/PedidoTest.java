import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PedidoTest {
    
    /*
    Pedido pedido;
    @BeforeEach
    public void setUp(){
        pedido = new Pedido();
    }
    */

    @Test
    public void naoAdicionaPizzaEmPedidoFechado(){
        //Arrange
        Pedido pedido = new Pedido();
        pedido.adicionarPizza(new Pizza());
        pedido.fecharPedido();

        //Act
        int quantidade = pedido.adicionarPizza(new Pizza());
    
        //Assert
        assertEquals(1, quantidade);
    }

    @Test
    public void testaValorAPagar(){
        //Arrange
        Pedido pedido = new Pedido();
        Pizza pizza1 = new Pizza();
        Pizza pizza2 = new Pizza();
        Pizza pizza3 = new Pizza();
        pizza1.adicionarIngredientes(4);//29 + 20 = 49 
        pizza2.adicionarIngredientes(8);//29 + 40 = 69
        pizza3.adicionarIngredientes(10);//29 + 0 = 29
        pedido.adicionarPizza(pizza1);
        pedido.adicionarPizza(pizza2);
        pedido.adicionarPizza(pizza3);
        pedido.fecharPedido();
    
        //Assert
        assertEquals(147, pedido.precoAPagar(),0.01);
    }

    @Test
    public void testaCupom(){
        //Arrange
        Pedido pedido = new Pedido();
        Pizza pizza1 = new Pizza();
        Pizza pizza2 = new Pizza();
        pizza1.adicionarIngredientes(2);//29 + 10 = 39 
        pizza2.adicionarIngredientes(5);//29 + 25 = 54
        pedido.adicionarPizza(pizza1);
        pedido.adicionarPizza(pizza2);
        pedido.fecharPedido();
    
        //Act
        String relatorio = pedido.relatorio();

        //Assert
        assertTrue( 
            relatorio.contains("2 ingredientes") &&
            relatorio.contains("5 ingredientes") &&
            relatorio.contains("39,00") &&
            relatorio.contains("54,00") &&
            relatorio.contains("93,00")
        );
    }
}

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PizzaTest {

    /*
    Pizza pizza;
    int ingredientesPadrao;

    @BeforeEach
    public void setUp(){
        //Arrange
        ingredientesPadrao = 4;
        pizza = new Pizza(ingredientesPadrao);
    }

    Testes: começa com 4. Tenta adicionar negativo. Tenta adicionar 8 excesso.
    */

    @Test
    public void adicionaIngredientesCorretamente(){
        //Arrange
        Pizza pizza = new Pizza();
        //Act
        int quantos = pizza.adicionarIngredientes(4);
        //Assert
        assertEquals(4, quantos);
    }

    @Test
    public void testaLimiteDeIngredientes(){
        //Arrange
        Pizza pizza = new Pizza();
        //Act
        int quantos = pizza.adicionarIngredientes(10);
        //Assert
        assertEquals(0, quantos);
    }

    @Test 
    public void testaValorFinal(){
        //Arrange
        Pizza pizza = new Pizza();
        //Act
        pizza.adicionarIngredientes(6);
        //Assert
        assertEquals(59.00,(double)pizza.valorFinal(),0.01);
    }

    @Test 
    public void testaCupom(){
        //Arrange
        Pizza pizza = new Pizza();
        //Act
        pizza.adicionarIngredientes(4);
        String cupom = pizza.gerarCupom();
        IO.println(cupom);
        //Assert
        assertTrue(cupom.contains("4 ingredientes") && cupom.contains("29,00") && cupom.contains("20,00") && cupom.contains("49,00"));
    }
    
}

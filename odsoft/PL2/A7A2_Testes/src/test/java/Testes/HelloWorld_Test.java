//Pachage
package Testes;

//Imports
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class HelloWorld_Test
{

  @Test
  public void mainShouldPrintHelloWorld()
  {

    //Variaveis locais
    example.HelloWorld clsTeste = new example.HelloWorld();
    String[] teParametroL = {"",""};

    //Teste
    assertEquals("A execução do metodo main deve imprimir no ecrã: Helo Word", 0, clsTeste.main(teParametroL));

  }

}

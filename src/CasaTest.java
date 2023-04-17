
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class CasaTest {
    Casa casaTest;
    Endereco enderecoTest;
    @BeforeEach
    public void prepare(){
        casaTest = new Casa(500000, 2010, 2, 500);
        enderecoTest = new Endereco("Rua RuaTeste", "BairroTeste", "203");
    }

    @Test
    public void deveCalcularOvalorDoDesconto(){
        assertEquals(0.2, casaTest.calculaValorDesconto());
    }

    @Test
    public void deveCalcularOValorDoAluguel(){
        assertEquals(548.33, casaTest.calculaValorAluguel());
    }

    @Test
    public void deveFormatarOendereço(){
        casaTest.enderecoImovel(enderecoTest);
        assertTrue(casaTest.enderecoFormatado().contains("RUA RUATESTE, BAIRROTESTE" +
                ", 203"));
    }
}

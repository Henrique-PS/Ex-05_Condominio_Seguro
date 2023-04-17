import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ApartamentoTest {
    Apartamento apartamentoTest;
    Endereco enderecoTest;

    @BeforeEach
    public void prepare(){
        apartamentoTest = new Apartamento(500000, 2019, 1, 1);
        enderecoTest = new Endereco("Rua RuaTeste", "BairroTeste", "203", "804A");
    }

    @Test
    public void deveCalcularOvalorDoDesconto(){
        assertEquals(0, apartamentoTest.calculaValorDesconto());
    }

    @Test
    public void deveCalcularOValorDoAluguel(){
        assertEquals(2600, apartamentoTest.calculaValorAluguel());
    }

    @Test
    public void deveFormatarOendereço(){
        apartamentoTest.enderecoImovel(enderecoTest);
        assertTrue(apartamentoTest.enderecoFormatado().contains("RUA RUATESTE, BAIRROTESTE" +
                ", 203, 804A"));
    }
}

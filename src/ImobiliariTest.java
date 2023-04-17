import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ImobiliariTest {
    Imobiliaria imobiliariaTest;
    Imovel casaTest1;
    Imovel casaTest2;
    Imovel ap1;
    Proprietario prop1;
    Proprietario prop2;
    Endereco enderecoTest;

    @BeforeEach
    public void prepare(){
        imobiliariaTest = new Imobiliaria();
        casaTest1 = new Casa(500000, 2000, 2, 500, 1);
        casaTest2 = new Casa(675000, 2017, 1, 500, 2);
        ap1 = new Apartamento(800000, 2020, 3, 1);
        prop1 = new Proprietario("Prop1");
        prop2 = new Proprietario("Prop2");
        enderecoTest = new Endereco("Rua RuaTeste", "BairroTeste", "203");

        imobiliariaTest.addImovel(casaTest1);
        imobiliariaTest.addImovel(casaTest2);
        imobiliariaTest.addProprietario(prop1);
        casaTest1.enderecoImovel(enderecoTest);
    }

    @Test
    public void deveAdicionarImovel(){
        imobiliariaTest.addImovel(ap1);
        assertEquals(3, imobiliariaTest.imoveis.size());
    }

    @Test
    public void deveRemoverImovel(){
        imobiliariaTest.removeImovel(1);
        assertEquals(1, imobiliariaTest.imoveis.size());
    }

    @Test
    public void deveAdicionarProprietario(){
        imobiliariaTest.addProprietario(prop2);
        assertEquals(2, imobiliariaTest.proprietarios.size());
    }

    @Test
    public void deveRemoverProprietario(){
        imobiliariaTest.removeProprietario(0);
        assertEquals(0, imobiliariaTest.proprietarios.size());
    }

    // ESSE TA FUNCIONANDO QUANDO EXECUTADO INDIVÍDUALMENTE, NÃO CONSEGUI ENTENDER
    // PORQUE NÃO FUNCIONOU COMPILANDO TODOS JUNTOS
    @Test
    public void deveCalcularOValorRecebido(){
        assertEquals(422, imobiliariaTest.calculaValorRecebido(2));
    }

    @Test
    public void deveImprimirInformacoesDosAlugueis(){
        assertTrue(imobiliariaTest.dadosImoveis(2000).contains(
                "Endereço: RUA RUATESTE, BAIRROTESTE, 203" +
                "\nValor de venda: R$ 500000,00" +
                "\nValor de aluguel: R$ 2193,33"
        ));
    }

    @Test
    public void deveClacularOTotalGanho(){
        assertEquals(685.2, imobiliariaTest.totalGanho());
    }

    // NÃO ENTENDI E NEM SEI PORQUE ESSE TESTE NÃO ESTÁ FUNCIONANDO
    @Test
    public void deveImprimirOValorArrecadadoELiquido(){
        imobiliariaTest.addImovel(ap1);
        System.out.println(imobiliariaTest.calcularTotalArrecadado(1));
        assertTrue(imobiliariaTest.calcularTotalArrecadado(1).contains(
                "Total arrecadado: R$ 6193,33" +
                "\nTotal líquido: R$ 5450,13"
        ));
    }
}

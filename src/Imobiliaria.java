import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Imobiliaria {
    protected List<Imovel> imoveis;
    protected List<Proprietario> proprietarios;
    private final double COMISSAO = 0.12;
    private double valorRecebido;
    private double ganhoTotal;
    private double totalArrecadado;
    private double valorLiquido;
    DecimalFormat formatter = new DecimalFormat("#.00");

    //#region Contrutores

    /**
     * Cria uma nova Imobiliária
     */
    public Imobiliaria() {
        this.imoveis = new ArrayList<>();
        this.proprietarios = new ArrayList<>();
    }
    //#endregion

    // #region Métodos de negócio

    /**
     * Adiciona um imóvel á lista de imóveis
     * @param novoImovel O imóvel a ser adicionado
     * @return True caso o consiga adicionar o imóvel, FALSE caso contrário
     */
    public boolean addImovel(Imovel novoImovel){
        return imoveis.add(novoImovel);
    }

    /**
     * Remove um imóvel da lista de imóveis
     * @param idImovel O id do imóvel a ser removido
     * @return O imóvel removido
     */
    public Imovel removeImovel(int idImovel){
        return imoveis.remove(idImovel);
    }

    /**
     * Adiciona um proprietária á lista de imóveis
     * @param proprietario O proprietária a ser adicionado
     * @return True caso o consiga adicionar o proprietário, FALSE caso contrário
     */
    public boolean addProprietario(Proprietario proprietario){
        return proprietarios.add(proprietario);
    }

    /**
     * Remove um proprietário da lista de imóveis
     * @param idProprietario O id do proprietário a ser removido
     * @return O proprietário removido
     */
    public Proprietario removeProprietario(int idProprietario){
        return proprietarios.remove(idProprietario);
    }

    /**
     * Calcular o valor recebido pela imobiliária por um aluguel (12% de comissão)
     * @param idImovel O id do imóvel
     * @return O valor recebido
     */
    public double calculaValorRecebido(int idImovel){
        for (Imovel imovel : imoveis) {
            if(idImovel == imovel.getId()){
                valorRecebido = imovel.calculaValorAluguel() * this.COMISSAO;
            }
        }

        return Math.round(valorRecebido * 100.0)/100.0;
    }

    /**
     * Imprimie dados de imóveis pelo ano de construção. Formato:
     * Endereço: <imovel.enderecoFormatado>
     * Valor de venda: R$ <imovel.valorVenda>
     * Valor de aluguel: R$ <imovel.calcualValorAluguel>
     * @param anoConstrucao Ano da construção dos imóveis
     * @return String no formato indicado
     */
    public String dadosImoveis(int anoConstrucao){
        StringBuilder aux = new StringBuilder();

        for (Imovel imovel : imoveis) {
            if(anoConstrucao == imovel.ano){
                aux.append("Endereço: " + imovel.enderecoFormatado());
                aux.append("\nValor de venda: R$ " + formatter.format(imovel.valorVenda));
                aux.append("\nValor de aluguel: R$ " + formatter.format(imovel.calculaValorAluguel()));
            }
        }

        return aux.toString();
    }

    /**
     * Mostrar o ganho total da administradora com todos os imóveis
     * @return O ganho total;
     */
    public double totalGanho(){
        for (Imovel imovel : imoveis) {
            this.ganhoTotal += calculaValorRecebido(imovel.getId());
        }

        return this.ganhoTotal;
    }

    /**
     * Mostrar, para os proprietários dos imóveis, o valor total arrecadado com aluguéis de suas
     * propriedades, e os valores líquidos a serem repassados a eles. Formato
     * Total arrecadado: R$ <totalArrecadado>
     * Total liquido: R$ <valorLiquido>
     * @return String no formato indicado
     */
    public String calcularTotalArrecadado(int idProprietario){
        StringBuilder aux = new StringBuilder();

        for (Proprietario proprietario : proprietarios){
            if (proprietario.getId() == idProprietario){
                for (Imovel imovel : imoveis) {
                    if(proprietario.getId() == imovel.idProprietario){
                        totalArrecadado += imovel.calculaValorAluguel();
                        valorLiquido += imovel.calculaValorAluguel() * (1 - this.COMISSAO);
                    }
                }
            }
        }

        aux.append("Total arrecadado: R$ " + formatter.format(this.totalArrecadado));
        aux.append("\nTotal líquido: R$ " + formatter.format(this.valorLiquido));
        return aux.toString();
    }
    //#endregion
}

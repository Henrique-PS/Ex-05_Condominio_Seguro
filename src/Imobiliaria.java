import java.util.List;

public class Imobiliaria {
    private List<Imovel> imoveis;
    private List<Proprietario> proprietarios;
    private final double COMISSAO = 0.12;
    private double valorRecebido;
    private double ganhoTotal;
    private double totalArrecadado;
    private double valorLiquido;

    public Imobiliaria() {
        this.imoveis = imoveis;
        this.proprietarios = proprietarios;
    }

    public boolean addImovel(Imovel imovel){
        return imoveis.add(imovel);
    }

    public double valorRecebido(Endereco enderecoAluguel){
        for (Imovel imovel : imoveis) {
            if(enderecoAluguel == imovel.endereco){
                valorRecebido = imovel.calculaValorAluguel() * this.COMISSAO;
            }
        }

        return valorRecebido;
    }

    public String dadosImoveis(int anoConstrucao){
        StringBuilder aux = new StringBuilder();

        for (Imovel imovel : imoveis) {
            if(anoConstrucao == imovel.ano){
                aux.append("Endereço: " + imovel.enderecoFormatado());
                aux.append("\nValor de Venda: " + imovel.valorVenda);
                aux.append("\nValor de aluguel: " + imovel.calculaValorAluguel());
            }
        }

        return aux.toString();
    }

    public double totalGanho(){
        for (Imovel imovel : imoveis) {
            this.ganhoTotal += valorRecebido(imovel.endereco);
        }

        return this.ganhoTotal;
    }

    public String calcularTotalArrecadado(int idProprietario){
        StringBuilder aux = new StringBuilder();

        for (Proprietario proprietario : proprietarios){
            if (proprietario.getId() == idProprietario){
                for (Imovel imovel : imoveis) {
                    totalArrecadado += imovel.calculaValorAluguel();
                    valorLiquido += imovel.calculaValorAluguel() - (imovel.calculaValorAluguel() * this.COMISSAO);
                }
            }
        }

        aux.append("Total arrecadado: " + this.totalArrecadado);
        aux.append("\nTotal liquido: " + this.valorLiquido);
        return aux.toString();
    }
}

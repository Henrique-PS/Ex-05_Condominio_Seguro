import java.util.ArrayList;
import java.util.List;

public class Proprietario {
    protected List<Imovel> imoveisPossuidos;
    private String nome;
    private int id;
    private static int cont = 0;

    public Proprietario(String nome) {
        this.nome = nome;
        this.imoveisPossuidos = new ArrayList<>();
        this.cont++;
        this.id = this.cont;
    }

    public int getId() {
        return id;
    }

}

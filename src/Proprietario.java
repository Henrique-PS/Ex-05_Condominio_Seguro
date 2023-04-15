import java.util.List;

public class Proprietario {
    protected List<Imovel> imoveisPossuidos;
    private int id;

    public Proprietario(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}

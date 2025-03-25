package miau.auau.amigosdequatropatas.db.entidades;

public class TipoMedicamento {

    private int codTipoMedicamento;
    private String nome;

    // Construtores
    public TipoMedicamento(int cod, String nome) {
        this.codTipoMedicamento = cod;
        this.nome = nome;
    }
    public TipoMedicamento() {
        this(0,"");
    }

    // Gets e Sets
    public int getCod() {
        return codTipoMedicamento;
    }

    public void setCod(int cod) {
        this.codTipoMedicamento = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}

package miau.auau.amigosdequatropatas.entities;

import miau.auau.amigosdequatropatas.dao.TipoLancamentoDAO;
import miau.auau.amigosdequatropatas.util.Conexao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TipoLancamento {
    @Autowired
    private TipoLancamentoDAO tipoLancamentoDAL;

    private int cod;
    private String descricao;

    // Construtores
    public TipoLancamento(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public TipoLancamento() {
        this(0, "");
    }

    // Gets e Sets
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    // CRUD ------------------------------------------------------------------
    public boolean incluir(Conexao conexao) {
        return tipoLancamentoDAL.gravar(this, conexao); // grava no banco
    }

    public boolean excluir(Conexao conexao) {
        return tipoLancamentoDAL.apagar(this, conexao);
    }

    public TipoLancamento consultarID(int id, Conexao conexao) {
        return tipoLancamentoDAL.get(id, conexao);
    }

    public List<TipoLancamento> consultar(String filtro, Conexao conexao) {
        return tipoLancamentoDAL.get(filtro, conexao);
    }

    public boolean alterar(Conexao conexao) {
        return tipoLancamentoDAL.alterar(this, conexao);
    }
}

package miau.auau.amigosdequatropatas.db.dals;

import miau.auau.amigosdequatropatas.entidades.TipoMedicamento;
import miau.auau.amigosdequatropatas.util.IDAL;
import miau.auau.amigosdequatropatas.util.SingletonDB;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@Component
public class TipoMedicamentoDAL implements IDAL<TipoMedicamento> {

    @Override
    public boolean gravar(TipoMedicamento entidade) {
        String sql = """
                INSERT INTO tipo_medicamento (tpm_nome)
                VALUES ('#1')
                """;
        sql = sql.replace("#1", entidade.getNome());
        return SingletonDB.getConexao().manipular(sql);
    }

    @Override
    public boolean alterar(TipoMedicamento entidade) {
        String sql = """
                UPDATE tipo_medicamento
                SET tpm_nome = '#1'
                WHERE tpm_id = #2
                """;
        sql = sql.replace("#1", entidade.getNome())
                .replace("#2", "" + entidade.getCod());
        return SingletonDB.getConexao().manipular(sql);
    }

    @Override
    public boolean apagar(TipoMedicamento entidade) {
        String sql = "DELETE FROM tipo_medicamento WHERE tpm_id = " + entidade.getCod();
        return SingletonDB.getConexao().manipular(sql);
    }

    @Override
    public TipoMedicamento get(int id) {
        TipoMedicamento tipoMedicamento = null;
        String sql = "SELECT * FROM tipo_medicamento WHERE tpm_id = " + id;
        ResultSet resultSet = SingletonDB.getConexao().consultar(sql);
        try {
            if (resultSet.next()) {
                tipoMedicamento = new TipoMedicamento(
                        id,
                        resultSet.getString("tpm_nome")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tipoMedicamento;
    }

    @Override
    public List<TipoMedicamento> get(String filtro) {
        List<TipoMedicamento> lista = new ArrayList<>();
        String sql = "SELECT * FROM tipo_medicamento";
        if (!filtro.isEmpty() && !filtro.equals(" ")) {
            filtro = "'" + filtro + "'";
            sql += " WHERE tpm_nome = " + filtro;
        }
        sql += " ORDER BY tpm_nome";
        System.out.println("SQL gerado: " + sql);
        ResultSet resultSet = SingletonDB.getConexao().consultar(sql);
        try {
            while (resultSet.next()) {
                lista.add(new TipoMedicamento(
                        resultSet.getInt("tpm_id"),
                        resultSet.getString("tpm_nome")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }
}

package br.astbit.smart.model.compra;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "compra")
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String descricao;
    String local;
    public Compra() {
    }
    public Compra(DadosCadastroCompra dados) {
        this.descricao = dados.descricao();
        this.local = dados.local();
    }
    public Compra(Long id, String descricao, String local) {
        this.id = id;
        this.descricao = descricao;
        this.local = local;
    }
    public void atualizaCompra(DadosAtualizaCompra dados) {
        this.descricao = dados.descricao();
        this.local = dados.local();
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public String getLocal() {
        return local;
    }
    public void setLocal(String local) {
        this.local = local;
    }
    @Override
    public String toString() {
        return "Compra [id=" + id + ", descricao=" + descricao + ", local=" + local + "]";
    }
}

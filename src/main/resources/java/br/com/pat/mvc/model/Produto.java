package br.com.pat.mvc.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.transaction.Transactional;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int idProduto;
	private String nomeProduto;
	private String tipoProduto;
	private String marcaProduto;
	private Integer valorProduto;
	private Date dataValidadeProduto;
	private List<ConsumoProduto> consumo;
	private boolean consumido;

	@Id
	@GenericGenerator(name = "generator", strategy = "increment")
	@Column(name = "id_produto", nullable = false)
	@GeneratedValue(generator = "generator")
	public int getIdProduto() {
		return idProduto;
	}

	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}

	@Column(name = "nome_produto")
	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	@Column(name = "tipo_produto")
	public String getTipoProduto() {
		return tipoProduto;
	}

	public void setTipoProduto(String tipoProduto) {
		this.tipoProduto = tipoProduto;
	}

	@Column(name = "marca_produto")
	public String getMarcaProduto() {
		return marcaProduto;
	}

	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}

	@Column(name = "valor_produto")
	public Integer getValorProduto() {
		return valorProduto;
	}

	public void setValorProduto(Integer valorProduto) {
		this.valorProduto = valorProduto;
	}

	@Temporal(value = TemporalType.DATE)
	@Column(name = "dataValidade_produto")
	public Date getDataValidadeProduto() {
		return dataValidadeProduto;
	}

	public void setDataValidadeProduto(Date dataValidadeProduto) {
		this.dataValidadeProduto = dataValidadeProduto;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
	public List<ConsumoProduto> getConsumo() {
		return consumo;
	}

	public void setConsumo(List<ConsumoProduto> consumo) {
		this.consumo = consumo;
	}

	@Column(name = "consumido")
	public boolean isConsumido() {
		return consumido;
	}

	public void setConsumido(boolean consumido) {
		this.consumido = consumido;
	}

	@Override
	@Transactional
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idProduto;
		return result;
	}

	@Override
	@Transactional
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (idProduto != other.idProduto)
			return false;
		return true;
	}

}

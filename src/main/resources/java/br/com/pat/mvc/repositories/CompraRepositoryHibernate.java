package br.com.pat.mvc.repositories;

import org.springframework.stereotype.Repository;

import br.com.pat.mvc.model.Compra;

@Repository
public class CompraRepositoryHibernate extends RepositoryBase implements CompraRepository {

	@Override
	public Compra getCompra() {
		return getHibernateTemplate().get(Compra.class, null);
	}

	@Override
	public Compra salva(Compra compra) {
		return (Compra) getHibernateTemplate().save(compra);
	}

}

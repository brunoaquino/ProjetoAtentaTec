package br.com.pat.mvc.repositories;

import br.com.pat.mvc.model.Mercado;

public interface MercadoRepository {

	public Mercado getMercado();

	public void salva(Mercado mercado);

}

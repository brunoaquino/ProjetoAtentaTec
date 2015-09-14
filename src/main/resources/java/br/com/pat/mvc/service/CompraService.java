package br.com.pat.mvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.pat.mvc.model.Compra;
import br.com.pat.mvc.repositories.CompraRepository;
import br.com.pat.mvc.repositories.ProdutoRepository;
import br.com.pat.mvc.util.UtilMensagens;

@Service
public class CompraService {

	@Resource(name = "compraRepository")
	public CompraRepository compraRepository;

	@Autowired
	public ProdutoRepository produtoRepository;

	public void salva(Compra compra) {
		validaCompra(compra);
		compraRepository.salva(compra);
	}

	public List<Compra> getDataCompra(Compra compra) {
		return compraRepository.getDataCompra(compra);
	}

	private void validaCompra(Compra compra) {
		if (compra.getDataCompra() == null) {
			UtilMensagens.setMsgError("Data da Compra � Obrigatorio");
		}

	}
}

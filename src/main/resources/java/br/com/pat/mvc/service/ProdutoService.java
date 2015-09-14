package br.com.pat.mvc.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import br.com.pat.mvc.model.Produto;
import br.com.pat.mvc.repositories.ProdutoRepository;
import br.com.pat.mvc.util.UtilMensagens;

@Service
public class ProdutoService {

	@Resource(name = "produtoRepository")
	public ProdutoRepository produtoRepository;

	public void salva(Produto produto) {
		validaProduto(produto);
		produtoRepository.salva(produto);
	}

	public List<Produto> getProdutos(Produto produto) {
		return produtoRepository.getProdutos(produto);
	}

	private void validaProduto(Produto produto) {
		if (produto.getNomeProduto() == "") {
			UtilMensagens.setMsgError("Nome do produto � Obrigatorio");
		}
		if (produto.getMarcaProduto() == "") {
			UtilMensagens.setMsgError("Marca do produto � Obrigatorio");
		}
		if (produto.getTipoProduto() == "") {
			UtilMensagens.setMsgError("Tipo do produto � Obrigatorio");
		}
		if (produto.getValorProduto() == null) {
			UtilMensagens.setMsgError("Valor do produto � Obrigatorio");
		}
		if (produto.getQuantidadeProduto() == null) {
			UtilMensagens.setMsgError("Quantidade do produto � Obrigatorio");
		}

	}
}

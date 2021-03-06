package br.com.pat.mvc.filtro;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import br.com.pat.mvc.model.Usuario;

@Component
public class FiltroRequisicao implements Filter {

	private static final String USUARIO_LOGADO = "UsuarioLogado";

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) servletResponse;

		String urlDeAcesso = req.getRequestURI();
		
		if (urlDeAcesso.contains("/resources/") || urlDeAcesso.contains("javax.faces.resource")) {
			chain.doFilter(request, resp);
			return;
		}
		if (!urlDeAcesso.contains("login.xhtml") && !isUsuarioLogado(req)) {
			resp.sendRedirect("login.xhtml");
			return;
		}

		chain.doFilter(request, resp);
	}

	private boolean isUsuarioLogado(HttpServletRequest request) {
		HttpSession session = request.getSession();

		Usuario usuario = (Usuario) session.getAttribute(USUARIO_LOGADO);

		if (usuario == null) {
			return false;
		}

		return true;
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
	}

}

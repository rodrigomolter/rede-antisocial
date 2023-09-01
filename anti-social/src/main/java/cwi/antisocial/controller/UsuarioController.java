package cwi.antisocial.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import cwi.antisocial.dao.UsuarioAmigoDao;
import cwi.antisocial.dao.UsuarioDao;
import cwi.antisocial.model.Usuario;
import cwi.antisocial.model.UsuarioAmigo;

@Controller
public class UsuarioController {

	@Inject
	private UsuarioDao usuarioDao;

	@Inject
	private UsuarioAmigoDao usuarioAmigoDao;

	@RequestMapping(value = "/cadastra/usuario", method = RequestMethod.POST)
	public String cadastrarUsuario(@RequestBody Usuario usuario,
			HttpSession session, Model model) {
		usuario = usuarioDao.persistirUsuario(usuario);
		return "redirect:/login";
	}

	@ResponseBody
	@RequestMapping(value = "/adiciona/amigo", method = RequestMethod.POST)
	public UsuarioAmigo adicionarAmigoEmUsuario(@RequestBody Usuario amigo,
			Model model, HttpSession session) {
		List<Usuario> usuarios = usuarioDao.buscarUsuarioPorNome(amigo
				.getNome());
		if (session.getAttribute("usuarioLogado") == null) {
			return null;
		} else if (usuarios.isEmpty()) {
			return new UsuarioAmigo();
		} else {
			Usuario usuario = (Usuario) session.getAttribute("usuarioLogado");
			amigo = usuarios.get(0);
			UsuarioAmigo usuarioAmigo = usuarioAmigoDao.adicionaAmigoAoUsuario(
					usuario, amigo);
			return usuarioAmigo;
		}
	}
}

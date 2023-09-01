package cwi.antisocial.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cwi.antisocial.dao.UsuarioDao;
import cwi.antisocial.model.Usuario;

@Controller
public class SessionController {

	@Inject
	UsuarioDao usuarioDao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String abreLogin(Model model) {
		return "login.html";
	}

	@RequestMapping(value = "/autentica", method = RequestMethod.POST)
	public String autenticarUsuario(Usuario usuario, HttpSession session,
			Model model) {
		Usuario conferido = usuarioDao.autenticarUsuarioNoBanco(
				usuario.getEmail(), usuario.getSenha());
		if (conferido != null
				&& conferido.getSenha().equals(usuario.getSenha())
				&& conferido.getEmail().equals(usuario.getEmail())) {
			session.setAttribute("usuarioLogado", conferido);
			return "redirect:/home";
		} else {
			model.addAttribute("message", "Usuário ou senha inválidos");
			return "login.html";
		}
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String deslogarUsuarioEncerrarSessao(HttpSession session) {
		session.removeAttribute("usuarioLogado");
		return "redirect:/login";
	}

}

package cwi.antisocial.controller;

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cwi.antisocial.model.Usuario;

@Controller
public class HomeController {

	@RequestMapping(value = "/home.html", method = RequestMethod.GET)
	public String abreIndex(Model model, HttpSession session) {
		if (session.getAttribute("usuarioLogado") == null) {
			return "redirect:/login";
		}
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		model.addAttribute("mustacheusername", usuarioLogado.getNome());
		model.addAttribute("userlocation", usuarioLogado.getLocalizacao());
		model.addAttribute("userdate", usuarioLogado.getDataNascimento());
		model.addAttribute("avatar", usuarioLogado.getAvatar());
		System.out.println("AVATAAAAAR " + usuarioLogado.getAvatar());
		return "redirect:/home";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String abreHome(Model model, HttpSession session) {
		if (session.getAttribute("usuarioLogado") == null) {
			return "redirect:/login";
		}
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		model.addAttribute("mustacheusername", usuarioLogado.getNome());
		model.addAttribute("userlocation", usuarioLogado.getLocalizacao());
		model.addAttribute("userdate", usuarioLogado.getDataNascimento());
		model.addAttribute("avatar", usuarioLogado.getAvatar());
		System.out.println("AVATAAAAAR " + usuarioLogado.getAvatar());
		return "home.html";
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String abreHomeHtml(Model model, HttpSession session) {
		if (session.getAttribute("usuarioLogado") == null) {
			return "redirect:/login";
		}
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		model.addAttribute("mustacheusername", usuarioLogado.getNome());
		model.addAttribute("userlocation", usuarioLogado.getLocalizacao());
		model.addAttribute("userdate", usuarioLogado.getDataNascimento());
		model.addAttribute("avatar", usuarioLogado.getAvatar());
		System.out.println("AVATAAAAAR " + usuarioLogado.getAvatar());
		return "redirect:/home";
	}

}

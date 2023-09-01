package cwi.antisocial.controller;

import java.text.ParseException;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cwi.antisocial.model.Usuario;

@Controller
public class AboutController {
	
	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String abrePesquisa(Model model, HttpSession session){
		if (session.getAttribute("usuarioLogado") == null) {
			return "redirect:/login";
		}
		Usuario usuarioLogado = (Usuario) session.getAttribute("usuarioLogado");
		model.addAttribute("mustacheusername", usuarioLogado.getNome());
		model.addAttribute("userlocation", usuarioLogado.getLocalizacao());
		try {
			model.addAttribute("userdate", usuarioLogado.getIdade());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "about.html";
	}
	
	

}

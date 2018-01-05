package br.com.tonsoft.sistemacerveja.controller;

import br.com.tonsoft.sistemacerveja.model.Cerveja;
import br.com.tonsoft.sistemacerveja.model.Origem;
import br.com.tonsoft.sistemacerveja.model.Sabor;
import br.com.tonsoft.sistemacerveja.repository.CervejaRepository;
import br.com.tonsoft.sistemacerveja.repository.EstiloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class CervejasController {

    @Autowired
    private CervejaRepository cervejaRepository;
    @Autowired
    private EstiloRepository estiloRepository;

    @RequestMapping("/cervejas/novo")
    public ModelAndView novo(Cerveja cerveja) {
        ModelAndView model = new ModelAndView("cerveja/CadastroCerveja");
        model.addObject("sabores", Sabor.values());

        model.addObject("origens", Origem.values());

        model.addObject("estilos", estiloRepository.findAll());

        return model;
    }

    @RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
    public ModelAndView cadastrar(@Valid Cerveja cerveja, BindingResult result, Model model, RedirectAttributes attributes) {
        if (result.hasErrors()) {
            return novo(cerveja);
        }

        //cervejaRepository.save(cerveja);

        attributes.addFlashAttribute("mensagem", "Cerveja salva com sucesso!");
        return new ModelAndView("redirect:/cervejas/novo");
    }


}

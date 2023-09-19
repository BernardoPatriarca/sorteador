package com.sorteio.sorteador.Controller;

import com.sorteio.sorteador.Service.S_sorteio;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class C_sorteio {
    @GetMapping("/")
    public String getSorteio() {
        return "sorteio";
    }

    @PostMapping("/sorteio")
    public String postSorteio(@RequestParam("minimo") int minimo,
                              @RequestParam("maximo") int maximo,
                              @RequestParam("quantidade") int quantidade,
                              @RequestParam("crescente") boolean crescente,
                              @RequestParam("repetir") boolean repetir,
                              @NotNull Model model) {
        int[] vect = S_sorteio.sortear(minimo, maximo, quantidade, repetir, crescente);

        model.addAttribute("minimo", minimo);
        model.addAttribute("maximo", maximo);
        model.addAttribute("quantidade", quantidade);
        model.addAttribute("crescente", crescente);
        model.addAttribute("repetir", repetir);
        model.addAttribute("sorteio", vect);

        return "resultado";
    }
}
package br.com.alura.linguagens.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LinguagemController {

//    private List<Linguagem> linguagens =
//            List.of(
//                    new Linguagem("Java",
//                                "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/java/java_512x512.png",
//                                1),
//                    new Linguagem("PHP",
//                                  "https://raw.githubusercontent.com/abrahamcalf/programming-languages-logos/master/src/php/php_512x512.png",
//                                  2)
//            );

//    @GetMapping(value="/linguagem-preferida")
//    public String processaLinguagemPreferida() {
//        return "Oi, Java!";
//    }

    @Autowired
    private LinguagemRepository repositorio;

    @GetMapping("/linguagens")
    public List<Linguagem> obterLinguagens() {
        List<Linguagem> linguagens = repositorio.findAll(Sort.by(Sort.Direction.ASC, "ranking"));
        return linguagens;
    }

    @PostMapping("/linguagens")
    public Linguagem cadastrarLinguagem(@RequestBody Linguagem linguagem) {
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return linguagemSalva;
    }

}

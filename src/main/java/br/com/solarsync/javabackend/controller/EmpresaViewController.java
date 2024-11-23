package br.com.solarsync.javabackend.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.solarsync.javabackend.dto.EmpresaRequestDTO;
import br.com.solarsync.javabackend.dto.EmpresaResponseDTO;
import br.com.solarsync.javabackend.model.Regiao;
import br.com.solarsync.javabackend.model.TipoPropriedade;
import br.com.solarsync.javabackend.service.EmpresaService;

@Controller
@RequestMapping("/empresas")
public class EmpresaViewController {

    private final EmpresaService empresaService;

    public EmpresaViewController(EmpresaService empresaService) {
        this.empresaService = empresaService;
    }

    @GetMapping
    public String listarTodasEmpresas(Model model) {
        List<EmpresaResponseDTO> empresas = empresaService.listarTodasEmpresas();
        model.addAttribute("empresas", empresas);
        return "empresas/listar";
    }

    @GetMapping("/{id}")
    public String visualizarEmpresa(@PathVariable Long id, Model model) {
        EmpresaResponseDTO empresa = empresaService.listarEmpresaPorId(id);
        model.addAttribute("empresa", empresa);
        return "empresas/visualizar";
    }

    @GetMapping("/novo")
    public String novaEmpresa(Model model) {
        model.addAttribute("empresa", new EmpresaRequestDTO("", "", "", null, "", "", null, null));
        model.addAttribute("regioes", Regiao.values());  
        model.addAttribute("tiposPropriedade", TipoPropriedade.values()); 
        return "empresas/novo"; 
    }

    @PostMapping("/novo")
    public String criarEmpresa(@ModelAttribute EmpresaRequestDTO empresaRequestDTO) {
        empresaService.criarEmpresa(empresaRequestDTO);
        return "redirect:/empresas";
    }

    @GetMapping("/editar/{id}")
    public String editarEmpresa(@PathVariable Long id, Model model) {
        EmpresaResponseDTO empresa = empresaService.listarEmpresaPorId(id);
        model.addAttribute("empresa", empresa);
        model.addAttribute("regioes", Regiao.values()); 
        model.addAttribute("tiposPropriedade", TipoPropriedade.values());  
        return "empresas/editar";
    }

    @PostMapping("/editar/{id}")
    public String atualizarEmpresa(@PathVariable Long id, @ModelAttribute EmpresaRequestDTO empresaRequestDTO) {
        empresaService.atualizarEmpresa(id, empresaRequestDTO);
        return "redirect:/empresas";
    }

    @GetMapping("/deletar/{id}")
    public String deletarEmpresa(@PathVariable Long id) {
        empresaService.deletarEmpresa(id);
        return "redirect:/empresas";
    }
}

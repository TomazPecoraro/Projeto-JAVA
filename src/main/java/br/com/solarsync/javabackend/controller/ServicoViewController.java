package br.com.solarsync.javabackend.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.solarsync.javabackend.dto.ClienteResponseDTO;
import br.com.solarsync.javabackend.dto.EmpresaResponseDTO;
import br.com.solarsync.javabackend.dto.ServicoRequestDTO;
import br.com.solarsync.javabackend.dto.ServicoResponseDTO;
import br.com.solarsync.javabackend.model.TipoServico;
import br.com.solarsync.javabackend.service.ClienteService;
import br.com.solarsync.javabackend.service.EmpresaService;
import br.com.solarsync.javabackend.service.ServicoService;

@Controller
@RequestMapping("/servicos")
public class ServicoViewController {

    private final ServicoService servicoService;
    private final ClienteService clienteService;
    private final EmpresaService empresaService;


    public ServicoViewController(ServicoService servicoService, ClienteService clienteService, EmpresaService empresaService) {
        this.servicoService = servicoService;
        this.clienteService = clienteService;
        this.empresaService = empresaService;

    }

    @GetMapping
    public String listarTodosempresas(Model model) {
        List<ServicoResponseDTO> servicos = servicoService.listarTodosServicos();
        model.addAttribute("servicos", servicos);
        return "servicos/listar"; 
    }

    @GetMapping("/visualizar/{id}")
    public String visualizarServico(@PathVariable Long id, Model model) {
        ServicoResponseDTO servico = servicoService.listarServicoPorId(id);
        ClienteResponseDTO cliente = clienteService.listarClientePorId(servico.idCliente());
        EmpresaResponseDTO empresa = empresaService.listarEmpresaPorId(servico.idEmpresa());
        model.addAttribute("servico", servico);
        model.addAttribute("cliente", cliente);
        model.addAttribute("empresa", empresa);
        return "servicos/visualizar"; 
    }

    @GetMapping("/novo")
    public String novoServico(Model model) {
        model.addAttribute("servicoRequestDTO", new ServicoRequestDTO("", "", null, null, null));
        model.addAttribute("tiposServico", TipoServico.values()); 
        return "servicos/novo"; 
    }

    @PostMapping("/novo")
    public String criarServico(@ModelAttribute ServicoRequestDTO servicoRequestDTO) {
        servicoService.criarServico(servicoRequestDTO);
        return "redirect:/servicos";
    }

    @GetMapping("/editar/{id}")
    public String editarServico(@PathVariable Long id, Model model) {
        ServicoResponseDTO servico = servicoService.listarServicoPorId(id);
        model.addAttribute("servico", servico);
        model.addAttribute("tiposServico", TipoServico.values());
        return "servicos/editar"; 
    }

    @PostMapping("/editar/{id}")
    public String atualizarServico(@PathVariable Long id, @ModelAttribute ServicoRequestDTO servicoRequestDTO) {
        servicoService.atualizarServico(id, servicoRequestDTO);
        return "redirect:/servicos";
    }

    @GetMapping("/deletar/{id}")
    public String deletarServico(@PathVariable Long id) {
        servicoService.deletarServico(id);
        return "redirect:/servicos";
    }
}

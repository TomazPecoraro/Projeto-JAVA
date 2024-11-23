package br.com.solarsync.javabackend.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.solarsync.javabackend.dto.ClienteRequestDTO;
import br.com.solarsync.javabackend.dto.ClienteResponseDTO;
import br.com.solarsync.javabackend.model.Regiao;
import br.com.solarsync.javabackend.model.TipoPropriedade;
import br.com.solarsync.javabackend.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteViewController {

  private final ClienteService clienteService;

  public ClienteViewController(ClienteService clienteService) {
    this.clienteService = clienteService;
  }

  @GetMapping
  public String listarTodosClientes(Model model) {
    List<ClienteResponseDTO> clientes = clienteService.listarTodosClientes();
    model.addAttribute("clientes", clientes);
    return "clientes/listar";
  }

  @GetMapping("/visualizar/{id}")
  public String visualizarCliente(@PathVariable Long id, Model model) {
    ClienteResponseDTO cliente = clienteService.listarClientePorId(id);
    model.addAttribute("cliente", cliente);
    return "clientes/visualizar";
  }

  @GetMapping("/novo")
  public String novoCliente(Model model) {
    model.addAttribute("clienteRequestDTO", new ClienteRequestDTO("", "",null, "",  "", null, null));
    model.addAttribute("regioes", Regiao.values());  
    model.addAttribute("tiposPropriedade", TipoPropriedade.values()); 
    return "clientes/novo";
  }

  @PostMapping("/novo")
  public String criarCliente(@ModelAttribute ClienteRequestDTO clienteRequestDTO) {
    clienteService.criarCliente(clienteRequestDTO);
    return "redirect:/clientes";
  }

  @GetMapping("/editar/{id}")
  public String editarCliente(@PathVariable Long id, Model model) {
    ClienteResponseDTO cliente = clienteService.listarClientePorId(id);
    if (cliente == null) {
      System.out.println("Cliente não encontrado para o ID: " + id);
    } else {
      System.out.println("Cliente carregado para edição: " + cliente.nome());
    }
    model.addAttribute("cliente", cliente);
    model.addAttribute("regioes", Regiao.values()); 
    model.addAttribute("tiposPropriedade", TipoPropriedade.values());  
    return "clientes/editar";
  }

  @PostMapping("/editar/{id}")
  public String atualizarCliente(@PathVariable Long id, @ModelAttribute ClienteRequestDTO clienteRequestDTO) {
    clienteService.atualizarCliente(id, clienteRequestDTO);
    return "redirect:/clientes";
  }

  @GetMapping("/deletar/{id}")
  public String deletarCliente(@PathVariable Long id) {
    clienteService.deletarCliente(id);
    return "redirect:/clientes";
  }
}

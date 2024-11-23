package br.com.solarsync.javabackend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.solarsync.javabackend.dto.ClienteRequestDTO;
import br.com.solarsync.javabackend.dto.ClienteResponseDTO;
import br.com.solarsync.javabackend.service.ClienteService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

  private final ClienteService clienteService;

  public ClienteController(ClienteService clienteService) {
    this.clienteService = clienteService;
  }

  @PostMapping
  public ResponseEntity<ClienteResponseDTO> criarCliente(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
    ClienteResponseDTO clienteResponseDTO = clienteService.criarCliente(clienteRequestDTO);
    return new ResponseEntity<>(clienteResponseDTO, HttpStatus.CREATED);
  }

  @GetMapping
  public ResponseEntity<List<ClienteResponseDTO>> listarTodosClientes() {
    List<ClienteResponseDTO> clientes = clienteService.listarTodosClientes();
    return ResponseEntity.ok(clientes);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ClienteResponseDTO> listarClientePorId(@PathVariable Long id) {
    ClienteResponseDTO clienteResponseDTO = clienteService.listarClientePorId(id);
    return ResponseEntity.ok(clienteResponseDTO);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ClienteResponseDTO> atualizarCliente(@PathVariable Long id,
      @Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
    ClienteResponseDTO clienteAtualizado = clienteService.atualizarCliente(id,
        clienteRequestDTO);
    return ResponseEntity.ok(clienteAtualizado);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deletarCliente(@PathVariable Long id) {
    clienteService.deletarCliente(id);
    return ResponseEntity.noContent().build();
  }
}

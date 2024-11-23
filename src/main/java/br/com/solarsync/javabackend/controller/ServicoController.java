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

import br.com.solarsync.javabackend.dto.ServicoRequestDTO;
import br.com.solarsync.javabackend.dto.ServicoResponseDTO;
import br.com.solarsync.javabackend.service.ServicoService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/servicos")
public class ServicoController {

    private final ServicoService servicoService;

    public ServicoController(ServicoService servicoService) {
        this.servicoService = servicoService;
    }

    @PostMapping
    public ResponseEntity<ServicoResponseDTO> criarServico(@Valid @RequestBody ServicoRequestDTO servicoRequestDTO) {
        ServicoResponseDTO servicoResponseDTO = servicoService.criarServico(servicoRequestDTO);
        return new ResponseEntity<>(servicoResponseDTO, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ServicoResponseDTO>> listarTodosServicos() {
        List<ServicoResponseDTO> servicos = servicoService.listarTodosServicos();
        return ResponseEntity.ok(servicos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> listarServicoPorId(@PathVariable Long id) {
        ServicoResponseDTO servicoResponseDTO = servicoService.listarServicoPorId(id);
        return ResponseEntity.ok(servicoResponseDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicoResponseDTO> atualizarServico(@PathVariable Long id,
                                                                @Valid @RequestBody ServicoRequestDTO servicoRequestDTO) {
        ServicoResponseDTO servicoAtualizado = servicoService.atualizarServico(id, servicoRequestDTO);
        return ResponseEntity.ok(servicoAtualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarServico(@PathVariable Long id) {
        servicoService.deletarServico(id);
        return ResponseEntity.noContent().build();
    }
}

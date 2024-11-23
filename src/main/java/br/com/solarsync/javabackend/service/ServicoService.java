package br.com.solarsync.javabackend.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.solarsync.javabackend.dto.ServicoRequestDTO;
import br.com.solarsync.javabackend.dto.ServicoResponseDTO;
import br.com.solarsync.javabackend.model.Servico;
import br.com.solarsync.javabackend.repository.ServicoRepository;

@Service
public class ServicoService {

  private final ServicoRepository servicoRepository;

  public ServicoService(ServicoRepository servicoRepository) {
    this.servicoRepository = servicoRepository;
  }

  public ServicoResponseDTO criarServico(ServicoRequestDTO servicoRequestDTO) {
    Servico servico = fromDTO(servicoRequestDTO);
    Servico servicoSalvo = servicoRepository.save(servico);
    return toDTO(servicoSalvo);
  }

  public List<ServicoResponseDTO> listarTodosServicos() {
    return servicoRepository.findAll()
        .stream()
        .map(this::toDTO)
        .collect(Collectors.toList());
  }

  public ServicoResponseDTO listarServicoPorId(Long id) {
    Optional<Servico> servicoOpt = servicoRepository.findById(id);
    if (servicoOpt.isPresent()) {
      return toDTO(servicoOpt.get());
    } else {
      throw new RuntimeException("Serviço não encontrado com o ID: " + id);
    }
  }

  public ServicoResponseDTO atualizarServico(Long id, ServicoRequestDTO servicoRequestDTO) {
    Optional<Servico> servicoOpt = servicoRepository.findById(id);
    if (servicoOpt.isPresent()) {
      Servico servico = servicoOpt.get();
      servico.setTituloServico(servicoRequestDTO.tituloServico());
      servico.setDescricaoServico(servicoRequestDTO.descricaoServico());
      servico.setIdCliente(servicoRequestDTO.idCliente());
      servico.setIdEmpresa(servicoRequestDTO.idEmpresa());
      servico.setTipoServico(servicoRequestDTO.tipoServico());

      Servico servicoAtualizado = servicoRepository.save(servico);
      return toDTO(servicoAtualizado);
    } else {
      throw new RuntimeException("Serviço não encontrado com o ID: " + id);
    }
  }

  public void deletarServico(Long id) {
    Optional<Servico> servicoOpt = servicoRepository.findById(id);
    if (servicoOpt.isPresent()) {
      servicoRepository.deleteById(id);
    } else {
      throw new RuntimeException("Serviço não encontrado com o ID: " + id);
    }
  }

  private Servico fromDTO(ServicoRequestDTO dto) {
    Servico servico = new Servico();
    servico.setTituloServico(dto.tituloServico());
    servico.setDescricaoServico(dto.descricaoServico());
    servico.setIdCliente(dto.idCliente());
    servico.setIdEmpresa(dto.idEmpresa());
    servico.setTipoServico(dto.tipoServico());
    return servico;
  }

  private ServicoResponseDTO toDTO(Servico servico) {
    return new ServicoResponseDTO(
        servico.getId(), 
        servico.getTituloServico(), 
        servico.getDescricaoServico(), 
        servico.getIdCliente(), 
        servico.getIdEmpresa(), 
        servico.getTipoServico());
  }
}

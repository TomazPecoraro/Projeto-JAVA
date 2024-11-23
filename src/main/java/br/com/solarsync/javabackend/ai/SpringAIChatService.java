package br.com.solarsync.javabackend.ai;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.solarsync.javabackend.model.Cliente;
import br.com.solarsync.javabackend.model.Empresa;
import br.com.solarsync.javabackend.model.Servico;
import br.com.solarsync.javabackend.repository.ClienteRepository;
import br.com.solarsync.javabackend.repository.EmpresaRepository;
import br.com.solarsync.javabackend.repository.ServicoRepository;

@Service
public class SpringAIChatService {
  private final ChatClient.Builder chatClientBuilder;

  @Autowired
  private final ServicoRepository servicoRepository;

  @Autowired
  private final ClienteRepository clienteRepository;

  @Autowired
  private final EmpresaRepository empresaRepository;

  public SpringAIChatService(ChatClient.Builder chatClientBuilder, ServicoRepository servicoRepository, ClienteRepository clienteRepository, EmpresaRepository empresaRepository) {
    this.chatClientBuilder = chatClientBuilder;
    this.servicoRepository = servicoRepository;
    this.clienteRepository = clienteRepository;
    this.empresaRepository = empresaRepository;
  }

  public String run(String userPrompt) {
    var chatClient = chatClientBuilder.build();
    return chatClient
        .prompt()
        .user(userPrompt)
        .call()
        .content()
        .replace("\n", "");
  }

  public String getServicoDetailsById(Long id) {
    Servico servico = servicoRepository.findById(id).get();
    Cliente cliente = clienteRepository.findById(servico.getIdCliente()).get();
    Empresa empresa = empresaRepository.findById(servico.getIdEmpresa()).get();

    return String.format("Meu projeto SolarSync serve para unir tanto Clientes que desejam contratar empresas que forncem soluções energéticas, quanto empresas que estão buscando clientes para contratarem os seus serviços. Os Clientes deixam claro suas pretenções, o que eles utilizam, quem eles são, qual seu consumo energetico por dia, e as empresas fazem o mesmo. A unificação entre Cliente e Empresa é feita com o Servico. O que eu peço para você é, analisar as entidades Cliente, Empresa e Serviço a seguir, e diga-me o que pensa dessa união, se ela é eficaz. Se o consumo energetico do cliente for maior do que a produção energetica da empresa, ou se as descrições forem contraditorias (exemplo, cliente só pode alugar placas, e a empresa só pode vender), e se as localizações deles for diferente, já de um sinal negativo para essa união. | %s | %s | %s ", cliente.toString(), empresa.toString(), servico.toString());
    
  }
}


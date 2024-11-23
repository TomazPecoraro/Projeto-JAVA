package br.com.solarsync.javabackend.ai;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/springai")
@Tag(name = "Basic - Spring AI")
public class SpringAIChatController {

  private final SpringAIChatService chatService;

  public SpringAIChatController(SpringAIChatService chatService) {
    this.chatService = chatService;
  }

  @SuppressWarnings("rawtypes")
  @GetMapping("/generate/{id}")
  public ResponseEntity<Map> generate(@PathVariable Long id) {
    String servicoDetails = chatService.getServicoDetailsById(id); 
    String analysisResult = chatService.run(servicoDetails);
    return new ResponseEntity<>(Map.of("ollama", analysisResult), HttpStatus.OK);
  }
}

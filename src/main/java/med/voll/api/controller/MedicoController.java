package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.DadosListagemMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired // injeção de dependencias
    private MedicoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados) {//RequestBody indicar que irá receber um json como parametro, o tipo dos dados será pela Record: DadosCadastroMedico
        repository.save(new Medico(dados)); // save meotodo para salvar no banco de dados
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable paginacao) {
        //return repository.findAll(paginacao).stream().map(DadosListagemMedico::new).toList(); // convertendo o findAll para mandar lista apenas com estes parametros: DadosListagemMedico
        return repository.findAll(paginacao).map(DadosListagemMedico::new); // convertendo o findAll para mandar lista apenas com estes parametros: DadosListagemMedico
    }
}

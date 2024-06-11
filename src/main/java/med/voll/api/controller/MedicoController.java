package med.voll.api.controller;

import jakarta.validation.Valid;
import med.voll.api.medico.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public Page<DadosListagemMedico> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) { // Pageable para a Api ter paginação
        //return repository.findAll(paginacao).stream().map(DadosListagemMedico::new).toList(); // convertendo o findAll para mandar lista apenas com estes parametros: DadosListagemMedico
        //return repository.findAll(paginacao).map(DadosListagemMedico::new); // convertendo o findAll para mandar lista apenas com estes parametros: DadosListagemMedico
        return repository.findAllByAtivoTrue(paginacao).map(DadosListagemMedico::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizacaoMedico dados) {
        Medico medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluir(@PathVariable Long id) { // PathVariable: Anotação para indicar que é o parametro recebido acima pela URl
//        repository.deleteById(id); para deletar do banco de dados
        Medico medico = repository.getReferenceById(id);
        medico.excluir();
    }


}

package med.voll.api.controller;

import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.medico.Medico;
import med.voll.api.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired // injeção de dependencias
    private MedicoRepository repository;
    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody DadosCadastroMedico dados) {//RequestBody indicar que irá receber um json como parametro, o tipo dos dados será pela Record: DadosCadastroMedico
        repository.save(new Medico(dados)); // save meotodo para salvar no banco de dados
    }
}

package org.soulcodeacademy.helpr.services;
import org.soulcodeacademy.helpr.domen.Cargo;
import org.soulcodeacademy.helpr.domen.Cliente;
import org.soulcodeacademy.helpr.domen.Funcionario;
import org.soulcodeacademy.helpr.domen.enums.Perfil;
import org.soulcodeacademy.helpr.repositories.CargoRepository;
import org.soulcodeacademy.helpr.repositories.ClienteRepository;
import org.soulcodeacademy.helpr.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
                                                                                //CRIAR ENTIDADES ANONIMAS
// Torna o objeto de PopulateService disponível para toda a aplicação (global)
@Service // indica para o Spring que esta classe será gerenciada por ele
public class PopulateService {
    @Autowired // injetar o objeto direto na classe
    private CargoRepository cargoRepository;
    @Autowired
    private FuncionarioRepository funcionarioRepositoty;

    @Autowired
    private ClienteRepository clienteRepository;

    public void populate() {
        // Integer idCargo, String nome, String descricao, Double salario
        Cargo c1 = new Cargo(null, "Diretor Geral", "Gerencia a empresa", 30000.0);
        Cargo c2 = new Cargo(null, "Diretor de Setor", "Gerencia um setor da empresa", 18000.0);
        Cargo c3 = new Cargo(null, "Técnico geral", "Resolve os chamados urgentes", 12000.0);

        Funcionario f1 = new Funcionario(null,"José silva","Jose@gmail.com","12312312312","123123123",null,c1);
        Funcionario f2 = new Funcionario(null,"Vitor silva","Vitor@gmail.com","45645645645","789789789",null,c2);

       Cliente cc1 = new Cliente(null,"Mateus Pererira","Pererira@gmail.com","11111111122","1233123","12031580");
       Cliente cc2 = new Cliente(null,"Renato Garcia","Garcia@gmail.com","22222222211","789797","12031580");

        // vamos persistir as entidades = salvar no banco
        this.cargoRepository.save(c1); // INSERT INTO
        this.cargoRepository.save(c2);
        this.cargoRepository.save(c3);
        this.funcionarioRepositoty.save(f1);
        this.funcionarioRepositoty.save(f2);
        this.clienteRepository.save(cc1);
        this.clienteRepository.save(cc2);

    }
}

// O objetivo desta classe é inserir no banco, dados fictícios (de teste)
// IOC = Inversion of Control = Inversão de Controle = É ele quem manda nas instâncias
// Container = é o local onde o Spring guarda os objetos anotados
// @Service = indica que a classe é um serviço
// Injeção de Dependências = quando o Spring injeta os objetos na classe